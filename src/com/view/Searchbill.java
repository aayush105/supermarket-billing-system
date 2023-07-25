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

public class Searchbill extends JFrame {

	private JPanel contentPane;
	private JLabel lblAddCashierDetails;
	private JLabel lblCashierId;
	private JTextField billTxt;
	private JScrollPane scrollPane;
	private JTable table;
	private int sid = 0;

	private JButton findBtn;
	private JLabel backLbl;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Searchbill frame = new Searchbill();
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
	public Searchbill() {
		setTitle("Search Bill");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 622, 621);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(new Color(94, 92, 100));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblAddCashierDetails());
		contentPane.add(getLblCashierId());
		contentPane.add(getBillTxt());
		contentPane.add(getScrollPane_1());

		contentPane.add(getFindBtn());
		contentPane.add(getBackLbl());
		displayBill();
	}
	private JLabel getLblAddCashierDetails() {
		if (lblAddCashierDetails == null) {
			lblAddCashierDetails = new JLabel("Search Bill");
			lblAddCashierDetails.setForeground(new Color(255, 255, 255));
			lblAddCashierDetails.setFont(new Font("FreeSans", Font.BOLD, 20));
			lblAddCashierDetails.setBounds(198, 24, 196, 26);
		}
		return lblAddCashierDetails;
	}
	private JLabel getLblCashierId() {
		if (lblCashierId == null) {
			lblCashierId = new JLabel("Bill No");
			lblCashierId.setFont(new Font("FreeSans", Font.BOLD, 14));
			lblCashierId.setForeground(new Color(255, 255, 255));
			lblCashierId.setBounds(117, 86, 57, 15);
		}
		return lblCashierId;
	}
	private JTextField getBillTxt() {
		if (billTxt == null) {
			billTxt = new JTextField();
			billTxt.setBounds(185, 74, 196, 37);
			billTxt.setColumns(10);
		}
		return billTxt;
	}
	
	private JScrollPane getScrollPane_1() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					
				}
			});
			scrollPane.setBounds(76, 167, 475, 394);
			scrollPane.setViewportView(getTable_1());
		}
		return scrollPane;
	}
	private JTable getTable_1() {
		if (table == null) {
			table = new JTable();
			
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Bill No", "Customer Name", "Amount",  "Date"
				}
			));
		}
		return table;
	}
	
	private void displayBill() {
		String bdata = billTxt.getText().trim();
		
		BillService bs = new BillServiceImpl();
		List<Bill> blist = bs.searchBill(bdata);
		
		DefaultTableModel tmodel = (DefaultTableModel) table.getModel();
		tmodel.setRowCount(0);
		
		for (Bill bl : blist) {
			tmodel.addRow(new Object[] {bl.getBillno(), bl.getCustname(), bl.getPrice(), bl.getDate()});
		}
	}
	
	private JButton getFindBtn() {
		if (findBtn == null) {
			findBtn = new JButton("Search");
			findBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String sdata = billTxt.getText().trim();
					
					BillService bs = new BillServiceImpl();
					List<Bill> blist = bs.searchBill(sdata);
					
					DefaultTableModel tmodel = (DefaultTableModel) table.getModel();
					tmodel.setRowCount(0);
					
					for(Bill b : blist) {
						tmodel.addRow(new Object[] {b.getBillno(), b.getCustname(), b.getPrice(), b.getDate() } );
					}
				}
			});
			findBtn.setBounds(417, 74, 134, 36);
			findBtn.setBackground(new Color(192, 191, 188));
			Image img = new ImageIcon(getClass().getResource("/search11.png")).getImage();
			findBtn.setIcon(new ImageIcon(img));
		}
		return findBtn;
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
