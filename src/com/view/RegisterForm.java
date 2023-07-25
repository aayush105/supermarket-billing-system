package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.model.Admin;
import com.service.AdminService;
import com.service.AdminServiceImpl;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterForm extends JFrame {

	private JPanel contentPane;
	private JLabel lblClickHereTo;
	private JLabel lblFirstName;
	private JLabel lblLastName;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JLabel lblRetypePass;
	private JLabel lblBirthDate;
	private JLabel lblAddress;
	private JTextField fnameTxt;
	private JTextField lnameTxt;
	private JTextField usernameTxt;
	private JTextField passwordTxt;
	private JTextField repasswordTxt;
	private JTextField addressTxt;
	private JButton cancelBtn;
	private JButton registerBtn;
	private JDateChooser dateChooser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterForm frame = new RegisterForm();
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
	public RegisterForm() {
		setTitle("Register Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 476, 548);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(61, 56, 70));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblClickHereTo());
		contentPane.add(getLblFirstName());
		contentPane.add(getLblLastName());
		contentPane.add(getLblUsername());
		contentPane.add(getLblPassword());
		contentPane.add(getLblRetypePass());
		contentPane.add(getLblBirthDate());
		contentPane.add(getLblAddress());
		contentPane.add(getFnameTxt());
		contentPane.add(getLnameTxt());
		contentPane.add(getUsernameTxt());
		contentPane.add(getPasswordTxt());
		contentPane.add(getRepasswordTxt());
		contentPane.add(getAddressTxt());
		contentPane.add(getCancelBtn());
		contentPane.add(getRegisterBtn());
		contentPane.add(getDateChooser());
	}
	private JLabel getLblClickHereTo() {
		if (lblClickHereTo == null) {
			lblClickHereTo = new JLabel("Click here to login");
			lblClickHereTo.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					new LoginForm().setVisible(true);
					dispose();
				}
			});
			lblClickHereTo.setFont(new Font("FreeSans", Font.BOLD, 14));
			lblClickHereTo.setForeground(new Color(255, 255, 255));
			lblClickHereTo.setBounds(185, 477, 133, 15);
		}
		return lblClickHereTo;
	}
	private JLabel getLblFirstName() {
		if (lblFirstName == null) {
			lblFirstName = new JLabel("First Name:");
			lblFirstName.setFont(new Font("FreeSans", Font.BOLD, 14));
			lblFirstName.setForeground(new Color(255, 255, 255));
			lblFirstName.setBounds(38, 40, 89, 15);
		}
		return lblFirstName;
	}
	private JLabel getLblLastName() {
		if (lblLastName == null) {
			lblLastName = new JLabel("Last Name:");
			lblLastName.setForeground(Color.WHITE);
			lblLastName.setFont(new Font("FreeSans", Font.BOLD, 14));
			lblLastName.setBounds(38, 92, 89, 15);
		}
		return lblLastName;
	}
	private JLabel getLblUsername() {
		if (lblUsername == null) {
			lblUsername = new JLabel("Username:");
			lblUsername.setForeground(Color.WHITE);
			lblUsername.setFont(new Font("FreeSans", Font.BOLD, 14));
			lblUsername.setBounds(38, 143, 89, 15);
		}
		return lblUsername;
	}
	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password:");
			lblPassword.setForeground(Color.WHITE);
			lblPassword.setFont(new Font("FreeSans", Font.BOLD, 14));
			lblPassword.setBounds(38, 196, 89, 15);
		}
		return lblPassword;
	}
	private JLabel getLblRetypePass() {
		if (lblRetypePass == null) {
			lblRetypePass = new JLabel("Retype Pass:");
			lblRetypePass.setForeground(Color.WHITE);
			lblRetypePass.setFont(new Font("FreeSans", Font.BOLD, 14));
			lblRetypePass.setBounds(38, 246, 89, 15);
		}
		return lblRetypePass;
	}
	private JLabel getLblBirthDate() {
		if (lblBirthDate == null) {
			lblBirthDate = new JLabel("Birth Date:");
			lblBirthDate.setForeground(Color.WHITE);
			lblBirthDate.setFont(new Font("FreeSans", Font.BOLD, 14));
			lblBirthDate.setBounds(38, 297, 89, 15);
		}
		return lblBirthDate;
	}
	private JLabel getLblAddress() {
		if (lblAddress == null) {
			lblAddress = new JLabel("Address:");
			lblAddress.setForeground(Color.WHITE);
			lblAddress.setFont(new Font("FreeSans", Font.BOLD, 14));
			lblAddress.setBounds(38, 347, 89, 15);
		}
		return lblAddress;
	}
	private JTextField getFnameTxt() {
		if (fnameTxt == null) {
			fnameTxt = new JTextField();
			fnameTxt.setForeground(new Color(0, 0, 0));
			fnameTxt.setBackground(new Color(255, 255, 255));
			fnameTxt.setBounds(155, 33, 232, 27);
			fnameTxt.setColumns(10);
		}
		return fnameTxt;
	}
	private JTextField getLnameTxt() {
		if (lnameTxt == null) {
			lnameTxt = new JTextField();
			lnameTxt.setForeground(new Color(0, 0, 0));
			lnameTxt.setBackground(new Color(255, 255, 255));
			lnameTxt.setColumns(10);
			lnameTxt.setBounds(155, 85, 232, 27);
		}
		return lnameTxt;
	}
	private JTextField getUsernameTxt() {
		if (usernameTxt == null) {
			usernameTxt = new JTextField();
			usernameTxt.setForeground(new Color(0, 0, 0));
			usernameTxt.setBackground(new Color(255, 255, 255));
			usernameTxt.setColumns(10);
			usernameTxt.setBounds(155, 136, 232, 27);
		}
		return usernameTxt;
	}
	private JTextField getPasswordTxt() {
		if (passwordTxt == null) {
			passwordTxt = new JTextField();
			passwordTxt.setForeground(new Color(0, 0, 0));
			passwordTxt.setBackground(new Color(255, 255, 255));
			passwordTxt.setColumns(10);
			passwordTxt.setBounds(155, 189, 232, 27);
		}
		return passwordTxt;
	}
	private JTextField getRepasswordTxt() {
		if (repasswordTxt == null) {
			repasswordTxt = new JTextField();
			repasswordTxt.setForeground(new Color(0, 0, 0));
			repasswordTxt.setBackground(new Color(255, 255, 255));
			repasswordTxt.setColumns(10);
			repasswordTxt.setBounds(155, 243, 232, 27);
		}
		return repasswordTxt;
	}
	private JTextField getAddressTxt() {
		if (addressTxt == null) {
			addressTxt = new JTextField();
			addressTxt.setForeground(new Color(0, 0, 0));
			addressTxt.setBackground(new Color(255, 255, 255));
			addressTxt.setColumns(10);
			addressTxt.setBounds(155, 340, 232, 27);
		}
		return addressTxt;
	}
	private JButton getCancelBtn() {
		if (cancelBtn == null) {
			cancelBtn = new JButton("Cancel");
			cancelBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					fnameTxt.setText("");
					lnameTxt.setText("");
					usernameTxt.setText("");
					passwordTxt.setText("");
					repasswordTxt.setText("");
					addressTxt.setText("");
					dateChooser.setDate(null);
				}
			});
			cancelBtn.setFont(new Font("FreeSans", Font.BOLD, 14));
			cancelBtn.setBackground(new Color(192, 28, 40));
			cancelBtn.setForeground(new Color(255, 255, 255));
			cancelBtn.setBounds(125, 410, 98, 33);
		}
		return cancelBtn;
	}
	private JButton getRegisterBtn() {
		if (registerBtn == null) {
			registerBtn = new JButton("Register");
			registerBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					// form validation
					if(fnameTxt.getText().isBlank()) {
						JOptionPane.showMessageDialog(fnameTxt, "firstname required");
						return ;
					}
					if(lnameTxt.getText().isBlank()) {
						JOptionPane.showMessageDialog(lnameTxt, "lastname required");
						return ;
					}
					if(usernameTxt.getText().isBlank()) {
						JOptionPane.showMessageDialog(usernameTxt, "username required");
						return ;
					}
					if(passwordTxt.getText().isBlank()) {
						JOptionPane.showMessageDialog(passwordTxt, "password required");
						return ;
					}
					if(repasswordTxt.getText().isBlank()) {
						JOptionPane.showMessageDialog(repasswordTxt, "reupassword required");
						return ;
					}
					if(dateChooser.getDateFormatString().isBlank()) {
						JOptionPane.showMessageDialog(dateChooser, "dob required");
						return ;
					}
					if(addressTxt.getText().isBlank()) {
						JOptionPane.showMessageDialog(addressTxt, "address required");
						return ;
					}
					
					
					
					Admin a = new Admin();
					a.setFname(fnameTxt.getText());
					a.setLname(lnameTxt.getText());
					a.setUsername(usernameTxt.getText());
					a.setPassword(passwordTxt.getText());
					a.setRepassword(repasswordTxt.getText());
					a.setAddress(addressTxt.getText());
					java.util.Date selectedDate = dateChooser.getDate();
					java.sql.Date sqlDate = new java.sql.Date(selectedDate.getTime());
					a.setDob(sqlDate);

					
					if(!(passwordTxt.getText()).equals(repasswordTxt.getText())) {
						JOptionPane.showMessageDialog(null, "Password not match");
						
					}else {
						AdminService as = new AdminServiceImpl();
						boolean res = as.addAdmin(a);
						
						if(res) {
							JOptionPane.showMessageDialog(null, "Added Success");
							
						} else {
							JOptionPane.showMessageDialog(null, "Added Failed");
						}
						fnameTxt.setText("");
						lnameTxt.setText("");
						usernameTxt.setText("");
						passwordTxt.setText("");
						repasswordTxt.setText("");
						addressTxt.setText("");
						dateChooser.setDate(null);
					}
				}
			});
			registerBtn.setFont(new Font("FreeSans", Font.BOLD, 14));
			registerBtn.setForeground(new Color(255, 255, 255));
			registerBtn.setBackground(new Color(53, 132, 228));
			registerBtn.setBounds(289, 410, 98, 33);
		}
		return registerBtn;
	}
	private JDateChooser getDateChooser() {
		if (dateChooser == null) {
			dateChooser = new JDateChooser();
			dateChooser.setBounds(155, 293, 232, 27);
		}
		return dateChooser;
	}
}
