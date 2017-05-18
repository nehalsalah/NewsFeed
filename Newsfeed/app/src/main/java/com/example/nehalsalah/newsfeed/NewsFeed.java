package com.example.nehalsalah.newsfeed;

/**
 * An {@link NewsFeed} object contains information related to News.
 */
public class NewsFeed {

    /**
     * News Title
     */
    private String mNewsTitle;

    /**
     * NewsFeed Type
     */
    private String mType;
    /* newsFeed Name*/
    private String mNews;
    /**
     * Website URL of the news
     */
    private String mUrl;

    /**
     * Constructs a new {@link NewsFeed} object.
     *
     * @param NewsTitle is the News Title
     * @param Type      is the News Type
     * @param News      is the News name
     * @param url       is the website URL to find more details about the News
     */
    public NewsFeed(String News, String Type, String NewsTitle, String url) {
        mType = Type;
        mNewsTitle = NewsTitle;
        mNews = News;
        mUrl = url;
    }

    /**
     * Returns the News Title
     */
    public String getNewsTitle() {
        return mNewsTitle;
    }

    /**
     * Returns the type of News .
     */
    public String getType() {
        return mType;
    }

    /**
     * Returns the name of News .
     */
    public String getNews() {
        return mNews;
    }

    /**
     * Returns the website URL to find more information about the News .
     */
    public String getUrl() {
        return mUrl;
    }


}
