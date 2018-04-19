package View;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import javax.swing.border.TitledBorder;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;

import Dao.GetSub;
import Model.Sub;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.player.embedded.windows.Win32FullScreenStrategy;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;
import uk.co.caprica.vlcj.runtime.x.LibXUtil;

public class HomeStudy {

	JFrame frame;
	public JFrame frmListVideo;
	JMenu Home, Video, About;
	JMenuItem HomePage, ListVideo, Library, Help;
	int t = 0; // Biến để play video or pause video

	Timer timerVideo;
	JProgressBar progressBar = new JProgressBar();

	static final int MY_MINIMUM = 0;
	static final int MY_MAXIMUM = 100;
	int timeOfVideo;

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// SwingUtilities.invokeLater(new Runnable() {
	// @Override
	// public void run() {
	// try {
	// chargerLibrairie();
	// HomeStudy window = new HomeStudy();
	// window.frame.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	// });
	// }

	/**
	 * Create the application.
	 */
	public HomeStudy(String path) {
		initialize(path);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String path) {

		List<Sub> lsubtime = GetSub.GetListTime(1);
		List<Sub> lsubtsub = GetSub.GetListSub(1);

		frame = new JFrame("English pronunciation");
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 18));
		frame.getContentPane().setBackground(new Color(153, 153, 255));
		frame.setBounds(300, 80, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		

		// Panel
		JPanel HomeP = new JPanel();
		HomeP.setBorder(new TitledBorder(null, "Pronunciation", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		HomeP.setFont(new Font("Tahoma", Font.BOLD, 16));
		HomeP.setBackground(new Color(224, 255, 255));
		HomeP.setBounds(10, 11, 760, 418);
		frame.getContentPane().add(HomeP, BorderLayout.NORTH);
		HomeP.setLayout(null);

		// Khởi tạo Canvas
		Canvas c = new Canvas();
		// Set background
		c.setBackground(Color.black);

		// Nơi chứa video
		JPanel VideoP = new JPanel();
		VideoP.setBounds(12, 30, 470, 290);
		VideoP.setLayout(new BorderLayout());
		VideoP.add(c, BorderLayout.CENTER);

		// frame.getContentPane().add(Video, BorderLayout.CENTER);
		HomeP.add(VideoP, BorderLayout.CENTER);
		// VideoP.setLayout(null);

		progressBar = new JProgressBar();
		progressBar.setBounds(12, 320, 470, 10);
		HomeP.add(progressBar);

		// Lable timer
		JLabel time = new JLabel();
		time.setBounds(20, 330, 70, 30);
		time.setText("00:00");
		HomeP.add(time);

		JLabel lblbackward = new JLabel(new ImageIcon("Images/backward.png"));
		lblbackward.setBounds(60, 330, 32, 32);
		HomeP.add(lblbackward);

		JLabel lblPlay = new JLabel(new ImageIcon("Images/pause.png"));
		lblPlay.setBounds(120, 330, 32, 32);
		HomeP.add(lblPlay);

		JLabel lblforward = new JLabel(new ImageIcon("Images/forward.png"));
		lblforward.setBounds(180, 330, 32, 32);
		HomeP.add(lblforward);

		// Nơi chứa Sub
		JPanel SubP = new JPanel();
		SubP.setBorder(new TitledBorder(null, "Sub", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		SubP.setBounds(490, 22, 260, 377);
		HomeP.add(SubP);
//		SubP.setLayout(null);

		JPanel control = new JPanel();
		control.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		control.setBounds(12, 320, 470, 50);
		HomeP.add(control);

		// Khởi tạo MediaPlayerFactory
		MediaPlayerFactory mediaPlayerFactory = new MediaPlayerFactory();
		// Tạo một thể loại media player
		EmbeddedMediaPlayer mediaPlayer = mediaPlayerFactory.newEmbeddedMediaPlayer(new Win32FullScreenStrategy(frame));
		mediaPlayer.setVideoSurface(mediaPlayerFactory.newVideoSurface(c));

		// Set full màn hình
		// mediaPlayer.toggleFullScreen();

		// Set chế độ thao tác chuột trên video
		// mediaPlayer.setEnableMouseInputHandling(false);

		// Tắt bàn phím bên trong JFrame
		mediaPlayer.setEnableKeyInputHandling(true);

		// Préparer le fichier
		mediaPlayer.prepareMedia(path);
		// lire le fichier
		mediaPlayer.start();

		// Su kien timer
		long t1 = mediaPlayer.getLength();
		long t3 = t1 / 1000;
		int t2 = (int) (long) t1;
		int t4 = (int) (long) t3;
		System.out.println(t4 + "thoi gian");

		progressBar.setMinimum(0);
		progressBar.setMaximum(t4);

		timerVideo = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int val = progressBar.getValue();
				if (val >= progressBar.getMaximum()) {
					// timer.stop();
					// mediaPlayer.stop();
					lblPlay.setIcon(new ImageIcon("Images/pause.png"));
					return;
				}
				progressBar.setValue(++val);
				int s = progressBar.getValue();
				if (s < 60) {
					if (s < 10) {
						time.setText("00:0" + String.valueOf(s));
					} else {
						time.setText("00:" + String.valueOf(s));
					}
				} else {
					int p = s / 60;
					s = s % 60;
					if (s < 10 && p < 10) {
						time.setText("0" + String.valueOf(p) + ":0" + String.valueOf(s));
					} else {
						if (s > 10 && p < 10) {
							time.setText("0" + String.valueOf(p) + ":" + String.valueOf(s));
						} else {
							if (s > 10 && p >= 10) {
								time.setText(String.valueOf(p) + ":0" + String.valueOf(s));
							} else {
								time.setText(String.valueOf(p) + ":" + String.valueOf(s));
							}
						}
					}
					time.setText(String.valueOf(p) + ":" + String.valueOf(s));
				}
			}
		});
		timerVideo.start();

		// Sự kiện play or pause video
		lblPlay.addMouseListener(new MouseListener() {

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
				if (t == 0) {
					lblPlay.setIcon(new ImageIcon("Images/play.png"));
					mediaPlayer.pause();
					timerVideo.stop();
					t = 1;
				} else if (t == 1) {
					lblPlay.setIcon(new ImageIcon("Images/pause.png"));
					mediaPlayer.play();
					timerVideo.start();
					t = 0;
				}
			}
		});

		// Sự kiện tua nhanh
		lblforward.addMouseListener(new MouseListener() {

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

			}
		});

		// Sự kiện tua chậm
		lblbackward.addMouseListener(new MouseListener() {

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
				// TODO Auto-generated method stub

			}
		});

		// Sub
		// final DefaultListModel<String> l1 = new DefaultListModel<>();
		// for (Sub s : lsubtime) {
		// l1.addElement(s.getTime());
		// System.out.println(s.getTime());
		// }
		// JList<String> listsubtime = new JList<>(l1);
		// listsubtime.setBounds(300, 25, 50, 300);
		// SubP.add(listsubtime);
		final DefaultListModel<String> l1 = new DefaultListModel<>();
		for (Sub s : lsubtsub) {
			l1.addElement(s.getContent());
			System.out.println(s.getContent());
		}
		JList<String> listsub = new JList<>(l1);
		listsub.setBounds(500, 25, 200, 100);
		SubP.add(listsub);

		JMenuBar mb = new JMenuBar(); // Tạo ra một menuBar

		Video = new JMenu("Video");
		Video.setActionCommand("Video");

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

		frame.setJMenuBar(mb);
		frame.setBounds(320, 80, 800, 500);
		frame.getContentPane().setLayout(null);

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
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			}
			if (e.getSource() == ListVideo) {
				System.out.println("List Video");
				ListVideo lv = new ListVideo();
				lv.frmListVideo.setVisible(true);
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
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
