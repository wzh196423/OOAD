package fdu14ss.ooad.service;

import fdu14ss.ooad.dao.CheckTaskDao;
import fdu14ss.ooad.dao.CheckTaskItemDao;
import fdu14ss.ooad.dao.CompanyDao;
import fdu14ss.ooad.entity.*;
import fdu14ss.ooad.entity.enums.ItemStatus;
import fdu14ss.ooad.entity.enums.TaskStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Set;

/**
 * Created by wangziheng on 2017/6/18.
 */
@Service
@Transactional
public class CheckTaskService implements ICheckTaskService{
    @Autowired
    CompanyDao companyDao;

    @Autowired
    CheckTaskItemDao checkTaskItemDao;

    @Override
    public Set<CheckTask> getTasksByCompanyId(Long com_id){
        Company company = companyDao.getOne(com_id);
        return company.getTask_set();
    }

    @Override
    public void sendPlan(Company company, CheckPlan plan, Date finish_time, TaskStatus status){
        CheckTask task = new CheckTask(plan, finish_time, status);
        // 根据task和里面对应的模板项目，创建task item
        for (CheckTemplateItem i: plan.getTemplate().getItem_set()) {
            checkTaskItemDao.save(new CheckTaskItem(i,task));
        }
        Set<CheckTask> current_tasks = company.getTask_set();
        current_tasks.add(task);

        //???这里没有问题吗？task只是存到了current_tasks里面，但是没有存到公司里面
        company.setTask_set(current_tasks);
        companyDao.save(company);
    }

}
