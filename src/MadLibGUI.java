import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class MadLibGUI extends JFrame {
	private JTextField txtAdjective;
	private JTextField txtVerb;
	private JTextField txtColor;
	private JTextField txtNoun;
	private JLabel lblOutput;
	public void buildJoke() {
		
		String jokeText = "The pink " + txtColor.getText() + " dragon " + 
				txtVerb.getText() + " at the " + txtAdjective.getText() 
				+ " " + txtNoun.getText();
		lblOutput.setText(jokeText);
	}
	public MadLibGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblAdjective = new JLabel("Adjective");
		lblAdjective.setBounds(34, 64, 61, 16);
		
		JLabel lblVerb = new JLabel("Verb in past");
		lblVerb.setBounds(34, 143, 85, 16);
		
		JLabel lblColor = new JLabel("Color");
		lblColor.setBounds(264, 64, 61, 16);
		
		JLabel lblNoun = new JLabel("Noun");
		lblNoun.setBounds(272, 143, 61, 16);
		
		JButton btnNewButton = new JButton("Press here to generate phrase!");
		btnNewButton.setBounds(104, 194, 233, 29);
		btnNewButton.addActionListener(e -> buildJoke());
		
		txtAdjective = new JTextField();
		txtAdjective.setBounds(122, 59, 101, 26);
		txtAdjective.setColumns(10);
		
		txtVerb = new JTextField();
		txtVerb.setBounds(131, 138, 85, 26);
		txtVerb.setColumns(10);
		
		txtColor = new JTextField();
		txtColor.setBounds(343, 59, 95, 26);
		txtColor.setColumns(10);
		
		txtNoun = new JTextField();
		txtNoun.setBounds(345, 138, 85, 26);
		txtNoun.setColumns(10);
		getContentPane().setLayout(null);
		getContentPane().add(txtAdjective);
		getContentPane().add(txtVerb);
		getContentPane().add(txtColor);
		getContentPane().add(txtNoun);
		getContentPane().add(lblAdjective);
		getContentPane().add(lblColor);
		getContentPane().add(lblVerb);
		getContentPane().add(lblNoun);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Doctor Payne's Wacky MadLibs App");
		lblNewLabel.setBounds(25, 20, 375, 16);
		getContentPane().add(lblNewLabel);
		
		lblOutput = new JLabel();
		lblOutput.setBounds(19, 181, 425, 16);
		getContentPane().add(lblOutput);
	}
	public static void main(String[] args) {
		MadLibGUI joke = new MadLibGUI();
		joke.setSize(new Dimension(450, 300));
		joke.setVisible(true);
		
	}
}
