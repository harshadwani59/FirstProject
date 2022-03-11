package com.hwani.leetcode;

import java.math.BigInteger;

public class AddTwoNumbers {

    public static void main(String[] args) {
        AddTwoNumbers solution  = new AddTwoNumbers();

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger number1 = getNumberFromLinkedList(l1);
        BigInteger number2 = getNumberFromLinkedList(l2);
        System.out.println("number1 = " + number1);
        System.out.println("number2 = " + number2);
        BigInteger sum = number1.add(number2);
        System.out.println("sum = " + sum);

        return getLinkedListFromNumber(sum);
    }

    private ListNode getLinkedListFromNumber(BigInteger sum) {
        if(sum.compareTo(BigInteger.valueOf(10)) < 0) {
            return new ListNode(sum.intValue());
        } else {
            return new ListNode(sum.mod(BigInteger.valueOf(10)).intValue(), getLinkedListFromNumber(sum.divide(BigInteger.valueOf(10))));
        }
    }


    private BigInteger getNumberFromLinkedList(ListNode l1) {
        if(l1.next == null) {
            return BigInteger.valueOf(l1.val);
        } else {
            return (getNumberFromLinkedList(l1.next).multiply(BigInteger.valueOf(10))).add(BigInteger.valueOf(l1.val));
        }
    }
}
