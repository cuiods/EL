package tools;
import dataBase.DataBase;
public class Money implements Runnable{
	DataBase db = new DataBase();
	@Override
	public void run() {
		while(true){
		db.Money+=2;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
	}
	
}
