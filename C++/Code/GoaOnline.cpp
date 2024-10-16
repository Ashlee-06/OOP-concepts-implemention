#include <iostream>
#include <string>

using namespace std;

class User {
private:
    static int userCounter;
    int userId;
    string name;
    string email;
    string phoneNumber;
    string address;
    string userType;

public:
    User(const string &name, const string &email, const string &phoneNumber, const string &address, const string &userType)
        : name(name), email(email), phoneNumber(phoneNumber), address(address), userType(userType) {
        userId = userCounter++;
    }

    int getUserId() const {
        return userId;
    }

    void registerUser() const {
        cout << "User registered successfully: " << name << " (User ID: " << userId << ")" << endl;
    }

    bool login(const string &email, const string &phoneNumber) const {
        if (this->email == email && this->phoneNumber == phoneNumber) {
            cout << "User logged in successfully: " << name << endl;
            return true;
        } else {
            cout << "Login failed. Incorrect email or phone number." << endl;
            return false;
        }
    }

    void updateProfile(const string &newAddress) {
        address = newAddress;
        cout << "Profile updated with new address: " << address << endl;
    }

    void viewServices() const {
        cout << "Viewing available services for user: " << name << endl;
    }

    void submitFeedback(const string &message) const {
        cout << "Feedback submitted by User ID: " << userId << " - " << message << endl;
    }
};

// Initialize static counter
int User::userCounter = 1;

class Service {
public:
    static void listAllServices() {
        cout << "1. Birth Certificate - Issuance of Birth Certificate" << endl;
        cout << "2. Driving License - Issuance of Driving License" << endl;
    }
};

class Application {
private:
    int applicationId;
    int userId;
    int serviceId;
    string applicationDate;
    string status;
    string documents;

public:
    Application(int appId, int userId, int serviceId, const string &appDate, const string &status, const string &documents)
        : applicationId(appId), userId(userId), serviceId(serviceId), applicationDate(appDate), status(status), documents(documents) {}

    void submitApplication() const {
        cout << "Application submitted successfully. Application ID: " << applicationId << endl;
    }

    void checkStatus() const {
        cout << "Application status: " << status << endl;
    }

    void uploadDocuments(const string &newDocuments) {
        documents = newDocuments;
        cout << "Documents uploaded: " << documents << endl;
    }

    void editApplication(const string &newStatus) {
        status = newStatus;
        cout << "Application status updated to: " << status << endl;
    }
};

class Payment {
private:
    int paymentId;
    int applicationId;
    double amount;
    string paymentDate;

public:
    Payment(int payId, int appId, double amount, const string &payDate)
        : paymentId(payId), applicationId(appId), amount(amount), paymentDate(payDate) {}

    void makePayment() const {
        cout << "Payment made successfully. Payment ID: " << paymentId << endl;
    }

    void getPaymentStatus() const {
        cout << "Payment status: Successful" << endl;
    }

    void generateReceipt() const {
        cout << "Receipt generated for Payment ID: " << paymentId << endl;
    }
};

class Notification {
private:
    int notificationId;
    int userId;
    string message;
    string date;

public:
    Notification(int notifId, int userId, const string &message, const string &date)
        : notificationId(notifId), userId(userId), message(message), date(date) {}

    void sendNotification(int userId, const string &message) const {
        cout << "Notification sent to User ID: " << userId << " - " << message << endl;
    }

    void markAsRead() const {
        cout << "Notification marked as read." << endl;
    }

    void getNotifications(int userId) const {
        cout << "Displaying notifications for User ID: " << userId << endl;
    }
};

class Feedback {
private:
    int feedbackId;
    int userId;
    string message;
    string date;

public:
    Feedback(int feedId, int userId, const string &message, const string &date)
        : feedbackId(feedId), userId(userId), message(message), date(date) {}

    void submitFeedback(int userId, const string &message) const {
        cout << "Feedback submitted by User ID: " << userId << " - " << message << endl;
    }

    void viewFeedback() const {
        cout << "Viewing feedback for Feedback ID: " << feedbackId << endl;
    }

    void responseToFeedback(const string &response) const {
        cout << "Response to feedback: " << response << endl;
    }
};

class SystemManager {
private:
    User* user;
    bool isLoggedIn;

    void showMenu() const {
        cout << "\n--- Welcome to Goa Online Services ---" << endl;
        cout << "1. Register User" << endl;
        cout << "2. Login" << endl;
        cout << "3. View Services" << endl;
        cout << "4. Submit Application" << endl;
        cout << "5. Make Payment" << endl;
        cout << "6. Send Notification" << endl;
        cout << "7. Submit Feedback" << endl;
        cout << "8. View Departments" << endl;
        cout << "9. Exit" << endl;
        cout << "Select an option: ";
    }

