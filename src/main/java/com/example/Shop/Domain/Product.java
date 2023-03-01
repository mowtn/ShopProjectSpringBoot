package com.example.Shop.Domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
@Entity
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(columnDefinition = "varchar(200) not null")
    private String name;

    @Column(length = 200)
    private String avatar;
    @Column(length = 200)
    private String imgUrl1;
    @Column(length = 200)
    private String imgUrl2;
    @Column(length = 200)
    private String imgUrl3;

    @Column(length = 200)
    private String imgUrl4;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private  int discount;
    @Column(columnDefinition = "varchar(500) not null")
    private String Description;

    @Column(nullable = false)
    private int status;

    @Temporal(TemporalType.DATE)
    private String createDate;

    @Temporal(TemporalType.DATE)
    private String updateDate;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Size_Gallery> size_gallery;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<OrderDetail> orderDetails;

    public Product() {
    }

    public Product(Long productId, String name, String avatar, String imgUrl1, String imgUrl2,
                   String imgUrl3, String imgUrl4, int price, int discount, String description, int status,
                   String createDate, String updateDate, Category category, Set<Size_Gallery> size_gallery, Set<OrderDetail> orderDetails) {
        this.productId = productId;
        this.name = name;
        this.avatar = avatar;
        this.imgUrl1 = imgUrl1;
        this.imgUrl2 = imgUrl2;
        this.imgUrl3 = imgUrl3;
        this.imgUrl4 = imgUrl4;
        this.price = price;
        this.discount = discount;
        Description = description;
        this.status = status;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.category = category;
        this.size_gallery = size_gallery;
        this.orderDetails = orderDetails;
    }

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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
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

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Size_Gallery> getSize_gallery() {
        return size_gallery;
    }

    public void setSize_gallery(Set<Size_Gallery> size_gallery) {
        this.size_gallery = size_gallery;
    }

    public Set<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Set<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
}

