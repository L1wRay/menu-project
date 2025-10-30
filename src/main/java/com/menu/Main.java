package com.menu;

import com.menu.model.Drink;
import com.menu.model.MenuItem;
import com.menu.model.Toast;
import com.menu.service.MenuService;
import java.util.List;

public final class Main {
    
    private Main() {
    }
    
    public static void main(String[] args) {
        MenuService menuService = new MenuService();
        
        menuService.addMenuItem(new Drink("Эспрессо", 4.0, 5, true, "Кофе", "Маленький"));
        menuService.addMenuItem(new Drink("Капучино", 7.0, 120, false, "Кофе", "Средний"));
        menuService.addMenuItem(new Drink("Зеленый чай", 6.0, 0, true, "Чай", "Средний"));
        menuService.addMenuItem(new Drink("Апельсиновый сок", 8.0, 110, true, "Сок", "Большой"));
        menuService.addMenuItem(new Drink("Соевый латте", 5.0, 90, true, "Кофе", "Средний"));
        menuService.addMenuItem(new Drink("Миндальный смузи", 10.0, 180, true, "Смузи", "Большой"));
        
        menuService.addMenuItem(new Toast("Авокадо тост", 2.0, 320, true, "Цельнозерновой", "Авокадо"));
        menuService.addMenuItem(new Toast("Сырный тост", 7.0, 280, false, "Белый", "Сыр"));
        menuService.addMenuItem(new Toast("Веганский клуб", 3.0, 420, true, "Мультизерновой", "Тофу и овощи"));
        menuService.addMenuItem(new Toast("Томат-Базилик", 6.0, 190, true, "На закваске", "Томаты и базилик"));
        menuService.addMenuItem(new Toast("Ветчина-Сыр", 13.0, 350, false, "Ржаной", "Ветчина и сыр"));
        menuService.addMenuItem(new Toast("Грибной", 15.0, 290, true, "Цельнозерновой", "Грибы"));
        
        displayAllMenu(menuService);
        displayVeganItems(menuService);
        displayAveragePriceForHighCalorie(menuService);
    }
    
    private static void displayAllMenu(MenuService menuService) {
        System.out.println("=== ПОЛНОЕ МЕНЮ ===");
        System.out.println("Всего элементов: " + menuService.getMenuItemsCount());
        System.out.println();
        
        List<MenuItem> allItems = menuService.getAllMenuItems();
        for (int i = 0; i < allItems.size(); i++) {
            System.out.println((i + 1) + ". " + allItems.get(i));
        }
        System.out.println();
    }
    
    private static void displayVeganItems(MenuService menuService) {
        System.out.println("=== ВЕГАНСКИЕ ЭЛЕМЕНТЫ ===");
        
        List<MenuItem> veganItems = menuService.getVeganItems();
        if (veganItems.isEmpty()) {
            System.out.println("Веганские элементы отсутствуют.");
        } else {
            System.out.println("Найдено " + veganItems.size() + " веганских элементов:");
            for (int i = 0; i < veganItems.size(); i++) {
                System.out.println((i + 1) + ". " + veganItems.get(i));
            }
        }
        System.out.println();
    }
    
    private static void displayAveragePriceForHighCalorie(MenuService menuService) {
        final int calorieThreshold = 300;
        double averagePrice = menuService.getAveragePriceForHighCalorieItems(calorieThreshold);
        
        System.out.println("=== СРЕДНЯЯ СТОИМОСТЬ ВЫСОКОКАЛОРИЙНЫХ ЭЛЕМЕНТОВ ===");
        System.out.printf("Средняя стоимость элементов с более чем %d калориями: %.2f бун%n", 
                         calorieThreshold, averagePrice);
    }
}