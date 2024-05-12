package distributor;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

import eration.mainpage;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;

public class newuserregi extends JFrame {

	private JPanel contentPane;
	private JTextField txtincome;
	private JTextField txtfamilyhead;
	private JTextField txtnationality;
	private JTextField txtcardno;
	private JTextField txtmobno;
	private JTextField txtemail;
	private JTextField txtadult;
	private JTextField txtchild;
	private JTextField txtverify;
	private JTable table;
	private JComboBox memberno;
	
	String cardNo = "";
	private JPasswordField txtpassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newuserregi frame = new newuserregi();
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
	public newuserregi() {
		setTitle("New User Registration");
		setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\Edu\\6th sem\\FINAL_PROJECT\\e-ration\\bin\\images.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(20, 10, 935, 1030);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 0, 51));
		contentPane.setBorder(new EmptyBorder(16, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("GOVERNMENT OF INDIA");
		label.setForeground(Color.GREEN);
		label.setFont(new Font("Times New Roman", Font.BOLD, 35));
		label.setBounds(251, 13, 441, 50);
		contentPane.add(label);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLUE);
		separator.setBackground(Color.YELLOW);
		separator.setBounds(12, 113, 888, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLUE);
		separator_1.setBackground(Color.YELLOW);
		separator_1.setBounds(12, 916, 888, 2);
		contentPane.add(separator_1);
		
		JLabel label_1 = new JLabel("Ration Card No.: ");
		label_1.setForeground(Color.YELLOW);
		label_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label_1.setBounds(28, 360, 152, 25);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Nationality :");
		label_2.setForeground(Color.YELLOW);
		label_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label_2.setBounds(28, 128, 120, 25);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Name of Family Head :");
		label_3.setForeground(Color.YELLOW);
		label_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label_3.setBounds(28, 166, 219, 25);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Address :");
		label_4.setForeground(Color.YELLOW);
		label_4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label_4.setBounds(28, 204, 120, 25);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("Annual Income : ");
		label_5.setForeground(Color.YELLOW);
		label_5.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label_5.setBounds(28, 282, 158, 25);
		contentPane.add(label_5);
		
		txtincome = new JTextField();
		txtincome.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtincome.setColumns(10);
		txtincome.setBounds(251, 285, 231, 24);
		contentPane.add(txtincome);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(251, 207, 498, 65);
		contentPane.add(scrollPane);
		
		JTextArea txtaddress = new JTextArea();
		scrollPane.setViewportView(txtaddress);
		txtaddress.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		txtfamilyhead = new JTextField();
		txtfamilyhead.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtfamilyhead.setColumns(10);
		txtfamilyhead.setBounds(251, 169, 313, 24);
		contentPane.add(txtfamilyhead);
		
		txtnationality = new JTextField();
		txtnationality.setEnabled(false);
		txtnationality.setText("Indian");
		txtnationality.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtnationality.setColumns(10);
		txtnationality.setBounds(251, 131, 231, 24);
		contentPane.add(txtnationality);
		
		txtcardno = new JTextField();
		txtcardno.setEditable(false);
		txtcardno.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtcardno.setColumns(10);
		txtcardno.setBounds(251, 364, 231, 24);
		contentPane.add(txtcardno);
		
		JLabel lblMobileNo = new JLabel("Mobile No.: ");
		lblMobileNo.setForeground(Color.YELLOW);
		lblMobileNo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblMobileNo.setBounds(28, 320, 200, 25);
		contentPane.add(lblMobileNo);
		
		JLabel lblEmailId = new JLabel("E-mail id: ");
		lblEmailId.setForeground(Color.YELLOW);
		lblEmailId.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblEmailId.setBounds(28, 412, 200, 25);
		contentPane.add(lblEmailId);
		
		txtmobno = new JTextField();
		txtmobno.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtmobno.setColumns(10);
		txtmobno.setBounds(251, 323, 231, 24);
		contentPane.add(txtmobno);
		
		txtemail = new JTextField();
		txtemail.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtemail.setColumns(10);
		txtemail.setBounds(251, 415, 316, 24);
		contentPane.add(txtemail);
		
		JLabel label_8 = new JLabel("Number of Units : ");
		label_8.setForeground(Color.YELLOW);
		label_8.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label_8.setBounds(28, 587, 152, 25);
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel("Name of Family Members : ");
		label_9.setForeground(Color.YELLOW);
		label_9.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label_9.setBounds(28, 693, 231, 25);
		contentPane.add(label_9);
		
		JButton btnGenerateCardNo = new JButton("GENERATE CARD NO.");
		btnGenerateCardNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Random rn = new Random(); 
			    int i = rn.nextInt(1000000)+1;
			    String val=String.valueOf(i);
			    txtcardno.setText(val);
				
			}
		});
		btnGenerateCardNo.setForeground(Color.CYAN);
		btnGenerateCardNo.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnGenerateCardNo.setBackground(new Color(51, 0, 255));
		btnGenerateCardNo.setBounds(546, 358, 208, 32);
		contentPane.add(btnGenerateCardNo);
		
		JButton btnSendOtp = new JButton("SEND OTP");
		btnSendOtp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Random num1 = new Random();
				int otp = num1.nextInt(864198)+123456;
				String otp_string = Integer.toString(otp);
				
				try
				{
					Connection conn = null;
					String url = "jdbc:mysql://localhost:3306/";
					String dbname = "e-ration";
					String driver = "com.mysql.jdbc.Driver";
					String userName = "root";
					String pass = "";
					Class.forName(driver).newInstance();
					conn = DriverManager.getConnection(url+dbname,userName,pass);
					PreparedStatement ps=conn.prepareStatement("insert into otp values (?,?)");
					ps.setString(1, txtemail.getText());
					ps.setString(2, otp_string);
					ps.executeUpdate();
					
					
					
					//JOptionPane.showMessageDialog(null,"Data inserted successfully..!");
					System.out.println(otp_string);
				}catch(Exception err0)
				{
					//System.out.println(err0);
					//JOptionPane.showMessageDialog(null,"Data not inserted..!");
					
				}
					final String username = "devashishjangle@gmail.com"; // enter your mail id
					final String password = "devashish@20";// enter ur password
					
				    Properties props = new Properties();  
				    props.setProperty("mail.transport.protocol", "smtp");     
				    props.setProperty("mail.host", "smtp.gmail.com");  
				    props.put("mail.smtp.auth", "true");  
				    props.put("mail.smtp.port", "465");  
				    props.put("mail.smtp.socketFactory.port", "465");  
				    props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");  
				    props.put("mail.smtp.socketFactory.fallback", "false");

					Session session = Session.getInstance(props,
					  new javax.mail.Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(username, password);
						}
					  });

					try {

						Message message = new MimeMessage(session);
						message.setFrom(new InternetAddress("devashishjangle@gmail.com")); // same email id
						message.setRecipients(Message.RecipientType.TO,
							InternetAddress.parse(txtemail.getText()));// whome u have to send mails that person id
						message.setSubject("One Time Password to create eration account.");
						message.setText("Dear User Your,"
								+"\n\n\n Your One Time Password(OTP) is... \n\n  "+ otp_string +" \n\n\n Please do not share it to anyone.");
						
						
					
						//enable this line in release mode
						Transport.send(message);
						
						JOptionPane.showMessageDialog(null, "OTP send to "+ txtemail.getText() + " successfully....");
						
						
					} catch (MessagingException e) {
						JOptionPane.showMessageDialog(null, "mail not sent..!");
						//throw new RuntimeException(e);
						
					}
										
				
				
			}
		});
		btnSendOtp.setForeground(Color.CYAN);
		btnSendOtp.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSendOtp.setBackground(new Color(51, 0, 255));
		btnSendOtp.setBounds(56, 462, 172, 32);
		contentPane.add(btnSendOtp);
		
		JLabel lblNewUserRegistration = new JLabel("New User Registration");
		lblNewUserRegistration.setForeground(Color.ORANGE);
		lblNewUserRegistration.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewUserRegistration.setBounds(352, 63, 262, 30);
		contentPane.add(lblNewUserRegistration);
		
		JLabel lblAdult = new JLabel("ADULT");
		lblAdult.setBackground(new Color(204, 204, 204));
		lblAdult.setForeground(Color.YELLOW);
		lblAdult.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblAdult.setBounds(164, 609, 152, 25);
		contentPane.add(lblAdult);
		
		JLabel lblChild = new JLabel("CHILD");
		lblChild.setBackground(new Color(204, 204, 204));
		lblChild.setForeground(Color.YELLOW);
		lblChild.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblChild.setBounds(328, 609, 152, 25);
		contentPane.add(lblChild);
		
		txtadult = new JTextField();
		txtadult.setEnabled(false);
		txtadult.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtadult.setColumns(10);
		txtadult.setBounds(164, 647, 152, 33);
		contentPane.add(txtadult);
		
		txtchild = new JTextField();
		txtchild.setEnabled(false);
		txtchild.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtchild.setColumns(10);
		txtchild.setBounds(317, 647, 152, 33);
		contentPane.add(txtchild);
		
		JButton button = new JButton("RESET");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtfamilyhead.setText(null);
				txtaddress.setText(null);
				txtincome.setText(null);
				txtmobno.setText(null);
				txtcardno.setText(null);
				txtemail.setText(null);
				txtadult.setText(null);
				txtchild.setText(null);
				//txttotalunit.setText(null);
				txtpassword.setText(null);
				
				
			}
		});
		button.setForeground(Color.CYAN);
		button.setFont(new Font("Times New Roman", Font.BOLD, 15));
		button.setBackground(new Color(51, 0, 255));
		button.setBounds(558, 931, 153, 39);
		contentPane.add(button);
		
		JButton btnAddUser = new JButton("ADD USER");
		btnAddUser.setEnabled(false);
		btnAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try
				{
					
					java.util.Date date = new java.util.Date();
					java.sql.Date sqlDate = new java.sql.Date(date.getTime());
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/e-ration","root","");
					Statement stmt=con.createStatement();
					String sql = "insert into usertable(`cardno`,`nationality`, `familyhead`, `address`, `income`, `mobno`, `email`, `password`, `adultunit`, `childunit`) VALUES ('" + txtcardno.getText().toString() + "','" + txtnationality.getText().toString() + "','" + txtfamilyhead.getText().toString() + "','" + txtaddress.getText().toString() + "','" + txtincome.getText().toString() + "','" + txtmobno.getText().toString() + "','" + txtemail.getText().toString() + "','" + txtpassword.getText().toString() + "','" + txtadult.getText().toString() + "','" + txtchild.getText().toString() + "')";
					int rs = stmt.executeUpdate(sql);
					System.out.println("rs" + rs);
					cardNo = txtcardno.getText().toString();
					
					JOptionPane.showMessageDialog(null, "User has been created..");
					
					txtfamilyhead.setText(null);
					txtaddress.setText(null);
					txtincome.setText(null);
					txtmobno.setText(null);
					txtcardno.setText(null);
					txtemail.setText(null);
					txtadult.setText(null);
					txtchild.setText(null);
					//txttotalunit.setText(null);
					txtpassword.setText(null);
					
					
					txtadult.setEnabled(false);
					txtchild.setEnabled(false);
					//txttotalunit.setEnabled(false);
					txtpassword.setEnabled(false);
					btnAddUser.setEnabled(false);
					
				}
				catch(Exception ex)
				{
					
					//System.out.print(ex);
					//ex.printStackTrace();

					JOptionPane.showMessageDialog(null, "Something went wrong. Please Try Again...");
					
				}
				
				try
				{
					
					java.util.Date date = new java.util.Date();
					java.sql.Date sqlDate = new java.sql.Date(date.getTime());
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/e-ration","root","");
					int no = memberno.getSelectedIndex() + 1;
					//System.out.println(no);
					Statement stmt=con.createStatement();
					String getUserTableIdQuery = "SELECT id FROM usertable WHERE cardno = '" +  cardNo +  "'";
					//System.out.println("getUserTableIdQuery : "+ getUserTableIdQuery);

					ResultSet rs=stmt.executeQuery(getUserTableIdQuery);
					int getUserTableId = 0;
					if(rs.next()){
						
						getUserTableId = rs.getInt(1);
						
					}

					//System.out.println("getUserTableId : "+ getUserTableId);

					int row = table.getRowCount();
					int column = table.getColumnCount();
					//System.out.println("column : "+ column);

					for (int j = 0; j  < no; j++) {
							String msql="insert into family_members(usertable_id,name,age, aadhar_no) VALUES ( '" + getUserTableId + "', '" + table.getValueAt(j, 0) + "','" + table.getValueAt(j, 1) + "','" + table.getValueAt(j, 2) + "')";
							//System.out.println(msql);
							int rst=stmt.executeUpdate(msql);
					    
					}
					
					JOptionPane.showMessageDialog(null, "Members are inserted.");
					
					
				}
				catch(Exception ex)
				{
					
					//System.out.print(ex);
					//ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "Something went wrong. Please Try Again...");
					
				}
					
				
			}
		});
		btnAddUser.setForeground(Color.CYAN);
		btnAddUser.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnAddUser.setBackground(new Color(51, 0, 255));
		btnAddUser.setBounds(748, 931, 152, 39);
		contentPane.add(btnAddUser);
		
		JButton button_2 = new JButton("BACK");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		        new distrimain().setVisible(true);
		        Component component = (Component) e.getSource();
		        JFrame newuserregi = (JFrame) SwingUtilities.getRoot(component);
		        newuserregi.dispose();
				
			}
		});
		button_2.setForeground(Color.CYAN);
		button_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		button_2.setBackground(new Color(51, 0, 255));
		button_2.setBounds(12, 931, 153, 39);
		contentPane.add(button_2);
		
		txtverify = new JTextField();
		txtverify.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtverify.setColumns(10);
		txtverify.setBounds(262, 467, 172, 24);
		contentPane.add(txtverify);
		
		JButton btnVerify = new JButton("VERIFY");
		btnVerify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try
				{
					Connection conn = null;
					String url = "jdbc:mysql://localhost:3306/";
					String dbname = "e-ration";
					String driver = "com.mysql.jdbc.Driver";
					String userName = "root";
					String pass = "";
					Class.forName(driver).newInstance();
					conn = DriverManager.getConnection(url+dbname,userName,pass);
					
					String sql = "select txtotp from otp where email = ?";
					PreparedStatement stmt = conn.prepareStatement(sql);
					stmt.setString(1, txtemail.getText());
					
					ResultSet rs = stmt.executeQuery();
					String otpp = null;
					while(rs.next())
					{
						
						otpp = rs.getString(1);
						
					}
					if (txtverify.getText().equals(otpp))
					{
						
						JOptionPane.showMessageDialog(null, "OTP verified. You can now procced.");
						
						txtadult.setEnabled(true);
						txtchild.setEnabled(true);
						//txttotalunit.setEnabled(true);
						txtpassword.setEnabled(true);
						btnAddUser.setEnabled(true);
						
					}
					else
					{
						
						JOptionPane.showMessageDialog(null, "OTP does not match...!");
						
						txtadult.setEnabled(false);
						txtchild.setEnabled(false);
						//txttotalunit.setEnabled(false);
						txtpassword.setEnabled(false);
						btnAddUser.setEnabled(false);
					
						
					}
					
					
				}catch(Exception e){
					
					JOptionPane.showMessageDialog(null, "Something went wrong ...! Try again later");
					
					txtadult.setEnabled(false);
					txtchild.setEnabled(false);
					//txttotalunit.setEnabled(false);
					txtpassword.setEnabled(false);
					btnAddUser.setEnabled(false);
					
					
				}
				
			}
		});
		btnVerify.setForeground(Color.CYAN);
		btnVerify.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnVerify.setBackground(new Color(51, 0, 255));
		btnVerify.setBounds(462, 462, 172, 32);
		contentPane.add(btnVerify);
		
		JLabel lblPassword = new JLabel("Password: ");
		lblPassword.setForeground(Color.YELLOW);
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblPassword.setBounds(28, 546, 152, 25);
		contentPane.add(lblPassword);
		
		JLabel lblnote = new JLabel("You will not able to procced utill you finished with verification.");
		lblnote.setForeground(Color.CYAN);
		lblnote.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		lblnote.setBounds(12, 518, 465, 25);
		contentPane.add(lblnote);
		
		table = new JTable(6,3);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		table.setEnabled(true);
		table.setRowHeight(22);
		table.setBounds(122, 778, 588, 132);
		contentPane.add(table);
		
		JLabel lblName = new JLabel("NAME: ");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setForeground(Color.YELLOW);
		lblName.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblName.setBackground(new Color(204, 204, 204));
		lblName.setBounds(122, 752, 152, 25);
		contentPane.add(lblName);
		
		JLabel lblAge = new JLabel("AGE: ");
		lblAge.setHorizontalAlignment(SwingConstants.CENTER);
		lblAge.setForeground(Color.YELLOW);
		lblAge.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblAge.setBackground(new Color(204, 204, 204));
		lblAge.setBounds(317, 752, 152, 25);
		contentPane.add(lblAge);
		
		JLabel lblAadharNo = new JLabel("AADHAR NO: ");
		lblAadharNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblAadharNo.setForeground(Color.YELLOW);
		lblAadharNo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblAadharNo.setBackground(new Color(204, 204, 204));
		lblAadharNo.setBounds(511, 752, 152, 25);
		contentPane.add(lblAadharNo);
		
		JLabel lblNoOfMembers = new JLabel("No. of members in family: ");
		lblNoOfMembers.setForeground(Color.YELLOW);
		lblNoOfMembers.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNoOfMembers.setBounds(140, 718, 231, 25);
		contentPane.add(lblNoOfMembers);
		
		memberno = new JComboBox();
		memberno.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		memberno.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6"}));
		memberno.setBounds(369, 720, 51, 25);
		contentPane.add(memberno);
		
		txtpassword = new JPasswordField();
		txtpassword.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtpassword.setEchoChar('*');
		txtpassword.setBounds(164, 547, 197, 26);
		contentPane.add(txtpassword);
		
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
		chckbxShowPass.setForeground(Color.YELLOW);
		chckbxShowPass.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		chckbxShowPass.setBackground(new Color(51, 0, 51));
		chckbxShowPass.setBounds(369, 549, 113, 25);
		contentPane.add(chckbxShowPass);
	}
}
