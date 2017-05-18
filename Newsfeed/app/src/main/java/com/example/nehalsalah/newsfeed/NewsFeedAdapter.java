package com.example.nehalsalah.newsfeed;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * An {@link NewsFeedAdapter} knows how to create a list item layout for each news
 * in the data source (a list of {@link NewsFeed} objects).
 * <p>
 * These list item layouts will be provided to an adapter view like ListView
 * to be displayed to the user.
 */
public class NewsFeedAdapter extends ArrayAdapter<NewsFeed> {

    /**
     * Constructs a new {@link NewsFeedAdapter}.
     *
     * @param context   of the app
     * @param newsFeeds is the list of newsFeeds, which is the data source of the adapter
     */
    public NewsFeedAdapter(Context context, List<NewsFeed> newsFeeds) {
        super(context, 0, newsFeeds);
    }

    /**
     * Returns a list item view that displays information about the News  at the given position
     * in the list of News Feed.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.newsfeed_list_item, parent, false);
        }

        // Find the News  at the given position in the list of News feed
        NewsFeed currentNewsFeed = getItem(position);

        // Find the TextView with view ID NewsType
        TextView NewsView = (TextView) listItemView.findViewById(R.id.NewsType);

        int Color = getNewsFeedColor(currentNewsFeed.getNews());
        NewsView.setText(currentNewsFeed.getNews());
        // Get the appropriate background color based on the current news type
        // Set the color on the news view
        NewsView.setBackgroundColor(Color);

        // Find the TextView with view ID news title 1
        TextView NewsTitleView = (TextView) listItemView.findViewById(R.id.newsTitle1);
        // Display the news title of the current news feed in that TextView
        NewsTitleView.setText(currentNewsFeed.getNewsTitle());

        // Find the TextView with view ID news title 2
        TextView typeView = (TextView) listItemView.findViewById(R.id.newsTitle2);
        // Display the news type of the current news feed in that TextView
        typeView.setText(currentNewsFeed.getType());

        // Return the list item view that is now showing the appropriate data
        return listItemView;
    }

    /**
     * Return the color for the News Type.
     *
     * @param NewsType of the NewsFeed
     */
    private int getNewsFeedColor(String NewsType) {
        int NewsTypeColorResourceId;
        switch (NewsType) {
            case "Life and style":
                NewsTypeColorResourceId = R.color.Life;
                break;
            case "US news":
                NewsTypeColorResourceId = R.color.USnews;
                break;
            case "Opinion":
                NewsTypeColorResourceId = R.color.Opinion;
                break;
            case "Higher Education Network":
                NewsTypeColorResourceId = R.color.Education;
                break;
            case "Australia news":
                NewsTypeColorResourceId = R.color.AustraliaNews;
                break;
            case "Politics":
                NewsTypeColorResourceId = R.color.Politics;
                break;
            default:
                NewsTypeColorResourceId = R.color.colorPrimary;
                break;
        }

        return ContextCompat.getColor(getContext(), NewsTypeColorResourceId);
    }


}
