package pl.triskelion.mytwitterrestapi.util;

import pl.triskelion.mytwitterrestapi.domain.Tweet;

import java.util.ArrayList;

public class ExampleData {

    public static ArrayList<Tweet> initTweets() {
        ArrayList<Tweet> tweets = new ArrayList<>();

        tweets.add(new Tweet(1, "Title 1", "Content 1", "Author 1"));
        tweets.add(new Tweet(2, "Title 2", "Content 2", "Author 2"));
        tweets.add(new Tweet(1, "Title 3", "Content 3", "Author 3"));

        return tweets;
    }
}
