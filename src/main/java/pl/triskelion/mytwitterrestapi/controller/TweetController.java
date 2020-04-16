package pl.triskelion.mytwitterrestapi.controller;

import org.springframework.web.bind.annotation.*;
import pl.triskelion.mytwitterrestapi.domain.Tweet;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping("/api/tweets")
public class TweetController {

    private Collection<Tweet> tweets = new ArrayList<>();

    @GetMapping
    public Iterable<Tweet> getTweets() {
        return tweets;
    }

    @PostMapping
    public void addTweet(@RequestBody Tweet tweet) {
        tweets.add(tweet);
    }
}
