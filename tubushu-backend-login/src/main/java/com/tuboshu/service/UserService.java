package com.tuboshu.service;

import com.tuboshu.bean.TbsUser;
import com.tuboshu.common.TBSResult;

public interface UserService{
	public TBSResult add(String params);
	
	public TBSResult get(Long id);
	
	public TBSResult login(TbsUser user);
	
	public TBSResult mail(TbsUser user) throws Exception;
	
	public TBSResult list(Integer pageNum,Integer pageSize);

}
