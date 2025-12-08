package upd.dev.usurtprojecthr.handler;

import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import upd.dev.usurtprojecthr.handler.buttons.*;
import upd.dev.usurtprojecthr.handler.commands.Start;
import upd.dev.usurtprojecthr.handler.events.ButtonEvent;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ButtonHandler implements ButtonEvent {
    Map<String, Execute> btns = new HashMap<>();
    int counter = 0;
    public ButtonHandler() {

//        regBtn("teacherListForRead", );

        System.out.printf("ButtonHandler: load %s buttons\n", counter);
    }
    @Override
    public void onButtonEvent(Update update) throws TelegramApiException, IOException {
        String btnId = update.getCallbackQuery().getData().split("_")[0];
        Long chatId = update.getCallbackQuery().getMessage().getChatId();

        if (btns.containsKey(btnId)) {
            btns.get(btnId).exe(update, chatId);
        }
    }
    void regBtn(String name, Execute event) {
        btns.put(name, event);
        counter++;
    }
}
