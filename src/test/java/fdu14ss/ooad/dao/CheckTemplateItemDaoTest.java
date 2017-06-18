package fdu14ss.ooad.dao;

import fdu14ss.ooad.entity.CheckTemplateItem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by wangziheng on 2017/6/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CheckTemplateItemDaoTest {

    @Autowired
    CheckTemplateItemDao checkTemplateItemDao;

    @Before
    public void setUp() throws Exception {
        CheckTemplateItem item = new CheckTemplateItem("Test1", "Test Description233");
        checkTemplateItemDao.save(item);
    }

    @After
    public void tearDown() throws Exception {
        checkTemplateItemDao.deleteAll();
    }

    @Test
    public void save() {


    }

    @Test
    public void findCheckTemplateItemsByDescriptionContaining() {
        List<CheckTemplateItem> items = checkTemplateItemDao.findCheckTemplateItemsByDescriptionContaining("233");
        assertEquals(1, items.size());
        assertEquals("Test1", items.get(0).getName());
    }

}