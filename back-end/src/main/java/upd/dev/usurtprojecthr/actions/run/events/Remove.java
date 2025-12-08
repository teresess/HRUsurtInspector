package upd.dev.usurtprojecthr.actions.run.events;

import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import upd.dev.usurtprojecthr.Loader;

public class Remove {
    Loader loader;
    int mess_id;
    Long chat_id;

    public Remove(Loader loader, int mess_id, Long chat_id) {
        this.loader = loader;
        this.chat_id = chat_id;
        this.mess_id = mess_id;
    }
    public void exe() throws TelegramApiException {
        DeleteMessage deleteMessage = new DeleteMessage();
        deleteMessage.setMessageId(mess_id);
        deleteMessage.setChatId(chat_id);
        loader.execute(deleteMessage);
    }
}
