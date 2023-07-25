package com.view;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminUI extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblCreateBill;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel lblCreateBill_1;
	private JLabel lblCreateBill_1_1;
	private JLabel lblCreateBill_1_2;
	private JLabel label_3;
	private JLabel lblCreateBill_1_2_1;
	private JLabel label_4;
	private JSeparator separator;
	private JLabel label_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminUI frame = new AdminUI();
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
	public AdminUI() {
		setTitle("Quick Bill");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 996, 730);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPanel());
		contentPane.add(getSeparator());
		contentPane.add(getLabel_5());
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(new Color(61, 56, 70));
			panel.setBounds(0, 0, 1008, 73);
			panel.setLayout(null);
			panel.add(getLblNewLabel());
			panel.add(getLblCreateBill());
			panel.add(getLabel());
			panel.add(getLabel_1());
			panel.add(getLabel_2());
			panel.add(getLblCreateBill_1());
			panel.add(getLblCreateBill_1_1());
			panel.add(getLblCreateBill_1_2());
			panel.add(getLabel_3());
			panel.add(getLblCreateBill_1_2_1());
			panel.add(getLabel_4());
		}
		return panel;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			Image img = new ImageIcon(getClass().getResource("/quickbilll.png")).getImage();
			lblNewLabel.setIcon(new ImageIcon(img));
			lblNewLabel.setBounds(12, 12, 150, 49);
		}
		return lblNewLabel;
	}
	private JLabel getLblCreateBill() {
		if (lblCreateBill == null) {
			lblCreateBill = new JLabel("Add Cashier");
			lblCreateBill.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					new AddCashier().setVisible(true);
//					dispose();
				}
			});
			lblCreateBill.setForeground(new Color(255, 255, 255));
			lblCreateBill.setFont(new Font("FreeSans", Font.BOLD, 14));
			lblCreateBill.setBounds(309, 22, 88, 27);
		}
		return lblCreateBill;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("");
			Image img = new ImageIcon(getClass().getResource("/cashier.png")).getImage();
			label.setIcon(new ImageIcon(img));
			label.setBounds(265, 17, 32, 32);
		}
		return label;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("");
			Image img = new ImageIcon(getClass().getResource("/warehouse.png")).getImage();
			label_1.setIcon(new ImageIcon(img));
			label_1.setBounds(420, 17, 32, 32);
		}
		return label_1;
	}
	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("");
			Image img = new ImageIcon(getClass().getResource("/trade.png")).getImage();
			label_2.setIcon(new ImageIcon(img));
			label_2.setBounds(533, 17, 32, 32);
		}
		return label_2;
	}
	private JLabel getLblCreateBill_1() {
		if (lblCreateBill_1 == null) {
			lblCreateBill_1 = new JLabel("Stocks");
			lblCreateBill_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					new Stock().setVisible(true);
				}
			});
			lblCreateBill_1.setForeground(new Color(255, 255, 255));
			lblCreateBill_1.setFont(new Font("FreeSans", Font.BOLD, 14));
			lblCreateBill_1.setBounds(469, 22, 56, 27);
		}
		return lblCreateBill_1;
	}
	private JLabel getLblCreateBill_1_1() {
		if (lblCreateBill_1_1 == null) {
			lblCreateBill_1_1 = new JLabel("Transaction");
			lblCreateBill_1_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
				new Transaction().setVisible(true);
				dispose();
				}
				
			});
			lblCreateBill_1_1.setForeground(new Color(255, 255, 255));
			lblCreateBill_1_1.setFont(new Font("FreeSans", Font.BOLD, 14));
			lblCreateBill_1_1.setBounds(577, 22, 88, 27);
		}
		return lblCreateBill_1_1;
	}
	private JLabel getLblCreateBill_1_2() {
		if (lblCreateBill_1_2 == null) {
			lblCreateBill_1_2 = new JLabel("Sales");
			lblCreateBill_1_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					new Sales().setVisible(true);
					dispose();
				}
			});
			lblCreateBill_1_2.setForeground(new Color(255, 255, 255));
			lblCreateBill_1_2.setFont(new Font("FreeSans", Font.BOLD, 14));
			lblCreateBill_1_2.setBounds(723, 22, 38, 27);
		}
		return lblCreateBill_1_2;
	}
	private JLabel getLabel_3() {
		if (label_3 == null) {
			label_3 = new JLabel("");
			Image img = new ImageIcon(getClass().getResource("/sales.png")).getImage();
			label_3.setIcon(new ImageIcon(img));
			label_3.setBounds(677, 17, 32, 32);
		}
		return label_3;
	}
	private JLabel getLblCreateBill_1_2_1() {
		if (lblCreateBill_1_2_1 == null) {
			lblCreateBill_1_2_1 = new JLabel("Exit");
			lblCreateBill_1_2_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					new IndexForm().setVisible(true);
					dispose();
				}
			});
			lblCreateBill_1_2_1.setForeground(new Color(255, 255, 255));
			lblCreateBill_1_2_1.setFont(new Font("FreeSans", Font.BOLD, 14));
			lblCreateBill_1_2_1.setBounds(934, 22, 32, 27);
		}
		return lblCreateBill_1_2_1;
	}
	private JLabel getLabel_4() {
		if (label_4 == null) {
			label_4 = new JLabel("");
			Image img = new ImageIcon(getClass().getResource("/exit.png")).getImage();
			label_4.setIcon(new ImageIcon(img));
			label_4.setBounds(890, 17, 32, 32);
		}
		return label_4;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setForeground(new Color(0, 0, 0));
			separator.setBounds(0, 73, 996, 2);
		}
		return separator;
	}
	private JLabel getLabel_5() {
		if (label_5 == null) {
			label_5 = new JLabel("");
			Image img = new ImageIcon(getClass().getResource("/admin1.jpg")).getImage();
			label_5.setIcon(new ImageIcon(img));
			label_5.setBounds(0, 73, 1008, 627);
		}
		return label_5;
	}
}
