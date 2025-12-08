package upd.dev.usurtprojecthr.logistic;

import org.telegram.telegrambots.meta.api.methods.groupadministration.GetChatMember;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.chatmember.ChatMember;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import upd.dev.usurtprojecthr.Main;

import java.util.concurrent.TimeUnit;

public class Util {

    public static DocumentType getDocType(String typeNum) {
        if (typeNum.equals("1")) return DocumentType.EMPLOYMENT_CONTRACT;
        if (typeNum.equals("2")) return DocumentType.APPLICATION_FOR_ADMISSION;
        if (typeNum.equals("3")) return DocumentType.PERSONAL_CARD;
        if (typeNum.equals("4")) return DocumentType.MEDICAL_BOOK;
        if (typeNum.equals("5")) return DocumentType.EDUCATION_DOCS;
        if (typeNum.equals("6")) return DocumentType.PASSPORT;
        if (typeNum.equals("7")) return DocumentType.APPLICATION;
        if (typeNum.equals("8")) return DocumentType.ORDER;

        return null;
    }

    public static Long getChatId(Update update) {
        if (update.hasCallbackQuery()) {
            return update.getCallbackQuery().getMessage().getChatId();
        } else if (update.hasPreCheckoutQuery()) {
            return update.getPreCheckoutQuery().getFrom().getId();
        } else if (update.hasMessage() && update.getMessage().hasText()) {
            return update.getMessage().getChatId();
        }
        return 0L;
    }

    public static String getUserName(Update update) {
        if (update.hasCallbackQuery()) {
            return update.getCallbackQuery().getFrom().getUserName();
        } else if (update.hasPreCheckoutQuery()) {
            return update.getPreCheckoutQuery().getFrom().getUserName();
        } else if (update.hasMessage() && update.getMessage().hasText()) {
            return update.getMessage().getFrom().getUserName();
        }
        return "null";
    }
    public static String formatPhoneNumberStrict(String phoneNumber) {
        String digitsOnly = "7"+phoneNumber.replaceAll("[^0-9]", "");


        return String.format("+7(%s)%s-%s-%s",
                digitsOnly.substring(1, 4),
                digitsOnly.substring(4, 7),
                digitsOnly.substring(7, 9),
                digitsOnly.substring(9));
    }
    public static String formatTimeAgo(long pastTimeInSeconds) {
        long currentTimeInSeconds = System.currentTimeMillis() / 1000L;
        long timeDifference = currentTimeInSeconds - pastTimeInSeconds;

        long days = TimeUnit.SECONDS.toDays(timeDifference);
        long hours = TimeUnit.SECONDS.toHours(timeDifference) % 24;
        long minutes = TimeUnit.SECONDS.toMinutes(timeDifference) % 60;

        StringBuilder result = new StringBuilder();

        if (days > 0) {
            result.append(days).append("д ");
        }

        if (hours > 0) {
            result.append(hours).append("ч ");
        }

        if (minutes > 0) {
            result.append(minutes).append("м ");
        }

        if (result.isEmpty()) {
            return "Только что";
        } else {
            result.append("назад");
            return result.toString();
        }
    }
    public static boolean isUserSubscribed(Long userId) {
        try {
            GetChatMember getChatMember = new GetChatMember();
            getChatMember.setChatId("@urgupschane"); // или ID канала
            getChatMember.setUserId(userId);

            ChatMember chatMember = Main.getLoader().execute(getChatMember);

            return chatMember.getStatus().equals("member") ||
                    chatMember.getStatus().equals("administrator") ||
                    chatMember.getStatus().equals("creator");
        } catch (TelegramApiException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static ErrorType getErrType(String datum) {
        if (datum.equals("1")) return ErrorType.HARD;
        if (datum.equals("2")) return ErrorType.MEDIUM;
        if (datum.equals("3")) return ErrorType.EASY;

        return null;
    }
}
