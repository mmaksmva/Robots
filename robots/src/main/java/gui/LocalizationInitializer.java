package gui;

import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class LocalizationInitializer {

    public static void initialize() {
        //TitlePane - это "шапка" окна, где эти кнопки
        //для основны LookAndFee . ButtonText - текст на кнопке
        UIManager.put("InternalFrameTitlePane.restoreButtonText", "Восстановить");
        UIManager.put("InternalFrameTitlePane.moveButtonText", "Переместить");
        UIManager.put("InternalFrameTitlePane.sizeButtonText", "Размер");
        UIManager.put("InternalFrameTitlePane.minimizeButtonText", "Свернуть");
        UIManager.put("InternalFrameTitlePane.maximizeButtonText", "Развернуть");
        UIManager.put("InternalFrameTitlePane.closeButtonText", "Закрыть");

        //Подсказки для кнопок и для Nimbus)когда наводишь мышкой на кнопку-ToolTip
        UIManager.put("InternalFrameTitlePane.closeButtonToolTip", "Закрыть");
        UIManager.put("InternalFrameTitlePane.iconifyButtonToolTip", "Свернуть");
        UIManager.put("InternalFrameTitlePane.maximizeButtonToolTip", "Развернуть");
        UIManager.put("InternalFrameTitlePane.restoreButtonToolTip", "Восстановить");

//СТАНДАРТНЫЕ КЛЮЧИ для Metal например
        UIManager.put("InternalFrame.restoreButtonText", "Восстановить");
        UIManager.put("InternalFrame.moveButtonText", "Переместить");
        UIManager.put("InternalFrame.sizeButtonText", "Размер");
        UIManager.put("InternalFrame.iconifyButtonText", "Свернуть");
        UIManager.put("InternalFrame.maximizeButtonText", "Развернуть");
        UIManager.put("InternalFrame.closeButtonText", "Закрыть");

        UIManager.put("OptionPane.yesButtonText", "Да");
        UIManager.put("OptionPane.noButtonText", "Нет");
        UIManager.put("OptionPane.cancelButtonText", "Отмена");
        UIManager.put("OptionPane.okButtonText", "OK");

        // Принудительно обновляем, если Nimbus уже загружен
        if (UIManager.getLookAndFeel() instanceof NimbusLookAndFeel) {
            UIManager.getLookAndFeel().getDefaults().putAll(UIManager.getDefaults());
        }
    }
}