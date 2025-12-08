package upd.dev.usurtprojecthr.logistic.service;

import org.springframework.stereotype.Service;
import upd.dev.usurtprojecthr.logistic.DocumentType;
import upd.dev.usurtprojecthr.logistic.ErrorType;
import upd.dev.usurtprojecthr.logistic.model.Document;
import upd.dev.usurtprojecthr.logistic.repository.DocumentRepository;

import java.util.*;

@Service
public class DocumentService {
    public DocumentRepository documentRepository;

    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public void saveDoc(String errsName, byte[] pdfData, boolean hasChoice, DocumentType documentType, ErrorType errorType) {
        Document document = new Document();
        document.setDocumentType(documentType);
        document.setHasChoice(hasChoice);
        document.setErrorType(errorType);
        document.setPdfData(pdfData);
        document.setErrorsName(errsName);

        documentRepository.save(document);
    }
    public List<Document> getRandomDocuments() {
        List<Document> randomDocuments = new ArrayList<>();
        List<DocumentType> allTypes = Arrays.asList(DocumentType.values());
        Collections.shuffle(allTypes);

        for (DocumentType type : allTypes) {
            if (randomDocuments.size() >= 8) break;

            List<Document> documentsByType = documentRepository.findByDocumentType(type);
            if (!documentsByType.isEmpty()) {
                Random random = new Random();
                Document randomDoc = documentsByType.get(random.nextInt(documentsByType.size()));
                randomDocuments.add(randomDoc);
            }
        }


        return randomDocuments;
    }
    public List<Document> getAll() {
        return documentRepository.findAll();
    }

    public Optional<Document> getDocumentById(Long docId) {
        return documentRepository.findById(docId);
    }
}
