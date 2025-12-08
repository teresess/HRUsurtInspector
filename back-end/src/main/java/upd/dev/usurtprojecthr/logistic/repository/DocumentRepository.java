package upd.dev.usurtprojecthr.logistic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import upd.dev.usurtprojecthr.logistic.DocumentType;
import upd.dev.usurtprojecthr.logistic.model.Document;

import java.util.List;
import java.util.Optional;

public interface DocumentRepository extends JpaRepository<Document, Long> {
    @Query("SELECT d FROM Document d WHERE d.documentType = :documentType")
    List<Document> findByDocumentType(@Param("documentType") DocumentType documentType);
}
