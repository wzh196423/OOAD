package fdu14ss.ooad.service;

import fdu14ss.ooad.entity.CheckPlan;
import fdu14ss.ooad.entity.CheckTemplate;
import fdu14ss.ooad.entity.Company;

import java.util.Date;

/**
 * Created by handsome on 2017/6/18.
 */
public interface ICheckPlanService {

    CheckPlan createPlan(CheckTemplate template, Date begin_date, Date ddl, String plan_src);

}
