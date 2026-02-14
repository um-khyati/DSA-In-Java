class Solution {
    public int thirdMax(int[] arr) {
        int firstmax = arr[0];
        Integer secondmax = null;
        Integer thirdmax = null;
        for(int i = 1; i < arr.length; i++)
        {
             if(arr[i] == firstmax || secondmax != null && arr[i] == secondmax || thirdmax != null && arr[i] == thirdmax)
            {
                continue;
            }
            if(firstmax < arr[i] )
            {
                thirdmax = secondmax;
                secondmax = firstmax;
                firstmax = arr[i];
            }
           
            else if(secondmax == null)
            {
                secondmax = arr[i];
            }
            else if(secondmax < arr[i] && firstmax > arr[i])
            {
                thirdmax = secondmax;
                secondmax = arr[i];
            }
            else if(thirdmax == null)
            {

                thirdmax = arr[i];
            }
            else if(thirdmax < arr[i] && secondmax > arr[i])
            {
                thirdmax = arr[i];
            }

            
            
        }
        if(thirdmax == null )
        {
            return firstmax;
        }
        return thirdmax;
    }
}