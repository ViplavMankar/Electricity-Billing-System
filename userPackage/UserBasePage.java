package userPackage;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserBasePage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserBasePage window = new UserBasePage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UserBasePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 100, 854, 585);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Online Billing System");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(266, 29, 368, 92);
		frame.getContentPane().add(lblNewLabel);
		
		JButton CreateAccountButton = new JButton("Create New Account");
		CreateAccountButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		CreateAccountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				UserAccountCreate.main(null);			
			}
		});
		CreateAccountButton.setBounds(164, 295, 207, 39);
		frame.getContentPane().add(CreateAccountButton);
		
		JButton SignUpButton = new JButton("Signup to Existing Account");
		SignUpButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		SignUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				UserLogin.main(null);
			}
		});
		SignUpButton.setBounds(490, 295, 245, 39);
		frame.getContentPane().add(SignUpButton);
	}
}
