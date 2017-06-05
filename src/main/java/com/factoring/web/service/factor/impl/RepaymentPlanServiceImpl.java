package com.factoring.web.service.factor.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.factoring.core.generic.GenericDao;
import com.factoring.core.generic.GenericServiceImpl;
import com.factoring.web.model.factor.RepaymentDetail;
import com.factoring.web.model.factor.RepaymentPlan;
import com.factoring.web.service.factor.RepaymentPlanService;

@Service
public class RepaymentPlanServiceImpl extends GenericServiceImpl<RepaymentPlan, String> implements RepaymentPlanService {


	@Override
	public List<RepaymentPlan> selectList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertSelective(RepaymentPlan repaymentPlan) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<RepaymentPlan> selectAllRepaymentPlan(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(RepaymentPlan record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public RepaymentDetail selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GenericDao<RepaymentPlan, String> getDao() {
		// TODO Auto-generated method stub
		return null;
	}

}
