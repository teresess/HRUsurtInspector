package upd.dev.usurtprojecthr.handler.events;

import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;

public interface ButtonEvent {
    void onButtonEvent(Update update) throws TelegramApiException, IOException;
}
