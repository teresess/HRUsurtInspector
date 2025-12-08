package upd.dev.usurtprojecthr.handler;

import lombok.Getter;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import upd.dev.usurtprojecthr.Main;
import upd.dev.usurtprojecthr.actions.Actions;
import upd.dev.usurtprojecthr.handler.commands.NewAchievement;
import upd.dev.usurtprojecthr.handler.commands.NewDocument;
import upd.dev.usurtprojecthr.handler.commands.Start;
import upd.dev.usurtprojecthr.handler.events.CommandEvent;
import upd.dev.usurtprojecthr.logistic.Util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CommandHandler implements CommandEvent {

    @Getter
    public static Map<String, Execute> cmds = new HashMap<>();
    int counter = 0;
    public CommandHandler() {

        regCmd("start", new Start());
        regCmd("nd", new NewDocument());
        regCmd("na", new NewAchievement());

        System.out.printf("CommandHandler: load %s commands\n", counter);
    }
    @Override
    public void onCommandEvent(Update update) throws TelegramApiException, IOException {
        String cmd;
        if (update.getMessage().hasDocument()) {
            cmd = update.getMessage().getCaption().split(":")[0];
        } else {
            cmd = update.getMessage().getText().replace("/", "").split(":")[0];
        }

        Long chatId = update.getMessage().getChatId();

//        if (!Util.isUserSubscribed(chatId)) {
//            Actions.send(
//                    Main.getLoader(), "Что-бы пользоваться ботом нужно быть подписанным на канал: <strong>@urgupschane</strong>.\n\nЕсли подписался — /start", chatId)
//                        .exe();
//            return;
//        }

        if (cmds.containsKey(cmd)) {
            cmds.get(cmd).exe(update, chatId);
        }
    }
    void regCmd(String name, Execute event) {
        cmds.put(name, event);
        counter++;
    }
}