package chap8;
/*
 * 인터페이스
 * 1. 인터페이스의 멤버는 상수, 추상 메서드, default메서드, static 메서드를 멤버로 가질 수 있다.
 *    상수 : public static final 이 무조건 붙는다.
 *    추상메서드 : public abstract 이 무조건 붙는다
 *    default메서드, static 메서드 : jdk8.0 이후 버전에서만 가능함. 구현부를 가지고 있는 메서드임.
 *    
 *    interface 인터페이스명 {
 *       int MAX=100;  //상수
 *       void method();  //추상메서드
 *    }
 * 2. 인터페이스간에 상속도 가능하다. extends 예약어를 이용하여 상속이 가능하다.
 *    인터페이스간에 상속은 다중 상속이 가능하다.  
 * 3. 클래스와 인터페이스는 구현이라고 한다. implements 예약어를 사용하여 인터페이스를 구현한다. 
 *    인터페이스를 구현한 클래스를 구현클래스라 한다. 
 *    다중 구현이 가능하다.
 * 4. 인터페이스는 객체화 불가 => 구현클래스의 객체화를 통해서 객체화가 된다.
 *    => 객체화시 인터페이스의 추상 메서드를 모두 오버라이딩 해야 한다.   
 * 5. 인터페이스는 참조자료형이다. 
 * 6. 인터페이스를 통해서 클래스의 단일상속의 제약을 보완할 수 있다.
 */
interface Movable {
	int MAX=100;
	public abstract void move(int x, int y) ;
}
interface Attackable {
	void attack(Unit u);
}
interface Fightable extends Movable,Attackable { }  //다중상속
class Unit {
	int currentHp,x,y;
}
class Fighter extends Unit implements Fightable {
	@Override
	public void move(int x, int y) {
		System.out.println(x + "," + y + "좌표로 이동");
	}
	@Override
	public void attack(Unit u) {
		System.out.println(u + "싸우자");
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
			System.out.println("f가 참조하는 객체는 Fighter 객체다");
		if(f instanceof Unit) {
			System.out.println("f가 참조하는 객체는 Unit 객체다");
			Unit u = (Unit)f;
			System.out.println("u 참조변수로 참조 가능한 멤버는 Object멤버를 제외하면 3개다");
			System.out.println(u.currentHp + "," + u.x + "," + u.y);
		}
		if(f instanceof Fightable) {
			System.out.println("f가 참조하는 객체는 Fightable 객체다");
			Fightable fa2 = (Fightable)f;
			System.out.println("fa2 참조변수로 참조 가능한 멤버는 Object멤버를 제외하면 3개다");
			System.out.println(fa2.MAX);
			fa2.attack(f);
			fa2.move(30, 40);
		}
		if(f instanceof Movable) {
			System.out.println("f가 참조하는 객체는 Movable 객체다");
			Movable m = (Movable)f;
			System.out.println("m 참조변수로 참조 가능한 멤버는 Object멤버를 제외하면 2개다");
			System.out.println(m.MAX);
			m.move(40, 50);
		}
		if(f instanceof Attackable) {
			System.out.println("f가 참조하는 객체는 Attackable 객체다");
			Attackable a = (Attackable)f;
			System.out.println("a 참조변수로 참조 가능한 멤버는 Object멤버를 제외하면 1개다");
			a.attack(f);
		}
		if(f instanceof Object) {
			System.out.println("f가 참조하는 객체는 Object 객체다");
			Object o = (Object)f;
			System.out.println("o 참조변수로 참조 가능한 멤버는 Object멤버를 제외하면 0개다");
		}
	}
	
}
