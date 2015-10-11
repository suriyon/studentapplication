package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class MainMenus extends JFrame {

	private JPanel contentPane;
	private FacultyFrame facultyFrame;
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
			}
		});
		mntmFaculty.setIcon(new ImageIcon(MainMenus.class.getResource("/images16/application_home.png")));
		mntmFaculty.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mnPrimary.add(mntmFaculty);
		
		JMenu mnNewMenu_1 = new JMenu("New menu");
		menuBar.add(mnNewMenu_1);
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
		btnExit.setIcon(new ImageIcon(MainMenus.class.getResource("/images32/cancel.png")));
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		toolBar.add(btnExit);
		
		desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
	}
}
