package it.pers.raza;

public class GetOneOddCode {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 3, 3};
        getOneOdd(arr);
    }

    public static void getOneOdd(int[] arr) {
        int eor = 0;
        for (int cur : arr) {
            eor ^= cur;
        }
        System.out.println(eor);
    }

}
