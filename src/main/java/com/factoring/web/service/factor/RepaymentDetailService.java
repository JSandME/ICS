package com.factoring.web.service.factor;

import java.util.List;

import com.factoring.core.generic.GenericService;
import com.factoring.web.model.factor.Product;
import com.factoring.web.model.factor.RepaymentDetail;

/**
 * 用户 业务 接口
 * 
 * @author 
 *   上午11:53:33
 **/
public interface RepaymentDetailService extends GenericService<RepaymentDetail, String> {
	
	/**
     * 插入
     * @param record
     * @return
     */
    int insertSelective(RepaymentDetail product);

    /**
     * 查询所有的
     * @return
     */
    List<RepaymentDetail> selectAllRepaymentDetail(String username);
    
    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(RepaymentDetail record);
    
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
