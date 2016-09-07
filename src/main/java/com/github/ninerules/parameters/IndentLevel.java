package com.github.ninerules.parameters;

/**
 * Rule 1. 1つのメソッドにつき，インデントは n 段階とすること．
 * <ul>
 *   <li>STRICT, GENERAL: n = 1</li>
 *   <li>ROUGHL: n = 2</li>
 * </ul>
 *
 * @author Haruaki Tamada
 */
public class IndentLevel extends IntegerParameter{
    public static IndentLevel STRICT_LEVEL = new IndentLevel(1);
    public static IndentLevel GENERAL_LEVEL = STRICT_LEVEL;
    public static IndentLevel ROUGH_LEVEL = new IndentLevel(2);

    public IndentLevel(int indentLevel){
        super(indentLevel);
    }
}