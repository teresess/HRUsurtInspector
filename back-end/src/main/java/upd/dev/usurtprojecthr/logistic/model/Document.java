package upd.dev.usurtprojecthr.logistic.model;

import jakarta.persistence.*;
import lombok.Data;
import upd.dev.usurtprojecthr.logistic.DocumentType;
import upd.dev.usurtprojecthr.logistic.ErrorType;

@Data
@Entity
@Table(name = "documents")
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private DocumentType documentType;

    @Enumerated(EnumType.STRING)
    private ErrorType errorType;

    private Boolean hasChoice;

    @Lob
    @Column(name = "pdf_data", columnDefinition = "BLOB")
    private byte[] pdfData;

    @Column(length = 5000)
    private String errorsName;

    @Column(columnDefinition = "JSON")
    private String templateStructure;
}

