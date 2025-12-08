package upd.dev.usurtprojecthr.handler;

import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;

public interface Execute {
    void exe(Update update, Long chatId) throws TelegramApiException, IOException;
}
