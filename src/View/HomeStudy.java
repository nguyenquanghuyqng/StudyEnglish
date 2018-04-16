package View;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;

import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.player.embedded.windows.Win32FullScreenStrategy;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;
import uk.co.caprica.vlcj.runtime.x.LibXUtil;

public class HomeStudy {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					chargerLibrairie();
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
		frame = new JFrame("English pronunciation");
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 18));
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
		HomePage.setBounds(10, 11, 760, 418);
		frame.getContentPane().add(HomePage, BorderLayout.NORTH);
		HomePage.setLayout(null);

		// Créer une instance de Canvas
		Canvas c = new Canvas();
		// L'arrière plan de la vidéo est noir par défaut
		c.setBackground(Color.black);

		JPanel Video = new JPanel();
		Video.setBorder(new TitledBorder(null, "Video", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		Video.setBounds(10, 22, 470, 377);
		Video.setLayout(new BorderLayout());
		Video.add(c, BorderLayout.CENTER);
		
		//frame.getContentPane().add(Video, BorderLayout.CENTER);
		HomePage.add(Video, BorderLayout.CENTER);
		// Video.setLayout(null);

		JPanel Sub = new JPanel();
		Sub.setBorder(new TitledBorder(null, "Sub", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		Sub.setBounds(490, 22, 260, 377);
		HomePage.add(Sub);
		Sub.setLayout(null);

		// La vidéo prend toute la surface

		// Créer une instance factory
		MediaPlayerFactory mediaPlayerFactory = new MediaPlayerFactory();
		// Créer une instance lecteur média
		EmbeddedMediaPlayer mediaPlayer = mediaPlayerFactory.newEmbeddedMediaPlayer(new Win32FullScreenStrategy(frame));
		mediaPlayer.setVideoSurface(mediaPlayerFactory.newVideoSurface(c));

		// Set full màn hình
		// mediaPlayer.toggleFullScreen();

		// Set chế độ thao tác chuột trên video
		// mediaPlayer.setEnableMouseInputHandling(false);

		// Désactiver le clavier à l'intérieur de JFrame
		mediaPlayer.setEnableKeyInputHandling(true);

		// Préparer le fichier
		mediaPlayer.prepareMedia("Video/Video1.mp4");
		// lire le fichier
		mediaPlayer.play();

	}

	private static void chargerLibrairie() {
		NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), "C:/Program Files/VideoLAN/VLC");
		Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
		LibXUtil.initialise();
	}
}
