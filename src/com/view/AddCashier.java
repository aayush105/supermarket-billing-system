package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.model.Cashier;

import com.service.CashierService;
import com.service.CashierServiceImpl;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddCashier extends JFrame {

	private JPanel contentPane;
	private JLabel lblAddCashierDetails;
	private JLabel lblCashierId;
	private JLabel lblCashierName;
	private JLabel lblMobileNumber;
	private JLabel lblAddress;
	private JLabel lblEmailId;
	private JLabel lblPassword;
	private JTextField idTxt;
	private JTextField cnameTxt;
	private JTextField phoneTxt;
	private JTextField addressTxt;
	private JTextField emailTxt;
	private JTextField passwordTxt;
	private JButton addBtn;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton updateBtn;
	private JButton deleteBtn;
	private int sid = 0;
	private JLabel backLbl;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCashier frame = new AddCashier();
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
	public AddCashier() {
		setTitle("Add Cashier");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1018, 521);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(new Color(94, 92, 100));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblAddCashierDetails());
		contentPane.add(getLblCashierId());
		contentPane.add(getLblCashierName());
		contentPane.add(getLblMobileNumber());
		contentPane.add(getLblAddress());
		contentPane.add(getLblEmailId());
		contentPane.add(getLblPassword());
		contentPane.add(getIdTxt());
		contentPane.add(getCnameTxt());
		contentPane.add(getPhoneTxt());
		contentPane.add(getAddressTxt());
		contentPane.add(getEmailTxt());
		contentPane.add(getPasswordTxt());
		contentPane.add(getAddBtn());
		contentPane.add(getUpdateBtn());
		contentPane.add(getDeleteBtn());
		contentPane.add(getScrollPane_1());
		contentPane.add(getBackLbl());
		displayData();
	}
	private JLabel getLblAddCashierDetails() {
		if (lblAddCashierDetails == null) {
			lblAddCashierDetails = new JLabel("Add Cashier Details");
			lblAddCashierDetails.setForeground(new Color(255, 255, 255));
			lblAddCashierDetails.setFont(new Font("FreeSans", Font.BOLD, 20));
			lblAddCashierDetails.setBounds(107, 25, 196, 26);
		}
		return lblAddCashierDetails;
	}
	private JLabel getLblCashierId() {
		if (lblCashierId == null) {
			lblCashierId = new JLabel("Cashier Id");
			lblCashierId.setFont(new Font("FreeSans", Font.BOLD, 14));
			lblCashierId.setForeground(new Color(255, 255, 255));
			lblCashierId.setBounds(34, 91, 91, 15);
		}
		return lblCashierId;
	}
	private JLabel getLblCashierName() {
		if (lblCashierName == null) {
			lblCashierName = new JLabel("Cashier Name");
			lblCashierName.setFont(new Font("FreeSans", Font.BOLD, 14));
			lblCashierName.setForeground(new Color(255, 255, 255));
			lblCashierName.setBounds(34, 143, 98, 15);
		}
		return lblCashierName;
	}
	private JLabel getLblMobileNumber() {
		if (lblMobileNumber == null) {
			lblMobileNumber = new JLabel("Mobile Number");
			lblMobileNumber.setFont(new Font("FreeSans", Font.BOLD, 14));
			lblMobileNumber.setForeground(new Color(255, 255, 255));
			lblMobileNumber.setBounds(34, 198, 112, 15);
		}
		return lblMobileNumber;
	}
	private JLabel getLblAddress() {
		if (lblAddress == null) {
			lblAddress = new JLabel("Address");
			lblAddress.setFont(new Font("FreeSans", Font.BOLD, 14));
			lblAddress.setForeground(new Color(255, 255, 255));
			lblAddress.setBounds(34, 248, 112, 15);
		}
		return lblAddress;
	}
	private JLabel getLblEmailId() {
		if (lblEmailId == null) {
			lblEmailId = new JLabel("Email Id");
			lblEmailId.setFont(new Font("FreeSans", Font.BOLD, 14));
			lblEmailId.setForeground(new Color(255, 255, 255));
			lblEmailId.setBounds(34, 299, 112, 15);
		}
		return lblEmailId;
	}
	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password");
			lblPassword.setFont(new Font("FreeSans", Font.BOLD, 14));
			lblPassword.setForeground(new Color(255, 255, 255));
			lblPassword.setBounds(34, 351, 112, 15);
		}
		return lblPassword;
	}
	private JTextField getIdTxt() {
		if (idTxt == null) {
			idTxt = new JTextField();
			idTxt.setBounds(166, 85, 196, 26);
			idTxt.setColumns(10);
		}
		return idTxt;
	}
	private JTextField getCnameTxt() {
		if (cnameTxt == null) {
			cnameTxt = new JTextField();
			cnameTxt.setColumns(10);
			cnameTxt.setBounds(166, 137, 196, 26);
		}
		return cnameTxt;
	}
	private JTextField getPhoneTxt() {
		if (phoneTxt == null) {
			phoneTxt = new JTextField();
			phoneTxt.setColumns(10);
			phoneTxt.setBounds(166, 192, 196, 26);
		}
		return phoneTxt;
	}
	private JTextField getAddressTxt() {
		if (addressTxt == null) {
			addressTxt = new JTextField();
			addressTxt.setColumns(10);
			addressTxt.setBounds(166, 242, 196, 26);
		}
		return addressTxt;
	}
	private JTextField getEmailTxt() {
		if (emailTxt == null) {
			emailTxt = new JTextField();
			emailTxt.setColumns(10);
			emailTxt.setBounds(166, 293, 196, 26);
		}
		return emailTxt;
	}
	private JTextField getPasswordTxt() {
		if (passwordTxt == null) {
			passwordTxt = new JTextField();
			passwordTxt.setColumns(10);
			passwordTxt.setBounds(166, 345, 196, 26);
		}
		return passwordTxt;
	}
	
	private JScrollPane getScrollPane_1() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					
				}
			});
			scrollPane.setBounds(517, 30, 475, 439);
			scrollPane.setViewportView(getTable_1());
		}
		return scrollPane;
	}
	private JTable getTable_1() {
		if (table == null) {
			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(table.getSelectedRow()<0) {
						JOptionPane.showMessageDialog(null, "Select any row");
						return;
					}
					
					int srow = table.getSelectedRow();
					sid = (int) table.getModel().getValueAt(srow, 0);
					
					CashierService cs = new CashierServiceImpl();
					Cashier c = cs.getCashierById(sid);
					
					// set the cashier data to from
					
					idTxt.setText(String.valueOf(c.getId()));
					cnameTxt.setText(c.getCname());
					phoneTxt.setText(c.getPhone());
					addressTxt.setText(c.getAddress());
					emailTxt.setText(c.getEmail());
					passwordTxt.setText(c.getPassword());
				}
			});
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "Name", "Phone No", "Address", "Email", "Password"
				}
			));
		}
		return table;
	}
	private JButton getAddBtn() {
		if (addBtn == null) {
			addBtn = new JButton("Add New");
			addBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					Cashier c = new Cashier();
					
					c.setId(Integer.parseInt(idTxt.getText()));
					c.setCname(cnameTxt.getText());
					c.setPhone(phoneTxt.getText());
					c.setAddress(addressTxt.getText());
					c.setEmail(emailTxt.getText());
					c.setPassword(passwordTxt.getText());
					
					CashierService cs = new CashierServiceImpl();
					boolean res = cs.addCashier(c);
					
					if(res) {
						JOptionPane.showMessageDialog(null, "Added Success");
						displayData();
						}else {
						JOptionPane.showMessageDialog(null, "Added failed");
					}
					
					idTxt.setText(String.valueOf(""));
					cnameTxt.setText("");
					phoneTxt.setText("");
					addressTxt.setText("");
					emailTxt.setText("");
					passwordTxt.setText("");
				}
			});
			addBtn.setBackground(new Color(192, 191, 188));
			Image img = new ImageIcon(getClass().getResource("/new1.png")).getImage();
			addBtn.setIcon(new ImageIcon(img));
			addBtn.setBounds(34, 422, 133, 42);
		}
		return addBtn;
	}
	private JButton getUpdateBtn() {
		if (updateBtn == null) {
			updateBtn = new JButton("Update");
			updateBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
					// set the data from text field to cashier object
					
					Cashier c = new Cashier();
					c.setId(sid);
					c.setCname(cnameTxt.getText());
					c.setPhone(phoneTxt.getText());
					c.setAddress(addressTxt.getText());
					c.setEmail(emailTxt.getText());
					c.setPassword(passwordTxt.getText());
					
					CashierService cs = new CashierServiceImpl();
					boolean res = cs.updateCashier(c);
					
					if(res) {
						JOptionPane.showMessageDialog(null, "Update Success");
						displayData();
					}else {
						JOptionPane.showMessageDialog(null, "Update Failed");
					}
					
					idTxt.setText(String.valueOf(""));
					cnameTxt.setText("");
					phoneTxt.setText("");
					addressTxt.setText("");
					emailTxt.setText("");
					passwordTxt.setText("");
				}
			});
			updateBtn.setBackground(new Color(192, 191, 188));
			Image img = new ImageIcon(getClass().getResource("/refresh.png")).getImage();
			updateBtn.setIcon(new ImageIcon(img));
			updateBtn.setBounds(195, 422, 143, 42);
		}
		return updateBtn;
	}
	private JButton getDeleteBtn() {
		if (deleteBtn == null) {
			deleteBtn = new JButton("Delete");
			deleteBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if(table.getSelectedRow() < 0) {
						JOptionPane.showMessageDialog(null, "Select any row");
						return;
					}
					int srow = table.getSelectedRow();
					int sid = (int) table.getModel().getValueAt(srow, 0);
					
					CashierService cs = new CashierServiceImpl();
					if(cs.deleteCashier(sid)) {
						JOptionPane.showMessageDialog(null, "Delete Success");
						displayData();
					}else {
						JOptionPane.showMessageDialog(null, "Delete Failed");
					}
					idTxt.setText(String.valueOf(""));
					cnameTxt.setText("");
					phoneTxt.setText("");
					addressTxt.setText("");
					emailTxt.setText("");
					passwordTxt.setText("");
				}
			});
			deleteBtn.setBackground(new Color(192, 191, 188));
			Image img = new ImageIcon(getClass().getResource("/delete.png")).getImage();
			deleteBtn.setIcon(new ImageIcon(img));
			deleteBtn.setBounds(368, 422, 127, 42);
		}
		return deleteBtn;
	}
	
	private void displayData() {
		CashierService cs = new CashierServiceImpl();
		List<Cashier> clist = cs.getsAllCashiers();
		
		DefaultTableModel tmodel =(DefaultTableModel) table.getModel();
		tmodel.setRowCount(0); // reset table
		
		for (Cashier cl : clist) {
			tmodel.addRow(new Object[] {cl.getId(),cl.getCname(),cl.getPhone(),cl.getAddress(),cl.getEmail(),cl.getPassword()});
		}
	}
	private JLabel getBackLbl() {
		if (backLbl == null) {
			backLbl = new JLabel("");
			backLbl.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					new AdminUI().setVisible(true);
					dispose();
				}
			});
			backLbl.setBounds(34, 12, 40, 32);
			Image img = new ImageIcon(getClass().getResource("/back.png")).getImage();
			backLbl.setIcon(new ImageIcon(img));
		}
		return backLbl;
	}
}
