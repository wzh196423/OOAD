package fdu14ss.ooad.dao;

import fdu14ss.ooad.entity.CheckTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by handsome on 2017/6/18.
 */
@Repository
public interface CheckTemplateDao extends JpaRepository<CheckTemplate, Long> {

    List<CheckTemplate> findCheckTemplatesByDescriptionContainingOrNameContaining(String description, String name);

    List<CheckTemplate> findCheckTemplatesByName(String name);
}
