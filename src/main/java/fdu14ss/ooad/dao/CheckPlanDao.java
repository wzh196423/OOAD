package fdu14ss.ooad.dao;

import fdu14ss.ooad.entity.CheckPlan;
import fdu14ss.ooad.entity.CheckTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by handsome on 2017/6/18.
 */
public interface CheckPlanDao extends JpaRepository<CheckPlan, Long> {

    List<CheckPlan> findCheckPlansByName(String name);
    // 根据模板查找使用这个模板的所有排查计划
    List<CheckPlan> findCheckPlansByTemplateEquals(CheckTemplate template);
}
