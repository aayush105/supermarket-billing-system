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

public class LoginForm extends JFrame {

	private JPanel contentPane;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JTextField usernameTxt;
	private JTextField passwordTxt;
	private JButton cancelBtn;
	private JButton loginBtn;
	private JLabel lblClickHereTo;
	private JLabel lblAdminLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm frame = new LoginForm();
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
	public LoginForm() {
		setTitle("Login Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 325);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(61, 56, 70));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblUsername());
		contentPane.add(getLblPassword());
		contentPane.add(getUsernameTxt());
		contentPane.add(getPasswordTxt());
		contentPane.add(getCancelBtn());
		contentPane.add(getLoginBtn());
		contentPane.add(getLblClickHereTo());
		contentPane.add(getLblAdminLogin());
	}
	private JLabel getLblUsername() {
		if (lblUsername == null) {
			lblUsername = new JLabel("Username:");
			lblUsername.setFont(new Font("FreeSans", Font.BOLD, 16));
			lblUsername.setForeground(new Color(255, 255, 255));
			lblUsername.setBounds(29, 57, 90, 15);
		}
		return lblUsername;
	}
	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password:");
			lblPassword.setFont(new Font("FreeSans", Font.BOLD, 16));
			lblPassword.setForeground(new Color(255, 255, 255));
			lblPassword.setBackground(new Color(255, 255, 255));
			lblPassword.setBounds(29, 128, 90, 15);
		}
		return lblPassword;
	}
	private JTextField getUsernameTxt() {
		if (usernameTxt == null) {
			usernameTxt = new JTextField();
			usernameTxt.setForeground(new Color(0, 0, 0));
			usernameTxt.setBackground(new Color(255, 255, 255));
			usernameTxt.setBounds(137, 49, 174, 30);
			usernameTxt.setColumns(10);
		}
		return usernameTxt;
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
					if(usernameTxt.getText().isBlank()) {
						JOptionPane.showMessageDialog(usernameTxt, "username required");
						return ;
					}
					if(passwordTxt.getText().isBlank()) {
						JOptionPane.showMessageDialog(passwordTxt, "password required");
						return ;
					}
					
					String un = usernameTxt.getText(); // to get the value of username
					String psw = passwordTxt.getText(); // to get the value of password
					
					try {
						// login sql
						String sql = "select * from admin where username = '"+un+"' and password='"+psw+"'";
						Statement stm = DB.getConnection().createStatement();
						ResultSet rs = stm.executeQuery(sql);
						if(rs.next()) {
							JOptionPane.showMessageDialog(null, "Login Success");
							new AdminUI().setVisible(true);
							dispose();
						} else {
							JOptionPane.showMessageDialog(null, "Login Failed");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} 
					
					
					
//					if(un.equals("aayush105") && psw.equals("123")) {
//						
//						JOptionPane.showMessageDialog(null,"login success");
//						new AdminUI().setVisible(true); // to redirect to the home page
//						dispose();						
//					}else{
//						JOptionPane.showMessageDialog(null,"login failed");
//					}
//				}
				
			});
			loginBtn.setBackground(new Color(53, 132, 228));
			loginBtn.setForeground(new Color(255, 255, 255));
			loginBtn.setFont(new Font("FreeSans", Font.BOLD, 14));
			loginBtn.setBounds(245, 179, 90, 30);
		}
		return loginBtn;
	}
	private JLabel getLblClickHereTo() {
		if (lblClickHereTo == null) {
			lblClickHereTo = new JLabel("Click here to create a new account");
			lblClickHereTo.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					new RegisterForm().setVisible(true);
					dispose();
				}
			});
			lblClickHereTo.setFont(new Font("FreeSans", Font.BOLD, 14));
			lblClickHereTo.setForeground(new Color(255, 255, 255));
			lblClickHereTo.setBounds(106, 249, 241, 15);
		}
		return lblClickHereTo;
	}
	private JLabel getLblAdminLogin() {
		if (lblAdminLogin == null) {
			lblAdminLogin = new JLabel("Admin Login");
			lblAdminLogin.setFont(new Font("FreeSans", Font.BOLD, 14));
			lblAdminLogin.setForeground(new Color(255, 255, 255));
			lblAdminLogin.setBounds(172, 12, 90, 15);
		}
		return lblAdminLogin;
	}
}
