package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.model.UserModel;
import com.example.demo.model.UserType;
import com.example.demo.security.CurrentUser;
import com.example.demo.service.BrandService;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewController {

    private CategoryService categoryService;
    private BrandService brandService;
    private ProductService productService;

    @Autowired
    public ViewController(CategoryService categoryService, BrandService brandService,
                          ProductService productService) {
        this.categoryService = categoryService;
        this.brandService = brandService;
        this.productService = productService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView mainPage(ModelMap map) {
        map.addAttribute("allCategories", categoryService.findAllCategory());
        map.addAttribute("allBrands", brandService.findAllBrands());
        map.addAttribute("allProducts",productService.findAllProduct());
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/loginSuccess", method = RequestMethod.GET)
    public ModelAndView loginSuccess() {
        CurrentUser principal = (CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal.getUser().getType()== UserType.MANAGER){
            return new ModelAndView("redirect:/admin");
        }
        return new ModelAndView("/");
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginPage(ModelMap modelMap) {
        return new ModelAndView("login");
    }
}
