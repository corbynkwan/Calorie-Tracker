package ui;

import model.Food;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AddFoodGUI extends JFrame implements ActionListener {
    private JLabel nameLabel;
    private JLabel calLabel;
    private JLabel proLabel;
    private JLabel carbsLabel;
    private JLabel fatsLabel;
    private JTextField nameTextField;
    private JTextField calTextField;
    private JTextField proTextField;
    private JTextField carbsTextField;
    private JTextField fatsTextField;
    private JButton addFoodButton;
    private JButton backButton;
    final Runnable sound = (Runnable)Toolkit.getDefaultToolkit().getDesktopProperty("win.sound.default");

    public AddFoodGUI() {
        setTitle("Add Food To FoodList");
        nameLabel = new JLabel("Name:");
        calLabel = new JLabel("Calories (100g):");
        proLabel = new JLabel("Protein (100g):");
        carbsLabel = new JLabel("Carbs (100g):");
        fatsLabel = new JLabel("Fats (100g):");
        nameTextField = new JTextField(5);
        calTextField = new JTextField(2);
        proTextField = new JTextField(2);
        carbsTextField = new JTextField(2);
        fatsTextField = new JTextField(2);

        addFoodButton = new JButton("Add");
        addFoodButton.addActionListener(this);
        backButton = new JButton("Back");
        backButton.addActionListener(this);
        add(nameLabel);
        add(nameTextField);
        add(calLabel);
        add(calTextField);
        add(proLabel);
        add(proTextField);
        add(carbsLabel);
        add(carbsTextField);
        add(fatsLabel);
        add(fatsTextField);
        add(addFoodButton);
        add(backButton);
        setLayout(new FlowLayout());
        setVisible(true); //Better to put the methods here so you don't call them in the main method.
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    //EFFECTS if e is addFoodButton. Adds the food the foodList file and saves it.
    //        if its the back button. Goes back to MainMenuGUI.
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addFoodButton) {
            try {
                Food newFood = new Food(nameTextField.getText(),
                        Integer.parseInt(calTextField.getText()),
                        Integer.parseInt(proTextField.getText()),
                        Integer.parseInt(carbsTextField.getText()), Integer.parseInt(fatsTextField.getText()));
                MainMenuGUI.foodList.add(newFood);
                MainMenuGUI.foodList.save(MainMenuGUI.user.getName() + "FoodList.dat");
                dispose();
                new MainMenuGUI(MainMenuGUI.user);
            } catch (Exception error) {
                sound.run();
                JOptionPane.showMessageDialog(this, "Invalid Input(s). Try Again");
            }
        } else if (e.getSource() == backButton) {
            dispose();
            new MainMenuGUI(MainMenuGUI.user);
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
