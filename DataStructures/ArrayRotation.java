package DataStructures;

public class ArrayRotation {

    public static void main(String[] args)
    {
        int[] numbers = {1, 2, 3, 4, 5, 6};
        Print(numbers);

        Rotate(numbers, 3);
        Print(numbers);        
    }

    private static void Print(int[] numbers)
    {
        for (int i = 0; i < numbers.length; ++i)
        {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
    }

    private static void Rotate(int[] numbers, int shift)
    {
        int[] temp = new int[numbers.length];

        for (int i = 0; i < numbers.length; ++i)
        {
            temp[(i + shift) % (numbers.length)] = numbers[i];
        }

        for (int i = 0; i < numbers.length; ++i)
        {
            numbers[i] = temp[i];
        }
    }
}
