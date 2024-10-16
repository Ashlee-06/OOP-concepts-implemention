
public class User {
    private static int userCounter = 1; // Static counter to generate unique user IDs
    private int userId;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private String userType;

    // Constructor with auto-increment userId
    public User(String name, String email, String phoneNumber, String address, String userType) {
        this.userId = userCounter++;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.userType = userType;
    }

    // Getter for userId
    public int getUserId() {
        return userId;
    }

    public void register() {
        // Simulate registration logic
        System.out.println("User registered successfully: " + name + " (User ID: " + userId + ")");
    }

    public boolean login(String email, String phoneNumber) {
        // Simulate login logic
        if (this.email.equals(email) && this.phoneNumber.equals(phoneNumber)) {
            System.out.println("User logged in successfully: " + name);
            return true;
        } else {
            System.out.println("Login failed. Incorrect email or phone number.");
            return false;
        }
    }

    public void updateProfile(String newAddress) {
        this.address = newAddress;
        System.out.println("Profile updated with new address: " + address);
    }

    public void viewServices() {
        // Simulate viewing services logic
        System.out.println("Viewing available services for user: " + name);
    }

    public void submitFeedback(String message) {
        // Simulate submitting feedback
        System.out.println("Feedback submitted by User ID: " + userId + " - " + message);
    }
}
