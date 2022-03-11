package com.hwani.leetcode;

public class ListNode {
      public int val;
      public ListNode next;
      ListNode() {}
      public ListNode(int val) { this.val = val; }
      public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

      @Override
      public String toString() {
            if(next == null) {
                  return String.valueOf(val);
            } else {
                  return toString() + next.toString();
            }
      }
}