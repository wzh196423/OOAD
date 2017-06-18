package fdu14ss.ooad.serviceTest;

import fdu14ss.ooad.dao.CheckTemplateDao;
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

import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by handsome on 2017/6/18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CheckTemplateService {

    @Autowired
    ICheckTemplateService iCheckTemplateService;

    @Autowired
    CheckTemplateDao checkTemplateDao;

    @Before
    public void setUp() throws Exception {

        CheckTemplate checkTemplate = new CheckTemplate("templateServiceTest0", "templateServiceTest Description233");

        checkTemplateDao.save(checkTemplate);

    }

    @Test
    public void createTemplate() {

        CheckTemplateItem checkTemplateItem = new CheckTemplateItem("item", "description");

        Set<CheckTemplateItem> checkTemplateItems = null;

        checkTemplateItems.add(checkTemplateItem);

        iCheckTemplateService.createTemplate("templateServiceTest1", "templateDesciptionTest1", checkTemplateItems);

        assertEquals (2, checkTemplateDao.findAll().size());

    }

    @After
    public void tearDown() throws Exception {

        checkTemplateDao.deleteAll();

    }

}
