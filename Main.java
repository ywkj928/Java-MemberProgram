package com.member.main;

import java.io.IOException; // IOException 처리
import java.util.Scanner; // 사용자 입력을 위한 Scanner 클래스 임포트
import com.member.controller.MemberManager; // 회원 관리 클래스 임포트
import com.member.service.MemberService; // 회원 서비스 클래스 임포트
import com.member.controller.ManagerMember; // 관리자 관리 클래스 임포트

// 프로그램의 메인 클래스
public class Main {
    public static void main(String[] args) {
        ManagerMember managerMember = new ManagerMember(); // 관리자 관리 객체 생성
        MemberManager memberManager = new MemberManager(); // 회원 관리 객체 생성
        MemberService memberService = new MemberService(memberManager); // 회원 서비스 객체 생성

        // 관리자 인증
        if (managerMember.authenticate()) {
            Scanner scanner = new Scanner(System.in); // 사용자 입력을 위한 Scanner 객체
            while (true) { // 무한 루프 시작
                // 프로그램 메뉴 출력
                System.out.println("*******************************************");
                System.out.println("               회원 관리 프로그램               ");
                System.out.println("*******************************************");
                System.out.println("회원 관리 프로그램");
                System.out.println("1. 고객 정보 등록하기" + "  2. 고객 정보 조회하기");
                System.out.println("3. 고객 정보 수정하기" + "  4. 고객 정보 삭제하기");
                System.out.println("5. 고객 정보 목록보기" + "  6. 고객 정보 파일출력");
                System.out.println("7. 종료");
                System.out.print("메뉴 번호를 선택해주세요: "); // 메뉴 선택 요청
                int choice = scanner.nextInt(); // 사용자로부터 메뉴 번호 입력 받기
                scanner.nextLine(); // 입력 버퍼 비우기
                memberManager.initMember(); // 회원 정보 초기화 (파일에서 읽기)
                
                // 메뉴 선택에 따른 분기 처리
                switch (choice) {
                    case 1:
                        memberService.registerMember(); // 회원 등록 메서드 호출
                        break;

                    case 2:
                        memberService.readMember(); // 회원 조회 메서드 호출
                        break;

                    case 3:
                        memberService.updateMember(); // 회원 수정 메서드 호출
                        break;

                    case 4:
                        memberService.deleteMember(); // 회원 삭제 메서드 호출
                        break;

                    case 5:
                        memberService.listMembers(); // 회원 목록 출력 메서드 호출
                        break;

                    case 6:
                        memberService.saveMembersToFile(); // 회원 정보를 파일에 저장하는 메서드 호출
                        break;

                    case 7:
                        System.out.println("회원 관리 프로그램을 종료합니다."); // 종료 메시지
                        System.exit(0); // 프로그램 종료

                    default:
                        System.out.println("1부터 7까지의 숫자를 입력하세요. 다시 선택해주세요."); // 잘못된 입력 처리
                }
            }
        } else {
            System.out.println("로그인 실패. 프로그램을 종료합니다."); // 로그인 실패 메시지
        }
    }
}
