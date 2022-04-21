package kr.smhrd.mapper;

import kr.smhrd.model.MemberVO;

public interface MemberVO_Mapper {
	
	//회원가입 메소드
	public void memberJoin(MemberVO vo);
	
	//로그인 메소드
	public String memberLogin(MemberVO vo);

}
