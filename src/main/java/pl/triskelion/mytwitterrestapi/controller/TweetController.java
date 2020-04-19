package pl.triskelion.mytwitterrestapi.controller;

import org.springframework.web.bind.annotation.*;
import pl.triskelion.mytwitterrestapi.domain.Tweet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Stream;

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

    @GetMapping(params = "author")
    public Stream<Tweet> findTweetsByAuthor(@RequestParam String author) {
        return tweets.stream().filter(tweet -> author.equals(tweet.getAuthor()));
    }

    @PostMapping
    public void addTweet(@RequestBody Tweet tweet) {
        tweets.add(tweet);
    }

    @DeleteMapping("/{id}")
    public void deleteTweet(@PathVariable long id) {
        tweets.removeIf(tweet -> tweet.getId() == id);
    }

    @PutMapping("/{id}")
    public void replaceTweet(@PathVariable long id, @RequestBody Tweet newTweet) {
        findTweetById(id).ifPresent(tweet -> {
            tweet.setTitle(newTweet.getTitle());
            tweet.setContent(newTweet.getContent());
            tweet.setAuthor(newTweet.getAuthor());
        });
    }

    private Optional<Tweet> findTweetById(long id) {
        return tweets.stream().filter(tweet -> tweet.getId() == id).findAny();
    }
}
