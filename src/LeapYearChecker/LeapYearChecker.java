package LeapYearChecker;

import javax.swing.*;

public class LeapYearChecker extends JFrame {
    private JTextField yearTextField;
    private JButton checkYearButton;

    public LeapYearChecker() {
        initializeUI();
    }

    private void initializeUI() {
        setupFrame();
        createYearInputField();
        createCheckButton();
        addComponents();
    }

    private void setupFrame() {
        setTitle("Leap Year Checker");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
    }

    private void createYearInputField() {
        yearTextField = new JTextField();
        yearTextField.setBounds(50, 30, 200, 30);
        yearTextField.setName("yearInputField");
    }

    private void createCheckButton() {
        checkYearButton = new JButton("Check Year");
        checkYearButton.setBounds(100, 70, 100, 30);
        checkYearButton.setName("checkButton");
        checkYearButton.addActionListener(e -> displayLeapYearStatus());
    }

    private void addComponents() {
        add(yearTextField);
        add(checkYearButton);
    }

    private void displayLeapYearStatus() {
        String resultMessage;
        try {
            int year = Integer.parseInt(yearTextField.getText());
            resultMessage = isLeapYear(year) ? "Leap year" : "Not a leap year";
        } catch (NumberFormatException e) {
            resultMessage = "Please enter a valid year.";
        }
        showMessage(resultMessage);
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Result", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LeapYearChecker checkerApp = new LeapYearChecker();
            checkerApp.setVisible(true);
        });
    }
}
