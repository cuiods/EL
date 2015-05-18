package tools;

import dataBase.DataBase;

public class Time implements Runnable{
	/*
	 * by @niansong
	 */
	/*
	 * ��������ʼ��ʱ��getremaintime������ȡ��ʼ��ʱ�����ڻ��ж೤ʱ��
	 * ����ʱ��Ϊ10min
	 */
	long now;
	long timeleft;
	long timeLimit;
	int remainTime;
	public Time(long tl){
		timeLimit = tl;
		DataBase.StartTime = System.currentTimeMillis();
		Thread th = new Thread(this);
		th.start();
	}
	public int getRemainTime(){
		return this.remainTime;
	}
	public int updateRemainTime(){
		now = System.currentTimeMillis();
		timeleft = timeLimit-(now - DataBase.StartTime);
		return (int) (timeleft/1000);
	}
	@Override
	public void run() {
		this.remainTime = updateRemainTime();
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
	}
}
