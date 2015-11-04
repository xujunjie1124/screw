package com.jd.ofc.model.bookstore;

import java.math.BigDecimal;
import java.util.Date;

import com.jd.ofc.screw.annotations.ScrewDatePattern;

public class Book {
    private int id;
    private String title;
    private String author;
    @ScrewDatePattern("yyyy-MM-dd")
    private Date publishDate;
    private BigDecimal price;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public Date getPublishDate() {
        return publishDate;
    }
    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
