package dao;

import pojo.Base;
import pojo.Item;

import java.util.List;

public interface ItemDao {
    public Item addItem(Item item);

    List<Item> findAllByBaseId(String id);

    String delete(String id);
}
