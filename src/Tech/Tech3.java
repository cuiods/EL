package Tech;

import units.Unit;
import dataBase.DataBase;

public class Tech3 {
	DataBase db = new DataBase();
	public Tech3(){
		db.Tech_3 = true;
		execute();
		db.Tech_3 = false;//�������Ƽ�����һ���Եģ����Զ������ʹ��
	}
	public void execute(){
		for(Unit u :db.enemyList){
			if(Math.random()>=0.8){
				u.setHp(0);//����80%������������
			}
		}
	}
}
