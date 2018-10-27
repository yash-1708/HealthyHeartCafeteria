import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.SystemColor;

@SuppressWarnings("serial")
public class Registration extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration frame = new Registration();
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
	public Registration() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 800);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{71, 119, 36, 445, 0};
		gbl_contentPane.rowHeights = new int[]{27, 36, 26, 36, 26, 36, 26, 36, 26, 36, 26, 36, 26, 36, 26, 36, 26, 36, 54, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblRegistration = new JLabel("Registration");
		lblRegistration.setHorizontalTextPosition(SwingConstants.CENTER);
		lblRegistration.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistration.setFont(new Font("Tahoma", Font.BOLD, 22));
		GridBagConstraints gbc_lblRegistration = new GridBagConstraints();
		gbc_lblRegistration.anchor = GridBagConstraints.NORTH;
		gbc_lblRegistration.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblRegistration.insets = new Insets(0, 0, 5, 0);
		gbc_lblRegistration.gridx = 3;
		gbc_lblRegistration.gridy = 0;
		contentPane.add(lblRegistration, gbc_lblRegistration);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblFirstName = new GridBagConstraints();
		gbc_lblFirstName.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblFirstName.insets = new Insets(0, 0, 5, 5);
		gbc_lblFirstName.gridx = 1;
		gbc_lblFirstName.gridy = 2;
		contentPane.add(lblFirstName, gbc_lblFirstName);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setMinimumSize(new Dimension(15, 30));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.anchor = GridBagConstraints.NORTH;
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 2;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblMiddleName = new JLabel("Middle Name");
		lblMiddleName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblMiddleName = new GridBagConstraints();
		gbc_lblMiddleName.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblMiddleName.insets = new Insets(0, 0, 5, 5);
		gbc_lblMiddleName.gridx = 1;
		gbc_lblMiddleName.gridy = 4;
		contentPane.add(lblMiddleName, gbc_lblMiddleName);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_1.setMinimumSize(new Dimension(15, 30));
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.anchor = GridBagConstraints.NORTH;
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.gridx = 3;
		gbc_textField_1.gridy = 4;
		contentPane.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblLastName = new GridBagConstraints();
		gbc_lblLastName.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblLastName.insets = new Insets(0, 0, 5, 5);
		gbc_lblLastName.gridx = 1;
		gbc_lblLastName.gridy = 6;
		contentPane.add(lblLastName, gbc_lblLastName);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_2.setMinimumSize(new Dimension(15, 30));
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.anchor = GridBagConstraints.NORTH;
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.gridx = 3;
		gbc_textField_2.gridy = 6;
		contentPane.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JLabel lblFloorNumber = new JLabel("Floor Number");
		lblFloorNumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblFloorNumber = new GridBagConstraints();
		gbc_lblFloorNumber.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblFloorNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblFloorNumber.gridx = 1;
		gbc_lblFloorNumber.gridy = 8;
		contentPane.add(lblFloorNumber, gbc_lblFloorNumber);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_3.setMinimumSize(new Dimension(15, 30));
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.anchor = GridBagConstraints.NORTH;
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.gridx = 3;
		gbc_textField_3.gridy = 8;
		contentPane.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		JLabel lblTableNumber = new JLabel("Table Number");
		lblTableNumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblTableNumber = new GridBagConstraints();
		gbc_lblTableNumber.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblTableNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblTableNumber.gridx = 1;
		gbc_lblTableNumber.gridy = 10;
		contentPane.add(lblTableNumber, gbc_lblTableNumber);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_4.setMinimumSize(new Dimension(15, 30));
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.anchor = GridBagConstraints.NORTH;
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.insets = new Insets(0, 0, 5, 0);
		gbc_textField_4.gridx = 3;
		gbc_textField_4.gridy = 10;
		contentPane.add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername.gridx = 1;
		gbc_lblUsername.gridy = 12;
		contentPane.add(lblUsername, gbc_lblUsername);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_5.setMinimumSize(new Dimension(15, 30));
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.anchor = GridBagConstraints.NORTH;
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.insets = new Insets(0, 0, 5, 0);
		gbc_textField_5.gridx = 3;
		gbc_textField_5.gridy = 12;
		contentPane.add(textField_5, gbc_textField_5);
		textField_5.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 1;
		gbc_lblPassword.gridy = 14;
		contentPane.add(lblPassword, gbc_lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordField.setMinimumSize(new Dimension(15, 30));
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.anchor = GridBagConstraints.NORTH;
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.insets = new Insets(0, 0, 5, 0);
		gbc_passwordField.gridx = 3;
		gbc_passwordField.gridy = 14;
		contentPane.add(passwordField, gbc_passwordField);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblConfirmPassword = new GridBagConstraints();
		gbc_lblConfirmPassword.anchor = GridBagConstraints.WEST;
		gbc_lblConfirmPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblConfirmPassword.gridx = 1;
		gbc_lblConfirmPassword.gridy = 16;
		contentPane.add(lblConfirmPassword, gbc_lblConfirmPassword);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordField_1.setMinimumSize(new Dimension(15, 30));
		GridBagConstraints gbc_passwordField_1 = new GridBagConstraints();
		gbc_passwordField_1.anchor = GridBagConstraints.NORTH;
		gbc_passwordField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField_1.insets = new Insets(0, 0, 5, 0);
		gbc_passwordField_1.gridx = 3;
		gbc_passwordField_1.gridy = 16;
		contentPane.add(passwordField_1, gbc_passwordField_1);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try
			        {
			        	 Class.forName("com.mysql.cj.jdbc.Driver");
						 Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/canteen?useSSL=false", "root" , "bilva");
						 String fname = textField.getText();
						 String mname = textField_1.getText();
						 String lname = textField_2.getText();
						 int floorNo = Integer.parseInt(textField_3.getText());
						 String tableNo = textField_4.getText();
						 String username = textField_5.getText();
						 String pass1 = String.valueOf(passwordField.getPassword());
						 String pass2 = String.valueOf(passwordField_1.getPassword());						 
						 
						 if(pass1.equals(pass2)) {
							 java.sql.CallableStatement newUser = conn.prepareCall("{call RegisterUser(?,?,?,?,?,?,?)}");
							 newUser.setString(1, fname);
							 newUser.setString(2, mname);
							 newUser.setString(3, lname);
							 newUser.setInt(4, floorNo);
							 newUser.setString(5, tableNo);
							 newUser.setString(6, username);
							 newUser.setString(7, pass1);
						 
							 newUser.execute();
							 hideForm();
							 new LoginPage().setVisible(true); 
						 }
						 else {
							 JOptionPane.showMessageDialog(null, "Passwords Do Not Match! Try Again...");
							 hideForm();
							 new Registration().setVisible(true);
						 }
						 conn.close();
			                 
			         }
			         catch (Exception e1)
			         {
			             System.out.print(e1.getMessage());
			         }
			}
		});
		btnRegister.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_btnRegister = new GridBagConstraints();
		gbc_btnRegister.fill = GridBagConstraints.BOTH;
		gbc_btnRegister.gridx = 3;
		gbc_btnRegister.gridy = 18;
		contentPane.add(btnRegister, gbc_btnRegister);
	}
	public void hideForm() {
		setVisible(false);
	}
}
