package fdu14ss.ooad.serviceTest;

import fdu14ss.ooad.dao.*;
import fdu14ss.ooad.entity.*;
import fdu14ss.ooad.entity.enums.Category;
import fdu14ss.ooad.entity.enums.Industry;
import fdu14ss.ooad.entity.enums.ItemStatus;
import fdu14ss.ooad.entity.enums.TaskStatus;
import fdu14ss.ooad.service.ICheckTaskService;
import fdu14ss.ooad.service.ICompanyService;
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

import static org.junit.Assert.*;

/**
 * Created by wangziheng on 2017/6/20.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyServiceTest {

    @Autowired
    private ICompanyService companyService;
    @Autowired
    private ICheckTaskService checkTaskService;
    @Autowired
    private CheckTemplateDao checkTemplateDao;
    @Autowired
    private CheckTemplateItemDao checkTemplateItemDao;
    @Autowired
    private CheckPlanDao checkPlanDao;
    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private CheckTaskDao checkTaskDao;
    @Autowired
    private CheckTaskItemDao checkTaskItemDao;

    @Before
    public void setUp() throws Exception {
        // 为了测试changeTaskItemStatus()，首先要给公司分发一个plan，否则公司没有taskItem
        // 首先创建模板并添加item
        CheckTemplate template = new CheckTemplate("temp","test_temp");
        CheckTemplateItem item = new CheckTemplateItem("item","test");
        checkTemplateItemDao.save(item);
        Set<CheckTemplateItem> set = new HashSet<>();
        set.add(item);
        template.setItem_set(set);
        checkTemplateDao.save(template);
        // 再用这个模板来初始化一个plan
        Date date = new Date(2017,6,20);
        CheckPlan plan = new CheckPlan(template, date, date, "plan0");
        checkPlanDao.save(plan);
        // 再创建一个公司
        Company company = new Company("fdu", Category.ProductionAndProcession, Industry.Metal);
        companyDao.save(company);
        // 将plan发给公司，注意此处用了一个自己的实现，所以要检测
        checkTaskService.sendPlan(company,plan);
        assertEquals(1,company.getTask_set().size());
        assertEquals(1,company.getTask_set().iterator().next().getCheckPlan().getTemplate().getItem_set().size());

    }



    @Test
    public void changeTaskItemStatus() throws Exception {
        Company company = companyDao.findCompaniesByName("fdu").get(0);
        CheckTask task = company.getTask_set().iterator().next();
        CheckTaskItem taskItem = checkTaskItemDao.findAllByCheckTask(task).get(0);
        companyService.changeTaskItemStatus(taskItem, ItemStatus.Qualified);
        // 再从数据库里读，看看这个taskItem的状态是否改变了
        assertEquals(ItemStatus.Qualified.toString(),checkTaskItemDao.findAllByCheckTask(companyDao.findCompaniesByName("fdu").get(0).getTask_set().iterator().next()).get(0).getStatus().toString());
        // 因为这个task只有一个taskItem，所以此时整个task都应该完成了
        assertEquals(TaskStatus.Checked.toString(),companyDao.findCompaniesByName("fdu").get(0).getTask_set().iterator().next().getStatus().toString());
    }

    @Test
    public void getAllTaskItem() throws Exception {
        Company company = companyDao.findCompaniesByName("fdu").get(0);
        assertEquals(1,companyService.getAllTaskItem(company).size());
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