package chap8;
interface MyInterface1 {
	default void method1() {
		System.out.println("MyInterface1의 default 메서드 : method1()");
	}
	static void staticMethod() {
		System.out.println("MyInterface1의 default 메서드 : staticMethod()");
	}
}
interface MyInterface2 {
	default void method1() {
		System.out.println("MyInterface2의 default 메서드 : method1()");
	}
	static void staticMethod() {
		System.out.println("MyInterface2의 default 메서드 : staticMethod()");
	}
}
class ImpClass implements MyInterface1,MyInterface2{ //다중구현.
	@Override
	public void method1() {
		System.out.println("ImpClass 클래스의 method1() 메서드");
		MyInterface1.super.method1();
		MyInterface2.super.method1();
	}
}
public class InterfaceEx5 {
	public static void main(String[] args) {
		ImpClass c = new ImpClass();
		c.method1();
		MyInterface1.staticMethod();
		MyInterface2.staticMethod();
	}
}
