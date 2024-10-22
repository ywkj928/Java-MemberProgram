package com.member.controller;

import com.member.domain.Member; // Member 클래스 임포트

// 회원 관리 인터페이스
public interface MemberManagement {
    // 회원 생성 메서드: 이름, 전화번호, 주소 및 비밀번호를 받아 회원을 생성
    boolean createMember(String name, int phone, String addr, String password); 
    
    // 회원 조회 메서드: 이름으로 회원 정보를 반환
    Member readMember(String name);
    
    // 회원 정보 업데이트 메서드: 회원 번호, 이름, 전화번호, 주소 및 비밀번호를 받아 회원 정보를 업데이트
    boolean updateMember(int num, String name, int phone, String addr, String password); 
    
    // 모든 회원 목록 출력 메서드
    void listMembers();
    
    // 회원 삭제 메서드: 회원 번호를 받아 해당 회원을 삭제
    boolean deleteMember(int num);
}
