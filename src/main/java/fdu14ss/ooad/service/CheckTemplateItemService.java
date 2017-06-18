package fdu14ss.ooad.service;

import fdu14ss.ooad.dao.CheckTemplateItemDao;
import fdu14ss.ooad.entity.CheckTemplateItem;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by handsome on 2017/6/18.
 */
public class CheckTemplateItemService implements ICheckTemplateItemService {

    @Autowired
    CheckTemplateItemDao checkTemplateItemDao;

    @Override
    public CheckTemplateItem createItem(String name, String description) {

        if(checkTemplateItemDao.findCheckTemplateItemsByNameEquals(name) != null) {

            System.out.println("item already exist");

            return null;
        }

        CheckTemplateItem checkTemplateItem = new CheckTemplateItem(name, description);

        return checkTemplateItemDao.saveAndFlush(checkTemplateItem);

    }

    @Override
    public List<CheckTemplateItem> searchItem(String key) {

        return checkTemplateItemDao.findCheckTemplateItemsByDescriptionContainingOrNameContaining(key,key);

    }
}
