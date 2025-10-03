import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {
    private JTextField display;
    private double num1 = 0, num2 = 0, result = 0;
    private char operator;

    public Calculator() {
        setTitle("Modern Colorful Calculator");
        setSize(420, 520);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(new Color(30, 30, 30));

        display = new JTextField();
        display.setFont(new Font("Segoe UI", Font.BOLD, 28));
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setBackground(new Color(50, 50, 50));
        display.setForeground(Color.WHITE);
        display.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 12, 12));
        panel.setBackground(new Color(30, 30, 30));

        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "=", "+"
        };

        for (String text : buttons) {
            JButton btn = new JButton(text);
            btn.setFont(new Font("Segoe UI", Font.BOLD, 22));
            btn.setFocusPainted(false);
            btn.setOpaque(true);
            btn.setBorderPainted(false);

            if ("/*-+".contains(text)) {
                btn.setBackground(new Color(186, 85, 211)); // purple
                btn.setForeground(Color.WHITE);
            } else if (text.equals("=")) {
                btn.setBackground(new Color(0, 200, 83)); // green
                btn.setForeground(Color.WHITE);
            } else if (text.equals("C")) {
                btn.setBackground(new Color(220, 20, 60)); // red
                btn.setForeground(Color.WHITE);
            } else {
                btn.setBackground(new Color(0, 150, 136)); // teal
                btn.setForeground(Color.WHITE);
            }

            btn.setBorder(BorderFactory.createLineBorder(new Color(40, 40, 40), 2, true));
            btn.addActionListener(this);
            panel.add(btn);
        }

        add(panel, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.charAt(0) >= '0' && command.charAt(0) <= '9') {
            display.setText(display.getText() + command);
        } else if (command.equals("C")) {
            display.setText("");
            num1 = num2 = result = 0;
        } else if (command.equals("=")) {
            try {
                num2 = Double.parseDouble(display.getText());
                switch (operator) {
                    case '+': result = num1 + num2; break;
                    case '-': result = num1 - num2; break;
                    case '*': result = num1 * num2; break;
                    case '/': 
                        if (num2 != 0) result = num1 / num2;
                        else JOptionPane.showMessageDialog(this, "Cannot divide by zero!");
                        break;
                }
                display.setText("" + result);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid Input!");
            }
        } else {
            num1 = Double.parseDouble(display.getText());
            operator = command.charAt(0);
            display.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Calculator calc = new Calculator();
            calc.setVisible(true);
        });
    }
}
