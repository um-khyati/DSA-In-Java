class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
      bubbleSort(candidates);

      List<List<Integer>> list = new ArrayList<>();

      backtrack(list, new ArrayList<>(), candidates, target, 0);
      
      return list;
    }

    public static void backtrack(List<List<Integer>> list, List<Integer> temp, int[] arr, int tar, int start){

        if(tar == 0) {
            list.add(new ArrayList<>(temp));
            return;
        }

        if(tar < 0){
            return;
        }

        for(int i = start; i < arr.length; i++){
            if(i > start && arr[i] == arr[i-1]){
                continue;
            }
            temp.add(arr[i]);
            backtrack(list, temp, arr, tar - arr[i], i+1 );
            temp.remove(temp.size() - 1);
        }
    }


     private static void bubbleSort(int[] arr){
        int n = arr.length;
        for ( int i = 0; i < n - 1; i++){
            for ( int j = 0; j < n - i - 1; j++){
                if ( arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}