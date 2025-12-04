class Solution {
        public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        Set<Integer> set1 = new HashSet<>();
        for (int x : nums1) {
            set1.add(x);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int x : nums2) {
            set2.add(x);
        }

    
        List<Integer> only1 = new ArrayList<>();
        List<Integer> only2 = new ArrayList<>();

      
        for (int x : set1) {
            if (!set2.contains(x)) {
                only1.add(x);
            }
        }

  
        for (int x : set2) {
            if (!set1.contains(x)) {
                only2.add(x);
            }
        }


        List<List<Integer>> answer = new ArrayList<>();
        answer.add(only1);
        answer.add(only2);
        return answer;
    }

}
