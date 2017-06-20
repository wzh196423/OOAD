package fdu14ss.ooad.serviceTest;

import fdu14ss.ooad.dao.CheckTemplateItemDao;
import fdu14ss.ooad.entity.CheckTemplateItem;
import fdu14ss.ooad.service.ICheckTemplateItemService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by handsome on 2017/6/18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CheckTemplateItemServiceTest {

    @Autowired
    ICheckTemplateItemService iCheckTemplateItemService;

    @Autowired
    CheckTemplateItemDao checkTemplateItemDao;

    @Before
    public void setUp() throws Exception {
        // 初始化一个item用于测试查找业务
        CheckTemplateItem item = new CheckTemplateItem("itemServiceTest0", "itemServiceTest Description233");

        checkTemplateItemDao.save(item);

    }

    @Test
    public void createItem() {

        iCheckTemplateItemService.createItem("itemServiceTest1", "itemServiceTest Description233");

        assertEquals (2, checkTemplateItemDao.findAll().size());

    }

    @Test
    public void searchItem() {

        List<CheckTemplateItem> items = iCheckTemplateItemService.searchItem("233");

        assertEquals(1, items.size());

        assertEquals("itemServiceTest0", items.get(0).getName());
    }

    @After
    public void tearDown() throws Exception {

        checkTemplateItemDao.deleteAll();

    }

}
