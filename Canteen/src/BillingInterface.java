import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class BillingInterface extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	static int userId;
	static int total;
	static int orderTransId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BillingInterface frame = new BillingInterface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BillingInterface() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 752, 532);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 10, 685, 219);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblEnterOrderTransaction = new JLabel("Enter Order Transaction Id");
		lblEnterOrderTransaction.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEnterOrderTransaction.setBounds(27, 281, 169, 45);
		contentPane.add(lblEnterOrderTransaction);
		
		textField = new JTextField();
		textField.setBounds(206, 281, 72, 45);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblTeacoffee = new JLabel("Tea/Coffee");
		lblTeacoffee.setHorizontalAlignment(SwingConstants.CENTER);
		lblTeacoffee.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTeacoffee.setBounds(66, 432, 117, 30);
		contentPane.add(lblTeacoffee);
		
		JLabel lblXQty = new JLabel("X Qty");
		lblXQty.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblXQty.setHorizontalAlignment(SwingConstants.CENTER);
		lblXQty.setBounds(206, 432, 72, 30);
		contentPane.add(lblXQty);
		
		JLabel lblbillAmt = new JLabel("--bill amt--");
		lblbillAmt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblbillAmt.setHorizontalAlignment(SwingConstants.CENTER);
		lblbillAmt.setBounds(361, 432, 96, 30);
		contentPane.add(lblbillAmt);
		
		JLabel lblTotal = new JLabel("TOTAL");
		lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotal.setBounds(361, 391, 96, 45);
		contentPane.add(lblTotal);
		
		JButton btnGenerateBill = new JButton("Generate Bill");
		btnGenerateBill.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGenerateBill.setBounds(316, 281, 155, 45);
		contentPane.add(btnGenerateBill);
		
		JButton btnSendBillTo = new JButton("Send Bill to User");
		btnSendBillTo.setEnabled(false);
		btnSendBillTo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSendBillTo.setBounds(490, 432, 148, 30);
		contentPane.add(btnSendBillTo);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/canteen?useSSL=false", "root" , "bilva");
			 Statement getOrderTransactions = conn.createStatement();
			 String orderTransactionsQuery = "select * from ordertransaction";
			 ResultSet ordertransactions = getOrderTransactions.executeQuery(orderTransactionsQuery);
  			 table.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(ordertransactions));
  			btnGenerateBill.addActionListener(new ActionListener() {
  			 	public void actionPerformed(ActionEvent e) {
  			 		orderTransId = Integer.parseInt(textField.getText());
  		  			try {
  		  				String billQuery = "SELECT idProductMaster, OrderQuantity, OrderPrice FROM orderdetails WHERE idOrderTransaction ="+orderTransId+";";
  		  				String userQuery = "select idUserMaster from ordertransaction WHERE idOrderTransaction ="+orderTransId+";";
  	  			 		Statement getBill = conn.createStatement();
  	  			 		Statement getUser = conn.createStatement();
	  			 		ResultSet getUserId = getUser.executeQuery(userQuery);
	  			 		getUserId.first();
	  			 		userId = getUserId.getInt("idUserMaster");
						
  	  			 		ResultSet bill = getBill.executeQuery(billQuery);
						if(bill.next()) {
							int price = 0;
							if(Integer.parseInt(bill.getString("idProductMaster")) == 1) {
								lblTeacoffee.setText("Tea");
								price = 10;
							}
							else {
								lblTeacoffee.setText("Coffee");
								price = 20;
							}
							
							lblXQty.setText("X "+bill.getString("OrderQuantity"));
							
							java.sql.CallableStatement billtotal = conn.prepareCall("{? = call billCalc(?,?)}");//used SQL function billCalc()
							billtotal.registerOutParameter(1, java.sql.Types.INTEGER);
							billtotal.setInt(2, Integer.parseInt(bill.getString("OrderQuantity")));
							billtotal.setInt(3, price);
							
							billtotal.execute();
							total = billtotal.getInt(1);
							
							lblbillAmt.setText("Rs. "+total);
							btnSendBillTo.setEnabled(true);
						}
					}
  		  			catch (SQLException e1) 
  		  			{
						e1.printStackTrace();
					}
  			 	}
  			 });
  			btnSendBillTo.addActionListener(new ActionListener() {
  				public void actionPerformed(ActionEvent e) {
  					try {
  						java.sql.CallableStatement uploadpayment = conn.prepareCall("{call savePayment(?,?)}");//used SQL function billCalc()
  						uploadpayment.setInt(1,userId);
  						uploadpayment.setInt(2,total);
  						uploadpayment.execute();
  						Statement delivery = conn.createStatement();
  						String setDelivered = "UPDATE ordertransaction SET DeliveredStatus = 1 WHERE idOrderTransaction = "+orderTransId+";";
  						delivery.executeUpdate(setDelivered);
  						JOptionPane.showMessageDialog(null, "Bill Sent");
  					}
  					catch (SQLException e2) 
  		  			{
						e2.printStackTrace();
					}
  				}
  			});
  			 
  			 
		}
		catch (Exception e)
        {
            System.out.print(e.getMessage());
        }
	}
}
