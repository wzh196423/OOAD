package fdu14ss.ooad.entity;

import com.sun.istack.internal.NotNull;
import fdu14ss.ooad.entity.enums.ItemStatus;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by wangziheng on 2017/6/18.
 */
@Entity
@Table(name = "task_item")
public class CheckTaskItem extends BaseEntity{

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "template_item_id")
    private CheckTemplateItem templateItem;

    @Enumerated(EnumType.STRING)
    private ItemStatus status = ItemStatus.Empty;

    @NotNull
    @ManyToOne(optional = false,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "task_id")
    private CheckTask checkTask;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date finish_time;

    public CheckTaskItem() {}

    public CheckTaskItem(CheckTemplateItem t) {
        this.templateItem = t;
    }

    public CheckTemplateItem getTemplateItem() {
        return templateItem;
    }

    public void setTemplateItem(CheckTemplateItem templateItem) {
        this.templateItem = templateItem;
    }

    public ItemStatus getStatus() {
        return status;
    }

    public void setStatus(ItemStatus status) {
        this.status = status;
    }

    public CheckTask getCheckTask() {
        return checkTask;
    }

    public void setCheckTask(CheckTask checkTask) {
        this.checkTask = checkTask;
    }

    public Date getFinish_time() {
        return finish_time;
    }

    public void setFinish_time(Date finish_time) {
        this.finish_time = finish_time;
    }
}
