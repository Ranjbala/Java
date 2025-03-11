package arrays;
import java.util.*;
public class ArrayProblems {
    public static void main(String[] args)
    {
        secondLargest();
        rotateArray();
        sortAlpha();
        twoDArray();
    }

    public static void secondLargest()
    {
        int[] numbers = {13499000,35,12,3,1,5,9,10,22,13,14,15,987,453,650,650};
        int length = numbers.length;
        int max = 0;
        int secondMax = 0;
        for(int i=0; i<length; i++)
        {
            if(numbers[i] > max)
                max = numbers[i];
            if(numbers[i] < max && numbers[i]>= secondMax)
                secondMax = numbers[i];
        }
        System.out.println("Second largest number is "+ secondMax);
    }

    public static void rotateArray()
    {
        int[] numbers = {1,2,43,45,8,9,10,11};
        int length = numbers.length;
        int left = 0;
        int right = length-1;
        while(left <= right)
        {
            int temp = numbers[left];
            numbers[left] = numbers[right];
            numbers[right] = temp;
            left++;
            right--;
        }
        System.out.println("The rotated array "+ Arrays.toString(numbers));
    }

    public static void sortAlpha()
    {
        char[] stringArray = {'q','a', 'l', 'm', 'y', 'p'};
        int length = stringArray.length;
        for(int i=0; i<length; i++)
        {
            char min = stringArray[i];
            int minIndex = i;
            for(int j=i; j<length; j++)
            {
                if(stringArray[j] <= min)
                {
                    min = stringArray[j];
                    minIndex = j;
                }
            }
            char temp = stringArray[i];
            stringArray[i] = stringArray[minIndex];
            stringArray[minIndex] = temp;
        }
        System.out.println("Sorted Array " + Arrays.toString(stringArray));
    }

    public static void twoDArray()
    {
        int[][] matrix = {
            {1,2,3},
            {11,22,33},
            {91,81,71}
        };
        int row = matrix.length;
        int col = matrix[0].length;
        int sum = 0;
        for(int i=0; i<row; i++)
        {
            for(int j=0; j<col; j++)
            {
                if(i == j){
                    sum += matrix[i][j];
                }
            }
        }
        System.out.println("Diagonal sum "+sum);
    }
}