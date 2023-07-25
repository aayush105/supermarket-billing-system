package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.db.DB;



import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CashierLogin extends JFrame {

	private JPanel contentPane;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JTextField emailTxt;
	private JTextField passwordTxt;
	private JButton cancelBtn;
	private JButton loginBtn;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CashierLogin frame = new CashierLogin();
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
	public CashierLogin() {
		setTitle("Login Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 277);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(61, 56, 70));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblUsername());
		contentPane.add(getLblPassword());
		contentPane.add(getEmailTxt());
		contentPane.add(getPasswordTxt());
		contentPane.add(getCancelBtn());
		contentPane.add(getLoginBtn());
		contentPane.add(getLblNewLabel());
	}
	private JLabel getLblUsername() {
		if (lblUsername == null) {
			lblUsername = new JLabel("Email :");
			lblUsername.setFont(new Font("FreeSans", Font.BOLD, 16));
			lblUsername.setForeground(new Color(255, 255, 255));
			lblUsername.setBounds(29, 57, 90, 15);
		}
		return lblUsername;
	}
	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password :");
			lblPassword.setFont(new Font("FreeSans", Font.BOLD, 16));
			lblPassword.setForeground(new Color(255, 255, 255));
			lblPassword.setBackground(new Color(255, 255, 255));
			lblPassword.setBounds(29, 128, 90, 15);
		}
		return lblPassword;
	}
	private JTextField getEmailTxt() {
		if (emailTxt == null) {
			emailTxt = new JTextField();
			emailTxt.setForeground(new Color(0, 0, 0));
			emailTxt.setBackground(new Color(255, 255, 255));
			emailTxt.setBounds(137, 49, 174, 30);
			emailTxt.setColumns(10);
		}
		return emailTxt;
	}
	private JTextField getPasswordTxt() {
		if (passwordTxt == null) {
			passwordTxt = new JTextField();
			passwordTxt.setForeground(new Color(0, 0, 0));
			passwordTxt.setBackground(new Color(255, 255, 255));
			passwordTxt.setColumns(10);
			passwordTxt.setBounds(137, 120, 174, 30);
		}
		return passwordTxt;
	}
	private JButton getCancelBtn() {
		if (cancelBtn == null) {
			cancelBtn = new JButton("Cancel");
			cancelBtn.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					new IndexForm().setVisible(true);
					dispose();
				}
			});
			cancelBtn.setFont(new Font("FreeSans", Font.BOLD, 14));
			cancelBtn.setForeground(new Color(255, 255, 255));
			cancelBtn.setBackground(new Color(192, 28, 40));
			cancelBtn.setBounds(112, 179, 90, 30);
		}
		return cancelBtn;
	}
	private JButton getLoginBtn() {
		if (loginBtn == null) {
			loginBtn = new JButton("Login");
			loginBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					// form validation
					if(emailTxt.getText().isBlank()) {
						JOptionPane.showMessageDialog(emailTxt, "username required");
						return ;
					}
					if(passwordTxt.getText().isBlank()) {
						JOptionPane.showMessageDialog(passwordTxt, "password required");
						return ;
					}
					
					String email = emailTxt.getText(); // to get the value of username
					String psw = passwordTxt.getText(); // to get the value of password
					
					try {
						// login sql
						String sql = "select * from cashier where email = '"+email+"' and password='"+psw+"'";
						Statement stm = DB.getConnection().createStatement();
						ResultSet rs = stm.executeQuery(sql);
						if(rs.next()) {
							JOptionPane.showMessageDialog(null, "Login Success");
							new CashierUI().setVisible(true);
							dispose();
						} else {
							JOptionPane.showMessageDialog(null, "Login Failed");
						}
					} catch (SQLException e1) {
						
						e1.printStackTrace();
					}
				} 
					

				
			});
			loginBtn.setBackground(new Color(53, 132, 228));
			loginBtn.setForeground(new Color(255, 255, 255));
			loginBtn.setFont(new Font("FreeSans", Font.BOLD, 14));
			loginBtn.setBounds(245, 179, 90, 30);
		}
		return loginBtn;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Cashier Login");
			lblNewLabel.setFont(new Font("FreeSans", Font.BOLD, 14));
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setBounds(164, 12, 110, 15);
		}
		return lblNewLabel;
	}
}
