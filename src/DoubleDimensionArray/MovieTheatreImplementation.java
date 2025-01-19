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

    public void insert (char r, int c, int seatNumber) {
        try {
            int rowName = r - 'A';
            if (arr[rowName][c] == Integer.MIN_VALUE){
                arr[rowName][c] = seatNumber;
                System.out.println("Successfully inserted");
            } else {
                System.out.println("The location is already occupied");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index for 2D array");
        }
    }

    public static void main(String[] args) {
//        if there are 10 rows and 10 seats in each row
        MovieTheatreImplementation seat = new MovieTheatreImplementation('K',10);
        System.out.println("Welcome to the seat booking app.");

    }

}
