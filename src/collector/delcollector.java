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

import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class delcollector extends JFrame {

	private JPanel contentPane;
	private JTextField txtuname;
	private JTextField txtpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					delcollector frame = new delcollector();
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
	public delcollector() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\Edu\\6th sem\\FINAL_PROJECT\\e-ration\\bin\\images.jpg"));
		setTitle("Delete Collector");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 526, 387);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 0, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("GOVERNMENT OF INDIA");
		label.setForeground(Color.GREEN);
		label.setFont(new Font("Times New Roman", Font.BOLD, 35));
		label.setBackground(Color.GREEN);
		label.setBounds(37, 13, 446, 51);
		contentPane.add(label);
		
		JLabel lblDeleteCollector = new JLabel("Delete Collector");
		lblDeleteCollector.setForeground(Color.ORANGE);
		lblDeleteCollector.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblDeleteCollector.setBounds(163, 58, 214, 42);
		contentPane.add(lblDeleteCollector);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLUE);
		separator.setBackground(Color.YELLOW);
		separator.setBounds(12, 113, 484, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLUE);
		separator_1.setBackground(Color.YELLOW);
		separator_1.setBounds(12, 275, 484, 2);
		contentPane.add(separator_1);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		        new collectormain().setVisible(true);
		        Component component = (Component) e.getSource();
		        JFrame delcollector = (JFrame) SwingUtilities.getRoot(component);
		        delcollector.dispose();
				
			}
		});
		btnBack.setForeground(Color.CYAN);
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnBack.setBackground(new Color(51, 0, 255));
		btnBack.setBounds(22, 292, 136, 30);
		contentPane.add(btnBack);
		
		JButton button = new JButton("DELETE COLLECTOR");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try
				{
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/e-ration","root","");
					Statement stmt=con.createStatement();
					String sql = "DELETE FROM `collector` WHERE username = '" + txtuname.getText() + "' and password = '" + txtpass.getText() + "'";
					int rs = stmt.executeUpdate(sql);
					//System.out.println("rs" + rs);
					//cardNo = txtcardno.getText().toString();
					
					JOptionPane.showMessageDialog(null, "Collector has been deleted..");
					
					txtuname.setText(null);
					txtpass.setText(null);
					
				}
				catch(Exception ex)
				{
					
					//System.out.print(ex);
					//ex.printStackTrace();

					JOptionPane.showMessageDialog(null, "Something went wrong. Please Try Again...");
					
				
				}
			}
		});
		button.setForeground(Color.CYAN);
		button.setFont(new Font("Times New Roman", Font.BOLD, 15));
		button.setBackground(new Color(51, 0, 255));
		button.setBounds(269, 288, 214, 39);
		contentPane.add(button);
		
		txtuname = new JTextField();
		txtuname.setText((String) null);
		txtuname.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtuname.setColumns(10);
		txtuname.setBounds(188, 171, 308, 24);
		contentPane.add(txtuname);
		
		JLabel lblUsername = new JLabel("Username: ");
		lblUsername.setForeground(Color.YELLOW);
		lblUsername.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblUsername.setBounds(23, 170, 126, 25);
		contentPane.add(lblUsername);
		
		txtpass = new JTextField();
		txtpass.setText((String) null);
		txtpass.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtpass.setColumns(10);
		txtpass.setBounds(188, 221, 308, 24);
		contentPane.add(txtpass);
		
		JLabel lblPassword = new JLabel("Password: ");
		lblPassword.setForeground(Color.YELLOW);
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblPassword.setBounds(23, 220, 126, 25);
		contentPane.add(lblPassword);
		
		JLabel lblEnterTheUsername = new JLabel("Enter the username & password to delete account");
		lblEnterTheUsername.setForeground(Color.CYAN);
		lblEnterTheUsername.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblEnterTheUsername.setBounds(37, 128, 446, 25);
		contentPane.add(lblEnterTheUsername);
	}

}
