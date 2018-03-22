package com.mjbarrerab.mymovies.ui.content;


import android.content.Intent;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.mjbarrerab.mymovies.R;
import com.mjbarrerab.mymovies.ui.details.MovieDetailsActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static com.mjbarrerab.mymovies.ui.content.RecyclerViewItemCountAssertion.withItemCount;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MoviesContentActivityUITest {



    @Rule
    public ActivityTestRule<MoviesContentActivity> mActivityTestRule =
            new ActivityTestRule<MoviesContentActivity>(MoviesContentActivity.class) {
                @Override
                protected Intent getActivityIntent() {
                    return super.getActivityIntent();
                }
            };


    @Test
    public void moviesContentActivityTest() {
        onView(withId(R.id.recycler_view_movies))
                .perform(RecyclerViewActions.actionOnItemAtPosition(2, click()));

    }

    @Test
    public void moviesContentListTest() {
        onView(withId(R.id.recycler_view_movies))
                .check(withItemCount(20));
    }


}
