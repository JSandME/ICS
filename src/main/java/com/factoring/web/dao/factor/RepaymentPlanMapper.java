package com.factoring.web.dao.factor;

import java.util.List;

import com.factoring.core.generic.GenericDao;
import com.factoring.web.model.factor.RepaymentPlan;

/**
 * 用户Dao接口
 * 
 * @author 
 *   上午11:49:57
 **/
public interface RepaymentPlanMapper extends GenericDao<RepaymentPlan, String> {

    int deleteByPrimaryKey(String id);

    int insert(RepaymentPlan record);

    int insertSelective(RepaymentPlan record);

    RepaymentPlan selectByPrimaryKey(String id);

    List<RepaymentPlan> selectAllRepaymentPlan(String panId);
    
    int updateByPrimaryKeySelective(RepaymentPlan record);
    
    List selectRepaymentPlanByState(String username);
    
}