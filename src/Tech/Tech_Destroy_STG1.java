package Tech;

import units.Unit;
import dataBase.DataBase;

public class Tech_Destroy_STG1 {
	DataBase db = new DataBase();
	public Tech_Destroy_STG1(){
		
		db.Tech_Destroy = true;
		execute();
		db.Tech_Destroy = false;//�������Ƽ�����һ���Եģ����Զ������ʹ��
	}
	public void execute(){
		for(Unit u :db.enemyList){
			if(u.getType()!=100){
			if(Math.random()>=0.2){
				u.setHp(0);;//����80%������������
			}
			}
		}
		for(int i = 0; i<db.enemyList.size(); i++){
			if(db.enemyList.get(i).getHp() <= 0){
				db.enemyList.remove(i);
			}
		}
	}
}
