package DataStructures;

public class KthSmallest {
    
    public static void main(String[] args)
    {
        int[] A = {3, 1, 2, 7, 5, 6, 9, 8};
        Print(A);

        QuickSort(A, 0, A.length - 1);
        Print(A);
    }

    private static void QuickSort(int[] A, int L, int R)
    {
        if (L < R)
        {
            int M = Partition(A, L, R);

            QuickSort(A, L, M - 1);
            QuickSort(A, M + 1, R);
        }
    }

    private static void Swap(int[] A, int i, int j)
    {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    private static void MedianOfThree(int[] A, int L, int M, int R)
    {
        if (A[L] > A[M])
            Swap(A, L, M);
        if (A[R] < A[M])
            Swap(A, R, M);
        if (A[L] > A[R])
            Swap(A, L, R);
        
        Swap(A, L, M);
    }

    private static int Partition(int[] A, int L, int R)
    {
        int M = L + (R - L) / 2;
        MedianOfThree(A, L, M, R);
        int piv = A[L];

        int j = L;
        for (int i = L + 1; i <= R; ++i)
        {
            if (A[i] <= piv)
                Swap(A, i, ++j);
        }

        Swap(A, L, j);
        return j;
    }

    private static void Print(int[] A)
    {
        for (int i = 0; i < A.length; ++i)
            System.out.print(A[i] + " ");
        System.out.println();
    }
    
}
