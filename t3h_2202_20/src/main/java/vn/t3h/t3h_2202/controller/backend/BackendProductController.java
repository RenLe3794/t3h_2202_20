package vn.t3h.t3h_2202.controller.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.t3h.t3h_2202.dto.ProductDto;
import vn.t3h.t3h_2202.paging.PagingAndSortObject;
import vn.t3h.t3h_2202.paging.PagingAndSortParam;
import vn.t3h.t3h_2202.service.CategoryService;
import vn.t3h.t3h_2202.service.ProductService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("backend/product")
public class BackendProductController {

    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;


    public static String UPLOADED_FOLDER = "D:\\usr\\img\\t3h\\";
    @RequestMapping("create")
    public String create() {
        return "backend/product/create";
    }

    @PostMapping(value = "create-form", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String createUserForm(ProductDto productDto, RedirectAttributes redirectAttributes,
                                 HttpServletResponse response, HttpServletRequest request) throws SQLException {
        productService.saveProduct(productDto);
        redirectAttributes.addFlashAttribute("message", "Tạo mới tài khoản " + productDto.getName() + " thành công!");
        return "redirect:/backend/product/create";
    }

    @PostMapping("/upload")
    @ResponseBody
    public String uploadFile(
            @RequestParam("file") MultipartFile uploadfile) {
        if (uploadfile.isEmpty()) {
            return null;
        }
        try {
            saveUploadedFiles(Arrays.asList(uploadfile));
        } catch (IOException e) {
            return null;
        }
        return uploadfile.getOriginalFilename();

    }

    //save file
    private void saveUploadedFiles(List<MultipartFile> files) throws IOException {

        for (MultipartFile file : files) {

            if (file.isEmpty()) {
                continue; //next pls
            }

            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

        }
    }
    @GetMapping("list")
    public String loadPageList(@RequestParam(required = false) Long categoryId, @PagingAndSortParam(path = "product")PagingAndSortObject pagingAndSortObject, Model model) throws SQLException {
        productService.danhsach(pagingAndSortObject);
        if (categoryId != null)
            model.addAttribute("Category", categoryService.findById(categoryId));
        return "backend/product/list";
    }
    @GetMapping("edit/{id}")
    public String loadPageEdit(Model model, @PathVariable Long id) {
        model.addAttribute("product", productService.detail(id));
        return "backend/product/edit";
    }
    //xóa product item
        @RequestMapping(value = "/delete")
        public String deleteUser(@RequestParam Long Id,Model model) throws SQLException {
        productService.deleteById(Id);
            return "redirect:/backend/product/list";
        }
    @PostMapping(value = "edit-form", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String editUserForm(ProductDto productDto, RedirectAttributes redirectAttributes,
                               HttpServletResponse response, HttpServletRequest request) throws SQLException {
        productService.editProduct(productDto);
//        request.setAttribute();
        redirectAttributes.addFlashAttribute("message", "Cập nhật tài khoản " + productDto.getName() + " thành công!");
//        response.sendRedirect("/backend/user/create");
        return "redirect:/backend/product/list";
    }

    }

