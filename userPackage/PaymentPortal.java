package userPackage;



import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class PaymentPortal {

	private JFrame frame;
	private JTextField CreditCardNumber;
	private JTextField Cvv;
	private JTextField Amount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaymentPortal window = new PaymentPortal(args);
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
	public PaymentPortal(String[] args) {
		initialize(args);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param args 
	 */
	private void initialize(String[] args) {
		frame = new JFrame();
		frame.setBounds(100, 100, 855, 525);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Payment Portal");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(342, 27, 259, 46);
		frame.getContentPane().add(lblNewLabel);
		
		CreditCardNumber = new JTextField();
		CreditCardNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
		CreditCardNumber.setBounds(275, 148, 251, 38);
		frame.getContentPane().add(CreditCardNumber);
		CreditCardNumber.setColumns(10);
		
		Cvv = new JTextField();
		Cvv.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Cvv.setBounds(275, 198, 251, 38);
		frame.getContentPane().add(Cvv);
		Cvv.setColumns(10);
		
		Amount = new JTextField();
		Amount.setEditable(false);
		Amount.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Amount.setBounds(273, 249, 253, 38);
		frame.getContentPane().add(Amount);
		Amount.setColumns(10);
		
		Amount.setText(args[4]);
		
		JButton PayButton = new JButton("Pay");
		PayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String firstName= CreditCardNumber.getText();
				String lastName= Cvv.getText();
				try {
					Connection myConn= DriverManager.getConnection("jdbc:mysql://localhost:3306/ElectricityBillingSystem","admin","Viplav@2000");
					Statement myStmt= myConn.createStatement();
					String sql= "select card_no,cvv from credit_card";
					ResultSet myRs=myStmt.executeQuery(sql);
					boolean flag=false;
					while(myRs.next()) {
						if(myRs.getString("card_no").equals(firstName) && myRs.getString("cvv").equals(lastName) ) {
							flag=true;
							String[] parameters= new String[2];
							parameters[0]=firstName;
							parameters[1]=lastName;
							JOptionPane.showMessageDialog(frame, "Payment Successful");
							MainPage.main(parameters);
							frame.dispose();
						}
					}
					if(flag==false) {
						JOptionPane.showMessageDialog(frame, "Invalid Details");
					}
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
		});
		PayButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PayButton.setBounds(346, 310, 135, 25);
		frame.getContentPane().add(PayButton);
		
		JLabel lblNewLabel_1 = new JLabel("Credit Card Number");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(75, 155, 176, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblCvv = new JLabel("CVV");
		lblCvv.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCvv.setBounds(193, 205, 60, 25);
		frame.getContentPane().add(lblCvv);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAmount.setBounds(165, 256, 90, 25);
		frame.getContentPane().add(lblAmount);
		
		JButton BackButton = new JButton("Back");
		BackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String[] parameters= new String[3];
				parameters[0]= args[0];
				parameters[1]= args[1];
				parameters[2]= args[2];
				UserBillPayment.main(parameters);
				frame.dispose();
			}
		});
		BackButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		BackButton.setBounds(117, 75, 97, 25);
		frame.getContentPane().add(BackButton);
	}
}
