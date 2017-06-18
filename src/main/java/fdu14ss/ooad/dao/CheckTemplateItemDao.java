package fdu14ss.ooad.dao;

import fdu14ss.ooad.entity.CheckTemplateItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wangziheng on 2017/6/17.
 */
public interface CheckTemplateItemDao extends JpaRepository<CheckTemplateItem, Long> {

    public List<CheckTemplateItem> findCheckTemplateItemsByNameEquals(String key);

    public List<CheckTemplateItem> findCheckTemplateItemsByDescriptionContainingOrNameContaining(String description, String name);

    public List<CheckTemplateItem> findCheckTemplateItemsByDescriptionContaining(String key);
}



