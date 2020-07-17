import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuessingGame extends JFrame {
	private JTextField txtGuess;
	private  JLabel lblOutput;
	private JLabel lblInsertedVal;
	private int theNumber;
	private int numberOfTries = 0;
	private JButton btnPlayAgain;
	private JButton btnNewButton;
	public void checkGuess() {
		String guessText = txtGuess.getText();
		numberOfTries ++;
		// show current value
		lblInsertedVal.setText("Inserted value: " + guessText);
		String message = "";
		try
		{
			int guess = Integer.parseInt(guessText);
			if (guess < theNumber) {
				message = guess + " is too low. Please try again.";
			} else if (guess > theNumber) {
				message = guess + " is too high. Please try again.";
			} else {
				message = "You win! Let's play again! Count of tries is: " + numberOfTries;
				btnNewButton.setVisible(false);
				btnPlayAgain.setVisible(true);
			}
		} catch (NumberFormatException e) {
			lblInsertedVal.setText("Inserted value should be string, but was: " + guessText);
		} finally {
			lblOutput.setText(message);
			txtGuess.requestFocus();
			txtGuess.selectAll();
		}
	}
	public void newGame() {
		theNumber = (int) (Math.random() * 100 + 1);
		btnNewButton.setVisible(true);
		btnPlayAgain.setVisible(false);
	}
	public GuessingGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("HiLo Guessing Game");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(139, 57, 172, 16);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Guess a number between 0 and 100:");
		lblNewLabel_1.setBounds(46, 85, 228, 16);
		getContentPane().add(lblNewLabel_1);
		
		txtGuess = new JTextField();
		txtGuess.setBounds(296, 77, 130, 26);
		getContentPane().add(txtGuess);
		txtGuess.setColumns(10);
		txtGuess.addActionListener(l -> checkGuess());
		
		btnNewButton = new JButton("Guess");
		btnNewButton.addActionListener(e -> checkGuess());
		/*btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});*/
		btnNewButton.setBounds(175, 135, 117, 29);
		getContentPane().add(btnNewButton);
		btnNewButton.setVisible(false);
		
		lblOutput = new JLabel("Enter a number above and click Guess!");
		lblOutput.setBounds(19, 181, 425, 16);
		getContentPane().add(lblOutput);
		
		lblInsertedVal = new JLabel("Inserted value: ");
		lblInsertedVal.setBounds(56, 113, 371, 16);
		getContentPane().add(lblInsertedVal);
		
		btnPlayAgain = new JButton("Play Again");
		btnPlayAgain.setBounds(175, 219, 117, 29);
		getContentPane().add(btnPlayAgain);
		btnPlayAgain.setVisible(false);
		btnPlayAgain.addActionListener(e -> newGame());
	}
	public static void main(String[] args) {
		GuessingGame theGame = new GuessingGame();
		theGame.newGame();
		theGame.setSize(new Dimension(450, 300));
		theGame.setVisible(true);
		
	}
}
