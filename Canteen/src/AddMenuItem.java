import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

@SuppressWarnings("serial")
public class AddMenuItem extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMenuItem frame = new AddMenuItem();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AddMenuItem() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setHorizontalTextPosition(SwingConstants.CENTER);
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblName.setBounds(79, 59, 85, 28);
		contentPane.add(lblName);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setHorizontalTextPosition(SwingConstants.CENTER);
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice.setBounds(79, 134, 85, 28);
		contentPane.add(lblPrice);
		
		textField = new JTextField();
		textField.setBounds(193, 61, 143, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(193, 136, 143, 31);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try
			        {
					 	Class.forName("com.mysql.cj.jdbc.Driver");
					 	Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/canteen?useSSL=false", "root" , "bilva");
					 
					 	String itemName = textField.getText();
					 	int price = Integer.parseInt(textField_1.getText());
					 	
					 	java.sql.CallableStatement newProduct = conn.prepareCall("{call SaveProduct(?,?)}");
					 	newProduct.setString(1, itemName);
					 	newProduct.setInt(2, price);
						 
						newProduct.execute();
			        	hideForm();
			        	
			        	
			        }
			        catch (Exception e1)
			         {
			             System.out.print(e1.getMessage());
			         }
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAdd.setBounds(174, 210, 94, 28);
		contentPane.add(btnAdd);
	}
	public void hideForm() {
		setVisible(false);
	}
}
