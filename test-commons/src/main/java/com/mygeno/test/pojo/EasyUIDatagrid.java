package com.mygeno.test.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @Auther: yt
 * @Date: 2019/1/22
 * @Description: com.mygeno.test.pojo
 * @version: 1.0
 */
public class EasyUIDatagrid implements Serializable {
    private List<?> rows;

    private long total;

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
