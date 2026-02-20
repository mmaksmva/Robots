package gui;

import java.awt.event.KeyEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;

import gui.MainApplicationFrame;
import log.Logger;

//Фабрика для создания меню приложения

public class MenuFactory {

    private final MainApplicationFrame frame;

    public MenuFactory(MainApplicationFrame frame) {
        this.frame = frame;
    }

    //главное меню приложения
    public JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        menuBar.add(createFileMenu());
        menuBar.add(createLookAndFeelMenu());
        menuBar.add(createTestMenu());

        return menuBar;
    }

    //меню "Файл" с пунктом "Выход"
    private JMenu createFileMenu() {
        JMenu fileMenu = new JMenu("Файл");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        fileMenu.add(createExitMenuItem());
        return fileMenu;
    }

    //пункт меню "Выход"
    private JMenuItem createExitMenuItem() {
        JMenuItem exitMenuItem = new JMenuItem("Выход", KeyEvent.VK_X);
        exitMenuItem.addActionListener(e -> frame.exitApplication());
        return exitMenuItem;
    }

    //Создает меню "Режим отображения" для управления LookAndFeel
    private JMenu createLookAndFeelMenu() {
        JMenu lookAndFeelMenu = new JMenu("Режим отображения");
        lookAndFeelMenu.setMnemonic(KeyEvent.VK_V);
        lookAndFeelMenu.getAccessibleContext().setAccessibleDescription(
                "Управление режимом отображения приложения");

        lookAndFeelMenu.add(createSystemLookAndFeelItem());
        lookAndFeelMenu.add(createCrossPlatformLookAndFeelItem());

        return lookAndFeelMenu;
    }

    //пункт меню для системной схемы оформления
    private JMenuItem createSystemLookAndFeelItem() {
        JMenuItem systemLookAndFeel = new JMenuItem("Системная схема", KeyEvent.VK_S);

        systemLookAndFeel.addActionListener(e -> {
            frame.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            frame.invalidate();
        });
        return systemLookAndFeel;
    }

    //пункт меню для универсальной схемы оформления
    private JMenuItem createCrossPlatformLookAndFeelItem() {
        JMenuItem crossplatformLookAndFeel = new JMenuItem("Универсальная схема", KeyEvent.VK_S);
        crossplatformLookAndFeel.addActionListener(e -> {
            frame.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            frame.invalidate();
        });
        return crossplatformLookAndFeel;
    }

    // меню "Тесты
    private JMenu createTestMenu() {
        JMenu testMenu = new JMenu("Тесты");
        testMenu.setMnemonic(KeyEvent.VK_T);
        testMenu.getAccessibleContext().setAccessibleDescription(
                "Тестовые команды");

        testMenu.add(createAddLogMessageItem());

        return testMenu;
    }

    //пункт меню для добавления сообщения в лог
    private JMenuItem createAddLogMessageItem() {
        JMenuItem addLogMessageItem = new JMenuItem("Сообщение в лог", KeyEvent.VK_S);
        addLogMessageItem.addActionListener(e -> Logger.debug("Новая строка"));
        return addLogMessageItem;
    }
}