package com.factoring.web.service.downstreamFirms.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.factoring.core.generic.GenericDao;
import com.factoring.core.generic.GenericServiceImpl;
import com.factoring.web.dao.downstreamFirms.CreditMapper;
import com.factoring.web.model.downstreamFirms.Credit;
import com.factoring.web.service.downstreamFirms.CreditService;

@Service
public class CreditServiceImpl extends GenericServiceImpl<Credit, String> implements CreditService {
	
	@Resource
	private CreditMapper creditMapper;

	@Override
	public int insertSelective(Credit credit) {
		return creditMapper.insertSelective(credit);
	}

	@Override
	public Credit selectCreditByUserName(String username) {
		return creditMapper.selectCreditByUserName(username);
	}

	@Override
	public int updateByPrimaryKeySelective(Credit record) {
		return creditMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int deleteByPrimaryKey(String id) {
		return creditMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Credit selectByPrimaryKey(String id) {
		return creditMapper.selectByPrimaryKey(id);
	}

	@Override
	public GenericDao<Credit, String> getDao() {
		return creditMapper;
	}

}
