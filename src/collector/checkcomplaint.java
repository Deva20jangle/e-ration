package collector;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JSeparator;
import javax.swing.JButton;

import distributor.distrimain;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.*;   

import user.ComplaintPOJO;
import net.proteanit.sql.DbUtils;

import com.toedter.calendar.JDateChooser;

public class checkcomplaint extends JFrame {

	private JPanel contentPane;
	private JDateChooser cmldate;
	private JTable table;
	
	String col[] = {"date","username","distriname","taluka","district","state","complaint"};

	DefaultTableModel tableModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					checkcomplaint frame = new checkcomplaint();
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
	public checkcomplaint() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\Edu\\6th sem\\FINAL_PROJECT\\e-ration\\bin\\images.jpg"));
		setTitle("Check Complaint");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 0, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("GOVERNMENT OF INDIA");
		label.setForeground(Color.GREEN);
		label.setFont(new Font("Times New Roman", Font.BOLD, 35));
		label.setBounds(196, 13, 441, 50);
		contentPane.add(label);
		
		JLabel lblComplaints = new JLabel("Complaints");
		lblComplaints.setForeground(Color.ORANGE);
		lblComplaints.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblComplaints.setBounds(350, 65, 152, 30);
		contentPane.add(lblComplaints);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLUE);
		separator.setBackground(Color.YELLOW);
		separator.setBounds(12, 106, 808, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLUE);
		separator_1.setBackground(Color.YELLOW);
		separator_1.setBounds(12, 519, 808, 2);
		contentPane.add(separator_1);
		
		JButton btnGetComplaints = new JButton("GET COMPLAINTS");
		btnGetComplaints.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/e-ration","root","");
					Statement stmt=con.createStatement();
					System.out.println(cmldate.getDate());
					
					String pattern = "yyyy-MM-dd";
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

					String date = simpleDateFormat.format(cmldate.getDate());
					//System.out.println("converted date " + date);
					
					String sql="select * from complaint where date = '"+ date +"'";
					ResultSet rs = stmt.executeQuery(sql);
					
					ComplaintPOJO complaintPOJO = null;
					ArrayList<ComplaintPOJO> complaintPOJOsList = new ArrayList<ComplaintPOJO>();
				
					
					while(rs.next()){
						
						complaintPOJO = new ComplaintPOJO();
						complaintPOJO.setDate(rs.getString(1));
						complaintPOJO.setUsername(rs.getString(2));
						complaintPOJO.setDistriName(rs.getString(3));
						complaintPOJO.setTaluka(rs.getString(4));
						complaintPOJO.setDistrictName(rs.getString(5));
						complaintPOJO.setState(rs.getString(6));
						complaintPOJO.setComplaint(rs.getString(7));

						complaintPOJOsList.add(complaintPOJO);
				
					}
					
					//System.out.println(complaintPOJOsList.size());
					
					for (int i = 0;i<complaintPOJOsList.size();i++){
						
						Object[] objs = {complaintPOJOsList.get(i).getDate(),
								complaintPOJOsList.get(i).getUsername(),
								complaintPOJOsList.get(i).getDistriName(),
								complaintPOJOsList.get(i).getTaluka(),
								complaintPOJOsList.get(i).getDistrictName(),
								complaintPOJOsList.get(i).getState(),
								complaintPOJOsList.get(i).getComplaint()};
						
						//System.out.println(objs);

						tableModel.addRow(objs);
						
						
						
					}
					
									
				}
				catch(Exception ex)
				{
					
					//System.out.print(ex);
					JOptionPane.showMessageDialog(null, "Something went wrong. Please Try Again...");
					
				}
				
			}
		});
		btnGetComplaints.setForeground(Color.CYAN);
		btnGetComplaints.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnGetComplaints.setBackground(new Color(51, 0, 255));
		btnGetComplaints.setBounds(289, 121, 172, 32);
		contentPane.add(btnGetComplaints);
		
		JButton button = new JButton("BACK");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		        new collectormain().setVisible(true);
		        Component component = (Component) e.getSource();
		        JFrame checkcomplaint = (JFrame) SwingUtilities.getRoot(component);
		        checkcomplaint.dispose();
				
			}
		});
		button.setForeground(Color.CYAN);
		button.setFont(new Font("Times New Roman", Font.BOLD, 15));
		button.setBackground(new Color(51, 0, 255));
		button.setBounds(12, 551, 153, 39);
		contentPane.add(button);
		
		cmldate = new JDateChooser();
		cmldate.setBounds(22, 121, 223, 32);
		contentPane.add(cmldate);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 192, 808, 317);
		contentPane.add(scrollPane);
		
		tableModel = new DefaultTableModel(col, 0);
		table = new JTable(tableModel);
		table.setRowHeight(22);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		table.setEnabled(true);
		table.setBounds(12,192,808,317);
		table.setModel(tableModel);
		scrollPane.setViewportView(table);

	}
}
