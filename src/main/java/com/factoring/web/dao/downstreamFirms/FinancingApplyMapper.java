package com.factoring.web.dao.downstreamFirms;

import java.util.List;
import java.util.Map;

import com.factoring.core.generic.GenericDao;
import com.factoring.web.model.downstreamFirms.FinancingApply;

/**
 * 用户Dao接口
 * 
 * @author 
 *   上午11:49:57
 **/
public interface FinancingApplyMapper extends GenericDao<FinancingApply, String> {

    int deleteByPrimaryKey(String id);

    int insert(FinancingApply record);

    int insertSelective(FinancingApply record);

    FinancingApply selectByPrimaryKey(String id);

    List<FinancingApply> selectFinancingApplyByUserName(String username);
    
    int updateByPrimaryKeySelective(FinancingApply record);
    
    List<FinancingApply> selectFinancingApplyByState(Map map);
    
}