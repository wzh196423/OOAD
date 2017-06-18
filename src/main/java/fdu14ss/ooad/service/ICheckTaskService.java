package fdu14ss.ooad.service;

import fdu14ss.ooad.entity.CheckPlan;
import fdu14ss.ooad.entity.CheckTask;
import fdu14ss.ooad.entity.CheckTaskItem;
import fdu14ss.ooad.entity.Company;

import java.util.Set;

/**
 * Created by wangziheng on 2017/6/18.
 */
public interface ICheckTaskService {
    CheckTaskItem createTaskItem(CheckTask task);
    Set<CheckTask> getTasksByCompanyId(Long com_id);
    void sendPlan(Company company, CheckPlan plan);
}
