import java.sql.*;
import java.util.Scanner;

public class Flight {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String url = "jdbc:mysql://127.0.0.1:3306/flight_db";
        String username = "root";
        String password = "Ehtesham18#";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver is loaded!!");

            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection is established successfully");

            while (true) {
                System.out.println("****** Flight Management System ****** ");
                System.out.println("1. Register the User");
                System.out.println("2. Search for Flights");
                System.out.println("3. Book a Flight");
                System.out.println("4. Cancel Bookings");
                System.out.println("5. View Bookings");
                System.out.println("6. Exit");

                System.out.println("Enter the choice : ");


                int choice = scan.nextInt();
                scan.nextLine();
                Statement stmt = con.createStatement();

                switch (choice) {
                    case 1:
                        registerUser(stmt, scan);
                        break;
                    case 2:
                        searchFlight(stmt, scan);
                        break;
                    case 3:
                        bookFlight(stmt, scan);
                        break;
                    case 4:
                        cancelFlight(stmt, scan);
                        break;
                    case 5:
                        viewFlight(stmt, scan);
                        break;
                    case 6:
                        System.out.println("Exiting!!");
                        con.close();
                        stmt.close();
                        return;
                    default:
                        System.out.println("Invalid Choice .. Try Again!!");
                }

            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void viewFlight(Statement stmt, Scanner scan) throws SQLException {
        System.out.println("Enter the user ID: ");
        int user = scan.nextInt();

        String query = "SELECT * FROM bookings WHERE user_id = " + user;

        ResultSet rs = stmt.executeQuery(query);

        while(rs.next()){
            System.out.println("Booking ID: " + rs.getInt("booking_id")
                    + ", Flight ID: "+rs.getInt("flight_id")
                    + ", Seat Number : " + rs.getInt("seat_number")
                    + ", Status : "+rs.getString("status"));
        }
    }

    private static void cancelFlight(Statement stmt, Scanner scan) throws SQLException {
        System.out.println("Enter the user id to cancel the flight: ");
        int user = scan.nextInt();

        String query = "UPDATE bookings SET status = 'CANCELLED' WHERE user_id = " + user;

        int row = stmt.executeUpdate(query);
        if( row > 0) {
            System.out.println("You flight booking is cancelled!!");


            String cancelQuery = "UPDATE flights SET no_of_seats = no_of_seats + 1 WHERE flight_id = " +
                    "(SELECT flight_id FROM bookings WHERE user_id =" + user + " )";

            int r = stmt.executeUpdate(cancelQuery);
        }
        else {
            System.out.println("Check your bookings carefully!!");
        }
    }

    private static void bookFlight(Statement stmt, Scanner scan) throws SQLException {

        System.out.println("Enter the user ID : ");
        int user = scan.nextInt();
        System.out.println("Enter the flight ID: ");
        int flight = scan.nextInt();

        String flightCheckingQuery = "SELECT no_of_seats FROM flights WHERE flight_id = " + flight;

        ResultSet rs = stmt.executeQuery(flightCheckingQuery);

        if (rs.next() && rs.getInt("no_of_seats") > 0) {
            int seatNumber = rs.getInt("no_of_seats");
            String confirmationQuery = "INSERT INTO bookings(user_id, flight_id, seat_number) values( " + user + "," + flight + "," + seatNumber + ")";
            int rows = stmt.executeUpdate(confirmationQuery);

            String updateQuery = "UPDATE flights SET no_of_seats = no_of_seats - 1 WHERE flight_id = " + flight;
            int row = stmt.executeUpdate(updateQuery);

            System.out.println("Your flight is booked successfully!!!");
        } else {
            System.out.println("Booking is not confirmed");
        }
    }

    private static void searchFlight(Statement stmt, Scanner scan) throws SQLException {

        System.out.println("Enter the Departure : ");
        String departure = scan.nextLine();
        System.out.println("Enter the destination : ");
        String destination = scan.nextLine();

        String query = "SELECT * FROM FLIGHTS WHERE DEPARTURE = '" + departure + "' AND DESTINATION = '" + destination + "' AND NO_OF_SEATS >0";

        ResultSet rs = stmt.executeQuery(query);

        System.out.println("-- Available Flights --");

        while (rs.next()) {
            System.out.println("Flight ID : " + rs.getInt("flight_id") +
                    " , " + " Airline : " + rs.getString("airline") +
                    " , " + " Departure : " + rs.getString("departure") +
                    " , " + " Destination : " + rs.getString("destination") +
                    " , " + " date : " + rs.getDate("date") +
                    " , " + "Number of Seats : " + rs.getInt("no_of_seats") +
                    " , " + "Price: " + rs.getFloat("price"));
        }

    }

    private static void registerUser(Statement stmt, Scanner scan) throws SQLException {

        System.out.println("Enter the name : ");
        String name = scan.nextLine();
        System.out.println("Enter the email ID : ");
        String email = scan.nextLine();
        System.out.println("Enter the number : ");
        int number = scan.nextInt();

        String query =
                "INSERT INTO USERS(name, email_id, number) values('" + name + "','" + email + "','" + number + "')";

        int rows = stmt.executeUpdate(query);

        System.out.println("User is registered successfully!!!");
    }
}