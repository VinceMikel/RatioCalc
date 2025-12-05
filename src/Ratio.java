public class Ratio {

    public static double ratio(int[] arr) {

        //simple test to not let an array smaller than 2 to bypass
        if(arr == null || arr.length < 2) {
            throw new IllegalArgumentException("Your array input amount is invalid, please enter more than two elements");
        }

        //initializing values
        double largest1 = 0;
        double largest2 = 0;

        double smallest1 = Integer.MAX_VALUE; // must set it to max value because we need to make sure
        double smallest2 = Integer.MAX_VALUE; //user cannot input something into the array thats bigger

        //for(int i = 0; i < arr.length; i++) { //discard, bad method

            for(int num : arr) { //same as the forloop at top but we need two indexes

                //finding the largest 2
                if (num > largest1) {
                    largest2 = largest1; //largest 2 gets passed down as 1
                    largest1 = num; //and then largest 1 would be what the current num is
                } else if (num > largest2) {
                    largest2 = num; //here we would find the 2nd largest
                }

                if (num < smallest1) { //same thing as the largest1 and 2 operation
                    smallest2 = smallest1;
                    smallest1 = num;
                } else if (num < smallest2) {
                    smallest2 = num;
                }
            }

            //we need to prevent the elements from being divided by 0
            if(smallest1 + smallest2 == 0) {
                throw new ArithmeticException("smallest elements amount to 0, cannot divide");
            }

            double ratio = (largest1 + largest2) / (smallest1 + smallest2);
            return ratio;
            }

//testing
    public static void main(String[] args) {
        //int[] arr = {0, 0, 10, 10};
        //int[] arr = {1};
        int[] arr = {3, 5, 12, 450, 1, 1, 5, 6, 23, 6, 8, 9, 321, 2, 3};
        double result = ratio(arr);
        System.out.println("The ratio is: " + result);
    }

}
