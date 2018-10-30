package com.tuboshu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.tuboshu.bean.TbsUser;
import com.tuboshu.common.TBSResult;

@RestController
public class UserController_Consumer{
	
	private static final String REST_URL_PREFIX = "http://localhost:8001";
	//private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT";

	/**
	 * 使用 使用restTemplate访问restful接口非常的简单粗暴无脑。 (url, requestMap,
	 * ResponseBean.class)这三个参数分别代表 REST请求地址、请求参数、HTTP响应转换被转换成的对象类型。
	 */
	@Autowired
	private RestTemplate restTemplate;

	@PostMapping("/usr/insert")
	public TBSResult add(@RequestBody String params){
		return restTemplate.postForObject(REST_URL_PREFIX + "/usr/insert", params, TBSResult.class);
	}

	@GetMapping("/usr/get/{id}")
	public TBSResult get(@PathVariable("id") Long id) {
		return restTemplate.getForObject(REST_URL_PREFIX + "/usr/get/" + id, TBSResult.class);
	}

	@PostMapping("/usr/login")
	public TBSResult login(@RequestBody TbsUser user) {
		return restTemplate.postForObject(REST_URL_PREFIX + "/usr/login",user, TBSResult.class);
	}

	@PostMapping("/usr/mail/message")
	public TBSResult mail(@RequestBody TbsUser user) {
		return restTemplate.postForObject(REST_URL_PREFIX + "/usr/mail/message",user, TBSResult.class);
	}
	
	@GetMapping("/country/list")
	public TBSResult list(@RequestParam(defaultValue = "1") Integer pageNum,
			@RequestParam(defaultValue = "10") Integer pageSize) {
		return restTemplate.getForObject(REST_URL_PREFIX+"/country/list?pageNum="+pageNum+"&pageSize="+pageSize , TBSResult.class);
	}

}
