package com.menu.model;

public abstract class MenuItem {
    
    private final String name;
    private final double price;
    private final int calories;
    private final boolean isVegan;
    
    public MenuItem(String name, double price, int calories, boolean isVegan) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        if (calories < 0) {
            throw new IllegalArgumentException("Calories cannot be negative");
        }
        
        this.name = name;
        this.price = price;
        this.calories = calories;
        this.isVegan = isVegan;
    }
    
    public String getName() {
        return name;
    }
    
    public double getPrice() {
        return price;
    }
    
    public int getCalories() {
        return calories;
    }
    
    public boolean isVegan() {
        return isVegan;
    }
    
    @Override
    public String toString() {
        return String.format("%s - %.2f бун, %d ккал%s", 
            name, price, calories, isVegan ? " (Веганский)" : "");
    }
    
    public abstract String getItemType();
}