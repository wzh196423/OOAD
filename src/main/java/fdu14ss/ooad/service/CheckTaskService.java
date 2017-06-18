package fdu14ss.ooad.service;

import fdu14ss.ooad.dao.CheckTaskDao;
import fdu14ss.ooad.dao.CheckTaskItemDao;
import fdu14ss.ooad.dao.CompanyDao;
import fdu14ss.ooad.entity.CheckPlan;
import fdu14ss.ooad.entity.CheckTask;
import fdu14ss.ooad.entity.CheckTaskItem;
import fdu14ss.ooad.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * Created by wangziheng on 2017/6/18.
 */
public class CheckTaskService implements ICheckTaskService{
    @Autowired
    CompanyDao companyDao;

    @Autowired
    CheckTaskItemDao checkTaskItemDao;

    @Override
    public CheckTaskItem createTaskItem(CheckTask task){
        CheckTaskItem item = new CheckTaskItem(task);
        return checkTaskItemDao.save(item);
    }

    @Override
    public Set<CheckTask> getTasksByCompanyId(Long com_id){
        Company company = companyDao.getOne(com_id);
        return company.getTask_set();
    }

    @Override
    public void sendPlan(Company company, CheckPlan plan){
        CheckTask task = new CheckTask(plan);
        Set<CheckTask> current_tasks = company.getTask_set();
        current_tasks.add(task);
        companyDao.save(company);
    }

}
