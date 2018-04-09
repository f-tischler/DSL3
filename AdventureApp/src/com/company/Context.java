package com.company;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Context implements IContext {
    private IState state = new State();
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public PrintStream getOut() {
        return System.out;
    }

    @Override
    public BufferedReader getIn() {
        return reader;
    }

    @Override
    public IState getState() {
        return state;
    }
}
