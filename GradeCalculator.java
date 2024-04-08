import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GradeCalculator extends JFrame {

    private JLabel osLabel, cnLabel, dbmsLabel, oopsLabel, dsLabel;
    private JTextField osTextField, cnTextField, dbmsTextField, oopsTextField, dsTextField;
    private JButton calculateButton, resetButton;
    private JTextField percentageTextField, gradeTextField;

    public GradeCalculator() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Grade Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);

        osLabel = new JLabel("Operating System:");
        cnLabel = new JLabel("Computer Network:");
        dbmsLabel = new JLabel("DBMS:");
        oopsLabel = new JLabel("OOPS:");
        dsLabel = new JLabel("Data Structures and Algorithm:");

        osTextField = new JTextField(10);
        cnTextField = new JTextField(10);
        dbmsTextField = new JTextField(10);
        oopsTextField = new JTextField(10);
        dsTextField = new JTextField(10);

        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(this::calculateGrade);

        resetButton = new JButton("Reset");
        resetButton.addActionListener(this::resetFields);

        percentageTextField = new JTextField(10);
        percentageTextField.setEditable(false); // Make it read-only
        gradeTextField = new JTextField(10);
        gradeTextField.setEditable(false); // Make it read-only

        JPanel panel = new JPanel(new GridLayout(0, 2)); // GridLayout with two columns
        panel.add(osLabel);
        panel.add(osTextField);
        panel.add(cnLabel);
        panel.add(cnTextField);
        panel.add(dbmsLabel);
        panel.add(dbmsTextField);
        panel.add(oopsLabel);
        panel.add(oopsTextField);
        panel.add(dsLabel);
        panel.add(dsTextField);
        panel.add(new JLabel("Percentage:"));
        panel.add(percentageTextField);
        panel.add(new JLabel("Grade:"));
        panel.add(gradeTextField);
        panel.add(calculateButton);
        panel.add(resetButton);

        add(panel);
    }

    private void calculateGrade(ActionEvent event) {
        int osMarks = Integer.parseInt(osTextField.getText());
        int cnMarks = Integer.parseInt(cnTextField.getText());
        int dbmsMarks = Integer.parseInt(dbmsTextField.getText());
        int oopsMarks = Integer.parseInt(oopsTextField.getText());
        int dsMarks = Integer.parseInt(dsTextField.getText());

        int totalMarks = osMarks + cnMarks + dbmsMarks + oopsMarks + dsMarks;
        double averagePercentage = totalMarks / 5.0;
        String grade;

        if (averagePercentage >= 90) {
            grade = "A";
        } else if (averagePercentage >= 80) {
            grade = "B";
        } else if (averagePercentage >= 70) {
            grade = "C";
        } else if (averagePercentage >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }

        percentageTextField.setText(String.valueOf(averagePercentage) + "%");
        gradeTextField.setText(grade);
    }

    private void resetFields(ActionEvent event) {
        osTextField.setText("");
        cnTextField.setText("");
        dbmsTextField.setText("");
        oopsTextField.setText("");
        dsTextField.setText("");
        percentageTextField.setText("");
        gradeTextField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GradeCalculator().setVisible(true);
        });
    }
}
