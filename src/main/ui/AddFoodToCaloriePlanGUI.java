package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class AddFoodToCaloriePlanGUI extends JFrame implements ActionListener {
    //Import the FoodList of the user load then display that food list.
    //Display that food list using a table using a for loop probably
    //Have an add button to add the food to the static FoodList in CaloriePlanGUI
    //Make an option in CaloriePlanGUI to remove a food when selecting the table (Search google on how to do this).

    //Load the food list so the user can add food
    private ArrayList<ArrayList<Object>> foodArray;
    JTable table;
    JButton addFoodButton;
    JButton backButton;
    ArrayList<Object> foodToBeAdded;
    Object[][] array;
    final Runnable sound = (Runnable)Toolkit.getDefaultToolkit().getDesktopProperty("win.sound.default");

    public AddFoodToCaloriePlanGUI() {
        setTitle("Add Food To Calorie Plan");
        //Display that food list using a table using a for loop probably
        String[] columnNames = {"Name", "Calories", "Protein", "Carbs", "Fats"};
        foodArray = new ArrayList<ArrayList<Object>>();
        convertArrayToArrayList();
        table = new JTable(array, columnNames);
        addFoodButton = new JButton("Add Food");
        backButton = new JButton("Back");
        addFoodButton.addActionListener(this);
        backButton.addActionListener(this);
        // Frame Size
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        add(scrollPane);
        add(backButton);
        add(addFoodButton);
        setLayout(new FlowLayout());
        setVisible(true); //Better to put the methods here so you don't call them in the main method.
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //MODIFIES this
    //EFFECTS converts the foodList ArrayList to a 2D Array to add to the JTable
    public void convertArrayToArrayList() {
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
        array = new Object[foodArray.size()][];
        for (int i = 0; i < foodArray.size(); i++) {
            ArrayList<Object> row = foodArray.get(i);
            array[i] = row.toArray(new Object[row.size()]);
        }
    }

    //EFFECTS saves an object to  fileName
    public void save(String fileName) throws Exception {
        try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)))) {
            out.writeObject(this);
        }
    }

    //EFFECTS loads an object from fileName
    public Object load(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)))) {
            return in.readObject();
        }
    }

    //EFFECTS if e is addFoodButton. Adds the food to the Calorie Planner.
    //        else if e is backButton. Goes Back to CaloriePlannerGUI
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addFoodButton) {
            int i;
            try {
                i = table.getSelectedRow();
                foodToBeAdded = new ArrayList<>();
                CaloriePlanGUI.data.add(foodToBeAdded);
                JOptionPane.showMessageDialog(this, "Food added to Calorie Plan");
                addToArrayList(i);
                dispose();
                new CaloriePlanGUI();
            } catch (Exception error) {
                sound.run();
                JOptionPane.showMessageDialog(this, "Row Not Selected. Try Again");
            }

        } else if (e.getSource() == backButton) {
            dispose();
            new CaloriePlanGUI();
        }
    }

    //MODIFIES this
    //EFFECTS adds selected food into the CaloriePlanGUI table.
    public void addToArrayList(int i) {
        foodToBeAdded.add(MainMenuGUI.foodList.get(i).getName());
        foodToBeAdded.add(MainMenuGUI.foodList.get(i).getCalories());
        foodToBeAdded.add(MainMenuGUI.foodList.get(i).getProtein());
        foodToBeAdded.add(MainMenuGUI.foodList.get(i).getCarbs());
        foodToBeAdded.add(MainMenuGUI.foodList.get(i).getFats());
    }
}
