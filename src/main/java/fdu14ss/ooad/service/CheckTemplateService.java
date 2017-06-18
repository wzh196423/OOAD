package fdu14ss.ooad.service;

import fdu14ss.ooad.dao.CheckTemplateDao;
import fdu14ss.ooad.entity.CheckTemplate;
import fdu14ss.ooad.entity.CheckTemplateItem;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

/**
 * Created by handsome on 2017/6/18.
 */
public class CheckTemplateService implements ICheckTemplateService{

    @Autowired
    CheckTemplateDao checkTemplateDao;

    @Override
    public void createTemplate(String name, String description, Set<CheckTemplateItem> items) {

        if(checkTemplateDao.findCheckTemplatesByNameEquals(name) != null) {

            System.out.println("tempalte already exist");

            return;
        }

        CheckTemplate checkTemplate = new CheckTemplate(name, description);

        checkTemplate.setItem_set(items);

        checkTemplateDao.save(checkTemplate);
    }

    @Override
    public void saveTemplate(Long id, String name, String description, Set<CheckTemplateItem> items) {

        CheckTemplate checkTemplate = checkTemplateDao.getOne(id);

        if(checkTemplate == null) {

            System.out.println("template doesn't exist");

            return;

        }

        checkTemplate.setName(name);

        checkTemplate.setDescription(description);

        Set<CheckTemplateItem> itemSet = checkTemplate.getItem_set();

        itemSet.addAll(items);

        checkTemplate.setItem_set(itemSet);

        checkTemplateDao.save(checkTemplate);

    }

    @Override
    public List<CheckTemplate> searchTemplate(String key) {

        return checkTemplateDao.findCheckTemplatesByDescriptionContainingOrNameContaining(key);

    }

}
