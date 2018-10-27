import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.awt.SystemColor;

@SuppressWarnings("serial")
public class showSpecials extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					showSpecials frame = new showSpecials();
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
	public showSpecials() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(140, 140, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlDkShadow);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNoSpecialToday = new JLabel("No Specials for Today");
		lblNoSpecialToday.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNoSpecialToday.setBounds(53, 85, 213, 41);
		contentPane.add(lblNoSpecialToday);
		
		JLabel lblRs = new JLabel("");
		lblRs.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRs.setBounds(311, 85, 68, 41);
		contentPane.add(lblRs);
		try {
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/canteen?useSSL=false", "root" , "bilva");
		 Statement stmt = conn.createStatement();
		 String sql = "select * from todaysmenu";
		 String name = null;
		 String price = null;
		 ResultSet rs = stmt.executeQuery(sql);
		 while(rs.next()) {
			 Date menudate = rs.getDate("MenuDate");
			 LocalDate sysdate = LocalDate.now();
			 if(sysdate.equals(menudate.toLocalDate())) {
				 name = rs.getString("ItemName");
				 price = String.valueOf(rs.getInt("ProductPrice"));
			 }
		 }
		 if(name != null) {
			 lblRs.setText("Rs. "+price);
			 lblNoSpecialToday.setText(name);
		 }
		 
		}
		catch (Exception e)
        {
            System.out.print(e.getMessage());
        }
		

		
	}

}
