package fdu14ss.ooad.service;

import fdu14ss.ooad.entity.CheckTemplateItem;

import java.util.List;

/**
 * Created by handsome on 2017/6/18.
 */
public interface ICheckTemplateItemService {

<<<<<<< HEAD
    public void createItem(String name, String description);
=======
    CheckTemplateItem createItem(String name, String description);
>>>>>>> a9cdc73cd64ec1bc77138bc20922c085cb908d79

    List<CheckTemplateItem> searchItem(String key);

}
