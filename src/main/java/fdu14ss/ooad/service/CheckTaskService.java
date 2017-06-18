package fdu14ss.ooad.service;

import fdu14ss.ooad.dao.CheckTaskDao;
import fdu14ss.ooad.dao.CheckTaskItemDao;
import fdu14ss.ooad.dao.CompanyDao;
import fdu14ss.ooad.entity.*;
import fdu14ss.ooad.entity.enums.ItemStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public void sendPlan(Company company, CheckPlan plan){
        CheckTask task = new CheckTask(plan);
        // 根据task和里面对应的模板项目，创建task item
        for (CheckTemplateItem i: plan.getTemplate().getItem_set()) {
            checkTaskItemDao.save(new CheckTaskItem(i,task));
        }
        Set<CheckTask> current_tasks = company.getTask_set();
        current_tasks.add(task);
        companyDao.save(company);
    }

}
