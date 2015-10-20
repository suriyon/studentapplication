package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import util.MySQLHelper;

import javax.swing.UIManager;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import java.awt.Frame;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class MainMenus extends JFrame {

	private JPanel contentPane;
	private FacultyFrame facultyFrame;
	private BranchFrame branchFrame;
	private StudentFrame studentFrame;
	private JDesktopPane desktopPane;

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
					MainMenus frame = new MainMenus();
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
	public MainMenus() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainMenus.class.getResource("/images32/cat.png")));
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setTitle("Student Application");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnPrimary = new JMenu("\u0E08\u0E31\u0E14\u0E01\u0E32\u0E23\u0E02\u0E49\u0E2D\u0E21\u0E39\u0E25\u0E1E\u0E37\u0E49\u0E19\u0E10\u0E32\u0E19");
		mnPrimary.setFont(new Font("Tahoma", Font.PLAIN, 12));
		menuBar.add(mnPrimary);
		
		JMenuItem mntmFaculty = new JMenuItem("\u0E02\u0E49\u0E2D\u0E21\u0E39\u0E25\u0E04\u0E13\u0E30");
		mntmFaculty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(facultyFrame==null || facultyFrame.isClosed()){
					facultyFrame = new FacultyFrame();
					facultyFrame.setVisible(true);
					desktopPane.add(facultyFrame);
				}
				try {
					facultyFrame.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mntmFaculty.setIcon(new ImageIcon(MainMenus.class.getResource("/images16/application_home.png")));
		mntmFaculty.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mnPrimary.add(mntmFaculty);
		
		JMenuItem mntmBranch = new JMenuItem("\u0E02\u0E49\u0E2D\u0E21\u0E39\u0E25\u0E2A\u0E32\u0E02\u0E32");
		mntmBranch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(branchFrame==null || branchFrame.isClosed()){
					branchFrame = new BranchFrame();
					branchFrame.setVisible(true);
					desktopPane.add(branchFrame);
				}
				try {
					branchFrame.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mntmBranch.setIcon(new ImageIcon(MainMenus.class.getResource("/images16/drive_edit.png")));
		mntmBranch.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mnPrimary.add(mntmBranch);
		
		JMenuItem mntmStudent = new JMenuItem("\u0E02\u0E49\u0E2D\u0E21\u0E39\u0E25\u0E19\u0E31\u0E01\u0E28\u0E36\u0E01\u0E29\u0E32");
		mntmStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(studentFrame==null || studentFrame.isClosed()){
					studentFrame = new StudentFrame();
					studentFrame.setVisible(true);
					desktopPane.add(studentFrame);
				}
				try {
					studentFrame.setMaximum(true);
				} catch (PropertyVetoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		mntmStudent.setIcon(new ImageIcon(MainMenus.class.getResource("/images16/user.png")));
		mntmStudent.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mnPrimary.add(mntmStudent);
		
		JMenu mnPrint = new JMenu("\u0E1E\u0E34\u0E21\u0E1E\u0E4C\u0E23\u0E32\u0E22\u0E07\u0E32\u0E19");
		mnPrint.setFont(new Font("Tahoma", Font.PLAIN, 12));
		menuBar.add(mnPrint);
		
		JMenuItem mntmPrintStudent = new JMenuItem("\u0E1E\u0E34\u0E21\u0E1E\u0E4C\u0E02\u0E49\u0E2D\u0E21\u0E39\u0E25\u0E19\u0E31\u0E01\u0E28\u0E36\u0E01\u0E29\u0E32");
		mntmPrintStudent.setIcon(new ImageIcon(MainMenus.class.getResource("/images16/printer.png")));
		mntmPrintStudent.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mnPrint.add(mntmPrintStudent);
		
		JMenuItem mntmPrintFaculty = new JMenuItem("\u0E1E\u0E34\u0E21\u0E1E\u0E4C\u0E02\u0E49\u0E2D\u0E21\u0E39\u0E25\u0E04\u0E13\u0E30");
		mntmPrintFaculty.setIcon(new ImageIcon(MainMenus.class.getResource("/images16/printer_add.png")));
		mntmPrintFaculty.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mnPrint.add(mntmPrintFaculty);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		JButton btnFaculty = new JButton("\u0E08\u0E31\u0E14\u0E01\u0E32\u0E23\u0E02\u0E49\u0E2D\u0E21\u0E39\u0E25\u0E04\u0E13\u0E30");
		btnFaculty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(facultyFrame==null || facultyFrame.isClosed()){
					facultyFrame = new FacultyFrame();
					facultyFrame.setVisible(true);
					desktopPane.add(facultyFrame);
				}
				try {
					facultyFrame.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnFaculty.setIcon(new ImageIcon(MainMenus.class.getResource("/images32/application_home.png")));
		btnFaculty.setFont(new Font("Tahoma", Font.PLAIN, 12));
		toolBar.add(btnFaculty);
		
		JButton btnExit = new JButton("\u0E1B\u0E34\u0E14\u0E42\u0E1B\u0E23\u0E41\u0E01\u0E23\u0E21");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		JButton btnPrint = new JButton("\u0E1E\u0E34\u0E21\u0E1E\u0E4C\u0E02\u0E49\u0E2D\u0E21\u0E39\u0E25\u0E04\u0E13\u0E30");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String report = "reports/facultyReport.jasper";
				Map map = new HashMap<>();
				try {
					JasperPrint jp = JasperFillManager.fillReport(report, map, MySQLHelper.openDB());
					JasperViewer jv = new JasperViewer(jp, false);
					jv.setVisible(true);
				} catch (JRException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnStudent = new JButton("\u0E08\u0E31\u0E14\u0E01\u0E32\u0E23\u0E02\u0E49\u0E2D\u0E21\u0E39\u0E25\u0E19\u0E31\u0E01\u0E28\u0E36\u0E01\u0E29\u0E32");
		btnStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(studentFrame==null || studentFrame.isClosed()){
					studentFrame = new StudentFrame();
					studentFrame.setVisible(true);
					desktopPane.add(studentFrame);
				}
				try {
					studentFrame.setMaximum(true);
				} catch (PropertyVetoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnStudent.setIcon(new ImageIcon(MainMenus.class.getResource("/images32/user.png")));
		btnStudent.setFont(new Font("Tahoma", Font.PLAIN, 12));
		toolBar.add(btnStudent);
		btnPrint.setIcon(new ImageIcon(MainMenus.class.getResource("/images32/printer.png")));
		btnPrint.setFont(new Font("Tahoma", Font.PLAIN, 12));
		toolBar.add(btnPrint);
		btnExit.setIcon(new ImageIcon(MainMenus.class.getResource("/images32/cancel.png")));
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		toolBar.add(btnExit);
		
		desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
	}
}
