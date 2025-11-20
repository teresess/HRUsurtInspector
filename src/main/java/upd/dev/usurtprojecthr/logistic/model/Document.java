package upd.dev.usurtprojecthr.logistic.model;

import jakarta.persistence.*;
import lombok.Data;
import upd.dev.usurtprojecthr.logistic.DocumentType;
import upd.dev.usurtprojecthr.logistic.ErrorSeverity;

import java.util.List;

@Data
@Entity
@Table(name = "document_templates")
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private DocumentType documentType;
    private ErrorSeverity errorSeverity;

    private String fileName;
    private String errorName;

    @Column(columnDefinition = "JSON")
    private String templateStructure;
}

