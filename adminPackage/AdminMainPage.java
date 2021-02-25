package adminPackage;
import userPackage.UserBasePage;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;



import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class AdminMainPage {

	private JFrame frmMainPage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminMainPage window = new AdminMainPage(args);
					window.frmMainPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */

	public AdminMainPage(String[] args) {
		// TODO Auto-generated constructor stub
		initialize(args);
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String[] args) {
		frmMainPage = new JFrame();
		frmMainPage.setTitle("Main Page");
		frmMainPage.setBounds(100, 100, 1063, 668);
		frmMainPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMainPage.getContentPane().setLayout(null);
		
		JComboBox<String> AccountComboBox = new JComboBox<String>();
		AccountComboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		AccountComboBox.setBounds(105, 214, 188, 26);
		AccountComboBox.addItem("Main Page");
		AccountComboBox.addItem("Remove User");
		AccountComboBox.addItem("Account Updation");
		AccountComboBox.addItem("Delete Account");
		AccountComboBox.addItem("Logout");
		AccountComboBox.setSelectedIndex(0);
		frmMainPage.getContentPane().add(AccountComboBox);
		
		JButton BillCreationButton = new JButton("Bill Creation");
		BillCreationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmMainPage.dispose();
				BillCreation.main(args);
			}
		});
		BillCreationButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		BillCreationButton.setBounds(404, 210, 238, 35);
		frmMainPage.getContentPane().add(BillCreationButton);
		
		JButton AboutTheAppButton = new JButton("About The App");
		AboutTheAppButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		AboutTheAppButton.setBounds(742, 210, 188, 35);
		frmMainPage.getContentPane().add(AboutTheAppButton);
		
		JButton OkButton = new JButton("OK");
		OkButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String value=(String) AccountComboBox.getSelectedItem();
				switch(value) {
				case "Main Page" : break;
				case "Remove User" : 
										RemoveUser.main(args);
										frmMainPage.dispose();
										break;
				case "Account Updation" : AdminAccountSettings.main(args);
										frmMainPage.dispose();
										break;
				case "Delete Account" : 
										int a= JOptionPane.showConfirmDialog(frmMainPage, "Are you sure?"); 
										if(a==JOptionPane.YES_OPTION) {
											try{ 
												Connection myConn= DriverManager.getConnection("jdbc:mysql://localhost:3306/ElectricityBillingSystem","admin","Viplav@2000"); 
												Statement myStmt= myConn.createStatement();
												String sql= "delete from Administrator where first_name='"+args[0]+"' and last_name='"+args[1]+"'"; 
												myStmt.executeUpdate(sql);  
												JOptionPane.showMessageDialog(frmMainPage, "Account Deleted!"); 
											}
											catch(Exception e) { 
												e.printStackTrace(); 
											}
											UserBasePage.main(null); 
											frmMainPage.dispose(); 
										}
										break;
				case "Logout" : int b= JOptionPane.showConfirmDialog(frmMainPage, "Are you sure?");
								if(b==JOptionPane.YES_OPTION) {
									frmMainPage.dispose();
									AdminLogin.main(null);
								}
				}
			}
		});
		OkButton.setBounds(153, 269, 61, 25);
		frmMainPage.getContentPane().add(OkButton);
		
		JLabel label = new JLabel("Main Page");
		label.setFont(new Font("Tahoma", Font.PLAIN, 30));
		label.setBounds(439, 26, 175, 64);
		frmMainPage.getContentPane().add(label);
	}

}
