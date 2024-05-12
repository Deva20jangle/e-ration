package collector;

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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

import user.usermain;
import eration.mainpage;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JCheckBox;

public class collectorlogin extends JFrame {

	private JPanel contentPane;
	private JPasswordField txtpassword;
	private JTextField txtusername;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					collectorlogin frame = new collectorlogin();
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
	public collectorlogin() {
		setTitle("Collector Login");
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
		label.setBounds(85, 13, 502, 42);
		contentPane.add(label);
		
		JLabel lblCollectorLogin = new JLabel("Collector Login");
		lblCollectorLogin.setForeground(Color.ORANGE);
		lblCollectorLogin.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblCollectorLogin.setBounds(228, 50, 320, 42);
		contentPane.add(lblCollectorLogin);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLUE);
		separator.setBackground(Color.YELLOW);
		separator.setBounds(12, 118, 658, 2);
		contentPane.add(separator);
		
		JLabel label_2 = new JLabel("USERNAME :");
		label_2.setForeground(Color.CYAN);
		label_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label_2.setBounds(161, 169, 128, 26);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("PASSWORD : ");
		label_3.setForeground(Color.CYAN);
		label_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label_3.setBounds(161, 240, 128, 26);
		contentPane.add(label_3);
		
		txtpassword = new JPasswordField();
		txtpassword.setEchoChar('*');
		txtpassword.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtpassword.setBounds(328, 242, 197, 26);
		contentPane.add(txtpassword);
		
		txtusername = new JTextField();
		txtusername.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtusername.setColumns(10);
		txtusername.setBounds(328, 171, 197, 26);
		contentPane.add(txtusername);
		
		JButton button = new JButton("BACK");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		        new mainpage().setVisible(true);
		        Component component = (Component) e.getSource();
		        JFrame collectorlogin = (JFrame) SwingUtilities.getRoot(component);
		        collectorlogin.dispose();
				
			}
		});
		button.setForeground(Color.CYAN);
		button.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		button.setBackground(new Color(51, 0, 255));
		button.setBounds(171, 366, 115, 33);
		contentPane.add(button);
		
		JButton button_1 = new JButton("LOGIN");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/e-ration","root","");
					Statement stmt=con.createStatement();
					String sql="Select * from collector where username = '" + txtusername.getText() + "' and password = '" + new String(txtpassword.getPassword()) + "'";
					ResultSet rs=stmt.executeQuery(sql);
					if(rs.next()){
						
						collectormain.main(new String[] {txtusername.getText()});
				        Component component = (Component) e.getSource();
				        JFrame collectorlogin = (JFrame) SwingUtilities.getRoot(component);
				        collectorlogin.dispose();
						
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Invalid Login details...123");
						
					}

					con.close();

					
				}
				catch(Exception ex)
				{
					
					//System.out.print(ex);
					JOptionPane.showMessageDialog(null, "Something went wrong. Please Try Again...");
					
				}
				
			}
		});
		button_1.setForeground(Color.CYAN);
		button_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		button_1.setBackground(new Color(51, 0, 255));
		button_1.setBounds(370, 366, 115, 33);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("EXIT");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int confirmed = JOptionPane.showConfirmDialog(null, 
				        "Are you sure you want to exit the program?", "Exit Program Message Box",
				        JOptionPane.YES_NO_OPTION);

				    if (confirmed == JOptionPane.YES_OPTION) {
				      dispose();
				    }
				
			}
		});
		button_2.setForeground(Color.CYAN);
		button_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		button_2.setBackground(new Color(51, 0, 255));
		button_2.setBounds(557, 397, 97, 33);
		contentPane.add(button_2);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLUE);
		separator_1.setBackground(Color.YELLOW);
		separator_1.setBounds(12, 326, 658, 2);
		contentPane.add(separator_1);
		
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
		chckbxShowPass.setBounds(412, 269, 113, 25);
		contentPane.add(chckbxShowPass);
	}

}
