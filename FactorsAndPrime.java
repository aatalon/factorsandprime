

import javax.swing.*;
import java.awt.event.*;

public class FactorsAndPrime extends JFrame {
    
    private JLabel lblTitle, lblEnter;
    private JTextField txtNumber;
    private JButton btnCalculate, btnExit;
    private JTextArea txtOutput;
    private JScrollPane scrollPane;

    public FactorsAndPrime() {
        // Frame setup
        setTitle("Factors and Prime Number");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Title label
        lblTitle = new JLabel("Factors and Prime Number");
        lblTitle.setBounds(120, 10, 200, 25);
        add(lblTitle);

        // Input label
        lblEnter = new JLabel("Enter a number:");
        lblEnter.setBounds(80, 50, 100, 25);
        add(lblEnter);

        // Input text field
        txtNumber = new JTextField();
        txtNumber.setBounds(190, 50, 80, 25);
        add(txtNumber);

        // Calculate button
        btnCalculate = new JButton("Calculate");
        btnCalculate.setBounds(140, 90, 100, 30);
        add(btnCalculate);

        // Output area
        txtOutput = new JTextArea();
        txtOutput.setEditable(false);
        scrollPane = new JScrollPane(txtOutput);
        scrollPane.setBounds(60, 140, 270, 70);
        add(scrollPane);

        // Exit button
        btnExit = new JButton("Exit");
        btnExit.setBounds(160, 230, 80, 25);
        add(btnExit);

        // Action listeners
        btnCalculate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateFactors();
            }
        });

        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void calculateFactors() {
        try {
            int number = Integer.parseInt(txtNumber.getText());
            if (number <= 0) {
                txtOutput.setText("Please enter a positive number.");
                return;
            }

            String factors = "";
            int count = 0;

            for (int i = 1; i <= number; i++) {
                if (number % i == 0) {
                    factors += i + ", ";
                    count++;
                }
            }

            // Remove trailing comma
            if (factors.endsWith(", ")) {
                factors = factors.substring(0, factors.length() - 2);
            }

            // Determine if prime
            String message = (count == 2) ? "Prime Number!" : "NOT Prime";

            txtOutput.setText(factors + "\n" + message);

        } catch (NumberFormatException ex) {
            txtOutput.setText("Invalid input. Please enter a whole number.");
        }
    }

    public static void main(String[] args) {
        new FactorsAndPrime().setVisible(true);
    }
}
