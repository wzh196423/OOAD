package fdu14ss.ooad.service;

import fdu14ss.ooad.dao.CheckTemplateItemDao;
import fdu14ss.ooad.entity.CheckTemplateItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by handsome on 2017/6/18.
 */
@Service
@Transactional
public class CheckTemplateItemService implements ICheckTemplateItemService {

    @Autowired
    CheckTemplateItemDao checkTemplateItemDao;

    @Override
    public CheckTemplateItem createItem(String name, String description) {

        System.out.println("hahaha1");

        if(checkTemplateItemDao.findCheckTemplateItemsByName(name).size() != 0) {

            System.out.println("item already exist");

            return null;
        }

        CheckTemplateItem checkTemplateItem = new CheckTemplateItem(name, description);

        checkTemplateItemDao.save(checkTemplateItem);

        return checkTemplateItem;

    }

    @Override
    public List<CheckTemplateItem> searchItem(String key) {

        return checkTemplateItemDao.findCheckTemplateItemsByDescriptionContainingOrNameContaining(key,key);

    }
}
