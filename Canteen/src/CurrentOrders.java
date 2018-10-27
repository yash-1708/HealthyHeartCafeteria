import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;

@SuppressWarnings("serial")
public class CurrentOrders extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CurrentOrders frame = new CurrentOrders();
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
	public CurrentOrders() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 752, 532);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlDkShadow);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(new Rectangle(0, 0, 20, 50));
		scrollPane.setBackground(SystemColor.controlDkShadow);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setBorder(null);
		scrollPane.setViewportView(table);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/canteen?useSSL=false", "root" , "bilva");
			 Statement getOrders = conn.createStatement();
			 String orderQuery = "select idOrderTransaction, idProductMaster, OrderQuantity, OrderPrice from orderdetails";
			 ResultSet orders = getOrders.executeQuery(orderQuery);
  			 table.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(orders));

		}
		catch (Exception e)
        {
            System.out.print(e.getMessage());
        }
	}

}
