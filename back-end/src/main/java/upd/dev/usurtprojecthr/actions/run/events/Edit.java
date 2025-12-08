package upd.dev.usurtprojecthr.actions.run.events;

import lombok.Setter;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import upd.dev.usurtprojecthr.Loader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Setter
public class Edit {
    Loader bot;
    String text;
    Long chat_id;
    int message_id;
    List<List<InlineKeyboardButton>> underMessage = new ArrayList<>();

    public Edit(Loader bot, String text, Long chat_id, int message_id) {
        this.bot = bot;
        this.text = text;
        this.chat_id = chat_id;
        this.message_id = message_id;
    }
    public Edit addRow(InlineKeyboardButton... btns) {
        underMessage.add(new ArrayList<>(Arrays.asList(btns)));
        return this;
    }
    public void exe() {
        EditMessageText editMessageText = new EditMessageText();
        editMessageText.setChatId(chat_id);
        editMessageText.setMessageId(message_id);
        editMessageText.setText(text);
        editMessageText.enableHtml(true);

        if (underMessage != null) {
            editMessageText.setReplyMarkup(new InlineKeyboardMarkup(underMessage));
        }

        try {
            bot.execute(editMessageText);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
