package collector;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

import distributor.distrimain;
import eration.mainpage;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox; 


public class newdistri extends JFrame {

	private JPanel contentPane;
	private JTextField txtshopname;
	private JTextField txtapplicantname;
	private JTextField txtfathername;
	private JTextField txtNone;
	private JTextField txtshopno;
	private JTextField txtimagepath;
	protected JComboBox yesnobox;
	private JPasswordField txtpassword;
	private JTextArea txtpaddr;
	private JTextArea txtpoaddr;
	
	public String s;
	private JTextField txtyesno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newdistri frame = new newdistri();
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
	public newdistri() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\Edu\\6th sem\\FINAL_PROJECT\\e-ration\\bin\\images.jpg"));
		setTitle("New Distributor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1250, 750);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 0, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("GOVERNMENT OF INDIA");
		label.setForeground(Color.GREEN);
		label.setFont(new Font("Times New Roman", Font.BOLD, 40));
		label.setBounds(393, 13, 502, 42);
		contentPane.add(label);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLUE);
		separator.setBackground(Color.YELLOW);
		separator.setBounds(12, 122, 1208, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLUE);
		separator_1.setBackground(Color.YELLOW);
		separator_1.setBounds(12, 631, 1208, 2);
		contentPane.add(separator_1);
		
		JLabel lblApplicationFormFor = new JLabel("Application Form For New Fair Price Shop");
		lblApplicationFormFor.setForeground(Color.ORANGE);
		lblApplicationFormFor.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblApplicationFormFor.setBounds(403, 53, 478, 42);
		contentPane.add(lblApplicationFormFor);
		
		JLabel lblNameOfThe = new JLabel("1. Name of the Fair Price Shop for which application is made: ");
		lblNameOfThe.setForeground(Color.YELLOW);
		lblNameOfThe.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNameOfThe.setBounds(43, 178, 502, 25);
		contentPane.add(lblNameOfThe);
		
		JLabel lblNameOfThe_1 = new JLabel("2. Name of the Applicant: ");
		lblNameOfThe_1.setForeground(Color.YELLOW);
		lblNameOfThe_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNameOfThe_1.setBounds(43, 216, 502, 25);
		contentPane.add(lblNameOfThe_1);
		
		JLabel lblNameOfThe_2 = new JLabel("3. Name of the Applicant's Father: ");
		lblNameOfThe_2.setForeground(Color.YELLOW);
		lblNameOfThe_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNameOfThe_2.setBounds(43, 255, 502, 25);
		contentPane.add(lblNameOfThe_2);
		
		JLabel lblPermanantAddressOf = new JLabel("4. Permanant Address of the Applicant: ");
		lblPermanantAddressOf.setForeground(Color.YELLOW);
		lblPermanantAddressOf.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblPermanantAddressOf.setBounds(43, 293, 502, 25);
		contentPane.add(lblPermanantAddressOf);
		
		JLabel lblPostalAddressOf = new JLabel("5. Postal Address of the Applicant: ");
		lblPostalAddressOf.setForeground(Color.YELLOW);
		lblPostalAddressOf.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblPostalAddressOf.setBounds(43, 353, 502, 25);
		contentPane.add(lblPostalAddressOf);
		
		JLabel lblHasTheApplicant = new JLabel("6. (A)Has the applicant previously been a fair shop dealer? : ");
		lblHasTheApplicant.setForeground(Color.YELLOW);
		lblHasTheApplicant.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblHasTheApplicant.setBounds(43, 416, 502, 25);
		contentPane.add(lblHasTheApplicant);
		
		JLabel lblbifSo = new JLabel("    (B)If so, When And Where? : ");
		lblbifSo.setForeground(Color.YELLOW);
		lblbifSo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblbifSo.setBounds(43, 454, 502, 25);
		contentPane.add(lblbifSo);
		
