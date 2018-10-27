import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;

@SuppressWarnings("serial")
public class OrderBeverages extends JFrame {

	private JPanel contentPane;
	private JTextField txtQuantity;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JRadioButton rdbtnTea;
	private JRadioButton rdbtnCoffee;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderBeverages frame = new OrderBeverages();
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
	public OrderBeverages() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 752, 532);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlDkShadow);
		contentPane.setForeground(SystemColor.textInactiveText);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 5, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		rdbtnTea = new JRadioButton("Tea");
		rdbtnTea.addActionListener(new RdBtnActionListenerTea());
		rdbtnTea.setBounds(281, 143, 96, 21);
		contentPane.add(rdbtnTea);
		
		rdbtnCoffee = new JRadioButton("Coffee");
		rdbtnCoffee.addActionListener(new RdBtnActionListenerCoffee());
		rdbtnCoffee.setBounds(281, 177, 96, 21);
		contentPane.add(rdbtnCoffee);
		
		txtQuantity = new JTextField();
		txtQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		txtQuantity.setBounds(281, 261, 96, 19);
		contentPane.add(txtQuantity);
		txtQuantity.setColumns(10);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblQuantity.setBounds(97, 264, 103, 13);
		contentPane.add(lblQuantity);
		
		JLabel lblConfirmUsername = new JLabel("Confirm Username");
		lblConfirmUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConfirmUsername.setBounds(97, 305, 152, 13);
		contentPane.add(lblConfirmUsername);
		
		JLabel lblFloor = new JLabel("Floor");
		lblFloor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFloor.setBounds(97, 341, 103, 13);
		contentPane.add(lblFloor);
		
		JLabel lblTableNumber = new JLabel("Table Number");
		lblTableNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTableNumber.setBounds(97, 374, 103, 13);
		contentPane.add(lblTableNumber);
		
		textField = new JTextField();
		textField.setBounds(281, 302, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(281, 338, 96, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(281, 371, 96, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnConfirmOrder = new JButton("Confirm Order");
		btnConfirmOrder.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnConfirmOrder.setBounds(510, 362, 167, 40);
		contentPane.add(btnConfirmOrder);
		
		JLabel lblChooseYourBeverage = new JLabel("Choose Your Beverage of Choice");
		lblChooseYourBeverage.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblChooseYourBeverage.setBounds(53, 145, 222, 13);
		contentPane.add(lblChooseYourBeverage);
		
		JLabel lblBeverageOrders = new JLabel("Beverage Orders");
		lblBeverageOrders.setHorizontalAlignment(SwingConstants.CENTER);
		lblBeverageOrders.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblBeverageOrders.setBounds(301, 43, 167, 34);
		contentPane.add(lblBeverageOrders);
		btnConfirmOrder.addActionListener(new subBtnListener());
	}
	class subBtnListener implements ActionListener
	{
	    public void actionPerformed(ActionEvent ae)
	    {	
	        try
	        {
	        	 Class.forName("com.mysql.cj.jdbc.Driver");
				 Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/canteen?useSSL=false", "root" , "bilva");
				 String username = textField.getText();
				 int userId = 0;
				 int quantity = Integer.parseInt(txtQuantity.getText());
				 int floorNo = Integer.parseInt(textField_1.getText());
				 int tableNo = Integer.parseInt(textField_2.getText());
				 int productId = 1;
				 if(rdbtnTea.isSelected()) {
					 productId = 1;
					 rdbtnCoffee.setSelected(false);
				 }
				 if(rdbtnCoffee.isSelected()) {
					 productId = 2;
					 rdbtnTea.setSelected(false);
				 }
				 
				 java.sql.CallableStatement getUserId = conn.prepareCall("{call GetUserDetails(?)}");
				 getUserId.setString(1, username);
				 boolean hadResults = getUserId.execute();
				 
				 if(hadResults) {
					 ResultSet rs = getUserId.getResultSet();
					 rs.first();
					 userId = rs.getInt("idUserMaster");
				 }
				 
				 java.sql.CallableStatement sendOrder = conn.prepareCall("{call SaveOrder(?,?,?,?,?)}");
				 sendOrder.setInt(1, userId);
				 sendOrder.setInt(2, tableNo);
				 sendOrder.setInt(3, floorNo);
				 sendOrder.setInt(4, productId);
				 sendOrder.setInt(5, quantity);
				 hadResults = sendOrder.execute();
				 JOptionPane.showMessageDialog(null, "Order Confirmed");
				 hideForm();
				 conn.close();
	                 
	         }
	         catch (Exception e)
	         {
	             System.out.print(e.getMessage());
	         }
	    }
	}
	class RdBtnActionListenerTea implements ActionListener{
		public void actionPerformed(ActionEvent ae)
	    {
			rdbtnCoffee.setSelected(false);
	    } 
	}
	class RdBtnActionListenerCoffee implements ActionListener{
		public void actionPerformed(ActionEvent ae)
	    {
			rdbtnTea.setSelected(false);
	    } 
	}
	public void hideForm() {
		setVisible(false);
	}
}



