package units;

import dataBase.DataBase;

public abstract class Unit {
	//ʿ�������ࣨ����0����ǹ��1������2��
	private  int type;
	protected int x;
	protected int y;
	protected DataBase db;  //������������
	

	
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
	
	
	
}
