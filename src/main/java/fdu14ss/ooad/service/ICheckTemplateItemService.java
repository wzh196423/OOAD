package fdu14ss.ooad.service;

import fdu14ss.ooad.entity.CheckTemplateItem;

import java.util.List;

/**
 * Created by handsome on 2017/6/18.
 */
public interface ICheckTemplateItemService {

    public void addItem(String name, String description);

    public List<CheckTemplateItem> searchItem(String key);

}
