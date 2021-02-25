package adminPackage;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BillCreation {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BillCreation window = new BillCreation(args);
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


	public BillCreation(String[] args) {
		// TODO Auto-generated constructor stub
		initialize(args);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param args 
	 */
	private void initialize(String[] args) {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1256, 774);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Bill Creation");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(546, 45, 390, 72);
		frame.getContentPane().add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(80, 153, 1096, 482);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		String[] columns= {"ID","First Name","Last Name","House No","Area"};
		DefaultTableModel model= new DefaultTableModel();
		model.setColumnIdentifiers(columns);
		table.setModel(model);
		
		table.setBackground(Color.lightGray);
		table.setForeground(Color.white);
		Font font= new Font("",1,20);
		table.setFont(font);
		table.setRowHeight(30);
		
		JButton RefreshButton = new JButton("Refresh");
		RefreshButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					model.setRowCount(0);
					Connection myConn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ElectricityBillingSystem","admin","Viplav@2000");
					Statement myStmt=myConn.createStatement();
					String firstName=args[0];
					String lastName= args[1];
					String mysql= "select ID from Administrator where first_name='"+firstName+"' and last_name='"+lastName+"'";
					Statement St= myConn.createStatement();
					ResultSet Rs= St.executeQuery(mysql);
					int id=0;
					while(Rs.next()) {
						id=Rs.getInt("ID");
					}
					String sql= "select ID,first_name,last_name,house_no,area from Customer where Admin_id='"+id+"'";
					ResultSet myRs= myStmt.executeQuery(sql);
					String[] row= new String[5];
					int i=0;
					while(myRs.next()) {
						row[0]= myRs.getString("ID");
						row[1]= myRs.getString("first_name");
						row[2]= myRs.getString("last_name");
						row[3]= myRs.getString("house_no");
						row[4]= myRs.getString("area");

						model.insertRow(i++, row);
					}
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		RefreshButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		RefreshButton.setBounds(948, 92, 127, 25);
		frame.getContentPane().add(RefreshButton);
		
		JButton BackButton = new JButton("Back");
		BackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminMainPage.main(args);
				frame.dispose();
			}
		});
		BackButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		BackButton.setBounds(180, 92, 127, 25);
		JButton btnNewButton = new JButton("Select User");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i= table.getSelectedRow();
				if(i>=0) {
					String[] parameters= new String[4];
					parameters[0]=args[0];
					parameters[1]=args[1];
					parameters[2]=args[2];
					parameters[3]=model.getValueAt(i, 0).toString();
					
					CreateBill.main(parameters);
					frame.dispose();
				}
				else {
					JOptionPane.showMessageDialog(frame, "Please Select 1 row!");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(560, 660, 150, 30);
		frame.getContentPane().add(btnNewButton);
		frame.getContentPane().add(BackButton);
	}
}
