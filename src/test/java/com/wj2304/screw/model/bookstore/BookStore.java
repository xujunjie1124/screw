package com.wj2304.screw.model.bookstore;

import java.util.List;
import java.util.Map;

import com.wj2304.screw.annotations.ScrewAlias;
import com.wj2304.screw.annotations.ScrewIgnore;


public class BookStore {

    @ScrewAlias("Keeper")
    private String keeper;
    @ScrewIgnore
    private String address;
    private Boolean isOk;
    private List<Book> books;
    private User[] users;
    private Map<String, User> userMap;
    public String getKeeper() {
        return keeper;
    }
    public void setKeeper(String keeper) {
        this.keeper = keeper;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public List<Book> getBooks() {
        return books;
    }
    public void setBooks(List<Book> books) {
        this.books = books;
    }
    public User[] getUsers() {
        return users;
    }
    public void setUsers(User[] users) {
        this.users = users;
    }
    public Boolean getIsOk() {
        return isOk;
    }
    public void setIsOk(Boolean isOk) {
        this.isOk = isOk;
    }
    public Map<String, User> getUserMap() {
        return userMap;
    }
    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }
    
}
