package service.impl;

import dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pojo.Base;
import service.BaseService;

import java.util.List;

@Service
public class BaseServiceImpl implements BaseService {
    @Autowired
    BaseDao baseDao;

    @Transactional
    @Override
    public Base addBase(Base base) {
        return baseDao.addBase(base);
    }

    @Transactional
    @Override
    public List<Base> findAllBase() {
        return baseDao.findAllBase();
    }

    @Transactional
    @Override
    public void delete(String id) {
        baseDao.delete(id);
    }
}
