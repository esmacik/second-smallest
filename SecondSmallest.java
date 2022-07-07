import java.util.*;

public class SecondSmallest {

    public static void main(String[] args) {
        HashSet<Integer> numSet = new HashSet<>();
        Random rand = new Random();
        int[] nums = new int[1000];
        for (int i = 0; i < nums.length; i++) {
            if (!numSet.contains(i)) {
                nums[i] = rand.nextInt(10);
                numSet.add(i);
            }
        }

        System.out.println(Arrays.toString(nums));
        int secondSmallest = findSecondSmallest(nums);
        System.out.println(secondSmallest);
    }

    /**
     * Return the second smallest element in an array with unique integers.
     * n + log n - 2 comparisons, or something like that.
     * */
    static int findSecondSmallest(int[] nums) {
        Queue<TreeNode> tnQueue = new LinkedList<>();
        for (int num: nums)
            tnQueue.add(new TreeNode(num));

        while (tnQueue.size() >= 2) {
            TreeNode p1 = tnQueue.remove();
            TreeNode p2 = tnQueue.remove();
            if (p1.val < p2.val)
                tnQueue.add(new TreeNode(p1.val, p1, p2));
            else
                tnQueue.add(new TreeNode(p2.val, p2, p1));
        }

        TreeNode smallestNode = tnQueue.remove();
        int secondSmallest = smallestNode.loser.val;
        smallestNode = smallestNode.winner;
        while (smallestNode.loser != null) {
            if (smallestNode.loser.val < secondSmallest)
                secondSmallest = smallestNode.loser.val;
            smallestNode = smallestNode.winner;
        }
        return secondSmallest;
    }
}
