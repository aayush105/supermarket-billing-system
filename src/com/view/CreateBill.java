package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.model.Bill;
import com.model.Product;
import com.service.BillService;
import com.service.BillServiceImpl;
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
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import javax.swing.DefaultComboBoxModel;

public class CreateBill extends JFrame {

	private JPanel contentPane;
	private JLabel lblCashierId;
	private JLabel lblCashierName;
	private JLabel lblMobileNumber;
	private JLabel lblAddress;
	private JLabel lblEmailId;
	private JTextField pnameTxt;
	private JTextField custTxt;
	private JTextField quantityTxt;
	private JTextField mrpTxt;
	private JButton addBtn;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton updateBtn;
	private int bid = 0;
	private JLabel lblBillNo;
	private JTextField billTxt;
	private JTextField disTxt;
	private JLabel lblDiscount;
	private JComboBox pidCmbo;
	private JLabel lblDate;
	private JDateChooser dateTxt;
	private JLabel lblTotal;
	private JTextField totalTxt;
	private JButton removeBtn;
	private JButton saveBtn;
	private JLabel backLbl;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateBill frame = new CreateBill();
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
	public CreateBill() {
		setTitle("New Bill");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1018, 570);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(new Color(94, 92, 100));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblCashierId());
		contentPane.add(getLblCashierName());
		contentPane.add(getLblMobileNumber());
		contentPane.add(getLblAddress());
		contentPane.add(getLblEmailId());
		contentPane.add(getPnameTxt());
		contentPane.add(getCustTxt());
		contentPane.add(getQuantityTxt());
		contentPane.add(getMrpTxt());
		contentPane.add(getAddBtn());
		
		contentPane.add(getScrollPane_1());
		contentPane.add(getLblBillNo());
		contentPane.add(getBillTxt());
		contentPane.add(getDisTxt());
		contentPane.add(getLblDiscount());
		contentPane.add(getPidCmbo());
		contentPane.add(getLblDate());
		contentPane.add(getDateTxt());
		contentPane.add(getLblTotal());
		contentPane.add(getTotalTxt());
		contentPane.add(getRemoveBtn());
		contentPane.add(getSaveBtn());
		contentPane.add(getBackLbl());
