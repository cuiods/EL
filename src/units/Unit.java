package units;

public abstract class Unit {
	public int DB;  //������������
	public int P;   
	public int HP;
	public int ATK;
	public int AR;
	public abstract void move();  //���ڱ仯x��y
	public abstract void attack();//���ڹ��������ٹ�����Χ�ڵз�������ֵ
	public abstract void detect();//���ڼ�⹥����Χ�ڵĵз�
}
