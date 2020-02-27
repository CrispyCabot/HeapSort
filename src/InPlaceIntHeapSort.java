public class InPlaceIntHeapSort {
    public static void main(String args[]) {
        int[] array = {27,22,11,18,4,9,19,20};
        heapSort(array);
        for (int i=0; i<array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }
    public static void heapSort(int[] array) {
        int n = array.length;

        //Part I: Turn the array into a max-heap
        for (int i=1; i < n-1; i++) {
            int parent = (i - 1) / 2;
            int currIndex = i;
            while (parent < n && parent >= 0 && array[currIndex] > array[parent]) { //while child is greater than parent, swap them
                int temp = array[i]; //Swap them
                array[i] = array[parent];
                array[parent] = temp;
                //Change values to continue sift up
                currIndex = parent;
                parent = (currIndex - 1) / 2;
            }
        }
        for (int i=0; i<array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
        //Part II: Repeatedly extract the max element from the heap
        int lastIndex = n-1;
        for (int i=n-1; i>0; i--) {
            //swap last val with first val
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            lastIndex--; //Cuts off the sorted part from sifting
            //Sift down element at index 0
            int leftChild = 1;
            int rightChild = 2;
            int currIndex = 0;
            //while currIndex is inside unsorted heap &
            //currIndex has a child which is inside unsorted heap and greater than it
            while ((currIndex >= 0 && currIndex < lastIndex) &&
                    (leftChild <= lastIndex && array[currIndex] < array[leftChild] || rightChild < lastIndex &&array[currIndex] < array[rightChild])) {
                if (array[leftChild] > array[rightChild]) {
                    //Swap leftChild with currIndex
                    temp = array[currIndex];
                    array[currIndex] = array[leftChild];
                    array[leftChild] = temp;
                    currIndex = leftChild;
                }
                else {
                    //Swap rightChild with currIndex
                    temp = array[currIndex];
                    array[currIndex] = array[rightChild];
                    array[rightChild] = temp;
                    currIndex = rightChild;
                }
                leftChild = 2*currIndex+1;
                rightChild = 2*currIndex+2;
            }
        }
    }
}
