import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {
        CombinationSum solution = new CombinationSum();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> result = solution.combinationSum(candidates, target);
                System.out.println(result);
    }
        
     private List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(candidates, target, 0, list, result);
                return result;  
            }
        
            private void backtrack(int[] candidates, int remainingTarget, int startIndex, List<Integer> currentCombination, List<List<Integer>> allCombinations) {
               
                if (remainingTarget == 0) {
                    allCombinations.add(new ArrayList<>(currentCombination));
                    return;
                }
                
                for (int i = startIndex; i < candidates.length; i++) {

                    if (candidates[i] > remainingTarget) break;
                    
                    currentCombination.add(candidates[i]);
                    backtrack(candidates, remainingTarget - candidates[i], i, currentCombination, allCombinations);
                    currentCombination.remove(currentCombination.size() - 1);
                }
            }
    
}
