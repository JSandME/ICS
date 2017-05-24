package com.factoring.web.dao.factor;

import java.util.List;

import com.factoring.core.generic.GenericDao;
import com.factoring.web.model.Role;
import com.factoring.web.model.factor.Product;

/**
 * 用户Dao接口
 * 
 * @author 
 *   上午11:49:57
 **/
public interface ProductMapper extends GenericDao<Product, String> {

    int deleteByPrimaryKey(String id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(String id);

    List<Product> selectAllProduct(String username);
    
    int updateByPrimaryKeySelective(Product record);
    
}