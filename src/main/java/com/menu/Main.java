package com.menu;

import com.menu.model.Drink;
import com.menu.model.MenuItem;
import com.menu.model.Toast;
import com.menu.service.MenuService;
import java.util.List;
import java.util.Scanner;

/**
 * Отрефакторенный главный класс с расширенной функциональностью
 * Демонстрирует CRUD операции и новые возможности
 */
public final class Main {
    
    private static final Scanner scanner = new Scanner(System.in);
    
    private Main() {
        // РЕФАКТОРИНГ: Добавлен приватный конструктор
    }
    
    public static void main(String[] args) {
        MenuService menuService = new MenuService();
        initializeSampleData(menuService);
        
        // РЕФАКТОРИНГ: Добавлено интерактивное меню
        showMainMenu(menuService);
    }
    
    /**
     * РЕФАКТОРИНГ: Добавлена инициализация примеров данных
     */
    private static void initializeSampleData(MenuService menuService) {
        // Напитки
        menuService.addMenuItem(new Drink("Эспрессо", 4.0, 5, true, "Кофе", "Маленький"));
        menuService.addMenuItem(new Drink("Капучино", 7.0, 120, false, "Кофе", "Средний"));
        menuService.addMenuItem(new Drink("Зеленый чай", 6.0, 0, true, "Чай", "Средний"));
        menuService.addMenuItem(new Drink("Апельсиновый сок", 8.0, 110, true, "Сок", "Большой"));
        menuService.addMenuItem(new Drink("Соевый латте", 5.0, 90, true, "Кофе", "Средний"));
        menuService.addMenuItem(new Drink("Миндальный смузи", 10.0, 180, true, "Смузи", "Большой"));
        
        // Тосты
        menuService.addMenuItem(new Toast("Авокадо тост", 2.0, 320, true, "Цельнозерновой", "Авокадо"));
        menuService.addMenuItem(new Toast("Сырный тост", 7.0, 280, false, "Белый", "Сыр"));
        menuService.addMenuItem(new Toast("Веганский клуб", 3.0, 420, true, "Мультизерновой", "Тофу и овощи"));
        menuService.addMenuItem(new Toast("Томат-Базилик", 6.0, 190, true, "На закваске", "Томаты и базилик"));
        menuService.addMenuItem(new Toast("Ветчина-Сыр", 13.0, 350, false, "Ржаной", "Ветчина и сыр"));
        menuService.addMenuItem(new Toast("Грибной", 15.0, 290, true, "Цельнозерновой", "Грибы"));
    }
    
    /**
     * РЕФАКТОРИНГ: Добавлено интерактивное главное меню
     */
    private static void showMainMenu(MenuService menuService) {
        while (true) {
            System.out.println("\n=== СИСТЕМА УПРАВЛЕНИЯ МЕНЮ ===");
            System.out.println("1. Показать все меню");
            System.out.println("2. Показать веганские блюда");
            System.out.println("3. Средняя цена высококалорийных блюд");
            System.out.println("4. Найти блюдо по названию");
            System.out.println("5. Удалить блюдо");
            System.out.println("6. Выход");
            System.out.print("Выберите опцию: ");
            
            String choice = scanner.nextLine();
            
            switch (choice) {
                case "1":
                    displayAllMenu(menuService);
                    break;
                case "2":
                    displayVeganItems(menuService);
                    break;
                case "3":
                    displayAveragePriceForHighCalorie(menuService);
                    break;
                case "4":
                    searchItemsByName(menuService);
                    break;
                case "5":
                    removeMenuItem(menuService);
                    break;
                case "6":
                    System.out.println("Выход из программы...");
                    return;
                default:
                    System.out.println("Неверный выбор!");
            }
        }
    }
    
    /**
     * РЕФАКТОРИНГ: Новый метод для поиска элементов по названию
     */
    private static void searchItemsByName(MenuService menuService) {
        System.out.print("Введите название для поиска: ");
        String searchTerm = scanner.nextLine();
        
        List<MenuItem> results = menuService.findItemsByName(searchTerm);
        if (results.isEmpty()) {
            System.out.println("Блюда не найдены.");
        } else {
            System.out.println("Найдено " + results.size() + " блюд:");
            for (int i = 0; i < results.size(); i++) {
                System.out.println((i + 1) + ". " + results.get(i));
            }
        }
    }
    
    /**
     * РЕФАКТОРИНГ: Новый метод для удаления элементов меню
     */
    private static void removeMenuItem(MenuService menuService) {
        displayAllMenu(menuService);
        System.out.print("Введите номер блюда для удаления: ");
        
        try {
            int index = Integer.parseInt(scanner.nextLine()) - 1;
            if (menuService.removeMenuItem(index)) {
                System.out.println("Блюдо успешно удалено!");
            } else {
                System.out.println("Неверный номер блюда!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Неверный формат номера!");
        }
    }
    
    /**
     * Отображает все элементы меню
     * @param menuService сервис меню для получения данных
     */
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
    
    /**
     * Отображает только веганские элементы меню
     * @param menuService сервис меню для получения данных
     */
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
    
    /**
     * Отображает среднюю стоимость высококалорийных элементов
     * @param menuService сервис меню для вычислений
     */
    private static void displayAveragePriceForHighCalorie(MenuService menuService) {
        final int calorieThreshold = 300;
        double averagePrice = menuService.getAveragePriceForHighCalorieItems(calorieThreshold);
        
        System.out.println("=== СРЕДНЯЯ СТОИМОСТЬ ВЫСОКОКАЛОРИЙНЫХ ЭЛЕМЕНТОВ ===");
        System.out.printf("Средняя стоимость элементов с более чем %d калориями: %.2f бун%n", 
                         calorieThreshold, averagePrice);
    }
}