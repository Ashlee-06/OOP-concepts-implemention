
public class Document {
    private int documentId;
    private String documentType;
    private String documentPath;
    private int applicationId;

    public Document(int documentId, String documentType, String documentPath, int applicationId) {
        this.documentId = documentId;
        this.documentType = documentType;
        this.documentPath = documentPath;
        this.applicationId = applicationId;
    }

    public void uploadDocument() {
        // Simulate document upload
        System.out.println("Document uploaded at path: " + documentPath);
    }

    public void downloadDocument(int documentId) {
        // Simulate document download
        System.out.println("Downloading document with ID: " + documentId);
    }

    public void validateDocument() {
        // Simulate document validation
        System.out.println("Document validated successfully.");
    }
}
