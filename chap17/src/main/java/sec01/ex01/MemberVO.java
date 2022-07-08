package sec01.ex01;

public class MemberVO {

	public MemberVO() {
		System.out.println("Member 생성자 호출");
	}
	public MemberVO(String id, String pwd, String name, String email) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
	}
	public MemberVO(String id, String pwd, String name, String email, Date joinDate) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.joinDate = joinDate;
	}
}
