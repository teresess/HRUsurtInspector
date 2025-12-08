//package upd.dev.usurtprojecthr.logistic.controllers.dto;
//
//import lombok.Data;
//import upd.dev.usurtprojecthr.logistic.DocumentType;
//import upd.dev.usurtprojecthr.logistic.ErrorType;
//import upd.dev.usurtprojecthr.logistic.GameMode;
//import upd.dev.usurtprojecthr.logistic.model.Document;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//@Data
//public class DocumentDTO {
//    private Long id;
//    private DocumentType documentType;
//    private ErrorType errorType;
//    private String fileName;
//    private String errorsName;
//    private String templateStructure;
//
//    public DocumentDTO(Document document) {
//        this.id = document.getId();
//        this.documentType = document.getDocumentType();
//        this.errorType = document.getErrorType();
//        this.fileName = document.getFileName();
//        this.errorsName = document.getErrorsName();
//        this.templateStructure = document.getTemplateStructure();
//    }
//}
