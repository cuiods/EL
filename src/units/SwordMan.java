package units;



public class SwordMan extends Soldier implements Runnable{


	
	//initialization
	public SwordMan(){
		x = db.START_LOC_X_STG1;
		y = db.START_LOC_Y_STG1;
    	hp=db.SWORDMAN_HP;
    	setType(0);
    }
	
	
	
	
    
    @Override
	public void move()  {

    		try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		if(this.getKind()==1){
    		x+=db.PATH_AGLX_STG1*db.SWORDMAN_SPD;
    		y+=db.PATH_AGLY_STG1*db.SWORDMAN_SPD;
    		}
    		else{
    			x+=db.PATH_AGLX_ENM*db.SWORDMAN_SPD;
        		y+=db.PATH_AGLY_ENM*db.SWORDMAN_SPD;
    		}
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
			if(distance>db.SWORDMAN_AR){
				return false;
			}else{
				if(this.hp>0)
				return true;
				else return false;
			}
		}else{
		return false;
		}
	}
	
	public void attack() {
		//ȡ�����Թ���Ķ���
		Unit ce;
		if(this.getKind()==1){
			ce = db.enemyList.get(detect());
			if(ce.hp>0&&this.hp>0){
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ce.hp-=db.SWORDMAN_ATK;
			}else{
				db.enemyList.remove(ce);
			}
		}else{
			ce=db.playerList.get(detect());
			if(ce.hp>0&&this.hp>0){
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ce.hp-=db.SWORDMAN_ATK;
			}else{
				db.playerList.remove(ce);
			}
		}
	}

	@Override
	public void run() {
			while(true){
//				if(this.hp<=0){
//					if(this.getKind()==0){
//						db.enemyList.remove(db.enemyList.indexOf(this));
//					}
//					else{
//						db.playerList.remove(db.playerList.indexOf(this));
//					}
//				}
				if(canAttack()){
					attack();
				}else{
					move();
				}
			}
			
	}
     
}
