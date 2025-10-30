package com.menu.service;

import com.menu.model.MenuItem;
import java.util.ArrayList;
import java.util.List;

public class MenuService {
    
    private final List<MenuItem> menuItems;
    
    public MenuService() {
        this.menuItems = new ArrayList<>();
    }
    
    public void addMenuItem(MenuItem item) {
        if (item == null) {
            throw new IllegalArgumentException("Menu item cannot be null");
        }
        menuItems.add(item);
    }
    
    public List<MenuItem> getAllMenuItems() {
        return new ArrayList<>(menuItems);
    }
    
    public List<MenuItem> getVeganItems() {
        List<MenuItem> veganItems = new ArrayList<>();
        for (MenuItem item : menuItems) {
            if (item.isVegan()) {
                veganItems.add(item);
            }
        }
        return veganItems;
    }
    
    public double getAveragePriceForHighCalorieItems(int minCalories) {
        if (minCalories < 0) {
            throw new IllegalArgumentException("Minimum calories cannot be negative");
        }
        
        List<MenuItem> highCalorieItems = new ArrayList<>();
        for (MenuItem item : menuItems) {
            if (item.getCalories() > minCalories) {
                highCalorieItems.add(item);
            }
        }
        
        if (highCalorieItems.isEmpty()) {
            return 0.0;
        }
        
        double totalPrice = 0.0;
        for (MenuItem item : highCalorieItems) {
            totalPrice += item.getPrice();
        }
        
        return totalPrice / highCalorieItems.size();
    }
    
    public int getMenuItemsCount() {
        return menuItems.size();
    }
}