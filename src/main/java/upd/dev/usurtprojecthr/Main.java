package upd.dev.usurtprojecthr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
public class Main {

    public static Loader loader;

    public static Loader getLoader() {
        return loader;
    }

    public static void main(String[] args) throws TelegramApiException {

        try {
            SpringApplication.run(Main.class, args);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        TelegramBotsApi tba = new TelegramBotsApi(DefaultBotSession.class);
        System.out.println("main: loading...");
        loader = new Loader();
        tba.registerBot(loader);
    }

}
