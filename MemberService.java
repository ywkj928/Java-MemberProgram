package com.member.service;

import com.member.controller.MemberManager;
import com.member.domain.Member;
import java.io.IOException;
import java.util.Scanner;

public class MemberService {
    private final MemberManager memberManager;
    private final Scanner scanner;

    public MemberService(MemberManager memberManager) {
        this.memberManager = memberManager;
        this.scanner = new Scanner(System.in);
    }

    public void registerMember() {
        boolean registrationSuccessful = false;
        while (!registrationSuccessful) {
                System.out.print("등록하실 회원의 이름을 입력하세요: ");
                String name = scanner.nextLine();
                System.out.print("등록하실 회원의 연락처를 입력하세요: ");
                int phone = scanner.nextInt();
                scanner.nextLine(); // 버퍼 비우기
                System.out.print("등록하실 회원의 주소를 입력하세요: ");
                String addr = scanner.nextLine();
                System.out.print("등록하실 회원의 비밀번호를 입력하세요: ");
                String password = scanner.nextLine();
                registrationSuccessful = memberManager.createMember(name, phone, addr, password);
        }
    }

    public void readMember() {
        System.out.print("조회할 회원의 이름을 입력하세요: ");
        String readName = scanner.nextLine();
        Member member = memberManager.readMember(readName);
        if (member != null) {
            System.out.println("회원번호: " + member.getNum() + "      이름: " + member.getName() + "        연락처: " + member.getPhone() + "     주소: " + member.getAddr() + "   비밀번호: " + member.getPassword());
        } else {
            System.out.println("해당 회원을 찾을 수 없습니다.");
        }
    }

    public void updateMember() {
        System.out.print("수정할 회원 이름을 입력해주세요: ");
        String readName = scanner.nextLine();
        Member member = memberManager.readMember(readName);
        if (member != null) {
            System.out.print(member.getName() + " 회원의 이름을 수정하세요: ");
			String newName = scanner.nextLine();
			member.setName(newName);
			System.out.print(member.getName() + " 회원의 연락처를 수정하세요: ");
			int newPhone = scanner.nextInt();
			member.setPhone(newPhone);
			System.out.print(member.getName() + " 회원의 주소를 수정하세요: ");
			String newAddr = scanner.nextLine();
			member.setAddr(newAddr);
			System.out.print(member.getName() + " 회원의 비밀번호를 수정하세요: ");
			String newPassword = scanner.nextLine();
			member.setPassword(newPassword);

			System.out.println("수정 완료되었습니다.");
        } else {
            System.out.println("해당 회원을 찾을 수 없습니다.");
        }
    }

    public void deleteMember() {
        System.out.print("삭제할 회원 이름을 입력해주세요: ");
        String deleteName = scanner.nextLine();
        System.out.print("비밀번호를 입력하세요: ");
        String deletePassword = scanner.nextLine();

        // 회원 정보를 조회하여 존재 여부와 비밀번호 확인
        Member member = memberManager.readMember(deleteName);
        if (member != null && member.getPassword().equals(deletePassword)) {
            // 비밀번호가 일치할 경우 회원 삭제
            memberManager.deleteMember(member.getNum()); // 회원 번호로 삭제
        } else {
            System.out.println("삭제할 회원을 찾을 수 없거나 비밀번호가 일치하지 않습니다.");
        }
    }

    public void listMembers() {
        memberManager.listMembers();
    }

    public void saveMembersToFile()  {
        System.out.print("저장할 파일 이름을 입력하세요: ");
        String filename = scanner.nextLine();
        memberManager.saveMembersToFile(filename);
    } 
    
    public void readFileMember() {
        System.out.print("불러올 파일 이름을 입력하세요: ");
        String filename = scanner.nextLine();
        memberManager.readMember(filename);
    }

}