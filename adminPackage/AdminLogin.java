package adminPackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;

import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class AdminLogin {

	private JFrame frmAdminLogin;
	private JTextField AdminFirstName;
	private JTextField AdminLastName;
	private JPasswordField AdminPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin window = new AdminLogin();
					window.frmAdminLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdminLogin = new JFrame();
		frmAdminLogin.setTitle("Admin Login");
		frmAdminLogin.setBounds(100, 100, 913, 557);
		frmAdminLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdminLogin.getContentPane().setLayout(null);
		
		JLabel lblAdminLogin = new JLabel("Admin Login");
		lblAdminLogin.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblAdminLogin.setBounds(370, 32, 173, 46);
		frmAdminLogin.getContentPane().add(lblAdminLogin);
		
		JButton BackButton = new JButton("Back");
		BackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmAdminLogin.dispose();
				AdminBasePage.main(null);
			}
		});
		BackButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		BackButton.setBounds(91, 50, 97, 28);
		frmAdminLogin.getContentPane().add(BackButton);
		
		JLabel label_1 = new JLabel("First Name");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_1.setBounds(127, 186, 97, 22);
		frmAdminLogin.getContentPane().add(label_1);
		
		AdminFirstName = new JTextField();
		AdminFirstName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		AdminFirstName.setColumns(10);
		AdminFirstName.setBounds(249, 173, 350, 38);
		frmAdminLogin.getContentPane().add(AdminFirstName);
		
		JLabel label_2 = new JLabel("Last Name");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_2.setBounds(127, 237, 97, 25);
		frmAdminLogin.getContentPane().add(label_2);
		
		AdminLastName = new JTextField();
		AdminLastName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		AdminLastName.setColumns(10);
		AdminLastName.setBounds(249, 224, 350, 38);
		frmAdminLogin.getContentPane().add(AdminLastName);
		
		JLabel label_3 = new JLabel("Password");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_3.setBounds(140, 290, 97, 22);
		frmAdminLogin.getContentPane().add(label_3);
		
		AdminPassword = new JPasswordField();
		AdminPassword.setToolTipText("");
		AdminPassword.setBounds(249, 285, 350, 38);
		frmAdminLogin.getContentPane().add(AdminPassword);
		
		JButton LoginButton = new JButton("Login");
		LoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String firstName= AdminFirstName.getText();
				String lastName= AdminLastName.getText();
				@SuppressWarnings("deprecation")
				String password= AdminPassword.getText();
				try {
					Connection myConn= DriverManager.getConnection("jdbc:mysql://localhost:3306/ElectricityBillingSystem","admin","Viplav@2000");
					Statement myStmt= myConn.createStatement();
					String sql= "select first_name,last_name,password from Administrator";
					ResultSet myRs=myStmt.executeQuery(sql);
					boolean flag=false;
					while(myRs.next()) {
						if(myRs.getString("first_name").equals(firstName) && myRs.getString("last_name").equals(lastName) && myRs.getString("password").equals(password)) {
							flag=true;
							String[] parameters= new String[3];
							parameters[0]=firstName;
							parameters[1]=lastName;
							parameters[2]=password;
							AdminMainPage.main(parameters);
							frmAdminLogin.dispose();
						}
					}
					if(flag==false) {
						JOptionPane.showMessageDialog(frmAdminLogin, "Invalid Details");
					}
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
		});
		LoginButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		LoginButton.setBounds(372, 380, 97, 38);
		frmAdminLogin.getContentPane().add(LoginButton);
	}

}
