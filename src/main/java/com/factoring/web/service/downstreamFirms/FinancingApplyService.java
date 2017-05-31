package com.factoring.web.service.downstreamFirms;

import com.factoring.core.generic.GenericService;
import com.factoring.web.model.downstreamFirms.Credit;
import com.factoring.web.model.downstreamFirms.FinancingApply;

/**
 * 用户 业务 接口
 * 
 * @author 
 *   上午11:53:33
 **/
public interface FinancingApplyService extends GenericService<FinancingApply, String> {
	
	/**
     * 插入
     * @param record
     * @return
     */
    int insertSelective(FinancingApply apply);

    /**
     * 查询所有的
     * @return
     */
    FinancingApply selectFinancingApplyByUserName(String username);
    
    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(FinancingApply record);
    
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
    FinancingApply selectByPrimaryKey(String id);
    
}
