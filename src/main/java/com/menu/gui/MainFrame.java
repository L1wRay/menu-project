package com.menu.gui;

import javax.swing.*;
import com.menu.repository.MenuRepository;

/**
 * Главное окно приложения
 */
public class MainFrame extends JFrame {
    private MenuRepository repository;
    
    public MainFrame() {
        repository = new MenuRepository();
        initializeUI();
    }
    
    private void initializeUI() {
        setTitle("Menu Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        
        // Создание и добавление панели меню
        MenuPanel menuPanel = new MenuPanel(repository);
        add(menuPanel);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }
}