package com.factoring.web.service.factor.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.factoring.core.generic.GenericDao;
import com.factoring.core.generic.GenericServiceImpl;
import com.factoring.web.dao.factor.RepaymentDetailMapper;
import com.factoring.web.model.factor.RepaymentDetail;
import com.factoring.web.service.factor.RepaymentDetailService;

@Service
public class RepaymentDetailServiceImpl extends GenericServiceImpl<RepaymentDetail, String> implements RepaymentDetailService {

	@Resource
	private RepaymentDetailMapper repaymentDetailMapper;
	
	@Override
	public int insertSelective(RepaymentDetail product) {
		return repaymentDetailMapper.insertSelective(product);
	}

	@Override
	public List<RepaymentDetail> selectAllRepaymentDetail(String username) {
		return repaymentDetailMapper.selectAllRepaymentDetail(username);
	}

	@Override
	public int updateByPrimaryKeySelective(RepaymentDetail record) {
		return repaymentDetailMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int deleteByPrimaryKey(String id) {
		return repaymentDetailMapper.deleteByPrimaryKey(id);
	}

	@Override
	public RepaymentDetail selectByPrimaryKey(String id) {
		return repaymentDetailMapper.selectByPrimaryKey(id);
	}

	@Override
	public GenericDao<RepaymentDetail, String> getDao() {
		return repaymentDetailMapper;
	}


}
