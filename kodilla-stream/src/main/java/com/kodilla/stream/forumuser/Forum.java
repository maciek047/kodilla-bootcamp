package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Forum {
    private final List<ForumUser> theUserList = new ArrayList<>();
    public Forum(){
        theUserList.add(new ForumUser(1,"user1",'M', LocalDate.of(1992, 6, 30),324));
        theUserList.add(new ForumUser(2,"user2",'F', LocalDate.of(2014, 7, 26),54));
        theUserList.add(new ForumUser(3,"user3",'F', LocalDate.of(1989, 9, 5),2));
        theUserList.add(new ForumUser(4,"user4",'M', LocalDate.of(1997, 2, 16),15));
        theUserList.add(new ForumUser(5,"user5",'M', LocalDate.of(2003, 11, 9),0));
    }

    public List<ForumUser> getUserList(){
        return new ArrayList<>(theUserList);
    }
}
