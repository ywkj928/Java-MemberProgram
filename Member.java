package com.member.domain;

public class Member {
    private int num;
    private String name;
    private int phone;
    private String addr;
    private String password;
   
    
    public Member(int num, String name, int phone, String addr, String password) {
        this.num = num;
        this.name = name;
        this.phone = phone;
        this.addr = addr;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNum(int num) {
		this.num = num;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public int getNum() {
        return num;
    }

    public String getName() {
        return name;
    }

    public int getPhone() {
        return phone;
    }

    public String getAddr() {
        return addr;
    }
}
