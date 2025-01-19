/*
* Simulate a movie theater that helps users to book and reserve seats.
* 1. reserve seats (if seat is taken, let them know it is taken and suggest an available seat)
* 2. cancel seats
* 3. retrieve initial seating charting
*/
package DoubleDimensionArray;
import java.util.Scanner;

public class MovieTheatreImplementation {
    int[][] arr = null;

//    Constructor
    public MovieTheatreImplementation(char row, int column) {
//        converting rows to an integer value
        int rowName = row - 'A' + 1;
        arr = new int[rowName][column];
        for(int r = 0; r < arr.length; r++) {
            for(int c = 0 ; c < arr[0].length; c++) {
                arr[r][c] = Integer.MIN_VALUE;
            }
        }
    }

//    Method to display the seating chart
//    public void displaySeatingChart() {
//        for(int r = 0; r < arr.length; r++) {
//            for(int c = 0 ; c < arr[r].length; c++) {
//                if (arr[r][c] == Integer.MIN_VALUE) {
//                    System.out.print("□  ");
//                } else {
//                    System.out.print("■  ");
//                }
//            }
//            System.out.println();
//        }
//    }

    public void displaySeatingChart() {
//        Took help from AI to add some fancy spacing to display seat chart
//        Print column numbers
        System.out.print("     ");
        for (int c = 1; c <= arr[0].length; c++) {
            System.out.printf("%-5d", c);
        }
        System.out.println();
        System.out.println();

//        Print rows with row labels and seat symbols
        for (int r = 0; r < arr.length; r++) {
            System.out.printf("%-3c", (char) ('A' + r));
            for (int c = 0; c < arr[r].length; c++) {
                if (arr[r][c] == Integer.MIN_VALUE) {
                    System.out.print("  □  ");
                } else {
                    System.out.print("  ■  ");
                }
            }
            System.out.println();
            System.out.println();
        }
    }

    //    Method to reserve a seat
    public void reserveSeat (char r, int c) {
        try {
            int rowName = r - 'A';
            if (arr[rowName][c] == Integer.MIN_VALUE) {
                arr[rowName][c] = 1;
                System.out.println("\nSeat " + r + (c + 1) + " has been reserved");
            } else {
                System.out.println("\nSorry, Seat " + r + (c + 1) + " is already taken.");
                System.out.println();
                suggestAvailableSeat();
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\nInvalid seat. Please try again with a valid seat number.");
        }
    }

//    Method to suggest available seats
    public void suggestAvailableSeat() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == Integer.MIN_VALUE) {
                    System.out.println("\nThe following seats marked with O are available");
                    System.out.println();
                    displaySeatingChart();
                    return;
                }
            }
        }
        System.out.println("No available seats.");
    }

//    Method to cancel seat
    public void cancelSeat(char r, int c) {
        try {
            int rowName = r - 'A';
            if (arr[rowName][c] == 1) {
                arr[rowName][c] = Integer.MIN_VALUE;
                System.out.println("\nSeat " + r + (c + 1) + " has been canceled");
            } else {
                System.out.println("\nSorry, Seat " + r + (c + 1) + " is not booked. Please enter a valid seat to cancel.");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\nInvalid seat. Please try again with a valid seat number.");
        }
    }
    public static void main(String[] args) {
//        if there are 10 rows and 10 seats in each row
        MovieTheatreImplementation seat = new MovieTheatreImplementation('K',20);
        System.out.println("Welcome to the seat booking app.");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1- To view seating chart type '1'");
            System.out.println("2- To reserve seat type '2'");
            System.out.println("3- To cancel seat type '3'");
            System.out.println("4- To exit the system type '4'");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.println();
                seat.displaySeatingChart();
                System.out.println();
            } else if (choice == 2) {
                System.out.println("\nEnter seat number to reserve (e.g., A1, B3):");
                String input = scanner.nextLine().toUpperCase();
                char row = input.charAt(0);
                int column = Integer.parseInt(input.substring(1)) - 1;
                seat.reserveSeat(row, column);
            } else if (choice ==3) {
                System.out.println("\nEnter your seat number to cancel:");
                String input = scanner.nextLine().toUpperCase();
                char row = input.charAt(0);
                int column = Integer.parseInt(input.substring(1)) - 1;
                seat.cancelSeat(row, column);
            }
            else if (choice == 4) {
                System.out.println("Thank you for using the app!");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();

        }
    }


