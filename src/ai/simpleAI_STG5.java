package ai;

import units.S_Unit;
import dataBase.DataBase;

public class simpleAI_STG5 extends AI implements Runnable{
	double AutoAtkRate = 0.8;
	public AIcommander AIC = new AIcommander();
	public simpleAI_STG5(){
	}
	@Override
	public void detect() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		execute(analyze(0),0);
		execute(analyze(1),1);
		execute(analyze(2),2);
		
	}
	public int analyze(int path_num) {
		Threat = 0;
		for(int i=0;i<DataBase.playerList.size()&&DataBase.playerList.get(i).path==path_num;i++){
			S_Unit u = DataBase.playerList.get(i);
			if(u.getType()!=100&&u.getType()!=102){
				if(path_num==0){
				int dis = (int) Math.sqrt((db.START_LOC_X_ENM_STG4-u.getX())*(db.START_LOC_X_ENM_STG4-u.getX())+
						(db.START_LOC_Y_ENM_STG4-u.getY())*(db.START_LOC_Y_ENM_STG4-u.getY()));
				if (dis <=200) Threat +=100;
				}
				if(path_num==1){
					int dis = (int) Math.sqrt((db.START_LOC_X_ENM_STG4-u.getX())*(db.START_LOC_X_ENM_STG4-u.getX())+
							(db.START_LOC_Y_ENM_STG4+165-u.getY())*(db.START_LOC_Y_ENM_STG4+165-u.getY()));
					if (dis <=200) Threat +=100;
				}
				if(path_num==2){
					int dis = (int) Math.sqrt((db.START_LOC_X_ENM_STG4-u.getX())*(db.START_LOC_X_ENM_STG4-u.getX())+
							(db.START_LOC_Y_ENM_STG4+330-u.getY())*(db.START_LOC_Y_ENM_STG4+330-u.getY()));
					if (dis <=200) Threat +=100;
				}
			Threat+=u.getHp()*u.attack;
			}
		}
		for(int i=0;i<DataBase.enemyList.size()&&DataBase.enemyList.get(i).path==path_num;i++){
			S_Unit u = DataBase.enemyList.get(i); 
			if(u.getType()!=100&&u.getType()!=101&&u.getType()!=8){
				Threat-=u.getHp()*u.attack*1.5;
				}
		} 
//		for(int i=0;i<DataBase.playerList.size()&&DataBase.playerList.get(i).path==path_num;i++){
//			Unit u = DataBase.playerList.get(i); 
//			int dis = (int) Math.sqrt((db.START_LOC_X_ENM_STG3-u.getX())*(db.START_LOC_X_ENM_STG3-u.getX())+
//					(db.START_LOC_Y_ENM_STG3-u.getY())*(db.START_LOC_Y_ENM_STG3-u.getY()));
//			if (dis <=200) Threat +=100;
//
//		}
		System.out.println(Threat);
		return Threat;
	}

	public void execute(int Threat,int path_num) {
		AutoAtkRate-=0.001;
		if(Threat<=0&&Math.random()>AutoAtkRate){
			AIC.addDrone(path_num);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			AIC.KillerVirus();
		}else if(Threat>0&&Threat<200&&Math.random()>0.4){
			AIC.GeneMissile();
			AIC.addRazerShip(path_num);
		}else if(Threat>=200&&Threat<340&&Math.random()>0.3){
			AIC.addRobotWarrior(path_num);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			AIC.addRazerShip(path_num);
		}else if(Threat>=340&&Threat<450&&Math.random()>0.4&&(DataBase.LockScience==false)){
			AIC.LockScience();
			AIC.addRazerShip(path_num);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			AIC.KillerVirus();
		}else if(Threat>=450&&Threat<=800){
			AIC.GeneMissile();
			AIC.KillerVirus();
			AIC.addRobotWarrior(path_num);
		}else if(Threat>=800){
			AIC.PhotonStrike();
		}
	}
	public void run() {
//		AIC.LockScience();
		AIC.addDrone(this.getRadomPath());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		AIC.addDrone(this.getRadomPath());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		AIC.addRazerShip(this.getRadomPath());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		AIC.addDrone(this.getRadomPath());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		AIC.addRazerShip(this.getRadomPath());
		while(!DataBase.isPause&&DataBase.pass==5){
			detect();
		}

	}
	@Override
	public int analyze() {
		// TODO 自动生成的方法存根
		return 0;
	}
	@Override
	public void execute(int Threat) {
		// TODO 自动生成的方法存根
		
	}
	public int getRadomPath(){
		return (int) (Math.random()*3);
	}
}
