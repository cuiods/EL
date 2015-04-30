package units;

import dataBase.DataBase;

public abstract class Soldier extends Unit{
	public boolean attacking = false;
	public boolean moving = false;
	public int ran = (int) (Math.random()*50);
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
				if(DataBase.enemyList.size()!=0){
					//��ʼֵΪ�����б��е�һ�����˵ľ���
					int minidistance= caldistance(this.x,DataBase.enemyList.get(0).getX(),
							this.y,DataBase.enemyList.get(0).getY());
					
						for(int i=0;i<DataBase.enemyList.size();i++){
							synchronized (this) {
								Unit enemy=DataBase.enemyList.get(i);
								int distance= caldistance(this.x,enemy.getX(),this.y,enemy.getY());
								//�ж��Ƿ��ǵ�ǰ��С����
								if(distance<minidistance){
									minidistance=distance;
									temp=i;
								}
							}
						}
		
					return temp;
				}else{
					return -1;
				}
			}else{
					if(DataBase.playerList.size()!=0){
						int minidistance= caldistance(this.x,DataBase.playerList.get(0).getX(),this.y,DataBase.playerList.get(0).getY());
						for(int i=0;i<DataBase.playerList.size();i++){
							Unit player=DataBase.playerList.get(i);
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
					//	this.die();
					}
					if(canAttack()){
						synchronized(this){
						this.moving = false;
						this.attacking = true;
						}
						attack();
						
					}else{
						synchronized(this){
						this.attacking = false;
						this.moving = true;
						}
						move();
					}
			}
		}

		@Override
		public void move() {
			int spd=0;
			if(!DataBase.isPause){
				switch(this.getType()){
				case 0:spd = DataBase.SWORDMAN_SPD;break;
				case 1:spd = DataBase.GUNNER_SPD;break;
				case 2:spd = DataBase.CANNON_SPD;break;
				case 3:spd = DataBase.MEDICTEAM_SPD;break;
				case 4:spd = DataBase.SNIPER_SPD;break;
				}
			}

		    	try {
					Thread.sleep(150);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	switch(DataBase.pass){
	    		case 1:
	    			if(this.getKind()==1){
			    		x+=DataBase.PATH_AGLX_STG1*spd;
			    		y+=DataBase.PATH_AGLY_STG1*spd;
			    		}
			    		else{
			    			x+=DataBase.PATH_AGLX_ENM*spd;
			        		y+=DataBase.PATH_AGLY_ENM*spd;
			    		}
	    			break;
	    		case 2:
	    			if(this.getKind()==1){
			    		x+=spd;
			    		y=(int) (0.0000007*x*x*x-0.001*x*x+0.1566*x+399.32);
			    	}else{
			    		x-=spd;
			        	y=(int) (0.0000007*x*x*x-0.001*x*x+0.1566*x+399.32);
			    	}
		    		break;
	    		}
		}
					
		//�ж����Լ�����ĵ����Ƿ��ڹ�����Χ��
		public boolean canAttack(){
			int ar=0;
			switch(this.getType()){
			case 0:ar = DataBase.SWORDMAN_AR;break;
			case 1:ar = DataBase.GUNNER_AR;break;
			case 2:ar = DataBase.CANNON_AR;break;
			case 3:ar = DataBase.MEDICTEAM_AR;break;
			case 4:ar = DataBase.SNIPER_AR;break;
			}
			//ȡ�������Լ�������Ǹ�����
			Unit ce;
			if(detect()!=-1){
				if(this.getKind()==1){
					 ce= DataBase.enemyList.get(detect());
				}else{
					 ce=DataBase.playerList.get(detect());
				}
				int distance = caldistance(this.x,ce.getX(),this.y,ce.getY());
				if(distance>ar){
					return false;
				}else{
					if(DataBase.playerList.contains(this)||DataBase.enemyList.contains(this)){
						return true;}
						else return false;
				}
			}else{
				return false;
			}
		}
		@Override
		public void attack() {
			int atk=0;
			if(!DataBase.isPause){
				switch(this.getType()){
				case 0:atk = DataBase.SWORDMAN_ATK;break;
				case 1:atk = DataBase.GUNNER_ATK;break;
				case 2:atk = DataBase.CANNON_ATK;break;
				case 4:atk = DataBase.SNIPER_ATK;break;
				}
			}
			//ȡ�����Թ���Ķ���
			Unit ce;
			if(this.getKind()==1){
				ce = DataBase.enemyList.get(detect());
				if(ce.hp>0&&this.hp>0){
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					ce.hp-=atk;
				}else{
					if(ce.hp<=0)
					DataBase.enemyList.remove(ce);
					if(this.hp<=0)
						DataBase.playerList.remove(this);
				}
			}else{
				ce=DataBase.playerList.get(detect());
				if(ce.hp>0&&this.hp>0){
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					ce.hp-=atk;
				}else{
					if(ce.hp<=0)
					DataBase.playerList.remove(ce);
					if(this.hp<=0)
						DataBase.enemyList.remove(this);
				}
			}
			
			
		}
		public void die(){			
				if(this.getKind()==0){
					try{
					DataBase.enemyList.remove(DataBase.enemyList.indexOf(this));
					}catch(java.lang.ArrayIndexOutOfBoundsException ex){
						
					}
				}
				else{
					try{
					DataBase.playerList.remove(DataBase.playerList.indexOf(this));
                    }catch(java.lang.ArrayIndexOutOfBoundsException ex){
						
					}
				}
		}
		
	
}
