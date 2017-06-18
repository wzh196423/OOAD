package fdu14ss.ooad.dao;

import fdu14ss.ooad.entity.CheckTaskItem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by wangziheng on 2017/6/18.
 */
public interface CheckTaskItemDao extends JpaRepository<CheckTaskItem, Long> {
}
