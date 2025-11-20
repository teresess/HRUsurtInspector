package upd.dev.usurtprojecthr;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import upd.dev.usurtprojecthr.handler.ButtonHandler;
import upd.dev.usurtprojecthr.handler.CommandHandler;
import upd.dev.usurtprojecthr.logistic.Util;

import java.util.Objects;

public class Loader extends TelegramLongPollingBot {
    CommandHandler commandHandler;
    ButtonHandler buttonHandler;
    Config config;

    @SuppressWarnings("deprecation")
    public Loader() {
        config = new Config();

        commandHandler = new CommandHandler();
        buttonHandler = new ButtonHandler();
        System.out.println("Loader: all handlers is loaded");
    }
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            try {
                commandHandler.onCommandEvent(update);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        } else if (update.hasCallbackQuery()) {
            try {
                buttonHandler.onButtonEvent(update);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public String getBotUsername() {
        return config.getBotUserName();
    }
    public String getBotToken() {
        return config.getBotToken();
    }
    public void onRegister() {
        System.out.println("Bot: loaded");
    }

}
