import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class WeekOfJune13th {

    public static double sortedArrayMedian(int[] nums1, int[] nums2) {
        int[] mergedArray = new int[nums1.length+nums2.length];
        System.arraycopy(nums1, 0, mergedArray, 0, nums1.length);
        System.arraycopy(nums2, 0, mergedArray, nums1.length, nums2.length);

        // O(n^2)
//        for(int j : mergedArray){
//            for(int i = 0; i < mergedArray.length-1; i++) {
//                if(mergedArray[i] > mergedArray[i+1]) {
//                    int temp = mergedArray[i];
//                    mergedArray[i] = mergedArray[i+1];
//                    mergedArray[i+1] = temp;
//                }
//            }
//        }

        // O(n log n)
        //Arrays.sort(mergedArray);

        // O(n log n)
        int j = 0;
        for (int i = 0; i < mergedArray.length-1; i++) {
            j=i;
            while(mergedArray[j] > mergedArray[j+1]) {
                int temp = mergedArray[i];
                mergedArray[j] = mergedArray[j+1];
                mergedArray[j+1] = temp;
                j = (mergedArray[j] < mergedArray[j-1]) ? --j : ++j ;
            }

        }

        int half = mergedArray.length/2;
        return (mergedArray.length % 2 == 0) ? (double)(mergedArray[half-1]+mergedArray[half])/2 : mergedArray[half] ;
    }

    public static LinkedList<Integer> mergeSortedLists(LinkedList<Integer>[] lists) {
        LinkedList<Integer> sortedList = new LinkedList<>();

        for(int i = 0; i < lists.length-1; i++) if(lists[i] != null) sortedList.addAll(lists[i]);

        // O(n^2)
//        for (int i = 0; i < sortedList.size()-1; i++) {
//            for (int j = 0; j < sortedList.size()-1; j++) {
//                if(sortedList.get(j) > sortedList.get(j+1)) {
//                    int temp = sortedList.get(j);
//                    sortedList.set(j, sortedList.get(j+1));
//                    sortedList.set(j+1, temp);
//                }
//            }
//        }

        // O(n log n)
        Collections.sort(sortedList);

        return sortedList;
    }
}
