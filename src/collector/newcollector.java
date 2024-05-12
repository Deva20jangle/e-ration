package collector;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;
import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JSeparator;
import javax.swing.JButton;

import eration.mainpage;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;

public class newcollector extends JFrame {

	private JPanel contentPane;
	private JTextField txtname;
	private JTextField txtuname;
	private JTextField txtdistrict;
	private JTextField txtmobno;
	private JPasswordField txtpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newcollector frame = new newcollector();
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
	public newcollector() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\Edu\\6th sem\\FINAL_PROJECT\\e-ration\\bin\\images.jpg"));
		setTitle("New Collector");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 585, 580);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 0, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("GOVERNMENT OF INDIA");
		label.setForeground(Color.GREEN);
		label.setFont(new Font("Times New Roman", Font.BOLD, 35));
		label.setBackground(Color.GREEN);
		label.setBounds(49, 23, 446, 51);
		contentPane.add(label);
		
		JLabel lblNewCollector = new JLabel("New Collector");
		lblNewCollector.setForeground(Color.ORANGE);
		lblNewCollector.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewCollector.setBounds(182, 68, 214, 42);
		contentPane.add(lblNewCollector);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLUE);
		separator.setBackground(Color.YELLOW);
		separator.setBounds(12, 123, 543, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLUE);
		separator_1.setBackground(Color.YELLOW);
		separator_1.setBounds(12, 471, 543, 2);
		contentPane.add(separator_1);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		        new collectormain().setVisible(true);
		        Component component = (Component) e.getSource();
		        JFrame newcollector = (JFrame) SwingUtilities.getRoot(component);
		        newcollector.dispose();
				
				
			}
		});
		btnBack.setForeground(Color.CYAN);
		btnBack.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnBack.setBackground(new Color(51, 0, 255));
		btnBack.setBounds(22, 486, 115, 33);
		contentPane.add(btnBack);
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				txtname.setText(null);
				txtuname.setText(null);
				txtpass.setText(null);
				txtdistrict.setText(null);
				txtmobno.setText(null);
				
			}
		});
		btnReset.setForeground(Color.CYAN);
		btnReset.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnReset.setBackground(new Color(51, 0, 255));
		btnReset.setBounds(217, 486, 115, 33);
		contentPane.add(btnReset);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try
				{
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/e-ration","root","");
					Statement stmt=con.createStatement();
					String sql = "insert into collector(`name`,`username`, `password`, `district`, `mobno`) VALUES ('" + txtname.getText().toString() + "','" + txtuname.getText().toString() + "','" + txtpass.getText().toString() + "','" + txtdistrict.getText().toString() + "','" + txtmobno.getText().toString() + "')";
					int rs = stmt.executeUpdate(sql);
					//System.out.println("rs" + rs);
					//cardNo = txtcardno.getText().toString();
					
					JOptionPane.showMessageDialog(null, "Collector has been created..");
					
					txtname.setText(null);
					txtuname.setText(null);
					txtpass.setText(null);
					txtdistrict.setText(null);
					txtmobno.setText(null);
					
				}
				catch(Exception ex)
				{
					
					//System.out.print(ex);
					//ex.printStackTrace();

					JOptionPane.showMessageDialog(null, "Something went wrong. Please Try Again...");
					
				}
				
			}
		});
		btnAdd.setForeground(Color.CYAN);
		btnAdd.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnAdd.setBackground(new Color(51, 0, 255));
		btnAdd.setBounds(422, 486, 115, 33);
		contentPane.add(btnAdd);
		
		JLabel lblFullName = new JLabel("Full name: ");
		lblFullName.setForeground(Color.YELLOW);
		lblFullName.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblFullName.setBounds(41, 150, 126, 25);
		contentPane.add(lblFullName);
		
		txtname = new JTextField();
		txtname.setText((String) null);
		txtname.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtname.setColumns(10);
		txtname.setBounds(206, 151, 308, 24);
		contentPane.add(txtname);
		
		JLabel lblUserName = new JLabel("User name: ");
		lblUserName.setForeground(Color.YELLOW);
		lblUserName.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblUserName.setBounds(41, 208, 126, 25);
		contentPane.add(lblUserName);
		
		txtuname = new JTextField();
		txtuname.setText((String) null);
		txtuname.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtuname.setColumns(10);
		txtuname.setBounds(206, 209, 308, 24);
		contentPane.add(txtuname);
		
		JLabel lblPassword = new JLabel("Password: ");
		lblPassword.setForeground(Color.YELLOW);
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblPassword.setBounds(41, 267, 126, 25);
		contentPane.add(lblPassword);
		
		JLabel lblDistrict = new JLabel("District: ");
		lblDistrict.setForeground(Color.YELLOW);
		lblDistrict.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblDistrict.setBounds(41, 348, 126, 25);
		contentPane.add(lblDistrict);
		
		txtdistrict = new JTextField();
		txtdistrict.setText((String) null);
		txtdistrict.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtdistrict.setColumns(10);
		txtdistrict.setBounds(206, 349, 308, 24);
		contentPane.add(txtdistrict);
		
		JLabel lblMobileNo = new JLabel("Mobile no.: ");
		lblMobileNo.setForeground(Color.YELLOW);
		lblMobileNo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblMobileNo.setBounds(41, 410, 126, 25);
		contentPane.add(lblMobileNo);
		
		txtmobno = new JTextField();
		txtmobno.setText((String) null);
		txtmobno.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtmobno.setColumns(10);
		txtmobno.setBounds(206, 411, 308, 24);
		contentPane.add(txtmobno);
		
		txtpass = new JPasswordField();
		txtpass.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtpass.setEchoChar('*');
		txtpass.setBounds(206, 270, 308, 25);
		contentPane.add(txtpass);
		
		JCheckBox chckbxShowPass = new JCheckBox("Show Password");
		chckbxShowPass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (chckbxShowPass.isSelected())
				{
					
					txtpass.setEchoChar((char)0);
					
				}
				else
				{
					txtpass.setEchoChar('*');
				}
				
			}
		});
		chckbxShowPass.setForeground(Color.YELLOW);
		chckbxShowPass.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		chckbxShowPass.setBackground(new Color(51, 0, 51));
		chckbxShowPass.setBounds(401, 304, 113, 25);
		contentPane.add(chckbxShowPass);
	}
}
