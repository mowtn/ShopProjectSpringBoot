package com.example.Shop.Model;

import com.example.Shop.Domain.Category;
import com.example.Shop.Domain.OrderDetail;
import com.example.Shop.Domain.Size_Gallery;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Long productId;
    private String name;
    private int price;
    private  int discount;
    private MultipartFile avatarUrl;
    private MultipartFile imgUrl1;
    private MultipartFile imgUrl2;
    private MultipartFile imgUrl3;
    private MultipartFile imgUrl4;
    private String Description;
    private int status;
    private Long categoryId;
    private Set<Size_Gallery> size_gallery;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public MultipartFile getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(MultipartFile avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public MultipartFile getImgUrl1() {
        return imgUrl1;
    }

    public void setImgUrl1(MultipartFile imgUrl1) {
        this.imgUrl1 = imgUrl1;
    }

    public MultipartFile getImgUrl2() {
        return imgUrl2;
    }

    public void setImgUrl2(MultipartFile imgUrl2) {
        this.imgUrl2 = imgUrl2;
    }

    public MultipartFile getImgUrl3() {
        return imgUrl3;
    }

    public void setImgUrl3(MultipartFile imgUrl3) {
        this.imgUrl3 = imgUrl3;
    }

    public MultipartFile getImgUrl4() {
        return imgUrl4;
    }

    public void setImgUrl4(MultipartFile imgUrl4) {
        this.imgUrl4 = imgUrl4;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Set<Size_Gallery> getSize_gallery() {
        return size_gallery;
    }

    public void setSize_gallery(Set<Size_Gallery> size_gallery) {
        this.size_gallery = size_gallery;
    }
}
