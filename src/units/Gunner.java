package units;

import dataBase.DataBase;

public class Gunner extends Soldier implements Runnable {
	  // health point
		private int hp;
		// location
		private int x,y;
		//to transmit data
		DataBase db;
		
		public Gunner(DataBase data){
		
			this.x=0;
			this.y=0;
		
		}
		
	  

	@Override
	public void run() {
		move();

	}

	@Override
	public void move() {
		x+=db.GUNNER_SPD;
		y+=db.GUNNER_SPD;
		
	}
	
	//�ж����Լ�����ĵ����Ƿ��ڹ�����Χ��
	public boolean canAttack(){
		//ȡ�������Լ�������Ǹ�����
		Unit ce= db.enemyList.get(detect());
		int distance = caldistance(this.x,ce.getX(),this.y,ce.getY());
		if(distance>db.GUNNER_AR){
			return false;
		}else{
			return true;
		}
	}
	@Override
	public void attack() {
		if(canAttack()){
			Unit ce = db.enemyList.get(detect());
			ce.hp-=db.GUNNER_ATK;
			if(ce.hp<=0){
				db.enemyList.remove(ce);
			}
		}
		
	}

	
	

}
