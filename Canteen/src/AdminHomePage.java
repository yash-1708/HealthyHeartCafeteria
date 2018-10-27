import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class AdminHomePage extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminHomePage frame = new AdminHomePage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AdminHomePage() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 752, 532);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 5, true));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JButton btnUpdateTodaysMenu = new JButton("Update Today's Menu Specials");
		btnUpdateTodaysMenu.setFont(new Font("SansSerif", Font.PLAIN, 12));
		btnUpdateTodaysMenu.setBounds(276, 63,200, 60);
		btnUpdateTodaysMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
		        {
		        	new UpdateSpecials().setVisible(true);
		        }
		        catch (Exception e1)
		         {
		             System.out.print(e1.getMessage());
		         }
				
			}
		});
		contentPane.add(btnUpdateTodaysMenu, BorderLayout.NORTH);
		
		JButton btnCheckOrders = new JButton("Check Beverage Orders");
		btnCheckOrders.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnCheckOrders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
		        {
		        	new CurrentOrders().setVisible(true);
		        }
		        catch (Exception e1)
		         {
		             System.out.print(e1.getMessage());
		         }
			}
		});
		btnCheckOrders.setBounds(276, 146, 200, 60);
		contentPane.add(btnCheckOrders);
		
		JButton btnRegisterAdmin = new JButton("Register New Admin");
		btnRegisterAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try
			        {
			        	hideForm();
			        	new adminRegPage().setVisible(true);
			        }
			        catch (Exception e1)
			         {
			             System.out.print(e1.getMessage());
			         }
			}
		});
		btnRegisterAdmin.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnRegisterAdmin.setBounds(276, 387, 200, 60);
		contentPane.add(btnRegisterAdmin);
		
		JButton btnAddNewPermanent = new JButton("Add New Permanent Item");
		btnAddNewPermanent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddMenuItem().setVisible(true);
			}
		});
		btnAddNewPermanent.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnAddNewPermanent.setBounds(276, 228, 200, 60);
		contentPane.add(btnAddNewPermanent);
		
		JLabel lblAdministratorPortal = new JLabel("Administrator Portal");
		lblAdministratorPortal.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdministratorPortal.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAdministratorPortal.setBounds(276, 20, 200, 20);
		contentPane.add(lblAdministratorPortal);
		
		JButton btnGenerateBillAnd = new JButton("Generate Bill and Deliver");
		btnGenerateBillAnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BillingInterface().setVisible(true);
			}
		});
		btnGenerateBillAnd.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnGenerateBillAnd.setBounds(276, 308, 200, 60);
		contentPane.add(btnGenerateBillAnd);
	}
	public void hideForm() {
		setVisible(false);
	}
}