//		displayBill();
	}
	private JLabel getLblCashierId() {
		if (lblCashierId == null) {
			lblCashierId = new JLabel("Product Id");
			lblCashierId.setFont(new Font("FreeSans", Font.BOLD, 14));
			lblCashierId.setForeground(new Color(255, 255, 255));
			lblCashierId.setBounds(34, 144, 91, 15);
		}
		return lblCashierId;
	}
	private JLabel getLblCashierName() {
		if (lblCashierName == null) {
			lblCashierName = new JLabel("Product Name");
			lblCashierName.setFont(new Font("FreeSans", Font.BOLD, 14));
			lblCashierName.setForeground(new Color(255, 255, 255));
			lblCashierName.setBounds(34, 189, 98, 15);
		}
		return lblCashierName;
	}
	private JLabel getLblMobileNumber() {
		if (lblMobileNumber == null) {
			lblMobileNumber = new JLabel("Customer Name");
			lblMobileNumber.setFont(new Font("FreeSans", Font.BOLD, 14));
			lblMobileNumber.setForeground(new Color(255, 255, 255));
			lblMobileNumber.setBounds(34, 236, 126, 15);
		}
		return lblMobileNumber;
	}
	private JLabel getLblAddress() {
		if (lblAddress == null) {
			lblAddress = new JLabel("Quantity");
			lblAddress.setFont(new Font("FreeSans", Font.BOLD, 14));
			lblAddress.setForeground(new Color(255, 255, 255));
			lblAddress.setBounds(34, 286, 112, 15);
		}
		return lblAddress;
	}
	private JLabel getLblEmailId() {
		if (lblEmailId == null) {
			lblEmailId = new JLabel("MRP");
			lblEmailId.setFont(new Font("FreeSans", Font.BOLD, 14));
			lblEmailId.setForeground(new Color(255, 255, 255));
			lblEmailId.setBounds(34, 337, 112, 15);
		}
		return lblEmailId;
	}
	private JTextField getPnameTxt() {
		if (pnameTxt == null) {
			pnameTxt = new JTextField();
			pnameTxt.setColumns(10);
			pnameTxt.setBounds(209, 183, 196, 26);
		}
		return pnameTxt;
	}
	private JTextField getCustTxt() {
		if (custTxt == null) {
			custTxt = new JTextField();
			custTxt.setColumns(10);
			custTxt.setBounds(209, 230, 196, 26);
		}
		return custTxt;
	}
	private JTextField getQuantityTxt() {
		if (quantityTxt == null) {
			quantityTxt = new JTextField();
			quantityTxt.setColumns(10);
			quantityTxt.setBounds(209, 280, 196, 26);
		}
		return quantityTxt;
	}
	private JTextField getMrpTxt() {
		if (mrpTxt == null) {
			mrpTxt = new JTextField();
			mrpTxt.setColumns(10);
			mrpTxt.setBounds(209, 331, 196, 26);
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
			scrollPane.setBounds(439, 85, 542, 315);
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
					bid = (int) table.getModel().getValueAt(srow, 0);
					
				
					BillService bs = new BillServiceImpl();
					Bill b = bs.getBillById(bid);
					
					// set the billing data to from
					
					billTxt.setText(String.valueOf(b.getBillno()));
					pidCmbo.setSelectedItem(String.valueOf(b.getPid()));
					pnameTxt.setText(b.getPname());
					custTxt.setText(b.getCustname());
					quantityTxt.setText(String.valueOf(b.getQuantity()));
					mrpTxt.setText(String.valueOf(b.getMrp()));
					disTxt.setText(String.valueOf(b.getDiscount()));

					
					if (b.getDate() != null) {
				        // Convert java.util.Date to java.sql.Date and then set in JDateChooser
				        java.sql.Date sqlDate = new java.sql.Date(b.getDate().getTime());
				        dateTxt.setDate(sqlDate);
				    } else {
				        dateTxt.setDate(null); // Set dateTxt to null if the Bill object's date is null
				    }
					
				}
			});
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Bill no", "Product Id", "Product Name", "Quantity", "MRP", "Price"
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
					
					Bill b = new Bill();
					b.setBillno(Integer.parseInt(billTxt.getText()));
					b.setPid(Integer.parseInt(pidCmbo.getSelectedItem().toString()));
					b.setPname(pnameTxt.getText());
					b.setCustname(custTxt.getText());
					b.setQuantity(Integer.parseInt(quantityTxt.getText()));
					b.setMrp(Float.parseFloat(mrpTxt.getText()));
					b.setDiscount(Float.parseFloat(disTxt.getText()));
					
					java.util.Date selectedDate = dateTxt.getDate();
					java.sql.Date sqlDate = new java.sql.Date(selectedDate.getTime());
					b.setDate(sqlDate);
					
					b.setTotal(Float.parseFloat(totalTxt.getText()));
					
					ProductService ps = new ProductServiceImpl();

					Product p = ps.searchProduct_bill(Integer.toString(b.getPid()));
					
					p.setPid(b.getPid());
					
					if ( b.getQuantity() > p.getAvailable()) {
					    JOptionPane.showMessageDialog(null, "Insufficient Product Available, try less/later");
					    return;
					} else {
					    int avai = p.getAvailable() - b.getQuantity();
					    p.setAvailable(avai);

					    boolean res = ps.updateProduct(p);

					    if (!res) {
					        JOptionPane.showMessageDialog(null, "Error updating product availability!");
					    }
					}

					
					float price = b.getQuantity()*b.getMrp();
					price = price - b.getDiscount();
					b.setPrice(price);
					
					DefaultTableModel tmodel = (DefaultTableModel) table.getModel();
		
					tmodel.addRow(new Object[] {b.getBillno(),b.getPid(), b.getPname(), b.getQuantity(), b.getMrp(),price});

						float total = 0;
						for(int i = 0; i< table.getRowCount();i++) {
							total += Float.parseFloat(table.getValueAt(i, 5).toString());
						}
						totalTxt.setText(Float.toString(total));

				}
			});
			addBtn.setBackground(new Color(192, 191, 188));
			Image img = new ImageIcon(getClass().getResource("/addC.png")).getImage();
			addBtn.setIcon(new ImageIcon(img));
			addBtn.setBounds(83, 452, 133, 42);
		}
		return addBtn;
	}

	
