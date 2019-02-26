package chap8;
/*
 * jdk 8.0 이후 추가  : 인터페이스의 멤버로 구현부를 가진 메서드를 가진다. 
 *   default 메서드 : 인스턴스 메서드
 *   static 메서드  : 클래스 메서드
 */
class Parent {
	
}
interface MyInterface {
	default void method1() { //default 메서드
		System.out.println("MyInterface 인터페이스의 method1() 메서드");
	}
	static void staticMethod() { //static 메서드. 
		System.out.println("MyInterface 인터페이스의 staticMethod() 메서드");
	}
}
class Child extends Parent implements MyInterface {
	@Override
	public void method1() { //default 메서드의 오버 라이딩
		System.out.println("Child 클래스의 method1() 메서드");
	}
}
public class InterfaceEx4 {
	public static void main(String[] args) {
		Child c = new Child();
		c.method1();
	//	MyInterface.method1();  //인스턴스 메서드. 객체화필요
		MyInterface.staticMethod(); //클래스 메서드
		Parent p = c; //Parent 클래스는 MyInterface 인터페이스의 구현 클래스가 아님.
		//p.method1();
	}
}
