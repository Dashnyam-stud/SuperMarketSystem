package supermarket;

import java.util.LinkedList;
import java.util.Queue;

public class EmployeeBinaryTree {

    private TreeNode root;

    // Constructor
    public EmployeeBinaryTree() {
        root = null;
    }

    // Insert a new employee into the Binary Search Tree
    public void insert(Employee employee) {

        TreeNode newNode = new TreeNode(employee);

        if (root == null) {
            root = newNode;
            return;
        }

        TreeNode current = root;

        while (true) {

            if (employee.getEmployeeName().compareToIgnoreCase(
                    current.employee.getEmployeeName()) < 0) {

                if (current.left == null) {
                    current.left = newNode;
                    return;
                }

                current = current.left;

            } else if (employee.getEmployeeName().compareToIgnoreCase(
                    current.employee.getEmployeeName()) > 0) {

                if (current.right == null) {
                    current.right = newNode;
                    return;
                }

                current = current.right;

            } else {
                current.employee = employee;
                return;
            }
        }
    }

    // Display employees using Level Order Traversal
    public void levelOrderTraversal() {

        if (root == null) {
            System.out.println("The tree is empty.");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            TreeNode current = queue.poll();

            current.employee.displayEmployee();

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    // Calculate the height of the tree
    public int getHeight(TreeNode node) {

        if (node == null) {
            return 0;
        }

        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    // Return the height of the tree
    public int getTreeHeight() {
        return getHeight(root);
    }

    // Count the total number of nodes
    public int countNodes(TreeNode node) {

        if (node == null) {
            return 0;
        }

        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    // Return the total number of employees
    public int getTotalNodes() {
        return countNodes(root);
    }
}
