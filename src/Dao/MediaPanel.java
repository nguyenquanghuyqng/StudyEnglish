package Dao;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;

import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.player.embedded.windows.Win32FullScreenStrategy;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;
import uk.co.caprica.vlcj.runtime.x.LibXUtil;
public class MediaPanel {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                
            	chargerLibrairie();
                 new MediaPanel(args);
//                 try {
//             		Thread.currentThread().join();
//             	} catch (InterruptedException e) {
//             		// TODO Auto-generated catch block
//             		System.out.println("Error");
//             	}
            }
        });

	}
	private static void chargerLibrairie(){
        NativeLibrary.addSearchPath(
               RuntimeUtil.getLibVlcLibraryName(), "C:/Program Files/VideoLAN/VLC");
       Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
       LibXUtil.initialise();
   }
  
   private MediaPanel(String[] args) {
       JFrame frame = new JFrame("Tutoriel vlcj");
       frame.setBounds(300, 80, 800, 500);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setVisible(true);
       //frame.setLocationRelativeTo(null);

       //Créer une instance de Canvas
       Canvas c = new Canvas();
       //L'arrière plan de la vidéo est noir par défaut
       c.setBackground(Color.black);
       JPanel p = new JPanel();
       p.setLayout(new BorderLayout());
       //La vidéo prend toute la surface
       p.add(c, BorderLayout.CENTER);
       frame.add(p, BorderLayout.CENTER);

       //Créer une instance factory
       MediaPlayerFactory mediaPlayerFactory = new MediaPlayerFactory();
       //Créer une instance lecteur média
       EmbeddedMediaPlayer mediaPlayer = mediaPlayerFactory.newEmbeddedMediaPlayer(new Win32FullScreenStrategy(frame));
       mediaPlayer.setVideoSurface(mediaPlayerFactory.newVideoSurface(c));
       
       //Set full màn  hình
       //mediaPlayer.toggleFullScreen();
       
       // Set chế độ thao tác chuột trên video
       // mediaPlayer.setEnableMouseInputHandling(false);
       
       //Désactiver le clavier à l'intérieur de JFrame
       mediaPlayer.setEnableKeyInputHandling(true);
      
       //Préparer le fichier
       mediaPlayer.prepareMedia("Video/Video1.mp4");
       //lire le fichier 
       mediaPlayer.play();
   }
  
}
