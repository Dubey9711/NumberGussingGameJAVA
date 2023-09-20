
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class NumberGuessingGame {

    private int randomNumber;
    private int attempts = 0;

    private JFrame frame;
    private JPanel panel;
    private JTextField textField;
    private JLabel label;
    private JButton button;

    public NumberGuessingGame() {
        Random random = new Random();
        randomNumber = random.nextInt(100) + 1; // Generate random number between 1 and 100

        frame = new JFrame("Number Guessing Game");
        panel = new JPanel();
        label = new JLabel("Enter your guess:");
        textField = new JTextField(10);
        button = new JButton("Guess");

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkGuess();
            }
        });

        panel.add(label);
        panel.add(textField);
        panel.add(button);

        frame.add(panel);
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private void checkGuess() {
        String userInput = textField.getText();
        int userGuess = Integer.parseInt(userInput);

        String message;
        attempts++;

        if(attempts<=10)
        {

            if (userGuess < randomNumber) {
                message = "Too low! Try again.";
            } else if (userGuess > randomNumber) {
                message = "Too high! Try again.";
            } else {
                message = "Congratulations! You guessed the number in " + attempts + " attempts.";
                button.setEnabled(false);
            }
        }
        else
        {
            message = "Sorry you used maximum guesses. \n    TRY AGAIN LATER ";
            button.setEnabled(false);
        }

        JOptionPane.showMessageDialog(frame, message);
        textField.setText("");
    }

    public static void main(String[] args) {
        new NumberGuessingGame();
    }
}
