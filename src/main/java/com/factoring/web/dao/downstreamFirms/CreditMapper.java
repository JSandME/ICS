package com.factoring.web.dao.downstreamFirms;

import java.util.Map;

import com.factoring.core.generic.GenericDao;
import com.factoring.web.model.downstreamFirms.Credit;

/**
 * 用户Dao接口
 * 
 * @author 
 *   上午11:49:57
 **/
public interface CreditMapper extends GenericDao<Credit, String> {

    int deleteByPrimaryKey(String id);

    int insert(Credit record);

    int insertSelective(Credit record);

    Credit selectByPrimaryKey(String id);

    Credit selectCreditByUserName(String username);
    
    int updateByPrimaryKeySelective(Credit record);
    
}