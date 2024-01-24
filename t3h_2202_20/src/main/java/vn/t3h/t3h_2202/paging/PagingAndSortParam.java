package vn.t3h.t3h_2202.paging;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PagingAndSortParam {
    public String path();
}
