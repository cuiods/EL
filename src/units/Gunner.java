package units;

import dataBase.DataBase;

public class Gunner extends Soldier implements Runnable {

		
		public Gunner(){
		
			this.x=db.START_LOC_X_STG1;
			this.y=db.START_LOC_Y_STG1;
		    hp=db.GUNNER_HP;
		    setType(1);
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

	    	try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		x+=db.GUNNER_SPD;
    		y+=db.PATH_AGL_STG1 *db.GUNNER_SPD;

	}
		
	
	
	//�ж����Լ�����ĵ����Ƿ��ڹ�����Χ��
	public boolean canAttack(){
		//ȡ�������Լ�������Ǹ�����
		Unit ce;
		if(detect()!=-1){
			if(this.getKind()==1){
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
		}else{
			return false;
		}
	}
	@Override
	public void attack() {

		//ȡ�����Թ���Ķ���
		Unit ce;
		if(this.getKind()==1){
			ce = db.enemyList.get(detect());
			if(ce.hp>0){
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ce.hp-=db.GUNNER_ATK;
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
				ce.hp-=db.GUNNER_ATK;
			}else{
				db.playerList.remove(ce);
			}
		}
		
		
	}





	
	

}
