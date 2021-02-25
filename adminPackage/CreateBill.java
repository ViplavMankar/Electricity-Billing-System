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
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class CreateBill {

	private JFrame frame;
	private JTextField IdField;
	private JTextField FinalReadingField;
	private JTextField TotalUnitsField;
	private JTextField PerUnitField;
	private JTextField AmountField;
	private JTextField DateField;
	private JTextField MonthField;
	private JTextField YearField;
	private JTextField CurrentReadingField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateBill window = new CreateBill(args);
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
	public CreateBill(String[] args) {
		initialize(args);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param args 
	 */
	private void initialize(String[] args) {
		frame = new JFrame();
		frame.setBounds(100, 100, 1281, 710);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User Bill Creation");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(528, 28, 314, 57);
		frame.getContentPane().add(lblNewLabel);
		
		IdField = new JTextField();
		IdField.setEditable(false);
		IdField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		IdField.setBounds(223, 165, 145, 31);
		frame.getContentPane().add(IdField);
		IdField.setColumns(10);
		IdField.setText(args[3]);
		
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(155, 168, 41, 26);
		frame.getContentPane().add(lblNewLabel_1);
		
		CurrentReadingField = new JTextField();
		CurrentReadingField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		CurrentReadingField.setColumns(10);
		CurrentReadingField.setBounds(223, 231, 238, 31);
		frame.getContentPane().add(CurrentReadingField);
		
		JLabel lblCurrentReading = new JLabel("Previous Reading");
		lblCurrentReading.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCurrentReading.setBounds(62, 234, 134, 26);
		frame.getContentPane().add(lblCurrentReading);
		
		JLabel lblFinalReading = new JLabel("Current Reading");
		lblFinalReading.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblFinalReading.setBounds(62, 288, 134, 26);
		frame.getContentPane().add(lblFinalReading);
		
		FinalReadingField = new JTextField();
		FinalReadingField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		FinalReadingField.setColumns(10);
		FinalReadingField.setBounds(223, 285, 238, 31);
		frame.getContentPane().add(FinalReadingField);
		
		JLabel lblTotalUnits = new JLabel("Total Units");
		lblTotalUnits.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTotalUnits.setBounds(528, 288, 134, 26);
		frame.getContentPane().add(lblTotalUnits);
		
		TotalUnitsField = new JTextField();
		TotalUnitsField.setEditable(false);
		TotalUnitsField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		TotalUnitsField.setColumns(10);
		TotalUnitsField.setBounds(693, 285, 145, 31);
		frame.getContentPane().add(TotalUnitsField);
		
		JLabel lblChargePerUnit = new JLabel("Charge Per Unit");
		lblChargePerUnit.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblChargePerUnit.setBounds(528, 234, 134, 26);
		frame.getContentPane().add(lblChargePerUnit);
		
		PerUnitField = new JTextField();
		PerUnitField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PerUnitField.setEditable(false);
		PerUnitField.setColumns(10);
		PerUnitField.setBounds(693, 231, 145, 31);
		frame.getContentPane().add(PerUnitField);
		
		JButton OkButton = new JButton("OK");
		OkButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int totalUnits= Integer.parseInt(FinalReadingField.getText()) - Integer.parseInt(CurrentReadingField.getText());
				String units= Integer.toString(totalUnits);
				TotalUnitsField.setText(units);
				PerUnitField.setText("7");
				int amount= totalUnits*7;
				String amt= Integer.toString(amount);
				AmountField.setText(amt);
			}
		});
		OkButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		OkButton.setBounds(268, 342, 61, 25);
		frame.getContentPane().add(OkButton);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblAmount.setBounds(528, 340, 94, 26);
		frame.getContentPane().add(lblAmount);
		
		AmountField = new JTextField();
		AmountField.setEditable(false);
		AmountField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		AmountField.setColumns(10);
		AmountField.setBounds(693, 337, 145, 31);
		frame.getContentPane().add(AmountField);
		
		JLabel lblDueDate = new JLabel("Due Date");
		lblDueDate.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDueDate.setBounds(710, 138, 99, 26);
		frame.getContentPane().add(lblDueDate);
		
		DateField = new JTextField();
		DateField.setEditable(false);
		DateField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		DateField.setColumns(10);
		DateField.setBounds(821, 135, 41, 31);
		frame.getContentPane().add(DateField);
		DateField.setText("01");
		
		JLabel label = new JLabel("/");
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(874, 138, 24, 26);
		frame.getContentPane().add(label);
		
		MonthField = new JTextField();
		MonthField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		MonthField.setColumns(10);
		MonthField.setBounds(895, 135, 41, 31);
		frame.getContentPane().add(MonthField);
		
		JLabel label_1 = new JLabel("/");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_1.setBounds(948, 138, 24, 26);
		frame.getContentPane().add(label_1);
		
		YearField = new JTextField();
		YearField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		YearField.setColumns(10);
		YearField.setBounds(969, 135, 73, 31);
		frame.getContentPane().add(YearField);
		
		JLabel lblDd = new JLabel("DD");
		lblDd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDd.setBounds(821, 168, 41, 26);
		frame.getContentPane().add(lblDd);
		
		JLabel lblMm = new JLabel("MM");
		lblMm.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMm.setBounds(895, 168, 41, 26);
		frame.getContentPane().add(lblMm);
		
		JLabel lblYyyy = new JLabel("YYYY");
		lblYyyy.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblYyyy.setBounds(969, 168, 41, 26);
		frame.getContentPane().add(lblYyyy);
		
		JButton CreateBillButton = new JButton("Create Bill");
		CreateBillButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(CurrentReadingField.getText()==null && FinalReadingField.getText()==null && TotalUnitsField.getText()==null && DateField.getText()==null && MonthField.getText()==null && YearField.getText()==null) {
					JOptionPane.showMessageDialog(frame, "Please Fill all the details!");
				}
				else {
					try {
						Connection myConn= DriverManager.getConnection("jdbc:mysql://localhost:3306/ElectricityBillingSystem","admin","Viplav@2000");
						Statement myStmt= myConn.createStatement();
						int userId= Integer.parseInt(IdField.getText());
						int currentReading= Integer.parseInt(FinalReadingField.getText());
						int previousReading= Integer.parseInt(CurrentReadingField.getText());
						int totalUnits= Integer.parseInt(TotalUnitsField.getText());
						int chargePerUnit= 7;
						int amount= Integer.parseInt(AmountField.getText());
						int month= Integer.parseInt(MonthField.getText());
						int year= Integer.parseInt(YearField.getText());
						int status= 0;
						
						String sql= "insert into Bill(ID,current_reading,previous_reading,total_units,charge_per_unit,amount,due_date,status)"
								+   "values('"+userId+"','"+currentReading+"','"+previousReading+"','"+totalUnits+"','"+chargePerUnit+"','"+amount+"','"+year+"-"+month+"-01','"+status+"')";
						myStmt.executeUpdate(sql);
						JOptionPane.showMessageDialog(frame, "Insert Complete!");
					}
					catch(Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
		CreateBillButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		CreateBillButton.setBounds(497, 411, 175, 31);
		frame.getContentPane().add(CreateBillButton);
		
		
		
		JButton BackButton = new JButton("Back");
		BackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String[] parameters= new String[3];
				parameters[0]= args[0];
				parameters[1]= args[1];
				parameters[2]= args[2];
				BillCreation.main(parameters);
				frame.dispose();
			}
		});
		BackButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		BackButton.setBounds(189, 51, 97, 25);
		frame.getContentPane().add(BackButton);
	}
}
