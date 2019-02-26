package chap8;
/*
 * 매개변수의 자료형으로 인터페이스 자료형을 사용하기 : 주로 허용의 기능을 가진다.
 */
interface Repairable{}
class Unit2 {
	int hp;
	final int MAX_HP;
	Unit2(int hp) {
		this.hp = hp;
		MAX_HP = hp;
	}
}
class AirUnit extends Unit2 {
	AirUnit(int hp) {
		super(hp);
	}
}
class GroundUnit extends Unit2 {
	GroundUnit(int hp) {
		super(hp);
	}
}
class Tank extends GroundUnit implements Repairable {
	Tank() {
		super(150);
	}
	public String toString() {
		return "Tank";
	}
}
class DropShip extends AirUnit implements Repairable {
	DropShip() {
		super(125);
	}
	public String toString() {
		return "DropShip";
	}
}
class Marine extends GroundUnit {
	Marine() {
		super(40);
	}
	public String toString() {
		return "Marine";
	}
}
class SCV extends GroundUnit implements Repairable {
	SCV() {
		super(60);
	}
	void repair (Repairable r) {
		if (r instanceof Unit2) {
			Unit2 u = (Unit2)r;
			u.hp = u.MAX_HP;
			System.out.println(r + "수리 완료");
		}
		//r.hp = r.MAX_HP; Repairable 타입은 멤버가 없다.
	}
	public String toString() {
		return "SCV";
	}
}
public class InterfaceEx3 {
	public static void main(String[] args) {
		Tank t = new Tank();
		DropShip d = new DropShip();
		Marine m = new Marine();
		SCV s = new SCV();
		s.repair(t); s.repair(d);
		//s.repair(m);// Marine 객체는 Repairable 인터페이스를 구현하지 않음. 
		            // Marine 객체 Repairable 객체로 형변환이 안됨.
	}
}
