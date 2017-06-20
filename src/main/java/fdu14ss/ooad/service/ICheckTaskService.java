package fdu14ss.ooad.service;

import fdu14ss.ooad.entity.*;
import fdu14ss.ooad.entity.enums.ItemStatus;
import fdu14ss.ooad.entity.enums.TaskStatus;

import java.util.Date;
import java.util.Set;

/**
 * Created by wangziheng on 2017/6/18.
 */
public interface ICheckTaskService {
    Set<CheckTask> getTasksByCompanyId(Long com_id);
    void sendPlan(Company company, CheckPlan plan, Date date, TaskStatus checking);
}
