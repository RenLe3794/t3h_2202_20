package vn.t3h.t3h_2202.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import vn.t3h.t3h_2202.entity.ProductEntity;

@Data
@NoArgsConstructor
public class ProductDto {
    Long id;
    String name;
    String description;
    Integer price;
    Long brandId;
    Long categoryId;
    String image;
    String cpu;
    String memory;
    String ram;
    String vga;
    String display;
    String wireless;
    String lan;
    String batterry;
    String os;
    String weight;
    String color;
    String brandName;

    public ProductEntity ConvertEntity(){
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(id);
        productEntity.setName(name);
        productEntity.setDescription(description);
        productEntity.setPrice(price);
        productEntity.setBrandId(brandId);
        productEntity.setCategoryId(categoryId);
        productEntity.setImage(image);
        productEntity.setCpu(cpu);
        productEntity.setMemory(memory);
        productEntity.setRam(ram);
        productEntity.setVga(vga);
        productEntity.setDisplay(display);
        productEntity.setLan(lan);
        productEntity.setBatterry(batterry);
        productEntity.setOs(os);
        productEntity.setWeight(weight);
        productEntity.setColor(color);
        return productEntity;
    }
}
