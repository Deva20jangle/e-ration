package user;


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
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JScrollPane;

import java.awt.Window.Type;

public class complaint extends JFrame {

	private JPanel contentPane;
	private JTextField txtusername;
	private JTextField txtdistriname;
	private JTextField txttaluka;
	private JTextField txtdistrict;
	private JTextArea txtcomplaint;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					complaint frame = new complaint();
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
	public complaint() {
		setType(Type.POPUP);
		setTitle("Complaint");
		setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\Edu\\6th sem\\FINAL_PROJECT\\e-ration\\bin\\images.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 825, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 0, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGovernmentOfIndia = new JLabel("GOVERNMENT OF INDIA");
		lblGovernmentOfIndia.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lblGovernmentOfIndia.setForeground(Color.GREEN);
		lblGovernmentOfIndia.setBounds(167, 13, 444, 41);
		contentPane.add(lblGovernmentOfIndia);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLUE);
		separator.setBackground(Color.YELLOW);
		separator.setBounds(12, 106, 783, 2);
		contentPane.add(separator);
		
		JLabel lblComplaintForm = new JLabel("Complaint");
		lblComplaintForm.setForeground(Color.ORANGE);
		lblComplaintForm.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblComplaintForm.setBounds(336, 63, 151, 30);
		contentPane.add(lblComplaintForm);
		
		JLabel lblNameOfUser = new JLabel("Name of User : ");
		lblNameOfUser.setForeground(Color.YELLOW);
		lblNameOfUser.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNameOfUser.setBounds(41, 152, 134, 24);
		contentPane.add(lblNameOfUser);
		
		JLabel lblNameOfDistributor = new JLabel("Name of Distributor : ");
		lblNameOfDistributor.setForeground(Color.YELLOW);
		lblNameOfDistributor.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNameOfDistributor.setBounds(40, 189, 186, 24);
		contentPane.add(lblNameOfDistributor);
		
		JLabel lblTaluka = new JLabel("Taluka : ");
		lblTaluka.setForeground(Color.YELLOW);
		lblTaluka.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTaluka.setBounds(41, 226, 80, 24);
		contentPane.add(lblTaluka);
		
		JLabel lblDistrict = new JLabel("District :");
		lblDistrict.setForeground(Color.YELLOW);
		lblDistrict.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblDistrict.setBounds(41, 263, 80, 24);
		contentPane.add(lblDistrict);
		
		JLabel lblComplaint = new JLabel("Complaint : ");
		lblComplaint.setForeground(Color.YELLOW);
		lblComplaint.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblComplaint.setBounds(41, 300, 107, 24);
		contentPane.add(lblComplaint);
		
		txtusername = new JTextField();
		txtusername.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtusername.setBounds(230, 154, 316, 24);
		contentPane.add(txtusername);
		txtusername.setColumns(10);
		
		txtdistriname = new JTextField();
		txtdistriname.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtdistriname.setColumns(10);
		txtdistriname.setBounds(230, 192, 316, 24);
		contentPane.add(txtdistriname);
		
		txttaluka = new JTextField();
		txttaluka.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txttaluka.setColumns(10);
		txttaluka.setBounds(230, 226, 176, 24);
		contentPane.add(txttaluka);
		
		txtdistrict = new JTextField();
		txtdistrict.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtdistrict.setColumns(10);
		txtdistrict.setBounds(230, 263, 176, 24);
		contentPane.add(txtdistrict);
		
		//JScrollPane sp = new JScrollPane;
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLUE);
		separator_1.setBackground(Color.YELLOW);
		separator_1.setBounds(12, 435, 783, 2);
		contentPane.add(separator_1);
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				txtusername.setText(null);
				txtdistriname.setText(null);
				txttaluka.setText(null);
				txtdistrict.setText(null);
				txtcomplaint.setText(null);
				
				
			}
		});
		btnReset.setForeground(Color.CYAN);
		btnReset.setBackground(new Color(51, 0, 255));
		btnReset.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnReset.setBounds(336, 461, 117, 30);
		contentPane.add(btnReset);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		        new usermain().setVisible(true);
		        Component component = (Component) e.getSource();
		        JFrame complaint = (JFrame) SwingUtilities.getRoot(component);
		        complaint.dispose();
				
			}
		});
		btnBack.setForeground(Color.CYAN);
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnBack.setBackground(new Color(51, 0, 255));
		btnBack.setBounds(54, 461, 117, 30);    
		contentPane.add(btnBack);
		
		JButton btnSumbit = new JButton("SUBMIT");
		btnSumbit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				try
				{
					System.out.println("in click");
					
					java.util.Date date = new java.util.Date();
					java.sql.Date sqlDate = new java.sql.Date(date.getTime());
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/e-ration","root","");
					Statement stmt=con.createStatement();
					String sql="insert into complaint(`date`,`username`, `distriname`, `taluka`, `district`, `complaint`) "
							+ " VALUES ('" + sqlDate + "','" + txtusername.getText().toString() + "','" 
							+ txtdistriname.getText().toString() + "','" + txttaluka.getText().toString() 
							+ "','" + txtdistrict.getText().toString() + "','" + txtcomplaint.getText().toString() + "')";
					//System.out.println(sql);
					int rs=stmt.executeUpdate(sql);
					
					txtusername.setText(null);
					txtdistriname.setText(null);
					txttaluka.setText(null);
					txtdistrict.setText(null);
					txtcomplaint.setText(null);
					
					JOptionPane.showMessageDialog(null, "We have received your complaint.");
					
				}
				catch(Exception ex)
				{
					//ex.printStackTrace();
					
					//System.out.print(ex);
					JOptionPane.showMessageDialog(null, "Something went wrong. Please Try Again...");
					
				}
					
				
					
			}
		});
		btnSumbit.setForeground(Color.CYAN);
		btnSumbit.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnSumbit.setBackground(new Color(51, 0, 255));
		btnSumbit.setBounds(603, 461, 117, 30);
		contentPane.add(btnSumbit);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(90, 325, 611, 67);
		contentPane.add(scrollPane);
		
		txtcomplaint = new JTextArea();
		txtcomplaint.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		scrollPane.setViewportView(txtcomplaint);
		
		
		JLabel lblMaximiumCharacters = new JLabel("Maximium 50 characters.");
		lblMaximiumCharacters.setForeground(Color.CYAN);
		lblMaximiumCharacters.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblMaximiumCharacters.setBounds(549, 390, 151, 24);
		contentPane.add(lblMaximiumCharacters);
	}
}
