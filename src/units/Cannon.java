package units;

import dataBase.DataBase;

public class Cannon extends Soldier implements Runnable {
	 
		

		public Cannon(){
			
			this.x=db.START_LOC_X_STG1;
			this.y=db.START_LOC_Y_STG1;
			hp=db.CANNON_HP;
			setType(2);
		}
		
	
	@Override
	public void run() {
		while(true){
			if(canAttack()){
				attack();
			}else{
				move();
			}
		}
	}

	@Override
	public void move() {
		while(true){
			
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    x+=db.CANNON_SPD;
			    y+=db.PATH_AGL_STG1*db.CANNON_SPD;
			
		}
	}
	
	//判断与自己最近的敌人是否在攻击范围内
	public boolean canAttack(){
		//取出距离自己最近的那个敌人
		Unit ce;
		if(this.kind==1){
			 ce= db.enemyList.get(detect());
		}else{
			 ce=db.playerList.get(detect());
		}
		
		int distance = caldistance(this.x,ce.getX(),this.y,ce.getY());
		if(distance>db.GUNNER_AR){
			return false;
		}else{
			return true;
		}
	}
	@Override
	public void attack() {

		//取出可以攻打的对象
		Unit ce;
		if(this.kind==1){
			ce = db.enemyList.get(detect());
			if(ce.hp>0){
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ce.hp-=db.CANNON_ATK;
			}else{
				db.enemyList.remove(ce);
			}
		}else{
			ce=db.playerList.get(detect());
			if(ce.hp>0){
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ce.hp-=db.CANNON_ATK;
			}else{
				db.playerList.remove(ce);
			}
		}
		
	}



}
