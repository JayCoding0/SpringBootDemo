package com.example.demo.jdk.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jay
 * @description
 * @date Created in 2020/8/4 6:43 下午
 */
public class TreeTest {


    class Tree {

        Tree right;
        Tree left;
        int val;

        Tree(int val) {

            this.val = val;
        }

    }

    @Test
    public void Test() {

        Tree tree = new Tree(1);
        final Tree t1 = new Tree(1);
        Tree t2 = new Tree(2);
        Tree t3 = new Tree(3);
        Tree t4 = new Tree(4);
        tree.right = t2;
        tree.left = t3;
        t2.right = t4;
        List<Integer> sort = sort(tree);
        System.out.println(sort);
    }


    public List<Integer> sort(Tree t) {

        List<Integer> list = new ArrayList<>();
        list.add(t.val);
        if (t.right != null) {
            sort(t.right);
        }

        if (t.right != null) {
            sort(t.left);
        }

        return list;
    }

}
