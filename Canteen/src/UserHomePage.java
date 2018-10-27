import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;*/
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

@SuppressWarnings("serial")
public class UserHomePage extends JFrame {
	//static String username;
	//static int UserId;
	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserHomePage frame = new UserHomePage();
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
	public UserHomePage() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 752, 532);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlDkShadow);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JButton btnUpdateTodaysMenu = new JButton("View Today's Menu Specials");
		btnUpdateTodaysMenu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnUpdateTodaysMenu.setBounds(276, 90,200, 60);
		btnUpdateTodaysMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new showSpecials().setVisible(true);
			}
		});
		contentPane.add(btnUpdateTodaysMenu, BorderLayout.NORTH);
		
		JButton btnBevOrders = new JButton("Order Beverages");
		btnBevOrders.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBevOrders.setBounds(276, 190, 200, 60);
		contentPane.add(btnBevOrders);
		btnBevOrders.addActionListener(new gotoOrderBev());
		
		JButton btnAlwaysAvailable = new JButton("Always Available Menu");
		btnAlwaysAvailable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAlwaysAvailable.setBounds(276, 286, 200, 60);
		contentPane.add(btnAlwaysAvailable);
		
		JLabel lblUserPortal = new JLabel("User Portal");
		lblUserPortal.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserPortal.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblUserPortal.setBounds(276, 39, 200, 30);
		contentPane.add(lblUserPortal);
		
		btnAlwaysAvailable.addActionListener(new gotoMenu());
		
		/*try {
        	System.out.println("Username"+username);
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/canteen?useSSL=false", "root" , "bilva");
		 
		java.sql.CallableStatement getUserId = conn.prepareCall("{call GetUserDetails(?)}");
		getUserId.setString(1, username);
		getUserId.execute();
		ResultSet rs = getUserId.getResultSet();
		rs.first();
		UserId = rs.getInt("idUserMaster");
		}
		catch (Exception e)
        {
            System.out.print(e.getMessage());
        }*/
		JButton btnCheckPendingBills = new JButton("Check Pending Bills");
		btnCheckPendingBills.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	        	PendingBills MyBills = new PendingBills();
	        	MyBills.setVisible(true);
	        	//System.out.println("User Id"+UserId);
	        	//MyBills.setUid(UserId);
			}
		});
		btnCheckPendingBills.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCheckPendingBills.setBounds(276, 381, 200, 60);
		contentPane.add(btnCheckPendingBills);
	}	
	/*public void setUsername(String usrnm) {
		username = usrnm;
	}*/
}
	
	class gotoOrderBev implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
	    {	
	        try
	        {
	        	new OrderBeverages().setVisible(true);
	        }
	        catch (Exception e)
	         {
	             System.out.print(e.getMessage());
	         }
	    }
	}
	class gotoMenu implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
	    {	
	        try
	        {
	        	new MenuPage().setVisible(true);
	        }
	        catch (Exception e)
	         {
	             System.out.print(e.getMessage());
	         }
	    }
	}
	
