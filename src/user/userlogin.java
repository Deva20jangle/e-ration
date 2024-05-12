package user;

import java.sql.*;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.SwingUtilities;

import eration.mainpage;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Window.Type;
import javax.swing.JCheckBox;

public class userlogin extends JFrame {

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
					userlogin frame = new userlogin();
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
	public userlogin() {
		setType(Type.POPUP);
		setTitle("User Login");
		setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\Edu\\6th sem\\FINAL_PROJECT\\e-ration\\bin\\images.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 490);
		contentPane =  new JPanel();
		contentPane.setBackground(new Color(51, 0, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserLogin = new JLabel("User Login");
		lblUserLogin.setForeground(Color.ORANGE);
		lblUserLogin.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblUserLogin.setBounds(270, 57, 203, 42);
		contentPane.add(lblUserLogin);
		
		JLabel lblNewLabel = new JLabel("GOVERNMENT OF INDIA");
		lblNewLabel.setForeground(Color.GREEN);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblNewLabel.setBounds(85, 13, 502, 42);
		contentPane.add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("CARD NO.:");
		lblUsername.setForeground(new Color(0, 255, 255));
		lblUsername.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblUsername.setBounds(161, 169, 128, 26);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("PASSWORD : ");
		lblPassword.setForeground(new Color(0, 255, 255));
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblPassword.setBounds(161, 240, 128, 26);
		contentPane.add(lblPassword);
		
		txtusername = new JTextField();
		txtusername.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtusername.setBounds(328, 171, 197, 26);
		contentPane.add(txtusername);
		txtusername.setColumns(10);
		
		txtpassword = new JPasswordField();
		txtpassword.setEchoChar('*');
		txtpassword.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtpassword.setBounds(328, 242, 197, 26);
		contentPane.add(txtpassword);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		        new mainpage().setVisible(true);
		        Component component = (Component) e.getSource();
		        JFrame userlogin = (JFrame) SwingUtilities.getRoot(component);
		        userlogin.dispose();
				
			}
		});
		btnBack.setBackground(new Color(51, 0, 255));
		btnBack.setForeground(Color.CYAN);
		btnBack.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnBack.setBounds(171, 366, 115, 33);
		contentPane.add(btnBack);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/e-ration","root","");
					Statement stmt=con.createStatement();
					String sql="Select * from usertable where cardno='"+txtusername.getText()+"' and password='"+txtpassword.getText().toString()+"'";
					ResultSet rs=stmt.executeQuery(sql);
					if(rs.next()){
						
						
						usermain.main(new String[] {txtusername.getText()});
				        Component component = (Component) e.getSource();
				        JFrame userlogin = (JFrame) SwingUtilities.getRoot(component);
				        userlogin.dispose();
						
					}
					else
						JOptionPane.showMessageDialog(null, "Invalid Login details...");
					con.close();

					
				}catch(Exception ex)
				{
					
					//System.out.print(ex);
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "Something went wrong. Please Try Again...");
					
				}
				
			}
		});
		btnLogin.setBackground(new Color(51, 0, 255));
		btnLogin.setForeground(Color.CYAN);
		btnLogin.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnLogin.setBounds(370, 366, 115, 33);
		contentPane.add(btnLogin);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int confirmed = JOptionPane.showConfirmDialog(null, 
				        "Are you sure you want to exit the program?", "Exit Program Message Box",
				        JOptionPane.YES_NO_OPTION);

				    if (confirmed == JOptionPane.YES_OPTION) {
				      dispose();
				    }
				
			}
		});
		btnExit.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnExit.setForeground(Color.CYAN);
		btnExit.setBackground(new Color(51, 0, 255));
		btnExit.setBounds(557, 397, 97, 33);
		contentPane.add(btnExit);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLUE);
		separator.setBackground(Color.YELLOW);
		separator.setBounds(12, 118, 658, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLUE);
		separator_1.setBackground(Color.YELLOW);
		separator_1.setBounds(12, 326, 658, 2);
		contentPane.add(separator_1);
		
		JCheckBox chckbxShowPass = new JCheckBox("Show Password");
		chckbxShowPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
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
		chckbxShowPass.setForeground(new Color(255, 255, 0));
		chckbxShowPass.setBackground(new Color(51, 0, 51));
		chckbxShowPass.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		chckbxShowPass.setBounds(412, 277, 113, 25);
		contentPane.add(chckbxShowPass);
	}

	protected static void HIDE_ON_CLOSE() {
		// TODO Auto-generated method stub
		
	}

	protected static void close() {
		// TODO Auto-generated method stub
		
	}

	protected static void DISPOSE_ON_CLOSE() {
		// TODO Auto-generated method stub
		
	}
}
