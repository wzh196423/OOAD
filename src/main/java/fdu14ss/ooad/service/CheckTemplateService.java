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
    public CheckTemplate createTemplate(String name, String description, Set<CheckTemplateItem> items) {
        /*
        if(checkTemplateDao.findCheckTemplatesByNameEquals(name) != null) {

            System.out.println("tempalte already exist");

            return ;
        }
        */
        CheckTemplate checkTemplate = new CheckTemplate(name, description);

        checkTemplate.setItem_set(items);

        return checkTemplateDao.save(checkTemplate);
    }

    @Override
    public void addItems(CheckTemplate template, Set<CheckTemplateItem> items) {
        /*
        CheckTemplate checkTemplate = checkTemplateDao.getOne(template_id);

        if(checkTemplate == null) {

            System.out.println("template doesn't exist");

            return;

        }
        */
        Set<CheckTemplateItem> itemSet = template.getItem_set();

        itemSet.addAll(items);

        template.setItem_set(itemSet);

        checkTemplateDao.save(template);

    }

    @Override
    public void addOneItem(CheckTemplate template , CheckTemplateItem item){
        Set<CheckTemplateItem> itemSet = template.getItem_set();

        itemSet.add(item);

        template.setItem_set(itemSet);

        checkTemplateDao.save(template);
    }

    @Override
    public List<CheckTemplate> searchTemplate(String key) {

        return checkTemplateDao.findCheckTemplatesByDescriptionContainingOrNameContaining(key,key);

    }

}