    void registerUser() {
        string name, email, phoneNumber, address, userType;
        cout << "Register a new user:" << endl;
        cout << "Enter Name: ";
        getline(cin, name);

        cout << "Enter Email: ";
        getline(cin, email);

        cout << "Enter Phone Number: ";
        getline(cin, phoneNumber);

        cout << "Enter Address: ";
        getline(cin, address);

        cout << "Enter User Type (Citizen/Admin): ";
        getline(cin, userType);

        user = new User(name, email, phoneNumber, address, userType);
        user->registerUser();
    }

    void loginUser() {
        if (user == nullptr) {
            cout << "No user registered. Please register first." << endl;
        } else {
            string email, phoneNumber;
            cout << "Login:" << endl;
            cout << "Enter Email: ";
            getline(cin, email);

            cout << "Enter Phone Number: ";
            getline(cin, phoneNumber);

            isLoggedIn = user->login(email, phoneNumber);
        }
    }

    void viewServices() const {
        if (isLoggedIn) {
            Service::listAllServices();
        } else {
            cout << "Please log in first." << endl;
        }
    }

    void submitApplication() const {
        if (isLoggedIn) {
            cout << "Submit an Application:" << endl;
            int applicationId, serviceId;
            string applicationDate, status, documents;

            cout << "Enter Application ID: ";
            cin >> applicationId;

            cout << "Enter Service ID: ";
            cin >> serviceId;
            cin.ignore(); // Ignore newline character

            cout << "Enter Application Date (YYYY-MM-DD): ";
            getline(cin, applicationDate);

            cout << "Enter Status (Pending/Approved): ";
            getline(cin, status);

            cout << "Enter Documents: ";
            getline(cin, documents);

            Application app(applicationId, user->getUserId(), serviceId, applicationDate, status, documents);
            app.submitApplication();
        } else {
            cout << "Please log in first." << endl;
        }
    }

    void makePayment() const {
        if (isLoggedIn) {
            cout << "Make a Payment:" << endl;
            int paymentId, applicationId;
            double amount;
            string paymentDate;

            cout << "Enter Payment ID: ";
            cin >> paymentId;

            cout << "Enter Application ID: ";
            cin >> applicationId;

            cout << "Enter Amount: ";
            cin >> amount;
            cin.ignore(); // Ignore newline character

            cout << "Enter Payment Date (YYYY-MM-DD): ";
            getline(cin, paymentDate);

            Payment payment(paymentId, applicationId, amount, paymentDate);
            payment.makePayment();
        } else {
            cout << "Please log in first." << endl;
        }
    }

    void sendNotification() const {
        if (isLoggedIn) {
            cout << "Send a Notification:" << endl;
            int notificationId;
            string message, date;

            cout << "Enter Notification ID: ";
            cin >> notificationId;
            cin.ignore(); // Ignore newline character

            cout << "Enter Message: ";
            getline(cin, message);

            cout << "Enter Date (YYYY-MM-DD): ";
            getline(cin, date);

            Notification notification(notificationId, user->getUserId(), message, date);
            notification.sendNotification(user->getUserId(), message);
        } else {
            cout << "Please log in first." << endl;
        }
    }

    void submitFeedback() const {
        if (isLoggedIn) {
            cout << "Submit Feedback:" << endl;
            int feedbackId;
            string message, date;

            cout << "Enter Feedback ID: ";
            cin >> feedbackId;
            cin.ignore(); // Ignore newline character

            cout << "Enter Message: ";
            getline(cin, message);

            cout << "Enter Date (YYYY-MM-DD): ";
            getline(cin, date);

            Feedback feedback(feedbackId, user->getUserId(), message, date);
            feedback.submitFeedback(user->getUserId(), message);
        } else {
            cout << "Please log in first." << endl;
        }
    }

public:
    SystemManager() : user(nullptr), isLoggedIn(false) {}

    void run() {
        int option;
        while (true) {
            showMenu();
            cin >> option;
            cin.ignore(); // Ignore newline character

            switch (option) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    loginUser();
                    break;
                case 3:
                    viewServices();
                    break;
                case 4:
                    submitApplication();
                    break;
                case 5:
                    makePayment();
                    break;
                case 6:
                    sendNotification();
                    break;
                case 7:
                    submitFeedback();
                    break;
                case 8:
                    cout << "View Departments functionality not implemented yet." << endl;
                    break;
                case 9:
                    cout << "Exiting the system." << endl;
                    return;
                default:
                    cout << "Invalid option. Please try again." << endl;
            }
        }
    }
};

int main() {
    SystemManager manager;
    manager.run();
    return 0;
}
