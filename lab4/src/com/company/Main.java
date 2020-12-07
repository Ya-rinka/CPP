package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
public class Main {
    private JPanel panel1;
    public static JTextArea a = new JTextArea(" ");
    public static JFrame f = new JFrame();
    public static void main(String[] args) throws InterruptedException{
        f.setBounds(500, 250, 500, 200);
        f.add(a);
        String PATH = "D:\\study\\course3\\sem1\\CPP_files\\lab4\\file.txt";
        Primma graph =new Primma(PATH);
        Monitor MN = new Monitor();
        f.setVisible(true);
        MN.run();
        ScheduledThreadPoolExecutor executor = (ScheduledThreadPoolExecutor)
                Executors.newScheduledThreadPool(2);
        Monitor task = new Monitor();
        executor.scheduleWithFixedDelay(task, 2, 2, TimeUnit.SECONDS);
        graph.prima();
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}