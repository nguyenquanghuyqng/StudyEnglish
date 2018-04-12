package View;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.BorderLayout;

public class HomeStudy {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeStudy window = new HomeStudy();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HomeStudy() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(300, 80, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnHome = new JMenu("Home");
		menuBar.add(mnHome);
		
		JMenu mnListVideo = new JMenu("List Video");
		menuBar.add(mnListVideo);
		
		JMenu mnAbout = new JMenu("About");
		menuBar.add(mnAbout);
		
		JMenuItem mntmHelp = new JMenuItem("Help");
		mnAbout.add(mntmHelp);
		
		// Panel
		JPanel HomePage = new JPanel();
		HomePage.setBorder(new TitledBorder(null, "Pronunciation", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		frame.setFont(new Font("Tahoma",Font.BOLD,16));
		HomePage.setBounds(10, 11, 760, 426);
		frame.getContentPane().add(HomePage, BorderLayout.NORTH);
		HomePage.setLayout(null);
		
		JPanel Video = new JPanel();
		Video.setBorder(new TitledBorder(null, "Video", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		Video.setBounds(10, 22, 470, 377);
		HomePage.add(Video);
		Video.setLayout(null);
		
		JPanel Sub = new JPanel();
		Sub.setBorder(new TitledBorder(null, "Sub", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		Sub.setBounds(490, 22, 260, 377);
		HomePage.add(Sub);
		Sub.setLayout(null);

	}
}
