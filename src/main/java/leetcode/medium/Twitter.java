package leetcode.medium;

import java.util.*;

/**
 * @Author long
 * @Date 2020/4/13 11:51
 * @Title 355. 设计推特
 * @Description //TODO
 **/
//执行用时 :37 ms, 在所有 Java 提交中击败了63.47%的用户
public class Twitter {

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(2, 5);
        twitter.postTweet(1, 3);
        twitter.postTweet(1, 101);
        twitter.follow(1, 2);
        twitter.postTweet(2, 13);
        twitter.postTweet(2, 10);
        twitter.postTweet(1, 2);
        twitter.postTweet(2, 94);
        twitter.postTweet(2, 505);
        twitter.postTweet(1, 133);
        twitter.postTweet(1, 22);
        List<Integer> list = twitter.getNewsFeed(1);
        for (int i : list) {
            System.out.print(i + " ");
        }
    }

    private static int timestamp;
    private Map<Integer, User> users;

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        timestamp = 0;
        this.users = new HashMap<>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        User user = users.getOrDefault(userId, new User(userId));
        user.addTweet(new Tweet(tweetId, ++timestamp));
        users.put(userId, user);
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        LinkedList<Integer> news = new LinkedList<>();
        User user = users.get(userId);
        if (user == null) return news;
        PriorityQueue<Tweet> tweets = new PriorityQueue<>(Comparator.comparingInt(o -> o.timestamp));
        tweets.addAll(user.tweets);
        for (User u : user.followers) {
            tweets.addAll(u.tweets);
        }
        while (tweets.size() > 10) {
            tweets.poll();
        }
        while (tweets.size() > 0) {
            news.addFirst(tweets.poll().id);
        }
        return news;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (followeeId == followerId) return;
        User follower = users.get(followerId);
        if (follower == null) {
            follower = new User(followerId);
            users.put(followerId, follower);
        }
        User followee = users.get(followeeId);
        if (followee == null) {
            followee = new User(followeeId);
            users.put(followeeId, followee);
        }
        follower.addFollower(followee);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (followeeId == followerId) return;
        User follower = users.get(followerId);
        User followee = users.get(followeeId);
        if (follower == null || followee == null) return;
        follower.removeFollower(followee);
    }

    class User {
        int id;
        Set<User> followers;
        LinkedList<Tweet> tweets;

        public User(int id) {
            this.id = id;
            this.followers = new HashSet<>();
            this.tweets = new LinkedList<>();
        }

        public void addFollower(User follower) {
            followers.add(follower);
        }

        public void removeFollower(User follower) {
            followers.remove(follower);
        }

        public void addTweet(Tweet tweet) {
            if (tweets.size() == 10) {
                tweets.remove();
            }
            tweets.addLast(tweet);
        }
    }

    class Tweet {
        public int id;
        public int timestamp;

        public Tweet(int id, int timestamp) {
            this.id = id;
            this.timestamp = timestamp;
        }
    }
}
