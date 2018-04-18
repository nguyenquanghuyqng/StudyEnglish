package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.sql.ResultSet;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import com.mysql.jdbc.Blob;
import com.mysql.jdbc.PreparedStatement;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import com.sun.jna.platform.unix.X11.XClientMessageEvent.Data;

import DB.DBConnection;
import Dao.GetListVideo;
import Model.Video;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;
import uk.co.caprica.vlcj.runtime.x.LibXUtil;

public class ListVideo {

	public JFrame frmListVideo;
	JMenu Home, ListVideo, About;
	JMenuItem Help;
	// Biến để Browse Images
	BufferedImage bi;

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

		List<Video> list = GetListVideo.GetList();

		// Tạo form chính
		frmListVideo = new JFrame("English pronunciation");
		frmListVideo.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 18));
		frmListVideo.getContentPane().setBackground(new Color(153, 153, 255));
		frmListVideo.setBounds(300, 80, 800, 500);
		frmListVideo.getContentPane().setLayout(null);
		frmListVideo.setLocationRelativeTo(null);

		// Panel
		JPanel HomePage = new JPanel();
		HomePage.setBackground(new Color(224, 255, 255));
		HomePage.setBorder(new TitledBorder(null, "List video", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		HomePage.setFont(new Font("Tahoma", Font.BOLD, 20));
		HomePage.setBounds(10, 11, 764, 418);
		frmListVideo.getContentPane().add(HomePage);
		HomePage.setLayout(null);

		JLabel video1 = new JLabel();
		// video1.setBackground(Color.YELLOW);
		video1.setIcon(new ImageIcon(""));
		video1.setBounds(17, 44, 170, 95);
		HomePage.add(video1);

		JLabel video2 = new JLabel();
		video2.setBackground(Color.GREEN);
		video2.setBounds(17, 168, 170, 95);
		HomePage.add(video2);

		JLabel video3 = new JLabel();
		video3.setBackground(Color.LIGHT_GRAY);
		video3.setBounds(17, 292, 170, 95);
		HomePage.add(video3);

		JLabel lblVideo1 = new JLabel("Video 1");
		lblVideo1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblVideo1.setBounds(200, 44, 579, 38);
		HomePage.add(lblVideo1);

		JLabel lblVideo2 = new JLabel("Video2\r\n");
		lblVideo2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblVideo2.setBounds(200, 168, 579, 38);
		HomePage.add(lblVideo2);

		JLabel lblVideo3 = new JLabel("Video3\r\n");
		lblVideo3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblVideo3.setBounds(200, 292, 579, 38);
		HomePage.add(lblVideo3);

		JLabel lblContent1 = new JLabel("Content1");
		lblContent1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblContent1.setBounds(200, 85, 579, 29);
		HomePage.add(lblContent1);

		JLabel lblContent2 = new JLabel("Content2");
		lblContent2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblContent2.setBounds(200, 208, 579, 29);
		HomePage.add(lblContent2);

		JLabel lblContent3 = new JLabel("Content3");
		lblContent3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblContent3.setBounds(205, 332, 579, 29);
		HomePage.add(lblContent3);

		for (Video video : list) {

			if (video.getId() == 1) {
				lblVideo1.setText(video.getVideoname());
				lblContent1.setText(video.getContent());

				String img = video.getImage();
				video1.setIcon(new ImageIcon(img));
			} else {
				if (video.getId() == 2) {
					lblVideo2.setText(video.getVideoname());
					lblContent2.setText(video.getContent());
					String img = video.getImage();
					video2.setIcon(new ImageIcon(img));
				} else {
					if (video.getId() == 3) {
						lblVideo3.setText(video.getVideoname());
						lblContent3.setText(video.getContent());
						String img = video.getImage();
						video3.setIcon(new ImageIcon(img));
					}
				}
			}
		}

		// Bắt sự kiện click
		lblVideo1.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				chargerLibrairie();
				HomeStudy hs = new HomeStudy();
				hs.frame.setVisible(true);
				frmListVideo.dispatchEvent(new WindowEvent(frmListVideo, WindowEvent.WINDOW_CLOSING));
			}
		});

		JMenuBar mb = new JMenuBar(); // Tạo ra một menuBar

		Home = new JMenu("Home");
		Home.setActionCommand("Home");

		ListVideo = new JMenu("List video");
		ListVideo.setActionCommand("ListVideo");

		About = new JMenu("About");
		Help = new JMenuItem("Help");
		About.add(Help);

		mb.add(Home);
		mb.add(ListVideo);
		mb.add(About);

		frmListVideo.setJMenuBar(mb);
		frmListVideo.setBounds(320, 80, 800, 500);
		frmListVideo.getContentPane().setLayout(null);

		// Tạo ra MenuItemListener để bắt sự kiện
		MenuItemListener menuItemListener = new MenuItemListener();
		Home.addActionListener(menuItemListener);
		ListVideo.addActionListener(menuItemListener);
		Help.addActionListener(menuItemListener);

	}

	private static void chargerLibrairie() {
		NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), "C:/Program Files/VideoLAN/VLC");
		Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
		LibXUtil.initialise();
	}

	// Bắt sự kiện cho từng menuItem
	public class MenuItemListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// Kiêm tra khi click vào các menuItem
			if (e.getSource() == Home) {
				Home home = new Home();
				home.frmHome.setVisible(true);
				// frmListVideo.setVisible(false);
			}
			if (e.getSource() == ListVideo) {
				ListVideo lv = new ListVideo();
				lv.frmListVideo.setVisible(true);
			}

		}
	}
}
