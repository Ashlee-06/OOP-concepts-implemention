
public class Feedback {
    private int feedbackId;
    private int userId;
    private String message;
    private String date;
    private String response;

    public Feedback(int feedbackId, int userId, String message, String date) {
        this.feedbackId = feedbackId;
        this.userId = userId;
        this.message = message;
        this.date = date;
        this.response = "";
    }

    public void submitFeedback(int userId, String message) {
        // Simulate submitting feedback
        System.out.println("Feedback submitted by User ID: " + userId + " - " + message);
    }

    public void viewFeedback() {
        // Display feedback details
        System.out.println("Feedback: " + message);
    }

    public void responseToFeedback(String response) {
        // Respond to feedback
        this.response = response;
        System.out.println("Response to feedback: " + response);
    }
}
