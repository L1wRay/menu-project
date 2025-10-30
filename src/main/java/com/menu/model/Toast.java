package com.menu.model;

public class Toast extends MenuItem {
    
    private final String breadType;
    private final String filling;
    
    public Toast(String name, double price, int calories, boolean isVegan,
                 String breadType, String filling) {
        super(name, price, calories, isVegan);
        
        if (breadType == null || breadType.trim().isEmpty()) {
            throw new IllegalArgumentException("Bread type cannot be null or empty");
        }
        if (filling == null || filling.trim().isEmpty()) {
            throw new IllegalArgumentException("Filling cannot be null or empty");
        }
        
        this.breadType = breadType;
        this.filling = filling;
    }
    
    public String getBreadType() {
        return breadType;
    }
    
    public String getFilling() {
        return filling;
    }
    
    @Override
    public String getItemType() {
        return "Toast";
    }
    
    @Override
    public String toString() {
        return String.format("%s [%s хлеб с %s] - %.2f бун, %d ккал%s", 
            getName(), breadType, filling, getPrice(), getCalories(), 
            isVegan() ? " (Веганский)" : "");
    }
}