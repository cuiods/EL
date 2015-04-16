package ui;

import gamecontrol.Controller;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import ui.button.ButtonUnit;
import units.*;
import dataBase.DataBase;


public class PanelUnit extends JPanel implements MouseListener{
	
	Image image = new ImageIcon("graphics/soldiers/unit.png").getImage();
	public PanelUnit(){
		this.setBounds(70, 50, 150, 60);
	}

	@Override
	public void paintComponent(Graphics g){
		g.drawImage(image,0,0,this.getWidth(),this.getHeight(),this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getX()<=50){
			if(DataBase.Money >= DataBase.SWORDMAN_P){
				this.addSwordman();
			}
		}else if(e.getX()<=100){
			if(DataBase.Money >= DataBase.GUNNER_P){
				this.addGunner();
			}
		}else if(e.getX()<=150){
			if(DataBase.Money >= DataBase.CANNON_P){
				this.addCannon();
			}
		}
		
		ButtonUnit.pressTime = 0;
		ButtonUnit.canRemove = true;
		PanelFight.removeUnitPanel();
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}
	
	/**
	 * add sword man to playerList
	 */
	public void addSwordman(){
		//create sword man
		SwordMan swordman = new SwordMan();
		// set player
		swordman.setKind(1);
		// add to player list
		DataBase.playerList.add(swordman);
		
		//start thread
		Thread st = new Thread(swordman);
		st.start();
		
		//deduct money
		DataBase.Money-=DataBase.SWORDMAN_P;
		
		Controller.gameframe.repaint();
	}
	
	/**
	 * add sword man to playerList
	 */
	public void addGunner() {
		Gunner gunner = new Gunner();
		gunner.setKind(1);
		DataBase.playerList.add(gunner);
		
		Thread st = new Thread(gunner);
		st.start();
		
		DataBase.Money-=DataBase.GUNNER_P;
		
		Controller.gameframe.repaint();
		
	}
	
	/**
	 * add cannon man to playerList
	 */
	public void addCannon(){
		Cannon cannon = new Cannon();
		cannon.setKind(1);
		DataBase.playerList.add(cannon);
		
		Thread st = new Thread(cannon);
		st.start();
		
		DataBase.Money-=DataBase.CANNON_P;
		
		Controller.gameframe.repaint();
	}

	
}
