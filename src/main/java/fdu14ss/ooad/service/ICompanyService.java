package fdu14ss.ooad.service;

import fdu14ss.ooad.entity.CheckPlan;
import fdu14ss.ooad.entity.CheckTaskItem;
import fdu14ss.ooad.entity.Company;
import fdu14ss.ooad.entity.enums.ItemStatus;

import java.util.List;

/**
 * Created by wangziheng on 2017/6/18.
 */
public interface ICompanyService {
    void changeTaskItemStatus(CheckTaskItem item, ItemStatus status);
    List<CheckTaskItem> getAllTaskItem(Company company);
}
