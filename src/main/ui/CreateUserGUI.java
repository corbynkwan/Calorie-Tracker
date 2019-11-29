package ui;

import exceptions.InvalidInputException;
import model.BodyBuildingDiet;
import model.Diet;
import model.KetoDiet;
import model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateUserGUI extends JFrame implements ActionListener {
    String name;
    Diet dietType;
    double targetWeight;
    private JLabel nameLabel;
    private JTextField nameTextField;
    private JLabel dietTypeLabel;
    private JComboBox dietTypeComboBox;
    private JLabel targetWeightLabel;
    private JTextField targetWeightTextField;
    private JButton addUserButton;
    private JButton backButton;
    final Runnable sound = (Runnable)Toolkit.getDefaultToolkit().getDesktopProperty("win.sound.default");

    public CreateUserGUI() {
        setTitle("Create User");

        nameLabel = new JLabel("Name:");
        nameTextField = new JTextField(10);
        dietTypeLabel = new JLabel("Diet Type:");
        dietTypeComboBox = new JComboBox();
        targetWeightLabel = new JLabel("Target Weight (lb):");
        targetWeightTextField = new JTextField(2);
        addUserButton = new JButton("Add User");
        backButton = new JButton("Back");

        dietTypeComboBox.addItem("BodyBuilding");
        dietTypeComboBox.addItem("Keto");

        add(nameLabel);
        add(nameTextField);
        add(dietTypeLabel);
        add(dietTypeComboBox);
        add(targetWeightLabel);
        add(targetWeightTextField);
        add(addUserButton);
        add(backButton);

        addUserButton.addActionListener(this);
        backButton.addActionListener(this);
        backButton.setBounds(500, 50, 150, 100);
        setLayout(new FlowLayout());
        setVisible(true); //Better to put the methods here so you don't call them in the main method.
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    //MODIFIES this
    //EFFECTS if e is addUserButton, adds the user to the userList and saves it
    //        else if e is backButton Goes back to SelectUserGUI
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addUserButton) {
            name = nameTextField.getText();
            if (dietTypeComboBox.getSelectedIndex() == 0) {
                dietType = new BodyBuildingDiet();
            } else {
                dietType = new KetoDiet();
            }
            try {
                targetWeight = Integer.parseInt(targetWeightTextField.getText());
                //Adding user with the same name.
                userNotAddedCondtion();
            } catch (Exception error) {
                sound.run();
                JOptionPane.showMessageDialog(this, "Invalid Input. Try Again");
            }
        } else if (e.getSource() == backButton) {
            dispose();
            new SelectUserGUI();
        }
    }

    //EFFECTS show an error message when the user exists
    public void userNotAddedCondtion() throws InvalidInputException {
        if (SelectUserGUI.userList.add(new User(name, dietType, targetWeight)) == false) {
            sound.run();
            JOptionPane.showMessageDialog(this, "User with the same name already exists");
        } else {
            userAddedCondition();
        }
    }

    //EFFECTS  Creates a user and saves it to the user list
    public void userAddedCondition() {
        try {
            SelectUserGUI.userList.add(new User(name, dietType, targetWeight));
            SelectUserGUI.userList.save("userList.dat");
            JOptionPane.showMessageDialog(this, "User created");
            dispose();
            new SelectUserGUI();
        } catch (Exception error) {
            sound.run();
            JOptionPane.showMessageDialog(this, "Unable to save userList");
        }
    }


}
