package com.menu.model;

/**
 * Представляет напиток в меню.
 * Наследуется от MenuItem и добавляет специфические свойства напитка: тип и размер.
 * 
 * @author Команда проекта Меню
 * @version 1.0
 */
public class Drink extends MenuItem {
    
    private final String тип;
    private final String размер;
    
    /**
     * Создает новый напиток с указанными свойствами.
     *
     * @param название название напитка
     * @param стоимость стоимость напитка
     * @param калории количество калорий
     * @param веганский является ли напиток веганским
     * @param тип тип напитка (например, Кофе, Сок, Газировка)
     * @param размер размер напитка (например, Маленький, Средний, Большой)
     * @throws IllegalArgumentException если тип или размер null или пустые
     */
    public Drink(String название, double стоимость, int калории, boolean веганский, 
                 String тип, String размер) {
        super(название, стоимость, калории, веганский);
        
        if (тип == null || тип.trim().isEmpty()) {
            throw new IllegalArgumentException("Тип напитка не может быть null или пустым");
        }
        if (размер == null || размер.trim().isEmpty()) {
            throw new IllegalArgumentException("Размер напитка не может быть null или пустым");
        }
        
        this.тип = тип;
        this.размер = размер;
    }
    
    /**
     * Возвращает тип напитка.
     *
     * @return тип напитка
     */
    public String getТип() {
        return тип;
    }
    
    /**
     * Возвращает размер напитка.
     *
     * @return размер напитка
     */
    public String getРазмер() {
        return размер;
    }
    
    /**
     * Возвращает конкретный тип элемента меню.
     *
     * @return "Напиток" как тип элемента
     */
    @Override
    public String getТипЭлемента() {
        return "Напиток";
    }
    
    /**
     * Возвращает подробное строковое представление напитка.
     *
     * @return строковое представление с деталями напитка
     */
    @Override
    public String toString() {
        return String.format("%s [%s, %s] - %.2f бун, %d ккал%s", 
            getНазвание(), тип, размер, getСтоимость(), getКалории(), 
            isВеганский() ? " (Веганский)" : "");
    }
}