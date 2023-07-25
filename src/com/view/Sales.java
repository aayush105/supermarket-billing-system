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

public class Sales extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable table;
	private int sid = 0;
	private JLabel lblSales;
	private JLabel backLbl;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sales frame = new Sales();
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
	public Sales() {
		setTitle("Sales");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 911, 510);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(new Color(94, 92, 100));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getScrollPane_1());
		contentPane.add(getLblSales());
		contentPane.add(getBackLbl());
		displayBill();
	}
	
	private JScrollPane getScrollPane_1() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					
				}
			});
			scrollPane.setBounds(12, 73, 877, 395);
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
					"Product Name", "Mrp","Qty sold", "Inventory value",  "sales value", "Remaining Stock"
				}
			));
		}
		return table;
	}
	
	private void displayBill() {

		
		BillService bs = new BillServiceImpl();
		ResultSet rs = bs.allbill();
		
		try {
			while(rs.next()) {
			DefaultTableModel tmodel =(DefaultTableModel) table.getModel();
			float inventorySale = rs.getInt("available")*rs.getFloat("mrp");
//			tmodel.addRow(new Object[] {rs.getString("pname"), rs.getFloat("mrp"),rs.getInt("available"),rs.getInt("total_quantity") ,rs.getFloat((int) inventorySale), rs.getFloat("total_price"),rs.getInt(remaining)});
			tmodel.addRow(new Object[] {rs.getString("pname"), rs.getFloat("mrp"), rs.getInt("total_quantity"), inventorySale, rs.getFloat("total_price"), rs.getInt("available")});

			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	private JLabel getLblSales() {
		if (lblSales == null) {
			lblSales = new JLabel("SALES");
			lblSales.setFont(new Font("FreeSans", Font.BOLD, 20));
			lblSales.setForeground(new Color(255, 255, 255));
			lblSales.setBounds(428, 12, 72, 34);
		}
		return lblSales;
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
