package com.kodilla.testing.forum.statistics;

public class ForumStatistics {
    private int userCount;
    private int postsCount;
    private int commentsCount;
    private double avgPostsPerUser;
    private double avgCommentsPerUser;
    private double avgCommentsPerPost;

    public void calculateAdvStatistics(Statistics statistics) {
        this.userCount = statistics.usersNames().size();
        this.postsCount = statistics.postsCount();
        this.commentsCount = statistics.commentsCount();

        if (this.userCount != 0) {
            this.avgPostsPerUser = (double) this.postsCount / (double) this.userCount;
            this.avgCommentsPerUser = (double) this.commentsCount / (double) this.userCount;
        } else {
            this.avgPostsPerUser = 0;
            this.avgCommentsPerUser = 0;
        }

        if (this.postsCount != 0) {
            this.avgCommentsPerPost = (double) this.commentsCount / (double) this.postsCount;
        } else {
            this.avgCommentsPerPost = 0;
        }
    }

    public void showStatistics(){
        System.out.println("Number of users: " + this.userCount);
        System.out.println("Number of forum posts: " + this.postsCount);
        System.out.println("Number of comments: " + this.commentsCount);
        System.out.println("Average number of posts per user: " + this.avgPostsPerUser);
        System.out.println("Average number of comments per user: " + this.avgCommentsPerUser);
        System.out.println("Average number of comments per post: " + this.avgCommentsPerPost);
    }

    public int getUserCount() {
        return userCount;
    }

    public int getPostsCount() {
        return postsCount;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public double getAvgPostsPerUser() {
        return avgPostsPerUser;
    }

    public double getAvgCommentsPerUser() {
        return avgCommentsPerUser;
    }

    public double getAvgCommentsPerPost() {
        return avgCommentsPerPost;
    }
}
