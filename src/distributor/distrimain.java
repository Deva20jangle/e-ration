package distributor;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;






import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JSeparator;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import eration.mainpage;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import collector.newdistri;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.Console;

import javax.mail.*;
import javax.mail.internet.*;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

//import javax.mail.internet.MimeMessage;





import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class distrimain extends JFrame {
	
	
	String iTax,istotal,itotal;
	double[] itemcost = new double[10];
	

	private JPanel contentPane;
	private JTextField txtwheat;
	private JTextField txtrice;
	private JTextField txtsugar;
	private JTextField txtdal;
	private JTextField txtkerosene;
	private JTextField txttax;
	private JTextField txtstotal;
	private JTextField txttotal;
	private JTextField txtemail;
	private JTextField txtcardno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					distrimain frame = new distrimain();
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
	public distrimain() {
		setTitle("E_RATION Distributor");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent arg0) {
				
				txtwheat.setEnabled(false);
				txtrice.setEnabled(false);
				txtsugar.setEnabled(false);
				txtdal.setEnabled(false);
				txtkerosene.setEnabled(false);
				
				/*txttax.setEnabled(false);
				txtstotal.setEnabled(false);
				txttotal.setEnabled(false);*/
				
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\Edu\\6th sem\\FINAL_PROJECT\\e-ration\\bin\\images.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 735);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 0, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLUE);
		separator.setBackground(Color.YELLOW);
		separator.setBounds(12, 113, 808, 2);
		contentPane.add(separator);
		
		JLabel label = new JLabel("GOVERNMENT OF INDIA");
		label.setForeground(Color.GREEN);
		label.setFont(new Font("Times New Roman", Font.BOLD, 35));
		label.setBounds(217, 13, 441, 50);
		contentPane.add(label);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLUE);
		separator_1.setBackground(Color.YELLOW);
		separator_1.setBounds(12, 593, 808, 2);
		contentPane.add(separator_1);
		
		JButton btnadduser = new JButton("ADD USER");
		btnadduser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		        new newuserregi().setVisible(true);
		        Component component = (Component) e.getSource();
		        JFrame distrimain = (JFrame) SwingUtilities.getRoot(component);
		        distrimain.dispose();
				
			}
		});
		btnadduser.setForeground(Color.CYAN);
		btnadduser.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnadduser.setBackground(new Color(51, 0, 255));
		btnadduser.setBounds(35, 608, 136, 39);
		contentPane.add(btnadduser);
		
		JButton btnstock = new JButton("UPDATE STOCK");
		btnstock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		        new stock().setVisible(true);
		        Component component = (Component) e.getSource();
		        JFrame distrimain = (JFrame) SwingUtilities.getRoot(component);
		        distrimain.dispose();
				
			}
		});
		btnstock.setForeground(Color.CYAN);
		btnstock.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnstock.setBackground(new Color(51, 0, 255));
		btnstock.setBounds(217, 608, 163, 39);
		contentPane.add(btnstock);
		
		JButton btnlogout = new JButton("LOG OUT");
		btnlogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int confirmed = JOptionPane.showConfirmDialog(null, 
				        "Are you sure you want to logout?", "Exit Program Message Box",
				        JOptionPane.YES_NO_OPTION);

				    if (confirmed == JOptionPane.YES_OPTION) {
				      
				    	new distributorlogin().setVisible(true);
				        Component component = (Component) e.getSource();
				        JFrame distrimain = (JFrame) SwingUtilities.getRoot(component);
				        distrimain.dispose();
				    	//dispose();
				    }
				
			}
		});
		btnlogout.setForeground(Color.CYAN);
		btnlogout.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnlogout.setBackground(new Color(51, 0, 255));
		btnlogout.setBounds(684, 645, 136, 30);
		contentPane.add(btnlogout);
		
		JButton btnWheat = new JButton("Wheat");
		btnWheat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtwheat.setEnabled(true);
				txtwheat.setText("");
				txtwheat.requestFocus();
				
			}
		});
		btnWheat.setForeground(Color.RED);
		btnWheat.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnWheat.setBackground(Color.CYAN);
		btnWheat.setBounds(23, 160, 136, 30);
		contentPane.add(btnWheat);
		
		JButton btnRice = new JButton("Rice");
		btnRice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtrice.setEnabled(true);
				txtrice.setText("");
				txtrice.requestFocus();
				
			}
		});
		btnRice.setForeground(Color.RED);
		btnRice.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnRice.setBackground(Color.CYAN);
		btnRice.setBounds(23, 214, 136, 30);
		contentPane.add(btnRice);
		
		JButton btnSugar = new JButton("Sugar");
		btnSugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtsugar.setEnabled(true);
				txtsugar.setText("");
				txtsugar.requestFocus();
				
			}
		});
		btnSugar.setForeground(Color.RED);
		btnSugar.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSugar.setBackground(Color.CYAN);
		btnSugar.setBounds(23, 268, 136, 30);
		contentPane.add(btnSugar);
		
		JButton btnDal = new JButton("Dal");
		btnDal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtdal.setEnabled(true);
				txtdal.setText("");
				txtdal.requestFocus();
				
			}
		});
		btnDal.setForeground(Color.RED);
		btnDal.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnDal.setBackground(Color.CYAN);
		btnDal.setBounds(23, 322, 136, 30);
		contentPane.add(btnDal);
		
		JButton btnKerosene = new JButton("Kerosene");
		btnKerosene.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtkerosene.setEnabled(true);
				txtkerosene.setText("");
				txtkerosene.requestFocus();
				
			}
		});
		btnKerosene.setForeground(Color.RED);
		btnKerosene.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnKerosene.setBackground(Color.CYAN);
		btnKerosene.setBounds(23, 375, 136, 30);
		contentPane.add(btnKerosene);
		
		txtwheat = new JTextField();
		txtwheat.setText("0");
		txtwheat.setHorizontalAlignment(SwingConstants.CENTER);
		txtwheat.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtwheat.setColumns(10);
		txtwheat.setBounds(201, 164, 163, 26);
		contentPane.add(txtwheat);
		
		txtrice = new JTextField();
		txtrice.setText("0");
		txtrice.setHorizontalAlignment(SwingConstants.CENTER);
		txtrice.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtrice.setColumns(10);
		txtrice.setBounds(201, 218, 163, 26);
		contentPane.add(txtrice);
		
		txtsugar = new JTextField();
		txtsugar.setText("0");
		txtsugar.setHorizontalAlignment(SwingConstants.CENTER);
		txtsugar.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtsugar.setColumns(10);
		txtsugar.setBounds(201, 269, 163, 26);
		contentPane.add(txtsugar);
		
		txtdal = new JTextField();
		txtdal.setText("0");
		txtdal.setHorizontalAlignment(SwingConstants.CENTER);
		txtdal.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtdal.setColumns(10);
		txtdal.setBounds(201, 326, 163, 26);
		contentPane.add(txtdal);
		
		txtkerosene = new JTextField();
		txtkerosene.setText("0");
		txtkerosene.setHorizontalAlignment(SwingConstants.CENTER);
		txtkerosene.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtkerosene.setColumns(10);
		txtkerosene.setBounds(201, 379, 163, 26);
		contentPane.add(txtkerosene);
		
		JLabel lblTax = new JLabel("Tax :");
		lblTax.setForeground(Color.YELLOW);
		lblTax.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTax.setBounds(469, 160, 120, 25);
		contentPane.add(lblTax);
		
		JLabel lblSubtotal = new JLabel("SubTotal :");
		lblSubtotal.setForeground(Color.YELLOW);
		lblSubtotal.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblSubtotal.setBounds(469, 198, 120, 25);
		contentPane.add(lblSubtotal);
		
		JLabel lblTotal = new JLabel("Total :");
		lblTotal.setForeground(Color.YELLOW);
		lblTotal.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTotal.setBounds(469, 236, 120, 25);
		contentPane.add(lblTotal);
		
		txttax = new JTextField();
		txttax.setText("0");
		txttax.setHorizontalAlignment(SwingConstants.CENTER);
		txttax.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txttax.setColumns(10);
		txttax.setBounds(601, 164, 163, 26);
		contentPane.add(txttax);
		
		txtstotal = new JTextField();
		txtstotal.setText("0");
		txtstotal.setHorizontalAlignment(SwingConstants.CENTER);
		txtstotal.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtstotal.setColumns(10);
		txtstotal.setBounds(601, 201, 163, 26);
		contentPane.add(txtstotal);
		
		txttotal = new JTextField();
		txttotal.setText("0");
		txttotal.setHorizontalAlignment(SwingConstants.CENTER);
		txttotal.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txttotal.setColumns(10);
		txttotal.setBounds(601, 239, 163, 26);
		contentPane.add(txttotal);
		
		JTextArea txtreceipt = new JTextArea();
		txtreceipt.setBounds(395, 282, 369, 160);
		contentPane.add(txtreceipt);
		
		JButton btnTotal = new JButton("TOTAL");
		btnTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				itemcost[0] = Double.parseDouble(txtwheat.getText()) *5;
				itemcost[1] = Double.parseDouble(txtrice.getText()) *3;
				itemcost[2] = Double.parseDouble(txtsugar.getText()) *4;
				itemcost[3] = Double.parseDouble(txtdal.getText()) *3.5;
				itemcost[4] = Double.parseDouble(txtkerosene.getText()) *10;
				
				itemcost[5] = itemcost[0] + itemcost[1] + itemcost[2] + itemcost[3] + itemcost[4];
				
				iTax = String.format("Rs. %.2f", itemcost[5]/5);
				istotal = String.format("Rs. %.2f", itemcost[5]);
				itotal = String.format("Rs. %.2f", itemcost[5] + (itemcost[5] / 5));
				
				txttax.setText(iTax);
				txtstotal.setText(istotal);
				txttotal.setText(itotal);
				
				
				txtreceipt.setEnabled(true);
				int refs= 1325 + (int) (Math.random()*4238);
				
				Calendar timer = Calendar.getInstance();
				timer.getTime();
				SimpleDateFormat tTime = new SimpleDateFormat("HH:mm:ss");
				tTime.format(timer.getTime());
				SimpleDateFormat tDate = new SimpleDateFormat("dd-MM-yyyy");
				tDate.format(timer.getTime());
				
				txtreceipt.append("\t ====== YOUR BILL ======\n" + "Reference: " + refs + "\n ====================================================\t" + 
				"\n ====================================================\t" + "\n Tax: \t\t\t" + iTax + 
				"\n SubTotal: \t\t\t" + istotal + "\n Total: \t\t\t" +itotal + "\n ====================================================\t" + 
				"\nDate: " + tDate.format(timer.getTime()) + "\tTime: " + tTime.format(timer.getTime()) + "\n\t   Thank You For Coming...");				
				
				
				
				
			}
		});
		btnTotal.setForeground(Color.RED);
		btnTotal.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnTotal.setBackground(Color.CYAN);
		btnTotal.setBounds(654, 455, 110, 30);
		contentPane.add(btnTotal);
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				txtreceipt.setText("");
				txtreceipt.setEnabled(false);
				txtwheat.setText("0");
				txtrice.setText("0");
				txtsugar.setText("0");
				txtdal.setText("0");
				txtkerosene.setText("0");
				txttax.setText("0");
				txtstotal.setText("0");
				txttotal.setText("0");
				
				txtwheat.setEnabled(false);
				txtrice.setEnabled(false);
				txtsugar.setEnabled(false);
				txtdal.setEnabled(false);
				txtkerosene.setEnabled(false);
				
				/*txttax.setEnabled(false);
				txtstotal.setEnabled(false);
				txttotal.setEnabled(false);*/
				
			}
		});
		btnReset.setForeground(Color.RED);
		btnReset.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnReset.setBackground(Color.CYAN);
		btnReset.setBounds(532, 455, 110, 30);
		contentPane.add(btnReset);
		
		JButton btnSend = new JButton("SEND");
		btnSend.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
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
						message.setSubject("BILL FOR YOUR RATION PURCHASE.");
						message.setText(txtreceipt.getText());

						Transport.send(message);

						//System.out.println("Done");
						
						txtemail.setText(null);
						txtreceipt.setText("");
						txtreceipt.setEnabled(false);
						txtwheat.setText("0");
						txtrice.setText("0");
						txtsugar.setText("0");
						txtdal.setText("0");
						txtkerosene.setText("0");
						txttax.setText("0");
						txtstotal.setText("0");
						txttotal.setText("0");
						
						txtwheat.setEnabled(false);
						txtrice.setEnabled(false);
						txtsugar.setEnabled(false);
						txtdal.setEnabled(false);
						txtkerosene.setEnabled(false);
						
						txtcardno.setText(null);
						
						
						JOptionPane.showMessageDialog(null, "Bill has been send.");
						

					} catch (MessagingException e) {
						
						JOptionPane.showMessageDialog(null, "Something went wrong....Try again later...");
						
						//throw new RuntimeException(e);
						
						
					}
				
				
				
			//txtemail.setText(null);
				
			}
		});
		btnSend.setForeground(Color.RED);
		btnSend.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSend.setBackground(Color.CYAN);
		btnSend.setBounds(689, 550, 110, 30);
		contentPane.add(btnSend);
		
		txtemail = new JTextField();
		txtemail.setEditable(false);
		txtemail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtemail.setColumns(10);
		txtemail.setBounds(308, 551, 360, 29);
		contentPane.add(txtemail);
		
		txtcardno = new JTextField();
		txtcardno.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtcardno.setColumns(10);
		txtcardno.setBounds(308, 508, 201, 29);
		contentPane.add(txtcardno);
		
		JButton btnGetUser = new JButton("GET USER E-mail");
		btnGetUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/e-ration","root","");
					Statement stmt=con.createStatement();
					//String sql="Select * from usertable where cardno='"+Username+"'";
					String sql = "SELECT email FROM `usertable` WHERE cardno = '" + txtcardno.getText() +"'";
					//System.out.println(sql);
					ResultSet rs=stmt.executeQuery(sql);
					if(rs.next())
					{
						txtemail.setText(rs.getString(1));
					}
					
					}
				catch (Exception e) 
				{
					
					e.printStackTrace();
				}
				
			}
		});
		btnGetUser.setForeground(Color.RED);
		btnGetUser.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnGetUser.setBackground(Color.CYAN);
		btnGetUser.setBounds(601, 507, 198, 30);
		contentPane.add(btnGetUser);
		
		JButton btnReset_1 = new JButton("RESET");
		btnReset_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtcardno.setText(null);
				txtemail.setText(null);
				
			}
		});
		btnReset_1.setForeground(Color.CYAN);
		btnReset_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnReset_1.setBackground(new Color(51, 0, 255));
		btnReset_1.setBounds(410, 608, 163, 39);
		contentPane.add(btnReset_1);
		
		JLabel lblDistributorMain = new JLabel("Distributor Main");
		lblDistributorMain.setForeground(Color.ORANGE);
		lblDistributorMain.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblDistributorMain.setBounds(315, 56, 245, 42);
		contentPane.add(lblDistributorMain);
	}
}
