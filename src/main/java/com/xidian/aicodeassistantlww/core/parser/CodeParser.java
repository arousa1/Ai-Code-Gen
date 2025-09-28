package com.xidian.aicodeassistantlww.core.parser;

/**
 * 策略模式，定义一系列算法和策略
 * 代码解析器策略接口
 */
public interface CodeParser<T> {

    /**
     * 解析代码
     * @param codeContent 待解析的代码
     * @return 解析后的代码
     */
    T parseCode(String codeContent);
}
