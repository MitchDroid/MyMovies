package com.mjbarrerab.mymovies.ui.content;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mjbarrerab.mymovies.R;
import com.mjbarrerab.mymovies.data.model.movies.Result;
import com.mjbarrerab.mymovies.data.remote.ApiConstants;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by miller.barrera on 28/09/2017.
 */

public class MoviesContentAdapter extends RecyclerView.Adapter<MoviesContentAdapter.MoviesContentViewHolder> {


    private Context mContext;
    private List<Result> mResultList;
    OnItemClickListener mItemClickListener;

    @Inject
    public MoviesContentAdapter(Context mContext) {
        this.mContext = mContext;
        mResultList = new ArrayList<>();
    }

    @Override
    public MoviesContentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        return new MoviesContentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MoviesContentViewHolder holder, int position) {
        Result result = mResultList.get(position);

        holder.txtMovieTitle.setText(result.getTitle());
        if (result.getPosterPath() != null && !result.getPosterPath().isEmpty()) {
            holder.setMoviePoster(result.getPosterPath());
        }
    }


    public void populateMoviesContent(List<Result> results) {
        mResultList = results;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mResultList == null ? 0 : mResultList.size();
    }

    public Result get(int position) {
        return mResultList.get(position);
    }

    public class MoviesContentViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.movie_poster)
        ImageView imgMovie;

        @BindView(R.id.movie_title)
        TextView txtMovieTitle;

        @BindView(R.id.card_view_movie_content)
        CardView mCardViewMovieContent;

        public MoviesContentViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mCardViewMovieContent.setOnClickListener(this);
        }

        public void setMoviePoster(String movie_poster_path) {
            Picasso.with(mContext).load(ApiConstants.BASE_URL_MOVIE_POSTER + movie_poster_path)
                    .placeholder(R.drawable.movie_placeholder)
                    .into(imgMovie);
        }

        @Override
        public void onClick(View view) {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(view, getAdapterPosition(), imgMovie);
            }
        }
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position, ImageView imageView);
    }
}
