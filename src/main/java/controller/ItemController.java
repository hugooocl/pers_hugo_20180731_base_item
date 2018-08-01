package controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pojo.Base;
import pojo.Item;
import service.BaseService;
import service.ItemService;

import java.util.List;

@RestController
@RequestMapping("item")
public class ItemController {
    @Autowired
    ItemService itemService;

    public List<Base> showAllBase() {
        return null;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public List<Item> addItem(@RequestBody Item item, String baseId) {
        itemService.addItem(item);
        return itemService.findAllByBaseId(baseId);
    }

    @ResponseBody
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public List<Item> deleteItem(@PathVariable String id) {
        System.out.println("delete :" + id);
        String baseId = itemService.delete(id);
        return itemService.findAllByBaseId(baseId);
    }

    @ResponseBody
    @RequestMapping(value = "{baseId}",method = RequestMethod.GET)
    public List<Item> findAllItemByBaseId(@PathVariable String baseId) {
        return itemService.findAllByBaseId(baseId);
    }
}
