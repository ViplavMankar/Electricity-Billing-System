package adminPackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class AdminAccountSettings {

	private JFrame frmAccountSettings;
	private JTextField AdminFirstName;
	private JPasswordField AdminPassword;
	private JTextField AdminLastName;
	private JTextField AdminPhoneNo;
	private JTextField AdminPincode;
	private JTextField AdminState;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminAccountSettings window = new AdminAccountSettings(args);
					window.frmAccountSettings.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminAccountSettings(String[] args) {
		initialize(args);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param args 
	 */
	private void initialize(String[] args) {
		frmAccountSettings = new JFrame();
		frmAccountSettings.setTitle("Account Settings");
		frmAccountSettings.setBounds(100, 100, 1063, 652);
		frmAccountSettings.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAccountSettings.getContentPane().setLayout(null);
		
		JButton BackButton = new JButton("Back");
		BackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmAccountSettings.dispose();
				AdminMainPage.main(args);
			}
		});
		BackButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		BackButton.setBounds(148, 62, 97, 25);
		frmAccountSettings.getContentPane().add(BackButton);
		
		JLabel label = new JLabel("Account Settings");
		label.setFont(new Font("Tahoma", Font.PLAIN, 30));
		label.setBounds(386, 41, 268, 54);
		frmAccountSettings.getContentPane().add(label);
		
		AdminFirstName = new JTextField();
		AdminFirstName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		AdminFirstName.setColumns(10);
		AdminFirstName.setBounds(197, 136, 311, 31);
		frmAccountSettings.getContentPane().add(AdminFirstName);
		
		JLabel label_1 = new JLabel("First Name");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_1.setBounds(88, 136, 97, 31);
		frmAccountSettings.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Password");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_2.setBounds(88, 245, 87, 31);
		frmAccountSettings.getContentPane().add(label_2);
		
		AdminPassword = new JPasswordField();
		AdminPassword.setBounds(197, 248, 311, 31);
		frmAccountSettings.getContentPane().add(AdminPassword);
		
		JLabel label_3 = new JLabel("Last Name");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_3.setBounds(88, 190, 111, 31);
		frmAccountSettings.getContentPane().add(label_3);
		
		AdminLastName = new JTextField();
		AdminLastName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		AdminLastName.setColumns(10);
		AdminLastName.setBounds(197, 190, 311, 31);
		frmAccountSettings.getContentPane().add(AdminLastName);
		
		JLabel label_5 = new JLabel("Phone No.");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_5.setBounds(88, 292, 87, 31);
		frmAccountSettings.getContentPane().add(label_5);
		
		AdminPhoneNo = new JTextField();
		AdminPhoneNo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		AdminPhoneNo.setColumns(10);
		AdminPhoneNo.setBounds(197, 292, 311, 31);
		frmAccountSettings.getContentPane().add(AdminPhoneNo);
		
		JLabel label_7 = new JLabel("Area");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_7.setBounds(411, 346, 59, 31);
		frmAccountSettings.getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("Pincode");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_8.setBounds(88, 346, 87, 31);
		frmAccountSettings.getContentPane().add(label_8);
		
		AdminPincode = new JTextField();
		AdminPincode.setFont(new Font("Tahoma", Font.PLAIN, 20));
		AdminPincode.setColumns(10);
		AdminPincode.setBounds(195, 346, 183, 31);
		frmAccountSettings.getContentPane().add(AdminPincode);
		
		AdminState = new JTextField();
		AdminState.setFont(new Font("Tahoma", Font.PLAIN, 20));
		AdminState.setColumns(10);
		AdminState.setBounds(195, 402, 183, 31);
		frmAccountSettings.getContentPane().add(AdminState);
		
		JLabel lblState = new JLabel("State");
		lblState.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblState.setBounds(88, 402, 87, 31);
		frmAccountSettings.getContentPane().add(lblState);
		
		JButton SubmitButton = new JButton("Submit");
		SubmitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmAccountSettings.dispose();
				AdminMainPage.main(args);
			}
		});
		SubmitButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		SubmitButton.setBounds(411, 477, 160, 31);
		frmAccountSettings.getContentPane().add(SubmitButton);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblCity.setBounds(411, 397, 87, 31);
		frmAccountSettings.getContentPane().add(lblCity);
		
		JComboBox<String> AdminArea = new JComboBox<String>();
		AdminArea.setFont(new Font("Tahoma", Font.PLAIN, 20));
		AdminArea.setBounds(482, 355, 172, 22);
		frmAccountSettings.getContentPane().add(AdminArea);
		try {
			Connection dropDownConn= DriverManager.getConnection("jdbc:mysql://localhost:3306/ElectricityBillingSystem","admin","Viplav@2000");
			Statement dropDownStmt= dropDownConn.createStatement();
			String sqlQuery= "select distinct area from Administrator";
			ResultSet dropDownRs= dropDownStmt.executeQuery(sqlQuery);
			String result;
			while(dropDownRs.next()) {
				result= dropDownRs.getString("area");
				AdminArea.addItem(result);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		JComboBox<String> AdminCity = new JComboBox<String>();
		AdminCity.setFont(new Font("Tahoma", Font.PLAIN, 20));
		AdminCity.setBounds(482, 404, 172, 22);
		frmAccountSettings.getContentPane().add(AdminCity);
		try {
			Connection dropdownConn= DriverManager.getConnection("jdbc:mysql://localhost:3306/ElectricityBillingSystem","admin","Viplav@2000");
			Statement dropdownStmt= dropdownConn.createStatement();
			String mysqlQuery= "select distinct city from Administrator";
			ResultSet dropdownRs= dropdownStmt.executeQuery(mysqlQuery);
			while(dropdownRs.next()) {
				AdminCity.addItem(dropdownRs.getString("city"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		JButton RefreshButton = new JButton("Refresh");
		RefreshButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Connection myConn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ElectricityBillingSystem","admin","Viplav@2000");
					System.out.println("Connection Successful");
					Statement myStmt=myConn.createStatement();
					String checkQuery="select ID,first_name,last_name,password from Administrator";
					ResultSet checkRs=myStmt.executeQuery(checkQuery);
					while(checkRs.next()) {
						if(checkRs.getString("first_name").equals(args[0]) && checkRs.getString("last_name").equals(args[1]) && checkRs.getString("password").equals(args[2])) {
							int id=checkRs.getInt("ID");
							PreparedStatement dataStmt= myConn.prepareStatement("select * from Administrator where ID=?");
							dataStmt.setInt(1,id);
							ResultSet dataRs= dataStmt.executeQuery();
							ResultSet Rs=dataRs;
							
							while(Rs.next()) {
							String firstName= Rs.getString("first_name");
							String lastName= Rs.getString("last_name");
							String password=Rs.getString("password");
							long phoneNo= Rs.getLong("phone");
							String area= Rs.getString("area");
							int pincode= Rs.getInt("pincode");
							String city= Rs.getString("city");
							String state= Rs.getString("state");
							AdminFirstName.setText(firstName);
							AdminLastName.setText(lastName);
							AdminPhoneNo.setText(""+phoneNo+"");
							AdminArea.setSelectedItem(area);
							AdminPincode.setText(""+pincode+"");
							AdminCity.setSelectedItem(city);
							AdminState.setText(state);
							AdminPassword.setText(password);
							}
						}
					}
				}
				catch(SQLException ex) {
					ex.printStackTrace();
				}
			}
		});
		RefreshButton.setBounds(762, 63, 97, 25);
		frmAccountSettings.getContentPane().add(RefreshButton);
	}
}
