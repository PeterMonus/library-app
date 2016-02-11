package web;

import java.util.List;

public class MemberService {	

	public List<Member> getAllMembers() {		
		List<Member> memberList = MemberListDAO.getAllMembers();
		return memberList;
	}
}
