
package supermarket;

public class TreeNode {

    Employee employee;
    TreeNode left;
    TreeNode right;

    // Constructor
    public TreeNode(Employee employee) {
        this.employee = employee;
        this.left = null;
        this.right = null;
    }
}
