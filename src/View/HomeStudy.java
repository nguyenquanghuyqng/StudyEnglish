package View;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;

import Dao.GetListVideo;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.player.embedded.windows.Win32FullScreenStrategy;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;
import uk.co.caprica.vlcj.runtime.x.LibXUtil;

public class HomeStudy {

	JFrame frame;
	int t = 0; // Biến để play video or pause video

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		SwingUtilities.invokeLater(new Runnable() {
//			@Override
//			public void run() {
//				try {
//					chargerLibrairie();
//					HomeStudy window = new HomeStudy();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

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
		frame = new JFrame("English pronunciation");
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 18));
		frame.getContentPane().setBackground(new Color(153, 153, 255));
		frame.setBounds(300, 80, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);

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
		HomePage.setFont(new Font("Tahoma", Font.BOLD, 16));
		HomePage.setBackground(new Color(224, 255, 255));
		HomePage.setBounds(10, 11, 760, 418);
		frame.getContentPane().add(HomePage, BorderLayout.NORTH);
		HomePage.setLayout(null);

		// Khởi tạo Canvas
		Canvas c = new Canvas();
		// Set background
		c.setBackground(Color.black);

		// Nơi chứa video
		JPanel Video = new JPanel();
		Video.setBounds(12, 30, 470, 290);
		Video.setLayout(new BorderLayout());
		Video.add(c, BorderLayout.CENTER);

		// frame.getContentPane().add(Video, BorderLayout.CENTER);
		HomePage.add(Video, BorderLayout.CENTER);
		// Video.setLayout(null);

		JLabel lblbackward = new JLabel(new ImageIcon("Images/backward.png"));
		lblbackward.setBounds(40, 330, 32, 32);
		HomePage.add(lblbackward);

		JLabel lblPlay = new JLabel(new ImageIcon("Images/pause.png"));
		lblPlay.setBounds(100, 330, 32, 32);
		HomePage.add(lblPlay);

		JLabel lblforward = new JLabel(new ImageIcon("Images/forward.png"));
		lblforward.setBounds(160, 330, 32, 32);
		HomePage.add(lblforward);

		JPanel Sub = new JPanel();
		Sub.setBorder(new TitledBorder(null, "Sub", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		Sub.setBounds(490, 22, 260, 377);
		HomePage.add(Sub);
		Sub.setLayout(null);

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
		mediaPlayer.play();

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
					t = 1;
				}
				else if(t==1){
					lblPlay.setIcon(new ImageIcon("Images/pause.png"));
					mediaPlayer.play();
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

	}

	private static void chargerLibrairie() {
		NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), "C:/Program Files/VideoLAN/VLC");
		Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
		LibXUtil.initialise();
	}
}
