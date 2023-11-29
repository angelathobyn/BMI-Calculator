/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BMISemester1;
/**
 *
 * @author axioo
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BMICalculator {
    public static void main(String[] args) {
        JFrame frame = new JFrame("BMI Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel);
        placeComponents(panel);

        frame.setSize(300, 200);
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel weightLabel = new JLabel("Berat Badan (kg):");
        weightLabel.setBounds(10, 20, 150, 25);
        panel.add(weightLabel);

        JTextField weightText = new JTextField(20);
        weightText.setBounds(160, 20, 100, 25);
        panel.add(weightText);

        JLabel heightLabel = new JLabel("Tinggi Badan (m):");
        heightLabel.setBounds(10, 50, 150, 25);
        panel.add(heightLabel);

        JTextField heightText = new JTextField(20);
        heightText.setBounds(160, 50, 100, 25);
        panel.add(heightText);

        JButton calculateButton = new JButton("Hitung BMI");
        calculateButton.setBounds(10, 80, 120, 25);
        panel.add(calculateButton);

        JLabel resultLabel = new JLabel("");
        resultLabel.setBounds(10, 110, 250, 25);
        panel.add(resultLabel);

        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double weight = Double.parseDouble(weightText.getText());
                    double height = Double.parseDouble(heightText.getText());

                    double bmi = calculateBMI(weight, height);

                    resultLabel.setText("BMI Anda: " + bmi + ", Kategori BMI: " + interpretBMI(bmi));
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Masukkan berat dan tinggi yang valid.");
                }
            }
        });
    }

    private static double calculateBMI(double weight, double height) {
        return (100 * 100 * weight) / (height * height);
    }

    private static String interpretBMI(double bmi) {
        if (bmi < 18.5) {
            return "Kekurangan berat badan";
        } else if (bmi >= 18.5 && bmi < 23) {
            return "Normal";
        } else if (bmi >= 23 && bmi < 30) {
            return "Kelebihan berat badan";
        } else {
            return "Obesitas";
        }
    }
}