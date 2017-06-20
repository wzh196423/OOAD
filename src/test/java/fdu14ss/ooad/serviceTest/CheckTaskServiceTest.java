package fdu14ss.ooad.serviceTest;

import fdu14ss.ooad.dao.CheckPlanDao;
import fdu14ss.ooad.dao.CheckTaskDao;
import fdu14ss.ooad.dao.CheckTemplateDao;
import fdu14ss.ooad.dao.CompanyDao;
import fdu14ss.ooad.entity.CheckPlan;
import fdu14ss.ooad.entity.CheckTask;
import fdu14ss.ooad.entity.CheckTemplate;
import fdu14ss.ooad.entity.Company;
import fdu14ss.ooad.entity.enums.Category;
import fdu14ss.ooad.entity.enums.Industry;
import fdu14ss.ooad.entity.enums.TaskStatus;
import fdu14ss.ooad.service.ICheckPlanService;
import fdu14ss.ooad.service.ICheckTaskService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by handsome on 2017/6/19.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CheckTaskServiceTest {

    @Autowired
    ICheckTaskService iCheckTaskService;

    @Autowired
    CompanyDao companyDao;

    @Autowired
    CheckTaskDao checkTaskDao;

    @Autowired
    CheckPlanDao checkPlanDao;

    @Autowired
    CheckTemplateDao checkTemplateDao;


    @Before
    public void setUp() throws Exception {
//
//        CheckTemplate template = new CheckTemplate("template", "templateDescription233");
//
//        Date date = new Date(2017,6,20);
//
//        CheckPlan plan = new CheckPlan(template, date, date, "plan0");

    }

    @Test
    public void getTaskByCompanyId() {

        // 新建checkTask
        CheckTemplate template = new CheckTemplate("template", "templateDescription233");

        Date date = new Date(2017,6,20);

        checkTemplateDao.save(template);

        CheckPlan plan = new CheckPlan(template, date, date, "plan0");

        checkPlanDao.save(plan);

        CheckTask checkTask = new CheckTask();

        checkTask.setCheckPlan(plan);

        checkTask.setFinish_time(date);

        checkTask.setStatus(TaskStatus.Checking);

        //存储checkTask
        checkTaskDao.save(checkTask);

        Set<CheckTask> checkTaskSet = new HashSet<CheckTask>();

        checkTaskSet.add(checkTask);

        //新建company
        Company company = new Company("new company", Category.Sales, Industry.Food);

        company.setTask_set(checkTaskSet);

        companyDao.save(company);

        Set<CheckTask> resultTaskSet = iCheckTaskService.getTasksByCompanyId(company.getId());

        assertEquals (1, resultTaskSet.size());

    }

    @Test
    public void sendPlan() {

        // 新建checkTask
        CheckTemplate template = new CheckTemplate("template", "templateDescription233");

        Date date = new Date(2017,6,20);

        checkTemplateDao.save(template);

        CheckPlan plan = new CheckPlan(template, date, date, "plan1");

        checkPlanDao.save(plan);

        //新建company
        Company company = new Company("new company", Category.Sales, Industry.Food);

        companyDao.save(company);

        iCheckTaskService.sendPlan(company, plan, date, TaskStatus.Checking);

        Set<CheckTask> resultTaskSet = iCheckTaskService.getTasksByCompanyId(company.getId());

        assertEquals (1, resultTaskSet.size());

    }

    @After
    public void tearDown() throws Exception {

        checkTaskDao.deleteAll();

        checkPlanDao.deleteAll();

        checkTemplateDao.deleteAll();

    }

}
