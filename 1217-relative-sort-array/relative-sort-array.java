class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {

       
        int[] count = new int[1001];
        for (int i = 0; i < arr1.length; i++) {
            count[arr1[i]]++;
        }

        int index = 0;
        for (int i = 0; i < arr2.length; i++) {
            int num = arr2[i];
            for (int j = 0; j < count[num]; j++) {
                arr1[index] = num;
                index++;
            }
            count[num] = 0; 
        }

        
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                arr1[index] = i;
                index++;
            }
        }

        return arr1;
    }
}