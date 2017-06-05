package com.factoring.web.dao.factor;

import java.util.List;

import com.factoring.core.generic.GenericDao;
import com.factoring.web.model.factor.Product;
import com.factoring.web.model.factor.RepaymentDetail;

/**
 * 用户Dao接口
 * 
 * @author 
 *   上午11:49:57
 **/
public interface RepaymentDetailMapper extends GenericDao<RepaymentDetail, String> {

    int deleteByPrimaryKey(String id);

    int insert(RepaymentDetail record);

    int insertSelective(RepaymentDetail record);

    RepaymentDetail selectByPrimaryKey(String id);

    List<RepaymentDetail> selectAllRepaymentDetail(String panId);
    
    int updateByPrimaryKeySelective(RepaymentDetail record);
    
}