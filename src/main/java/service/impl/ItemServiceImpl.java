package service.impl;

import dao.ItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pojo.Item;
import service.ItemService;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemDao itemDao;

    @Transactional
    @Override
    public Item addItem(Item item) {
        return itemDao.addItem(item);
    }

    @Transactional
    @Override
    public List<Item> findAllByBaseId(String id) {
        return itemDao.findAllByBaseId(id);
    }

    @Transactional
    @Override
    public String delete(String id) {
        return itemDao.delete(id);
    }
}
