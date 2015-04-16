package units;

import dataBase.DataBase;

public abstract class Unit {
	protected DataBase db;  //������������
	protected int x = db.START_LOC_X_STG1;
	protected int y = db.START_LOC_Y_STG1;
	//ʿ�������ࣨ����0����ǹ��1������2��
	private int type;
	//���Ե�ʿ������Ϊ0 ��ҵ�Ϊ1
	private int kind;//ԭ����Ӣ�ﲻ���벻�����ʵĴ�0.0
		
	protected int hp;//health point
	
	public abstract void move();  //���ڱ仯x��y
	public abstract void attack();//���ڹ��������ٹ�����Χ�ڵз�������ֵ
	public abstract int detect();//���ؾ����Լ�����ĵ��˵����
	public abstract boolean canAttack();//���ڼ������Լ�����ĵ����Ƿ����Լ�������Χ��
	public int caldistance(int x1,int x2,int y1,int y2){
		
		return (x1-x2)*(x1-x2)+(y1-y2)*(y1-y2);
		
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getKind() {
		return kind;
	}
	public void setKind(int kind) {
		this.kind = kind;
	}
	
	
	
}
