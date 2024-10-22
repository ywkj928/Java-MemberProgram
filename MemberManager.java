package com.member.controller;

import com.member.domain.Member; // Member 클래스를 사용하기 위한 임포트
import java.io.BufferedReader; // 파일 읽기를 위한 BufferedReader 클래스 임포트
import java.io.BufferedWriter; // 파일 쓰기를 위한 BufferedWriter 클래스 임포트
import java.io.File; // 파일 관리를 위한 File 클래스 임포트
import java.io.FileReader; // 파일 읽기를 위한 FileReader 클래스 임포트
import java.io.FileWriter; // 파일 쓰기를 위한 FileWriter 클래스 임포트
import java.io.IOException; // IOException 처리
import java.util.ArrayList; // ArrayList 사용
import java.util.List; // List 인터페이스 사용
import java.util.StringTokenizer; // 문자열 분할을 위한 StringTokenizer 클래스 임포트

// 회원 관리 클래스
public class MemberManager implements MemberManagement {
    private List<Member> members = new ArrayList<>(); // 회원 정보를 저장할 리스트
    private int nextNum = 1; // 다음 회원 번호 초기화
    
    // 회원 생성 메서드
    @Override
    public boolean createMember(String name, int phone, String addr, String password) {
        // 중복 이름 체크
        for (Member member : members) {
            if (member.getName().equals(name)) {
                System.out.println("이미 존재하는 이름입니다. 다른 이름으로 등록해주세요."); // 중복 이름 메시지
                return false; // 회원 등록 실패
            }
        }
        // 새 회원 추가
        members.add(new Member(nextNum++, name, phone, addr, password)); // 회원 추가 및 번호 증가
        System.out.println("등록 완료되었습니다."); // 등록 완료 메시지
        return true; // 회원 등록 성공
    }

    // 회원 조회 메서드
    @Override
    public Member readMember(String name) {
        // 이름으로 회원 검색
        for (Member member : members) {
            if (member.getName().equals(name)) {
                return member; // 회원 반환
            }
        }
        return null; // 회원을 찾지 못했음
    }

    // 회원 정보 업데이트 메서드
    @Override
    public boolean updateMember(int num, String name, int phone, String addr, String password) {
        // 이름으로 회원 검색 후 수정
        for (Member member : members) {
            if (member.getName().equals(name)) {
                System.out.println("수정 완료되었습니다."); // 수정 완료 메시지
                return true; // 회원 수정 성공
            }
        }
        return false; // 회원 수정 실패
    }

    // 회원 삭제 메서드
    @Override
    public boolean deleteMember(int num) {
        // 회원 번호로 회원 검색 후 삭제
        for (Member member : members) {
            if (member.getNum() == num) {
                members.remove(member); // 회원 삭제
                System.out.println("삭제되었습니다."); // 삭제 완료 메시지
                return true; // 회원 삭제 성공
            }
        }
        return false; // 회원 삭제 실패
    }

    // 모든 회원 목록 출력 메서드
    @Override
    public void listMembers() {
        if (members.isEmpty()) { // 리스트가 비어있는 경우
            System.out.println("등록된 회원이 없습니다."); // 회원 없음 메시지
            return;
        }
        // 모든 회원 정보 출력
        for (Member member : members) {
            System.out.println("회원번호: " + member.getNum() + "      이름: " + member.getName() + "     연락처: " + member.getPhone());
        }
    }

    // 회원 정보를 파일에 저장하는 메서드
    public void saveMembersToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            // 모든 회원 정보를 파일에 기록
            for (Member member : members) {
                writer.write("회원번호: " + member.getNum() + "    이름: " + member.getName() + 
                             "     연락처: " + member.getPhone() + "     주소: " + member.getAddr() + 
                             "   비밀번호: " + member.getPassword());
                writer.newLine(); // 다음 라인으로 이동
            }
            System.out.println("회원 정보가 " + filename + "에 저장되었습니다."); // 저장 완료 메시지
        } catch (IOException e) {
        	System.out.println("파일 저장 중 오류가 발생했습니다: " + e.getMessage()); // 파일 저장 오류 처리
        }
    }

    // 회원 정보를 파일에서 초기화하는 메서드
    public void initMember() {
		File file = new File("memberLixt.txt"); // 회원 정보 파일 경로
		try {
			FileReader myreader = new FileReader(file); // 파일 읽기 위한 FileReader
			BufferedReader br = new BufferedReader(myreader); // BufferedReader로 파일 읽기

			String str;

			// 파일의 모든 라인 읽기
			while ((str = br.readLine()) != null) {
				StringTokenizer strToken = new StringTokenizer(str); // 문자열 분할
				String rDum1 = strToken.nextToken(); // 번호:
				String rNum = strToken.nextToken(); // 회원 번호
				String rDum2 = strToken.nextToken(); // 이름:
				String rName = strToken.nextToken(); // 회원 이름
				String rDum3 = strToken.nextToken(); // 연락처:
				String rPhone = strToken.nextToken(); // 연락처
				String rDum4 = strToken.nextToken(); // 주소:
				String rAddr = strToken.nextToken(); // 주소
				String rDum5 = strToken.nextToken(); // 비밀번호:
				String rPass = strToken.nextToken(); // 비밀번호

				// 회원 정보를 리스트에 추가
				members.add(new Member(nextNum++, rName, Integer.valueOf(rPhone), rAddr, rPass));
			}
			myreader.close(); // 파일 리더 닫기
		} catch (Exception e) {
			e.printStackTrace(); // 예외 발생 시 스택 트레이스 출력
		}
	}

    // 회원 정보 업데이트 메서드 (중복 정의, 필요 시 수정 필요)
	public boolean updateMember(int num, String name, String newPhone, String newAddr, String newPassword) {
        for (Member member : members) {
            if (member.getName().equals(name)) {
                System.out.println("수정 완료되었습니다."); // 수정 완료 메시지
                return true; // 회원 수정 성공
            }
        }
        return false; // 회원 수정 실패
    }
}
