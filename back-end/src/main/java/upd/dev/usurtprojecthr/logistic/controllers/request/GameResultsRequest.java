package upd.dev.usurtprojecthr.logistic.controllers.request;

import lombok.Data;
import upd.dev.usurtprojecthr.logistic.GameMode;
import upd.dev.usurtprojecthr.logistic.model.Document;

import java.util.ArrayList;
import java.util.List;

@Data
public class GameResultsRequest {
    private Long userId;
    private GameMode gameMode;
    private Integer score;
    private Integer accuracy;
    private Integer errorsFound;
    private Integer durationSeconds;
    private List<Long> documentIds = new ArrayList<>();
    private String sessionDetails;
}
