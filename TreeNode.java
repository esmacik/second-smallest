public class TreeNode {
    int val;
    TreeNode winner;
    TreeNode loser;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode winner, TreeNode loser) {
        this.val = val;
        this.winner = winner;
        this.loser = loser;
    }
}
