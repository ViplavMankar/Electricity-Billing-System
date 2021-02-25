package userPackage;

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
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserBillPayment {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserBillPayment window = new UserBillPayment(args);
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
	public UserBillPayment(String[] args) {
		initialize(args);
	}


	/**
	 * Initialize the contents of the frame.
	 * @param args 
	 */
	private void initialize(String[] args) {
		frame = new JFrame();
		frame.setBounds(100, 100, 1201, 735);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bill Payment");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(515, 34, 227, 71);
		frame.getContentPane().add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(85, 137, 1021, 456);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		String[] columns= {"ID","Total Units","Amount","Due Date","Status"};
		DefaultTableModel model= new DefaultTableModel();
		model.setColumnIdentifiers(columns);
		table.setModel(model);
		
		
		table.setBackground(Color.lightGray);
		table.setForeground(Color.white);
		Font font= new Font("",1,20);
		table.setFont(font);
		table.setRowHeight(30);
		
		JButton RefreshButton= new JButton("Refresh");
		RefreshButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		RefreshButton.setBounds(889, 64, 135, 25);
		frame.getContentPane().add(RefreshButton);	
		RefreshButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					model.setRowCount(0);
					Connection myConn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ElectricityBillingSystem","admin","Viplav@2000");
					Statement myStmt=myConn.createStatement();
					String firstName=args[0];
					String lastName= args[1];
					String mysql= "select ID from Customer where first_name='"+firstName+"' and last_name='"+lastName+"'";
					Statement St= myConn.createStatement();
					ResultSet Rs= St.executeQuery(mysql);
					int id=0;
					while(Rs.next()) {
						id=Rs.getInt("ID");
					}
					String sql= "select ID,total_units,amount,due_date,status from Bill where ID='"+id+"' order by due_date desc";
					ResultSet myRs= myStmt.executeQuery(sql);
					String[] row= new String[5];
					int i=0;
					while(myRs.next()) {
						row[0]= myRs.getString("ID");
						row[1]= myRs.getString("total_units");
						row[2]= myRs.getString("amount");
						row[3]= myRs.getString("due_date");
						if(myRs.getBoolean("status")) {
							row[4]= "Paid";
						}
						else {
							row[4]="Unpaid";
						}
						model.insertRow(i++, row);
					}
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		});

		JButton BackButton = new JButton("Back");
		BackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainPage.main(args);
				frame.dispose();
			}
		});
		BackButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		BackButton.setBounds(130, 64, 119, 25);
		frame.getContentPane().add(BackButton);
		
		JButton PayBillButton = new JButton("Pay Bill");
		PayBillButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i= table.getSelectedRow();
				if(i>=0) {
					String[] parameters= new String[5];
					parameters[0]=args[0];
					parameters[1]=args[1];
					parameters[2]=args[2];
					parameters[3]=model.getValueAt(i, 0).toString();
					parameters[4]=model.getValueAt(i, 2).toString();
					
					PaymentPortal.main(parameters);
					frame.dispose();
				}
				else {
					JOptionPane.showMessageDialog(frame, "Please Select a row!");
				}
			}
		});
		PayBillButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PayBillButton.setBounds(537, 622, 111, 33);
		frame.getContentPane().add(PayBillButton);
		
	
		
	}
}
