/* Calculate the average temperature, and give how many days are above the average temperature
* 1. Take an input from the user (e.g. 5)
* 2. Prompt the user to enter all the 5 numbers (temperature values)
* 3. Calculate the average temperature
* 4. Given the average temperature, how many of the numbers in the line 2 are above the average temperature?
*/

package SingleDimensionArray;
import java.util.Scanner;
import java.util.Arrays;

public class TemperatureAboveAverage {
    double arr[] = null;

    public TemperatureAboveAverage(int sizeOfArray) {
        arr = new double[sizeOfArray];
        for (int i =0; i < arr.length; i++) {
            arr[i] = Double.MIN_VALUE;
        }
    }

//    insert
    public void insert(int location, double temp) {
        try {
            if (arr[location] == Double.MIN_VALUE) {
                arr[location] = temp;
                System.out.println("Value of temperature successfully inserted");
            } else {
                System.out.println("The location is already occupied");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index to access array");
        }
    }

//    calculating average
    public static void Average(double[] arr) {
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        double average = sum / arr.length;
        System.out.println("Average temperature = " + average);

        // Calculate the number of days with temperatures above average
        int daysAboveAverage = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > average) {
                daysAboveAverage++;
            }
        }
        System.out.println("Number of days with temperature above average: " + daysAboveAverage);
    }

        public static void main (String[] args){
            TemperatureAboveAverage T1 = new TemperatureAboveAverage(5);

//        To take input from the user
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter temperatures for 5 days in °C");
            for (int i = 0; i < 5; i++) {
                System.out.println("Temperature in °C for day " + (i + 1) + ": ");
                double temp = scanner.nextDouble();
                T1.insert(i, temp);
            }
            System.out.println("Recorded temperatures are: " + Arrays.toString(T1.arr));

//        calling average method
            Average(T1.arr);
            scanner.close();
        }
    }