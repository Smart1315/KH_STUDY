package com.kh.spring.member.model.service;

import com.kh.spring.member.model.vo.Member;

public interface MemberService {

	Member memberLogin(Member m);

	int insertMember(Member m);

	int updateMember(Member m);

	int updateMemberPwd(Member m);

	int checkIdDup(String id);

}
