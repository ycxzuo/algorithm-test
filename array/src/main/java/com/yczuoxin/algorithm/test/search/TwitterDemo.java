package com.yczuoxin.algorithm.test.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近 10 条推文。
 *
 * 实现 Twitter 类：
 *
 * Twitter() 初始化简易版推特对象
 * void postTweet(int userId, int tweetId) 根据给定的 tweetId 和 userId 创建一条新推文。每次调用此函数都会使用一个不同的 tweetId 。
 * List<Integer> getNewsFeed(int userId) 检索当前用户新闻推送中最近 10 条推文的 ID 。新闻推送中的每一项都必须是由用户关注的人或者是用户自己发布的推文。推文必须 按照时间顺序由最近到最远排序 。
 * void follow(int followerId, int followeeId) ID 为 followerId 的用户开始关注 ID 为 followeeId 的用户。
 * void unfollow(int followerId, int followeeId) ID 为 followerId 的用户不再关注 ID 为 followeeId 的用户。
 *
 */
public class TwitterDemo {

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 2);
        twitter.postTweet(2,1);
        twitter.follow(1, 2);
        twitter.getNewsFeed(1).forEach(System.out::println);
        System.out.println("-----------------------");
        twitter.unfollow(1, 2);
        twitter.getNewsFeed(1).forEach(System.out::println);
    }

    /**
     * 用户推文
     * 是一个单向链表的数据结构
     */
    static class Tweet {
        // 推文 id
        private int id;
        // 推文序列号
        private int seq;
        // 推文的下一个
        Tweet next;

        public Tweet(int id, int seq) {
            this.id = id;
            this.seq = seq;
        }
    }

    static class Twitter {
        // 用户和推文关系
        private Map<Integer, Tweet> tweetMap;
        // 维护用户 id 和关注的用户列表
        private Map<Integer, Set<Integer>> followingIds;
        // 维护顺序
        private int seq = 0;

        public Twitter() {
            tweetMap = new HashMap<>();
            followingIds = new HashMap<>();
        }

        public void postTweet(int userId, int tweetId) {
            seq++;
            if (tweetMap.containsKey(userId)) {
                Tweet oldTweet = tweetMap.get(userId);
                Tweet newTweet = new Tweet(tweetId, seq);
                newTweet.next = oldTweet;
                tweetMap.put(userId, newTweet);
            } else {
                tweetMap.put(userId, new Tweet(tweetId, seq));
            }
        }

        public List<Integer> getNewsFeed(int userId) {
            // 数字越大越靠前
            PriorityQueue<Tweet> tempHeap = new PriorityQueue<>(((o1, o2) -> o2.seq - o1.seq));
            // 放入自己的推文
            Tweet selfTweet = tweetMap.get(userId);
            if (selfTweet != null) {
                tempHeap.add(selfTweet);
            }
            // 放入关注者的推文
            Set<Integer> followings = followingIds.get(userId);
            if (followings != null && !followings.isEmpty()) {
                for (Integer following : followings) {
                    Tweet tweet = tweetMap.get(following);
                    if (tweet != null) {
                        tempHeap.add(tweet);
                    }
                }
            }
            // 遍历最近的十个推文
            List<Integer> tweets = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                if (tempHeap.isEmpty()) {
                    return tweets;
                }
                Tweet head = tempHeap.poll();
                tweets.add(head.id);
                // 将链表的下一个元素放入优先队列
                if (head.next != null) {
                    tempHeap.add(head.next);
                }
            }
            return tweets;
        }

        public void follow(int followerId, int followeeId) {
            // 关注自己没用
            if (followerId == followeeId) {
                return;
            }
            Set<Integer> follows = followingIds.get(followerId);
            if (follows == null) {
                follows = new HashSet<>();
            } else {
                // 关注的人去重
                if (follows.contains(followeeId)) {
                    return;
                }
            }
            follows.add(followeeId);
            followingIds.put(followerId, follows);
        }

        public void unfollow(int followerId, int followeeId) {
            // 取关自己没用
            if (followerId == followeeId) {
                return;
            }
            Set<Integer> follows = followingIds.get(followerId);
            if (follows == null) {
                return;
            }
            follows.remove(followeeId);
        }
    }


}