		JLabel lblIDoHereby = new JLabel("I do hereby declare that the facts stated above are true and correct to the best of my knowledge\r\nand belief, and I undertake to be ");
		lblIDoHereby.setForeground(Color.YELLOW);
		lblIDoHereby.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblIDoHereby.setBounds(106, 531, 1017, 25);
		contentPane.add(lblIDoHereby);
		
		JLabel lblPersonallyLiableIf = new JLabel("personally liable if the facts stated above are found to be incorrect or\r\nuntrue in any way. ");
		lblPersonallyLiableIf.setForeground(Color.YELLOW);
		lblPersonallyLiableIf.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblPersonallyLiableIf.setBounds(64, 549, 1080, 25);
		contentPane.add(lblPersonallyLiableIf);
		
		txtshopname = new JTextField();
		txtshopname.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtshopname.setColumns(10);
		txtshopname.setBounds(572, 178, 467, 26);
		contentPane.add(txtshopname);
		
		txtapplicantname = new JTextField();
		txtapplicantname.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtapplicantname.setColumns(10);
		txtapplicantname.setBounds(572, 219, 467, 26);
		contentPane.add(txtapplicantname);
		
		txtfathername = new JTextField();
		txtfathername.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtfathername.setColumns(10);
		txtfathername.setBounds(572, 258, 467, 26);
		contentPane.add(txtfathername);
		
