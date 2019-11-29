package ui;

import model.Food;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CaloriePlanGUI extends JFrame implements ActionListener {

    private JButton removeFoodButton;
    private JTable table;
    private JButton addFoodButton;
    private JButton backButton;
    private JButton resetButton;
    private Object[][] array;
    public static ArrayList<ArrayList<Object>> data = new ArrayList<ArrayList<Object>>();
    final Runnable sound = (Runnable)Toolkit.getDefaultToolkit().getDesktopProperty("win.sound.default");

    public CaloriePlanGUI() {
        setTitle("Calorie Plan");

        String[] columnNames = {"Name", "Calories", "Protein", "Carbs", "Fats"};
        array = new Object[data.size() + 2][5];
        for (int i = 0; i < data.size(); i++) {
            ArrayList<Object> row = data.get(i);
            array[i] = row.toArray(new Object[row.size()]);
        }

        double totalCal = 0;
        double totalPro = 0;
        double totalCarbs = 0;
        double totalFats = 0;

        for (int i = 0; i < data.size();i++) {
            totalCal += (Double)data.get(i).get(1);
            totalPro += (Double)data.get(i).get(2);
            totalCarbs += (Double)data.get(i).get(3);
            totalFats += (Double)data.get(i).get(4);
        }
        array[array.length - 2][0] = "TOTAL";
        array[array.length - 2][1] = totalCal;
        array[array.length - 2][2] = totalPro;
        array[array.length - 2][3] = totalCarbs;
        array[array.length - 2][4] = totalFats;

        System.out.println(MainMenuGUI.user.getDietType().calculateCal());
        array[array.length - 1][0] = "TARGET TOTAL";
        array[array.length - 1][1] = MainMenuGUI.user.getDietType().calculateCal();
        array[array.length - 1][2] = MainMenuGUI.user.getDietType().calculatePro();
        array[array.length - 1][3] = MainMenuGUI.user.getDietType().calculateCarbs();
        array[array.length - 1][4] = MainMenuGUI.user.getDietType().calculateFats();

        table = new JTable(array, columnNames);
        add(table);
        addFoodButton = new JButton("Add Food");
        JScrollPane scrollPane = new JScrollPane(table);
        removeFoodButton = new JButton("Remove Food");
        backButton = new JButton("Back");
        resetButton = new JButton("Reset");
        add(scrollPane);
        add(backButton);
        add(addFoodButton);
        add(removeFoodButton);
        add(resetButton);

        backButton.addActionListener(this);
        addFoodButton.addActionListener(this);
        removeFoodButton.addActionListener(this);
        resetButton.addActionListener(this);

        table.setFillsViewportHeight(true);
        setLayout(new FlowLayout());
        setVisible(true); //Better to put the methods here so you don't call them in the main method.
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public CaloriePlanGUI(Food f) {
        //Not sure if this class is needed
        String[][] data = {};
        String[] columnNames = {"Name", "Calories", "Protein", "Carbs", "Fats"};
        table.setBounds(30, 40, 200, 300);
        table = new JTable(data, columnNames);
        add(table);


        setLayout(null); //Put FlowLayout so that border layout is not put where 1 label is put on top of the other.
        setVisible(true); //Better to put the methods here so you don't call them in the main method.
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    //MODIFIES this
    //EFFECTS if e is removeFoodButton. Removes the Selected Food.
    //        else if e is addFoodButton. Goes to AddFoodToCaloriePlanGUI
    //        else if e is backButton. Goes back to MainMenuGUI
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addFoodButton) {
            dispose();
            new AddFoodToCaloriePlanGUI();
        } else if (e.getSource() == removeFoodButton) {
            if (table.getSelectedRow() == -1 || table.getSelectedRow() == array.length - 1
                    || table.getSelectedRow() == array.length - 2) {
                sound.run();
                JOptionPane.showMessageDialog(this, "Row Not Selected. Try Again");
                //if row selected is not the total of target row
            } else {
                elseCondtion();
            }
        } else if (e.getSource() == backButton) {
            dispose();
            new MainMenuGUI(MainMenuGUI.user);
        } else if (e.getSource() == resetButton) {
            resetButtonCondition();
        }
    }

    public void elseCondtion() {
        int i = table.getSelectedRow();
        data.remove(i);
        dispose();
        new CaloriePlanGUI();
    }

    public void resetButtonCondition() {
        data = new ArrayList<ArrayList<Object>>();
        dispose();
        new CaloriePlanGUI();
    }
}
