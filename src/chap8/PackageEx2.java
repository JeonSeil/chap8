package chap8;
/*
 * 1. 객체 생성을 못하도록 생성자의 접근 제어자를 private으로 설정할 수 있다
 *     Math 클래스의 생성자가 private임 => 모든 멤버가 static임. 객체 생성 불필요
 * 2. 객체의 갯수를 제한 할 수 있다.    
 */
class Single {
	private static Single s = new Single();
	private Single() {}
	private int value;
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public static Single getInstance() {
		return s;
	}
}
public class PackageEx2 {
	public static void main(String[] args) {
//		Math m = new Math(); //객체 생성 불가.
		Single s1 = new Single(); //객체 생성 불가
		Single s1 = Single.getInstance();
		Single s2 = Single.getInstance();
		Single s3 = Single.getInstance();
		System.out.println(s1.getValue() + "," + s2.getValue() + "," + s3.getValue());
		s1.setValue(100);
		System.out.println(s1.getValue() + "," + s2.getValue() + "," + s3.getValue());
	}
}
