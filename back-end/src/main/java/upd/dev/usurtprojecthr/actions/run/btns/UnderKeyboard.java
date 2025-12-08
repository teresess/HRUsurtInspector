package upd.dev.usurtprojecthr.actions.run.btns;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;

public class UnderKeyboard {
    String label;

    public UnderKeyboard(String label) {
        this.label = label;
    }
    public KeyboardButton build() {
        KeyboardButton keyboardButton = new KeyboardButton();
        keyboardButton.setText(label);

        return keyboardButton;
    }
}