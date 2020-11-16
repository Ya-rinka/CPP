package com.company;
import org.junit.Assert;
import static org.junit.jupiter.api.Assertions.*;

class TestTask2 {
    @org.junit.jupiter.api.Test
    public void shouldFindQuestions() throws Exception{
        Task2 task2 = new Task2();
        String text = "My string? My string.";

        Assert.assertTrue(task2.findQuestions(text).size() == 1);
        String expected = "My string?";
        String real = task2.findQuestions(text).get(0);
        Assert.assertEquals(expected,real);
    }

    @org.junit.jupiter.api.Test
    public void shouldFindWordsWithSizeTwo() throws Exception{
        Task2 task2 = new Task2();
        String text = "My string? My string.";
        var list = task2.findQuestions(text);

        String expected = "My";
        String real = task2.findWordsWithSizeGiven(list.get(0), 2).get(0);

        Assert.assertEquals(expected, real);
    }

    @org.junit.jupiter.api.Test
    public void shouldNotFindAnySentence() throws Exception{
        Task2 task2 = new Task2();
        String text = "My string. String without question mark.";
        var list = task2.findQuestions(text);

        Assert.assertEquals(list.size(), 0);
    }



}