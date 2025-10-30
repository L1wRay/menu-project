package com.menu.model;

public class Drink extends MenuItem {
    
    private final String type;
    private final String size;
    
    public Drink(String name, double price, int calories, boolean isVegan, 
                 String type, String size) {
        super(name, price, calories, isVegan);
        
        if (type == null || type.trim().isEmpty()) {
            throw new IllegalArgumentException("Drink type cannot be null or empty");
        }
        if (size == null || size.trim().isEmpty()) {
            throw new IllegalArgumentException("Drink size cannot be null or empty");
        }
        
        this.type = type;
        this.size = size;
    }
    
    public String getType() {
        return type;
    }
    
    public String getSize() {
        return size;
    }
    
    @Override
    public String getItemType() {
        return "Drink";
    }
    
    @Override
    public String toString() {
        return String.format("%s [%s, %s] - %.2f бун, %d ккал%s", 
            getName(), type, size, getPrice(), getCalories(), 
            isVegan() ? " (Веганский)" : "");
    }
}