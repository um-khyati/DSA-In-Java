class Solution {
    public boolean checkIfExist(int[] arr) {
        for(int i=0;i<arr.length;i++){
            if(arr[i]%2==0){
                int a=arr[i]/2;
                for(int j=0;j<arr.length;j++){
                    if(arr[j] ==a && i!=j){
                        return true;
                    }
                }
            }
            
        }
        return false;
    }
}