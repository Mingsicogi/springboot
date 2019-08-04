package com.mybatisAndTransaction.member;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mybatisAndTransaction.app.common.service.MemberService;
import com.mybatisAndTransaction.app.common.vo.MemberVO;

import lombok.extern.slf4j.Slf4j;

/**
 * Source - Generate Element Comment
 * jUnit 활용 테스트
 * GIVE : 조건
 * WHEN : 작업
 * THEN : 결과
 * GIVE조건에서 WHEN작업을 했을 때 THEN 결과가 나오는지 확인
 * 
 * 방법 : Run As - jUnit Test
 * 
 * @author minhj
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class MemberServiceImplTest {
	
	@Autowired
	private MemberService memberService;
	
	@Test
	public void a_멤버_서비스_단건_조회() {
		
		MemberVO dbParam;
		MemberVO dbInfo;
		
		GIVE:{
			dbParam = new MemberVO();
			dbParam.setEmail("min@gmail.com");
			dbParam.setName("형준");
		}
		
		WHEN:{
			dbInfo = memberService.getMemberOne(dbParam);
		}
		
		THEN:{
			org.junit.Assert.assertNotNull(dbInfo);
			
			System.out.println(dbInfo.toString());
		}
	}
	
	@Test
	public void b_멤버_서비스_단건_추가() {
		
		MemberVO dbParam;
		MemberVO dbInfo;
		
		GIVE:{
			dbParam = new MemberVO();
			dbParam.setId(2);
			dbParam.setEmail("jeon2@gmail.com");
			dbParam.setName("민석2");
		}
		
		WHEN:{
			memberService.addMember(dbParam);
			
			dbInfo = memberService.getMemberOne(dbParam);
		}
		
		THEN:{
			org.junit.Assert.assertNotNull(dbInfo);
			
			System.out.println(dbInfo.toString());
		}
	}
}
