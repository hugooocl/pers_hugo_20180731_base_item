package dao.impl;

import dao.BaseDao;
import org.springframework.stereotype.Repository;
import pojo.Base;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class BaseDaoImpl implements BaseDao {

    @PersistenceContext(name = "em")
    private EntityManager manager;


    @Override
    public Base addBase(Base base) {
        manager.persist(base);
        return base;
    }

    @Override
    public List<Base> findAllBase() {
        String jpql = "from Base";
        List<Base> bases = manager
                .createQuery(jpql)
                .getResultList();
        return bases;
    }

    @Override
    public void delete(String id) {
        Base base = manager.getReference(Base.class, id);
        manager.remove(base);
    }
}
