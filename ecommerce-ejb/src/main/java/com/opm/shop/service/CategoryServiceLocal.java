package com.opm.shop.service;



import com.opm.shop.entity.Category;

public interface CategoryServiceLocal {
    
    public void save(Category category);

   
    public Category findById(int id);

   
    public int findCategoryLevelByCategory(Category data);

}