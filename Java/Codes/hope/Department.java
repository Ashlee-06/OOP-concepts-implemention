
import java.util.HashMap;
import java.util.Map;

public class Department {
    private int departmentId;
    private String departmentName;
    private String contactInfo;

    // Sample map to simulate departments
    private static Map<Integer, Department> departments = new HashMap<>();

    public Department(int departmentId, String departmentName, String contactInfo) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.contactInfo = contactInfo;
        departments.put(departmentId, this);
    }

    public static void listDepartments() {
        // List all departments
        for (Department department : departments.values()) {
            System.out.println(department.departmentId + ": " + department.departmentName);
        }
    }

    public static void getDepartmentInfo(int departmentId) {
        // Fetch department info
        Department dept = departments.get(departmentId);
        if (dept != null) {
            System.out.println("Department Name: " + dept.departmentName);
            System.out.println("Contact Info: " + dept.contactInfo);
        } else {
            System.out.println("Department not found.");
        }
    }
}
