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

    @Autowired
    CheckTaskDao checkTaskDao;

    @Override
    public void sendPlan(Company company, CheckPlan plan){
        CheckTask task = new CheckTask(plan);
        //checkTaskDao.save(task);
        // 根据task和里面对应的模板项目，创建task item
        for (CheckTemplateItem i: plan.getTemplate().getItem_set()) {
            checkTaskItemDao.save(new CheckTaskItem(i,task));
        }

        Set<CheckTask> current_tasks = company.getTask_set();
        current_tasks.add(task);

        company.setTask_set(current_tasks);
        companyDao.save(company);
    }

}
