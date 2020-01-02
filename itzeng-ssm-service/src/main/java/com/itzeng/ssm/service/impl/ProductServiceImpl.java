package com.itzeng.ssm.service.impl;

import com.itzeng.ssm.dao.IProductDao;
import com.itzeng.ssm.domain.Product;
import com.itzeng.ssm.service.IProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2019/12/31.
 * <p>
 * by author wz
 * <p>
 * com.itzeng.ssm.service.impl
 */
@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao iProductDao;

    @Override
    public List<Product> findAll() {
        return iProductDao.findAll();
    }

    @Override
    public void save(Product product) {
        iProductDao.save(product);
    }
}
