package tools;

import dataBase.DataBase;

public class Time {
	/*
	 * by @niansong
	 */
	/*
	 * ��������ʼ��ʱ��getremaintime������ȡ��ʼ��ʱ�����ڻ��ж೤ʱ��
	 * ����ʱ��Ϊ10min
	 */
	long now;
	long timeleft;
	long timeLimit = DataBase.TIMELIMIT_STG2;
	public Time(){
		DataBase.StartTime = System.currentTimeMillis();
	}
	public int getRemainTime(){
		now = System.currentTimeMillis();
		timeleft = timeLimit-(now - DataBase.StartTime);
		return (int) (timeleft/1000);
	}
}
