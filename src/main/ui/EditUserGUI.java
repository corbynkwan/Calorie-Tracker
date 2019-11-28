package ui;

import model.BodyBuildingDiet;
import model.Diet;
import model.KetoDiet;
import model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class EditUserGUI extends JFrame implements ActionListener {
    private JLabel nameLabel;
    private JTextField nameTextField;
    private JLabel dietTypeLabel;
    private JComboBox dietTypeComboBox;
    private JLabel targetWeightLabel;
    private JTextField targetWeightTextField;
    private JButton editUserButton;
    private JButton backButton;
    final Runnable sound = (Runnable)Toolkit.getDefaultToolkit().getDesktopProperty("win.sound.default");

    public EditUserGUI() {
        setTitle("Edit User");

        nameLabel = new JLabel("Name:");
        nameTextField = new JTextField(10);
        dietTypeLabel = new JLabel("Diet Type:");
        dietTypeComboBox = new JComboBox();
        targetWeightLabel = new JLabel("Target Weight:");
        targetWeightTextField = new JTextField(2);
        editUserButton = new JButton("Edit User");
        backButton = new JButton("Back");

        dietTypeComboBox.addItem("BodyBuilding");
        dietTypeComboBox.addItem("Keto");

        add(nameLabel);
        add(nameTextField);
        add(dietTypeLabel);
        add(dietTypeComboBox);
        add(targetWeightLabel);
        add(targetWeightTextField);
        add(editUserButton);
        add(backButton);

        editUserButton.addActionListener(this);
        backButton.addActionListener(this);
        backButton.setBounds(500, 50, 150, 100);
        setLayout(new FlowLayout()); //Put FlowLayout so that border layout is not put where 1 label is put on top of the other.
        setVisible(true); //Better to put the methods here so you don't call them in the main method.
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == editUserButton) {
            String name = nameTextField.getText();
            Diet dietType;
            if (dietTypeComboBox.getSelectedIndex() == 0) {
                dietType = new BodyBuildingDiet();
            } else {
                dietType = new KetoDiet();
            }
            try {
                double targetWeight = Integer.parseInt(targetWeightTextField.getText());
                MainMenuGUI.user.setDietType(dietType);
                MainMenuGUI.user.setTargetWeight(targetWeight);
                File oldFileName = new File(MainMenuGUI.user.getName() + "FoodList.dat");
                if (SelectUserGUI.userList.contains(new User(name,new BodyBuildingDiet(),5))) {
                    sound.run();
                    JOptionPane.showMessageDialog(this, "User with same name already exists");
                } else {
                    MainMenuGUI.user.setName(name);
                    SelectUserGUI.userList.save("userList.dat");
                    dispose();
                    File newFileName = new File(MainMenuGUI.user.getName() + "FoodList.dat");
                    oldFileName.renameTo(newFileName);
                    new MainMenuGUI(MainMenuGUI.user);
                }
            } catch (Exception error) {
                sound.run();
                JOptionPane.showMessageDialog(this, "Invalid Input. Try Again");
            }
        } else if (e.getSource() == backButton) {
            dispose();
            new MainMenuGUI(MainMenuGUI.user);
        }
    }
}
