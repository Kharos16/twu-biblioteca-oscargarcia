package com.twu.biblioteca.databases;

import com.twu.biblioteca.domain.User;
import com.twu.biblioteca.domain.UserInfo;

import java.util.ArrayList;
import java.util.List;

public class UserDataBase {
    private List<User> userList;

    public UserDataBase() {
        this.userList = new ArrayList<>();
        this.userList.add(new User("Current_User", "1"));
        this.userList.get(0).setUserInfo(new UserInfo("Oscar Garcia", "eodogarcia16@gmail.com", "+56932788616"));
        this.userList.add(new User("oscar.garcia", "1234"));
        this.userList.get(1).setUserInfo(new UserInfo("Oscar Garcia", "eodogarcia16@gmail.com", "+56932788616"));
        this.userList.add(new User("123-4567", "1234"));
        this.userList.get(2).setUserInfo(new UserInfo("Oscar Garcia", "eodogarcia16@gmail.com", "+56932788616"));
    }

    public List<User> getUserList() {
        return userList;
    }


}
