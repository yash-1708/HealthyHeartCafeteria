import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class PendingBills extends JFrame {
	static int UserId;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblConfirmUsernameTo;
	private JTextField textField;
	private JButton btnOk;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PendingBills frame = new PendingBills();
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
	public PendingBills() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 752, 532);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 718, 304);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblAtTheEnd = new JLabel("At the End of the Month Please Pay Rs.");
		lblAtTheEnd.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAtTheEnd.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtTheEnd.setBounds(10, 412, 718, 73);
		contentPane.add(lblAtTheEnd);
		
 			 lblConfirmUsernameTo = new JLabel("Confirm Username to see bills :");
 			 lblConfirmUsernameTo.setFont(new Font("Tahoma", Font.PLAIN, 14));
 			 lblConfirmUsernameTo.setHorizontalAlignment(SwingConstants.CENTER);
 			 lblConfirmUsernameTo.setBounds(53, 350, 217, 29);
 			 contentPane.add(lblConfirmUsernameTo);
 			 
 			 textField = new JTextField();
 			 textField.setBounds(280, 350, 112, 29);
 			 contentPane.add(textField);
 			 textField.setColumns(10);
 			 
 			 btnOk = new JButton("Ok");
 			 btnOk.addActionListener(new ActionListener() {
 			 	public void actionPerformed(ActionEvent e) {
 			 		try {
 			 		Class.forName("com.mysql.cj.jdbc.Driver");
 					Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/canteen?useSSL=false", "root" , "bilva");
 					 
 					java.sql.CallableStatement getUserId = conn.prepareCall("{call GetUserDetails(?)}");
 					getUserId.setString(1, textField.getText());
 					boolean hadResults = getUserId.execute();
 					if(hadResults) {
 					ResultSet rs = getUserId.getResultSet();
 					rs.first();
 					UserId = rs.getInt("idUserMaster");
 					
 					Statement getbills = conn.createStatement();
					String billQuery = "select * from paymenttransaction where idUserMaster = "+UserId+";";
					ResultSet bills = getbills.executeQuery(billQuery);
		 			table.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(bills));
		 			bills.first();
		 			int total = 0;
		 			do {
		 				total = total + bills.getInt("Amount");
		 			}
		 			while(bills.next());
		 			JOptionPane.showMessageDialog(null, "User Found");
		 			lblAtTheEnd.setText("At the End of the Month Please Pay Rs."+total);
 					}
 					else {
 						JOptionPane.showMessageDialog(null, "User does not exist");
 					}
 			 		}
 					catch (Exception e1)
 			        {
 			            System.out.print(e1.getMessage());
 			        }
 			 	}
 			 });
 			 btnOk.setBounds(417, 350, 59, 29);
 			 contentPane.add(btnOk);
 		
	}
	
	/*public void setUid(int UserId) {
		Userid = UserId;
	}*/
}
