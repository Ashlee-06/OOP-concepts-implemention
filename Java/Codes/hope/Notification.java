
public class Notification {
    private int notificationId;
    private int userId;
    private String message;
    private String date;
    private String status;

    public Notification(int notificationId, int userId, String message, String date) {
        this.notificationId = notificationId;
        this.userId = userId;
        this.message = message;
        this.date = date;
        this.status = "Unread";
    }

    public void sendNotification(int userId, String message) {
        // Simulate sending notification
        System.out.println("Notification sent to User ID: " + userId + " - " + message);
    }

    public void markAsRead() {
        // Mark notification as read
        this.status = "Read";
        System.out.println("Notification marked as read.");
    }

    public void getNotifications(int userId) {
        // Simulate getting notifications for a user
        System.out.println("Fetching notifications for User ID: " + userId);
    }
}
