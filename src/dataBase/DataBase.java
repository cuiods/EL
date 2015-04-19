package dataBase;

import java.util.ArrayList;

import units.Unit;

public class DataBase {
	public static ArrayList<Unit> enemyList = new ArrayList<Unit>();
	public static ArrayList<Unit> playerList = new ArrayList<Unit>();
	//Parameters for stage1
	public static final int CASTLE_HP_STG1 = 3000;//�ҷ��Ǳ�������ֵ
	public static final int START_LOC_X_STG1 = 50;//���õ�һ�صĳ���λ��
	public static final int START_LOC_Y_STG1 = 500;
	public static final int PATH_AGLX_STG1 = 2;//���õ�һ��·����б��
	public static final int PATH_AGLY_STG1 = -1;
	
	public static final int CASTLE_HP_ENM = 2000;//�з��Ǳ�������ֵ
	public static final int START_LOC_X_ENM = 950;//���õ�һ�ص��˵ĳ���λ��
	public static final int START_LOC_Y_ENM = 50;
	public static final int PATH_AGLX_ENM = -2;//���õ�һ�ص���·����б��
	public static final int PATH_AGLY_ENM = 1;
	//General parameters for the game
	public static int Money = 2000; //��¼��ҵ�ǰ�Ľ�Ǯ��
	public static int Money_Increment = 2;
	public static int Castle_HP; //��¼��ҵ�ǰ�Ǳ�������ֵ��Ҫ���ݹصĲ�ͬ��ʼ����ͬ��ֵ
	public static boolean Tech_1 = false;//�������ܳ��ֵĿƼ�������12345���
	public static boolean Tech_2 = false;
	public static boolean Tech_3 = false;
	public static boolean Tech_4 = false;
	public static boolean Tech_5 = false;
	//Parameters for Tech_1
	public static final int Tech_1_P = 1000;//Ч��������cannon��
	//Parameters for Tech_2
	public static final int Tech_2_P = 2500;//Ч�����ý�Ǯ�����ٶȱ��1.5��
	//Parameters for Tech_3
	public static final int Tech_3_p = 500;//Ч��������ݻٵ���80%�ĵ�λ
		
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
}
