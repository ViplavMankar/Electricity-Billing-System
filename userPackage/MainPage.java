package userPackage;



import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class MainPage {

	private JFrame frmMainPage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage window = new MainPage(args);
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

	public MainPage(String[] args) {
		// TODO Auto-generated constructor stub
		initialize(args);
	}

	private void initialize(String[] args) {
		// TODO Auto-generated method stub
		frmMainPage = new JFrame();
		frmMainPage.setTitle("Main Page");
		frmMainPage.setBounds(100, 100, 1115, 659);
		frmMainPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMainPage.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Main Page");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(459, 37, 175, 64);
		frmMainPage.getContentPane().add(lblNewLabel);
		
		JButton BillPaymentButton = new JButton("Bill Payments");
		BillPaymentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmMainPage.dispose();
				UserBillPayment.main(args);
			}
		});
		BillPaymentButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		BillPaymentButton.setBounds(421, 203, 238, 35);
		frmMainPage.getContentPane().add(BillPaymentButton);
		
		JButton AboutTheAppButton = new JButton("About The App");
		AboutTheAppButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		AboutTheAppButton.setBounds(761, 203, 188, 35);
		frmMainPage.getContentPane().add(AboutTheAppButton);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox.addItem("Main Page");
		comboBox.addItem("Account Updation");
		comboBox.addItem("Delete Account");
		comboBox.addItem("Logout");
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(106, 212, 188, 26);
		frmMainPage.getContentPane().add(comboBox);
		
		JButton OkButton = new JButton("OK");
		OkButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String value=(String) comboBox.getSelectedItem();
				switch(value) {
				case "Main Page" : break;
				case "Account Updation" : UserAccountSettings.main(args);
										frmMainPage.dispose();
										break;
				case "Delete Account" : 
										int a= JOptionPane.showConfirmDialog(frmMainPage, "Are you sure?");
										if(a==JOptionPane.YES_OPTION) {
											try{
												Connection myConn= DriverManager.getConnection("jdbc:mysql://localhost:3306/ElectricityBillingSystem","admin","Viplav@2000");
												Statement myStmt= myConn.createStatement();
												String sql= "delete from Customer where first_name='"+args[0]+"' and last_name='"+args[1]+"'";
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
									UserLogin.main(null);
								}
				}
			}
		});
		OkButton.setBounds(164, 262, 61, 25);
		frmMainPage.getContentPane().add(OkButton);
	}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	