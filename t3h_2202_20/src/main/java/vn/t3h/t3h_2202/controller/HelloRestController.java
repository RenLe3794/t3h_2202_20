package vn.t3h.t3h_2202.controller;

import lombok.Data;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.t3h.t3h_2202.dto.CartDto;
import vn.t3h.t3h_2202.dto.ProductDto;
import vn.t3h.t3h_2202.entity.CartEntity;
import vn.t3h.t3h_2202.entity.ProductEntity;
import vn.t3h.t3h_2202.repository.CartRepository;
import vn.t3h.t3h_2202.service.CartService;
import vn.t3h.t3h_2202.service.ProductService;

import javax.validation.Valid;
import java.util.*;

@RestController// đánh dấu nó là 1 controller = @Controller + @ResponseBody
public class HelloRestController {

//    @GetMapping(value = "hello/{name}")
//    public Test testController(@PathVariable String name,
//                                 @RequestParam String clazz) {
//        Test test = new Test();
//        test.setClazz(clazz);
//        test.setName(name);
//        return test;
//    }
    @Autowired
    CartService cartService;
    @Autowired
    ProductService productService;

@RequestMapping(value = "/hello/{id}", method = RequestMethod.GET)
@ResponseBody
public List<Long> cartDtos(@PathVariable int id){
    List<CartDto> cartDtos = cartService.findCartByUserId(id);
    List<Long> name = new ArrayList<Long>();
    for (CartDto cartDto :  cartDtos)
        name.add(cartDto.getProductId());
return name;
}

@RequestMapping(value = "/hello2/{id}", method = RequestMethod.GET)
@ResponseBody
public List<ProductEntity> productEntityList (@PathVariable int id)

    {
        List<ProductEntity> productEntities = productService.findTop10();
        return  productEntities;
    }

@RequestMapping(value = "/crateHello/{id}", method = RequestMethod.POST)
@ResponseBody
public ProductDto createProduct(@PathVariable int id,@RequestBody ProductDto productDto){
    productService.saveProduct(productDto);
    return productDto;
}

@RequestMapping(value = "/editHello/{id}", method = RequestMethod.PUT)
@ResponseBody
public ProductDto editProduct(@PathVariable Long id,@RequestBody ProductDto productDto){
    ProductDto productDtos = productService.detail(id);

    productDtos.setName(productDto.getName());
    productDtos.setDescription(productDto.getDescription());
    productDtos.setId(id);
    productDtos.setCpu(productDto.getCpu());
    productService.editProduct(productDtos);
    return productDto;
}
    @RequestMapping(value = "/deleteHello/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteProduct(@PathVariable Long id){
    productService.deleteById(id);
        return "Đã delete";
    }

    @Data// tự động generate hàm getter setter cho class
    public static class Test {
        String name;
        String clazz;
    }
}
