class User:
    user_counter = 1

    def __init__(self, name, email, phone_number, address, user_type):
        self.user_id = User.user_counter
        User.user_counter += 1
        self.name = name
        self.email = email
        self.phone_number = phone_number
        self.address = address
        self.user_type = user_type

    def get_user_id(self):
        return self.user_id

    def register_user(self):
        print(f"User registered successfully: {self.name} (User ID: {self.user_id})")

    def login(self, email, phone_number):
        if self.email == email and self.phone_number == phone_number:
            print(f"User logged in successfully: {self.name}")
            return True
        else:
            print("Login failed. Incorrect email or phone number.")
            return False

    def update_profile(self, new_address):
        self.address = new_address
        print(f"Profile updated with new address: {self.address}")

    def view_services(self):
        print(f"Viewing available services for user: {self.name}")

    def submit_feedback(self, message):
        print(f"Feedback submitted by User ID: {self.user_id} - {message}")


class Service:
    @staticmethod
    def list_all_services():
        print("1. Birth Certificate - Issuance of Birth Certificate")
        print("2. Residence Certificate - Issuance of Residence Certificate")


class Application:
    def __init__(self, app_id, user_id, service_id, app_date, status, documents):
        self.application_id = app_id
        self.user_id = user_id
        self.service_id = service_id
        self.application_date = app_date
        self.status = status
        self.documents = documents

    def submit_application(self):
        print(f"Application submitted successfully. Application ID: {self.application_id}")

    def check_status(self):
        print(f"Application status: {self.status}")

    def upload_documents(self, new_documents):
        self.documents = new_documents
        print(f"Documents uploaded: {self.documents}")

    def edit_application(self, new_status):
        self.status = new_status
        print(f"Application status updated to: {self.status}")


class Payment:
    def __init__(self, pay_id, app_id, amount, pay_date):
        self.payment_id = pay_id
        self.application_id = app_id
        self.amount = amount
        self.payment_date = pay_date

    def make_payment(self):
        print(f"Payment made successfully. Payment ID: {self.payment_id}")

    def get_payment_status(self):
        print("Payment status: Successful")

    def generate_receipt(self):
        print(f"Receipt generated for Payment ID: {self.payment_id}")


class Notification:
    def __init__(self, notif_id, user_id, message, date):
        self.notification_id = notif_id
        self.user_id = user_id
        self.message = message
        self.date = date

    def send_notification(self, user_id, message):
        print(f"Notification sent to User ID: {user_id} - {message}")

    def mark_as_read(self):
        print("Notification marked as read.")

    def get_notifications(self, user_id):
        print(f"Displaying notifications for User ID: {user_id}")


class Feedback:
    def __init__(self, feed_id, user_id, message, date):
        self.feedback_id = feed_id
        self.user_id = user_id
        self.message = message
        self.date = date

    def submit_feedback(self, user_id, message):
        print(f"Feedback submitted by User ID: {user_id} - {message}")

    def view_feedback(self):
        print(f"Viewing feedback for Feedback ID: {self.feedback_id}")

    def response_to_feedback(self, response):
        print(f"Response to feedback: {response}")


class SystemManager:
    def __init__(self):
        self.user = None
        self.is_logged_in = False

    def show_menu(self):
        print("\n--- Welcome to Goa Online Services ---")
        print("1. Register User")
        print("2. Login")
        print("3. View Services")
        print("4. Submit Application")
        print("5. Make Payment")
        print("6. Send Notification")
        print("7. Submit Feedback")
        print("8. View Departments")
        print("9. Exit")
        option = int(input("Select an option: "))
        return option

    def register_user(self):
        print("Register a new user:")
        name = input("Enter Name: ")
        email = input("Enter Email: ")
        phone_number = input("Enter Phone Number: ")
        address = input("Enter Address: ")
        user_type = input("Enter User Type (Citizen/Admin): ")
        self.user = User(name, email, phone_number, address, user_type)
        self.user.register_user()

    def login_user(self):
        if self.user is None:
            print("No user registered. Please register first.")
        else:
            email = input("Enter Email: ")
            phone_number = input("Enter Phone Number: ")
            self.is_logged_in = self.user.login(email, phone_number)

    def view_services(self):
        if self.is_logged_in:
            Service.list_all_services()
        else:
            print("Please log in first.")

    def submit_application(self):
        if self.is_logged_in:
            print("Submit an Application:")
            app_id = int(input("Enter Application ID: "))
            service_id = int(input("Enter Service ID: "))
            app_date = input("Enter Application Date (YYYY-MM-DD): ")
            status = input("Enter Status (Pending/Approved): ")
            documents = input("Enter Documents: ")
            app = Application(app_id, self.user.get_user_id(), service_id, app_date, status, documents)
            app.submit_application()
        else:
            print("Please log in first.")

    def make_payment(self):
        if self.is_logged_in:
            print("Make a Payment:")
            pay_id = int(input("Enter Payment ID: "))
            app_id = int(input("Enter Application ID: "))
            amount = float(input("Enter Amount: "))
            pay_date = input("Enter Payment Date (YYYY-MM-DD): ")
            payment = Payment(pay_id, app_id, amount, pay_date)
            payment.make_payment()
        else:
            print("Please log in first.")

    def send_notification(self):
        if self.is_logged_in:
            print("Send a Notification:")
            notif_id = int(input("Enter Notification ID: "))
            message = input("Enter Message: ")
            date = input("Enter Date (YYYY-MM-DD): ")
            notification = Notification(notif_id, self.user.get_user_id(), message, date)
            notification.send_notification(self.user.get_user_id(), message)
        else:
            print("Please log in first.")

    def submit_feedback(self):
        if self.is_logged_in:
            print("Submit Feedback:")
            feed_id = int(input("Enter Feedback ID: "))
            message = input("Enter Message: ")
            date = input("Enter Date (YYYY-MM-DD): ")
            feedback = Feedback(feed_id, self.user.get_user_id(), message, date)
            feedback.submit_feedback(self.user.get_user_id(), message)
        else:
            print("Please log in first.")

    def run(self):
        while True:
            option = self.show_menu()
            if option == 1:
                self.register_user()
            elif option == 2:
                self.login_user()
            elif option == 3:
                self.view_services()
            elif option == 4:
                self.submit_application()
            elif option == 5:
                self.make_payment()
            elif option == 6:
                self.send_notification()
            elif option == 7:
                self.submit_feedback()
            elif option == 8:
                print("View Departments functionality not implemented yet.")
            elif option == 9:
                print("Exiting the system.")
                break
            else:
                print("Invalid option. Please try again.")


if __name__ == "__main__":
    manager = SystemManager()
    manager.run()
