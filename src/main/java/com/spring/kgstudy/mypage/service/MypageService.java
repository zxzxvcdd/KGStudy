package com.spring.kgstudy.mypage.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.kgstudy.member.vo.MemberVO;
import com.spring.kgstudy.mypage.dao.MypageDAO;
import com.spring.kgstudy.seat.dao.SeatDAO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MypageService {

	private final MypageDAO dao;
	private final SeatDAO seatDao;
	
	private final PasswordEncoder passwordEncoder;
	
	
	//마이페이지 비밀번호 체크
	public boolean mypagePwCheck(MemberVO memberVO) {
		
		String rawPw = memberVO.getUser_pw();

		memberVO = dao.findOneMember(memberVO.getUser_id()); // db에서 login한 유저의 아이디를 가져와서
		
		String encodedPw = memberVO.getUser_pw(); // login한 유저의 pw를 MemberVO pw안에 넣는다.
		
		//System.out.println("mypagePwCheck vo : " + memberVO);
		
		boolean pwdSuccess = passwordEncoder.matches(rawPw, encodedPw);
		
		//System.out.println("평문 pw:" + rawPw);
		//System.out.println("암호화된 pw:" + encodedPw);

		if (pwdSuccess) {
			return true;
		} else {
			return false;
		}

	}

	//마이페이지 회원 수정
	public boolean mypageUserUpdate(MemberVO memberVO) {
		
		String pwdBycrypt = passwordEncoder.encode(memberVO.getUser_pw());
		memberVO.setUser_pw(pwdBycrypt);
		
		/* System.out.println("pw 암호화:" + pwdBycrypt); */
		
		boolean updateSuccess = dao.memberUpdate(memberVO);
		
		if (updateSuccess) {
			return true;
		} else {
			return false;
		}
		
	}


	
	public boolean mypagefindReserv(String user_id) {
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
