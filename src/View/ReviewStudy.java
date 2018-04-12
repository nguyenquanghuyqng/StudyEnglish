package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class ReviewStudy {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReviewStudy window = new ReviewStudy();
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
	public ReviewStudy() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("English pronunciation");
		frame.setBounds(300, 80, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel HomePage = new JPanel();
		HomePage.setBorder(new TitledBorder(null, "Pronunciation", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		frame.setFont(new Font("Tahoma",Font.BOLD,16));
		HomePage.setBounds(10, 11, 760, 539);
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
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Replay", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 410, 740, 118);
		HomePage.add(panel);
	}

}
