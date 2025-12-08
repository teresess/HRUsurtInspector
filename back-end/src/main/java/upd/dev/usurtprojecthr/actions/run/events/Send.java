package upd.dev.usurtprojecthr.actions.run.events;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import upd.dev.usurtprojecthr.Loader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Send {
    Loader bot;
    String text;
    Long chat_id;
    List<List<InlineKeyboardButton>> underMessage = new ArrayList<>();
    ReplyKeyboardMarkup underKeyboard;

    public Send(Loader bot, String text, Long chat_id) {
        this.bot = bot;
        this.text = text;
        this.chat_id = chat_id;
    }
    public Send addRow(InlineKeyboardButton... btns) {

        underMessage.add(new ArrayList<>(Arrays.asList(btns)));
        return this;
    }
    public Send addRow(KeyboardButton... btns) {
        KeyboardRow row = new KeyboardRow();
        List<KeyboardRow> keyboardRows = new ArrayList<>();

        row.addAll(new ArrayList<>(Arrays.asList(btns)));

        if (underKeyboard != null) {
            keyboardRows = underKeyboard.getKeyboard();
        }
        keyboardRows.add(row);

        underKeyboard = new ReplyKeyboardMarkup(keyboardRows);
        underKeyboard.setResizeKeyboard(true);

        return this;
    }

    public void exe() throws TelegramApiException {
        SendMessage sendMessage = new SendMessage(String.valueOf(chat_id), text);
        sendMessage.enableHtml(true);

        if (underMessage != null) {
            sendMessage.setReplyMarkup(new InlineKeyboardMarkup(underMessage));
        }
        if (underKeyboard != null) {
            underKeyboard.setOneTimeKeyboard(false);
            sendMessage.setReplyMarkup(underKeyboard);
        }

        bot.execute(sendMessage);
    }
}