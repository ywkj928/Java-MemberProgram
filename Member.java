package com.member.domain;

public class Member {
    private int num; // 회원 번호
    private String name; // 회원 이름
    private int phone; // 회원 전화번호
    private String addr; // 회원 주소
    private String password; // 회원 비밀번호

    // 생성자: 회원 정보를 초기화
    public Member(int num, String name, int phone, String addr, String password) {
        this.num = num; // 회원 번호 설정
        this.name = name; // 회원 이름 설정
        this.phone = phone; // 회원 전화번호 설정
        this.addr = addr; // 회원 주소 설정
        this.password = password; // 회원 비밀번호 설정
    }

    // 비밀번호 반환
    public String getPassword() {
        return password; // 회원 비밀번호 반환
    }

    // 비밀번호 설정
    public void setPassword(String password) {
        this.password = password; // 회원 비밀번호 설정
    }

    // 회원 번호 설정
    public void setNum(int num) {
		this.num = num; // 회원 번호 설정
	}

    // 회원 이름 설정
	public void setName(String name) {
		this.name = name; // 회원 이름 설정
	}

    // 회원 전화번호 설정
	public void setPhone(int phone) {
		this.phone = phone; // 회원 전화번호 설정
	}

    // 회원 주소 설정
	public void setAddr(String addr) {
		this.addr = addr; // 회원 주소 설정
	}

    // 회원 번호 반환
	public int getNum() {
        return num; // 회원 번호 반환
    }

    // 회원 이름 반환
    public String getName() {
        return name; // 회원 이름 반환
    }

    // 회원 전화번호 반환
    public int getPhone() {
        return phone; // 회원 전화번호 반환
    }

    // 회원 주소 반환
    public String getAddr() {
        return addr; // 회원 주소 반환
    }
}
