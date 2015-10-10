package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.FacultyDAO;
import model.Faculty;
import util.ComboBoxItem;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TestComboBox extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestComboBox frame = new TestComboBox();
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
	public TestComboBox() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object item = comboBox.getSelectedItem();
				String key = ((ComboBoxItem)item).getKey();
				JOptionPane.showMessageDialog(null, "key=>" + key);
			}
		});
		contentPane.add(comboBox, BorderLayout.NORTH);
		addFacultyToComboBox();
	}

	private void addFacultyToComboBox() {
		// TODO Auto-generated method stub
		FacultyDAO dao = new FacultyDAO();
		List<Faculty> faculties = dao.selectAll();
		for (Faculty faculty : faculties) {
			comboBox.addItem(new ComboBoxItem(faculty.getFacultyId(), faculty.getFacultyName()));			
		}		
	}

}
