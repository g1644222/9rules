package com.github.ninerules.parameters;

public class NullParameter implements Parameter {
    private static final NullParameter INSTANCE = new NullParameter();
    public static final NullParameter STRICT_LEVEL = INSTANCE;
    public static final NullParameter GENERAL_LEVEL = INSTANCE;
    public static final NullParameter ROUGH_LEVEL = INSTANCE;

    private NullParameter(){
    }

    public static NullParameter parameter(){
        return INSTANCE;
    }

    @Override
    public boolean isEqualsTo(Parameter parameter) {
        return this == parameter;
    }

    @Override
    public boolean isLessThan(Parameter parameter) {
        return false;
    }

    @Override
    public boolean isGreaterThan(Parameter parameter) {
        return false;
    }
}