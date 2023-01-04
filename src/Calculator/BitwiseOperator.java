package Calculator;

public class BitwiseOperator {
        public static int largest(int x, int y){
            int z, i, max;

            z = x - y;

            i = (z >> 31) & 1;

            max = x - (i * z);

            return max;
        }

        public static void main(String[] args) {
            int num1 = 35;
            int num2 = 12;

            System.out.println(largest(num1, num2));
        }

}
