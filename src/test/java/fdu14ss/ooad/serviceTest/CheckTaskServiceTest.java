package fdu14ss.ooad.serviceTest;

import fdu14ss.ooad.dao.*;
import fdu14ss.ooad.entity.*;
import fdu14ss.ooad.entity.enums.Category;
import fdu14ss.ooad.entity.enums.Industry;
import fdu14ss.ooad.entity.enums.TaskStatus;
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
    CheckTemplateItemDao checkTemplateItemDao;

    @Autowired
    CheckPlanDao checkPlanDao;

    @Autowired
    CheckTemplateDao checkTemplateDao;

    @Autowired
    CheckTaskDao checkTaskDao;

    @Autowired
    CheckTaskItemDao checkTaskItemDao;


    @Before
    public void setUp() throws Exception {
        // 创建一个模板
        CheckTemplate template = new CheckTemplate("template", "templateDescription233");
        // 给模板几个item
        CheckTemplateItem item0 = new CheckTemplateItem("item0","test0");
        checkTemplateItemDao.save(item0);
        CheckTemplateItem item1 = new CheckTemplateItem("item1","test1");
        checkTemplateItemDao.save(item1);
        Set<CheckTemplateItem> set = new HashSet<>();
        set.add(item0);
        set.add(item1);
        System.out.println("aaaaaaaaaaaaaaaaaaa"+set.size());
        template.setItem_set(set);
        checkTemplateDao.save(template);

        Date date = new Date(2017,6,20);

        // 用这个模板来初始化一个plan
        CheckPlan plan = new CheckPlan(template, date, date, "plan0");

        checkPlanDao.save(plan);

        // 初始化一个公司
        Company company = new Company("new company", Category.Sales, Industry.Food);
        companyDao.save(company);

    }

    @Test
    public void sendPlan() {

        // 得到初始化的plan
        CheckPlan plan = checkPlanDao.findCheckPlansByName("plan0").get(0);

        // 得到初始化的公司
        Company company = companyDao.findCompaniesByName("new company").get(0);

        iCheckTaskService.sendPlan(company, plan);

        //Set<CheckTask> resultTaskSet = iCheckTaskService.getTasksByCompanyId(company.getId());

        // 测试公司是否受到了这个task
        assertEquals (1, company.getTask_set().size());
        // 测试公司收到了这个task后，自己的task item数量，是不是等于这个task对应的plan对应的模板原有的item数量
        assertEquals (2, company.getTask_set().iterator().next().getCheckPlan().getTemplate().getItem_set().size());

    }

    @After
    public void tearDown() throws Exception {

        companyDao.deleteAll();

        checkTaskItemDao.deleteAll();

        checkTaskDao.deleteAll();

        checkTemplateDao.deleteAll();

        checkTemplateItemDao.deleteAll();
    }

}
