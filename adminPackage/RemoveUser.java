package adminPackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class RemoveUser {

	private JFrame frame;
	private JTextField firstName;
	private JTextField lastName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveUser window = new RemoveUser(args);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param args 
	 */
	public RemoveUser(String[] args) {
		initialize(args);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param args 
	 */
	private void initialize(String[] args) {
		frame = new JFrame();
		frame.setBounds(100, 100, 662, 445);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Remove User");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(249, 28, 167, 44);
		frame.getContentPane().add(lblNewLabel);
		
		firstName = new JTextField();
		firstName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		firstName.setBounds(249, 118, 167, 29);
		frame.getContentPane().add(firstName);
		firstName.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFirstName.setBounds(126, 118, 112, 29);
		frame.getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLastName.setBounds(126, 165, 112, 29);
		frame.getContentPane().add(lblLastName);
		
		lastName = new JTextField();
		lastName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lastName.setColumns(10);
		lastName.setBounds(249, 165, 167, 29);
		frame.getContentPane().add(lastName);
		
		JButton btnNewButton = new JButton("Remove");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Connection myConn= DriverManager.getConnection("jdbc:mysql://localhost:3306/ElectricityBillingSystem","admin","Viplav@2000"); 
					Statement myStmt= myConn.createStatement();
					String sql= "select ID from Customer where first_name='"+firstName.getText()+"' and last_name='"+lastName.getText()+"'";
					ResultSet rs= myStmt.executeQuery(sql);
					int i=0;
					while(rs.next()) {
						i++;
					}
					if(i==0) {
						JOptionPane.showMessageDialog(frame, "No User Found!");
					}
					else {
						int a= JOptionPane.showConfirmDialog(frame, "Are you sure?");
						if(a==JOptionPane.YES_OPTION) {
							try {
								Connection Conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/ElectricityBillingSystem","admin","Viplav@2000"); 
								Statement Stmt= Conn.createStatement();
								String mysql= "delete from Customer where first_name='"+firstName.getText()+"' and last_name='"+lastName.getText()+"'";
								Stmt.executeUpdate(mysql);
								JOptionPane.showMessageDialog(frame, "Delete Successful!");
								AdminMainPage.main(args);
								frame.dispose();
							}
							catch(Exception e) {
								e.printStackTrace();
							}
						}
					}
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(249, 235, 112, 25);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminMainPage.main(args);
				frame.dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBack.setBounds(76, 43, 97, 25);
		frame.getContentPane().add(btnBack);
	}
}
