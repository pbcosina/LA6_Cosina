package FoodOrderingSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FoodOrderingSystem extends JFrame {
    // Declare components
    private JCheckBox cPizza, cBurger, cFries, cSoftDrinks, cTea, cSundae;
    private JRadioButton radioButton1;
    private JRadioButton rb5, rb10, rb15, rbNone;
    private ButtonGroup discountGroup;
    private JButton btnOrder;

    // Prices for each food item
    private static final double PIZZA_PRICE = 100.0;
    private static final double BURGER_PRICE = 80.0;
    private static final double FRIES_PRICE = 65.0;
    private static final double SOFT_DRINKS_PRICE = 55.0;
    private static final double TEA_PRICE = 50.0;
    private static final double SUNDAE_PRICE = 40.0;

    public FoodOrderingSystem() {
        // Set up the frame
        setTitle("Food Ordering System");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Initialize checkboxes for food items
        cPizza = new JCheckBox("Pizza - Php 100");
        cBurger = new JCheckBox("Burger - Php 80");
        cFries = new JCheckBox("Fries - Php 65");
        cSoftDrinks = new JCheckBox("Soft drinks - Php 55");
        cTea = new JCheckBox("Tea - Php 50");
        cSundae = new JCheckBox("Sundae - Php 40");

        // Initialize radio buttons for discounts
        rb5 = new JRadioButton("5% off");
        rb10 = new JRadioButton("10% off");
        rb15 = new JRadioButton("15% off");
        rbNone = new JRadioButton("No discount", true); // Default is no discount

        // Group the radio buttons together to allow only one selection at a time
        discountGroup = new ButtonGroup();
        discountGroup.add(rb5);
        discountGroup.add(rb10);
        discountGroup.add(rb15);
        discountGroup.add(rbNone);

        // Initialize the order button
        btnOrder = new JButton("Order");

        // Add components to the frame
        add(cPizza);
        add(cBurger);
        add(cFries);
        add(cSoftDrinks);
        add(cTea);
        add(cSundae);
        add(rb5);
        add(rb10);
        add(rb15);
        add(rbNone);
        add(btnOrder);

        // Action listener for the order button
        btnOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateTotalPrice();
            }
        });
    }

    private void calculateTotalPrice() {
        double totalPrice = 0.0;

        // Add the price of each selected food item
        if (cPizza.isSelected()) totalPrice += PIZZA_PRICE;
        if (cBurger.isSelected()) totalPrice += BURGER_PRICE;
        if (cFries.isSelected()) totalPrice += FRIES_PRICE;
        if (cSoftDrinks.isSelected()) totalPrice += SOFT_DRINKS_PRICE;
        if (cTea.isSelected()) totalPrice += TEA_PRICE;
        if (cSundae.isSelected()) totalPrice += SUNDAE_PRICE;

        // Get the selected discount
        double discountPercentage = 0.0;
        if (rb5.isSelected()) discountPercentage = 5.0;
        else if (rb10.isSelected()) discountPercentage = 10.0;
        else if (rb15.isSelected()) discountPercentage = 15.0;

        // Apply the discount
        double discountAmount = totalPrice * discountPercentage / 100;
        totalPrice -= discountAmount;

        // Format the total price to 2 decimal places
        String totalPriceFormatted = String.format("The total price is Php %.2f", totalPrice);

        // Show the total price in a message dialog
        JOptionPane.showMessageDialog(this, totalPriceFormatted);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Create an instance of the FoodOrderingSystem class and make it visible
            FoodOrderingSystem orderingSystem = new FoodOrderingSystem();
            orderingSystem.setVisible(true);
        });
    }
}