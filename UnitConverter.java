import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UnitConverter extends JFrame implements ActionListener {
    JComboBox<String> category;
    JTextField input, output;
    JButton convert, reset;

    public UnitConverter() {
        setTitle("Unit Converter");
        setSize(350, 200);
        setLayout(new GridLayout(4, 2, 10, 10));

        category = new JComboBox<>(new String[]{"Length (cm→m)", "Temperature (°C→°F)", "Weight (kg→lbs)"});
        input = new JTextField();
        output = new JTextField();
        output.setEditable(false);
        convert = new JButton("Convert");
        reset = new JButton("Reset");

        add(new JLabel("Select Category:"));
        add(category);
        add(new JLabel("Input:"));
        add(input);
        add(new JLabel("Output:"));
        add(output);
        add(convert);
        add(reset);

        convert.addActionListener(this);
        reset.addActionListener(e -> input.setText(""));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double val = Double.parseDouble(input.getText());
            String choice = (String) category.getSelectedItem();
            double result = 0;

            if (choice.contains("Length")) result = val / 100;       // cm → m
            else if (choice.contains("Temperature")) result = (val * 9/5) + 32; // °C → °F
            else if (choice.contains("Weight")) result = val * 2.20462; // kg → lbs

            output.setText(String.format("%.2f", result));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Enter valid number!");
        }
    }

    public static void main(String[] args) {
        new UnitConverter();
    }
}