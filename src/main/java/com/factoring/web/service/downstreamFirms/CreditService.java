package com.factoring.web.service.downstreamFirms;

import java.util.List;

import com.factoring.core.generic.GenericService;
import com.factoring.web.model.downstreamFirms.Credit;
import com.factoring.web.model.factor.Product;

/**
 * 用户 业务 接口
 * 
 * @author 
 *   上午11:53:33
 **/
public interface CreditService extends GenericService<Credit, String> {
	
	/**
     * 插入
     * @param record
     * @return
     */
    int insertSelective(Credit credit);

    /**
     * 查询所有的
     * @return
     */
    Credit selectCreditByUserName(String username);
    
    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Credit record);
    
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
    Credit selectByPrimaryKey(String id);
    
}
