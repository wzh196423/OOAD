package fdu14ss.ooad.serviceTest;

import fdu14ss.ooad.dao.CheckPlanDao;
import fdu14ss.ooad.dao.CheckTemplateDao;
import fdu14ss.ooad.entity.CheckPlan;
import fdu14ss.ooad.entity.CheckTemplate;
import fdu14ss.ooad.service.ICheckPlanService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Created by handsome on 2017/6/19.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CheckPlanServiceTest {

    @Autowired
    ICheckPlanService iCheckPlanService;

    @Autowired
    CheckPlanDao checkPlanDao;

    @Autowired
    CheckTemplateDao checkTemplateDao;

    @Before
    public void setUp() throws Exception {
        // 初始化操作，先在数据库中创建模板和plan

        CheckTemplate template = new CheckTemplate("template", "templateDescription233");

        Date date = new Date(2017,6,20);

        checkTemplateDao.save(template);

        CheckPlan plan = new CheckPlan(template, date, date, "plan0");

        checkPlanDao.save(plan);
    }

    @Test
    public void createPlan() {
        // 为这个业务逻辑先创建一个模板
        CheckTemplate template = new CheckTemplate("template1", "templateDescription233");

        Date date = new Date(2017,6,20);

        checkTemplateDao.save(template);
        // 实际测试
        iCheckPlanService.createPlan(template, date, date, "plan1");
        // 因为初始化也创建了plan，所以expect 2
        assertEquals (2, checkPlanDao.findAll().size());

    }

    @Test
    public void searchPlan() {

        assertEquals (1, iCheckPlanService.searchPlan("plan").size());

    }

    @After
    public void tearDown() throws Exception {

        checkPlanDao.deleteAll();

        checkTemplateDao.deleteAll();

    }

}
