package com.example.Shop.Controller;

import com.example.Shop.Domain.Category;
import com.example.Shop.Model.CategoryDto;
import com.example.Shop.Service.ICategoriesService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/Category")
public class categoriesController {
    @Autowired
    public ICategoriesService iCategoriesService;
    private Category category;


    @RequestMapping("/")
    public String listCategory(Model model){
        return view(model,1);
    }
    @GetMapping("/viewpage/{pageNum}")
    public String view(Model model, @PathVariable(name ="pageNum")int pageNum){
        Page<Category> page = iCategoriesService.findAll(pageNum);
        List<Category> categoryList = page.getContent();
        model.addAttribute("listCategory",categoryList);
        model.addAttribute("currentPage",pageNum);
        model.addAttribute("totalPage",page.getTotalPages());
        model.addAttribute("totalItem",page.getTotalElements());
        return "admin/listCategory";
    }
    @GetMapping("/new")
    public String addNewCate(Model model){
        CategoryDto cate = new CategoryDto();
        model.addAttribute("cate",cate);
        return "admin/addOrEditCate";
    }
    @PostMapping("/saveOrUpdate")
    public ModelAndView saveOrUpdate(ModelMap model,
                                     @Valid CategoryDto cate, BindingResult result){
        System.out.println(cate);
        if (result.hasErrors()){
            return new ModelAndView("admin/addOrEditCate",model);
        }else{
            Category entity = new Category();
            BeanUtils.copyProperties(cate,entity);
            iCategoriesService.save(entity);
            model.addAttribute("message","Category is save!");
            return new ModelAndView("forward:/Category/",model);
        }
    }
    @GetMapping("/edit/{id}")
    public ModelAndView ShowEdit (@PathVariable(name = "id") int id){
        ModelAndView mav = new ModelAndView("admin/addOrEditCate");
        Optional<Category> category = iCategoriesService.findById(id);
        CategoryDto cate = new CategoryDto();
        if(category.isPresent()){//kiểm tra xem tồn tại hay không
            Category entity = category.get();// lấy ra phần tử
            BeanUtils.copyProperties(entity,cate);
            cate.setIsEdit(true);//xác định là sửa dữ liệu
            mav.addObject("cate",cate);
            return mav;
        }
        mav.addObject("message","Category is existed");
        return mav;
    }
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id")int id){
        iCategoriesService.deleteById(id);
        return "redirect:/Category/";
    }

}
