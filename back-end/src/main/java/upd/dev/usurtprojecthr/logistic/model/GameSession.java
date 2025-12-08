package upd.dev.usurtprojecthr.logistic.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import upd.dev.usurtprojecthr.logistic.GameMode;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "game_sessions")
public class GameSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "player_id")
    private Long playerId;

    private Integer score;
    private Integer accuracy;
    private Integer errorsFound;
    private Integer durationSeconds;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "game_session_documents",
            joinColumns = @JoinColumn(name = "game_session_id"),
            inverseJoinColumns = @JoinColumn(name = "document_id")
    )
    private List<Document> documents = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private GameMode gameMode;

    @CreationTimestamp
    private LocalDateTime completedAt;

    @Column(columnDefinition = "JSON")
    private String sessionDetails;


    public void addDocument(Document document) {
        if (this.documents == null) {
            this.documents = new ArrayList<>();
        }
        if (!this.documents.contains(document)) {
            this.documents.add(document);
        }
    }
}

