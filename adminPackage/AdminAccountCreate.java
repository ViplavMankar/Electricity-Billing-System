package adminPackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;

import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

class Admin{
	private String firstName;
	private String lastName;
	
	private long phoneNo;
	
	private String area;
	private String city;
	private String state;
	private int pincode;
	private String password;
	
	public Admin createUser(String firstName,String lastName,long phoneNo,String area,String city,String state,int pincode,String password) {
		Admin newUser=new Admin();
		newUser.firstName=firstName;
		newUser.lastName=lastName;
		
		newUser.phoneNo=phoneNo;
		
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
	
	public long getPhoneNo() {
		return phoneNo;
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
	
	public void setPhoneNo(long phoneNo) {
		this.phoneNo=phoneNo;
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

public class AdminAccountCreate {

	private JFrame frmAccountcreation;
	private JTextField AdminFirstName;
	private JPasswordField AdminPassword;
	
	private JTextField AdminPhoneNo;
	
	private JTextField AdminState;
	private JTextField AdminPincode;
	private JTextField AdminLastName;
	private JTextField UserPhoneNo;

	/**
	 * Launch tPhoneNo;
	private JTextField AdminHouseNo;
	private JTextField AdminState;
	private JTextField AdminPincode;
	private JTextField AdminLastName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminAccountCreate window = new AdminAccountCreate();
					window.frmAccountcreation.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminAccountCreate() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAccountcreation = new JFrame();
		frmAccountcreation.setTitle("AccountCreation");
		frmAccountcreation.setBounds(100, 100, 1060, 656);
		frmAccountcreation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAccountcreation.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("First Name");
		label.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label.setBounds(63, 126, 97, 31);
		frmAccountcreation.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Password");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_1.setBounds(63, 175, 87, 31);
		frmAccountcreation.getContentPane().add(label_1);
		
		JLabel label_3 = new JLabel("Phone No.");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_3.setBounds(63, 282, 87, 31);
		frmAccountcreation.getContentPane().add(label_3);
		
		JLabel label_5 = new JLabel("State");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_5.setBounds(63, 392, 87, 31);
		frmAccountcreation.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("City");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_6.setBounds(396, 392, 44, 31);
		frmAccountcreation.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("Area");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_7.setBounds(386, 336, 59, 31);
		frmAccountcreation.getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("Pincode");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_8.setBounds(63, 336, 87, 31);
		frmAccountcreation.getContentPane().add(label_8);
		
		JLabel label_9 = new JLabel("Last Name");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_9.setBounds(506, 126, 111, 31);
		frmAccountcreation.getContentPane().add(label_9);
		
		JLabel label_10 = new JLabel("Account Creation");
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 30));
		label_10.setBounds(399, 24, 246, 67);
		frmAccountcreation.getContentPane().add(label_10);
		
		
		AdminFirstName = new JTextField();
		AdminFirstName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		AdminFirstName.setColumns(10);
		AdminFirstName.setBounds(169, 126, 311, 31);
		frmAccountcreation.getContentPane().add(AdminFirstName);
		
		AdminPassword = new JPasswordField();
		AdminPassword.setBounds(169, 175, 311, 31);
		frmAccountcreation.getContentPane().add(AdminPassword);
		
		AdminState = new JTextField();
		AdminState.setFont(new Font("Tahoma", Font.PLAIN, 20));
		AdminState.setColumns(10);
		AdminState.setBounds(169, 392, 188, 31);
		frmAccountcreation.getContentPane().add(AdminState);
		
		AdminPincode = new JTextField();
		AdminPincode.setFont(new Font("Tahoma", Font.PLAIN, 20));
		AdminPincode.setColumns(10);
		AdminPincode.setBounds(169, 336, 169, 31);
		frmAccountcreation.getContentPane().add(AdminPincode);
		
		AdminLastName = new JTextField();
		AdminLastName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		AdminLastName.setColumns(10);
		AdminLastName.setBounds(610, 126, 311, 31);
		frmAccountcreation.getContentPane().add(AdminLastName);
		
		AdminPhoneNo = new JTextField();
		AdminPhoneNo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		AdminPhoneNo.setColumns(10);
		AdminPhoneNo.setBounds(169, 282, 311, 31);
		frmAccountcreation.getContentPane().add(AdminPhoneNo);
		
		JComboBox<String> AdminArea = new JComboBox<String>();
		AdminArea.setFont(new Font("Tahoma", Font.PLAIN, 20));
		AdminArea.setBounds(454, 334, 188, 31);
		frmAccountcreation.getContentPane().add(AdminArea);
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
		AdminCity.setBounds(454, 392, 188, 29);
		frmAccountcreation.getContentPane().add(AdminCity);
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
		
		JButton BackButton = new JButton("Back");
		BackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmAccountcreation.dispose();
				AdminBasePage.main(null);
			}
		});
		BackButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		BackButton.setBounds(123, 52, 97, 25);
		frmAccountcreation.getContentPane().add(BackButton);
	
	JButton CreateAccountButton = new JButton("Create Account");
	CreateAccountButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			try {
				String firstName=AdminFirstName.getText();
				String lastName=AdminLastName.getText();
				
				String phoneStr=AdminPhoneNo.getText();
				long phoneNo=Long.parseLong(phoneStr);
				String area= (String) AdminArea.getSelectedItem();
				String pincodeStr=AdminPincode.getText();
				int pincode=Integer.parseInt(pincodeStr);
				String city=(String) AdminCity.getSelectedItem();
				String state=AdminState.getText();
				Admin newUser=new Admin();
				@SuppressWarnings("deprecation")
				String password=AdminPassword.getText();
				newUser.createUser(firstName, lastName, phoneNo, area, city, state, pincode,password);
				
				Connection myConn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ElectricityBillingSystem","admin","Viplav@2000");
				System.out.println("Connection Successful");
				Statement myStmt=myConn.createStatement();
				String sql="insert into Administrator"
						+ "(first_name,last_name,pincode,phone,password,area,city,state)"
						+" values('"+firstName+"','"+lastName+"','"+pincode+"','"+phoneNo+"','"+password+"','"+area+"','"+city+"','"+state+"')";
				myStmt.executeUpdate(sql);
				System.out.println("Update Complete");
				String[] parameters= new String[3];
				parameters[0]=firstName;
				parameters[1]=lastName;
				parameters[2]=password;
				AdminMainPage.main(parameters);
				frmAccountcreation.dispose();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Complete");
			return;
		}
	});
	CreateAccountButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
	CreateAccountButton.setBounds(457, 461, 160, 31);
	frmAccountcreation.getContentPane().add(CreateAccountButton);
	
	
	}
}
