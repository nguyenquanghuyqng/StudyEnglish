package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class ListVideo {

	public JFrame frmListVideo;
	JMenu Home, ListVideo, About;
	JMenuItem Help;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListVideo window = new ListVideo();
					window.frmListVideo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ListVideo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// Tạo form chính
		frmListVideo = new JFrame("English pronunciation");
		frmListVideo.setBounds(300, 80, 800, 600);
		frmListVideo.getContentPane().setLayout(null);

		// Panel
		JPanel HomePage = new JPanel();
		HomePage.setBorder(new TitledBorder(null, "List video", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		// Login.setFont(new Font("Tahoma",Font.BOLD,16));
		HomePage.setBounds(10, 11, 760, 418);
		frmListVideo.getContentPane().add(HomePage);
		HomePage.setLayout(null);

		JMenuBar mb = new JMenuBar(); // Tạo ra một menuBar

		Home = new JMenu("Home");
		ListVideo = new JMenu("List video");
		About = new JMenu("About");
		Help = new JMenuItem("Help");
		About.add(Help);

		mb.add(Home);
		mb.add(ListVideo);
		mb.add(About);

		frmListVideo.setJMenuBar(mb);
		frmListVideo.setBounds(320, 80, 800, 500);
		frmListVideo.getContentPane().setLayout(null);
	}

}
