package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.model.Product;
import com.service.ProductService;
import com.service.ProductServiceImpl;

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

public class Stock extends JFrame {

	private JPanel contentPane;
	private JLabel lblAddCashierDetails;
	private JLabel lblCashierId;
	private JLabel lblCashierName;
	private JLabel lblMobileNumber;
	private JLabel lblAddress;
	private JLabel lblEmailId;
	private JTextField pidTxt;
	private JTextField pnameTXt;
	private JTextField availableTxt;
	private JTextField addedTxt;
	private JTextField mrpTxt;
	private JButton addBtn;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton updateBtn;
	private int sid = 0;
	private JLabel backLbl;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stock frame = new Stock();
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
	public Stock() {
		setTitle("Update Stock");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1018, 492);
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
		contentPane.add(getPidTxt());
		contentPane.add(getPnameTXt());
		contentPane.add(getAvailableTxt());
		contentPane.add(getAddedTxt());
		contentPane.add(getMrpTxt());
		contentPane.add(getAddBtn());
		contentPane.add(getUpdateBtn());
		contentPane.add(getScrollPane_1());
		contentPane.add(getBackLbl());
		displayProduct();
	}
	private JLabel getLblAddCashierDetails() {
		if (lblAddCashierDetails == null) {
			lblAddCashierDetails = new JLabel("Update Stock");
			lblAddCashierDetails.setForeground(new Color(255, 255, 255));
			lblAddCashierDetails.setFont(new Font("FreeSans", Font.BOLD, 20));
			lblAddCashierDetails.setBounds(144, 25, 143, 26);
		}
		return lblAddCashierDetails;
	}
	private JLabel getLblCashierId() {
		if (lblCashierId == null) {
			lblCashierId = new JLabel("Product Id");
			lblCashierId.setFont(new Font("FreeSans", Font.BOLD, 14));
			lblCashierId.setForeground(new Color(255, 255, 255));
			lblCashierId.setBounds(34, 91, 91, 15);
		}
		return lblCashierId;
	}
	private JLabel getLblCashierName() {
		if (lblCashierName == null) {
			lblCashierName = new JLabel("Product Name");
			lblCashierName.setFont(new Font("FreeSans", Font.BOLD, 14));
			lblCashierName.setForeground(new Color(255, 255, 255));
			lblCashierName.setBounds(34, 143, 98, 15);
		}
		return lblCashierName;
	}
	private JLabel getLblMobileNumber() {
		if (lblMobileNumber == null) {
			lblMobileNumber = new JLabel("Quantity Available");
			lblMobileNumber.setFont(new Font("FreeSans", Font.BOLD, 14));
			lblMobileNumber.setForeground(new Color(255, 255, 255));
			lblMobileNumber.setBounds(34, 198, 126, 15);
		}
		return lblMobileNumber;
	}
	private JLabel getLblAddress() {
		if (lblAddress == null) {
			lblAddress = new JLabel("Quantity Added");
			lblAddress.setFont(new Font("FreeSans", Font.BOLD, 14));
			lblAddress.setForeground(new Color(255, 255, 255));
			lblAddress.setBounds(34, 248, 112, 15);
		}
		return lblAddress;
	}
	private JLabel getLblEmailId() {
		if (lblEmailId == null) {
			lblEmailId = new JLabel("MRP");
			lblEmailId.setFont(new Font("FreeSans", Font.BOLD, 14));
			lblEmailId.setForeground(new Color(255, 255, 255));
			lblEmailId.setBounds(34, 299, 112, 15);
		}
		return lblEmailId;
	}
	private JTextField getPidTxt() {
		if (pidTxt == null) {
			pidTxt = new JTextField();
			pidTxt.setBounds(209, 85, 196, 26);
			pidTxt.setColumns(10);
		}
		return pidTxt;
	}
	private JTextField getPnameTXt() {
		if (pnameTXt == null) {
			pnameTXt = new JTextField();
			pnameTXt.setColumns(10);
			pnameTXt.setBounds(209, 137, 196, 26);
		}
		return pnameTXt;
	}
	private JTextField getAvailableTxt() {
		if (availableTxt == null) {
			availableTxt = new JTextField();
			availableTxt.setColumns(10);
			availableTxt.setBounds(209, 192, 196, 26);
		}
		return availableTxt;
	}
	private JTextField getAddedTxt() {
		if (addedTxt == null) {
			addedTxt = new JTextField();
			addedTxt.setColumns(10);
			addedTxt.setBounds(209, 242, 196, 26);
		}
		return addedTxt;
	}
	private JTextField getMrpTxt() {
		if (mrpTxt == null) {
			mrpTxt = new JTextField();
			mrpTxt.setColumns(10);
			mrpTxt.setBounds(209, 293, 196, 26);
		}
		return mrpTxt;
	}
	
	private JScrollPane getScrollPane_1() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					
				}
			});
			scrollPane.setBounds(517, 30, 475, 394);
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
				
					ProductService ps = new ProductServiceImpl();
					Product p = ps.getProductById(sid);
				
					// set the cashier data to from
					
					pidTxt.setText(String.valueOf(p.getPid()));
					pnameTXt.setText(p.getPname());
					availableTxt.setText(String.valueOf(p.getAvailable()));
					addedTxt.setText(String.valueOf(p.getAdded()));
					mrpTxt.setText(String.valueOf(p.getMrp()));
					
				}
			});
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Product Id","Product Name","Available","MRP" 
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
					
					Product p = new Product();
				
					p.setPid(Integer.parseInt(pidTxt.getText()));
					p.setPname(pnameTXt.getText());
					p.setAvailable(Integer.parseInt(availableTxt.getText()));
					p.setAdded(Integer.parseInt(addedTxt.getText()));
					p.setMrp(Float.parseFloat(mrpTxt.getText()));
					
					
					ProductService ps = new ProductServiceImpl();
					boolean res = ps.addProduct(p);
					
					if(res) {
						JOptionPane.showMessageDialog(null, "Added Success");
						displayProduct();
						}else {
						JOptionPane.showMessageDialog(null, "Added failed");
					}
					
					pidTxt.setText(String.valueOf(""));
					pnameTXt.setText("");
					availableTxt.setText("");
					addedTxt.setText("");
					mrpTxt.setText("");
					
				}
			});
			addBtn.setBackground(new Color(192, 191, 188));
			Image img = new ImageIcon(getClass().getResource("/new1.png")).getImage();
			addBtn.setIcon(new ImageIcon(img));
			addBtn.setBounds(81, 382, 133, 42);
		}
		return addBtn;
	}
	private JButton getUpdateBtn() {
		if (updateBtn == null) {
			updateBtn = new JButton("Update");
			updateBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
					// set the data from text field to cashier object
					
					Product p = new Product();
					
					p.setPid(sid);
					p.setPname(pnameTXt.getText());
					p.setAvailable(Integer.parseInt(availableTxt.getText()));
					p.setAdded(Integer.parseInt(addedTxt.getText()));
					p.setMrp(Float.parseFloat(mrpTxt.getText()));

					
					ProductService ps = new ProductServiceImpl();
					boolean res = ps.updateProduct(p);
					
					if(res) {
						JOptionPane.showMessageDialog(null, "Update Success");
						displayProduct();
						}else {
						JOptionPane.showMessageDialog(null, "Update failed");
					}
					
					pidTxt.setText(String.valueOf(""));
					pnameTXt.setText("");
					availableTxt.setText("");
					addedTxt.setText("");
					mrpTxt.setText("");
					
				}
			});
			updateBtn.setBackground(new Color(192, 191, 188));
			Image img = new ImageIcon(getClass().getResource("/refresh.png")).getImage();
			updateBtn.setIcon(new ImageIcon(img));
			updateBtn.setBounds(292, 382, 143, 42);
		}
		return updateBtn;
	}
	
	private void displayProduct() {
		
		ProductService ps = new ProductServiceImpl();

		List<Product> plist = ps.getsAllProducts();
		
		DefaultTableModel tmodel =(DefaultTableModel) table.getModel();
		tmodel.setRowCount(0); // reset table
		
		for (Product pl : plist) {
			tmodel.addRow(new Object[] {pl.getPid(),pl.getPname(),pl.getAvailable()+pl.getAdded(),pl.getMrp()});
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
