package plpetkov.everlivedemo;

import com.telerik.everlive.sdk.core.model.base.DataItem;
import com.telerik.everlive.sdk.core.serialization.ServerProperty;
import com.telerik.everlive.sdk.core.serialization.ServerType;

/**
 * Created by 20473 on 1/12/2016.
 */
@ServerType("TestTable")
public class CommonTable extends DataItem {

    @ServerProperty("Count")
    private Integer count;

    @ServerProperty("Name")
    private String name;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
