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

import dataBase.DataBase;
import tools.MusicPlayer;
import tools.MusicThread;
import ui.FrameGame;

public class ButtonClassic extends JLabel implements MouseListener,Runnable{
	
	Image ButtonImage = null;
	String filepath = null;
	static boolean isIn = false;
	public int x = 550;
	public int y = 0;
	
	public ButtonClassic(){
		filepath = "graphics/button/classicbutton1.png";
		ButtonImage = new ImageIcon(filepath).getImage();
		this.setBounds(x, y, 140, 140);
	}
	
	public void paintComponent(Graphics g){
		if(!isIn){
			filepath = "graphics/button/classic1.png";
			ButtonImage = new ImageIcon(filepath).getImage();
		}else{
			filepath = "graphics/button/classicButtonMoveIn.png";
			ButtonImage = new ImageIcon(filepath).getImage();
		}
		g.drawImage(ButtonImage, 0, 0, this.getWidth(), this.getHeight(), this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		new MusicThread("music/effects/clicked.wav", false).start();
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		DataBase.pass = 11;
		Controller.changeTo(FrameGame.CLASSICPANEL);
		isIn = false;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		isIn = true;
		this.repaint();
		
		new MusicThread("music/effects/moveIn.wav", false).start();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		isIn = false;
		this.repaint();
		
	}

	@Override
	public void run() {
		while(y<=250){
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			y+=20;
		}
	}

}
