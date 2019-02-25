package chap8;
/*
 * �������̽�
 * 1. �������̽��� ����� ���, �߻� �޼���, default�޼���, static �޼��带 ����� ���� �� �ִ�.
 *    ��� : public static final �� ������ �ٴ´�.
 *    �߻�޼��� : public abstract �� ������ �ٴ´�
 *    default�޼���, static �޼��� : jdk8.0 ���� ���������� ������. �����θ� ������ �ִ� �޼�����.
 *    
 *    interface �������̽��� {
 *       int MAX=100;  //���
 *       void method();  //�߻�޼���
 *    }
 * 2. �������̽����� ��ӵ� �����ϴ�. extends ���� �̿��Ͽ� ����� �����ϴ�.
 *    �������̽����� ����� ���� ����� �����ϴ�.  
 * 3. Ŭ������ �������̽��� �����̶�� �Ѵ�. implements ���� ����Ͽ� �������̽��� �����Ѵ�. 
 *    �������̽��� ������ Ŭ������ ����Ŭ������ �Ѵ�. 
 *    ���� ������ �����ϴ�.
 * 4. �������̽��� ��üȭ �Ұ� => ����Ŭ������ ��üȭ�� ���ؼ� ��üȭ�� �ȴ�.
 *    => ��üȭ�� �������̽��� �߻� �޼��带 ��� �������̵� �ؾ� �Ѵ�.   
 * 5. �������̽��� �����ڷ����̴�. 
 * 6. �������̽��� ���ؼ� Ŭ������ ���ϻ���� ������ ������ �� �ִ�.
 */
interface Movable {
	int MAX=100;
	public abstract void move(int x, int y) ;
}
interface Attackable {
	void attack(Unit u);
}
interface Fightable extends Movable,Attackable { }  //���߻��
class Unit {
	int currentHp,x,y;
}
class Fighter extends Unit implements Fightable {
	@Override
	public void move(int x, int y) {
		System.out.println(x + "," + y + "��ǥ�� �̵�");
	}
	@Override
	public void attack(Unit u) {
		System.out.println(u + "�ο���");
	}
}
public class InterfaceEx1 {
	public static void main(String[] args) {
		Fighter f = new Fighter();
		System.out.println(f.MAX);
		f.move(10, 20);
		f.attack(f);
		System.out.println(f.currentHp); 
		Fightable fa = f;
		System.out.println(fa.MAX);
		fa.attack(f);
		fa.move(20, 30);
//		System.out.println(fa.currentHp); //error
		if(f instanceof Fighter)
			System.out.println("f�� �����ϴ� ��ü�� Fighter ��ü��");
		if(f instanceof Unit) {
			System.out.println("f�� �����ϴ� ��ü�� Unit ��ü��");
			Unit u = (Unit)f;
			System.out.println("u ���������� ���� ������ ����� Object����� �����ϸ� 3����");
			System.out.println(u.currentHp + "," + u.x + "," + u.y);
		}
		if(f instanceof Fightable) {
			System.out.println("f�� �����ϴ� ��ü�� Fightable ��ü��");
			Fightable fa2 = (Fightable)f;
			System.out.println("fa2 ���������� ���� ������ ����� Object����� �����ϸ� 3����");
			System.out.println(fa2.MAX);
			fa2.attack(f);
			fa2.move(30, 40);
		}
		if(f instanceof Movable) {
			System.out.println("f�� �����ϴ� ��ü�� Movable ��ü��");
			Movable m = (Movable)f;
			System.out.println("m ���������� ���� ������ ����� Object����� �����ϸ� 2����");
			System.out.println(m.MAX);
			m.move(40, 50);
		}
		if(f instanceof Attackable) {
			System.out.println("f�� �����ϴ� ��ü�� Attackable ��ü��");
			Attackable a = (Attackable)f;
			System.out.println("a ���������� ���� ������ ����� Object����� �����ϸ� 1����");
			a.attack(f);
		}
		if(f instanceof Object) {
			System.out.println("f�� �����ϴ� ��ü�� Object ��ü��");
			Object o = (Object)f;
			System.out.println("o ���������� ���� ������ ����� Object����� �����ϸ� 0����");
		}
	}
	
}