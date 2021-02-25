package userPackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import java.sql.*;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class UserLogin {

	private JFrame frmUserLogin;
	private JTextField UserFirstName;
	private JTextField UserLastName;
	private JPasswordField UserPassword;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserLogin window = new UserLogin();
					window.frmUserLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UserLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUserLogin = new JFrame();
		frmUserLogin.setTitle("User Login");
		frmUserLogin.setBounds(100, 100, 918, 534);
		frmUserLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUserLogin.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User Login");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(366, 30, 173, 46);
		frmUserLogin.getContentPane().add(lblNewLabel);
		
		UserFirstName = new JTextField();
		UserFirstName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		UserFirstName.setBounds(245, 171, 350, 38);
		frmUserLogin.getContentPane().add(UserFirstName);
		UserFirstName.setColumns(10);
		
		
		UserLastName = new JTextField();
		UserLastName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		UserLastName.setBounds(245, 222, 350, 38);
		frmUserLogin.getContentPane().add(UserLastName);
		UserLastName.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String firstName= UserFirstName.getText();
				String lastName= UserLastName.getText();
				@SuppressWarnings("deprecation")
				String password= UserPassword.getText();
				try {
					Connection myConn= DriverManager.getConnection("jdbc:mysql://localhost:3306/ElectricityBillingSystem","admin","Viplav@2000");
					Statement myStmt= myConn.createStatement();
					String sql= "select first_name,last_name,password from Customer";
					ResultSet myRs=myStmt.executeQuery(sql);
					boolean flag=false;
					while(myRs.next()) {
						if(myRs.getString("first_name").equals(firstName) && myRs.getString("last_name").equals(lastName) && myRs.getString("password").equals(password)) {
							flag=true;
							String[] parameters= new String[3];
							parameters[0]=firstName;
							parameters[1]=lastName;
							parameters[2]=password;
							MainPage.main(parameters);
							frmUserLogin.dispose();
						}
					}
					if(flag==false) {
						JOptionPane.showMessageDialog(frmUserLogin, "Invalid Details");
					}
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(368, 378, 97, 38);
		frmUserLogin.getContentPane().add(btnNewButton);
		
		JButton BackButton = new JButton("Back");
		BackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmUserLogin.dispose();
				UserBasePage.main(null);
			}
		});
		BackButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		BackButton.setBounds(87, 48, 97, 28);
		frmUserLogin.getContentPane().add(BackButton);
		
		UserPassword = new JPasswordField();
		UserPassword.setToolTipText("");
		UserPassword.setBounds(245, 283, 350, 38);
		frmUserLogin.getContentPane().add(UserPassword);
		
		lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(136, 288, 97, 22);
		frmUserLogin.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Last Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(123, 235, 97, 25);
		frmUserLogin.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("First Name");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(123, 184, 97, 22);
		frmUserLogin.getContentPane().add(lblNewLabel_3);
	}
}
