package fdu14ss.ooad.service;

import fdu14ss.ooad.dao.CheckPlanDao;
import fdu14ss.ooad.dao.CheckTaskDao;
import fdu14ss.ooad.dao.CompanyDao;
import fdu14ss.ooad.entity.CheckPlan;
import fdu14ss.ooad.entity.CheckTemplate;
import fdu14ss.ooad.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by handsome on 2017/6/18.
 */
@Service
@Transactional
public class CheckPlanService implements ICheckPlanService{

    @Autowired
    CheckPlanDao checkPlanDao;

    @Override
    public CheckPlan createPlan(CheckTemplate template, Date begin_date, Date ddl, String name) {

        if(checkPlanDao.findCheckPlansByName(name).size() > 0) {

            System.out.println("plan already exist");

            return null;
        }

        CheckPlan checkPlan = new CheckPlan(template, begin_date, ddl, name);

        return checkPlanDao.save(checkPlan);

    }

    @Override
    public List<CheckPlan> searchPlan(String key){
        return checkPlanDao.findCheckPlansByNameContaining(key);
    }

}
