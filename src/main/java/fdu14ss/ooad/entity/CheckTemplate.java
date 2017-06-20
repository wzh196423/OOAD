package fdu14ss.ooad.entity;

import javax.validation.constraints.NotNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by wangziheng on 2017/6/17.
 */

@Entity
@Table(name = "check_template")
public class CheckTemplate extends BaseEntity{

    @NotNull
    private String name;

    @NotNull
    private String description;

    @ManyToMany(cascade = CascadeType.REFRESH)
    @JoinTable(
            name = "template_2_item_ref",
            joinColumns = @JoinColumn(name = "t_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "i_id",referencedColumnName = "id")
    )
    private Set<CheckTemplateItem> item_set=new HashSet<CheckTemplateItem>();

    public CheckTemplate(){
    }

    public CheckTemplate(String name, String description) {
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

    public Set<CheckTemplateItem> getItem_set() {
        return item_set;
    }

    public void setItem_set(Set<CheckTemplateItem> item_set) {
        this.item_set = item_set;
    }

    /*
    public void addItem(CheckTemplateItem i){
        this.item_set.add(i);
    }

    public void deleteItemByName(String name){
        Iterator<CheckTemplateItem> i = this.item_set.iterator();
        while(i.hasNext()){//遍历
            if (i.next().getName().equals(name)) {
                i.remove();
                break;
            }
        }
    }
    */
}
