package com.kodilla.testing.forum.statistics;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
public class StatisticsTestSuite {
    @Test
    public void testStatisticsZeroPosts() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        ArrayList<String> namesList = new ArrayList<String>();
        namesList.add("Jason");
        namesList.add("Anna");
        namesList.add("Chris");
        namesList.add("Kate");

        when(statisticsMock.usersNames()).thenReturn(namesList);
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(400);

        ForumStatistics forumStatistics = new ForumStatistics();
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //When
        int userCount = forumStatistics.getUserCount();
        int postsCount = forumStatistics.getPostsCount();
        int commentsCount = forumStatistics.getCommentsCount();
        double avgPostsPerUser = forumStatistics.getAvgPostsPerUser();
        double avgCommentsPerUser = forumStatistics.getAvgCommentsPerUser();
        double avgCommentsPerPost = forumStatistics.getAvgCommentsPerPost();

        //Then
        Assert.assertEquals(4, userCount);
        Assert.assertEquals(0, postsCount);
        Assert.assertEquals(400, commentsCount);
        Assert.assertEquals(avgPostsPerUser,0.0,0.1);
        Assert.assertEquals(avgCommentsPerUser,100.0,0.1);
        Assert.assertEquals(avgCommentsPerPost,0.0,0.1);
    }

    @Test
    public void testStatisticsZeroComments() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        ArrayList<String> namesList = new ArrayList<String>();
        namesList.add("Jason");
        namesList.add("Anna");
        namesList.add("Chris");
        namesList.add("Kate");

        when(statisticsMock.usersNames()).thenReturn(namesList);
        when(statisticsMock.postsCount()).thenReturn(100);
        when(statisticsMock.commentsCount()).thenReturn(0);

        ForumStatistics forumStatistics = new ForumStatistics();
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //When
        int userCount = forumStatistics.getUserCount();
        int postsCount = forumStatistics.getPostsCount();
        int commentsCount = forumStatistics.getCommentsCount();
        double avgPostsPerUser = forumStatistics.getAvgPostsPerUser();
        double avgCommentsPerUser = forumStatistics.getAvgCommentsPerUser();
        double avgCommentsPerPost = forumStatistics.getAvgCommentsPerPost();

        //Then
        Assert.assertEquals(4, userCount);
        Assert.assertEquals(100, postsCount);
        Assert.assertEquals(0, commentsCount);
        Assert.assertEquals(avgPostsPerUser,25.0,0.1);
        Assert.assertEquals(avgCommentsPerUser,0,0.1);
        Assert.assertEquals(avgCommentsPerPost,0,0.1);
    }

    @Test
    public void testStatistics1000Posts() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        ArrayList<String> namesList = new ArrayList<String>();
        namesList.add("Jason");
        namesList.add("Anna");
        namesList.add("Chris");
        namesList.add("Kate");

        when(statisticsMock.usersNames()).thenReturn(namesList);
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(3000);

        ForumStatistics forumStatistics = new ForumStatistics();
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //When
        int userCount = forumStatistics.getUserCount();
        int postsCount = forumStatistics.getPostsCount();
        int commentsCount = forumStatistics.getCommentsCount();
        double avgPostsPerUser = forumStatistics.getAvgPostsPerUser();
        double avgCommentsPerUser = forumStatistics.getAvgCommentsPerUser();
        double avgCommentsPerPost = forumStatistics.getAvgCommentsPerPost();

        //Then
        Assert.assertEquals(4, userCount);
        Assert.assertEquals(1000, postsCount);
        Assert.assertEquals(3000, commentsCount);
        Assert.assertEquals(avgPostsPerUser,250.0,0.1);
        Assert.assertEquals(avgCommentsPerUser,750.0,0.1);
        Assert.assertEquals(avgCommentsPerPost,3.0,0.1);
    }

    @Test
    public void testStatisticsZeroUsers() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        ArrayList<String> namesList = new ArrayList<String>();

        when(statisticsMock.usersNames()).thenReturn(namesList);
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(3000);

        ForumStatistics forumStatistics = new ForumStatistics();
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //When
        int userCount = forumStatistics.getUserCount();
        int postsCount = forumStatistics.getPostsCount();
        int commentsCount = forumStatistics.getCommentsCount();
        double avgPostsPerUser = forumStatistics.getAvgPostsPerUser();
        double avgCommentsPerUser = forumStatistics.getAvgCommentsPerUser();
        double avgCommentsPerPost = forumStatistics.getAvgCommentsPerPost();

        //Then
        Assert.assertEquals(0, userCount);
        Assert.assertEquals(1000, postsCount);
        Assert.assertEquals(3000, commentsCount);
        Assert.assertEquals(avgPostsPerUser,0.0, 0.1);
        Assert.assertEquals(avgCommentsPerUser,0.0,0.1);
        Assert.assertEquals(avgCommentsPerPost,3.0,0.1);
    }

    @Test
    public void testStatistics100Users() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        ArrayList<String> namesList = new ArrayList<String>();
        for(int i=0;i<100;i++){
            namesList.add("name"+i);
        }

        when(statisticsMock.usersNames()).thenReturn(namesList);
        when(statisticsMock.postsCount()).thenReturn(2000);
        when(statisticsMock.commentsCount()).thenReturn(1000);

        ForumStatistics forumStatistics = new ForumStatistics();
        forumStatistics.calculateAdvStatistics(statisticsMock);

        //When
        int userCount = forumStatistics.getUserCount();
        int postsCount = forumStatistics.getPostsCount();
        int commentsCount = forumStatistics.getCommentsCount();
        double avgPostsPerUser = forumStatistics.getAvgPostsPerUser();
        double avgCommentsPerUser = forumStatistics.getAvgCommentsPerUser();
        double avgCommentsPerPost = forumStatistics.getAvgCommentsPerPost();

        //Then
        Assert.assertEquals(100, userCount);
        Assert.assertEquals(2000, postsCount);
        Assert.assertEquals(1000, commentsCount);
        Assert.assertEquals(avgPostsPerUser,20,0.1);
        Assert.assertEquals(avgCommentsPerUser,10,0.1);
        Assert.assertEquals(avgCommentsPerPost,0.5,0.1);
    }
}
