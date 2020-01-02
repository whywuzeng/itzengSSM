package com.itzeng.ssm.service;

import com.itzeng.ssm.domain.Product;

import java.util.List;

/**
 * Created by Administrator on 2019/12/31.
 * <p>
 * by author wz
 * <p>
 * com.itzeng.ssm.service
 */

public interface IProductService {
    List<Product> findAll();

    void save(Product product);
}
