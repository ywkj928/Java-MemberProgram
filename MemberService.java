package com.member.service;

import com.member.controller.MemberManager; // 회원 관리 클래스 임포트
import com.member.domain.Member; // Member 클래스 임포트
import java.io.IOException; // IOException 처리
import java.util.Scanner; // 사용자 입력을 위한 Scanner 클래스 임포트

// 회원 서비스 클래스
public class MemberService {
    private final MemberManager memberManager; // 회원 관리 객체
    private final Scanner scanner; // 사용자 입력을 위한 Scanner 객체

    // 생성자: MemberManager 객체 초기화
    public MemberService(MemberManager memberManager) {
        this.memberManager = memberManager; // 회원 관리 객체 설정
        this.scanner = new Scanner(System.in); // Scanner 초기화
    }

    // 회원 등록 메서드
    public void registerMember() {
        boolean registrationSuccessful = false; // 등록 성공 여부 초기화
        while (!registrationSuccessful) { // 등록 성공할 때까지 반복
            System.out.print("등록하실 회원의 이름을 입력하세요: "); // 이름 입력 요청
            String name = scanner.nextLine(); // 이름 입력 받기
            System.out.print("등록하실 회원의 연락처를 입력하세요: "); // 연락처 입력 요청
            int phone = scanner.nextInt(); // 연락처 입력 받기
            scanner.nextLine(); // 입력 버퍼 비우기
            System.out.print("등록하실 회원의 주소를 입력하세요: "); // 주소 입력 요청
            String addr = scanner.nextLine(); // 주소 입력 받기
            System.out.print("등록하실 회원의 비밀번호를 입력하세요: "); // 비밀번호 입력 요청
            String password = scanner.nextLine(); // 비밀번호 입력 받기
            registrationSuccessful = memberManager.createMember(name, phone, addr, password); // 회원 등록 시도
        }
    }

    // 회원 조회 메서드
    public void readMember() {
        System.out.print("조회할 회원의 이름을 입력하세요: "); // 조회할 회원 이름 입력 요청
        String readName = scanner.nextLine(); // 이름 입력 받기
        Member member = memberManager.readMember(readName); // 회원 조회
        if (member != null) { // 회원이 존재하는 경우
            // 회원 정보 출력
            System.out.println("회원번호: " + member.getNum() + "      이름: " + member.getName() + 
                               "        연락처: " + member.getPhone() + "     주소: " + member.getAddr() + 
                               "   비밀번호: " + member.getPassword());
        } else {
            System.out.println("해당 회원을 찾을 수 없습니다."); // 회원을 찾지 못했을 때 메시지
        }
    }

    // 회원 정보 수정 메서드
    public void updateMember() {
        System.out.print("수정할 회원 이름을 입력해주세요: "); // 수정할 회원 이름 입력 요청
        String readName = scanner.nextLine(); // 이름 입력 받기
        Member member = memberManager.readMember(readName); // 회원 조회
        if (member != null) { // 회원이 존재하는 경우
            System.out.print(member.getName() + " 회원의 이름을 수정하세요: "); // 이름 수정 요청
            String newName = scanner.nextLine(); // 새 이름 입력 받기
            member.setName(newName); // 이름 설정
            System.out.print(member.getName() + " 회원의 연락처를 수정하세요: "); // 연락처 수정 요청
            int newPhone = scanner.nextInt(); // 새 연락처 입력 받기
            member.setPhone(newPhone); // 연락처 설정
            System.out.print(member.getName() + " 회원의 주소를 수정하세요: "); // 주소 수정 요청
            String newAddr = scanner.nextLine(); // 새 주소 입력 받기
            member.setAddr(newAddr); // 주소 설정
            System.out.print(member.getName() + " 회원의 비밀번호를 수정하세요: "); // 비밀번호 수정 요청
            String newPassword = scanner.nextLine(); // 새 비밀번호 입력 받기
            member.setPassword(newPassword); // 비밀번호 설정

            System.out.println("수정 완료되었습니다."); // 수정 완료 메시지
        } else {
            System.out.println("해당 회원을 찾을 수 없습니다."); // 회원을 찾지 못했을 때 메시지
        }
    }

    // 회원 삭제 메서드
    public void deleteMember() {
        System.out.print("삭제할 회원 이름을 입력해주세요: "); // 삭제할 회원 이름 입력 요청
        String deleteName = scanner.nextLine(); // 이름 입력 받기
        System.out.print("비밀번호를 입력하세요: "); // 비밀번호 입력 요청
        String deletePassword = scanner.nextLine(); // 비밀번호 입력 받기

        // 회원 정보를 조회하여 존재 여부와 비밀번호 확인
        Member member = memberManager.readMember(deleteName); // 회원 조회
        if (member != null && member.getPassword().equals(deletePassword)) { // 비밀번호 확인
            // 비밀번호가 일치할 경우 회원 삭제
            memberManager.deleteMember(member.getNum()); // 회원 번호로 삭제
        } else {
            System.out.println("삭제할 회원을 찾을 수 없거나 비밀번호가 일치하지 않습니다."); // 회원 삭제 실패 메시지
        }
    }

    // 모든 회원 목록 출력 메서드
    public void listMembers() {
        memberManager.listMembers(); // 회원 목록 출력
    }

    // 회원 정보를 파일에 저장하는 메서드
    public void saveMembersToFile() {
        System.out.print("저장할 파일 이름을 입력하세요: "); // 파일 이름 입력 요청
        String filename = scanner.nextLine(); // 파일 이름 입력 받기
        memberManager.saveMembersToFile(filename); // 파일에 회원 정보 저장
    } 
    
    // 파일에서 회원 정보를 읽어오는 메서드 (구현 필요)
    public void readFileMember() {
        System.out.print("불러올 파일 이름을 입력하세요: "); // 파일 이름 입력 요청
        String filename = scanner.nextLine(); // 파일 이름 입력 받기
        memberManager.readMember(filename); // 회원 정보 읽기 (구현 필요)
    }
}
