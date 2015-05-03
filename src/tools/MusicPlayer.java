package tools;

import java.io.*;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

public class MusicPlayer {
	public boolean stop = false;
	public void play(String file, boolean loop) throws UnsupportedAudioFileException, IOException, LineUnavailableException{ 
		do{
		// ��ȡ��Ƶ������
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(file));
		// ��ȡ��Ƶ�������
		AudioFormat audioFormat = audioInputStream.getFormat(); 
		// ������������
		DataLine.Info dataLineInfo = new DataLine.Info(SourceDataLine.class,audioFormat, AudioSystem.NOT_SPECIFIED);
		SourceDataLine sourceDataLine = (SourceDataLine) AudioSystem.getLine(dataLineInfo);
		sourceDataLine.open(audioFormat);
		sourceDataLine.start(); 
		/*
		 * ���������ж�ȡ���ݷ��͵�������
		 */
		int count;
		byte tempBuffer[] = new byte[1024];
		while ((count = audioInputStream.read(tempBuffer, 0, tempBuffer.length)) != -1) {
			if (count > 0) {
				sourceDataLine.write(tempBuffer, 0, count);
			}
			if(stop){
				sourceDataLine.drain();
				sourceDataLine.close();
			}
		} 
		// ������ݻ���,���ر�����
		sourceDataLine.drain();
		sourceDataLine.close();
		}while(loop);
		
		
	}
	
}
	 
