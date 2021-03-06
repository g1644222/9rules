package com.github.ninerules.rules.stringvisitor;

import java.nio.file.Path;

import com.github.ninerules.entities.LineCount;

public interface StringLineVisitor {
    void visitLine(String line, LineCount number);

    String preVisitLine(String line, LineCount number);

    default void visit(Path path){
        StringLineVisitorHelper helper = new StringLineVisitorHelper(this);
        helper.visit(path);
    }
}
