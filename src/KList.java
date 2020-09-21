import java.util.Arrays;

class KList {
    /*
        * params:
            * double[][] outerArray - a matrix with nested arrays of double values
        * description: merges nested arrays of the matrix from lowest to greatest
        * return: double[]
    */
    public double[] mergeKLists(double[][] outerArray) {
        int amount = 0;
        double smallest = 0;
        int[] indicies = new int[outerArray.length];
        for(int i = 0; i < outerArray.length; i++) {
            amount = amount + outerArray[i].length;
        }
        double[] mergedArr = new double[amount];
        for(int i = 0; i < amount; i++) {
            smallest = this.findSmallest(indicies, outerArray);
            mergedArr[i] = smallest;
        }
        return mergedArr;
    }

    /*
        * params:
            * int[] indicies - array of indicies, where each index represents the index of the nested array
                               within the matrix, and the value at the index represents the index in the
                               nested array that has not yet been merged
            * double[][] outerArray - the matrix of nested arrays
        * description: finds the smallest value within the nested arrays
        * returns: double
    */
    private double findSmallest(int[] indicies, double[][] outerArray) {
        boolean firstIteration = true;
        double smallest = -1;
        int indexToIncrement = 0;
        for(int i = 0; i < indicies.length; i++) {
            double arr[] = outerArray[i];
            if(arr.length <= indicies[i]) {
                continue;
            }
            if(firstIteration) {
                smallest = arr[indicies[i]];
                indexToIncrement = i;
                firstIteration = false;
                continue;
            }
            if(arr[indicies[i]] < smallest) {
                smallest = arr[indicies[i]];
                indexToIncrement = i;
            }
        }
        indicies[indexToIncrement] = indicies[indexToIncrement] + 1;
        return smallest;
    }

    public static void main(String[] args) {
        KList k = new KList();
        //double[][] testArr = {{1.1, 4.4, 5.5}, {1.1, 3.3, 4.4}, {2.2, 6.6}};
        //double[][] testArr = {};
        //double[][] testArr = {{}};
        double[][] testArr = {{9.7, 17.1}, {15.8}, {12.7, 18.5, 21.27}};
        System.out.println("Result: " + Arrays.toString(k.mergeKLists(testArr)));
    }
}