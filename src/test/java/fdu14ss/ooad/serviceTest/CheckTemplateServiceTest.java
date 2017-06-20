package fdu14ss.ooad.serviceTest;

import fdu14ss.ooad.dao.CheckTemplateDao;
import fdu14ss.ooad.dao.CheckTemplateItemDao;
import fdu14ss.ooad.entity.CheckTemplate;
import fdu14ss.ooad.entity.CheckTemplateItem;
import fdu14ss.ooad.service.ICheckTemplateService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by handsome on 2017/6/18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CheckTemplateServiceTest {

    @Autowired
    ICheckTemplateService iCheckTemplateService;

    @Autowired
    CheckTemplateDao checkTemplateDao;

    @Autowired
    CheckTemplateItemDao checkTemplateItemDao;

    @Before
    public void setUp() throws Exception {

        CheckTemplate checkTemplate = new CheckTemplate("templateServiceTest0", "templateServiceTest Description233");

        checkTemplateDao.save(checkTemplate);

    }

    @Test
    public void createTemplate() {

        CheckTemplateItem checkTemplateItem = new CheckTemplateItem("item", "description");

        Set<CheckTemplateItem> checkTemplateItems = new HashSet<CheckTemplateItem>();

        checkTemplateItems.add(checkTemplateItem);

        iCheckTemplateService.createTemplate("templateServiceTest1", "templateDesciptionTest1", checkTemplateItems);

        assertEquals (2, checkTemplateDao.findAll().size());

    }

    @Test
    public void addItems() {

        Set<CheckTemplateItem> checkTemplateItems = new HashSet<CheckTemplateItem>();

        CheckTemplateItem checkTemplateItem = new CheckTemplateItem("item", "description");

        checkTemplateItemDao.save(checkTemplateItem);

        checkTemplateItems.add(checkTemplateItem);

        CheckTemplateItem checkTemplateItem1 = new CheckTemplateItem("item1", "description1234");

        checkTemplateItemDao.save(checkTemplateItem1);

        checkTemplateItems.add(checkTemplateItem1);

        CheckTemplate checkTemplate = new CheckTemplate("templateServiceTest2", "templateServiceTest2 Description233");

        checkTemplateDao.save(checkTemplate);

        iCheckTemplateService.addItems(checkTemplate, checkTemplateItems);

        assertEquals (2, checkTemplateDao.findCheckTemplatesByName("templateServiceTest2").get(0).getItem_set().size());

    }

    @Test
    public void addOneItem() {

        CheckTemplateItem checkTemplateItem = new CheckTemplateItem("item", "description");

        checkTemplateItemDao.save(checkTemplateItem);

        CheckTemplate checkTemplate = new CheckTemplate("templateServiceTest3", "templateServiceTest3 Description233");

        checkTemplateDao.save(checkTemplate);

        iCheckTemplateService.addOneItem(checkTemplate, checkTemplateItem);

        Set<CheckTemplateItem> items = checkTemplateDao.findCheckTemplatesByName("templateServiceTest3").get(0).getItem_set();

        assertEquals (1, items.size());
    }

    @Test
    public void searchTemplate() {

        assertEquals (1, iCheckTemplateService.searchTemplate("template").size());

    }

    @After
    public void tearDown() throws Exception {

        checkTemplateDao.deleteAll();

        checkTemplateItemDao.deleteAll();

    }

}
