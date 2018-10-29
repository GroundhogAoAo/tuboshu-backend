package com.tuboshu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tuboshu.bean.TbsUser;
import com.tuboshu.common.TBSResult;
import com.tuboshu.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService service;

	@PostMapping("/usr/insert")
	public TBSResult add(@RequestBody String params) {
		return service.add(params);
	}

	@GetMapping("/usr/get/{id}")
	public TBSResult get(@PathVariable("id") Long id) {
		return service.get(id);
	}

	@PostMapping("/usr/login")
	public TBSResult login(@RequestBody TbsUser user) {
		return service.login(user);
	}

	@PostMapping("/usr/mail/message")
	public TBSResult mail(@RequestBody TbsUser user) {
		try {
			return service.mail(user);
		} catch (Exception e) {
			e.printStackTrace();
			return TBSResult.build(500, "系统内部错误");
		}
	}

	@GetMapping("/country/list")
	public TBSResult list(@RequestParam(defaultValue = "1") Integer pageNum,
			@RequestParam(defaultValue = "10") Integer pageSize) {
		return service.list(pageNum, pageSize);
	}

}
