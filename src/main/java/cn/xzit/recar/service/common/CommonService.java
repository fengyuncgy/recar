package cn.xzit.recar.service.common;

import cn.xzit.recar.bean.domain.CePage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@SuppressWarnings("all")
public class CommonService {


    /**
     * 封装分页擦数
     * @param content 结果集
     * @param page 有JPA查询出来之后的page对象
     * @param <T> 进过service处理的结果集类型
     * @param <E> 经过JPA查询出来的结果集类型
     * @return 分页对象
     */
    public <T, E> CePage<T> page(List<T> content, Page<E> page) {

        CePage<T> cePage = new CePage<>();
        cePage.setContent(content);
        cePage.setTotalElements(page.getTotalElements());
        cePage.setTotalPages(page.getTotalPages());
        cePage.setSize(page.getSize());
        cePage.setNumber(page.getNumber());
        cePage.setNumberOfElements(page.getNumberOfElements());
        cePage.setFirst(page.isFirst());
        cePage.setLast(page.isLast());
        cePage.setSorted(page.getSort().isSorted());
        return cePage;
    }

    /**
     * 分装分页参数
     * @param content 结果集
     * @param pageable 前端给定的pageable对象
     * @param count 根据结果集相同的查询条件，从数据库中查询出来总共的行数
     * @param <T> 结果集类型
     * @return 分页对象
     */
    public <T> CePage<T> page(List<T> content, Pageable pageable, long count) {
        int size = pageable.getPageSize();
        long totalPages = count / size;
        totalPages = count % size == 0 ? totalPages : totalPages + 1;

        boolean first = pageable.getOffset() == 0;
        boolean last = count - pageable.getOffset() <= size;
        boolean isSorted = pageable.getSort().isSorted();

        CePage<T> cePage = new CePage<>();
        cePage.setContent(content);
        cePage.setTotalElements(count);
        cePage.setTotalPages(totalPages);
        cePage.setSize(size);
        cePage.setNumber(pageable.getPageNumber());
        cePage.setNumberOfElements(content.size());
        cePage.setFirst(first);
        cePage.setLast(last);
        cePage.setSorted(isSorted);
        return cePage;
    }

    // 根据排序字段名称获取字段的排序方式：desc或者asc
    public String getOrderMethod(Pageable pageable, String property) {
        return pageable.getSort().getOrderFor(property).getDirection().toString().toLowerCase();
    }

    public String likeAllPer(String str) {
        return "%" + str + "%";
    }

    public String likeRigtPer(String str) {
        return str + "%";
    }

    public String likeLeftPer(String str) {
        return "%" + str;
    }

    public String likeAllLine(String str, int... countLine) {
        String leftLine = "_";
        String rightLine = "_";
        if (countLine != null && countLine.length > 0) {
            for (int i = 1; i < countLine[0]; i++) {
                leftLine += "_";
            }
            if (countLine.length >= 2) {
                for (int i = 1; i < countLine[1]; i++) {
                    rightLine += "_";
                }
            }
        }
        return leftLine + str + rightLine;
    }

    public String likeRightLine(String str, int countLine) {
        String line = "_";
        for (int i = 1; i < countLine; i++) {
            line += "_";
        }
        return str + line;
    }

    public String likeLeftLine(String str, int countLine) {
        String line = "_";
        for (int i = 1; i < countLine; i++) {
            line += "_";
        }
        return line + str;
    }

    /**
     * 根据新的pageSize构造新的pageable对象
     * @param pageable 当前的pageable对象
     * @param actualPageSize 要传递给pageable对象的pageSize
     * @return pageable对象
     */
    public Pageable pageable(Pageable pageable, int actualPageSize) {
        return new Pageable() {
            @Override
            public int getPageNumber() {
                return pageable.getPageNumber();
            }

            @Override
            public int getPageSize() {
                return actualPageSize;
            }

            @Override
            public long getOffset() {
                return pageable.getOffset();
            }

            @Override
            public Sort getSort() {
                return pageable.getSort();
            }

            @Override
            public Pageable next() {
                return pageable.next();
            }

            @Override
            public Pageable previousOrFirst() {
                return pageable.previousOrFirst();
            }

            @Override
            public Pageable first() {
                return pageable.first();
            }

            @Override
            public boolean hasPrevious() {
                return pageable.hasPrevious();
            }
        };
    }

    public boolean isNull(Object o){
        if(o==null)return true;
        return false;
    }
}
