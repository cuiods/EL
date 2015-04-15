package units;



public class SwordMan extends Soldier implements Runnable{


	
	//initialization
	public SwordMan(){
    	this.x=0;
    	this.y=0;
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
    		x+=db.SWORDMAN_SPD;
    		y+=db.SWORDMAN_SPD;
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
		if(distance>db.SWORDMAN_AR){
			return false;
		}else{
			return true;
		}
	}
	
public void attack() {
	
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
				ce.hp-=db.SWORDMAN_ATK;
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
				ce.hp-=db.SWORDMAN_ATK;
			}else{
				db.playerList.remove(ce);
			}
		}
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
     
}
