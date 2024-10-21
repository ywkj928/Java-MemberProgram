package com.member.controller;

import com.member.domain.Member;
import com.member.controller.*;

public interface MemberManagement {
    boolean createMember(String name, int phone, String addr, String password); 
    Member readMember(String name);
    boolean updateMember(int num, String name, int phone, String addr, String password); 
    void listMembers();
	boolean deleteMember(int num);
	
}
