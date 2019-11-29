package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ViewFoodListGUI extends JFrame implements ActionListener {
    private ArrayList<ArrayList<Object>> foodArray;
    JTable table;
    JButton backButton;

    //MODIFIES this
    //EFFECTS User can view the foodList and it's macronutrients values through JTable
    public ViewFoodListGUI() {
        setTitle("Food List");

        //Display that food list using a table using a for loop probably
        String[] columnNames = {"Name", "Calories", "Protein", "Carbs", "Fats"};
        foodArray = new ArrayList<ArrayList<Object>>();
        for (int i = 0; i < MainMenuGUI.foodList.size(); i++) {
            ArrayList<Object> a = new ArrayList<>();
            a.add(MainMenuGUI.foodList.get(i).getName());
            a.add(MainMenuGUI.foodList.get(i).getCalories());
            a.add(MainMenuGUI.foodList.get(i).getProtein());
            a.add(MainMenuGUI.foodList.get(i).getCarbs());
            a.add(MainMenuGUI.foodList.get(i).getFats());
            foodArray.add(a);
            a = new ArrayList<>();
        }
        Object[][] array = new Object[foodArray.size()][];
        for (int i = 0; i < foodArray.size(); i++) {
            ArrayList<Object> row = foodArray.get(i);
            array[i] = row.toArray(new Object[row.size()]);
        }
        table = new JTable(array, columnNames);
        backButton = new JButton("Back");
        backButton.addActionListener(this);
        // Frame Size
        JScrollPane scrollPane = new JScrollPane(table);
        //scrollPane.setSize();
        table.setFillsViewportHeight(true);
        add(scrollPane);
        add(backButton);
        setLayout(new FlowLayout());
        setVisible(true); //Better to put the methods here so you don't call them in the main method.
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//

    }

    //EFFECTS if e is backButton. Goes back to MainMenuGUI
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            dispose();
            new MainMenuGUI(MainMenuGUI.user);
        }
    }
}
