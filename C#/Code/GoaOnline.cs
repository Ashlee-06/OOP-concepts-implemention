using System;

namespace GoaOnlineServices
{
    class User
    {
        public int UserId { get; set; }
        public string Name { get; set; }
        public string Email { get; set; }
        public string PhoneNumber { get; set; }
        public string Address { get; set; }
        public string UserType { get; set; }
    }

    class Program
    {
        // Static counter for userId
        private static int userCounter = 1;

        static void Main(string[] args)
        {
            User user = new User();
            bool isLoggedIn = false;
            string email, phoneNumber, newAddress;
            int choice;

            while (true)
            {
                ShowMenu();
                choice = int.Parse(Console.ReadLine());

                switch (choice)
                {
                    case 1:
                        // Register User
                        Console.WriteLine("Register a new user:");
                        Console.Write("Enter Name: ");
                        user.Name = Console.ReadLine();

                        Console.Write("Enter Email: ");
                        user.Email = Console.ReadLine();

                        Console.Write("Enter Phone Number: ");
                        user.PhoneNumber = Console.ReadLine();

                        Console.Write("Enter Address: ");
                        user.Address = Console.ReadLine();

                        Console.Write("Enter User Type (Citizen/Admin): ");
                        user.UserType = Console.ReadLine();

                        user.UserId = userCounter++;
                        RegisterUser(user);
                        break;

                    case 2:
                        // Login User
                        if (user.UserId == 0)
                        {
                            Console.WriteLine("No user registered. Please register first.");
                        }
                        else
                        {
                            Console.WriteLine("Login:");
                            Console.Write("Enter Email: ");
                            email = Console.ReadLine();

                            Console.Write("Enter Phone Number: ");
                            phoneNumber = Console.ReadLine();

                            isLoggedIn = LoginUser(user, email, phoneNumber);
                        }
                        break;

                    case 3:
                        // View Services
                        if (isLoggedIn)
                        {
                            ViewServices();
                        }
                        else
                        {
                            Console.WriteLine("Please log in first.");
                        }
                        break;

                    case 4:
                        // Submit Application
                        if (isLoggedIn)
                        {
                            SubmitApplication();
                        }
                        else
                        {
                            Console.WriteLine("Please log in first.");
                        }
                        break;

                    case 5:
                        // Make Payment
                        if (isLoggedIn)
                        {
                            MakePayment();
                        }
                        else
                        {
                            Console.WriteLine("Please log in first.");
                        }
                        break;

                    case 6:
                        // Send Notification
                        if (isLoggedIn)
                        {
                            SendNotification(user);
                        }
                        else
                        {
                            Console.WriteLine("Please log in first.");
                        }
                        break;

                    case 7:
                        // Submit Feedback
                        if (isLoggedIn)
                        {
                            SubmitFeedback(user);
                        }
                        else
                        {
                            Console.WriteLine("Please log in first.");
                        }
                        break;

                    case 8:
                        // List Departments
                        ListDepartments();
                        break;

                    case 9:
                        // Exit
                        Console.WriteLine("Exiting the application. Thank you for using Goa Online Services!");
                        return;

                    default:
                        Console.WriteLine("Invalid option. Please try again.");
                        break;
                }
            }
        }

        static void ShowMenu()
        {
            Console.WriteLine("\n--- Welcome to Goa Online Services ---");
            Console.WriteLine("1. Register User");
            Console.WriteLine("2. Login");
            Console.WriteLine("3. View Services");
            Console.WriteLine("4. Submit Application");
            Console.WriteLine("5. Make Payment");
            Console.WriteLine("6. Send Notification");
            Console.WriteLine("7. Submit Feedback");
            Console.WriteLine("8. View Departments");
            Console.WriteLine("9. Exit");
            Console.Write("Select an option: ");
        }

        static void RegisterUser(User user)
        {
            Console.WriteLine($"User registered successfully: {user.Name} (User ID: {user.UserId})");
        }

        static bool LoginUser(User user, string email, string phoneNumber)
        {
            if (user.Email == email && user.PhoneNumber == phoneNumber)
            {
                Console.WriteLine($"User logged in successfully: {user.Name}");
                return true;
            }
            else
            {
                Console.WriteLine("Login failed. Incorrect email or phone number.");
                return false;
            }
        }

        static void ViewServices()
        {
            Console.WriteLine("1. Birth Certificate - Issuance of Birth Certificate");
            Console.WriteLine("2. Residence Certificate - Issuance of Residence Certificate");
        }

        static void SubmitApplication()
        {
            Console.WriteLine("Application submitted successfully.");
        }

        static void MakePayment()
        {
            Console.WriteLine("Payment made successfully.");
        }

        static void SendNotification(User user)
        {
            Console.WriteLine($"Notification sent to User ID: {user.UserId}");
        }

        static void SubmitFeedback(User user)
        {
            Console.WriteLine($"Feedback submitted by User ID: {user.UserId}");
        }

        static void ListDepartments()
        {
            Console.WriteLine("List of Departments:");
            Console.WriteLine("1. Health Department - Contact: health@goaonline.gov.in");
            Console.WriteLine("2. Survey Department - Contact: survey@goaonline.gov.in");
        }
    }
}
