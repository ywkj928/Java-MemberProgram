package com.member.controller;

import com.member.domain.Member;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MemberManager implements MemberManagement {
    private List<Member> members = new ArrayList<>();
    private int nextNum = 1; // 다음 회원 번호
    
    @Override
    public boolean createMember(String name, int phone, String addr, String password)  {
        for (Member member : members) {
            if (member.getName().equals(name)) {
                System.out.println("이미 존재하는 이름입니다. 다른 이름으로 등록해주세요.");
                return false;
            }
        }
        members.add(new Member(nextNum++, name, phone, addr, password));
        System.out.println("등록 완료되었습니다.");
        return true;
    }

    @Override
    public Member readMember(String name) {
        for (Member member : members) {
            if (member.getName().equals(name)) {
                return member;
            }
        }
        return null; // 회원을 찾지 못했음
    }

    @Override
    public boolean updateMember(int num, String name, int phone, String addr, String password) {
        for (Member member : members) {
            if (member.getName().equals(name)) {
                System.out.println("수정 완료되었습니다.");
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteMember(int num) {
        for (Member member : members) {
            if (member.getNum() == num) {
                members.remove(member);
                System.out.println("삭제되었습니다.");
                return true;
            }
        }
        return false ; 
    }

    @Override
    public void listMembers() {
        if (members.isEmpty()) {
            System.out.println("등록된 회원이 없습니다.");
            return;
        }
        for (Member member : members) {
            System.out.println("회원번호: " + member.getNum() + "      이름: " + member.getName() + "     연락처: " + member.getPhone());
        }
    }

    public void saveMembersToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Member member : members) {
                writer.write("회원번호: " + member.getNum() + "    이름: " + member.getName() + "     연락처: " + member.getPhone() + "     주소: " + member.getAddr() + "   비밀번호: "+ member.getPassword());
                writer.newLine();
            }
            System.out.println("회원 정보가 " + filename + "에 저장되었습니다.");
        } catch (IOException e) {
        	System.out.println("파일 저장 중 오류가 발생했습니다: " + e.getMessage());
        }
    }
    public void initMember() {
		File file = new File("memberLixt.txt");
		try {
			FileReader myreader = new FileReader(file);
			BufferedReader br = new BufferedReader(myreader);
			
			String str;
			
			while((str = br.readLine()) != null) {
				StringTokenizer strToken = new StringTokenizer(str);
				String rDum1 = strToken.nextToken();// 번호:
				String rNum = strToken.nextToken();
				String rDum2 = strToken.nextToken();// 이름:
				String rName = strToken.nextToken();
				String rDum3 = strToken.nextToken();// 연락처:
				String rPhone = strToken.nextToken();
				String rDum4 = strToken.nextToken();// 주소:
				String rAddr = strToken.nextToken();
				String rDum5 = strToken.nextToken();// 비밀번호:
				String rPass = strToken.nextToken();
			
				members.add(new Member(nextNum++,rName,Integer.valueOf(rPhone),rAddr,rPass));
			}
			myreader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}	

	public boolean updateMember(int num, String name, String newPhone, String newAddr, String newPassword) {
		   for (Member member : members) {
	            if (member.getName().equals(name)) {
	                System.out.println("수정 완료되었습니다.");
	                return true;
	            }
	        }
	        return false;
	    }
}
