/*
* Simulate a movie theater that helps users to book and reserve seats.
* 1. reserve seats (if seat is taken, let them know it is taken and suggest an available seat)
* 2. cancel seats
* 3. retrieve initial seating charting
*/
package DoubleDimensionArray;
import java.util.Scanner;
import java.util.Arrays;

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

//    public void insert (char r, int c, int seatNumber) {
//        try {
//            int rowName = r - 'A';
//            if (arr[rowName][c] == Integer.MIN_VALUE){
//                arr[rowName][c] = seatNumber;
//                System.out.println("Successfully inserted");
//            } else {
//                System.out.println("The location is already occupied");
//            }
//        } catch (ArrayIndexOutOfBoundsException e) {
//            System.out.println("Invalid index for 2D array");
//        }
//    }

//    Method to display the seating chart
    public void displaySeatingChart() {
        for(int r = 0; r < arr.length; r++) {
            for(int c = 0 ; c < arr[r].length; c++) {
                if (arr[r][c] == Integer.MIN_VALUE) {
                    System.out.print("O ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
//        if there are 10 rows and 10 seats in each row
        MovieTheatreImplementation seat = new MovieTheatreImplementation('K',10);
        System.out.println("Welcome to the seat booking app.");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("To view seating chart type 1");
            System.out.println("To reserve seat type 2");
            System.out.println("To exit the system type 3");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                seat.displaySeatingChart();
                System.out.println();
            } else if (choice == 2) {
                System.out.println();
            } else if (choice == 3) {
                System.out.println("Thank you for using the app!");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();

        }
    }


