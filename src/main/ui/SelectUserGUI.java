package ui;

import model.User;
import model.UserList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SelectUserGUI extends JFrame implements ActionListener {
    public static UserList userList;
    private JComboBox comboBox;
    private JButton selectButton;
    private JButton createUserButton;

    //EFFECTS Human can select which user they want to select or create a user.
    public SelectUserGUI() {
        setTitle("Select User");

        //Loading userList
        try {
            userList = (UserList) load("userList.dat");
        } catch (Exception e) {
            System.out.println("Files couldn't be loaded so new file for UserList and FoodList are created");
            userList = new UserList();
        }

        comboBox = new JComboBox();
        for (int i = 0; i < userList.size();i++) {
            comboBox.addItem(userList.get(i).getName());
        }

        selectButton = new JButton("Select");
        createUserButton = new JButton("Create User");
        add(comboBox);
        add(selectButton);
        selectButton.addActionListener(this);
        add(createUserButton);
        createUserButton.addActionListener(this);
        setLayout(new FlowLayout());
        setVisible(true); //Better to put the methods here so you don't call them in the main method.
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //EFFECTS if e is selectButton. Goes to the MainMenuGUI of the selected user
    //        else if e is createUserButton. Goes to CreateUserGUI
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == selectButton) {
            int index = comboBox.getSelectedIndex();
            User user = userList.get(index);
            new MainMenuGUI(user);
            dispose();
        } else if (e.getSource() == createUserButton) {
            new CreateUserGUI();
            dispose();
        }
    }

    public void save(String fileName) throws Exception {
        try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)))) {
            out.writeObject(this);
        }
    }

    public Object load(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)))) {
            return in.readObject();
        }
    }
}
