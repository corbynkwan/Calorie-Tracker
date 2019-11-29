package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class DeleteUserGUI extends JFrame implements ActionListener {
    JLabel confirmationLabel;
    JButton yesButton;
    JButton noButton;

    public DeleteUserGUI() {
        confirmationLabel = new JLabel("Are you sure you want to delete this user?");
        yesButton = new JButton("Yes");
        noButton = new JButton("No");
        add(confirmationLabel);
        add(yesButton);
        add(noButton);
        yesButton.addActionListener(this);
        noButton.addActionListener(this);
        setLayout(new FlowLayout());
        setVisible(true); //Better to put the methods here so you don't call them in the main method.
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    //MODIFIES SelectUserGUI() userList
    //EFFECTS removes this user from userList
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == yesButton) {
            File f = new File(MainMenuGUI.user.getName() + "FoodList.dat");
            f.delete();
            SelectUserGUI.userList.remove(MainMenuGUI.user);
            try {
                SelectUserGUI.userList.save("userList.dat");
            } catch (Exception error) {
                System.out.println("Unable to save");
            }
            dispose();
            new SelectUserGUI();
        } else if (e.getSource() == noButton) {
            dispose();
            new MainMenuGUI(MainMenuGUI.user);
        }
    }

}

