import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;


@SuppressWarnings("serial")
public class LoginPage extends JFrame {

	public static final String userid = null;
	private JPanel contentPane;
	private JTextField textFielduser;
	private JPasswordField textFieldpass;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
//constructor for the jFrame page 
	public LoginPage() {
		setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 752, 532);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0), 3, true), new LineBorder(new Color(0, 0, 0), 1, true)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		JButton btnRegisterNewUser = new JButton("Register Now");
		btnRegisterNewUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Registration().setVisible(true);
			}
		});
		btnRegisterNewUser.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnRegisterNewUser.setBackground(Color.WHITE);
		btnRegisterNewUser.setBounds(518, 371, 176, 46);
		contentPane.add(btnRegisterNewUser);
		
		JButton btnAdminLogin = new JButton("Admin Login");
		btnAdminLogin.setBackground(Color.WHITE);
		btnAdminLogin.setBounds(58, 371, 177, 46);
		btnAdminLogin.setFont(new Font("Ariel", Font.PLAIN, 18));
		contentPane.add(btnAdminLogin);
		btnAdminLogin.addActionListener(new MyAdminLogin());
		
		JLabel label = new JLabel("Healthy Heart Cafeteria");
		label.setForeground(Color.BLACK);
		label.setBackground(new Color(255, 255, 255));
		label.setBounds(168, 10, 430, 63);
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Ariel", Font.BOLD | Font.ITALIC, 29));
		contentPane.add(label);
		
		JButton btnLogin = new JButton("User Login");
		btnLogin.setBackground(Color.WHITE);
		btnLogin.setBounds(292, 371, 176, 46);
		btnLogin.setFont(new Font("Ariel", Font.PLAIN, 18));
		contentPane.add(btnLogin);
		
		btnLogin.addActionListener(new MyLogin());
		
		textFieldpass = new JPasswordField();
		textFieldpass.setBounds(328, 274, 157, 32);
		textFieldpass.setFont(new Font("Ariel", Font.PLAIN, 16));
		textFieldpass.setColumns(4);
		contentPane.add(textFieldpass);
		
		JLabel lblOldPass = new JLabel("Password :");
		lblOldPass.setBounds(189, 270, 138, 38);
		lblOldPass.setBackground(UIManager.getColor("Button.darkShadow"));
		lblOldPass.setForeground(Color.BLACK);
		lblOldPass.setFont(new Font("Ariel", Font.PLAIN, 18));
		contentPane.add(lblOldPass);
		
		JLabel lblOldUser = new JLabel("Username :");
		lblOldUser.setBackground(Color.BLACK);
		lblOldUser.setBounds(189, 197, 138, 38);
		lblOldUser.setForeground(Color.BLACK);
		lblOldUser.setFont(new Font("Ariel", Font.PLAIN, 18));
		contentPane.add(lblOldUser);
		
		JLabel lblNewLabel = new JLabel("Login Page");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(189, 97, 382, 58);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Ariel", Font.BOLD, 23));
		contentPane.add(lblNewLabel);
		
		textFielduser = new JTextField();
		textFielduser.setBounds(328, 201, 157, 32);
		textFielduser.setFont(new Font("Ariel", Font.PLAIN, 16));
		contentPane.add(textFielduser);
		textFielduser.setColumns(4);

		JLabel photo = new JLabel(new ImageIcon("C:\\Users\\yash\\Desktop\\Cimages\\meduvada.jpg"));
		photo.setBounds(0, 0, 752, 532);
		contentPane.add(photo);
	}
	class MyAdminLogin implements ActionListener
    {
		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent ae)
        {	
	        try
	        {
	        	 //JDBC connection syntax
	        	 Class.forName("com.mysql.cj.jdbc.Driver");
				 Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/canteen?useSSL=false", "root" , "bilva");
				 Statement stmt = conn.createStatement();
				 String user = textFielduser.getText();
				 String pass = textFieldpass.getText();
				 String sql = "select * from usermaster where UserName='"+user+"' and Password='"+pass+"' and idUserTypeMaster=2";
				 
				 //executing select query, need result set so using execute instead of executeUpdate
				 ResultSet rs = stmt.executeQuery(sql);

				 if (rs.next())
				 {
					JOptionPane.showMessageDialog(null, "Login successful!");
					System.out.println("Login Sucessful!");
					new AdminHomePage().setVisible(true);
				 }
				 else {
					JOptionPane.showMessageDialog(null, "Login failed! Account does not exist");
				 	System.out.println("Login Unsucessful!");
				 }
				 rs.close();
				 stmt.close();
				 conn.close();
	                 
	         }
	         catch (Exception e)
	         {
	             System.out.print(e.getMessage());
	         }
         }
    
    
}
	class MyLogin implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {	
	        try
	        {
	        	 Class.forName("com.mysql.cj.jdbc.Driver");
				 Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/canteen?useSSL=false", "root" , "bilva");
				 Statement stmt = conn.createStatement();
				 String user = textFielduser.getText();
				 String pass = String.valueOf(textFieldpass.getPassword());
				 String sql = "select * from usermaster where UserName='"+user+"' and Password='"+pass+"' and idUserTypeMaster=1";
				 
				 ResultSet rs = stmt.executeQuery(sql);

				 if (rs.next())
				 {
					JOptionPane.showMessageDialog(null, "Login successful!");
					System.out.println("Login Sucessful!");
					UserHomePage UsrHome = new UserHomePage();
					//UsrHome.setUsername(user);
					UsrHome.setVisible(true);
				 }
				 else {
					JOptionPane.showMessageDialog(null, "Login failed! Account does not exist");
				 	System.out.println("Login Unsucessful!");
				 }
				 rs.close();
				 stmt.close();
				 conn.close();
	                 
	         }
	         catch (Exception e)
	         {
	             System.out.print(e.getMessage());
	         }
        }
    }
}

