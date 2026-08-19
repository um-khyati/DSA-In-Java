class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer,HashSet<Integer>> map = new HashMap<>();

        for(int[] arr:reservedSeats){
            if(!map.containsKey(arr[0])){
                map.put(arr[0],new HashSet<>());
                map.get(arr[0]).add(arr[1]);
            }
            else{
                map.get(arr[0]).add(arr[1]);
            }

        }

        int ans = (n-map.size())*2;
        for(HashSet<Integer> val:map.values()){
            boolean flag2 = true;
            boolean flag4 = true;
            boolean flag6 = true;
            if(val.contains(2) || val.contains(3) || val.contains(4) || val.contains(5)){
                flag2 = false;
            }
            if(flag2==true){
                val.add(4);
                ans++;
            }
            if(val.contains(4) || val.contains(5) || val.contains(6) || val.contains(7)){
                flag4 = false;
            }
            if(flag4==true){
                val.add(6);
                ans++;
            }
            if(val.contains(6) || val.contains(7) || val.contains(8) || val.contains(9)){
                flag6 = false;
            }
            if(flag6==true){
                val.add(8);
                ans++;
            }
        }
        return ans;
    }
}