package SimpleCalculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator extends JFrame {
    private JTextField tfNumber1, tfNumber2;
    private JComboBox<String> cbOperations;
    private JButton btnCompute;
    private JLabel lblResult;

    public SimpleCalculator() {
        setTitle("Simple Calculator");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        tfNumber1 = new JTextField();
        tfNumber1.setBounds(30, 30, 100, 30);
        tfNumber1.setName("tfNumber1");

        tfNumber2 = new JTextField();
        tfNumber2.setBounds(250, 30, 100, 30);
        tfNumber2.setName("tfNumber2");

        String[] operations = {"+", "-", "*", "/"};
        cbOperations = new JComboBox<>(operations);
        cbOperations.setBounds(150, 30, 80, 30);
        cbOperations.setName("cbOperations");

        btnCompute = new JButton("Compute");
        btnCompute.setBounds(150, 80, 100, 30);
        btnCompute.setName("btnCompute");

        lblResult = new JLabel("Result: ");
        lblResult.setBounds(380, 30, 200, 30);
        lblResult.setName("lblResult");

        add(tfNumber1);
        add(cbOperations);
        add(tfNumber2);
        add(btnCompute);
        add(lblResult);

        btnCompute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateResult();
            }
        });
    }

    private void calculateResult() {
        try {

            double num1 = Double.parseDouble(tfNumber1.getText());
            double num2 = Double.parseDouble(tfNumber2.getText());

            String operation = (String) cbOperations.getSelectedItem();
            double result;

            switch (operation) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 == 0) {
                        lblResult.setText("Error: Division by zero");
                        return;
                    }
                    result = num1 / num2;
                    break;
                default:
                    lblResult.setText("Invalid operation");
                    return;
            }

            lblResult.setText("Result: " + result);

        } catch (NumberFormatException e) {
            lblResult.setText("Error: Enter valid numbers");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SimpleCalculator calculator = new SimpleCalculator();
            calculator.setVisible(true);
        });
    }
}