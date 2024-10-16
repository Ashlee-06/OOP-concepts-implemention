
import java.util.HashMap;
import java.util.Map;

public class Application {
    private int applicationId;
    private int userId;
    private int serviceId;
    private String applicationDate;
    private String status;
    private String documents;

    // Sample map to simulate submitted applications
    private static Map<Integer, Application> applications = new HashMap<>();

    public Application(int applicationId, int userId, int serviceId, String applicationDate, String status, String documents) {
        this.applicationId = applicationId;
        this.userId = userId;
        this.serviceId = serviceId;
        this.applicationDate = applicationDate;
        this.status = status;
        this.documents = documents;
        applications.put(applicationId, this);
    }

    public void submitApplication() {
        // Logic to submit the application
        this.status = "Submitted";
        System.out.println("Application submitted successfully.");
    }

    public void checkStatus() {
        // Logic to check the application status
        System.out.println("Application Status: " + status);
    }

    public void uploadDocuments(String newDocuments) {
        // Logic to upload documents
        this.documents = newDocuments;
        System.out.println("Documents uploaded successfully.");
    }

    public void editApplication(String newStatus) {
        // Logic to edit the application
        this.status = newStatus;
        System.out.println("Application updated successfully.");
    }
}
