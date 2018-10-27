import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Font;

public class UpdateSpecials extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateSpecials frame = new UpdateSpecials();
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
	public UpdateSpecials() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblItemName = new JLabel("Item Name : ");
		lblItemName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblItemName.setBounds(29, 59, 103, 13);
		contentPane.add(lblItemName);
		
		JLabel lblItemPrice = new JLabel("Item Price : ");
		lblItemPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblItemPrice.setBounds(29, 109, 103, 13);
		contentPane.add(lblItemPrice);
		
		textField = new JTextField();
		textField.setBounds(154, 56, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(154, 106, 96, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
		        {
				 	Class.forName("com.mysql.cj.jdbc.Driver");
				 	Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/canteen?useSSL=false", "root" , "bilva");
				 
				 	String itemName = textField.getText();
				 	int price = Integer.parseInt(textField_1.getText());
				 	
				 	java.sql.CallableStatement newSpec = conn.prepareCall("{call UpdateSpecial(?,?)}");
				 	newSpec.setString(1, itemName);
				 	newSpec.setInt(2, price);
					
				 	newSpec.execute();
					
		        	hideForm();
		        	
		        	
		        }
		        catch (Exception e1)
		         {
		             System.out.print(e1.getMessage());
		         }
			}
		});
		btnUpdate.setBounds(165, 153, 85, 21);
		contentPane.add(btnUpdate);
		
		
	}
	public void hideForm() {
		setVisible(false);
	}
}
