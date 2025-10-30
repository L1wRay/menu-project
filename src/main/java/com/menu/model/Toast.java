package com.menu.model;

/**
 * Представляет тост в меню.
 * Наследуется от MenuItem и добавляет специфические свойства тоста: тип хлеба и начинку.
 * 
 * @author Команда проекта Меню
 * @version 1.0
 */
public class Toast extends MenuItem {
    
    private final String типХлеба;
    private final String начинка;
    
    /**
     * Создает новый тост с указанными свойствами.
     *
     * @param название название тоста
     * @param стоимость стоимость тоста
     * @param калории количество калорий
     * @param веганский является ли тост веганским
     * @param типХлеба тип используемого хлеба
     * @param начинка основная начинка тоста
     * @throws IllegalArgumentException если типХлеба или начинка null или пустые
     */
    public Toast(String название, double стоимость, int калории, boolean веганский,
                 String типХлеба, String начинка) {
        super(название, стоимость, калории, веганский);
        
        if (типХлеба == null || типХлеба.trim().isEmpty()) {
            throw new IllegalArgumentException("Тип хлеба не может быть null или пустым");
        }
        if (начинка == null || начинка.trim().isEmpty()) {
            throw new IllegalArgumentException("Начинка не может быть null или пустой");
        }
        
        this.типХлеба = типХлеба;
        this.начинка = начинка;
    }
    
    /**
     * Возвращает тип хлеба, используемого в тосте.
     *
     * @return тип хлеба
     */
    public String getТипХлеба() {
        return типХлеба;
    }
    
    /**
     * Возвращает начинку тоста.
     *
     * @return начинка тоста
     */
    public String getНачинка() {
        return начинка;
    }
    
    /**
     * Возвращает конкретный тип элемента меню.
     *
     * @return "Тост" как тип элемента
     */
    @Override
    public String getТипЭлемента() {
        return "Тост";
    }
    
    /**
     * Возвращает подробное строковое представление тоста.
     *
     * @return строковое представление с деталями тоста
     */
    @Override
    public String toString() {
        return String.format("%s [%s хлеб с %s] - %.2f бун, %d ккал%s", 
            getНазвание(), типХлеба, начинка, getСтоимость(), getКалории(), 
            isВеганский() ? " (Веганский)" : "");
    }
}