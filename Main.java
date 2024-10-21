package com.member.main;

import java.io.IOException;
import java.util.Scanner;
import com.member.controller.MemberManager;
import com.member.service.MemberService;
import com.member.controller.ManagerMember;

public class Main {
    public static void main(String[] args) {
        ManagerMember managerMember = new ManagerMember();
        MemberManager memberManager = new MemberManager();
        MemberService memberService = new MemberService(memberManager);
        
        if (managerMember.authenticate()) {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("*******************************************");
                System.out.println("               회원 관리 프로그램               ");
                System.out.println("*******************************************");
                System.out.println("회원 관리 프로그램");
                System.out.println("1. 고객 정보 등록하기" + "  2. 고객 정보 조회하기");
                System.out.println("3. 고객 정보 수정하기" + "  4. 고객 정보 삭제하기");
                System.out.println("5. 고객 정보 목록보기" + "  6. 고객 정보 파일출력");
                System.out.println("7. 종료");
                System.out.print("메뉴 번호를 선택해주세요: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // 버퍼 비우기
                memberManager.initMember();
                switch (choice) {
                    case 1:
                        memberService.registerMember();
                        break;

                    case 2:
                        memberService.readMember();
                        break;

                    case 3:
                        memberService.updateMember();
                        break;

                    case 4:
                        memberService.deleteMember();
                        break;

                    case 5:
                        memberService.listMembers();
                        break;

                    case 6:
                        memberService.saveMembersToFile();
                        break;

                    case 7:
                        System.out.println("회원 관리 프로그램을 종료합니다.");
                        System.exit(0);

                    default:
                        System.out.println("1부터 7까지의 숫자를 입력하세요. 다시 선택해주세요.");
                }
            }
        } else {
            System.out.println("로그인 실패. 프로그램을 종료합니다.");
        }
    }
}
