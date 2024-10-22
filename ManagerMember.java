package com.member.controller;

import java.util.Scanner; // Scanner 클래스를 사용하기 위한 임포트
import com.member.domain.*; // 도메인 클래스를 사용하기 위한 임포트
import com.member.main.*; // 메인 클래스를 사용하기 위한 임포트

public class ManagerMember {
    private static final String ADMIN_ID = "ywkj"; // 관리자의 ID
    private static final String ADMIN_PASSWORD = "ywkj"; // 관리자의 비밀번호

    // 관리자 인증 메서드
    public static boolean authenticate() {
        Scanner scanner = new Scanner(System.in); // 사용자 입력을 위한 Scanner 객체
        int err_cnt = 0; // 오류 카운터 초기화

        while (true) { // 무한 루프 시작
            System.out.println("********************************************");
            System.out.println("                    로그인                   "); // 로그인 화면 표시
            System.out.println("********************************************");

            System.out.print("아이디 입력하세요: "); // 아이디 입력 요청
            String inputId = scanner.nextLine(); // 사용자로부터 아이디 입력 받기
            if (!inputId.equals(ADMIN_ID)) { // 입력한 아이디가 관리자의 아이디와 일치하지 않는 경우
                System.out.println("일치하는 아이디가 없습니다."); // 아이디 불일치 메시지
                err_cnt++; // 오류 카운터 증가
                if (err_cnt == 3) { // 3회 오류 발생 시
                	return false; // 인증 실패
                }
            } else {
                System.out.print("비밀번호를 입력하세요: "); // 비밀번호 입력 요청
                String inputPassword = scanner.nextLine(); // 사용자로부터 비밀번호 입력 받기
                if (inputPassword.equals(ADMIN_PASSWORD)) { // 입력한 비밀번호가 관리자의 비밀번호와 일치하는 경우
                    System.out.println("로그인 성공"); // 로그인 성공 메시지
                    return true; // 로그인 성공
                } else {
                    System.out.println("비밀번호가 틀렸습니다."); // 비밀번호 불일치 메시지
                    err_cnt++; // 오류 카운터 증가
                    if (err_cnt == 3) { // 3회 오류 발생 시
                        System.out.println("로그인 횟수 초과"); // 로그인 횟수 초과 메시지
                        return false; // 인증 실패
                    }
                }
            }
        }
    }
}
