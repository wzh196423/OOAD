package fdu14ss.ooad.dao;

import fdu14ss.ooad.entity.CheckTask;
import fdu14ss.ooad.entity.CheckTaskItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wangziheng on 2017/6/18.
 */
@Repository
public interface CheckTaskItemDao extends JpaRepository<CheckTaskItem, Long> {
    // 返回一个task下所有的item
    List<CheckTaskItem> findAllByCheckTask(CheckTask checkTask);
}
