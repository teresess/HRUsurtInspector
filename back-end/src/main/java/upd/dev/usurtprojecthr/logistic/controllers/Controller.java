package upd.dev.usurtprojecthr.logistic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import upd.dev.usurtprojecthr.logistic.controllers.request.GameResultsRequest;
import upd.dev.usurtprojecthr.logistic.model.Achievement;
import upd.dev.usurtprojecthr.logistic.model.Document;
import upd.dev.usurtprojecthr.logistic.model.GameSession;
import upd.dev.usurtprojecthr.logistic.model.User;
import upd.dev.usurtprojecthr.logistic.service.DocumentService;
import upd.dev.usurtprojecthr.logistic.service.GameSessionService;
import upd.dev.usurtprojecthr.logistic.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Component
@RestController
@RequestMapping("/api")
public class Controller {
    static Services services;

    @Autowired
    public Controller(UserService userService, DocumentService documentService, GameSessionService gameSessionService) {
        services = new Services(userService, documentService, gameSessionService);
    }

    public static Services get() {
        return services;
    }

    @GetMapping("/document/random")
    public ResponseEntity<List<Document>> getRandomDocuments() {
        return ResponseEntity.ok(services.doc().getRandomDocuments());
    }
    @GetMapping("/document/random-errors")
    public ResponseEntity<List<String>> getRandomErrors() {
        return ResponseEntity.ok(services.doc().getRandomErrors());
    }
    @GetMapping("/document/{id}")
    public ResponseEntity<byte[]> viewPdf(@PathVariable Long id) {
        Document document = services.doc().getDocumentById(id).get();

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline")
                .contentType(MediaType.APPLICATION_PDF)
                .contentLength(document.getPdfData().length)
                .body(document.getPdfData());
    }
    @PostMapping("/game/save")
    public ResponseEntity<String> saveGameResults(@RequestBody GameResultsRequest request) {
        User user = services.user.getUser(request.getUserId());

        List<Document> documents = new ArrayList<>();
        for (Long docId : request.getDocumentIds()) {
            Document doc = services.doc().getDocumentById(docId)
                    .orElseThrow(() -> new RuntimeException("Document not found: " + docId));
            documents.add(doc);
        }

        services.game().saveGameSession(
                user,
                request.getGameMode(),
                request.getScore(),
                request.getAccuracy(),
                request.getErrorsFound(),
                request.getDurationSeconds(),
                documents,
                request.getSessionDetails()
        );
        return ResponseEntity.ok("Daaaam");
    }

    @GetMapping("/game/all")
    public ResponseEntity<List<GameSession>> getAllGames() {
        return ResponseEntity.ok(services.game().getAll());
    }
    @GetMapping("/user/all")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(services.user().getAll());
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<User> getUser(@PathVariable Long userId) {
        return ResponseEntity.ok(services.user().getUser(userId));
    }
    @GetMapping("/user/exp/{userId}")
    public ResponseEntity<Integer> getExp(@PathVariable Long userId) {
        return ResponseEntity.ok(services.user().getExp(userId));
    }
    @GetMapping("/user/coins/{userId}")
    public ResponseEntity<Integer> getCoins(@PathVariable Long userId) {
        return ResponseEntity.ok(services.user().getCoins(userId));
    }
    @GetMapping("/user/coins/take/{userId}/{coins}")
    public ResponseEntity<String> takeCoins(@PathVariable Long userId, @PathVariable Integer coins) {
        services.user().takeCoins(userId, coins);
        return ResponseEntity.ok("Успешно!");
    }
    @GetMapping("/game/list/{userId}")
    public ResponseEntity<List<GameSession>> getGames(@PathVariable Long userId) {
        return ResponseEntity.ok(services.game().getGames(userId));
    }
    @GetMapping("/achievement/all")
    public List<Achievement> getAchievements() {
        return services.user().getAchievements();
    }
}