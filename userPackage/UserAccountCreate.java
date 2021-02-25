package userPackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import java.sql.*;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

class User{
	private String firstName;
	private String lastName;
	private String email;
	private long phoneNo;
	private int houseNo;
	private String area;
	private String city;
	private String state;
	private int pincode;
	private String password;
	
	public User createUser(String firstName,String lastName,String email,long phoneNo,int houseNo,String area,String city,String state,int pincode,String password) {
		User newUser=new User();
		newUser.firstName=firstName;
		newUser.lastName=lastName;
		newUser.email=email;
		newUser.phoneNo=phoneNo;
		newUser.houseNo=houseNo;
		newUser.area=area;
		newUser.city=city;
		newUser.state=state;
		newUser.pincode=pincode;
		newUser.password=password;
		return newUser;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getEmail() {
		return email;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public int getHouseNo() {
		return houseNo;
	}
	public String getArea() {
		return area;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public int getPincode() {
		return pincode;
	}
	public void setFirstName(String firstName) {
		this.firstName=firstName;
	}
	public void setLastName(String lastName) {
		this.lastName=lastName;
	}
	public void setEmail(String email) {
		this.email=email;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo=phoneNo;
	}
	public void setHouseNo(int houseNo) {
		this.houseNo=houseNo;
	}
	public void setArea(String area) {
		this.area=area;
	}
	public void setCity(String city) {
		this.city=city;
	}
	public void setState(String state) {
		this.state=state;
	}
	public void setPincode(int pincode) {
		this.pincode=pincode;
	}
}
public class UserAccountCreate {

	public JFrame frame;
	private JTextField UserFirstName;
	private JTextField UserLastName;
	private JTextField UserEmail;
	private JTextField UserPhoneNo;
	private JTextField UserHouseNo;
	private JTextField UserPincode;
	private JTextField UserCity;
	private JButton BackButton;
	private JPasswordField UserPassword;
	private JLabel lblNewLabel_1;
	private JLabel lblFirstName;
	private JLabel lblLastName;
	private JLabel lblEmail;
	private JLabel lblPhoneNo;
	private JLabel lblHouseNo;
	private JLabel lblArea;
	private JLabel lblPincode;
	private JLabel lblCity;
	private JLabel lblState;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserAccountCreate window = new UserAccountCreate();
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
	public UserAccountCreate() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1032, 608);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Account Creation");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(372, 45, 246, 67);
		frame.getContentPane().add(lblNewLabel);
		
		UserFirstName = new JTextField();
		UserFirstName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		UserFirstName.setBounds(145, 147, 311, 31);
		frame.getContentPane().add(UserFirstName);
		UserFirstName.setColumns(10);
		
		UserLastName = new JTextField();
		UserLastName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		UserLastName.setBounds(586, 147, 311, 31);
		frame.getContentPane().add(UserLastName);
		UserLastName.setColumns(10);
		
		UserEmail = new JTextField();
		UserEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		UserEmail.setBounds(145, 254, 311, 31);
		frame.getContentPane().add(UserEmail);
		UserEmail.setColumns(10);
		
		UserPhoneNo = new JTextField();
		UserPhoneNo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		UserPhoneNo.setColumns(10);
		UserPhoneNo.setBounds(145, 303, 311, 31);
		frame.getContentPane().add(UserPhoneNo);
		
		UserHouseNo = new JTextField();
		UserHouseNo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		UserHouseNo.setColumns(10);
		UserHouseNo.setBounds(145, 357, 183, 31);
		frame.getContentPane().add(UserHouseNo);

		
		UserPincode = new JTextField();
		UserPincode.setFont(new Font("Tahoma", Font.PLAIN, 20));
		UserPincode.setColumns(10);
		UserPincode.setBounds(756, 357, 169, 31);
		frame.getContentPane().add(UserPincode);
		
		UserCity = new JTextField();
		UserCity.setFont(new Font("Tahoma", Font.PLAIN, 20));
		UserCity.setColumns(10);
		UserCity.setBounds(145, 413, 188, 31);
		frame.getContentPane().add(UserCity);
		
		BackButton = new JButton("Back");
		BackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				UserBasePage.main(null);
			}
		});
		BackButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		BackButton.setBounds(96, 73, 97, 25);
		frame.getContentPane().add(BackButton);
		
		UserPassword = new JPasswordField();
		UserPassword.setBounds(145, 196, 311, 31);
		frame.getContentPane().add(UserPassword);
		
		lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_1.setBounds(36, 196, 87, 31);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblFirstName.setBounds(36, 147, 97, 31);
		frame.getContentPane().add(lblFirstName);
		
		lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblLastName.setBounds(479, 147, 111, 31);
		frame.getContentPane().add(lblLastName);
		
		lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblEmail.setBounds(36, 254, 87, 31);
		frame.getContentPane().add(lblEmail);
		
		lblPhoneNo = new JLabel("Phone No.");
		lblPhoneNo.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblPhoneNo.setBounds(36, 303, 87, 31);
		frame.getContentPane().add(lblPhoneNo);
		
		lblHouseNo = new JLabel("House No.");
		lblHouseNo.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblHouseNo.setBounds(36, 357, 87, 31);
		frame.getContentPane().add(lblHouseNo);
		
		lblArea = new JLabel("Area");
		lblArea.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblArea.setBounds(359, 357, 59, 31);
		frame.getContentPane().add(lblArea);
		
		lblPincode = new JLabel("Pincode");
		lblPincode.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblPincode.setBounds(657, 357, 87, 31);
		frame.getContentPane().add(lblPincode);
		
		lblCity = new JLabel("State");
		lblCity.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblCity.setBounds(36, 413, 87, 31);
		frame.getContentPane().add(lblCity);
		
		lblState = new JLabel("City");
		lblState.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblState.setBounds(369, 413, 44, 31);
		frame.getContentPane().add(lblState);
		
		JComboBox<String> UserState = new JComboBox<String>();
		UserState.setFont(new Font("Tahoma", Font.PLAIN, 20));
		UserState.setBounds(430, 413, 188, 29);
		frame.getContentPane().add(UserState);
		try {
			Connection dropdownConn= DriverManager.getConnection("jdbc:mysql://localhost:3306/ElectricityBillingSystem","admin","Viplav@2000");
			Statement dropdownStmt= dropdownConn.createStatement();
			String mysqlQuery= "select distinct city from Customer";
			ResultSet dropdownRs= dropdownStmt.executeQuery(mysqlQuery);
			while(dropdownRs.next()) {
				UserState.addItem(dropdownRs.getString("city"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		JComboBox<String> UserArea = new JComboBox<String>();
		UserArea.setFont(new Font("Tahoma", Font.PLAIN, 20));
		UserArea.setBounds(430, 355, 188, 31);
		frame.getContentPane().add(UserArea);
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
		
		
		JButton CreateAccountButton = new JButton("Create Account");
		CreateAccountButton.addActionListener(new ActionListener() {
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
					String city=UserCity.getText();
					String state=(String) UserState.getSelectedItem();
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
					int id = 0;
					ResultSet myRs=stmt.executeQuery(mysql);
					while(myRs.next()) {
						 id= myRs.getInt("ID");
					}
					Statement newstmt= myConn.createStatement();
					String newsql= "update Customer set Admin_id='"+id+"'where area='"+area+"'";
					stmt.executeUpdate(newsql);
					
					MainPage.main(parameters);
					frame.dispose();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Complete");
				return;
			}
		});
		CreateAccountButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		CreateAccountButton.setBounds(430, 482, 160, 31);
		frame.getContentPane().add(CreateAccountButton);
	}

}
