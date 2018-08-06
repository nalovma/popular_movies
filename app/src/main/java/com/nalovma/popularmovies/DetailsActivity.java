package com.nalovma.popularmovies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.nalovma.popularmovies.model.Movie;
import com.nalovma.popularmovies.utils.NetworkUtils;
import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {

    ImageView mBackdropIv;
    ImageView mPosterIv;
    TextView mTitleTv;
    TextView mReleaseDateTv;
    TextView mVoteCountTv;
    TextView mOverviewTv;
    RatingBar mVoteAverageRb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        initView();

        Intent intent = getIntent();
        if (intent.hasExtra(getString(R.string.extra_movie_id))) {
            Movie movie = (Movie) getIntent().getParcelableExtra(getString(R.string.extra_movie_id));

            populateUI(movie);
        }
    }

    void initView() {
        mBackdropIv = findViewById(R.id.iv_backdrop);
        mPosterIv = findViewById(R.id.iv_poster);
        mTitleTv = findViewById(R.id.tv_title);
        mReleaseDateTv = findViewById(R.id.tv_release_date);
        mVoteCountTv = findViewById(R.id.tv_vote_count);
        mOverviewTv = findViewById(R.id.tv_overview);
        mVoteAverageRb = findViewById(R.id.rb_vote_average);
    }

    void populateUI(final Movie movie) {
        mTitleTv.setText(movie.getTitle());
        mReleaseDateTv.setText(movie.getReleaseDate());
        mVoteCountTv.setText(Integer.toString(movie.getVoteCount()));
        mOverviewTv.setText(movie.getPlot());
        Picasso.get()
                .load(movie.getPosterPath())
                .placeholder(R.drawable.movie_image)
                .error(R.drawable.movie_image)
                .into(mPosterIv);
        Picasso.get()
                .load(movie.getBackdropPath())
                .placeholder(R.drawable.movie_image)
                .error(R.drawable.movie_image)
                .into(mBackdropIv);
    }
}
