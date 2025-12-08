package upd.dev.usurtprojecthr.handler.commands;

import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import upd.dev.usurtprojecthr.Loader;
import upd.dev.usurtprojecthr.Main;
import upd.dev.usurtprojecthr.actions.Actions;
import upd.dev.usurtprojecthr.actions.Button;
import upd.dev.usurtprojecthr.handler.Execute;
import upd.dev.usurtprojecthr.logistic.controllers.Controller;
import upd.dev.usurtprojecthr.logistic.controllers.Services;

import javax.swing.*;

public class Start implements Execute {

    public Start() {}
    @Override
    public void exe(Update update, Long chatId) throws TelegramApiException {
        Services services = Controller.get();
        Loader loader = Main.getLoader();
        String text = "Вы успешно вошли в систему!";

        services.user().initUser(chatId);

        Actions.send(loader, text, chatId)
                .addRow(
                        Button.mess("Запустить тренажёр", "link").setUrl("https://t.me/hr_inspector_robot/startapp")
                                .build()).exe();
    }
}
//<strong></strong>