package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import dao.FacultyDAO;
import model.Faculty;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FacultyFrame extends JInternalFrame {
	private JTextField textFacId;
	private JTextField textFacName;
	private JScrollPane scrollPane;
	private DefaultTableModel model;
	private JTable table;
	private int rowSelected;
	private JButton btnAdd;
	private JButton btnEdit;
	private JButton btnClear;

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
					FacultyFrame frame = new FacultyFrame();
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
	public FacultyFrame() {
		setFrameIcon(new ImageIcon(FacultyFrame.class.getResource("/images32/application_home.png")));
		setTitle("Faculty Management");
		setClosable(true);
		setBounds(100, 100, 406, 387);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u0E02\u0E49\u0E2D\u0E21\u0E39\u0E25\u0E04\u0E13\u0E30", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 370, 101);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u0E23\u0E2B\u0E31\u0E2A\u0E04\u0E13\u0E30");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(21, 30, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u0E0A\u0E37\u0E48\u0E2D\u0E04\u0E13\u0E30");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(117, 30, 46, 14);
		panel.add(lblNewLabel_1);
		
		textFacId = new JTextField();
		textFacId.setHorizontalAlignment(SwingConstants.RIGHT);
		textFacId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFacId.setEnabled(false);
		textFacId.setBounds(21, 48, 86, 22);
		panel.add(textFacId);
		textFacId.setColumns(10);		
		
		textFacName = new JTextField();
		textFacName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFacName.setBounds(117, 48, 230, 22);
		panel.add(textFacName);
		textFacName.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u0E08\u0E31\u0E14\u0E01\u0E32\u0E23\u0E02\u0E49\u0E2D\u0E21\u0E39\u0E25\u0E04\u0E13\u0E30", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 118, 370, 72);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		btnAdd = new JButton("\u0E40\u0E1E\u0E34\u0E48\u0E21");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFacName.getText().equals("")){
					JOptionPane.showMessageDialog(null, "ป้อนข้อมูลให้ครบ");
				}else{
					String facultyId = textFacId.getText();
					String facultyName = textFacName.getText();
					Faculty faculty = new Faculty(facultyId, facultyName);
					
					FacultyDAO dao = new FacultyDAO();
					boolean result = dao.insert(faculty);
					
					if(result){
						JOptionPane.showMessageDialog(null, "เพิ่มข้อมูลสำเร็จ");
						addDataToTable();
						addFacId();
					}else{
						JOptionPane.showMessageDialog(null, "เพิ่มข้อมูลไม่สำเร็จ");
					}
					textFacName.setText("");
				}							
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAdd.setIcon(new ImageIcon(FacultyFrame.class.getResource("/images16/add.png")));
		btnAdd.setBounds(10, 25, 84, 30);
		panel_1.add(btnAdd);
		
		JButton btnClose = new JButton("\u0E1B\u0E34\u0E14");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnClose.setIcon(new ImageIcon(FacultyFrame.class.getResource("/images16/cross.png")));
		btnClose.setBounds(276, 25, 84, 30);
		panel_1.add(btnClose);
		
		btnEdit = new JButton("\u0E41\u0E01\u0E49\u0E44\u0E02");
		btnEdit.setEnabled(false);
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textFacName.getText().equals("")){
					JOptionPane.showMessageDialog(null, "ป้อนข้อมูลให้ครบ");
				}else{
					String facultyId = textFacId.getText();
					String facultyName = textFacName.getText();
					Faculty faculty = new Faculty(facultyId, facultyName);
					
					FacultyDAO dao = new FacultyDAO();
					boolean result = dao.update(faculty);
					
					if(result){
						JOptionPane.showMessageDialog(null, "แก้ไขข้อมูลสำเร็จ");
						addDataToTable();
						addFacId();
						
						btnAdd.setEnabled(true);
						btnEdit.setEnabled(false);
						
					}else{
						JOptionPane.showMessageDialog(null, "แก้ไขข้อมูลไม่สำเร็จ");
					}
					textFacName.setText("");
				}
			}
		});
		btnEdit.setIcon(new ImageIcon(FacultyFrame.class.getResource("/images16/drive_edit.png")));
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEdit.setBounds(100, 25, 84, 30);
		panel_1.add(btnEdit);
		
		btnClear = new JButton("\u0E25\u0E49\u0E32\u0E07");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {								
				clearData();
			}
		});
		btnClear.setIcon(new ImageIcon(FacultyFrame.class.getResource("/images16/accept.png")));
		btnClear.setBounds(188, 25, 84, 30);
		panel_1.add(btnClear);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u0E41\u0E2A\u0E14\u0E07\u0E02\u0E49\u0E2D\u0E21\u0E39\u0E25\u0E04\u0E13\u0E30", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(10, 201, 370, 145);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 23, 350, 111);
		panel_2.add(scrollPane);

		addFacId();
		prepareTable();
		addDataToTable();
	}

	protected void clearData() {
		addFacId();
		addDataToTable();
		btnAdd.setEnabled(true);
		btnEdit.setEnabled(false);
		textFacName.setText("");
	}

	private void addDataToTable() {		
		removeTable();
		
		FacultyDAO dao = new FacultyDAO();
		Vector data = dao.showFaculty();
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

	private void prepareTable() {
		model = new DefaultTableModel();
		model.addColumn("รหัสคณะ");
		model.addColumn("ชื่อคณะ");
		
		table = new JTable(model);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				rowSelected = table.getSelectedRow();			
				textFacId.setText(model.getValueAt(rowSelected, 0).toString());
				textFacName.setText(model.getValueAt(rowSelected, 1).toString());
				
				btnAdd.setEnabled(false);
				btnEdit.setEnabled(true);
			}
		});
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(120);
		table.getColumnModel().getColumn(1).setPreferredWidth(300);
		
		table.setFillsViewportHeight(true);
		scrollPane.add(table);
		scrollPane.setViewportView(table);		
	}

	private void addFacId() {
		FacultyDAO dao = new FacultyDAO();
		textFacId.setText(dao.genFacId());
	}
}
