package ai;

import units.S_Unit;
import dataBase.DataBase;

public class simpleAI_Classic extends AI implements Runnable{
	public int Threat = 0;
	public int Pass = 11;
	public int Money = 0;
	AIMoney m;
	AIcommander AIC;
	public simpleAI_Classic(){
		AIC = new AIcommander();
		this.Pass = AIMoney.AIPass;
		this.Money = AIMoney.Money;
		m = new AIMoney();
		Thread th = new Thread(m);
		th.start();
	}
	@Override
	public void detect() {
		this.Pass = AIMoney.AIPass;
		this.Money = AIMoney.Money;
		System.out.println(this.Pass);
		System.out.println(DataBase.pass);
		System.out.println(this.Money);
		System.out.println(AIMoney.Money_Increment);
		execute(analyzeThreat(0),analyzeThreat(1),analyzeThreat(2),analyzeDevelop(),
				analyzeAttackRisk(analyzeThreat(0),analyzeThreat(1),analyzeThreat(2)));

	}

	private void execute(int ThreatResult0, int ThreatResult1, int ThreatResult2,
			int DevelopResult, int AttackPotentialResult ) {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		System.out.printf("\nThreats are : %d %d %d \n",
				ThreatResult0,ThreatResult1,ThreatResult2);
		System.out.println(this.getCastlePercentage(1));
		resist(ThreatResult0,0);
		resist(ThreatResult1,1);
		resist(ThreatResult2,2);
		
	}
	private void resist(int Threat, int path_num){
		boolean vacant = true;
		int dis;
		for(int i=0;i<DataBase.playerList.size();i++){
			if(DataBase.playerList.get(i).path==path_num){
			S_Unit u = DataBase.playerList.get(i); 
			dis = (int) Math.sqrt((db.START_LOC_X_ENM_STG5-u.getX())*(db.START_LOC_X_ENM_STG5-u.getX())+
					(db.START_LOC_Y_ENM_STG5+165*path_num-u.getY())*(db.START_LOC_Y_ENM_STG5+165*path_num-u.getY()));
			for(int j=0;j<DataBase.enemyList.size();j++){
				if(DataBase.enemyList.get(j).getType()!=100){
				if(DataBase.enemyList.get(j).path==path_num) vacant = false;
				}
			}
			if (dis <=300&&vacant) this.CheckAndAdd(AIAction.Rifle, path_num);
			}
		}
		System.out.println("path "+path_num+" vacant is "+vacant);
	}
	//analyze the Threat to our site
	private int analyzeThreat(int path_num) {
		int result = 0;
		for(int i=0;i<DataBase.playerList.size();i++){
			S_Unit ce = DataBase.playerList.get(i);
			if(ce.getType()!=101){
				if(ce.path==path_num)
					result+=ce.attack*ce.getHp();
			}
			else{
				result+=60;
			}
		}
		for(int i=0;i<DataBase.enemyList.size();i++){
			S_Unit ce = DataBase.enemyList.get(i);
			if(ce.path==path_num)
				result-=ce.attack*ce.getHp();
		}
		return balanceByLevel(result);
	}
	private int analyzeAttackRisk(int ThreatResult0,int ThreatResult1,int ThreatResult2){
		int weakThreat = Math.min(Math.min(ThreatResult0, ThreatResult1), ThreatResult2);
		return (int) (weakThreat*getCastlePercentage(1)*getCastlePercentage(1));
	}
	private int getWeakPath(){
		int ThreatResult0 = analyzeThreat(0);
		int ThreatResult1 = analyzeThreat(0);
		int ThreatResult2 = analyzeThreat(0);
		int path = 0;
		int weak = ThreatResult0;
		if(ThreatResult1<=weak){
			path = 1;
			weak = ThreatResult1;
		}
		if(ThreatResult2<=weak){
			path = 2;
		}
		return path;
	}
	private int analyzeDevelop(){

		return 0;
	}
	private int balanceByLevel(int prudentData){
		int result = (int) (prudentData/(Math.pow(3, this.Pass-11)));
		return result;
	}
	private double getCastlePercentage(int Kind){
		double CastleHp = 0;
		double FullCastleHp = 0;
		if(Kind==0){
			for(int i=0;i<DataBase.enemyList.size();i++){
				if(DataBase.enemyList.get(i).getType()==100){
					CastleHp = DataBase.enemyList.get(i).getHp();
				}
			}
			switch(Pass){
			case 11: FullCastleHp = DataBase.CASTLE_HP_CLASSIC_LV1;break;
			case 12: FullCastleHp = DataBase.CASTLE_HP_CLASSIC_LV2;break;
			case 13: FullCastleHp = DataBase.CASTLE_HP_CLASSIC_LV3;break;
			}
		}
		else{
			for(int i=0;i<DataBase.playerList.size();i++){
				if(DataBase.playerList.get(i).getType()==100){
					CastleHp = DataBase.playerList.get(i).getHp();
				}
			}
			switch(DataBase.pass){
			case 11: FullCastleHp = DataBase.CASTLE_HP_CLASSIC_LV1;break;
			case 12: FullCastleHp = DataBase.CASTLE_HP_CLASSIC_LV2;break;
			case 13: FullCastleHp = DataBase.CASTLE_HP_CLASSIC_LV3;break;
			}
		}
		System.out.printf("FUllHP is %f and Now is %f \n",FullCastleHp,CastleHp);
		return CastleHp/FullCastleHp;
	}
	public void CheckAndAdd(AIAction action,int path_num){
		switch(action){
		case MedicTeam: if(this.Money>=DataBase.MEDICTEAM_P){
			AIC.addMedicTeam(path_num);
		}break;
		case Sniper: if(this.Money>=DataBase.SNIPER_P){
			AIC.addSniper(path_num);
		}break;
		case Truck: if(this.Money>=DataBase.TRUCK_P){
			AIC.addTruck(path_num);
		}break;
		case Rifle: if(this.Money>=DataBase.RIFLE_P){
			AIC.addRifle(path_num);
		}break;
		case SpaceCarrier: if(this.Money>=DataBase.SPACECARRIER_P&&this.Pass==12){
			AIC.addSpaceCarrier(path_num);
		}break;
		case SpaceMan: if(this.Money>=DataBase.SPACEMAN_P&&this.Pass==12){
			AIC.addSpaceMan(path_num);
		}break;
		case SpaceShip: if(this.Money>=DataBase.SPACESHIP_P&&this.Pass==12){
			AIC.addSpaceShip(path_num);
		}break;
		case Drone: if(this.Money>=DataBase.DRONE_P&&this.Pass==13){
			AIC.addDrone(path_num);
		}break;
		case RazerShip: if(this.Money>=DataBase.RAZERSHIP_P&&this.Pass==13){
			AIC.addRazerShip(path_num);
		}break;
		case RobotWarrior: if(this.Money>=DataBase.ROBOTWARRIOR_P&&this.Pass==13){
			AIC.addRobotWarrior(path_num);
		}break;
		case Sneaker: if(this.Money>=DataBase.SNEAKER_P&&this.Pass==13){
			AIC.addSneaker(path_num);
		}break;
		case LockScience: if(this.Money>=DataBase.TECH_LOCKSCIENCE_P&&this.Pass==12){
			AIC.LockScience();
		}break;
		case GeneMissile: if(this.Money>=DataBase.TECH_GENEMISSILE_P&&this.Pass==13){
			AIC.GeneMissile();
		}break;
		case KillerVirus: if(this.Money>=DataBase.TECH_KILLERVIRUS_P&&this.Pass==13){
			AIC.KillerVirus();
		}break;
		case PhotonStrike: if(this.Money>=DataBase.TECH_PHOTONSTRIKE_P&&this.Pass==13){
			AIC.PhotonStrike();
		}break;
		}
	}
	@Override
	public void run() {
		while(DataBase.threadContinue){
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

}
