package controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pojo.Base;
import service.BaseService;

import java.util.List;

@RestController
@RequestMapping("base")
public class BaseController {
    @Autowired
    BaseService baseService;

    public List<Base> showAllBase() {
        return null;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public List<Base> addBase(@RequestBody Base base) {
        baseService.addBase(base);
        return baseService.findAllBase();
    }

    @ResponseBody
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public List<Base> deleteBase(@PathVariable String id) {
        System.out.println("delete :" + id);
        baseService.delete(id);
        return baseService.findAllBase();
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public List<Base> findAllBase() {
        return baseService.findAllBase();
    }
}
