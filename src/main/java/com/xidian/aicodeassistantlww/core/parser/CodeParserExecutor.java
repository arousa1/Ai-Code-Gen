package com.xidian.aicodeassistantlww.core.parser;

import com.xidian.aicodeassistantlww.ai.model.enums.CodeGenTypeEnum;
import com.xidian.aicodeassistantlww.exception.BusinessException;
import com.xidian.aicodeassistantlww.exception.ErrorCode;

/**
 * 执行器模式
 * 代码解析执行器
 */
public class CodeParserExecutor {

    private static final HtmlCodeParser htmlCodeParser = new HtmlCodeParser();
    private static final MultiFileCodeParser multiFileCodeParser = new MultiFileCodeParser();
    /**
     * 执行代码解析
     * @param codeContent 待解析代码内容
     * @param codeGenTypeEnum 解析代码类型
     */
    public static Object executeParser(String codeContent, CodeGenTypeEnum codeGenTypeEnum){
        return switch (codeGenTypeEnum) {
            case HTML -> htmlCodeParser.parseCode(codeContent);
            case MULTI_FILE -> multiFileCodeParser.parseCode(codeContent);
            default -> {
                String errorMessage = "不支持的代码解析类型：" + codeGenTypeEnum.getValue();
                throw new BusinessException(ErrorCode.SYSTEM_ERROR, errorMessage);
            }
        };
    }
}
