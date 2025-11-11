package com.menu.service;

import com.menu.model.MenuItem;
import com.menu.repository.MenuRepository;
import java.util.ArrayList;
import java.util.List;

/**
 * Отрефакторенный сервисный класс с шаблоном репозитория
 * Теперь использует MenuRepository для операций сохранения данных
 */
public class MenuService {
    
    private final MenuRepository menuRepository;
    
    /**
     * РЕФАКТОРИНГ: Использование шаблона репозитория для доступа к данным
     */
    public MenuService() {
        this.menuRepository = new MenuRepository();
    }
    
    /**
     * Добавляет элемент меню через репозиторий
     * @param item элемент меню для добавления
     * @return назначенный ID добавленного элемента
     */
    public int addMenuItem(MenuItem item) {
        // РЕФАКТОРИНГ: Делегирование репозиторию
        return menuRepository.addMenuItem(item);
    }
    
    /**
     * Удаляет элемент меню по индексу
     * @param index индекс для удаления
     * @return true если успешно
     */
    public boolean removeMenuItem(int index) {
        // РЕФАКТОРИНГ: Добавлена функциональность удаления
        return menuRepository.removeMenuItem(index);
    }
    
    /**
     * Обновляет существующий элемент меню
     * @param index индекс для обновления
     * @param newItem новые данные элемента
     * @return true если успешно
     */
    public boolean updateMenuItem(int index, MenuItem newItem) {
        // РЕФАКТОРИНГ: Добавлена функциональность обновления
        return menuRepository.updateMenuItem(index, newItem);
    }
    
    /**
     * Получает все элементы меню
     * @return список всех элементов меню
     */
    public List<MenuItem> getAllMenuItems() {
        // РЕФАКТОРИНГ: Использование репозитория
        return menuRepository.getAllMenuItems();
    }
    
    /**
     * Получает только веганские элементы
     * @return список веганских элементов меню
     */
    public List<MenuItem> getVeganItems() {
        // РЕФАКТОРИНГ: Улучшена логика фильтрации
        List<MenuItem> veganItems = new ArrayList<>();
        for (MenuItem item : menuRepository.getAllMenuItems()) {
            if (item.isVegan()) {
                veganItems.add(item);
            }
        }
        return veganItems;
    }
    
    /**
     * Вычисляет среднюю цену для высококалорийных элементов
     * @param minCalories минимальный порог калорий
     * @return средняя цена
     */
    public double getAveragePriceForHighCalorieItems(int minCalories) {
        // РЕФАКТОРИНГ: Улучшен расчет с подходом похожим на стримы
        List<MenuItem> highCalorieItems = new ArrayList<>();
        double totalPrice = 0.0;
        
        for (MenuItem item : menuRepository.getAllMenuItems()) {
            if (item.getCalories() > minCalories) {
                highCalorieItems.add(item);
                totalPrice += item.getPrice();
            }
        }
        
        if (highCalorieItems.isEmpty()) {
            return 0.0;
        }
        
        return totalPrice / highCalorieItems.size();
    }
    
    /**
     * Получает количество элементов
     * @return количество элементов меню
     */
    public int getMenuItemsCount() {
        // РЕФАКТОРИНГ: Использование репозитория
        return menuRepository.getItemsCount();
    }
    
    /**
     * РЕФАКТОРИНГ: Новый метод для поиска элементов по названию
     * @param name название для поиска
     * @return список соответствующих элементов
     */
    public List<MenuItem> findItemsByName(String name) {
        return menuRepository.findByName(name);
    }
    
    /**
     * РЕФАКТОРИНГ: Новый метод для очистки всех элементов
     */
    public void clearAllItems() {
        menuRepository.clearAll();
    }
}