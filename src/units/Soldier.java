package units;

public abstract class Soldier extends Unit{
	/*
	 �����ڼ̳�soldier�������½����캯��
	 �ҹ��캯����������������ݣ�
	1. ���캯������Ҫ��һ������ΪDataBase data��Ȼ�������ֵ����Ĳ���DB����������
	2.��ʵ����������Database�����Ӧֵ��ʼ��
	3. ������������Ժ���밴����Ӫ��ӵ���Ӧ��arraylist�з���
	
	 */
	
	
	/*
	 ��λ��ΪSwordMan(����)��GUNNER(��ǹ��)��CANNON(����)����;ÿ����Ӧ�Ĳ���ֵ���Ѿ���database����д�á�
	 */
	

	//�ҵ�����swordman��С�ĵ��˵�index
		public int detect() {

			//to record the temporary minimum distance and its index
			int temp=0;			
			if(this.getKind()==1){
				if(db.enemyList.size()!=0){
					//��ʼֵΪ�����б��е�һ�����˵ľ���
					int minidistance= caldistance(this.x,db.enemyList.get(0).getX(),
							this.y,db.enemyList.get(0).getY());
					for(int i=0;i<db.enemyList.size();i++){
						Unit enemy=db.enemyList.get(i);
						int distance= caldistance(this.x,enemy.getX(),this.y,enemy.getY());
						//�ж��Ƿ��ǵ�ǰ��С����
						if(distance<minidistance){
								minidistance=distance;
								temp=i;
						}
					}
					return temp;
				}else{
					return -1;
				}
			}else{
					if(db.playerList.size()!=0){
						int minidistance= caldistance(this.x,db.playerList.get(0).getX(),this.y,db.playerList.get(0).getY());
						for(int i=0;i<db.playerList.size();i++){
							Unit player=db.playerList.get(i);
							int distance= caldistance(this.x,player.getX(),this.y,player.getY());
							//�ж��Ƿ��ǵ�ǰ��С����
							if(distance<minidistance){
								minidistance=distance;
								temp=i;
							}
						}
						return temp;
					}else{
						return -1;
					}
				}
		}
		public void run() {
			while(true){
				if(this.hp<=0){
					if(this.getKind()==0){
						db.enemyList.remove(db.enemyList.indexOf(this));
					}
					else{
						db.playerList.remove(db.playerList.indexOf(this));
					}
				}
				if(canAttack()){
					attack();
					
				}else{
					move();
				}
			}
		}

		@Override
		public void move() {
			int spd=0;
			switch(this.getType()){
			case 0:spd = db.SWORDMAN_SPD;break;
			case 1:spd = db.GUNNER_SPD;break;
			case 2:spd = db.CANNON_SPD;break;
			}

		    	try {
					Thread.sleep(150);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	if(this.getKind()==1){
		    		x+=db.PATH_AGLX_STG1*spd;
		    		y+=db.PATH_AGLY_STG1*spd;
		    		}
		    		else{
		    			x+=db.PATH_AGLX_ENM*spd;
		        		y+=db.PATH_AGLY_ENM*spd;
		    		}
		}
			
		
		
		//�ж����Լ�����ĵ����Ƿ��ڹ�����Χ��
		public boolean canAttack(){
			int ar=0;
			switch(this.getType()){
			case 0:ar = db.SWORDMAN_AR;break;
			case 1:ar = db.GUNNER_AR;break;
			case 2:ar = db.CANNON_AR;break;
			}
			//ȡ�������Լ�������Ǹ�����
			Unit ce;
			if(detect()!=-1){
				if(this.getKind()==1){
					 ce= db.enemyList.get(detect());
				}else{
					 ce=db.playerList.get(detect());
				}
				int distance = caldistance(this.x,ce.getX(),this.y,ce.getY());
				if(distance>ar){
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
		@Override
		public void attack() {
			int atk=0;
			switch(this.getType()){
			case 0:atk = db.SWORDMAN_ATK;break;
			case 1:atk = db.GUNNER_ATK;break;
			case 2:atk = db.CANNON_ATK;break;
			}
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
					ce.hp-=atk;
				}//else{
				//	db.enemyList.remove(ce);
			//	}
			}else{
				ce=db.playerList.get(detect());
				if(ce.hp>0&&this.hp>0){
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					ce.hp-=atk;
			//	}else{
			//		db.playerList.remove(ce);
				}
			}
			
			
		}
		
	
}
