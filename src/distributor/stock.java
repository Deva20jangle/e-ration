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
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import user.complaint;
import user.usermain;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class stock extends JFrame {

	private JPanel contentPane;
	private JTextField txtwheat;
	private JTextField txtrice;
	private JTextField txtsugar;
	private JTextField txtdal;
	private JTextField txtkerosene;
	private JTextField txtshopno;
	private JTextField txtmonth;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					stock frame = new stock();
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
	public stock() {
		setTitle("Stock Availability");
		setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\Edu\\6th sem\\FINAL_PROJECT\\e-ration\\bin\\images.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 530);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 0, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("GOVERNMENT OF INDIA");
		label.setForeground(Color.GREEN);
		label.setFont(new Font("Times New Roman", Font.BOLD, 40));
		label.setBounds(68, 13, 502, 42);
		contentPane.add(label);
		
		JLabel lblStockAvailability = new JLabel("Stock Availability");
		lblStockAvailability.setForeground(Color.ORANGE);
		lblStockAvailability.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblStockAvailability.setBounds(206, 54, 249, 42);
		contentPane.add(lblStockAvailability);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLUE);
		separator.setBackground(Color.YELLOW);
		separator.setBounds(12, 94, 608, 2);
		contentPane.add(separator);
		
		JLabel lblMonth = new JLabel("Month :");
		lblMonth.setForeground(Color.CYAN);
		lblMonth.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblMonth.setBounds(44, 151, 93, 29);
		contentPane.add(lblMonth);
		
		JLabel lblWheat = new JLabel("Wheat :");
		lblWheat.setForeground(Color.ORANGE);
		lblWheat.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblWheat.setBounds(57, 228, 85, 24);
		contentPane.add(lblWheat);
		
		JLabel lblRice = new JLabel("Rice :");
		lblRice.setForeground(Color.ORANGE);
		lblRice.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblRice.setBounds(346, 228, 85, 24);
		contentPane.add(lblRice);
		
		JLabel lblSugar = new JLabel("Sugar :");
		lblSugar.setForeground(Color.ORANGE);
		lblSugar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblSugar.setBounds(57, 276, 85, 24);
		contentPane.add(lblSugar);
		
		JLabel lblDal = new JLabel("Dal :");
		lblDal.setForeground(Color.ORANGE);
		lblDal.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblDal.setBounds(346, 274, 87, 24);
		contentPane.add(lblDal);
		
		JLabel lblKerosene = new JLabel("Kerosene :");
		lblKerosene.setForeground(Color.ORANGE);
		lblKerosene.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblKerosene.setBounds(57, 327, 87, 24);
		contentPane.add(lblKerosene);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLUE);
		separator_1.setBackground(Color.YELLOW);
		separator_1.setBounds(12, 383, 608, 2);
		contentPane.add(separator_1);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		        new distrimain().setVisible(true);
		        Component component = (Component) e.getSource();
		        JFrame stock = (JFrame) SwingUtilities.getRoot(component);
		        stock.dispose();
				
			}
		});
		btnBack.setForeground(Color.CYAN);
		btnBack.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnBack.setBackground(new Color(51, 0, 255));
		btnBack.setBounds(44, 418, 115, 33);
		contentPane.add(btnBack);
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				txtshopno.setText(null);
				txtmonth.setText(null);
				txtwheat.setText(null);
				txtrice.setText(null);
				txtsugar.setText(null);
				txtdal.setText(null);
				txtkerosene.setText(null);
				
			}
		});
		btnReset.setForeground(Color.CYAN);
		btnReset.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnReset.setBackground(new Color(51, 0, 255));
		btnReset.setBounds(244, 418, 115, 33);
		contentPane.add(btnReset);
		
		JButton btnUdtStock = new JButton("New Month");
		btnUdtStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				

				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/e-ration","root","");
					Statement stmt=con.createStatement();
					String sql="insert into stock(`shopno`,`month`, `wheat`, `rice`, `sugar`, `dal`, `kero`) "
							+ " VALUES ('" + txtshopno.getText().toString() + "','" + txtmonth.getText().toString() + "','" 
							+ txtwheat.getText().toString() + "','" + txtrice.getText().toString() 
							+ "','" + txtsugar.getText().toString() + "','" + txtdal.getText().toString() + "','" + txtkerosene.getText().toString() + "')";
					//System.out.println(sql);
					int rs=stmt.executeUpdate(sql);
					
					txtshopno.setText(null);
					txtmonth.setText(null);
					txtwheat.setText(null);
					txtdal.setText(null);
					txtsugar.setText(null);
					txtrice.setText(null);
					txtkerosene.setText(null);
					
					JOptionPane.showMessageDialog(null, "New month stock is updated.");
					
				}
				catch(Exception ex)
				{
					//ex.printStackTrace();
					
					//System.out.print(ex);
					JOptionPane.showMessageDialog(null, "Something went wrong. Please Try Again...");
					
				}
				
			}
		});
		btnUdtStock.setForeground(Color.CYAN);
		btnUdtStock.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnUdtStock.setBackground(new Color(51, 0, 255));
		btnUdtStock.setBounds(458, 337, 144, 33);
		contentPane.add(btnUdtStock);
		
		txtwheat = new JTextField();
		txtwheat.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtwheat.setBounds(154, 230, 159, 24);
		contentPane.add(txtwheat);
		txtwheat.setColumns(10);
		
		txtrice = new JTextField();
		txtrice.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtrice.setColumns(10);
		txtrice.setBounds(443, 231, 159, 24);
		contentPane.add(txtrice);
		
		txtsugar = new JTextField();
		txtsugar.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtsugar.setColumns(10);
		txtsugar.setBounds(154, 279, 159, 24);
		contentPane.add(txtsugar);
		
		txtdal = new JTextField();
		txtdal.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtdal.setColumns(10);
		txtdal.setBounds(445, 276, 159, 24);
		contentPane.add(txtdal);
		
		txtkerosene = new JTextField();
		txtkerosene.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtkerosene.setColumns(10);
		txtkerosene.setBounds(154, 329, 159, 24);
		contentPane.add(txtkerosene);
		
		txtshopno = new JTextField();
		txtshopno.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtshopno.setColumns(10);
		txtshopno.setBounds(216, 109, 175, 29);
		contentPane.add(txtshopno);
		
		txtmonth = new JTextField();
		txtmonth.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtmonth.setColumns(10);
		txtmonth.setBounds(216, 154, 175, 29);
		contentPane.add(txtmonth);
		
		JLabel lblDistributor = new JLabel("Shop no.: ");
		lblDistributor.setForeground(Color.CYAN);
		lblDistributor.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblDistributor.setBounds(44, 109, 145, 29);
		contentPane.add(lblDistributor);
		
		JButton btnUpdateStock = new JButton("Update Stock");
		btnUpdateStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/e-ration","root","");
					Statement stmt=con.createStatement();
					String sql="UPDATE `stock` SET `wheat`='" + txtwheat.getText().toString() + "',`rice`='" + txtrice.getText().toString() + "',`sugar`='" + txtsugar.getText().toString() + "',"
							+ "`dal`='" + txtdal.getText().toString() + "',`kero`='" + txtkerosene.getText().toString() + "'"
									+ " WHERE shopno = '"+ txtshopno.getText() +"' and month = '"+ txtmonth.getText() +"'";
					//System.out.println(sql);
					int rs=stmt.executeUpdate(sql);
					
					txtwheat.setText(null);
					txtdal.setText(null);
					txtsugar.setText(null);
					txtrice.setText(null);
					txtkerosene.setText(null);
					txtshopno.setText(null);
					txtmonth.setText(null);
					
					JOptionPane.showMessageDialog(null, "Stock updated successfully.");
					
				}
				catch(Exception ex)
				{
					//ex.printStackTrace();
					
					//System.out.print(ex);
					JOptionPane.showMessageDialog(null, "Something went wrong. Please Try Again...");
					
				}
				
			}
		});
		btnUpdateStock.setForeground(Color.CYAN);
		btnUpdateStock.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnUpdateStock.setBackground(new Color(51, 0, 255));
		btnUpdateStock.setBounds(426, 418, 144, 33);
		contentPane.add(btnUpdateStock);
		
		JLabel lblMonthMustBe = new JLabel("Month must be like January 2000");
		lblMonthMustBe.setForeground(Color.CYAN);
		lblMonthMustBe.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblMonthMustBe.setBounds(407, 161, 199, 24);
		contentPane.add(lblMonthMustBe);
	}
}
