package com.example.Shop.Response;

import com.example.Shop.Domain.Size_Gallery;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;

public class ProductResponse {
    private Long productId;
    private String name;
    private int price;
    private  int discount;
    private String avatarUrl;
    private String imgUrl1;
    private String imgUrl2;
    private String imgUrl3;
    private String imgUrl4;
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

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getImgUrl1() {
        return imgUrl1;
    }

    public void setImgUrl1(String imgUrl1) {
        this.imgUrl1 = imgUrl1;
    }

    public String getImgUrl2() {
        return imgUrl2;
    }

    public void setImgUrl2(String imgUrl2) {
        this.imgUrl2 = imgUrl2;
    }

    public String getImgUrl3() {
        return imgUrl3;
    }

    public void setImgUrl3(String imgUrl3) {
        this.imgUrl3 = imgUrl3;
    }

    public String getImgUrl4() {
        return imgUrl4;
    }

    public void setImgUrl4(String imgUrl4) {
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
