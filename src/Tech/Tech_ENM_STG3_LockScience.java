package Tech;

import tools.Time;
import dataBase.DataBase;
public class Tech_ENM_STG3_LockScience implements Runnable {
	Time t;
	public Tech_ENM_STG3_LockScience(){
		t = new Time(DataBase.LOCKSCIENCE_TIMELIMIT);
	}
	public void execute(){
		while(t.getRemainTime()>=0){
			DataBase.LockScience = true;
	    }
		DataBase.LockScience = false;
}

	@Override
	public void run() {
		this.execute();
		
	}
}
