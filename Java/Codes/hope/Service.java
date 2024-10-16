
import java.util.HashMap;
import java.util.Map;

public class Service {
    private int serviceId;
    private String serviceName;
    private String description;
    private int departmentId;
    private double fee;
    private String requiredDocuments;

    // Sample map to simulate available services
    private static Map<Integer, Service> services = new HashMap<>();

    public Service(int serviceId, String serviceName, String description, int departmentId, double fee, String requiredDocuments) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.description = description;
        this.departmentId = departmentId;
        this.fee = fee;
        this.requiredDocuments = requiredDocuments;
        services.put(serviceId, this);
    }

    public static void listAllServices() {
        // Display all services
        for (Service service : services.values()) {
            System.out.println(service.serviceId + ": " + service.serviceName);
        }
    }

    public static void getServiceDetails(int serviceId) {
        // Fetch and display service details
        Service service = services.get(serviceId);
        if (service != null) {
            System.out.println("Service Name: " + service.serviceName);
            System.out.println("Description: " + service.description);
            System.out.println("Fee: " + service.fee);
            System.out.println("Required Documents: " + service.requiredDocuments);
        } else {
            System.out.println("Service not found.");
        }
    }

    public double calculateFee() {
        // Basic fee calculation logic
        return fee;
    }
}
