package fdu14ss.ooad.service;

import fdu14ss.ooad.dao.CheckPlanDao;
import fdu14ss.ooad.entity.CheckPlan;
import fdu14ss.ooad.entity.CheckTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Created by handsome on 2017/6/18.
 */
public class CheckPlanService implements ICheckPlanService{

    @Autowired
    CheckPlanDao checkPlanDao;

    @Override
    public void createPlan(CheckTemplate template, Date begin_date, Date ddl, String name) {

        if(checkPlanDao.findCheckPlansByName(name) != null) {

            System.out.println("plan already exist");

            return;
        }

        CheckPlan checkPlan = new CheckPlan(template, begin_date, ddl, name);

        checkPlanDao.save(checkPlan);

    }

}
