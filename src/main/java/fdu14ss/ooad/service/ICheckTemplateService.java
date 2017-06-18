package fdu14ss.ooad.service;

import fdu14ss.ooad.entity.CheckTemplate;
import fdu14ss.ooad.entity.CheckTemplateItem;

import java.util.List;
import java.util.Set;

/**
 * Created by handsome on 2017/6/18.
 */
public interface ICheckTemplateService {

    public void createTemplate(String name, String description, Set<CheckTemplateItem> items) ;

    public void saveTemplate(Long id, String name, String description, Set<CheckTemplateItem> items) ;

    public List<CheckTemplate> searchTemplate(String key);
}
