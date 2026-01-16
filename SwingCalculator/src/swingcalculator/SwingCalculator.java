package swingcalculator;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SwingCalculator extends JFrame implements ActionListener {

    JTextField t1, t2, t3;
    JButton b1, b2, b3, b4, b5, b6;

    SwingCalculator(String title) {
        super(title);

        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER, 80, 10));

        JLabel l1 = new JLabel("Number 1");
        t1 = new JTextField(10);

        JLabel l2 = new JLabel("Number 2");
        t2 = new JTextField(10);

        JLabel l3 = new JLabel("Result: ");
        t3 = new JTextField(10);
        t3.setEditable(false);

        b1 = new JButton("Add");
        b2 = new JButton("Sub");
        b3 = new JButton("Mul");
        b4 = new JButton("Div");
        b5 = new JButton("Clear");
        b6 = new JButton("Exit");

        // Add components to the frame
        add(l1); add(t1);
        add(l2); add(t2);
        add(l3); add(t3);
        add(b1); add(b2); add(b3); add(b4);
        add(b5); add(b6);

        // Add action listeners
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double n1 = Double.parseDouble(t1.getText());
            double n2 = Double.parseDouble(t2.getText());
            double result = 0;

            if (e.getSource() == b1) {
                result = n1 + n2;
            } else if (e.getSource() == b2) {
                result = n1 - n2;
            } else if (e.getSource() == b3) {
                result = n1 * n2;
            } else if (e.getSource() == b4) {
                if (n2 == 0) {
                    t3.setText("Divide by 0");
                    return;
                } else {
                    result = n1 / n2;
                }
            }

            if (e.getSource() != b5 && e.getSource() != b6) {
                t3.setText(String.valueOf(result));
            }

        } catch (NumberFormatException ex) {
            t3.setText("Invalid");
        }

        if (e.getSource() == b5) { // Clear
            t1.setText("");
            t2.setText("");
            t3.setText("");
        }

        if (e.getSource() == b6) { // Exit
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new SwingCalculator("Simple Calculator");
    }
}