		txtNone = new JTextField();
		txtNone.setHorizontalAlignment(SwingConstants.CENTER);
		txtNone.setText("NONE");
		txtNone.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtNone.setColumns(10);
		txtNone.setBounds(572, 457, 467, 26);
		contentPane.add(txtNone);
		
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		
		JButton btnUploadSignature = new JButton("Upload Signature");
		btnUploadSignature.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				FileNameExtensionFilter filter = new FileNameExtensionFilter("*.image","jpg","png");
				fileChooser.addChoosableFileFilter(filter);
				int result = fileChooser.showOpenDialog(btnUploadSignature);
				if (result == JFileChooser.APPROVE_OPTION) 
				{
				    File selectedFile = fileChooser.getSelectedFile();
				    String path = selectedFile.getAbsolutePath();
				    s = path;
				}
				txtimagepath.setText(fileChooser.getSelectedFile().getName());
								
			}
		});
		btnUploadSignature.setForeground(Color.CYAN);
		btnUploadSignature.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnUploadSignature.setBackground(new Color(51, 0, 255));
		btnUploadSignature.setBounds(949, 576, 195, 40);
		contentPane.add(btnUploadSignature);
		
		JButton btnAddDistributor = new JButton("ADD DISTRIBUTOR");
		btnAddDistributor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try
				{
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/e-ration","root","");
					Statement stmt=con.createStatement();
					InputStream is = new FileInputStream(new File(s));
					String sql = "insert into distributor(`shopno`,`password`, `shopname`, `appliname`, `fappliname`, `paddress`, `poaddress`, `preshop`, `location`, `img`) VALUES ('" + txtshopno.getText().toString() + "','" + txtpassword.getText().toString() + "','" + txtshopname.getText().toString() + "','" + txtapplicantname.getText().toString() + "','" + txtfathername.getText().toString() + "','" + txtpaddr.getText().toString() + "','" + txtpoaddr.getText().toString() + "','" + txtyesno.getText().toString() + "','" + txtNone.getText().toString() + "','"+is+"')";					
					int rs = stmt.executeUpdate(sql);
					
					JOptionPane.showMessageDialog(null, "Distributor has been created..");
					
					txtshopname.setText(null);
					txtshopno.setText(null);
					txtapplicantname.setText(null);
					txtfathername.setText(null);
					txtNone.setText("NONE");
					txtyesno.setText(null);
					txtpaddr.setText(null);
					txtpoaddr.setText(null);
					txtimagepath.setText(null);
					txtpassword.setText(null);
					

					
				}
				catch(Exception ex)
				{
					
					//System.out.print(ex);
					//ex.printStackTrace();

					JOptionPane.showMessageDialog(null, "Something went wrong. Please Try Again...");
					
				}
				
				
			}
		});
		btnAddDistributor.setForeground(Color.CYAN);
		btnAddDistributor.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnAddDistributor.setBackground(new Color(51, 0, 255));
		btnAddDistributor.setBounds(955, 657, 223, 39);
		contentPane.add(btnAddDistributor);
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtshopno.setText(null);
				txtapplicantname.setText(null);
				txtfathername.setText(null);
				//textField_3.setText(null);
				txtNone.setText(null);
				txtshopname.setText(null);
				txtimagepath.setText(null);
				yesnobox.setSelectedIndex(0);
				
			}
		});
		btnReset.setForeground(Color.CYAN);
		btnReset.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnReset.setBackground(new Color(51, 0, 255));
		btnReset.setBounds(765, 657, 153, 39);
		contentPane.add(btnReset);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		        new collectormain().setVisible(true);
		        Component component = (Component) e.getSource();
		        JFrame newdistri = (JFrame) SwingUtilities.getRoot(component);
		        newdistri.dispose();
				
			}
		});
		btnBack.setForeground(Color.CYAN);
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnBack.setBackground(new Color(51, 0, 255));
		btnBack.setBounds(22, 657, 153, 39);
		contentPane.add(btnBack);
		
		JLabel lblShopNo = new JLabel("SHOP NO.: ");
		lblShopNo.setForeground(Color.YELLOW);
		lblShopNo.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblShopNo.setBounds(22, 134, 111, 31);
		contentPane.add(lblShopNo);
		
		txtshopno = new JTextField();
		txtshopno.setEditable(false);
		txtshopno.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtshopno.setColumns(10);
		txtshopno.setBounds(139, 139, 233, 26);
		contentPane.add(txtshopno);
		
		JButton btnGenerateShopNo = new JButton("CREATE SHOP NO.");
		btnGenerateShopNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Random rn = new Random(); 
			    int i = rn.nextInt(10000)+1;
			    String val=String.valueOf(i);
			    txtshopno.setText(val);
				
			}
		});
		btnGenerateShopNo.setForeground(Color.CYAN);
		btnGenerateShopNo.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnGenerateShopNo.setBackground(new Color(51, 0, 255));
		btnGenerateShopNo.setBounds(412, 137, 179, 32);
		contentPane.add(btnGenerateShopNo);
		
		txtimagepath = new JTextField();
		txtimagepath.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtimagepath.setColumns(10);
		txtimagepath.setBounds(462, 585, 467, 26);
		contentPane.add(txtimagepath);
		
		JLabel lblPassword = new JLabel("8. Password: ");
		lblPassword.setForeground(Color.YELLOW);
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblPassword.setBounds(43, 493, 111, 25);
		contentPane.add(lblPassword);
		
		txtpassword = new JPasswordField();
		txtpassword.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtpassword.setEchoChar('*');
		txtpassword.setBounds(166, 492, 217, 31);
		contentPane.add(txtpassword);
		
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
		chckbxShowPass.setForeground(Color.CYAN);
		chckbxShowPass.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		chckbxShowPass.setBackground(new Color(51, 0, 51));
		chckbxShowPass.setBounds(406, 497, 113, 25);
		contentPane.add(chckbxShowPass);
		
		txtpaddr = new JTextArea();
		txtpaddr.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtpaddr.setBounds(571, 296, 468, 55);
		contentPane.add(txtpaddr);
		
		txtpoaddr = new JTextArea();
		txtpoaddr.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtpoaddr.setBounds(571, 356, 468, 55);
		contentPane.add(txtpoaddr);
		
		txtyesno = new JTextField();
		txtyesno.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtyesno.setColumns(10);
		txtyesno.setBounds(572, 424, 179, 26);
		contentPane.add(txtyesno);
		
		JLabel lblTypeOnlyYes = new JLabel("Type only YES or NO");
		lblTypeOnlyYes.setForeground(Color.CYAN);
		lblTypeOnlyYes.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblTypeOnlyYes.setBounds(765, 422, 153, 25);
		contentPane.add(lblTypeOnlyYes);
	}
}
