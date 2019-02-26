package chap8;

//import chap8.packtest.Pack1; //Pack1 Ŭ������ ��Ű���� ����
import chap8.packtest.*;  //chap8.packtest ��Ű���� ��� Ŭ������ ��Ű������ ����

/* package
 * 1. package�� Ŭ�������� �����̴�. 
 * 2. Ŭ������ �̸��� ��Ű������ �����Ѵ�.
 *     String => java.lang.String
 * 3. package ������ ������ ó���� �ѹ��� �����ϴ�. => �ϳ��� ���Ͽ� �ִ� ��� Ŭ������ ���� ��Ű���� Ŭ������ �ȴ�.
 * 
 * import  : Ŭ���� ���� ��Ű������ ���� �� �� �ֵ��� ����.
 * 
 * - ��Ű������ �����ص� �Ǵ� ���
 *  1. ����ϴ� Ŭ������ ���Ǵ� Ŭ������ ���� ��Ű���� Ŭ������ ���
 *  2. java.lang ��Ű���� ���� Ŭ������ ���
 *  3. import ������ ������ Ŭ������ ���
 *  
 * ���� ������ : private < (default �����Ȱ��) < protected < public
 * 
 * ���    : private,(default),protected, public
 * Ŭ���� : (default), public 
 */
class Test extends Pack1{ 
	void testmethod() {
		//method();  //default �����������̹Ƿ� ���� �Ұ�
		method2(); //protected �����������̹Ƿ� ���� ���
	}
}
public class PackageEx1 {
	public static void main(String[] args) {
		System.out.println("��Ű�� ����");
		Pack1 p = new Pack1();
		p.method(); //PackageEx1 Ŭ�������� Pack1 Ŭ������ method() ���� �Ұ�. default ������������
		p.method2();//PackageEx1 Ŭ�������� Pack1 Ŭ������ method() ���� �Ұ�. protected ������������
		Test t = new Test();
		t.testmethod();
		Test2 t2 = new Test2();
		t2.testmethod(); //default ������������
	}
}