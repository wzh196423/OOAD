package fdu14ss.ooad.dao;

import fdu14ss.ooad.entity.CheckPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by handsome on 2017/6/18.
 */
public interface CheckPlanDao extends JpaRepository<CheckPlan, Long> {

    public List<CheckPlan> findCheckPlansByPlan_srcEquals(String key);

}
