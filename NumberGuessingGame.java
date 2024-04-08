import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NumberGuessingGame extends JFrame implements ActionListener {
    private int randomNumber;
    private int attempts;
    //private int score;

    private JLabel titleLabel;
    private JTextField guessField;
    private JButton guessButton;
    private JTextArea feedbackArea;
    private JButton playAgainButton;

    public NumberGuessingGame() {
        super("Number Guessing Game");
        randomNumber = generateRandomNumber();
        attempts = 0;
        score = 0;

        titleLabel = new JLabel("Guess the number between 1 and 100:");
        guessField = new JTextField(10);
        guessButton = new JButton("Guess");
        feedbackArea = new JTextArea(10, 25);
        playAgainButton = new JButton("Play Again");

        guessButton.addActionListener(this);
        playAgainButton.addActionListener(this);

        setLayout(new FlowLayout());
        add(titleLabel);
        add(guessField);
        add(guessButton);
        add(feedbackArea);
        add(playAgainButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setVisible(true);
    }

    private int generateRandomNumber() {
        return (int) (Math.random() * 100) + 1;
    }

    private void checkGuess(int guess) {
        attempts++;
        if (guess == randomNumber) {
            score++;
            feedbackArea.append("Congratulations! You've guessed the number " + randomNumber + " in " + attempts + " attempts.\n");
            resetGame();
        } else if (guess < randomNumber) {
            feedbackArea.append("Too low! Try again.\n");
        } else {
            feedbackArea.append("Too high! Try again.\n");
        }
        guessField.setText("");
    }

    private void resetGame() {
        randomNumber = generateRandomNumber();
        attempts = 0;
        guessField.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == guessButton) {
            try {
                int guess = Integer.parseInt(guessField.getText());
                checkGuess(guess);
            } catch (NumberFormatException ex) {
                feedbackArea.append("Invalid input! Please enter a number.\n");
            }
        } else if (e.getSource() == playAgainButton) {
            feedbackArea.setText("");
            score = 0;
            resetGame();
        }
    }

    public static void main(String[] args) {
        new NumberGuessingGame();
    }
}
