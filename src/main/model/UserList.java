package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserList extends SaveAndLoad implements Serializable {
    private List<User> userList;

    public UserList() {
        userList = new ArrayList<User>();
    }
    //EFFECT adds a new user to the userList

    public void add(User newUser) {
        userList.add(newUser);
    }

    //REQUIRES userList to have a length >=1
    //EFFECT prints out the whole user list in a format
    public void printUserList() {
        for (int i = 0; i < userList.size(); i++) {
            userList.get(i).printString();
        }
    }

    //REQUIRES i to have a length >=0
    //EFFECT returns the Food at index i
    public User get(int i) {
        return userList.get(i);
    }

}
