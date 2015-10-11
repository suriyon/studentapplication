package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import dao.FacultyDAO;
import model.Faculty;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FacultyFrame extends JInternalFrame {
	private JTextField textFacId;
	private JTextField textFacName;

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
		setBounds(100, 100, 406, 300);
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
		
		JButton btnAdd = new JButton("\u0E40\u0E1E\u0E34\u0E48\u0E21");
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
		btnAdd.setBounds(25, 25, 89, 30);
		panel_1.add(btnAdd);
		
		JButton btnClose = new JButton("\u0E1B\u0E34\u0E14");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnClose.setIcon(new ImageIcon(FacultyFrame.class.getResource("/images16/cross.png")));
		btnClose.setBounds(260, 25, 89, 30);
		panel_1.add(btnClose);

		addFacId();
	}

	private void addFacId() {
		FacultyDAO dao = new FacultyDAO();
		textFacId.setText(dao.genFacId());
	}
}
