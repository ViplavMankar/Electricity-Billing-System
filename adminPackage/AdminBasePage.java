package adminPackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminBasePage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminBasePage window = new AdminBasePage();
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
	public AdminBasePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 890, 498);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Online Billing System");
		label.setFont(new Font("Tahoma", Font.BOLD, 30));
		label.setBounds(248, 13, 368, 92);
		frame.getContentPane().add(label);
		
		JButton button = new JButton("Create New Account");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				AdminAccountCreate.main(null);
			}
		});
		button.setBounds(186, 279, 167, 39);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("Signup to Existing Account");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				AdminLogin.main(null);
			}
		});
		button_1.setBounds(472, 279, 220, 39);
		frame.getContentPane().add(button_1);
	}

}
