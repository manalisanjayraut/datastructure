package Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class topKFrequentElements {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3, 4, 4, 4, 4, 5};
        int k = 2;
        
        int[] result = function(nums,k);

        for(int i : result){
            System.out.println(i);
        }   
    }

    public static int[] function(int a[], int k){

        if(a.length < k) return null;

        Map<Integer, Integer> map = new HashMap<>();

        for(int i : a){
            map.put(i, map.getOrDefault(i,0)+1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((v1,b) -> v1.getValue() - b.getValue());

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            minHeap.add(entry);
            if(minHeap.size() > k) minHeap.poll();
        }

        List<Integer> result = new ArrayList<>();

        while(!minHeap.isEmpty()){
            result.add(minHeap.poll().getKey());
        }

        Collections.reverse(result);
        return result.stream().mapToInt(i -> i).toArray();
    }
    
}
