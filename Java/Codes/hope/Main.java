
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User user = null;
        boolean isLoggedIn = false;

        // Predefined departments and services
        Department dept1 = new Department(1, "Revenue Department", "revenue@goa.gov.in");
        Department dept2 = new Department(2, "Transport Department", "transport@goa.gov.in");

        Service service1 = new Service(101, "Birth Certificate", "Issuance of Birth Certificate", 1, 50.0, "ID Proof");
        Service service2 = new Service(102, "Residence Certificate", "Issuance of Residence Certificate", 2, 200.0, "Application Form, ID Proof");

        while (true) {
            // Display menu options
            System.out.println("\n--- Welcome to Goa Online Services ---");
            System.out.println("1. Register User");
            System.out.println("2. Login");
            System.out.println("3. View Services");
            System.out.println("4. Submit Application");
            System.out.println("5. Make Payment");
            System.out.println("6. Send Notification");
            System.out.println("7. Submit Feedback");
            System.out.println("8. View Departments");
            System.out.println("9. Exit");
            System.out.print("Select an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                // Register User
                System.out.println("Register a new user:");
                System.out.print("Enter Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter Email: ");
                String email = scanner.nextLine();
                System.out.print("Enter Phone Number: ");
                String phoneNumber = scanner.nextLine();
                System.out.print("Enter Address: ");
                String address = scanner.nextLine();
                System.out.print("Enter User Type (Citizen/Admin): ");
                String userType = scanner.nextLine();
            
                // Create and register user with auto-assigned userId
                user = new User(name, email, phoneNumber, address, userType);
                user.register();
                break;
            
                case 2:
                    // Login User
                    if (user == null) {
                        System.out.println("No user registered. Please register first.");
                    } else {
                        System.out.println("Login:");
                        System.out.print("Enter Email: ");
                        String loginEmail = scanner.nextLine();
                        System.out.print("Enter Phone Number: ");
                        String loginPhone = scanner.nextLine();
                        isLoggedIn = user.login(loginEmail, loginPhone);
                    }
                    break;

                case 3:
                    // View Services
                    if (isLoggedIn) {
                        Service.listAllServices();
                    } else {
                        System.out.println("Please log in first.");
                    }
                    break;

                case 4:
                    // Submit Application
                    if (isLoggedIn) {
                        System.out.println("Submit an Application:");
                        System.out.print("Enter Application ID: ");
                        int applicationId = scanner.nextInt();
                        System.out.print("Enter Service ID (e.g., 101 for Birth Certificate): ");
                        int serviceId = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        System.out.print("Enter Application Date (YYYY-MM-DD): ");
                        String applicationDate = scanner.nextLine();
                        System.out.print("Enter Status (Pending/Approved): ");
                        String status = scanner.nextLine();
                        System.out.print("Enter Documents (e.g., ID Proof): ");
                        String documents = scanner.nextLine();

                        Application application = new Application(applicationId, user.getUserId(), serviceId, applicationDate, status, documents);
                        application.submitApplication();
                        application.checkStatus();
                    } else {
                        System.out.println("Please log in first.");
                    }
                    break;

                case 5:
                    // Make Payment
                    if (isLoggedIn) {
                        System.out.println("Make a Payment:");
                        System.out.print("Enter Payment ID: ");
                        int paymentId = scanner.nextInt();
                        System.out.print("Enter Application ID: ");
                        int applicationId = scanner.nextInt();
                        System.out.print("Enter Amount: ");
                        double amount = scanner.nextDouble();
                        scanner.nextLine(); // Consume newline
                        System.out.print("Enter Payment Date (YYYY-MM-DD): ");
                        String paymentDate = scanner.nextLine();

                        Payment payment = new Payment(paymentId, applicationId, amount, paymentDate);
                        payment.makePayment();
                    } else {
                        System.out.println("Please log in first.");
                    }
                    break;

                case 6:
                    // Send Notification
                    if (isLoggedIn) {
                        System.out.println("Send a Notification:");
                        System.out.print("Enter Notification Message: ");
                        String message = scanner.nextLine();

                        Notification notification = new Notification(501, user.getUserId(), message, "2024-08-30");
                        notification.sendNotification(user.getUserId(), message);
                    } else {
                        System.out.println("Please log in first.");
                    }
                    break;

                case 7:
                    // Submit Feedback
                    if (isLoggedIn) {
                        System.out.println("Submit Feedback:");
                        System.out.print("Enter Feedback Message: ");
                        String feedbackMessage = scanner.nextLine();

                        Feedback feedbackObj = new Feedback(601, user.getUserId(), feedbackMessage, "2024-08-30");
                        feedbackObj.submitFeedback(user.getUserId(), feedbackMessage);
                    } else {
                        System.out.println("Please log in first.");
                    }
                    break;

                case 8:
                    // View Departments
                    Department.listDepartments();
                    break;

                case 9:
                    // Exit
                    System.out.println("Exiting the application. Thank you!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
