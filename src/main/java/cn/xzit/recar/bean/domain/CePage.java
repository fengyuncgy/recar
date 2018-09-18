package cn.xzit.recar.bean.domain;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CePage<T> {

    // 总行数
    private long totalElements;
    // 总页数
    private long totalPages;
    // 单页个数
    private int size;
    // 当前第几页
    private int number;
    // 当前页多少个数据
    private int numberOfElements;
    // 第一页
    private boolean first;
    // 最后一页
    private boolean last;
    // 是否排序
    private boolean sorted;
    // 结果集
    private List<T> content;

}
