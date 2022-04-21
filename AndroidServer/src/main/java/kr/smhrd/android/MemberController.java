package kr.smhrd.android;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.smhrd.mapper.MemberVO_Mapper;
import kr.smhrd.model.MemberVO;

@RestController
public class MemberController {
	
	@Autowired
	MemberVO_Mapper mapper;
		
	@RequestMapping(value="/Join", method=RequestMethod.POST)
	public String Join(MemberVO vo) {
		      
		      System.out.println(vo.getId());
		      System.out.println(vo.getNick());
		      System.out.println(vo.getPw());
		      
		      mapper.memberJoin(vo);
		
		
		return "success";
		
	}

	@RequestMapping(value="/Login", method=RequestMethod.POST)
	public String Login(MemberVO vo) {

		String nick = mapper.memberLogin(vo);
				
		return nick;
		
	}
}
