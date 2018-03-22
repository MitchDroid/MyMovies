package com.mjbarrerab.mymovies.ui.details;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.mjbarrerab.mymovies.R;
import com.mjbarrerab.mymovies.data.model.details.MovieDetails;
import com.mjbarrerab.mymovies.data.remote.ApiConstants;
import com.mjbarrerab.mymovies.ui.base.BaseActivity;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import javax.inject.Inject;

import ak.sh.ay.oblique.ObliqueView;
import butterknife.BindView;
import butterknife.ButterKnife;
import rx.subscriptions.CompositeSubscription;
import timber.log.Timber;

public class MovieDetailsActivity extends BaseActivity {

    CompositeSubscription mCompositeSubscription;

    @Inject
    MovieDetailsViewModel mMovieDetailsViewModel;

    @BindView(R.id.toolbarDetails)
    Toolbar mToolBar;

    @BindView(R.id.movie_details_image)
    ObliqueView mMovieDetailPoster;

    @BindView(R.id.txt_movie_details_title)
    TextView mMovieDetailTitle;

    @BindView(R.id.txt_movie_details_overview)
    TextView mMovieOverview;

    @BindView(R.id.txt_genre)
    TextView mMovieGenre;

    @BindView(R.id.txt_language)
    TextView mMovieLanguage;

    @BindView(R.id.txt_companies_title)
    TextView mCompaniesTitle;

    @BindView(R.id.txt_companies)
    TextView mMovieProductionCompanies;

    private static final String SELECTED_MOVIE_ID = "movie_id";
    private int mMovieId;
    private boolean isSync = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        getActivityComponent().inject(this);
        ButterKnife.bind(this);
        initializeViews();
    }

    private void initializeViews() {
        setSupportActionBar(mToolBar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        if (getIntent().getExtras() != null) {
            mMovieId = getIntent().getExtras().getInt(SELECTED_MOVIE_ID);
        }

        attachCompositeSubscription();
        getMovieDetails();

    }

    private void getMovieDetails() {
        mCompositeSubscription.add(mMovieDetailsViewModel.getMovieDetails(String.valueOf(mMovieId))
                .subscribe(movieDetails -> {
                    Timber.d("MovieObject Details ID %s ", movieDetails.getId());
                    setContentToViews(movieDetails);
                    isSync = true;
                }, throwable -> {
                    showError(throwable.getMessage(), ApiConstants.LOW_ERROR);
                    this.finish();
                }));
    }

    public void attachCompositeSubscription() {
        if (mCompositeSubscription == null || mCompositeSubscription.isUnsubscribed()) {
            mCompositeSubscription = new CompositeSubscription();
        }
    }


    public boolean isIdleSyncFinished() {
        return isSync;
    }
    private void setContentToViews(MovieDetails details) {
        getSupportActionBar().setTitle(details.getTitle());

        Picasso.with(this).load(ApiConstants.BASE_URL_MOVIE_POSTER + details.getBackdropPath())
                .placeholder(R.drawable.movie_placeholder)
                .into(mMovieDetailPoster);

        if (details.getGenres() != null && details.getGenres().size() > 0) {
            mMovieGenre.setVisibility(View.VISIBLE);
            mMovieGenre.setText(details.getGenres().get(0).getName() + "," + details.getGenres().get(0).getName());
        } else {
            mMovieGenre.setVisibility(View.GONE);
        }

        mMovieLanguage.setText(details.getOriginalLanguage());
        mMovieDetailTitle.setText(details.getTitle());
        mMovieOverview.setText(details.getOverview());

        String companies = "";
        if (details.getProductionCompanies() != null && details.getProductionCompanies().size() > 0) {
            mMovieProductionCompanies.setVisibility(View.VISIBLE);
            mCompaniesTitle.setVisibility(View.VISIBLE);
            for (int i = 0; i < details.getProductionCompanies().size(); i++) {
                companies = companies + details.getProductionCompanies().get(i).getName() + "\n";

            }
            mMovieProductionCompanies.setText(companies);
        } else {
            mCompaniesTitle.setVisibility(View.GONE);
            mMovieProductionCompanies.setVisibility(View.GONE);
        }

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mCompositeSubscription != null) {
            mCompositeSubscription.clear();
        }
    }
}
