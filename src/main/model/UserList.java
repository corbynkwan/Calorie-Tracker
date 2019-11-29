package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserList extends SaveAndLoad implements Serializable {
    private List<User> userList;

    public UserList() {
        userList = new ArrayList<User>();
    }

    //EFFECT Checks if a user exists with the same name. If not adds a new user to the userList
    public boolean add(User newUser) {
        if (!(userList.contains(newUser))) {
            userList.add(newUser);
            return true;
        } else {
            return false;
        }

    }

    //Checks if a user with the same name is in the userList.
    public boolean contains(User newUser) {
        return userList.contains(newUser);
    }

    //REQUIRES userList to have a length >=1
    //EFFECT prints out the whole user list in a format
    public void printUserList() {
        for (int i = 0; i < userList.size(); i++) {
            userList.get(i).printString();
        }
    }

    //returns the size of the userList
    public int size() {
        return userList.size();
    }

    //REQUIRES i to have a length >=0
    //EFFECT returns the Food at index i
    public User get(int i) {
        return userList.get(i);
    }

    //Removes a user from the userList.
    public void remove(User user) {
        userList.remove(user);
    }
}
