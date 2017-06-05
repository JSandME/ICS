package com.factoring.web.service.factor;

import java.util.List;

import com.factoring.core.generic.GenericService;
import com.factoring.web.model.factor.RepaymentDetail;
import com.factoring.web.model.factor.RepaymentPlan;

/**
 * 用户 业务 接口
 * 
 * @author 
 *   上午11:53:33
 **/
public interface RepaymentPlanService extends GenericService<RepaymentPlan, String> {
	
	/**
     * 插入
     * @param record
     * @return
     */
    int insertSelective(RepaymentPlan repaymentPlan);

    /**
     * 查询所有的
     * @return
     */
    List<RepaymentPlan> selectAllRepaymentPlan(String username);
    
    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(RepaymentPlan record);
    
    /**
     * 删除
     * @param record
     * @return
     */
    int deleteByPrimaryKey(String id);
    
    /**
     * 
     * @param record
     * @return
     */
    RepaymentDetail selectByPrimaryKey(String id);
}
