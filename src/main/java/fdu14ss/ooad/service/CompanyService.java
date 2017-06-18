package fdu14ss.ooad.service;

import fdu14ss.ooad.dao.CheckTaskDao;
import fdu14ss.ooad.dao.CheckTaskItemDao;
import fdu14ss.ooad.entity.CheckTask;
import fdu14ss.ooad.entity.CheckTaskItem;
import fdu14ss.ooad.entity.Company;
import fdu14ss.ooad.entity.enums.ItemStatus;
import fdu14ss.ooad.entity.enums.TaskStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by wangziheng on 2017/6/18.
 */
@Service
@Transactional
public class CompanyService implements ICompanyService {

    @Autowired
    CheckTaskItemDao checkTaskItemDao;

    @Autowired
    CheckTaskDao checkTaskDao;

    @Override
    public void changeTaskItemStatus(CheckTaskItem item, ItemStatus status){
        if (item.getStatus() == ItemStatus.Empty) {
            item.setStatus(status);
            checkTaskItemDao.save(item);
        }
        List<CheckTaskItem> all = checkTaskItemDao.findAllByCheckTask(item.getCheckTask());
        for (CheckTaskItem i : all) {
            if (i.getStatus() == ItemStatus.Empty)
                return;
        }
        // 该task下所有的task item都已经录入完毕
        item.getCheckTask().setStatus(TaskStatus.Checked);
        checkTaskDao.save(item.getCheckTask());
    }

    @Override
    public List<CheckTaskItem> getAllTaskItem(Company company){
        Set<CheckTask> tasks = company.getTask_set();
        List<CheckTaskItem> result = new ArrayList<>();
        for(CheckTask t : tasks){
            result.addAll(checkTaskItemDao.findAllByCheckTask(t));
        }
        return result;
    }

}
