package com.factoring.web.service.factor.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.factoring.core.generic.GenericDao;
import com.factoring.core.generic.GenericServiceImpl;
import com.factoring.web.dao.factor.ProductMapper;
import com.factoring.web.model.factor.Product;
import com.factoring.web.service.factor.ProductService;

@Service
public class ProductServiceImpl extends GenericServiceImpl<Product, String> implements ProductService {

	@Resource
	private ProductMapper productMapper;
	
	@Override
	public int insertSelective(Product product) {
		return productMapper.insertSelective(product);
	}

	@Override
	public List<Product> selectAllProduct(String username) {
		return productMapper.selectAllProduct(username);
	}

	@Override
	public int updateByPrimaryKeySelective(Product record) {
		return productMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int deleteByPrimaryKey(String id) {
		return productMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Product selectByPrimaryKey(String id) {
		return productMapper.selectByPrimaryKey(id);
	}

	@Override
	public GenericDao<Product, String> getDao() {
		return productMapper;
	}

}
