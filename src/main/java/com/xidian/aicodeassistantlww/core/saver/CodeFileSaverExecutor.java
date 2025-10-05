package com.xidian.aicodeassistantlww.core.saver;

import com.xidian.aicodeassistantlww.ai.model.HtmlCodeResult;
import com.xidian.aicodeassistantlww.ai.model.MultiFileCodeResult;
import com.xidian.aicodeassistantlww.ai.model.enums.CodeGenTypeEnum;
import com.xidian.aicodeassistantlww.exception.BusinessException;
import com.xidian.aicodeassistantlww.exception.ErrorCode;

import java.io.File;

/**
 * 代码文件保存执行器
 */
public class CodeFileSaverExecutor {

    private static final HtmlCodeFileSaverTemplate htmlCodeFileSaver = new HtmlCodeFileSaverTemplate();

    private static final MultiFileCodeFileSaverTemplate multiFileCodeFileSaver = new MultiFileCodeFileSaverTemplate();

    /**
     * 执行代码保存
     *
     * @param codeResult  代码结果对象
     * @param codeGenType 代码生成类型
     * @return 保存的目录
     */
    public static File executeSaver(Object codeResult, CodeGenTypeEnum codeGenType, Long appId) {
        return switch (codeGenType) {
            case HTML -> htmlCodeFileSaver.saveCode((HtmlCodeResult) codeResult, appId);
            case MULTI_FILE -> multiFileCodeFileSaver.saveCode((MultiFileCodeResult) codeResult, appId);
            default -> throw new BusinessException(ErrorCode.SYSTEM_ERROR, "不支持的代码生成类型: " + codeGenType);
        };
    }
}

