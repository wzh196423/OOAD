package fdu14ss.ooad.service;

import fdu14ss.ooad.entity.CheckTemplate;

import java.util.Date;

/**
 * Created by handsome on 2017/6/18.
 */
public interface ICheckPlanService {

    public void createPlan(CheckTemplate template, Date begin_date, Date ddl, String plan_src);

}
