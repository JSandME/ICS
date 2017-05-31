package com.factoring.web.service.downstreamFirms.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.factoring.core.entity.ServiceException;
import com.factoring.core.generic.GenericDao;
import com.factoring.core.generic.GenericServiceImpl;
import com.factoring.web.dao.downstreamFirms.FinancingApplyMapper;
import com.factoring.web.model.downstreamFirms.FinancingApply;
import com.factoring.web.service.downstreamFirms.FinancingApplyService;

@Service
public class FinancingApplyServiceImpl extends GenericServiceImpl<FinancingApply, String> implements FinancingApplyService {
	
	@Resource
	private FinancingApplyMapper financingApplyMapper;

	@Override
	@Transactional(rollbackFor = ServiceException.class)
	public int insertSelective(FinancingApply apply) throws ServiceException{
		return financingApplyMapper.insertSelective(apply);
	}

	@Override
	public FinancingApply selectFinancingApplyByUserName(String username) {
		return financingApplyMapper.selectFinancingApplyByUserName(username);
	}

	@Override
	public int updateByPrimaryKeySelective(FinancingApply record) {
		return financingApplyMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int deleteByPrimaryKey(String id) {
		return financingApplyMapper.deleteByPrimaryKey(id);
	}

	@Override
	public FinancingApply selectByPrimaryKey(String id) {
		return financingApplyMapper.selectByPrimaryKey(id);
	}

	@Override
	public GenericDao<FinancingApply, String> getDao() {
		return financingApplyMapper;
	}

}
