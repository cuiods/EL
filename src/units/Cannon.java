package units;

import dataBase.DataBase;

public class Cannon extends Soldier implements Runnable {
	 
		
<<<<<<< HEAD
		public Cannon(){
=======
		public Cannon(DataBase data){
>>>>>>> origin/master
			
			this.x=0;
			this.y=0;
			hp=db.CANNON_HP;
			setType(2);
		}
		
	
	@Override
	public void run() {
<<<<<<< HEAD
		while(true){
			if(canAttack()){
				attack();
			}else{
				move();
			}
=======
		if(this.hp>0){
			move();
>>>>>>> origin/master
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
			    y+=db.CANNON_SPD;
			
		}
	}
	
	//�ж����Լ�����ĵ����Ƿ��ڹ�����Χ��
	public boolean canAttack(){
		//ȡ�������Լ�������Ǹ�����
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
<<<<<<< HEAD

		//ȡ�����Թ���Ķ���
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
=======
		if(canAttack()){
			//ȡ�����Թ���Ķ���
			Unit ce;
			if(this.kind==1){
				ce = db.enemyList.get(detect());
			}else{
				ce=db.playerList.get(detect());
			}
			ce.hp-=db.GUNNER_ATK;
			if(ce.hp<=0){
>>>>>>> origin/master
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
