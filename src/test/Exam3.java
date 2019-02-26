package test;

/*
 * Animal2 Ŭ������ ������ ����. ���� Ŭ������ ���������� ������ ����� 
 * �������� ���α׷� �����ϱ�  
 * Flyable �������̽�, Dove,Monkey,Eagle Ŭ���� �����ϱ�
 * [���]
 * ��ѱ�� ���� ������ ��� �Դ´�.
 * ��ѱ�� ���� �ٴϴ� ���Դϴ�.
 * �����̴� �������� ���Ÿ� ���� �Դ´�
 * �������� ���� ���� ��� �Դ´�.
 * �������� ��û ���� ���� �ٴѴ�.
 */
abstract class Animal2 {
	String name;
	Animal2(String name) {
		this.name = name;
	}
	abstract void eat();
}
class Dove extends Animal2 implements Flyable{
	Dove() {
		super("��ѱ�");
	}
	@Override
	void eat() {
		System.out.println(name + "�� ���� ������ ��� �Դ´�.");
	}
	@Override
	public void fly() {
		System.out.println(name + "�� ���� �ٴϴ� ���Դϴ�.");
	}
}
class Monkey extends Animal2 {
	Monkey() {
		super("������");
	}
	@Override
	void eat() {
		System.out.println(name + "�� �������� ���Ÿ� ���� �Դ´�");
	}
}
class Eagle extends Animal2  implements Flyable{
	Eagle() {
		super("������");
	}
	@Override
	void eat() {
		System.out.println(name + "�� ���� ���� ��� �Դ´�.");
	}
	@Override
	public void fly() {
		System.out.println(name + "�� ��û ���� ���� �ٴѴ�.");
	}
}
interface Flyable {
	void fly();
}
public class Exam3 {
	public static void main(String[] args) {
		Animal2[] arr = new Animal2[3];
		arr[0] = new Dove();
		arr[1] = new Monkey();
		arr[2] = new Eagle();
		for (Animal2 a : arr) {
			a.eat();
			if (a instanceof Flyable) {
				((Flyable) a).fly();
			}
		}
	}
}