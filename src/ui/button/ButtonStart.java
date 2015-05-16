package ui.button;

import gamecontrol.Controller;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import tools.MusicPlayer;
import tools.MusicThread;
import ui.FrameGame;



public class ButtonStart extends JLabel implements MouseListener,Runnable{

	Image ButtonImage = null;
	String filepath = null;
	static boolean isIn = false;
	public int x = 400;
	public int y = 600;
	
	public ButtonStart(){

		filepath = "graphics/button/startButton1.png";
		ButtonImage = new ImageIcon(filepath).getImage();
		this.setBounds(x,y,170,170);
	}
	
	public void paintComponent(Graphics g){
		if(!isIn){
			filepath = "graphics/button/startbutton1.png";
			ButtonImage = new ImageIcon(filepath).getImage();
		}else{
			filepath = "graphics/button/startButtonMoveIn.png";
			ButtonImage = new ImageIcon(filepath).getImage();
		}
		g.drawImage(ButtonImage, 0, 0, this.getWidth(), this.getHeight(), this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	
//		Controller.gameframe.startPanel.setVisible(false);
//		Controller.gameframe.fightPanel = new PanelFight();
//		Controller.gameframe.setContentPane(Controller.gameframe.fightPanel);
//		
//		Thread ft = new Thread(Controller.gameframe.fightPanel);
//		ft.start();
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
//		Controller.gameframe.startPanel.setVisible(false);
//		Controller.gameframe.fightPanel = new PanelFight();
//		Controller.gameframe.setContentPane(Controller.gameframe.fightPanel);
//		
//		Thread ft = new Thread(Controller.gameframe.fightPanel);
//		ft.start();
		
		//full screen (if needed)
//		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice(); 
//		gd.setFullScreenWindow(Controller.gameframe);
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		Controller.changeTo(FrameGame.STORYZERO);
		isIn = false;
		
		new MusicThread("music/effects/clicked.wav", false).start();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		isIn = true;
		this.repaint();
		
		//play sound
		new MusicThread("music/effects/moveIn.wav", false).start();
	}
	

	@Override
	public void mouseExited(MouseEvent e) {
		isIn = false;
		this.repaint();
	}

	@Override
	public void run() {
		while(y >= 400){
			try {
				Thread.sleep(50);
			} catch (Exception e) {
				e.printStackTrace();
			}
			y -= 15;
		}
	}
}
