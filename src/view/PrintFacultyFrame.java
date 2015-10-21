package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import dao.FacultyDAO;
import model.Faculty;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import util.ComboBoxItem;
import util.MySQLHelper;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrintFacultyFrame extends JInternalFrame {
	private JComboBox cmbFaculty;
	private JButton btnPrint;

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
					PrintFacultyFrame frame = new PrintFacultyFrame();
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
	public PrintFacultyFrame() {
		setTitle("Print Faculty");
		setFrameIcon(new ImageIcon(PrintFacultyFrame.class.getResource("/images16/printer_add.png")));
		setClosable(true);
		setBounds(100, 100, 522, 166);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u0E1B\u0E23\u0E34\u0E19\u0E17\u0E4C\u0E02\u0E49\u0E2D\u0E21\u0E39\u0E25\u0E04\u0E13\u0E30", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 486, 114);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u0E40\u0E25\u0E37\u0E2D\u0E01\u0E04\u0E13\u0E30\u0E17\u0E35\u0E48\u0E15\u0E49\u0E2D\u0E07\u0E01\u0E32\u0E23\u0E1E\u0E34\u0E21\u0E1E\u0E4C");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(12, 47, 134, 14);
		panel.add(lblNewLabel);
		
		cmbFaculty = new JComboBox();
		cmbFaculty.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbFaculty.setBounds(143, 42, 228, 25);
		panel.add(cmbFaculty);
		
		btnPrint = new JButton("\u0E1E\u0E34\u0E21\u0E1E\u0E4C");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object item = cmbFaculty.getSelectedItem();
				String facultyId = ((ComboBoxItem)item).getKey();
				String file = "reports/student.jasper";
				Map map = new HashMap<>();
				map.put("facultyId", facultyId);
				
				try {
					JasperPrint print = JasperFillManager.fillReport(file, map, MySQLHelper.openDB());
					JasperViewer view = new JasperViewer(print, false);
					view.setVisible(true);
				} catch (JRException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnPrint.setIcon(new ImageIcon(PrintFacultyFrame.class.getResource("/images16/printer.png")));
		btnPrint.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPrint.setBounds(383, 37, 89, 35);
		panel.add(btnPrint);

		addFacultyToComboBox();
	}

	private void addFacultyToComboBox() {
		if(cmbFaculty.getItemCount()>0){
			cmbFaculty.removeAll();
		}
		
		FacultyDAO dao = new FacultyDAO();
		List<Faculty> faculties = new ArrayList<Faculty>();
		faculties = dao.selectAll();
		for (Faculty faculty : faculties) {
			cmbFaculty.addItem(new ComboBoxItem(
					faculty.getFacultyId(), 
					faculty.getFacultyName()));
		}
	}
}
