package view;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import dao.BranchDAO;
import dao.FacultyDAO;
import model.Branch;
import model.Faculty;
import util.ComboBoxItem;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BranchFrame extends JInternalFrame {
	private JTextField textBrachId;
	private JTextField textBranchName;
	private JComboBox cmbFaculty;
	private JButton btnAdd;
	private JButton btnEdit;
	private JButton btnClear;
	private JButton btnExit;
	private JScrollPane scrollPane;
	
	private JTable table;
	private DefaultTableModel model;
	
	private List<Faculty> faculties;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BranchFrame frame = new BranchFrame();
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
	public BranchFrame() {
		setFrameIcon(new ImageIcon(BranchFrame.class.getResource("/images16/drive_edit.png")));
		setClosable(true);
		setTitle("Branch Management");
		setBounds(100, 100, 572, 461);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u0E02\u0E49\u0E2D\u0E21\u0E39\u0E25\u0E2A\u0E32\u0E02\u0E32", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 539, 110);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		textBrachId = new JTextField();
		textBrachId.setEnabled(false);
		textBrachId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textBrachId.setBounds(15, 56, 101, 25);
		panel.add(textBrachId);
		textBrachId.setColumns(10);
		
		textBranchName = new JTextField();
		textBranchName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textBranchName.setBounds(131, 56, 218, 25);
		panel.add(textBranchName);
		textBranchName.setColumns(10);
		
		cmbFaculty = new JComboBox();
		cmbFaculty.setEditable(true);
		cmbFaculty.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbFaculty.setBounds(364, 56, 160, 25);
		panel.add(cmbFaculty);
		
		JLabel lblNewLabel = new JLabel("\u0E23\u0E2B\u0E31\u0E2A\u0E2A\u0E32\u0E02\u0E32");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(15, 31, 75, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u0E0A\u0E37\u0E48\u0E2D\u0E2A\u0E32\u0E02\u0E32");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(131, 31, 69, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u0E0A\u0E37\u0E48\u0E2D\u0E04\u0E13\u0E30");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(364, 31, 60, 14);
		panel.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u0E08\u0E31\u0E14\u0E01\u0E32\u0E23\u0E02\u0E49\u0E2D\u0E21\u0E39\u0E25\u0E2A\u0E32\u0E02\u0E32", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 132, 539, 78);
		getContentPane().add(panel_1);
		
		btnAdd = new JButton("\u0E40\u0E1E\u0E34\u0E48\u0E21");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textBranchName.getText().equals("")){
					JOptionPane.showMessageDialog(null, "ป้อนข้อมูลให้ครบ");
				}else{
					String branchId = textBrachId.getText();
					String branchName = textBranchName.getText();
					Object item = cmbFaculty.getSelectedItem();
					String facultyId = ((ComboBoxItem)item).getKey(); 
					//System.out.println(facultyId);
					Branch branch = new Branch(branchId, branchName, facultyId);
					
					BranchDAO dao = new BranchDAO();
					boolean result = dao.insert(branch);
					
					if(result){
						JOptionPane.showMessageDialog(null, "เพิ่มข้อมูลสำเร็จ");
						addDataToTable();
						addBranchId();
					}else{
						JOptionPane.showMessageDialog(null, "เพิ่มข้อมูลไม่สำเร็จ");
					}
					textBranchName.setText("");
				}
			}
		});
		btnAdd.setIcon(new ImageIcon(BranchFrame.class.getResource("/images16/add.png")));
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAdd.setBounds(40, 25, 84, 30);
		panel_1.add(btnAdd);
		
		btnExit = new JButton("\u0E1B\u0E34\u0E14");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setIcon(new ImageIcon(BranchFrame.class.getResource("/images16/cross.png")));
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnExit.setBounds(412, 25, 84, 30);
		panel_1.add(btnExit);
		
		btnEdit = new JButton("\u0E41\u0E01\u0E49\u0E44\u0E02");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String branchName = textBranchName.getText();
				String branchId = textBrachId.getText();
				Branch branch = new Branch();
				branch.setBrachName(branchName);
				branch.setBranchId(branchId);
				
				BranchDAO dao = new BranchDAO();
				boolean result = dao.update(branch);
				if(result){
					JOptionPane.showMessageDialog(null, "แก้ไขข้อมูลสำเร็จ");
				}else{
					JOptionPane.showMessageDialog(null, "แก้ไขข้อมูลไม่สำเร็จ");
				}
				
				addBranchId();
				textBranchName.setText("");
				addFacultyToComboBox();
				btnAdd.setEnabled(true);
				btnEdit.setEnabled(false);
				addDataToTable();
			}
		});
		btnEdit.setEnabled(false);
		btnEdit.setIcon(new ImageIcon(BranchFrame.class.getResource("/images16/drive_edit.png")));
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEdit.setBounds(164, 25, 84, 30);
		panel_1.add(btnEdit);
		
		btnClear = new JButton("\u0E25\u0E49\u0E32\u0E07");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				addFacultyToComboBox();
				addBranchId();
				
				textBranchName.setText("");
				
				btnAdd.setEnabled(true);
				btnEdit.setEnabled(false);
				
				table.clearSelection();
			}
		});
		btnClear.setIcon(new ImageIcon(BranchFrame.class.getResource("/images16/accept.png")));
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnClear.setBounds(288, 26, 84, 30);
		panel_1.add(btnClear);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "\u0E41\u0E2A\u0E14\u0E07\u0E02\u0E49\u0E2D\u0E21\u0E39\u0E25\u0E2A\u0E32\u0E02\u0E32", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 221, 539, 199);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 26, 519, 162);
		panel_2.add(scrollPane);

		addFacultyToComboBox();
		prepareTable(); 
		
		addDataToTable();
		addBranchId();
	}

	protected void addBranchId() {
		BranchDAO dao = new BranchDAO();
		textBrachId.setText(dao.genBranchId());
	}

	private void addFacultyToComboBox() {
		FacultyDAO dao = new FacultyDAO();
		faculties = new ArrayList<>();
		faculties = dao.selectAll();
		cmbFaculty.removeAllItems();
		for (Faculty faculty : faculties) {
			cmbFaculty.addItem(new ComboBoxItem(
					faculty.getFacultyId(), 
					faculty.getFacultyName()));
		}		
	}
	
	private void prepareTable() {
		model = new DefaultTableModel();
		model.addColumn("รหัสสาขา");
		model.addColumn("ชื่อสาขา");
		model.addColumn("รหัสคณะ");
		
		table = new JTable(model);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				textBrachId.setText(model.getValueAt(row, 0).toString());
				textBranchName.setText(model.getValueAt(row, 1).toString());
				
				String facultyId = model.getValueAt(row, 2).toString();
				for (Faculty faculty : faculties) {
					if(faculty.getFacultyId().equals(facultyId)){
						cmbFaculty.getEditor().setItem(faculty.getFacultyName());
					}
				}
								
				btnAdd.setEnabled(false);
				btnEdit.setEnabled(true);
			}
		});
		
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(120);
		table.getColumnModel().getColumn(1).setPreferredWidth(300);
		table.getColumnModel().getColumn(2).setPreferredWidth(300);
		
		table.setFillsViewportHeight(true);
		scrollPane.add(table);
		scrollPane.setViewportView(table);		
	}
	
	private void addDataToTable() {		
		removeTable();
		
		BranchDAO dao = new BranchDAO();
		Vector data = dao.showBranch();
		int row = data.size();
		for(int i=0;i<row;i++){
			model.addRow((Vector) data.get(i));
		}
	}

	private void removeTable() {
		if(table.getRowCount()>0){
			int row = table.getRowCount();
			for(int i=0;i<row;i++){
				model.removeRow(0);
			}
		}		
	}
}
