package chap8;
/*
 * 인터페이스의 객체 생성하기
 */
interface Action {
	void action();
}
public class InterfaceEx6 {
	public static void main(String[] args) {
		Action a = new Action() {
			@Override
			public void action() {
				System.out.println("Action 인터페이스의 객체 내부의 action() 메서드");
			}
		};
		a.action();
		a = new Action() {
			@Override
			public void action() {
				System.out.println("Action 객체로 다른 기능 구현하기");
			}
		};
		a.action();
	}
}
