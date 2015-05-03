package dataBase;

import java.util.ArrayList;

import units.Unit;

public class DataBase {
	//��¼�ѵ��ؿ����͵�ǰ��Ϸ�ؿ���
	public static int pass = 1;
    public static int passAlready = 2;
    
    //��¼�Ƿ���ͣ
    public static boolean isPause = false;

    //��¼���е�λ��Ϣ
	public static ArrayList<Unit> enemyList = new ArrayList<Unit>();
	public static ArrayList<Unit> playerList = new ArrayList<Unit>();
	
	//Parameters for stage1
	public static final int INITIAL_MONEY_STG1 = 200000;
	public static final int INITIAL_MONEY_INCREMENT_STG1 = 2;
	public static final int CASTLE_HP_STG1 = 3;//�ҷ��Ǳ�������ֵ
	public static final int START_LOC_X_STG1 = 50;//���õ�һ�صĳ���λ��
	public static final int START_LOC_Y_STG1 = 500;
	public static final int PATH_AGLX_STG1 = 2;//���õ�һ��·����б��
	public static final int PATH_AGLY_STG1 = -1;
	
	public static final int CASTLE_HP_ENM_STG1 = 2000;//�з��Ǳ�������ֵ
	public static final int START_LOC_X_ENM_STG1 = 950;//���õ�һ�ص��˵ĳ���λ��
	public static final int START_LOC_Y_ENM_STG1 = 50;
	public static final int PATH_AGLX_ENM = -2;//���õ�һ�ص���·����б��
	public static final int PATH_AGLY_ENM = 1;
	
	//Parameters for stage2
	public static long StartTime = 0;
	public static final int INITIAL_MONEY_STG2 = 100000;
	public static final int INITIAL_MONEY_INCREMENT_STG2 = 5;
	public static final int CASTLE_HP_STG2 = 500;
	public static final int START_LOC_X_STG2 = 0;//���õڶ��صĳ���λ��
	public static final int START_LOC_Y_STG2 = 400;
	
	public static final int CASTLE_HP_ENM_STG2 = 1000;
	public static final int START_LOC_X_ENM_STG2 = 990;//���õڶ��ص��˵ĳ���λ��
	public static final int START_LOC_Y_ENM_STG2 = 180;
	public static final int TIMELIMIT_STG2 = 1000*60*10;
	//General parameters for the game
	public static int Money = 200000; //��¼��ҵ�ǰ�Ľ�Ǯ��
	public static int Money_Increment = 2;
	public static int Castle_HP_ply; //��¼��ҵ�ǰ�Ǳ�������ֵ��Ҫ���ݹصĲ�ͬ��ʼ����ͬ��ֵ
	public static int Castle_HP_enm;
	public static boolean Tech_CannonEnable = false;//�������ܳ��ֵĿƼ�������12345���
	public static boolean Tech_MoneyBoom = false;
	public static boolean Tech_Destroy = false;
	
	public static boolean Tech_MedicEnable = false;
	public static boolean Tech_TruckReinforce = false;
	public static boolean Tech_LessTime = false;
	public static boolean Tech_Heal = false;
	public static boolean Tech_CastleReinforce = false;
	//Parameters for Tech_1
	public static final int Tech_CannonEnable_P = 1000;//Ч��������cannon��
	//Parameters for Tech_2
	public static final int Tech_MoneyBoom_P = 2500;//Ч�����ý�Ǯ�����ٶȱ��1.5��
	//Parameters for Tech_3
	public static final int Tech_Destroy_P = 500;//Ч��������ݻٵ���80%�ĵ�λ
	//Parameters for Tech_4
	public static final int Tech_MedicEnable_p = 1000;
	//Parameters for Tech_5
	public static final int Tech_TruckReinforce_P = 1200;
	//Parameters for Tech_6
	public static final int Tech_LessTime_P = 2000;
	//Parameters for Tech_7
	public static final int Tech_Heal_P = 500;
	//Parameters for Tech_8
	public static final int Tech_CastleReinforce_P = 900;
		
	public static final int SWORDMAN_P = 100;//the price of swordman
	public static final int SWORDMAN_HP = 50;//The health point of swordman
	public static final int SWORDMAN_ATK = 1;//the attacking point of swordman
	public static final int SWORDMAN_AR = 60;//������Χ attacking range
	public static final int SWORDMAN_SPD = 4;//speed
	
	public static final int GUNNER_P = 300;
	public static final int GUNNER_HP = 21;
	public static final int GUNNER_ATK = 3;
	public static final int GUNNER_AR = 120;
	public static final int GUNNER_SPD = 3;
	
	public static final int CANNON_P = 1000;
	public static final int CANNON_HP = 50;
	public static final int CANNON_ATK = 5;
	public static final int CANNON_AR = 180;
	public static final int CANNON_SPD = 1;
	
	public static final int MEDICTEAM_P = 200;
	public static final int MEDICTEAM_HP = 10;
	public static final int MEDICTEAM_ATK = 0;
	public static final int MEDICTEAM_AR = 0;
	public static final int MEDICTEAM_SPD = 0;
	public static final int MEDICTEAM_HEAL = 10;
	
	public static final int SNIPER_P = 500;
	public static final int SNIPER_HP = 20;
	public static final int SNIPER_ATK = 20;
	public static final int SNIPER_AR = 500;
	public static final int SNIPER_SPD = 0;
	
	public static final int TRUCK_P = 400;
	public static final int TRUCK_HP = 100;
	public static final int TRUCK_ATK = 0;
	public static final int TRUCK_AR = 0;
	public static final int TRUCK_SPD = 4;
	
	public static final int RIFLE_P = 100;
	public static final int RIFLE_HP = 50;
	public static final int RIFLE_ATK = 1;
	public static final int RIFLE_AR = 60;
	public static final int RIFLE_SPD = 4;
	
	
	
	public static void recover(){
		enemyList.removeAll(enemyList);
		playerList.removeAll(playerList);
		switch(pass){
		case 1: Money = INITIAL_MONEY_STG1;
		Money_Increment = INITIAL_MONEY_INCREMENT_STG1;break;
		case 2:Money = INITIAL_MONEY_STG2;
		Money_Increment = INITIAL_MONEY_INCREMENT_STG2;break;
		case 3:break;
		case 4:break;
		}
		
		Tech_CannonEnable = false;
		Tech_MoneyBoom = false;
		Tech_Destroy = false;
		Tech_MedicEnable = false;
		Tech_TruckReinforce = false;
		Tech_LessTime = false;
		Tech_Heal = false;
		Tech_CastleReinforce = false;
	}
}
