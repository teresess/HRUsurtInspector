package upd.dev.usurtprojecthr.actions;

import upd.dev.usurtprojecthr.Loader;
import upd.dev.usurtprojecthr.actions.run.events.Edit;
import upd.dev.usurtprojecthr.actions.run.events.Remove;
import upd.dev.usurtprojecthr.actions.run.events.Send;

public class Actions {
    public static Send send(Loader bot, String text, Long chat_id) {
        return new Send(bot, text, chat_id);
    }
    public static Edit edit(Loader bot, String text, Long chat_id, int message_id) {
        return new Edit(bot, text, chat_id, message_id);
    }
    public static Remove rem(Loader loader, int mess_id, Long chat_id) {
        return new Remove(loader, mess_id, chat_id);
    }
}
