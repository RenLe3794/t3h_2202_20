package vn.t3h.t3h_2202.controller.frontend;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.t3h.t3h_2202.service.BrandService;
import vn.t3h.t3h_2202.dto.BrandDto;
import vn.t3h.t3h_2202.dto.ProductDto;

import vn.t3h.t3h_2202.service.CartService;
import vn.t3h.t3h_2202.service.CategoryService;
import vn.t3h.t3h_2202.service.ProductService;

import java.util.ArrayList;

@Controller
public class HomeController {
    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    BrandService brandService;

    @Autowired
    CartService cartService;

    @RequestMapping({"/", "home","home/page", "home/page/1"})
        public String homepage(@RequestParam(required = false) Long brandId,
                               @RequestParam(required = false) Long categoryId ,
                               @RequestParam(required = false) Long priceRange,
                               Model model){
         if (brandId != null) {
             model.addAttribute("products", productService.findBrand(brandId));
             brandId = null;
         }
        else if(categoryId != null)
         {
             model.addAttribute("products", productService.findCategory(categoryId));
             categoryId = null;
         }
//        else if(priceRange!=null)
//         {
//             if (priceRange==1) model.addAttribute("")
//         }
        else  model.addAttribute("products", productService.findTop10());
        model.addAttribute("danhsachCategory", categoryService.findAll());// lấy từ db
        model.addAttribute("danhsachBrand", brandService.findAll());

        return "home";
    }


    // Lấy danh sản phẩm theo category id
    @RequestMapping("category/{id}")
    public String category(Model model, @PathVariable Long id){
        // Query trong db sác sản phẩm có category id = {id}
        model.addAttribute("danhsachProduct", new ArrayList<ProductDto>());// lấy từ db
        return "homecategory";
    }
    @RequestMapping("brand/{id}")
    public String brand(Model model, @PathVariable Long id){
        // Query trong db sác sản phẩm có category id = {id}
        model.addAttribute("danhsachBrand", new ArrayList<BrandDto>());// lấy từ db
        return "homecategory";
    }
    @RequestMapping("login")
    public String login (Model model){
        return "login";
    }

    @RequestMapping("ThankingPage")
    public String thankingPage(Model model){
        return "ThankingPage";
    }

}
