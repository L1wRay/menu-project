package com.menu.repository;

import com.menu.model.MenuItem;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Класс-репозиторий для управления сущностями MenuItem.
 * Предоставляет CRUD операции для коллекции элементов меню.
 */
public class MenuRepository {
    
    private final List<MenuItem> menuItems;
    private int nextId;
    
    /**
     * Конструктор инициализирует пустой репозиторий со счетчиком ID
     */
    public MenuRepository() {
        this.menuItems = new ArrayList<>();
        this.nextId = 1;
    }
    
    /**
     * Добавляет новый элемент меню в репозиторий
     * @param item элемент меню для добавления
     * @return назначенный ID добавленного элемента
     */
    public int addMenuItem(MenuItem item) {
        // РЕФАКТОРИНГ: Добавлено управление ID для лучшего отслеживания элементов
        menuItems.add(item);
        return nextId++;
    }
    
    /**
     * Удаляет элемент меню по его индексу
     * @param index индекс элемента для удаления
     * @return true если удаление прошло успешно, false в противном случае
     */
    public boolean removeMenuItem(int index) {
        // РЕФАКТОРИНГ: Добавлена проверка границ для безопасного удаления
        if (index >= 0 && index < menuItems.size()) {
            menuItems.remove(index);
            return true;
        }
        return false;
    }
    
    /**
     * Обновляет существующий элемент меню
     * @param index индекс элемента для обновления
     * @param newItem новые данные элемента меню
     * @return true если обновление прошло успешно, false в противном случае
     */
    public boolean updateMenuItem(int index, MenuItem newItem) {
        // РЕФАКТОРИНГ: Добавлена функциональность обновления с валидацией
        if (index >= 0 && index < menuItems.size() && newItem != null) {
            menuItems.set(index, newItem);
            return true;
        }
        return false;
    }
    
    /**
     * Находит элемент меню по его индексу
     * @param index индекс для поиска
     * @return Optional содержащий элемент если найден
     */
    public Optional<MenuItem> findMenuItem(int index) {
        // РЕФАКТОРИНГ: Использование Optional для безопасного возврата значений
        if (index >= 0 && index < menuItems.size()) {
            return Optional.of(menuItems.get(index));
        }
        return Optional.empty();
    }
    
    /**
     * Находит элементы меню по названию (без учета регистра)
     * @param name название для поиска
     * @return список соответствующих элементов меню
     */
    public List<MenuItem> findByName(String name) {
        // РЕФАКТОРИНГ: Добавлена функциональность поиска
        List<MenuItem> results = new ArrayList<>();
        for (MenuItem item : menuItems) {
            if (item.getName().toLowerCase().contains(name.toLowerCase())) {
                results.add(item);
            }
        }
        return results;
    }
    
    /**
     * Получает все элементы меню из репозитория
     * @return список всех элементов меню
     */
    public List<MenuItem> getAllMenuItems() {
        // РЕФАКТОРИНГ: Возвращает защищенную копию
        return new ArrayList<>(menuItems);
    }
    
    /**
     * Получает количество элементов меню в репозитории
     * @return количество элементов меню
     */
    public int getItemsCount() {
        return menuItems.size();
    }
    
    /**
     * Очищает все элементы меню из репозитория
     */
    public void clearAll() {
        // РЕФАКТОРИНГ: Добавлена массовая операция
        menuItems.clear();
    }
}