package com.wpy.mall.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author W
 * @date 2022-02-25
 */
public class Main {
    public static void main(String[] args) {
    }



    public  boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isSymmetricPer(root.left,root.right);
    }

    private boolean isSymmetricPer(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if(left== null || right == null || left.val != right.val) {
            return false;
        }
        return isSymmetricPer(left.left,right.right) && isSymmetricPer(left.right,right.left);
    }


}
