package model;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class UserList implements Serializable, SaveAndLoad {
    private List<User> userList;

    public UserList() {
        userList = new ArrayList<User>();
    }
    //EFFECT adds a new user to the userList

    public void add(User newUser) {
        userList.add(newUser);
    }

    //EFFECT returns the userList
    public List<User> getUserList() {
        return userList;
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


    @Override
    public void save(String fileName) throws Exception {
        try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)))) {
            out.writeObject(this);
            out.close();
        }
    }

    @Override
    public Object load(String fileName) throws Exception {
        try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)))) {
            return in.readObject();
        }
    }
}
