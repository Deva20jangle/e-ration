package collector;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;
import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import distributor.distributorlogin;
import distributor.newuserregi;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class collectormain extends JFrame {

	private JPanel contentPane;
	private JTextField txtcollectorname;
	private JTextField txtdistrict;
	private JTextField txtuname;

	static String Username;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		if(args.length==1){
			Username=args[0];
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					collectormain frame = new collectormain();
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
	public collectormain() {
		
		setTitle("E_RATION Collector");
		setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\Edu\\6th sem\\FINAL_PROJECT\\e-ration\\bin\\images.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 530);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 0, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("GOVERNMENT OF INDIA");
		label.setForeground(Color.GREEN);
		label.setFont(new Font("Times New Roman", Font.BOLD, 35));
		label.setBackground(Color.GREEN);
		label.setBounds(218, 13, 446, 51);
		contentPane.add(label);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLUE);
		separator.setBackground(Color.YELLOW);
		separator.setBounds(12, 120, 858, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLUE);
		separator_1.setBackground(Color.YELLOW);
		separator_1.setBounds(12, 426, 858, 2);
		contentPane.add(separator_1);
		
		JButton btnAddDistributor = new JButton("ADD DISTRIBUTOR");
		btnAddDistributor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		        new newdistri().setVisible(true);
		        Component component = (Component) e.getSource();
		        JFrame collectormain = (JFrame) SwingUtilities.getRoot(component);
		        collectormain.dispose();
				
			}
		});
		btnAddDistributor.setForeground(Color.CYAN);
		btnAddDistributor.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnAddDistributor.setBackground(new Color(51, 0, 255));
		btnAddDistributor.setBounds(73, 293, 285, 39);
		contentPane.add(btnAddDistributor);
		
		JButton button_2 = new JButton("LOG OUT");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int confirmed = JOptionPane.showConfirmDialog(null, 
				        "Are you sure you want to logout?", "Exit Program Message Box",
				        JOptionPane.YES_NO_OPTION);

				    if (confirmed == JOptionPane.YES_OPTION) {
				      
				    	new collectorlogin().setVisible(true);
				        Component component = (Component) e.getSource();
				        JFrame collectormain = (JFrame) SwingUtilities.getRoot(component);
				        collectormain.dispose();
				    	//dispose();
				    }
				
			}
		});
		button_2.setForeground(Color.CYAN);
		button_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		button_2.setBackground(new Color(51, 0, 255));
		button_2.setBounds(734, 441, 136, 30);
		contentPane.add(button_2);
		
		JButton btnAddCollector = new JButton("ADD COLLECTOR");
		btnAddCollector.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		        new newcollector().setVisible(true);
		        Component component = (Component) e.getSource();
		        JFrame collectormain = (JFrame) SwingUtilities.getRoot(component);
		        collectormain.dispose();
				
			}
		});
		btnAddCollector.setForeground(Color.CYAN);
		btnAddCollector.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnAddCollector.setBackground(new Color(51, 0, 255));
		btnAddCollector.setBounds(29, 362, 238, 39);
		contentPane.add(btnAddCollector);
		
		JLabel lblNameOfCollector = new JLabel("Name of Collector :");
		lblNameOfCollector.setForeground(Color.YELLOW);
		lblNameOfCollector.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNameOfCollector.setBounds(393, 151, 174, 25);
		contentPane.add(lblNameOfCollector);
		
		txtcollectorname = new JTextField();
		txtcollectorname.setText((String) null);
		txtcollectorname.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtcollectorname.setEditable(false);
		txtcollectorname.setColumns(10);
		txtcollectorname.setBounds(616, 155, 231, 24);
		contentPane.add(txtcollectorname);
		
		JLabel lblArea = new JLabel("District: ");
		lblArea.setForeground(Color.YELLOW);
		lblArea.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblArea.setBounds(241, 206, 91, 25);
		contentPane.add(lblArea);
		
		txtdistrict = new JTextField();
		txtdistrict.setText((String) null);
		txtdistrict.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtdistrict.setEditable(false);
		txtdistrict.setColumns(10);
		txtdistrict.setBounds(364, 207, 231, 24);
		contentPane.add(txtdistrict);
		
		JLabel lblUsername = new JLabel("Login Name: ");
		lblUsername.setForeground(Color.YELLOW);
		lblUsername.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblUsername.setBounds(29, 154, 126, 25);
		contentPane.add(lblUsername);
		
		txtuname = new JTextField();
		txtuname.setText((String) null);
		txtuname.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtuname.setEditable(false);
		txtuname.setColumns(10);
		txtuname.setBounds(167, 155, 191, 24);
		contentPane.add(txtuname);
		
		JButton btnCheckComplaints = new JButton("CHECK COMPLAINTS");
		btnCheckComplaints.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		        new checkcomplaint().setVisible(true);
		        Component component = (Component) e.getSource();
		        JFrame collectormain = (JFrame) SwingUtilities.getRoot(component);
		        collectormain.dispose();
				
			}
		});
		btnCheckComplaints.setForeground(Color.CYAN);
		btnCheckComplaints.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnCheckComplaints.setBackground(new Color(51, 0, 255));
		btnCheckComplaints.setBounds(521, 293, 285, 39);
		contentPane.add(btnCheckComplaints);
		
		JLabel lblCollectorMain = new JLabel("Collector Main");
		lblCollectorMain.setForeground(Color.ORANGE);
		lblCollectorMain.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblCollectorMain.setBounds(351, 58, 214, 42);
		contentPane.add(lblCollectorMain);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.BLUE);
		separator_2.setBackground(Color.YELLOW);
		separator_2.setBounds(12, 261, 858, 2);
		contentPane.add(separator_2);
		
		JButton btnDeleteCollector = new JButton("DELETE COLLECTOR");
		btnDeleteCollector.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		        new delcollector().setVisible(true);
		        Component component = (Component) e.getSource();
		        JFrame collectormain = (JFrame) SwingUtilities.getRoot(component);
		        collectormain.dispose();
				
			}
		});
		btnDeleteCollector.setForeground(Color.CYAN);
		btnDeleteCollector.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnDeleteCollector.setBackground(new Color(51, 0, 255));
		btnDeleteCollector.setBounds(609, 362, 238, 39);
		contentPane.add(btnDeleteCollector);
		
		JButton btnDeleteDistributor = new JButton("DELETE DISTRIBUTOR");
		btnDeleteDistributor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				  new deldistri().setVisible(true);
			        Component component = (Component) e.getSource();
			        JFrame collectormain = (JFrame) SwingUtilities.getRoot(component);
			        collectormain.dispose();
				
			}
		});
		btnDeleteDistributor.setForeground(Color.CYAN);
		btnDeleteDistributor.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnDeleteDistributor.setBackground(new Color(51, 0, 255));
		btnDeleteDistributor.setBounds(329, 362, 238, 39);
		contentPane.add(btnDeleteDistributor);
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/e-ration","root","");
			Statement stmt=con.createStatement();
			//String sql="Select * from usertable where cardno='"+Username+"'";
			String sql = "SELECT username, name, district FROM `collector` WHERE username = '" + Username +"'";
			//System.out.println(sql);
			ResultSet rs=stmt.executeQuery(sql);
			if(rs.next()){
				
				txtcollectorname.setText(rs.getString(2));
				txtuname.setText(rs.getString(1));
				txtdistrict.setText(rs.getString(3));	
					
				}
			else
				JOptionPane.showMessageDialog(null, "Invalid Login details...");
			con.close();

		}catch(Exception ex){
			ex.printStackTrace();
			System.out.print(ex);}
		
	}
}
