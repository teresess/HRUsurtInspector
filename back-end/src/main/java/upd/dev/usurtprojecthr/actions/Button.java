package upd.dev.usurtprojecthr.actions;

import upd.dev.usurtprojecthr.actions.run.btns.UnderKeyboard;
import upd.dev.usurtprojecthr.actions.run.btns.UnderMessage;

public class Button {
    public static UnderMessage mess(String label, String callback_date) {
        return new UnderMessage(label, callback_date);
    }
    public static UnderKeyboard key(String label) {
        return new UnderKeyboard(label);
    }
}
