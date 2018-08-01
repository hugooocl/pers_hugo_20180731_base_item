package service;

import pojo.Base;

import java.util.List;

public interface BaseService {
    public Base addBase(Base base);

    List<Base>  findAllBase();

    void delete(String id);
}
