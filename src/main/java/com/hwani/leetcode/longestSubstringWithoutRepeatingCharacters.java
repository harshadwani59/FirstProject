package com.hwani.leetcode;

public class longestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring(" "));
        System.out.println(lengthOfLongestSubstring("au"));
    }
    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        String maxSubString = null;
        if(s == null || s.length() == 0)
            return maxLength;
        else {

            int startPoint = 0;
            int incrementalPointer = 0;
            StringBuilder sb = new StringBuilder();
            String subString = String.valueOf(s.charAt(startPoint));

            while(incrementalPointer < s.length()) {
                String c = String.valueOf(s.charAt(incrementalPointer));

                if(subString.contains(c) ) {
                    if(subString.length() > maxLength){
                        maxLength = subString.length();
                        maxSubString = subString;
                    }
                    String newSubstring = s.substring(0,incrementalPointer);
                    System.out.println("newSubstring = " + newSubstring);
                    startPoint = newSubstring.lastIndexOf(c)+1;
                    System.out.println("startPoint = " + startPoint);
                    subString = s.substring(startPoint,incrementalPointer+1);
                    System.out.println("subString = " + subString);
                } else {
                    subString = subString + c;
                    if(incrementalPointer == s.length() -1 && subString.length() > maxLength){
                        maxLength = subString.length();
                        maxSubString = subString;
                    }
                }
                incrementalPointer++;
            }
            System.out.println("maxSubString = " + maxSubString);
            return maxLength;
        }
    }
}
