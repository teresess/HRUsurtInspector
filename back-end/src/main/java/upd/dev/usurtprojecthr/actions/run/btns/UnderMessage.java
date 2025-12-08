package upd.dev.usurtprojecthr.actions.run.btns;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

public class UnderMessage {
    String label;
    String callback_data;
    String url;
    boolean isPay;

    public UnderMessage(String label, String callback_data) {
        this.isPay = false;
        this.label = label;
        this.callback_data = callback_data;
    }
    public UnderMessage setPay() {

        this.isPay = true;

        return this;
    }
    public UnderMessage setUrl(String url) {

        this.url = url;

        return this;
    }

    public InlineKeyboardButton build() {
        InlineKeyboardButton inlineKeyboardButton = new InlineKeyboardButton();

        if (isPay) {
            inlineKeyboardButton.setPay(true);
        }
        if (url != null) {
            inlineKeyboardButton.setUrl(url);
        }

        inlineKeyboardButton.setText(label);
        inlineKeyboardButton.setCallbackData(callback_data);

        return inlineKeyboardButton;
    }
}