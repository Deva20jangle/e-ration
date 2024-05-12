package user;

import java.awt.Component;
import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import distributor.stock;
import net.proteanit.sql.*;

import javax.swing.JTable;
import javax.swing.SwingConstants;

public class usermain extends JFrame {

	private JPanel contentPane;
	private JTextField txtnationality;
	private JTextField txtfamilyhead;
	private JTextField txtincome;
	private JTextField txtmobno;
	private JTextField txtemail;
	private JTextField txtcardno;
	private JTextField txtadult;
	private JTextField txtchild;
	private JTextField txttotunit;

		
	private static String Username;
	private JTable table;
	
	String col[] = {"Name","Age","Aadhar"};

	DefaultTableModel tableModel;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	//public static void main() {
		
		
		if(args.length==1){
			Username=args[0];
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					usermain frame = new usermain();
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
	public usermain() {
			
		
		setTitle("User Details");
		setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\Edu\\6th sem\\FINAL_PROJECT\\e-ration\\bin\\images.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(20, 10, 935, 943);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 0, 51));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGovernmentOfIndia = new JLabel("GOVERNMENT OF INDIA");
		lblGovernmentOfIndia.setForeground(Color.GREEN);
		lblGovernmentOfIndia.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lblGovernmentOfIndia.setBounds(251, 13, 441, 50);
		contentPane.add(lblGovernmentOfIndia);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLUE);
		separator.setBackground(Color.YELLOW);
		separator.setBounds(12, 113, 888, 2);
		contentPane.add(separator);
		
		JLabel lblDetailsOfCard = new JLabel("Details of card Holder:");
		lblDetailsOfCard.setForeground(Color.CYAN);
		lblDetailsOfCard.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblDetailsOfCard.setBounds(344, 123, 241, 25);
		contentPane.add(lblDetailsOfCard);
		
		JLabel lblNationality = new JLabel("Nationality :");
		lblNationality.setForeground(new Color(255, 255, 0));
		lblNationality.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNationality.setBounds(22, 213, 120, 25);
		contentPane.add(lblNationality);
		
		JLabel lblNameOfFamily = new JLabel("Name of Family Head :");
		lblNameOfFamily.setForeground(new Color(255, 255, 0));
		lblNameOfFamily.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNameOfFamily.setBounds(22, 251, 219, 25);
		contentPane.add(lblNameOfFamily);
		
		JLabel lblAddress = new JLabel("Address :");
		lblAddress.setForeground(new Color(255, 255, 0));
		lblAddress.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblAddress.setBounds(22, 289, 120, 25);
		contentPane.add(lblAddress);
		
		JLabel lblAnnualIncome = new JLabel("Annual Income : ");
		lblAnnualIncome.setForeground(new Color(255, 255, 0));
		lblAnnualIncome.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblAnnualIncome.setBounds(22, 366, 158, 25);
		contentPane.add(lblAnnualIncome);
		
		JLabel lblRegisteredMobileNo = new JLabel("Registered Mobile No.: ");
		lblRegisteredMobileNo.setForeground(new Color(255, 255, 0));
		lblRegisteredMobileNo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblRegisteredMobileNo.setBounds(22, 404, 200, 25);
		contentPane.add(lblRegisteredMobileNo);
		
		JLabel lblRegisteredEmailId = new JLabel("Registered e-mail id: ");
		lblRegisteredEmailId.setForeground(new Color(255, 255, 0));
		lblRegisteredEmailId.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblRegisteredEmailId.setBounds(22, 442, 200, 25);
		contentPane.add(lblRegisteredEmailId);
		
		JLabel lblNameOfFamily_1 = new JLabel("Name of Family Members : ");
		lblNameOfFamily_1.setForeground(new Color(255, 255, 0));
		lblNameOfFamily_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNameOfFamily_1.setBounds(24, 602, 231, 25);
		contentPane.add(lblNameOfFamily_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLUE);
		separator_1.setBackground(Color.YELLOW);
		separator_1.setBounds(12, 793, 888, 2);
		contentPane.add(separator_1);
		
		JButton btnComplaint = new JButton("COMPLAINT");
		btnComplaint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		        new complaint().setVisible(true);
		        Component component = (Component) e.getSource();
		        JFrame usermain = (JFrame) SwingUtilities.getRoot(component);
		        usermain.dispose();
				
			}
		});
		btnComplaint.setBackground(new Color(51, 0, 255));
		btnComplaint.setForeground(Color.CYAN);
		btnComplaint.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnComplaint.setBounds(22, 808, 136, 39);
		contentPane.add(btnComplaint);
		
		JButton btnCheckStock = new JButton("CHECK STOCK");
		btnCheckStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		        new checkstock().setVisible(true);
		        Component component = (Component) e.getSource();
		        JFrame usermain = (JFrame) SwingUtilities.getRoot(component);
		        usermain.dispose();
				
			}
		});
		btnCheckStock.setForeground(Color.CYAN);
		btnCheckStock.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnCheckStock.setBackground(new Color(51, 0, 255));
		btnCheckStock.setBounds(281, 808, 158, 39);
		contentPane.add(btnCheckStock);
		
		JButton btnCheckMap = new JButton("CHECK MAP");
		btnCheckMap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
				    Desktop.getDesktop().browse(new URL("https://www.google.com/maps/search/ration+shop+near+me/@18.3436294,73.9045553,11z/data=!3m1!4b1").toURI());
				} catch (Exception e) 
				{
					//e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Something went wrong. Please Try Again...");
				}
				
			}
		});
		btnCheckMap.setForeground(Color.CYAN);
		btnCheckMap.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnCheckMap.setBackground(new Color(51, 0, 255));
		btnCheckMap.setBounds(531, 808, 136, 39);
		contentPane.add(btnCheckMap);
		
		JButton btnLogOut = new JButton("LOG OUT");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int confirmed = JOptionPane.showConfirmDialog(null, 
				        "Are you sure you want to logout?", "Exit Program Message Box",
				        JOptionPane.YES_NO_OPTION);

				    if (confirmed == JOptionPane.YES_OPTION) {
				      
				    	new userlogin().setVisible(true);
				        Component component = (Component) e.getSource();
				        JFrame usermain = (JFrame) SwingUtilities.getRoot(component);
				        usermain.dispose();
				    	//dispose();
				    }
				
				

				
			}
		});
		btnLogOut.setForeground(Color.CYAN);
		btnLogOut.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnLogOut.setBackground(new Color(51, 0, 255));
		btnLogOut.setBounds(768, 863, 136, 30);
		contentPane.add(btnLogOut);
		
		JLabel lblNumberOfUnits = new JLabel("Number of Units : ");
		lblNumberOfUnits.setForeground(Color.YELLOW);
		lblNumberOfUnits.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNumberOfUnits.setBounds(22, 480, 152, 25);
		contentPane.add(lblNumberOfUnits);
		
		txtnationality = new JTextField();
		txtnationality.setEditable(false);
		txtnationality.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtnationality.setColumns(10);
		txtnationality.setBounds(245, 216, 231, 24);
		contentPane.add(txtnationality);
		
		txtfamilyhead = new JTextField();
		txtfamilyhead.setEditable(false);
		txtfamilyhead.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtfamilyhead.setColumns(10);
		txtfamilyhead.setBounds(245, 254, 316, 24);
		contentPane.add(txtfamilyhead);
		
		txtincome = new JTextField();
		txtincome.setEditable(false);
		txtincome.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtincome.setColumns(10);
		txtincome.setBounds(245, 369, 231, 24);
		contentPane.add(txtincome);
		
		txtmobno = new JTextField();
		txtmobno.setEditable(false);
		txtmobno.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtmobno.setColumns(10);
		txtmobno.setBounds(245, 407, 231, 24);
		contentPane.add(txtmobno);
		
		txtemail = new JTextField();
		txtemail.setEditable(false);
		txtemail.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtemail.setColumns(10);
		txtemail.setBounds(245, 445, 316, 24);
		contentPane.add(txtemail);
		
		
		txtcardno = new JTextField();
		txtcardno.setEditable(false);
		txtcardno.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtcardno.setColumns(10);
		txtcardno.setBounds(245, 179, 231, 24);
		txtcardno.setText(Username);
		contentPane.add(txtcardno);
		
		JLabel lblRationCardNo = new JLabel("Ration Card No.: ");
		lblRationCardNo.setForeground(Color.YELLOW);
		lblRationCardNo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblRationCardNo.setBounds(22, 175, 152, 25);
		contentPane.add(lblRationCardNo);
		
		txtadult = new JTextField();
		txtadult.setEditable(false);
		txtadult.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtadult.setColumns(10);
		txtadult.setBounds(81, 556, 152, 33);
		contentPane.add(txtadult);
		
		JLabel label = new JLabel("ADULT");
		label.setForeground(Color.YELLOW);
		label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label.setBackground(new Color(204, 204, 204));
		label.setBounds(81, 518, 152, 25);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("CHILD");
		label_1.setForeground(Color.YELLOW);
		label_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label_1.setBackground(new Color(204, 204, 204));
		label_1.setBounds(245, 518, 152, 25);
		contentPane.add(label_1);
		
		txtchild = new JTextField();
		txtchild.setEditable(false);
		txtchild.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtchild.setColumns(10);
		txtchild.setBounds(234, 556, 152, 33);
		contentPane.add(txtchild);
		
		JLabel label_2 = new JLabel("TOTAL UNIT");
		label_2.setForeground(Color.YELLOW);
		label_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label_2.setBackground(new Color(204, 204, 204));
		label_2.setBounds(409, 518, 152, 25);
		contentPane.add(label_2);
		
		txttotunit = new JTextField();
		txttotunit.setEditable(false);
		txttotunit.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txttotunit.setColumns(10);
		txttotunit.setBounds(387, 556, 152, 33);
		contentPane.add(txttotunit);
		
		JTextArea txtaddr = new JTextArea();
		txtaddr.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtaddr.setEditable(false);
		txtaddr.setBounds(245, 292, 540, 64);		
		contentPane.add(txtaddr);
		
		tableModel = new DefaultTableModel(col, 0);
		table = new JTable(tableModel);
		table.setRowHeight(22);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		table.setEnabled(true);
		table.setBounds(79, 652, 588, 132);
		table.setModel(tableModel);
		contentPane.add(table);
		
		JLabel label_3 = new JLabel("AADHAR NO: ");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(Color.YELLOW);
		label_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label_3.setBackground(new Color(204, 204, 204));
		label_3.setBounds(468, 626, 152, 25);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("AGE: ");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(Color.YELLOW);
		label_4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label_4.setBackground(new Color(204, 204, 204));
		label_4.setBounds(274, 626, 152, 25);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("NAME: ");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setForeground(Color.YELLOW);
		label_5.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label_5.setBackground(new Color(204, 204, 204));
		label_5.setBounds(79, 626, 152, 25);
		contentPane.add(label_5);
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/e-ration","root","");
			Statement stmt=con.createStatement();
			//String sql="Select * from usertable where cardno='"+Username+"'";
			String sql = "SELECT id, cardno, nationality, familyhead, address, income, mobno, email, password, adultunit , childunit, "
					+ "( adultunit + childunit ) AS totalCount FROM `usertable` WHERE cardno = '" + Username +"'";
			//System.out.println(sql);
			ResultSet rs=stmt.executeQuery(sql);
			if(rs.next()){
				
				
				txtnationality.setText(rs.getString(3));
				txtfamilyhead.setText(rs.getString(4));
				txtaddr.setText(rs.getString(5));
				txtincome.setText(rs.getString(6));
				txtmobno.setText(rs.getString(7));
				txtemail.setText(rs.getString(8));
				txtadult.setText(rs.getString(10));
				txtchild.setText(rs.getString(11));
				txttotunit.setText(rs.getString(12));	
				
				String getfamilyMemberQuery = "SELECT * FROM family_members WHERE usertable_id = " + rs.getInt(1);
				//System.out.println("getfamilyMemberQuery" + getfamilyMemberQuery);
				ResultSet familyMemberResultSet = stmt.executeQuery(getfamilyMemberQuery);
				
				ArrayList<String> nameList = new ArrayList<String>();
				ArrayList<Integer> ageList = new ArrayList<Integer>();
				ArrayList<Integer> aadharList = new ArrayList<Integer>();

				while(familyMemberResultSet.next()){
					nameList.add(familyMemberResultSet.getString(3));
					ageList.add(familyMemberResultSet.getInt(4));
					aadharList.add(familyMemberResultSet.getInt(5));
		
				}
				
				for(int i=0;i<aadharList.size();i++){
					
					/*System.out.println("nameList at " + i + " is : " + nameList.get(i));
					System.out.println("ageList at " + i + " is : " + ageList.get(i));
					System.out.println("aadharList at " + i + " is : " + aadharList.get(i));*/
				
					Object[] objs = {nameList.get(i) , ageList.get(i), aadharList.get(i)};

					tableModel.addRow(objs);
					
				}

			}
			else
				JOptionPane.showMessageDialog(null, "Invalid Login details...");
			con.close();

		}catch(Exception ex){
			ex.printStackTrace();
			System.out.print(ex);}
		
	}
}
