package upd.dev.usurtprojecthr.logistic.controllers;


import upd.dev.usurtprojecthr.logistic.service.DocumentService;
import upd.dev.usurtprojecthr.logistic.service.GameSessionService;
import upd.dev.usurtprojecthr.logistic.service.UserService;

public class Services {

    UserService user;
    DocumentService document;
    GameSessionService gameSessionService;

    public UserService user() {
        return user;
    }
    public DocumentService doc() {
        return document;
    }
    public GameSessionService game() {
        return gameSessionService;
    }

    public Services(UserService user, DocumentService document, GameSessionService gameSessionService) {
        this.user = user;
        this.document = document;
        this.gameSessionService = gameSessionService;
    }
}