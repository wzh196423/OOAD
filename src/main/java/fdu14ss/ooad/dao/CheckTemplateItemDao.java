package fdu14ss.ooad.dao;

import fdu14ss.ooad.entity.CheckTemplateItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by wangziheng on 2017/6/17.
 */
public interface CheckTemplateItemDao extends JpaRepository<CheckTemplateItem, Long> {

    public List<CheckTemplateItem> findCheckTemplateItemsByDescriptionContaining(String key);

}
