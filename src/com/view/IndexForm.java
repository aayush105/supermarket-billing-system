package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IndexForm extends JFrame {

	private JPanel contentPane;
	private JLabel lblWelcomeToSuper;
	private JButton btnAdminLogin;
	private JButton btnCashierLogin;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IndexForm frame = new IndexForm();
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
	public IndexForm() {
		setTitle("Quick Bill");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 508, 368);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblWelcomeToSuper());
		contentPane.add(getBtnAdminLogin());
		contentPane.add(getBtnCashierLogin());
		contentPane.add(getLblNewLabel());
	}
	private JLabel getLblWelcomeToSuper() {
		if (lblWelcomeToSuper == null) {
			lblWelcomeToSuper = new JLabel("Welcome To Super Market Billing System");
			lblWelcomeToSuper.setBackground(new Color(36, 31, 49));
			lblWelcomeToSuper.setForeground(new Color(36, 31, 49));
			lblWelcomeToSuper.setFont(new Font("FreeSerif", Font.BOLD, 20));
			lblWelcomeToSuper.setBounds(73, 12, 369, 31);
		}
		return lblWelcomeToSuper;
	}
	private JButton getBtnAdminLogin() {
		if (btnAdminLogin == null) {
			btnAdminLogin = new JButton("Admin Login");
			btnAdminLogin.setForeground(new Color(255, 255, 255));
			btnAdminLogin.setFont(new Font("FreeSans", Font.BOLD, 14));
			btnAdminLogin.setBackground(new Color(61, 56, 70));
			btnAdminLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new LoginForm().setVisible(true);
					dispose();
				}
			});
			btnAdminLogin.setBounds(293, 123, 134, 37);
		}
		return btnAdminLogin;
	}
	private JButton getBtnCashierLogin() {
		if (btnCashierLogin == null) {
			btnCashierLogin = new JButton("Cashier Login");
			btnCashierLogin.setBackground(new Color(61, 56, 70));
			btnCashierLogin.setForeground(new Color(255, 255, 255));
			btnCashierLogin.setFont(new Font("FreeSans", Font.BOLD, 14));
			btnCashierLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new CashierLogin().setVisible(true);
					dispose();
				}
			});
			btnCashierLogin.setBounds(293, 195, 134, 37);
		}
		return btnCashierLogin;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setForeground(new Color(255, 255, 255));
			Image img = new ImageIcon(getClass().getResource("/Quick.png")).getImage();
			lblNewLabel.setIcon(new ImageIcon(img));
			lblNewLabel.setBounds(31, 70, 194, 200);
		}
		return lblNewLabel;
	}
}
