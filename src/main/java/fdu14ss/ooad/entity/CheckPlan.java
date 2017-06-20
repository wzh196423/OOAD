package fdu14ss.ooad.entity;

import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by wangziheng on 2017/6/17.
 */
@Entity
@Table(name = "check_plan")
public class CheckPlan extends BaseEntity{
    @NotNull
    @ManyToOne(optional = false,fetch = FetchType.EAGER)
    @JoinColumn(name = "template_id")
    private CheckTemplate template;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date begin_date;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date ddl;

    @NotNull
    private String name;

    public CheckPlan() {
    }

    public CheckPlan(CheckTemplate template, Date begin_date, Date ddl, String name) {
        this.template = template;
        this.begin_date = begin_date;
        this.ddl = ddl;
        this.name = name;
    }

    public CheckTemplate getTemplate() {
        return template;
    }

    public Date getBegin_date() {
        return begin_date;
    }

    public void setBegin_date(Date begin_date) {
        this.begin_date = begin_date;
    }

    public Date getDdl() {
        return ddl;
    }

    public void setDdl(Date ddl) {
        this.ddl = ddl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
