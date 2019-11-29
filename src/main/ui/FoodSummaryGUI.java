package ui;

import network.FoodSummary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FoodSummaryGUI extends JFrame implements ActionListener {
    private JTextField foodToSearchTextField;
    private JButton searchButton;
    private JButton backButton;
    private JTextArea foodTextArea;
    private FoodSummary fs;
    String summary;
    final Runnable sound = (Runnable)Toolkit.getDefaultToolkit().getDesktopProperty("win.sound.default");

    public FoodSummaryGUI(String summary) {
        this.summary = summary;
        fs = new FoodSummary();
        foodToSearchTextField = new JTextField(5);
        foodTextArea = new JTextArea(this.summary);
        searchButton = new JButton("Search");
        backButton = new JButton("Back");
        foodTextArea.setMinimumSize(new Dimension(300,300));
        foodTextArea.setPreferredSize(new Dimension(300,300));
        foodTextArea.setMaximumSize(new Dimension(300,300));
        foodTextArea.setLineWrap(true);
        foodTextArea.setWrapStyleWord(true);
        Font font = new Font("Arial", Font.BOLD, 20);
        foodTextArea.setFont(font);

        add(foodToSearchTextField);
        add(searchButton);
        add(backButton);
        add(foodTextArea);


        searchButton.addActionListener(this);
        backButton.addActionListener(this);
        setLayout(new FlowLayout());
        setVisible(true); //Better to put the methods here so you don't call them in the main method.
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchButton) {
            try {
                summary = fs.fetchSummary(foodToSearchTextField.getText());
                JOptionPane.showMessageDialog(this, "Food Summary completed");
                dispose();
                new FoodSummaryGUI(summary);
            } catch (Exception error) {
                sound.run();
                JOptionPane.showMessageDialog(this, "Unable to find results from the web");
            }
        } else if (e.getSource() == backButton) {
            dispose();
            new MainMenuGUI(MainMenuGUI.user);
        }
    }
}
