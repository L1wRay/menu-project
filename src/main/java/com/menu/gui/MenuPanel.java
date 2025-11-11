package com.menu.gui;

import javax.swing.*;
import java.awt.*;
import com.menu.repository.MenuRepository;
import com.menu.model.*;

/**
 * Панель управления элементами меню
 */
public class MenuPanel extends JPanel {
    private MenuRepository repository;
    private JList<MenuItem> itemsList;
    private DefaultListModel<MenuItem> listModel;
    
    public MenuPanel(MenuRepository repository) {
        this.repository = repository;
        this.listModel = new DefaultListModel<>();
        this.itemsList = new JList<>(listModel);
        
        initializeComponents();
        loadData();
    }
    
    private void initializeComponents() {
        setLayout(new BorderLayout());
        
        // Панель кнопок
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Добавить");
        JButton removeButton = new JButton("Удалить");
        JButton updateButton = new JButton("Изменить");
        
        // Обработчики событий
        addButton.addActionListener(e -> showAddDialog());
        removeButton.addActionListener(e -> removeSelectedItem());
        updateButton.addActionListener(e -> showUpdateDialog());
        
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(updateButton);
        
        // Список элементов
        add(new JScrollPane(itemsList), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }
    
    private void loadData() {
        listModel.clear();
        repository.getAllItems().forEach(listModel::addElement);
    }
    
    private void showAddDialog() {
        // Диалог для добавления нового элемента
        JTextField nameField = new JTextField();
        JTextField priceField = new JTextField();
        
        Object[] message = {
            "Название:", nameField,
            "Цена:", priceField
        };
        
        int option = JOptionPane.showConfirmDialog(this, message, 
            "Добавить элемент", JOptionPane.OK_CANCEL_OPTION);
            
        if (option == JOptionPane.OK_OPTION) {
            try {
                String name = nameField.getText();
                double price = Double.parseDouble(priceField.getText());
                
                MenuItem newItem = new Drink(name, price, 200); // Пример
                repository.addItem(newItem);
                loadData(); // Обновить список
                
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Ошибка ввода цены");
            }
        }
    }
    
    private void removeSelectedItem() {
        int selectedIndex = itemsList.getSelectedIndex();
        if (selectedIndex != -1) {
            MenuItem item = listModel.get(selectedIndex);
            repository.removeItem(item);
            loadData();
        }
    }
    
    private void showUpdateDialog() {
        int selectedIndex = itemsList.getSelectedIndex();
        if (selectedIndex != -1) {
            MenuItem selectedItem = listModel.get(selectedIndex);
            // Логика изменения элемента
            JOptionPane.showMessageDialog(this, "Функция изменения в разработке");
        }
    }
}