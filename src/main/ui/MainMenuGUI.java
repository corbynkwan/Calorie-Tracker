package ui;

import model.FoodList;
import model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MainMenuGUI extends JFrame implements ActionListener {
    public static User user;
    private JButton viewCaloriePlanButton;
    private JButton addFoodButton;
    private JButton selectNewUserButton;
    private JButton editUserButton;
    private JButton viewFoodListButton;
    private JButton deleteUserButton;
    private JButton foodSummaryButton;
    public static FoodList foodList;

    public MainMenuGUI(User user) {
        setTitle("Main Menu");

        try {
            foodList = (FoodList) load(user.getName() + "FoodList.dat");
        } catch (Exception e) {
            foodList = new FoodList();
        }
        this.user = user;
        viewCaloriePlanButton = new JButton("View Calorie Plan");

        addFoodButton = new JButton("Add Food");
        selectNewUserButton = new JButton("Select New User");
        editUserButton = new JButton("Edit User");
        viewFoodListButton = new JButton("View Food List");
        deleteUserButton = new JButton("Delete User");
        foodSummaryButton = new JButton("Food Summary");

        viewCaloriePlanButton.setAlignmentX(CENTER_ALIGNMENT);

        addFoodButton.setAlignmentX(CENTER_ALIGNMENT);

        selectNewUserButton.setAlignmentX(CENTER_ALIGNMENT);
        editUserButton.setAlignmentX(CENTER_ALIGNMENT);
        viewFoodListButton.setAlignmentX(CENTER_ALIGNMENT);
        deleteUserButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        foodSummaryButton.setAlignmentX(CENTER_ALIGNMENT);
        add(viewCaloriePlanButton);
        add(Box.createVerticalStrut(10));//Adds an empty space between the buttons
        add(addFoodButton);
        add(Box.createVerticalStrut(10));//Adds an empty space between the buttons
        add(selectNewUserButton);
        add(Box.createVerticalStrut(10));//Adds an empty space between the buttons
        add(editUserButton);
        add(Box.createVerticalStrut(10));//Adds an empty space between the buttons
        add(viewFoodListButton);
        add(Box.createVerticalStrut(10));//Adds an empty space between the buttons
        add(deleteUserButton);
        add(Box.createVerticalStrut(10));//Adds an empty space between the buttons
        add(foodSummaryButton);
        viewCaloriePlanButton.addActionListener(this);
        addFoodButton.addActionListener(this);
        selectNewUserButton.addActionListener(this);
        editUserButton.addActionListener(this);
        viewFoodListButton.addActionListener(this);
        deleteUserButton.addActionListener(this);
        foodSummaryButton.addActionListener(this);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS)); //Makes the box layout vertically allign
        setVisible(true); //Better to put the methods here so you don't call them in the main method.
        pack();
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    //EFFECTS goes to respective GUI based on which button the user clicked.
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewCaloriePlanButton) {
            dispose();
            new CaloriePlanGUI();
        } else if (e.getSource() == addFoodButton) {
            dispose();
            new AddFoodGUI();
        } else if (e.getSource() == selectNewUserButton) {
            dispose();
            new SelectUserGUI();
        }
        ifStatementsForAP(e);

    }

    //EFFECTS goes to respective GUI based on which button the user clicked.
    public void ifStatementsForAP(ActionEvent e) {
        if (e.getSource() == editUserButton) {
            dispose();
            new EditUserGUI();
        } else if (e.getSource() == viewFoodListButton) {
            dispose();
            new ViewFoodListGUI();
        } else if (e.getSource() == deleteUserButton) {
            dispose();
            new DeleteUserGUI();
        } else if (e.getSource() == foodSummaryButton) {
            dispose();
            new FoodSummaryGUI("");
        }
    }

    //EFFECTS Saves an object to a file
    public void save(String fileName) throws Exception {
        try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)))) {
            out.writeObject(this);
        }
    }

    //EFFECTS Loads an object from a file
    public Object load(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)))) {
            return in.readObject();
        }
    }
}
