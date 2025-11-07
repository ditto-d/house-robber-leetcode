 class HouseRobber {


    public int rob(int[] nums) {
        // empty array
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // maxTwoBack: maximum money we could rob up to 2 houses ago
        // maxOneBack: maximum money we could rob up to 1 house ago
        int maxTwoBack = 0;
        int maxOneBack = 0;

        // proccesing each house
        for (int num : nums) {
            // we can either rob this house or skip it
            // 1. we skip this house -> keep maxOneBack
            // 2. rob this house -> take num + maxTwoBack
            //(can't use maxOneBack because adjacent house)
            int maxCurrent = Math.max(maxOneBack, maxTwoBack + num);

            // sliding forward for the next iteration
            maxTwoBack = maxOneBack;  // old "one back" becomes "two back"
            maxOneBack = maxCurrent;   // current max becomes "one back"
        }

        // after processing all houses, maxOneBack contains the answer
        return maxOneBack;
    }
    

 public static void main(String[] args) {
     HouseRobber solution = new HouseRobber();

     System.out.println("=== House Robber Tests ===\n");


     int[] test1 = {2, 7, 9, 3, 1};
     System.out.println("Test 1: [2, 7, 9, 3, 1]");
     System.out.println("Output: " + solution.rob(test1));
     System.out.println("Expected: 12\n");

 }
}
