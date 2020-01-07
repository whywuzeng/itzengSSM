package com.itzeng.ssm.service.impl;

import com.itzeng.ssm.dao.ISysLogDao;
import com.itzeng.ssm.domain.SysLog;
import com.itzeng.ssm.service.ISysLogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2020/1/7.
 * <p>
 * by author wz
 * <p>
 * com.itzeng.ssm.service.impl
 */
@Service
public class SysLogServiceImpl implements ISysLogService {

    @Autowired
    private ISysLogDao iSysLogDao;

    @Override
    public void save(SysLog sysLog) {
        iSysLogDao.save(sysLog);
    }

    @Override
    public List<SysLog> findAll() {
        return iSysLogDao.findAll();
    }
}
