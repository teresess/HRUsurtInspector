package upd.dev.usurtprojecthr.logistic;

public enum DocumentType {
    EMPLOYMENT_CONTRACT("Трудовой договор"),
    APPLICATION_FOR_ADMISSION("Заявление о приеме"),
    PERSONAL_CARD("Личная карточка Т-2"),
    MEDICAL_BOOK("Медицинская книжка"),
    EDUCATION_DOCS("Документы об образовании"),
    PASSPORT("Паспортные данные"),
    APPLICATION("Трудовая книжка"),
    ORDER("Приказы о приеме/увольнении");

    final private String type;
    DocumentType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
