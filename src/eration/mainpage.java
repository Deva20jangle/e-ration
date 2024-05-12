package eration;

import java.awt.BorderLayout;

import javax.swing.JOptionPane;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Component;
import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

import javax.swing.JSeparator;

import collector.collectorlogin;
import distributor.distributorlogin;
import user.userlogin;

import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class mainpage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainpage frame = new mainpage();
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
	public mainpage() {       
		setTitle("E_RATION SYSTEM");
		setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\Edu\\6th sem\\FINAL_PROJECT\\e-ration\\bin\\images.jpg"));
		setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1025, 765);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 0, 51));
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblErationSystem = new JLabel("E-RATION SYSTEM");
		lblErationSystem.setForeground(new Color(255, 204, 0));
		lblErationSystem.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lblErationSystem.setBounds(356, 78, 343, 45);
		contentPane.add(lblErationSystem);
		
		JButton btnUserLogin = new JButton("USER LOGIN");
		btnUserLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		        new userlogin().setVisible(true);
		        Component component = (Component) e.getSource();
		        JFrame main = (JFrame) SwingUtilities.getRoot(component);
		        main.dispose();

				
			}

			private void dispose() {
				// TODO Auto-generated method stub
				
			}

			private void setVisible(boolean b) {
				// TODO Auto-generated method stub
				
			}
		});
		btnUserLogin.setBackground(new Color(51, 0, 255));
		btnUserLogin.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnUserLogin.setForeground(Color.CYAN);
		btnUserLogin.setBounds(66, 578, 250, 45);
		contentPane.add(btnUserLogin);
		
		JButton btnDistributorLogin = new JButton("DISTRIBUTOR LOGIN");
		btnDistributorLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		        new distributorlogin().setVisible(true);
		        Component component = (Component) e.getSource();
		        JFrame main = (JFrame) SwingUtilities.getRoot(component);
		        main.dispose();
				
			}
		});
		btnDistributorLogin.setBackground(new Color(51, 0, 255));
		btnDistributorLogin.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnDistributorLogin.setForeground(Color.CYAN);
		btnDistributorLogin.setBounds(393, 578, 250, 45);
		contentPane.add(btnDistributorLogin);
		
		JButton btnCollectorLogin = new JButton("COLLECTOR LOGIN");
		btnCollectorLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		        new collectorlogin().setVisible(true);
		        Component component = (Component) e.getSource();
		        JFrame main = (JFrame) SwingUtilities.getRoot(component);
		        main.dispose();
				
			}
		});
		btnCollectorLogin.setBackground(new Color(51, 0, 255));
		btnCollectorLogin.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnCollectorLogin.setForeground(Color.CYAN);
		btnCollectorLogin.setBounds(711, 578, 250, 45);
		contentPane.add(btnCollectorLogin);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int confirmed = JOptionPane.showConfirmDialog(null, 
				        "Are you sure you want to exit the program?", "Exit Program Message Box",
				        JOptionPane.YES_NO_OPTION);

				    if (confirmed == JOptionPane.YES_OPTION) {
				      dispose();
				    }
				
			}
		});
		btnExit.setForeground(Color.CYAN);
		btnExit.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnExit.setBackground(new Color(51, 0, 255));
		btnExit.setBounds(806, 661, 155, 44);
		contentPane.add(btnExit);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.YELLOW);
		separator.setForeground(Color.BLUE);
		separator.setBounds(12, 136, 976, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.YELLOW);
		separator_1.setForeground(Color.BLUE);
		separator_1.setBounds(12, 563, 983, 2);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(Color.YELLOW);
		separator_2.setForeground(Color.BLUE);
		separator_2.setBounds(12, 646, 983, 2);
		contentPane.add(separator_2);
		
		JLabel lblIndianGovernment = new JLabel("GOVERNMENT OF INDIA");
		lblIndianGovernment.setBackground(Color.GREEN);
		lblIndianGovernment.setForeground(Color.GREEN);
		lblIndianGovernment.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lblIndianGovernment.setBounds(307, 26, 446, 51);
		contentPane.add(lblIndianGovernment);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("F:\\Edu\\6th sem\\FINAL_PROJECT\\e-ration\\bin\\mainpagelogo.jpg"));
		lblNewLabel.setBounds(157, 144, 725, 413);
		contentPane.add(lblNewLabel);
	}
}
