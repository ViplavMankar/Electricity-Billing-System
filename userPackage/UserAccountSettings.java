package userPackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class UserAccountSettings {

	private JFrame frmAccountSettings;
	private JTextField UserFirstName;
	private JTextField UserLastName;
	private JTextField UserEmail;
	private JPasswordField UserPassword;
	private JTextField UserPhoneNo;
	private JTextField UserHouseNo;
	private JTextField UserPincode;
	private JTextField UserState;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		System.out.println("Successful");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserAccountSettings window = new UserAccountSettings(args);
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

	public UserAccountSettings(String[] args) {
		// TODO Auto-generated constructor stub
		initialize(args);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String[] args) {
		frmAccountSettings = new JFrame();
		frmAccountSettings.setTitle("Account Settings");
		frmAccountSettings.setBounds(100, 100, 1076, 674);
		frmAccountSettings.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAccountSettings.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Account Settings");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(394, 49, 268, 54);
		frmAccountSettings.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("First Name");
		label.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label.setBounds(96, 144, 97, 31);
		frmAccountSettings.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Password");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_1.setBounds(96, 193, 87, 31);
		frmAccountSettings.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Email");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_2.setBounds(96, 251, 87, 31);
		frmAccountSettings.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Phone No.");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_3.setBounds(96, 300, 87, 31);
		frmAccountSettings.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("House No.");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_4.setBounds(96, 354, 87, 31);
		frmAccountSettings.getContentPane().add(label_4);
		
		JLabel lblState = new JLabel("State");
		lblState.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblState.setBounds(96, 410, 87, 31);
		frmAccountSettings.getContentPane().add(lblState);
		
		JLabel label_6 = new JLabel("Area");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_6.setBounds(419, 354, 59, 31);
		frmAccountSettings.getContentPane().add(label_6);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblCity.setBounds(414, 410, 64, 31);
		frmAccountSettings.getContentPane().add(lblCity);
		
		JLabel label_8 = new JLabel("Pincode");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_8.setBounds(717, 354, 87, 31);
		frmAccountSettings.getContentPane().add(label_8);
		
		JLabel label_9 = new JLabel("Last Name");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_9.setBounds(539, 144, 111, 31);
		frmAccountSettings.getContentPane().add(label_9);
		
		
		JButton BackButton = new JButton("Back");
		BackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmAccountSettings.dispose();
				MainPage.main(args);
			}
		});
		BackButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		BackButton.setBounds(156, 70, 97, 25);
		frmAccountSettings.getContentPane().add(BackButton);
		
		UserFirstName = new JTextField();
		UserFirstName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		UserFirstName.setColumns(10);
		UserFirstName.setBounds(205, 144, 311, 31);
		frmAccountSettings.getContentPane().add(UserFirstName);
		
		UserLastName = new JTextField();
		UserLastName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		UserLastName.setColumns(10);
		UserLastName.setBounds(662, 144, 311, 31);
		frmAccountSettings.getContentPane().add(UserLastName);
		
		UserEmail = new JTextField();
		UserEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		UserEmail.setColumns(10);
		UserEmail.setBounds(205, 251, 311, 31);
		frmAccountSettings.getContentPane().add(UserEmail);
		
		UserPassword = new JPasswordField();
		UserPassword.setBounds(205, 200, 311, 31);
		frmAccountSettings.getContentPane().add(UserPassword);
		
		UserPhoneNo = new JTextField();
		UserPhoneNo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		UserPhoneNo.setColumns(10);
		UserPhoneNo.setBounds(205, 307, 311, 31);
		frmAccountSettings.getContentPane().add(UserPhoneNo);
		
		UserHouseNo = new JTextField();
		UserHouseNo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		UserHouseNo.setColumns(10);
		UserHouseNo.setBounds(203, 361, 183, 31);
		frmAccountSettings.getContentPane().add(UserEmail);
		
		UserPassword = new JPasswordField();
		UserPassword.setBounds(205, 200, 311, 31);
		frmAccountSettings.getContentPane().add(UserPassword);
		
		UserPhoneNo = new JTextField();
		UserPhoneNo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		UserPhoneNo.setColumns(10);
		UserPhoneNo.setBounds(205, 307, 311, 31);
		frmAccountSettings.getContentPane().add(UserPhoneNo);
		
		UserHouseNo = new JTextField();
		UserHouseNo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		UserHouseNo.setColumns(10);
		UserHouseNo.setBounds(203, 361, 183, 31);
		frmAccountSettings.getContentPane().add(UserHouseNo);
		
		UserPincode = new JTextField();
		UserPincode.setFont(new Font("Tahoma", Font.PLAIN, 20));
		UserPincode.setColumns(10);
		UserPincode.setBounds(816, 361, 183, 31);
		frmAccountSettings.getContentPane().add(UserPincode);
		
		UserState = new JTextField();
		UserState.setFont(new Font("Tahoma", Font.PLAIN, 20));
		UserState.setColumns(10);
		UserState.setBounds(203, 410, 183, 31);
		frmAccountSettings.getContentPane().add(UserState);
		
		JComboBox<String> UserArea = new JComboBox<String>();
		UserArea.setFont(new Font("Tahoma", Font.PLAIN, 20));
		UserArea.setBounds(490, 361, 175, 22);
		frmAccountSettings.getContentPane().add(UserArea);
		try {
			Connection dropDownConn= DriverManager.getConnection("jdbc:mysql://localhost:3306/ElectricityBillingSystem","admin","Viplav@2000");
			Statement dropDownStmt= dropDownConn.createStatement();
			String sqlQuery= "select distinct area from Customer";
			ResultSet dropDownRs= dropDownStmt.executeQuery(sqlQuery);
			String result;
			while(dropDownRs.next()) {
				result= dropDownRs.getString("area");
				UserArea.addItem(result);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		JComboBox<String> UserCity = new JComboBox<String>();
		UserCity.setFont(new Font("Tahoma", Font.PLAIN, 20));
		UserCity.setBounds(490, 417, 175, 22);
		frmAccountSettings.getContentPane().add(UserCity);
		try {
			Connection dropdownConn= DriverManager.getConnection("jdbc:mysql://localhost:3306/ElectricityBillingSystem","admin","Viplav@2000");
			Statement dropdownStmt= dropdownConn.createStatement();
			String mysqlQuery= "select distinct city from Customer";
			ResultSet dropdownRs= dropdownStmt.executeQuery(mysqlQuery);
			while(dropdownRs.next()) {
				UserCity.addItem(dropdownRs.getString("city"));
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
					String checkQuery="select ID,first_name,last_name,password from Customer";
					ResultSet checkRs=myStmt.executeQuery(checkQuery);
					while(checkRs.next()) {
						if(checkRs.getString("first_name").equals(args[0]) && checkRs.getString("last_name").equals(args[1]) && checkRs.getString("password").equals(args[2])) {
							int id=checkRs.getInt("ID");
							PreparedStatement dataStmt= myConn.prepareStatement("select * from Customer where ID=?");
							dataStmt.setInt(1,id);
							ResultSet dataRs= dataStmt.executeQuery();
							ResultSet Rs=dataRs;
							
							while(Rs.next()) {
							String firstName= Rs.getString("first_name");
							String lastName= Rs.getString("last_name");
							String password=Rs.getString("password");
							String email= Rs.getString("email");
							long phoneNo= Rs.getLong("phone");
							int houseNo= Rs.getInt("house_no");
							String area= Rs.getString("area");
							int pincode= Rs.getInt("pincode");
							String city= Rs.getString("city");
							String state= Rs.getString("state");
							UserFirstName.setText(firstName);
							UserLastName.setText(lastName);
							UserEmail.setText(email);
							UserPhoneNo.setText(""+phoneNo+"");
							UserHouseNo.setText(""+houseNo+"");
							UserArea.setSelectedItem(area);
							UserPincode.setText(""+pincode+"");
							UserCity.setSelectedItem(city);
							UserState.setText(state);
							UserPassword.setText(password);
							}
						}
					}
				}
				catch(SQLException ex) {
					ex.printStackTrace();
				}
			}
		});
		RefreshButton.setBounds(770, 71, 97, 25);
		frmAccountSettings.getContentPane().add(RefreshButton);
		
		JButton SubmitButton = new JButton("Submit");
		SubmitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String firstName=UserFirstName.getText();
					String lastName=UserLastName.getText();
					String email=UserEmail.getText();
					String phoneStr=UserPhoneNo.getText();
					long phoneNo=Long.parseLong(phoneStr);
					String houseStr=UserHouseNo.getText();
					int houseNo=Integer.parseInt(houseStr);
					String area= (String) UserArea.getSelectedItem();
					String pincodeStr=UserPincode.getText();
					int pincode=Integer.parseInt(pincodeStr);
					String city=(String) UserCity.getSelectedItem();
					String state=UserState.getText();
					User newUser=new User();
					@SuppressWarnings("deprecation")
					String password=UserPassword.getText();
					newUser.createUser(firstName, lastName, email, phoneNo, houseNo, area, city, state, pincode,password);
					
					Connection myConn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ElectricityBillingSystem","admin","Viplav@2000");
					System.out.println("Connection Successful");
					Statement myStmt=myConn.createStatement();
					String sql="insert into Customer"
							+ "(first_name,last_name,pincode,phone,password,email,house_no,area,city,state)"
							+" values('"+firstName+"','"+lastName+"','"+pincode+"','"+phoneNo+"','"+password+"','"+email+"','"+houseNo+"','"+area+"','"+city+"','"+state+"')";
					myStmt.executeUpdate(sql);
					System.out.println("Update Complete");
					String[] parameters= new String[3];
					parameters[0]=firstName;
					parameters[1]=lastName;
					parameters[2]=password;
					Statement stmt= myConn.createStatement();
					String mysql="select ID from Administrator where area='"+area+"'";
					int id;
					ResultSet myRs=stmt.executeQuery(mysql);
					while(myRs.next()) {
						 id= myRs.getInt("ID");
					}
					Statement newstmt= myConn.createStatement();
					String newsql= "update Admin_id";
					frmAccountSettings.dispose();
					MainPage.main(parameters);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Complete");
				return;
			}
		});
		SubmitButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		SubmitButton.setBounds(419, 485, 160, 31);
		frmAccountSettings.getContentPane().add(SubmitButton);
		
	}
}
