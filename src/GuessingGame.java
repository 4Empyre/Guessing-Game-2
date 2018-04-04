import javax.swing.JFrame;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuessingGame extends JFrame {
	private JTextField txtGuess;
	private JLabel lblOutput;
	private int theNumber;
	public int numberOfTries;
	public void checkGuess() {
		String guessText = txtGuess.getText();
		String message = "";
		try {
			int guess = Integer.parseInt(guessText);
			if (guess < theNumber)
				message = guess + " is too low. Punk ass bitch.";
			else if (guess > theNumber)
				message = guess + " is too high. How low can you go?";
			else {
				message = "Holy sheeit! " + guess + " is right, and it only took you " + numberOfTries + " mutha-fuckin tries. Try Again!";
				newGame();
			}
		} catch (Exception e) {
			message = "Numbers between 1 and 100 ONLY, ya dumb-dumb.";
		} finally {
			lblOutput.setText(message);
			txtGuess.requestFocus();
			txtGuess.selectAll();
		}
	}
	public void newGame() {
		theNumber = (int)(Math.random() * 100 + 1);
		numberOfTries = 0;
	}
	public GuessingGame() {
		setFont(new Font("Dialog", Font.PLAIN, 12));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Empyre's Guessing Game To End All Games");
		getContentPane().setLayout(null);

		JLabel lblTitle = new JLabel("Empyre's Guessing Game To End All Games");
		lblTitle.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 14));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(10, 14, 414, 25);
		getContentPane().add(lblTitle);

		JLabel lbl01 = new JLabel("I challenge thee! To pick a number, not between 1 and 3. \r\n");
		lbl01.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl01.setHorizontalAlignment(SwingConstants.CENTER);
		lbl01.setBounds(20, 53, 414, 14);
		getContentPane().add(lbl01);

		JLabel lbl02 = new JLabel("But much higher, and rounded. Up to 100, from 1 being grounded. ");
		lbl02.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl02.setHorizontalAlignment(SwingConstants.CENTER);
		lbl02.setBounds(20, 81, 414, 14);
		getContentPane().add(lbl02);

		JLabel lbl04 = new JLabel("If you think you can be the best, a perfect score is 7 tries or less.");
		lbl04.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl04.setHorizontalAlignment(SwingConstants.CENTER);
		lbl04.setBounds(20, 106, 414, 14);
		getContentPane().add(lbl04);

		txtGuess = new JTextField();
		txtGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
				numberOfTries = numberOfTries + 1;
			}
		});
		txtGuess.setHorizontalAlignment(SwingConstants.CENTER);
		txtGuess.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtGuess.setBounds(195, 162, 39, 31);
		getContentPane().add(txtGuess);
		txtGuess.setColumns(10);

		JButton btnGuess = new JButton("Guess!");
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		btnGuess.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGuess.setBounds(287, 162, 91, 31);
		getContentPane().add(btnGuess);

		lblOutput = new JLabel("Enter a number between 1 and 100 above and click the Guess button.");
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblOutput.setBounds(10, 210, 414, 14);
		getContentPane().add(lblOutput);
	}

	public static void main(String[] args) {
		GuessingGame theGame = new GuessingGame();
		theGame.newGame();
		theGame.setSize(new Dimension(450,300));
		theGame.setVisible(true);
	}
}
