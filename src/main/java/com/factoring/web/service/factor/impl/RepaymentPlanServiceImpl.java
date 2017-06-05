package com.factoring.web.service.factor.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.factoring.core.generic.GenericDao;
import com.factoring.core.generic.GenericServiceImpl;
import com.factoring.web.dao.factor.RepaymentPlanMapper;
import com.factoring.web.model.factor.RepaymentPlan;
import com.factoring.web.service.factor.RepaymentPlanService;

@Service
public class RepaymentPlanServiceImpl extends GenericServiceImpl<RepaymentPlan, String> implements RepaymentPlanService {

	@Resource
	private RepaymentPlanMapper repaymentPlanMapper;

	@Override
	public int insertSelective(RepaymentPlan repaymentPlan) {
		return repaymentPlanMapper.insertSelective(repaymentPlan);
	}

	@Override
	public List<RepaymentPlan> selectAllRepaymentPlan(String username) {
		return repaymentPlanMapper.selectAllRepaymentPlan(username);
	}

	@Override
	public int updateByPrimaryKeySelective(RepaymentPlan record) {
		return repaymentPlanMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int deleteByPrimaryKey(String id) {
		return repaymentPlanMapper.deleteByPrimaryKey(id);
	}

	@Override
	public RepaymentPlan selectByPrimaryKey(String id) {
		return repaymentPlanMapper.selectByPrimaryKey(id);
	}

	@Override
	public GenericDao<RepaymentPlan, String> getDao() {
		return repaymentPlanMapper;
	}

	@Override
	public List selectRepaymentPlanByState(String username) {
		return repaymentPlanMapper.selectRepaymentPlanByState(username);
	}

}
