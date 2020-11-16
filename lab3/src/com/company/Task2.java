package com.company;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2 {

    public List<String> findQuestions(String text){
        List<String> questionsList = new LinkedList<>();

        Pattern questionMarkPattern = Pattern.compile("([^.?!]*)\\?");
        Matcher questionMarkMatcher = questionMarkPattern.matcher(text);
        while (questionMarkMatcher.find()){
            questionsList.add(questionMarkMatcher.group());
        }

        return questionsList;
    }

    public List<String> findWordsWithSizeGiven(String text, int length){
        Pattern wordPattern = Pattern.compile("\\b\\w{" + length + "}\\b");
        Matcher wordMatcher = wordPattern.matcher(text);
        List<String> words = new LinkedList<>();

        while(wordMatcher.find()){
            words.add(wordMatcher.group());
        }
        return words;
    }

}
