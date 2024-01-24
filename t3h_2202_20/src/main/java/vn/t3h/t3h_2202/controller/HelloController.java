package vn.t3h.t3h_2202.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
public class HelloController {
    // 1: Làm theo hướng dẫn tạo mới csdl bảng user
    // 2: Tạo mới Rest controller lấy danh sách user, cập nhật user, xóa user theo id
    // 3: Tạo jsp để thêm mới user



    @GetMapping(value = "hello")
    public String testController() {
//        List<Integer> integerList = List.of(1, 2, 3);
//        final List<Integer> integerList = Arrays.asList(new Integer[]{1,2,3});
        return "hello";// đi tìm file /WEB-INF/jsp/ hello .jsp trong thư muc webapp
        // reden ra html
    }

    // hello-rest/dong?key1=value1&key2=value2
    @GetMapping(value = "hello-rest/{name}")
    @ResponseBody
    public String testController1(@PathVariable String name,
                                  @RequestParam String clazz, @RequestParam Map<String, String> allParam) {
        allParam.get("clazz");
        String v = allParam.get("key1");// value1
        String v2 = allParam.get("key2");// value2
        return "<h1>Xin chao t3h</h1>";
    }
}
