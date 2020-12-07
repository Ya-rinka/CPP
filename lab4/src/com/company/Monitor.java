package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
public class Monitor implements Runnable {
    public List<Thread> threads = new ArrayList<>();
    public String Info() {
        StringBuilder sb = new StringBuilder();
        this.threads = Primma.threads;
        threads.forEach(t -> sb.append("THREAD Id:"+t.getId()+" State:"+t.getState() +" IsAlive:"+t.isAlive()+ "\n"));
        return (sb.toString() + "\n");
    }
    public void run() {
        ActionListener task = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Main.a.setText(Info());
            };
        };
        javax.swing.Timer timer = new Timer(100, task); // Execute task each 100 miliseconds
        timer.setRepeats(true);
        timer.start();
    }
    public void setThreads() {
        this.threads.addAll(Primma.threads);
    }
}
