package dao.impl;

import dao.ItemDao;
import org.springframework.stereotype.Repository;
import pojo.Item;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ItemDaoImpl implements ItemDao {

    @PersistenceContext(name = "em")
    private EntityManager manager;

    @Override
    public Item addItem(Item item) {
        manager.persist(item);
        return item;
    }

    @Override
    public List<Item> findAllByBaseId(String id) {
        String jpql = "from Item where b_id = ?";
        List<Item> items = manager
                .createQuery(jpql)
                .setParameter(1, id)
                .getResultList();
        return items;
    }

    @Override
    public String delete(String id) {
        System.out.println("delete" +id);
        Item item = manager.getReference(Item.class, id);
        item.getBase().getItems().remove(item);
        String baseId = item.getBase().getId();
        manager.remove(item);
        return baseId;
    }
}
