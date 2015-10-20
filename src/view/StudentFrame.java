package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import dao.BranchDAO;
import dao.FacultyDAO;
import dao.StudentDAO;
import model.Branch;
import model.Faculty;
import model.Student;
import util.ComboBoxItem;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class StudentFrame extends JInternalFrame {
	private JTextField textStudentId;
	private JTextField textStudentName;
	private JComboBox cmbFaculty;
	private JButton btnClose;
	private JButton btnAdd;
	private JButton btnEdit;
	private JButton btnClear;
	private JScrollPane scrollPane;
	
	private DefaultTableModel model;
	private JTable table;
	private JLabel lblNewLabel_4;
	private JTextField textSearch;
	private JButton btnSearch;
	
	private List<Faculty> faculties;
	private List<Branch> branches;
	private JComboBox cmbBranch;

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
					StudentFrame frame = new StudentFrame();
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
	public StudentFrame() {
		setFrameIcon(new ImageIcon(StudentFrame.class.getResource("/images32/user.png")));
		setTitle("Student Frame");
		setClosable(true);
		setBounds(100, 100, 557, 625);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u0E02\u0E49\u0E2D\u0E21\u0E39\u0E25\u0E19\u0E31\u0E01\u0E28\u0E36\u0E01\u0E29\u0E32", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 516, 151);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u0E23\u0E2B\u0E31\u0E2A\u0E19\u0E31\u0E01\u0E28\u0E36\u0E01\u0E29\u0E32");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(20, 23, 104, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u0E0A\u0E37\u0E48\u0E2D-\u0E19\u0E32\u0E21\u0E2A\u0E01\u0E38\u0E25");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(20, 82, 104, 14);
		panel.add(lblNewLabel_1);
		
		textStudentId = new JTextField();
		textStudentId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textStudentId.setBounds(20, 48, 159, 25);
		panel.add(textStudentId);
		textStudentId.setColumns(10);
		
		textStudentName = new JTextField();
		textStudentName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textStudentName.setBounds(20, 107, 224, 25);
		panel.add(textStudentName);
		textStudentName.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u0E04\u0E13\u0E30\u0E17\u0E35\u0E48\u0E2A\u0E31\u0E07\u0E01\u0E31\u0E14");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(258, 24, 104, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u0E2A\u0E32\u0E02\u0E32\u0E17\u0E35\u0E48\u0E2A\u0E31\u0E07\u0E01\u0E31\u0E14");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(258, 83, 104, 14);
		panel.add(lblNewLabel_3);
		
		cmbFaculty = new JComboBox();
		cmbFaculty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object item = cmbFaculty.getSelectedItem();
				String facultyId = ((ComboBoxItem)item).getKey();
				//JOptionPane.showMessageDialog(null, facultyId);
				addBranchToComboBox(facultyId);
			}
		});
		cmbFaculty.setEditable(true);
		cmbFaculty.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbFaculty.setBounds(258, 48, 236, 25);
		panel.add(cmbFaculty);
		
		cmbBranch = new JComboBox();
		cmbBranch.setEditable(true);
		cmbBranch.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbBranch.setBounds(258, 107, 236, 25);
		panel.add(cmbBranch);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u0E08\u0E31\u0E14\u0E01\u0E32\u0E23\u0E02\u0E49\u0E2D\u0E21\u0E39\u0E25\u0E19\u0E31\u0E01\u0E28\u0E36\u0E01\u0E29\u0E32", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 173, 516, 84);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		btnAdd = new JButton("\u0E40\u0E1E\u0E34\u0E48\u0E21");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textStudentName.getText().equals("") || textStudentId.getText().equals("")){
					textStudentId.setText("");
					textStudentName.setText("");
					JOptionPane.showMessageDialog(null, "กรุณากรอกข้อมูลให้ครบ");
				}else{
					String studentId = textStudentId.getText();
					String studentName = textStudentName.getText();
					Object item = cmbBranch.getSelectedItem();
					String branchId = ((ComboBoxItem)item).getKey();
					Student student = new Student(studentId, studentName, branchId);
					StudentDAO dao = new StudentDAO();
					 
					boolean result = dao.insert(student);
					if(result)
						JOptionPane.showMessageDialog(null, "เพิ่มข้อมูลสำเร็จ");
					else
						JOptionPane.showMessageDialog(null, "เพิ่มข้อมูลไม่สำเร็จ");
					
					textStudentId.setText("");
					textStudentName.setText("");
					
					addDataToTable();
				}
			}
		});
		btnAdd.setIcon(new ImageIcon(StudentFrame.class.getResource("/images16/user_add.png")));
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAdd.setBounds(32, 28, 89, 35);
		panel_1.add(btnAdd);
		
		btnEdit = new JButton("\u0E41\u0E01\u0E49\u0E44\u0E02");
		btnEdit.setEnabled(false);
		btnEdit.setIcon(new ImageIcon(StudentFrame.class.getResource("/images16/user_edit.png")));
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEdit.setBounds(153, 28, 89, 35);
		panel_1.add(btnEdit);
		
		btnClear = new JButton("\u0E25\u0E49\u0E32\u0E07");
		btnClear.setIcon(new ImageIcon(StudentFrame.class.getResource("/images16/arrow_rotate_clockwise.png")));
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnClear.setBounds(274, 28, 89, 35);
		panel_1.add(btnClear);
		
		btnClose = new JButton("\u0E1B\u0E34\u0E14");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnClose.setIcon(new ImageIcon(StudentFrame.class.getResource("/images16/cross.png")));
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnClose.setBounds(395, 28, 89, 35);
		panel_1.add(btnClose);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "\u0E04\u0E49\u0E19\u0E2B\u0E32\u0E02\u0E49\u0E2D\u0E21\u0E39\u0E25\u0E19\u0E31\u0E01\u0E28\u0E36\u0E01\u0E29\u0E32", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 268, 516, 74);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		lblNewLabel_4 = new JLabel("\u0E04\u0E49\u0E19\u0E2B\u0E32\u0E08\u0E32\u0E01\u0E0A\u0E37\u0E48\u0E2D\u0E19\u0E31\u0E01\u0E28\u0E36\u0E01\u0E29\u0E32");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(26, 36, 110, 14);
		panel_2.add(lblNewLabel_4);
		
		textSearch = new JTextField();
		textSearch.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textSearch.setBounds(155, 31, 214, 25);
		panel_2.add(textSearch);
		textSearch.setColumns(10);
		
		btnSearch = new JButton("\u0E04\u0E49\u0E19\u0E2B\u0E32");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String studentName = textSearch.getText();
				addDataToTable(studentName);
			}
		});
		btnSearch.setIcon(new ImageIcon(StudentFrame.class.getResource("/images16/magnifier.png")));
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSearch.setBounds(395, 24, 89, 35);
		panel_2.add(btnSearch);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "\u0E41\u0E2A\u0E14\u0E07\u0E02\u0E49\u0E2D\u0E21\u0E39\u0E25\u0E19\u0E31\u0E01\u0E28\u0E36\u0E01\u0E29\u0E32", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(10, 353, 516, 231);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 23, 496, 197);
		panel_3.add(scrollPane);

		prepareTable();
		addFacultyToComboBox();
	}

	protected void addDataToTable() {
		removeDataFromTable();
		
		StudentDAO dao = new StudentDAO();
		Vector data = dao.showStudentAll();
		int row = data.size();
		for(int i=0;i<row;i++){
			model.addRow((Vector) data.get(i));
		}
	}

	protected void addDataToTable(String studentName) {
		removeDataFromTable();
		
		StudentDAO dao = new StudentDAO();
		Vector data = dao.selectStudentByName(studentName);
		int row = data.size();
		//System.out.println(row);
		for(int i=0;i<row;i++){
			model.addRow((Vector) data.get(i));
			//System.out.println(data.get(i).toString());
		}
	}

	private void removeDataFromTable() {
//		if(model.getRowCount()>0)
//			table.removeAll();
		if(table.getRowCount()>0){
			int row = table.getRowCount();
			for(int i=0;i<row;i++){
				model.removeRow(0);
			}
		}
	}

	private void prepareTable() {
		model = new DefaultTableModel();
		model.addColumn("รหัสนักศึกษา");
		model.addColumn("ชื่อ-นามสกุล");
		model.addColumn("รหัสสาขาที่สังกัด");
		
		table = new JTable(model);
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(150);
		table.getColumnModel().getColumn(1).setPreferredWidth(300);
		table.getColumnModel().getColumn(2).setPreferredWidth(250);
		
		table.setFillsViewportHeight(true);
		scrollPane.add(table);
		scrollPane.setViewportView(table);		
	}
	
	private void addFacultyToComboBox() {
		if(cmbFaculty.getItemCount()>0)
			cmbFaculty.removeAllItems();
		FacultyDAO dao = new FacultyDAO();
		faculties = new ArrayList<>();
		faculties = dao.selectAll();
		
		for (Faculty faculty : faculties) {
			cmbFaculty.addItem(new ComboBoxItem(
					faculty.getFacultyId(), 
					faculty.getFacultyName()));
		}		
	}
	
	private void addBranchToComboBox(String facultyId){
		if(cmbBranch.getItemCount()>0)
			cmbBranch.removeAllItems();
		BranchDAO dao = new BranchDAO();
		branches = new ArrayList<>();
		branches = dao.selectBranchByKey(facultyId);
		
		for (Branch branch : branches) {
			cmbBranch.addItem(new ComboBoxItem(
					branch.getBranchId(), 
					branch.getBrachName()));
		}
	}
}