//	private void displayBill() {
//		
//		BillService bs = new BillServiceImpl();
//		List<Bill> blist = bs.getsBillProducts();
//		
//		DefaultTableModel tmodel = (DefaultTableModel) table.getModel();
//		tmodel.setRowCount(0);
//		
//			for (Bill bl : blist) {
//				
//				tmodel.addRow(new Object[] {bl.getBillno(),bl.getPid(), bl.getPname(), bl.getQuantity(), bl.getMrp(),bl.getPrice()});
//				
//			}
//			float total = 0;
//			for(int i = 0; i< table.getRowCount();i++) {
//				total += Float.parseFloat(table.getValueAt(i, 5).toString());
//			}
//			totalTxt.setText(Float.toString(total));
//	}
	private JLabel getLblBillNo() {
		if (lblBillNo == null) {
			lblBillNo = new JLabel("Bill No");
			lblBillNo.setForeground(Color.WHITE);
			lblBillNo.setFont(new Font("FreeSans", Font.BOLD, 14));
			lblBillNo.setBounds(34, 98, 91, 15);
		}
		return lblBillNo;
	}
	private JTextField getBillTxt() {
		if (billTxt == null) {
			billTxt = new JTextField();
			billTxt.setColumns(10);
			billTxt.setBounds(209, 92, 196, 26);
		}
		return billTxt;
	}
	private JTextField getDisTxt() {
		if (disTxt == null) {
			disTxt = new JTextField();
			disTxt.setColumns(10);
			disTxt.setBounds(209, 379, 196, 26);
		}
		return disTxt;
	}
	private JLabel getLblDiscount() {
		if (lblDiscount == null) {
			lblDiscount = new JLabel("Discount");
			lblDiscount.setForeground(Color.WHITE);
			lblDiscount.setFont(new Font("FreeSans", Font.BOLD, 14));
			lblDiscount.setBounds(34, 385, 112, 15);
		}
		return lblDiscount;
	}
	private JComboBox getPidCmbo() {
		if (pidCmbo == null) {
			pidCmbo = new JComboBox();
			pidCmbo.setModel(new DefaultComboBoxModel(new String[] {"select pid", "101", "102", "103", "104", "105", "106", "107"}));
			pidCmbo.setBounds(209, 138, 196, 24);
		}
		return pidCmbo;
	}
	private JLabel getLblDate() {
		if (lblDate == null) {
			lblDate = new JLabel("Date");
			lblDate.setForeground(Color.WHITE);
			lblDate.setFont(new Font("FreeSans", Font.BOLD, 14));
			lblDate.setBounds(729, 42, 47, 15);
		}
		return lblDate;
	}
	private JDateChooser getDateTxt() {
		if (dateTxt == null) {
			dateTxt = new JDateChooser();
			dateTxt.setBounds(794, 36, 187, 26);
		}
		return dateTxt;
	}
	private JLabel getLblTotal() {
		if (lblTotal == null) {
			lblTotal = new JLabel("Total");
			lblTotal.setForeground(Color.WHITE);
			lblTotal.setFont(new Font("FreeSans", Font.BOLD, 14));
			lblTotal.setBounds(618, 427, 47, 15);
		}
		return lblTotal;
	}
	private JTextField getTotalTxt() {
		if (totalTxt == null) {
			totalTxt = new JTextField();
			totalTxt.setText("0");
			totalTxt.setColumns(10);
			totalTxt.setBounds(681, 421, 196, 26);
		}
		return totalTxt;
	}
	private JButton getRemoveBtn() {
		if (removeBtn == null) {
			removeBtn = new JButton("Remove");
			removeBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(table.getSelectedRow() < 0) {
						JOptionPane.showMessageDialog(null, "Select any row");
						return ;
					}
					
					int srow = table.getSelectedRow();
					int bid = (int) table.getModel().getValueAt(srow, 0);
					
					String total = totalTxt.getText();
					float price = (float) table.getModel().getValueAt(srow, 5);
					float total1 = Float.parseFloat(total) - price; 
					
					totalTxt.setText(Float.toString(total1));
					
					
					
					DefaultTableModel tmodel =(DefaultTableModel) table.getModel();
					
					if(table.getSelectedRowCount() ==1) {
						tmodel.removeRow(table.getSelectedRow());
					} else {
						if(table.getRowCount() == 0) {
							JOptionPane.showMessageDialog(null, "Table is empty");
						}
					}
					
//					BillService bs = new BillServiceImpl();
//					boolean res = bs.removeBill(bid);
//					
//					if(res) {
//						JOptionPane.showMessageDialog(null, "Delect Success");
////						displayBill();
//					}else {
//						JOptionPane.showMessageDialog(null, "Delete Failed");
//					}
					
//					Bill b = new Bill();
//					billTxt.setText(String.valueOf(""));
//					pidCmbo.setSelectedItem("");
//					pnameTxt.setText("");
//					custTxt.setText("");
//					quantityTxt.setText(String.valueOf(""));
//					mrpTxt.setText(String.valueOf(""));
//					disTxt.setText(String.valueOf(""));
//					dateTxt.setDateFormatString(String.valueOf(""));
//					totalTxt.setText(String.valueOf(total1));
					
				}
			});
			removeBtn.setBackground(new Color(192, 191, 188));
			removeBtn.setBounds(278, 452, 127, 42);
			Image img = new ImageIcon(getClass().getResource("/remove.png")).getImage();
			removeBtn.setIcon(new ImageIcon(img));
		}
		return removeBtn;
	}
	private JButton getSaveBtn() {
		if (saveBtn == null) {
			saveBtn = new JButton("Save");
			saveBtn.setBackground(new Color(192, 191, 188));
			saveBtn.setFont(new Font("FreeSans", Font.BOLD, 14));
			saveBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					
					Bill b = new Bill();
					
					b.setBillno(Integer.parseInt(billTxt.getText()));
					b.setCustname(custTxt.getText());
					
					java.util.Date selectedDate = dateTxt.getDate();
					java.sql.Date sqlDate = new java.sql.Date(selectedDate.getTime());
					b.setDate(sqlDate);
					
					b.setPrice(Float.parseFloat(totalTxt.getText()));
					JOptionPane.showMessageDialog(null, totalTxt.getText());;
					
					BillService bs = new BillServiceImpl();
					boolean resu = bs.addBill(b);
					if(resu) {
						JOptionPane.showMessageDialog(null, "Bill Saved");
					}else {
						JOptionPane.showMessageDialog(null, "Bill Not Saved");
					}
					
						DefaultTableModel tmodel = (DefaultTableModel) table.getModel();
						for(int i = 0 ; i < table.getRowCount(); i++) {
							
							int bid = Integer.parseInt(table.getValueAt(i, 0).toString());
							int pid = Integer.parseInt(table.getValueAt(i, 1).toString());
							String pname = table.getValueAt(i, 2).toString();
							int quantity = Integer.parseInt(table.getValueAt(i, 3).toString());
							float mrp = Float.parseFloat(table.getValueAt(i, 4).toString());
							float price = Float.parseFloat(table.getValueAt(i, 5).toString());

							boolean res = bs.addBillitem(bid, pid, pname,quantity, mrp,  price);
						
							if(!res) {
								JOptionPane.showMessageDialog(null, "Added failed");
							} 
						}
						dispose();
				}
			});
			saveBtn.setBackground(new Color(192, 191, 188));
			saveBtn.setBounds(472, 452, 127, 40);
			Image img = new ImageIcon(getClass().getResource("/addP.png")).getImage();
			saveBtn.setIcon(new ImageIcon(img));
		}
		return saveBtn;
	}
	private JLabel getBackLbl() {
		if (backLbl == null) {
			backLbl = new JLabel("");
			backLbl.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					new CashierUI().setVisible(true);
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
