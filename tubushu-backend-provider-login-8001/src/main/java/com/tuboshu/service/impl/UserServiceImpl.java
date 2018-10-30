package com.tuboshu.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.tuboshu.bean.TbsCountry;
import com.tuboshu.bean.TbsCountryQuery;
import com.tuboshu.bean.TbsEmailVerification;
import com.tuboshu.bean.TbsEmailVerificationQuery;
import com.tuboshu.bean.TbsUser;
import com.tuboshu.bean.TbsUserQuery;
import com.tuboshu.common.MD5Util;
import com.tuboshu.common.MailUtil;
import com.tuboshu.common.RandomUtil;
import com.tuboshu.common.TBSResult;
import com.tuboshu.dao.TbsCountryDao;
import com.tuboshu.dao.TbsEmailVerificationDao;
import com.tuboshu.dao.TbsUserDao;
import com.tuboshu.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private TbsUserDao userDao;
	@Autowired
	private TbsEmailVerificationDao emailVerificationDao;
	@Autowired
	private TbsCountryDao countryDao;
	
	@Override
	public TBSResult add(String params){
		JSONObject jsonobject = JSONObject.parseObject(params);
		String code = jsonobject.getString("code");
		String email = jsonobject.getString("email");
		String verfication = jsonobject.getString("verfication");
		String pwd = jsonobject.getString("pwd");
		String invite = jsonobject.getString("invite");
		String level = jsonobject.getString("level");
		TbsEmailVerificationQuery tbsEmailVerificationQuery = new TbsEmailVerificationQuery();
		tbsEmailVerificationQuery.setOrderByClause("time DESC");
		tbsEmailVerificationQuery.createCriteria().andEmailEqualTo(email);
		List<TbsEmailVerification> emails = emailVerificationDao.selectByExample(tbsEmailVerificationQuery);
		if(emails.isEmpty()){
			return TBSResult.build(400, "未发送验证码");
		}
		TbsEmailVerification tbsEmailVerification = emails.get(0);
		Long startTime = tbsEmailVerification.getTime();
		Long endTime = new Date().getTime();
		if((endTime-startTime)>24* 3600000){
			return TBSResult.build(400, "验证码超过24小时,请重新发送");
		}
		String verificationCode = tbsEmailVerification.getVerificationCode();
		if(!verificationCode.equals(verfication)){
			return TBSResult.build(400, "验证码错误");
		}
		TbsUserQuery tbsUserQuery = new TbsUserQuery();
		tbsUserQuery.createCriteria().andEmailEqualTo(email);
		List<TbsUser> users = userDao.selectByExample(tbsUserQuery);
		if(!users.isEmpty()){
			return TBSResult.build(400, "该邮箱已经注册");
		}
		TbsUser user = new TbsUser();
		String convertMD5 = MD5Util.string2MD5(pwd);
		user.setLevel(level==null?"0":level);
		user.setPwd(convertMD5);
		user.setEmail(email);
		user.setCreated(new Date().getTime());
		user.setAreaCode(code);
		userDao.insertSelective(user);
		return TBSResult.ok("添加成功");
	}

	@Override
	public TBSResult get(Long id) {
		// TODO Auto-generated method stub
		TbsUser user = userDao.selectByPrimaryKey(id);
		if(user == null){
			return TBSResult.build(400, "用户不存在");
		}
		return TBSResult.build(200, "查询成功", user);
			
	}

	@Override
	public TBSResult login(TbsUser user) {
		// TODO Auto-generated method stub
		String email = user.getEmail();
		String pwd = user.getPwd();
		String convertMD5 = MD5Util.string2MD5(pwd);
		TbsUserQuery tbsUserQuery = new TbsUserQuery();
		tbsUserQuery.createCriteria().andEmailEqualTo(email);
		List<TbsUser> users = userDao.selectByExample(tbsUserQuery);
		if(users.isEmpty()){
			return TBSResult.build(400, "该邮箱未注册");
		}
		TbsUser tbsUser = users.get(0);
		if(!tbsUser.getPwd().equals(convertMD5)){
			return TBSResult.build(400, "账号/密码错误");
		}
		return TBSResult.ok("登录成功");
	}

	@Override
	public TBSResult mail(TbsUser user) throws Exception {
		// TODO Auto-generated method stub
		String random = RandomUtil.getRandom();
		TbsEmailVerification tbsEmailVerification = new TbsEmailVerification();
		tbsEmailVerification.setEmail(user.getEmail());
		tbsEmailVerification.setTime(new Date().getTime());
		tbsEmailVerification.setVerificationCode(random);
		emailVerificationDao.insertSelective(tbsEmailVerification);
		MailUtil.sendMail(user.getEmail(), "土拨鼠短信验证码","请您在24小时内完成验证,本次验证码:"+random);
		return TBSResult.ok("发送成功");
	}

	@Override
	public TBSResult list(Integer pageNum,Integer pageSize) {
		// TODO Auto-generated method stub
		TbsCountryQuery tbsCountryQuery = new TbsCountryQuery();
		tbsCountryQuery.setPageNo(pageNum);
		tbsCountryQuery.setPageSize(pageSize);
		List<TbsCountry> countrys = countryDao.selectByExample(tbsCountryQuery);
		return TBSResult.ok(countrys);
	}

}
