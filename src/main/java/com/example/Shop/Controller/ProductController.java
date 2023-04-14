package com.example.Shop.Controller;

import com.example.Shop.Domain.Category;
import com.example.Shop.Domain.Product;
import com.example.Shop.Model.CategoryDto;
import com.example.Shop.Model.ProductDto;
import com.example.Shop.Response.ProductResponse;
import com.example.Shop.Service.ICategoriesService;
import com.example.Shop.Service.IProductService;
import com.example.Shop.Service.Impl.ProductServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/Product")
public class ProductController {
    @Autowired
    IProductService  iProductService;
    @Autowired
    ICategoriesService iCategoriesService;

    @ModelAttribute("categories")
    public List<CategoryDto> getCategories(){
        return iCategoriesService.findAll().stream().map(item->{
            CategoryDto dto = new CategoryDto();
            BeanUtils.copyProperties(item,dto);
            return dto;
        }).toList();
    }
    @GetMapping("/")
    public String productList(Model model){
       return viewpage(model,1);
    }
    @GetMapping("/viewpage/{pageNum}")
    public String viewpage(Model model, @PathVariable("pageNum") int pageNum){
        Page<Product> page = iProductService.findAll(pageNum);
        List<Product> productList = page.getContent();
        ProductResponse item = new ProductResponse();
        model.addAttribute("listProduct",productList);
        model.addAttribute("item",item);
        model.addAttribute("currentPage",pageNum);
        model.addAttribute("totalPage",page.getTotalPages());
        model.addAttribute("totalItem",page.getTotalElements());
        return "admin/listProduct";
    }
    @GetMapping("/viewpage/{pageNum}/{id}")
    public String viewItemDetail(Model model, @PathVariable("pageNum") int pageNum,@PathVariable("id") int id){
        System.out.println("đã vào");
        Page<Product> page = iProductService.findAll(pageNum);
        List<Product> productList = page.getContent();
        ProductResponse item = new ProductResponse();
        productList.forEach(s->{
            if(s.getProductId()==id){
                BeanUtils.copyProperties(s,item);
            }
        });
        model.addAttribute("listProduct",productList);
        model.addAttribute("item",item);
        model.addAttribute("currentPage",pageNum);
        model.addAttribute("totalPage",page.getTotalPages());
        model.addAttribute("totalItem",page.getTotalElements());
        return "admin/listProduct";
    }
    @GetMapping("/new")
    public String newProduct(Model model){
        model.addAttribute("productItem",new ProductDto());
        return "admin/addOrEditPro";
    }
    @GetMapping("/edit/{id}")
    public ModelAndView editById(@PathVariable("id")Long id){
        System.out.println("đã vào");
        ModelAndView modelAndView = new ModelAndView("admin/addOrEditPro");
        Optional<Product> product = iProductService.findById(id);
        ProductResponse productDto = new ProductResponse();
        if(product.isPresent()){
            Product pro = product.get();
            BeanUtils.copyProperties(pro,productDto);
            productDto.setAvatarUrl(product.get().getAvatar());
            modelAndView.addObject("productItem",productDto);


        }else {
            modelAndView.addObject("message","Product not exist!");
        }
        return modelAndView;
    }
    @PostMapping("/saveOrUpdate")
    public String saveOrUpdate(@ModelAttribute ProductDto productDto){
        if(productDto.getAvatarUrl().isEmpty() || productDto.getImgUrl1().isEmpty()
                || productDto.getImgUrl2().isEmpty() || productDto.getImgUrl3().isEmpty() || productDto.getImgUrl4().isEmpty()){
            return "redirect:/Product/new";
        }
        System.out.println("CategoryID: "+ productDto.getCategoryId());
        Product product = new Product();
        int cateId = Math.toIntExact(productDto.getCategoryId());
        Optional<Category> category = iCategoriesService.findById(cateId);
        product.setCategory(category.get());
        Path path = Paths.get("Uploads/");
        BeanUtils.copyProperties(productDto,product);
        try{
            //Avatar
            InputStream inputStream = productDto.getAvatarUrl().getInputStream();
            Files.copy(inputStream,path.resolve(productDto.getAvatarUrl().getOriginalFilename()),
                    StandardCopyOption.REPLACE_EXISTING);
            product.setAvatar(productDto.getAvatarUrl().getOriginalFilename());
            //img1
             inputStream = productDto.getImgUrl1().getInputStream();
            Files.copy(inputStream,path.resolve(productDto.getImgUrl1().getOriginalFilename()),
                    StandardCopyOption.REPLACE_EXISTING);
            product.setImgUrl1(productDto.getImgUrl1().getOriginalFilename());
            //img2
             inputStream = productDto.getImgUrl2().getInputStream();
            Files.copy(inputStream,path.resolve(productDto.getImgUrl2().getOriginalFilename()),
                    StandardCopyOption.REPLACE_EXISTING);
            product.setImgUrl2(productDto.getImgUrl2().getOriginalFilename());
            //img3
             inputStream = productDto.getImgUrl3().getInputStream();
            Files.copy(inputStream,path.resolve(productDto.getImgUrl3().getOriginalFilename()),
                    StandardCopyOption.REPLACE_EXISTING);
            product.setImgUrl3(productDto.getImgUrl3().getOriginalFilename());
            //img4
             inputStream = productDto.getImgUrl4().getInputStream();
            Files.copy(inputStream,path.resolve(productDto.getImgUrl4().getOriginalFilename()),
                    StandardCopyOption.REPLACE_EXISTING);
            product.setImgUrl4(productDto.getImgUrl4().getOriginalFilename());
        }catch (Exception ex){
            ex.printStackTrace();
        }
        String timeStamp = new SimpleDateFormat("HH:mm_dd/MM/yyyy").format(Calendar.getInstance().getTime());
        product.setCreateDate(timeStamp);
        iProductService.save(product);
        return "redirect:/Product/";
    }
    @RequestMapping("/delete/{id}")
    public String deleteById(@PathVariable("id")Long id){
        iProductService.deleteById(id);
        return "redirect:/Product/";
    }
    @RequestMapping("/detail/{id}")
    public String detailProduct(@PathVariable("id")Long id){

        return "admin/detailProduct";
    }

}
