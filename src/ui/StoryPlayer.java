package ui;

import java.awt.*;

import javax.swing.*;

import ui.button.ButtonNext;

public class StoryPlayer {
          //�ؿ�
          int pass;
      	public static Panelstory1 first = null;
    	
          //�ؿ���Ϊ����������
          public StoryPlayer(int pass){
        	 this.pass = pass;
        	 if(pass==1)
        	 first = new Panelstory1();
           }
          
    
       
}
