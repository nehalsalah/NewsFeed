package com.example.nehalsalah.newsfeed;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

/**
 * Loads a list of newsFeed by using an AsyncTask to perform the
 * network request to the given URL.
 */
public class NewsFeedLoader extends AsyncTaskLoader<List<NewsFeed>> {

    /**
     * Tag for log messages
     */
    private static final String LOG_TAG = NewsFeedLoader.class.getName();

    /**
     * Query URL
     */
    private String mUrl;

    /**
     * Constructs a new {@link NewsFeedLoader}.
     *
     * @param context of the activity
     * @param url     to load data from
     */
    public NewsFeedLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    /**
     * This is on a background thread.
     */
    @Override
    public List<NewsFeed> loadInBackground() {
        if (mUrl == null) {
            return null;
        }

        // Perform the network request, parse the response, and extract a list of newsFeeds.
        List<NewsFeed> newsFeeds = QueryUtils.fetchEarthquakeData(mUrl);
        return newsFeeds;
    }
}

