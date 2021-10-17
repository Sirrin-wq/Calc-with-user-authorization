package task;

import java.util.Scanner;

public class Calculator {
    public void logic() {
        Scanner scan = new Scanner(System.in);
        double[] history = new double[5];
        double a, b;
        String firstPick;
        String secondPick;
        int counter = 0; // counter for user activity history
        double result;

        int secCounter = 0; // counter for proper user placement in the array
        User user = new User();
        User[] arr = new User[100];

        do {
            do {
                System.out.println("1) Registration\n2) Authorization\n3) Exit");
                firstPick = scan.nextLine();

                switch (firstPick) {
                    case "1":
                        user = registration(scan, arr);
                        arr[secCounter] = user;
                        secCounter++;
                        break;

                    case "2":
                        user = authorization(scan, arr);
                        break;

                    case "3":
                        System.out.println("Goodbye");
                        break;

                    default:
                        System.out.println("This command does not exist");
                }
            } while (!firstPick.equals("3") && user.isReturnIndicator());

            if (firstPick.equals("3")){
                scan.close();
                break;
            }
            user.setReturnIndicator(false);

            do {
                System.out.println("\nMenu:");
                System.out.println("""
                        1. Addition
                        2. Subtraction
                        3. Multiplication
                        4. Division
                        5. 5 previous results
                        6. Back to registration and authorization""");

                secondPick = scan.nextLine();

                switch (secondPick) {
                    case "1":
                        System.out.println("Enter two real numbers");
                        a = scan.nextDouble();
                        b = scan.nextDouble();
                        scan.nextLine();
                        result = ArithmeticOperations.addition(a, b);
                        history[counter] = result;
                        System.out.println("Result: " + result);
                        counter++;
                        break;

                    case "2":
                        System.out.println("Enter two real numbers");
                        a = scan.nextDouble();
                        b = scan.nextDouble();
                        scan.nextLine();
                        result = ArithmeticOperations.subtraction(a, b);
                        history[counter] = result;
                        System.out.println("Result: " + result);
                        counter++;
                        break;

                    case "3":
                        System.out.println("Enter two real numbers");
                        a = scan.nextDouble();
                        b = scan.nextDouble();
                        scan.nextLine();
                        result = ArithmeticOperations.multiplication(a, b);
                        history[counter] = result;
                        System.out.println("Result: " + result);
                        counter++;
                        break;

                    case "4":
                        System.out.println("Enter two real numbers");
                        a = scan.nextDouble();
                        b = scan.nextDouble();
                        scan.nextLine();
                        result = ArithmeticOperations.division(a, b);
                        history[counter] = result;
                        System.out.println("Result: " + result);
                        counter++;
                        break;

                    case "5":
                        for (int i = 0; i < 5; i++) {
                            System.out.print(history[i] + ",  ");
                        }
                        break;

                    case "6":
                        break;

                    default:
                        System.out.println("This command does not exist");
                }
                if (counter > 4) {
                    counter = 0;
                }

            } while (!secondPick.equals("6"));

        } while (true);
    }


    public User registration(Scanner scan, User[] arr){
        User user = new User();
        System.out.println("Create your login");
        String login = scan.nextLine();
        System.out.println("Create your password");
        String password = scan.nextLine();

        boolean loginExist = false;
        boolean passwordExist= false;


        for (User object : arr) {
            if (object != null) {
                if (object.getLogin().equals(login)) {
                    user.setReturnIndicator(true);
                    loginExist = true;
                }
                if (object.getPassword().equals(password)) {
                    user.setReturnIndicator(true);
                    passwordExist = true;
                }
            } else {
                break;
            }
        }
        if (loginExist && passwordExist){
            System.out.println("These login and password are already exist");
        } else if (loginExist){
            System.out.println("This login is already exist");
        } else if (passwordExist){
            System.out.println("This password is already exist");
        } else {
            user.setLogin(login);
            user.setPassword(password);
            user.setReturnIndicator(false);
        }
        return user;
    }

    public User authorization(Scanner scan, User[] arr){
        User user = null;

            System.out.println("Enter your login");
            String login = scan.nextLine();
            System.out.println("Enter your password");
            String password = scan.nextLine();
            for (int i = 0; i < 100; i++) {
                if (arr[i] != null) {
                    if (arr[i].getLogin().equals(login) && arr[i].getPassword().equals(password)) {
                        System.out.println("Welcome back");
                        user = arr[i];
                        break;
                    }
                } else {
                    System.out.println("There are no users with this password or login");
                    user = new User();
                    user.setReturnIndicator(true);
                    break;
                }
            }
        return user;
    }
}
