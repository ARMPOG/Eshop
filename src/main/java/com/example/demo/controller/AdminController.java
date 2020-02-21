package com.example.demo.controller;

import com.example.demo.model.Brand;
import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.service.BrandService;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
public class AdminController {

    private CategoryService categoryService;
    private BrandService brandService;
    private ProductService productService;

    @Value("${eshop.product.upload.path}")
    private String imageUploadPath;

    @Autowired
    public AdminController(CategoryService categoryService, BrandService brandService,
                           ProductService productService) {
        this.categoryService = categoryService;
        this.brandService = brandService;
        this.productService = productService;
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(ModelMap map) {
        map.addAttribute("category", new Category());
        map.addAttribute("brand", new Brand());
        map.addAttribute("product", new Product());
        map.addAttribute("allCategories", categoryService.findAllCategory());
        map.addAttribute("allBrands", brandService.findAllBrands());
        return "admin";
    }

    @RequestMapping(value = "/addCategory", method = RequestMethod.POST)
    public String addBrand(@ModelAttribute(name = "category") Category category) {
        categoryService.saveCategory(category);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/addBrand", method = RequestMethod.POST)
    public String addCategory(@ModelAttribute(name = "brand") Brand brand) {
        brandService.saveBrand(brand);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute(name = "product") Product product,
                             @RequestParam(value = "image") MultipartFile file) throws IOException {
        File dir = new File(imageUploadPath);
        if (!dir.exists()) {
            dir.mkdir();
        }
        String picName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        File picture = new File(imageUploadPath + picName);
        file.transferTo(picture);
        product.setPicUrl(picName);
        productService.saveProduct(product);
        return "redirect:/admin";
    }


    @RequestMapping(value = "/product/image", method = RequestMethod.GET)
    public void getImageAsByteArray(HttpServletResponse response,
                                    @RequestParam("fileName") String fileName) throws IOException {
        InputStream in = new FileInputStream(imageUploadPath + fileName);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        IOUtils.copy(in, response.getOutputStream());
    }

}
