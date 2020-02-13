package com.example.biz;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.service.MemberService;
import com.example.vo.MemberVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	MemberService memberService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String home(MemberVO memberVo, Model model) {
		int row = this.memberService.create(memberVo);
		if (row == 1)
			model.addAttribute("status", "Insert Success");
		else
			model.addAttribute("status", "Insert Failure");
		return "create"; // /WEB-INF/views/create.jsp
	}	

	@RequestMapping(value = "/view/{userid}", method = RequestMethod.GET)
	public String view(@PathVariable String userid, Model model) {
		MemberVO memberVo = this.memberService.read(userid);
		model.addAttribute("member", memberVo);
		return "view"; // /WEB-INF/views/view.jsp
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		List<MemberVO> list = this.memberService.readAll();
		model.addAttribute("userlist", list);
		return "list"; // /WEB-INF/views/list.jsp
	}

	@RequestMapping(value = "/delete/{userid}", method = RequestMethod.GET)
	public String delete(@PathVariable String userid) {
		this.memberService.delete(userid);
		return "redirect:/list";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@RequestParam("userid") String userid, @RequestParam("age") int age,
			@RequestParam("gender") String gender, @RequestParam("city") String city) {
		this.memberService.update(new MemberVO(userid, "", age, gender, city));
		return "redirect:/list";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register() {
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@ModelAttribute("userVO") MemberVO userVO, BindingResult result) {
		String page = "register_ok";
		UserValidator validator = new UserValidator();
		validator.validate(userVO, result);
		if (result.hasErrors()) {
			page = "register";
		}
		return page;
	}
}
