package tools;
import dataBase.DataBase;
public class Money implements Runnable{
	@Override
	public void run() {
		while(DataBase.threadContinue){
			if(!DataBase.isPause){
				DataBase.Money+=DataBase.Money_Increment;
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
	}
	
}
