class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0 || target <= 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < candidates.length; i++) {
            backtrack(i, 0, new ArrayList<>(), candidates, target, result);
        }
        return result;
    }
    
    private static void backtrack(int start, int currentSum, List<Integer> current, int[] candidates, int target, List<List<Integer>> result) {
        if (currentSum + candidates[start] > target) {
            return;
        }
        current.add(candidates[start]);
        currentSum += candidates[start];
        if (currentSum == target) {
            result.add(new ArrayList<>(current));
            current.removeLast();
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            backtrack(i, currentSum, current, candidates, target, result);
        }
        current.removeLast();
    }
}