package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class Home {

	JFrame frmHome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.frmHome.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// Tạo form chính
		frmHome = new JFrame("English pronunciation");
		frmHome.setBounds(400, 200, 400, 260);
		frmHome.getContentPane().setLayout(null);

		// Panel
		JPanel HomePage = new JPanel();
		HomePage.setBorder(new TitledBorder(null, "English pronunciation", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		// Login.setFont(new Font("Tahoma",Font.BOLD,16));
		HomePage.setBounds(12, 10, 362, 200);
		frmHome.getContentPane().add(HomePage);
		HomePage.setLayout(null);

		// Tạo button đăng nhập
		JButton btnListVieo = new JButton("List Video");
		btnListVieo.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnListVieo.setBounds(100, 40, 160, 50);
		btnListVieo.setIcon(new ImageIcon(""));
		HomePage.add(btnListVieo);

		// Tạo button đăng nhập
		JButton btnLib = new JButton("Library");
		btnLib.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLib.setBounds(100, 120, 160, 50);
		btnLib.setIcon(new ImageIcon(""));
		HomePage.add(btnLib);
		
		// Bắt sự kiện khi click vào ListVideo
		btnListVieo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ListVideo lv = new ListVideo();
				lv.frmListVideo.setVisible(true);
				Home hp = new Home();
				hp.frmHome.dispatchEvent(new WindowEvent(frmHome, WindowEvent.WINDOW_CLOSING));
			}
		});
	}

}
