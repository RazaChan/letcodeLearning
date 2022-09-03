package it.pers.raza;

public class GetTwoOddCode {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1,1, 2, 2, 3, 3, 130,130,130,4, 4, 4,4,128,128,129,129,128};
        getTwoOdd(arr);
    }

    public static void getTwoOdd(int[] arr) {
        int eor = 0;
        for (int cur : arr) {
            eor ^= cur;
        }
        // eor = a^b
        // eor必然有一个位置为1
        int rightOne = eor & (~eor + 1);// 取最右侧的1
        /**
         * a:        101001110
         * ~a:       010110001
         * ~a+1:     010110010
         * a&(~a+1): 000000010
         */
        int onlyOne = 0; // eor'=a
        for (int cur : arr) {
            if ((cur & rightOne) == 0) {
                onlyOne ^= cur;
            }
        }
        System.out.println(onlyOne + " " + (eor ^ onlyOne));
    }

}
