package com.company;

import java.util.LinkedList;
import java.util.List;

public class Task1 {
    public String findPossiblePaths(String text) {
        int indexOfPattern = -1;

        String[] pathPattern = new String[]{":\\", "\\", ":/", "/"};
        for (String pattern : pathPattern){
            if(text.contains(pattern)){
                indexOfPattern = text.indexOf(pattern);
            }
        }

        if(indexOfPattern == -1){
            return null;
        }

        int begin = -1;
        int end = -1;
        if(text.substring(0 , indexOfPattern).contains(" ")){
            begin = text.substring(0 , indexOfPattern).lastIndexOf(" ") + 1;
        }
        else{
            begin = 0;
        }

        String substring = text.substring(begin);
        if(substring.contains(" ")){
            end = substring.indexOf(" ") + begin;
        }
        else{
            end = text.length();
        }

        return text.substring(begin, end);
    }

    public void deleteLongSentence (List<String> sentences) {
        for (String s : sentences) {
            if (s.length() <= 180) {
                System.out.println(s + ".");

            }
            else{
                System.out.println("---Too long sentence---");
            }
        }
    }


}
