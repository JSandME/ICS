package com.factoring.web.service.factor;

import java.util.List;

import com.factoring.core.generic.GenericService;
import com.factoring.web.model.User;
import com.factoring.web.model.factor.Product;

/**
 * 用户 业务 接口
 * 
 * @author 
 *   上午11:53:33
 **/
public interface ProductService extends GenericService<Product, String> {
	
	/**
     * 插入
     * @param record
     * @return
     */
    int insertSelective(Product product);

    /**
     * 查询所有的
     * @return
     */
    List<Product> selectAllProduct(String username);
    
    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Product record);
    
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
    Product selectByPrimaryKey(String id);
    
    /**
     * 根据金额匹配产品
     * @return
     */
    List<Product> selectProductsByAmt(String amt);
    
}
