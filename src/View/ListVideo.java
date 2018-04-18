package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;

import Dao.GetListVideo;
import Model.Video;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;
import uk.co.caprica.vlcj.runtime.x.LibXUtil;

public class ListVideo {

	public JFrame frmListVideo;
	JMenu Home, Video, About;
	JMenuItem HomePage, ListVideo, Library, Help;
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
		JPanel HomeP = new JPanel();
		HomeP.setBackground(new Color(224, 255, 255));
		HomeP.setBorder(new TitledBorder(null, "List video", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		HomeP.setFont(new Font("Tahoma", Font.BOLD, 20));
		HomeP.setBounds(10, 11, 764, 418);
		frmListVideo.getContentPane().add(HomeP);
		HomeP.setLayout(null);

		JLabel video1 = new JLabel();
		// video1.setBackground(Color.YELLOW);
		video1.setIcon(new ImageIcon(""));
		video1.setBounds(17, 44, 170, 95);
		HomeP.add(video1);

		JLabel video2 = new JLabel();
		video2.setBackground(Color.GREEN);
		video2.setBounds(17, 168, 170, 95);
		HomeP.add(video2);

		JLabel video3 = new JLabel();
		video3.setBackground(Color.LIGHT_GRAY);
		video3.setBounds(17, 292, 170, 95);
		HomeP.add(video3);

		JLabel lblVideo1 = new JLabel("Video 1");
		lblVideo1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblVideo1.setBounds(200, 44, 579, 38);
		HomeP.add(lblVideo1);

		JLabel lblVideo2 = new JLabel("Video2\r\n");
		lblVideo2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblVideo2.setBounds(200, 168, 579, 38);
		HomeP.add(lblVideo2);

		JLabel lblVideo3 = new JLabel("Video3\r\n");
		lblVideo3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblVideo3.setBounds(200, 292, 579, 38);
		HomeP.add(lblVideo3);

		JLabel lblContent1 = new JLabel("Content1");
		lblContent1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblContent1.setBounds(200, 85, 579, 29);
		HomeP.add(lblContent1);

		JLabel lblContent2 = new JLabel("Content2");
		lblContent2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblContent2.setBounds(200, 208, 579, 29);
		HomeP.add(lblContent2);

		JLabel lblContent3 = new JLabel("Content3");
		lblContent3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblContent3.setBounds(205, 332, 579, 29);
		HomeP.add(lblContent3);

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
				String path = GetListVideo.GetPathVideo(1);
				System.out.println(path);
				HomeStudy hs = new HomeStudy(path);
				hs.frame.setVisible(true);
				frmListVideo.dispatchEvent(new WindowEvent(frmListVideo, WindowEvent.WINDOW_CLOSING));
			}
		});

		lblVideo2.addMouseListener(new MouseListener() {

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
				String path = GetListVideo.GetPathVideo(2);
				System.out.println(path);
				HomeStudy hs = new HomeStudy(path);
				hs.frame.setVisible(true);
				frmListVideo.dispatchEvent(new WindowEvent(frmListVideo, WindowEvent.WINDOW_CLOSING));
			}
		});

		lblVideo3.addMouseListener(new MouseListener() {

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
				String path = GetListVideo.GetPathVideo(3);
				HomeStudy hs = new HomeStudy(path);
				hs.frame.setVisible(true);
				frmListVideo.dispatchEvent(new WindowEvent(frmListVideo, WindowEvent.WINDOW_CLOSING));
			}
		});

		JMenuBar mb = new JMenuBar(); // Tạo ra một menuBar

		Video = new JMenu("Video");
		Video.setActionCommand("ListVideo");

		About = new JMenu("About");
		Help = new JMenuItem("Help");
		Help.setActionCommand("Help");
		About.add(Help);

		Home = new JMenu("Home");
		Home.setActionCommand("Home");

		mb.add(Home);

		HomePage = new JMenuItem("Home Page");
		Home.add(HomePage);

		// Tạo các sự kiện cho các menuItem
		mb.add(Video);

		ListVideo = new JMenuItem("List Video");
		Video.add(ListVideo);

		Library = new JMenuItem("Library");
		Video.add(Library);
		mb.add(About);

		frmListVideo.setJMenuBar(mb);
		frmListVideo.setBounds(320, 80, 800, 500);
		frmListVideo.getContentPane().setLayout(null);

		// Tạo ra MenuItemListener để bắt sự kiện
		MenuItemListener menuItemListener = new MenuItemListener();
		HomePage.addActionListener(menuItemListener);
		ListVideo.addActionListener(menuItemListener);
		Library.addActionListener(menuItemListener);
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
			if (e.getSource() == HomePage) {
				Home home = new Home();
				home.frmHome.setVisible(true);
				System.out.println("Home Page");
				frmListVideo.dispatchEvent(new WindowEvent(frmListVideo, WindowEvent.WINDOW_CLOSING));
			}
			if (e.getSource() == ListVideo) {
//				System.out.println("List Video");
//				ListVideo lv = new ListVideo();
//				lv.frmListVideo.setVisible(true);
			}
			if (e.getSource() == Help) {
				System.out.println("Help");
				
			}
			if (e.getSource() == Library) {
				System.out.println("Library");
			}
		}
	}
}