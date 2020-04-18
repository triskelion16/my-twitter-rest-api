package pl.triskelion.mytwitterrestapi.controller;

import org.springframework.web.bind.annotation.*;
import pl.triskelion.mytwitterrestapi.domain.Tweet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api/tweets")
public class TweetController {

    private Collection<Tweet> tweets = new ArrayList<>();

    @GetMapping
    public Iterable<Tweet> getTweets() {
        return tweets;
    }

    @GetMapping("/{id}")
    public Optional<Tweet> getTweet(@PathVariable long id) {
        return findTweetById(id);
    }

    @PostMapping
    public void addTweet(@RequestBody Tweet tweet) {
        tweets.add(tweet);
    }

    private Optional<Tweet> findTweetById(long id) {
        return tweets.stream().filter(tweet -> tweet.getId() == id).findAny();
    }
}
