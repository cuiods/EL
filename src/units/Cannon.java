package units;

import dataBase.DataBase;

public class Cannon extends Soldier implements Runnable {
	 
		

		public Cannon(){
			x = DataBase.START_LOC_X_STG1;
			y = DataBase.START_LOC_Y_STG1;
			hp=DataBase.CANNON_HP;
			setType(2);
		}
}
