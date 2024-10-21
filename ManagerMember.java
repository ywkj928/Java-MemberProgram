package com.member.controller;

import java.util.Scanner;
import com.member.domain.*;
import com.member.main.*;

public class ManagerMember {
    private static final String ADMIN_ID = "ywkj";
    private static final String ADMIN_PASSWORD = "ywkj";

    public static boolean authenticate() {
        Scanner scanner = new Scanner(System.in);
        int err_cnt = 0;

        while (true) {
            System.out.println("********************************************");
            System.out.println("                    로그인                   ");
            System.out.println("********************************************");

            System.out.print("아이디 입력하세요: ");
            String inputId = scanner.nextLine();
            if (!inputId.equals(ADMIN_ID)) {
                System.out.println("일치하는 아이디가 없습니다.");
                err_cnt++;
                if (err_cnt == 3) {
                	return false;
                }
            } else {
                System.out.print("비밀번호를 입력하세요: ");
                String inputPassword = scanner.nextLine();
                if (inputPassword.equals(ADMIN_PASSWORD)) {
                    System.out.println("로그인 성공");
                    return true; // 로그인 성공
                } else {
                    System.out.println("비밀번호가 틀렸습니다.");
                    err_cnt++;
                    if (err_cnt == 3) {
                        System.out.println("로그인 횟수 초과");
                        return false;
                    }
                }
            }
            
        }
    }
}

