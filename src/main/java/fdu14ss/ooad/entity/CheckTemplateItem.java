package fdu14ss.ooad.entity;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;

/**
 * Created by wangziheng on 2017/6/17.
 */
@Entity
@Table(name = "check_template_items")
public class CheckTemplateItem extends BaseEntity{

    @NotNull
    private String name;

    @NotNull
    private String description;

    public CheckTemplateItem(){}

    public CheckTemplateItem(String name , String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
