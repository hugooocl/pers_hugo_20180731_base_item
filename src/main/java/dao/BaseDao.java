package dao;

import pojo.Base;

import java.util.List;

public interface BaseDao {
    public Base addBase(Base base);

    List<Base> findAllBase();

    void delete(String id);
}
