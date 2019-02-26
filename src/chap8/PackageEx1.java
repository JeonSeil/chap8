package chap8;

//import chap8.packtest.Pack1; //Pack1 클래스의 패키지명 설정
import chap8.packtest.*;  //chap8.packtest 패키지의 모든 클래스의 패키지명을 생략

/* package
 * 1. package란 클래스들의 모임이다. 
 * 2. 클래스의 이름은 패키지명을 포함한다.
 *     String => java.lang.String
 * 3. package 설정은 파일의 처음에 한번만 가능하다. => 하나의 파일에 있는 모든 클래스는 같은 패키지의 클래스가 된다.
 * 
 * import  : 클래스 사용시 패키지명을 생략 할 수 있도록 지원.
 * 
 * - 패키지명을 생략해도 되는 경우
 *  1. 사용하는 클래스와 사용되는 클래스가 같은 패키지의 클래스인 경우
 *  2. java.lang 패키지에 속한 클래스인 경우
 *  3. import 구문에 설정된 클래스인 경우
 *  
 * 접근 제어자 : private < (default 생략된경우) < protected < public
 * 
 * 멤버    : private,(default),protected, public
 * 클래스 : (default), public 
 */
class Test extends Pack1{ 
	void testmethod() {
		//method();  //default 접근제어자이므로 접근 불가
		method2(); //protected 접근제어자이므로 접근 허용
	}
}
public class PackageEx1 {
	public static void main(String[] args) {
		System.out.println("패키지 예제");
		Pack1 p = new Pack1();
		p.method(); //PackageEx1 클래스에서 Pack1 클래스의 method() 접근 불가. default 접근제어자임
		p.method2();//PackageEx1 클래스에서 Pack1 클래스의 method() 접근 불가. protected 접근제어자임
		Test t = new Test();
		t.testmethod();
		Test2 t2 = new Test2();
		t2.testmethod(); //default 접근제어자임
	}
}