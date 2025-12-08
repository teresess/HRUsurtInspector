package upd.dev.usurtprojecthr.handler.commands;

import org.telegram.telegrambots.meta.api.methods.GetFile;
import org.telegram.telegrambots.meta.api.objects.Document;
import org.telegram.telegrambots.meta.api.objects.File;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import upd.dev.usurtprojecthr.Config;
import upd.dev.usurtprojecthr.Main;
import upd.dev.usurtprojecthr.actions.Actions;
import upd.dev.usurtprojecthr.handler.Execute;
import upd.dev.usurtprojecthr.logistic.DocumentType;
import upd.dev.usurtprojecthr.logistic.ErrorType;
import upd.dev.usurtprojecthr.logistic.Util;
import upd.dev.usurtprojecthr.logistic.controllers.Controller;
import upd.dev.usurtprojecthr.logistic.controllers.Services;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

public class NewDocument implements Execute {
    @Override
    public void exe(Update update, Long chatId) throws TelegramApiException, IOException {
        Services s = Controller.get();
        if (!s.user().isAdmin(chatId)) return;

        String[] data = update.getMessage().getCaption().split(":");
        DocumentType documentType = Util.getDocType(data[1]);
        boolean hasChoice = Boolean.parseBoolean(data[2]);
        String errorsName = data[3];

        Document document = update.getMessage().getDocument();
        GetFile getFile = new GetFile();
        getFile.setFileId(document.getFileId());
        File file = Main.getLoader().execute(getFile);
        Config config = new Config();
        String fileUrl = file.getFileUrl(config.getBotToken());

        byte[] pdfData = downloadFileFromUrl(fileUrl);

        ErrorType errorType = ErrorType.EASY;

        int errCount = errorsName.split(",").length;

        if (hasChoice) {
            if(errCount >= 5) errorType = ErrorType.MEDIUM;
        } else errorType = ErrorType.HARD;

        s.doc().saveDoc(errorsName, pdfData, hasChoice, documentType, errorType);

        Actions.send(Main.getLoader(),
                "✅ Документ успешно добавлен!\n" +
                        "📄 Тип: " + documentType + "\n" +
                        "💾 Есть выбор: " + hasChoice + "\n" +
                        "⚠️ Сложность: " + errorType + "\n" +
                        "📝 Ошибки: \n\n- " + errorsName.replace(",", "\n- ") + "\n\n" +
                        "💾 PDF data size: " + pdfData.length,
                chatId).exe();
    }
    private byte[] downloadFileFromUrl(String fileUrl) throws IOException {
        try (InputStream in = new URL(fileUrl).openStream();
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = in.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }

            return baos.toByteArray();
        }
    }
}