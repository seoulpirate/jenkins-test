package com.example.biz;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.vo.MemberVO;

public class UserValidator implements Validator {
	@Override
	public boolean supports(Class<?> arg0) {
		// 검증할 객체의 class 타입 정보를 반환
		return MemberVO.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		System.out.println("검증시작");
		MemberVO userVO = (MemberVO) obj;
		String username = userVO.getUsername();
		if (username == null || username.trim().isEmpty()) {
			System.out.println("이름의 값이 빠졌습니다.");
			errors.rejectValue("username", "No Value");
		}
		int userage = userVO.getAge();
		if (userage == 0) {
			System.out.println("나이의 값이 빠졌습니다.");
			errors.rejectValue("age", "No Value");
		}
		String userid = userVO.getUserid();
		if (userid == null || userid.trim().isEmpty()) {
			System.out.println("아이디의 값이 빠졌습니다.");
			errors.rejectValue("userid", "No Value");
		}
	}
}
