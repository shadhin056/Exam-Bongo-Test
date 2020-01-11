package com.shadhin;

import java.util.Scanner;

public class AnagramsFinder {

    public static void main(String[] args) {
        String firstString = "";
        String secondString = "";
        boolean isAnagram = false;

        Scanner Obj = new Scanner(System.in);
        System.out.print("Enter First String : ");
        while (Obj.hasNext()) {
            firstString = Obj.nextLine();
            System.out.print("Enter Second String : ");
            secondString = Obj.nextLine();

            isAnagram = checkAnagram(firstString, secondString);
            if (isAnagram) {
                System.out.println("Strings are Anagram");
            } else {
                System.out.println("Strings are not Anagram");
            }

            System.out.print("Enter First String : ");
        }
    }

    public static boolean checkAnagram(String firstString, String secondString) {
        //If two string match then print Strings are Anagram

        int firstStringLen;
        int secondStringLen;
        //remove space and convert to lowercase from lowercase and uppercase
        firstString = firstString.toLowerCase().replaceAll(" ", "");
        //remove space and convert to lowercase from lowercase and uppercase
        secondString = secondString.toLowerCase().replaceAll(" ", "");

        firstStringLen = firstString.length();
        secondStringLen = secondString.length();
        boolean isAnagramFirst = false;
        boolean isAnagramSecond = false;

        if (firstStringLen > 0 && secondStringLen > 0) {
            if (firstStringLen != secondStringLen) {
                return false;
            } else {
                String[] splitedFirstString = firstString.split("");
                String[] splitedSecondString = secondString.split("");

                for (int i = 0; i < firstStringLen; i++) {
                    isAnagramFirst = isStringContains(splitedFirstString[i], secondString);
                    isAnagramSecond = isStringContains(splitedSecondString[i], firstString);

                    if (!isAnagramFirst || !isAnagramSecond) {
                        return false;
                    }
                }
                return true;
            }
        } else {
            System.out.println("Please input valid string");
        }
        return false;
    }

    private static boolean isStringContains(String firstString, String secondString) {
        //if letter found in world then return true
        return secondString.contains(firstString);
    }
}

