package distributor;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

import user.usermain;
import eration.mainpage;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JCheckBox;

public class distributorlogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtusername;
	private JPasswordField txtpassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					distributorlogin frame = new distributorlogin();
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
	public distributorlogin() {
		setTitle("Distributor Login");
		setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\Edu\\6th sem\\FINAL_PROJECT\\e-ration\\bin\\images.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 490);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 0, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("GOVERNMENT OF INDIA");
		label.setForeground(Color.GREEN);
		label.setFont(new Font("Times New Roman", Font.BOLD, 40));
		label.setBounds(83, 13, 502, 42);
		contentPane.add(label);
		
		JLabel lblDistributorLogin = new JLabel("Distributor Login");
		lblDistributorLogin.setForeground(Color.ORANGE);
		lblDistributorLogin.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblDistributorLogin.setBounds(213, 55, 336, 42);
		contentPane.add(lblDistributorLogin);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLUE);
		separator.setBackground(Color.YELLOW);
		separator.setBounds(12, 111, 658, 2);
		contentPane.add(separator);
		
		JLabel lblShopNo = new JLabel("SHOP NO.:");
		lblShopNo.setForeground(Color.CYAN);
		lblShopNo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblShopNo.setBounds(160, 184, 128, 26);
		contentPane.add(lblShopNo);
		
		txtusername = new JTextField();
		txtusername.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtusername.setColumns(10);
		txtusername.setBounds(327, 186, 197, 26);
		contentPane.add(txtusername);
		
		JLabel label_3 = new JLabel("PASSWORD : ");
		label_3.setForeground(Color.CYAN);
		label_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label_3.setBounds(160, 255, 128, 26);
		contentPane.add(label_3);
		
		txtpassword = new JPasswordField();
		txtpassword.setEchoChar('*');
		txtpassword.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtpassword.setBounds(327, 257, 197, 26);
		contentPane.add(txtpassword);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLUE);
		separator_1.setBackground(Color.YELLOW);
		separator_1.setBounds(12, 326, 658, 2);
		contentPane.add(separator_1);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		        new mainpage().setVisible(true);
		        Component component = (Component) e.getSource();
		        JFrame distributorlogin = (JFrame) SwingUtilities.getRoot(component);
		        distributorlogin.dispose();
				
			}
		});
		btnBack.setForeground(Color.CYAN);
		btnBack.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnBack.setBackground(new Color(51, 0, 255));
		btnBack.setBounds(171, 366, 115, 33);
		contentPane.add(btnBack);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/e-ration","root","");
					Statement stmt=con.createStatement();
					String sql="Select * from distributor where shopno='"+txtusername.getText()+"' and password='"+txtpassword.getText().toString()+"'";
					ResultSet rs=stmt.executeQuery(sql);
					if(rs.next()){
						
						
						distrimain.main(new String[] {txtusername.getText()});
				        Component component = (Component) e.getSource();
				        JFrame distributorlogin = (JFrame) SwingUtilities.getRoot(component);
				        distributorlogin.dispose();
						
					}
					else
						JOptionPane.showMessageDialog(null, "Invalid Login details...");
					con.close();

					
				}
				catch(Exception ex)
				{
					
					//System.out.print(ex);
					JOptionPane.showMessageDialog(null, "Something went wrong. Please Try Again...");
					
				}
				
			}
		});
		btnLogin.setForeground(Color.CYAN);
		btnLogin.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnLogin.setBackground(new Color(51, 0, 255));
		btnLogin.setBounds(370, 366, 115, 33);
		contentPane.add(btnLogin);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int confirmed = JOptionPane.showConfirmDialog(null, 
				        "Are you sure you want to exit the program?", "Exit Program Message Box",
				        JOptionPane.YES_NO_OPTION);

				    if (confirmed == JOptionPane.YES_OPTION) {
				      dispose();
				    }
				
			}
		});
		btnExit.setForeground(Color.CYAN);
		btnExit.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnExit.setBackground(new Color(51, 0, 255));
		btnExit.setBounds(552, 397, 97, 33);
		contentPane.add(btnExit);
		
		JCheckBox chckbxShowPass = new JCheckBox("Show Password");
		chckbxShowPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (chckbxShowPass.isSelected())
				{
					
					txtpassword.setEchoChar((char)0);
					
				}
				else
				{
					txtpassword.setEchoChar('*');
				}
				
			}
		});
		chckbxShowPass.setForeground(Color.YELLOW);
		chckbxShowPass.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		chckbxShowPass.setBackground(new Color(51, 0, 51));
		chckbxShowPass.setBounds(411, 281, 113, 25);
		contentPane.add(chckbxShowPass);
	}
}
