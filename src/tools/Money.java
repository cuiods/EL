package tools;
import dataBase.DataBase;
public class Money implements Runnable{
	DataBase db = new DataBase();
	@Override
	public void run() {
		while(true){
			if(!DataBase.isPause){
				db.Money+=db.Money_Increment;
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
