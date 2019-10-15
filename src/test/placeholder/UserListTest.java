package placeholder;

import model.BodyBuildingDiet;
import model.User;
import model.UserList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserListTest {
    UserList userList;
    User u;

    @BeforeEach
    public void runBefore() {
        u = new User("dave", new BodyBuildingDiet(), 155);
    }
    @Test
    void add() {
        userList.add(u);
        assertEquals(u, userList.get(0));
    }

    @Test
    void getUserList() {
        assertEquals(userList.getUserList(),userList);
    }

    @Test
    void printUserList() {
        userList.add(u);
        userList.printUserList();
    }

    @Test
    void get() {
        assertEquals(userList.get(0), u);
    }
}