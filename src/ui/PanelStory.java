package ui;

import gamecontrol.Controller;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import dataBase.DataBase;
import ui.button.*;

public class PanelStory extends PanelFade implements MouseListener {
      public static int picNum=1;
      String path="graphics/storyteller/story";
      Image story=null;
      ButtonLast last;
      private int endNum = 1;
      
      public PanelStory(){   	
    	  last = new ButtonLast();  
    	  this.setLayout(null); 		
  		  this.add(last);
  		  last.addMouseListener(last);
  		  this.addMouseListener(this);
  		  setEnd();
      }
      
      @Override
      public void paintComponent(Graphics g){
    		
    		g.drawImage(new ImageIcon("graphics/storyteller/story"+DataBase.pass+"_"+picNum+".png").getImage(), 0, 0, this.getWidth(),this.getHeight(),this);
    	  
    	 }
      
      private void setEnd(){
    	  switch(DataBase.pass){
    	  case 1:endNum = 2;break;
    	  case 2:endNum = 3;break;
    	  case 3:endNum = 5;break;
    	  case 4:endNum = 6;break;
    	  case 5:endNum = 4;break;
    	  case 6:endNum = 1;break;
    	  }
      }

	 @Override
	 public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	 }

	 @Override
	 public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	 }

	 @Override
	 public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	 }

	 @Override
	 public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	 }

	 @Override
	 public void mouseReleased(MouseEvent e) {
		if(picNum<endNum){
			picNum++;
			repaint();
		}else{
			Controller.changeTo(FrameGame.AIMPANEL);
			picNum=1;
		}
	 }
     
}
