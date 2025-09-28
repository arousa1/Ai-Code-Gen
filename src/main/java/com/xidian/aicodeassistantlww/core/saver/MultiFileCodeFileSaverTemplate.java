package com.xidian.aicodeassistantlww.core.saver;

import cn.hutool.core.util.StrUtil;
import com.xidian.aicodeassistantlww.ai.model.MultiFileCodeResult;
import com.xidian.aicodeassistantlww.ai.model.enums.CodeGenTypeEnum;
import com.xidian.aicodeassistantlww.exception.BusinessException;
import com.xidian.aicodeassistantlww.exception.ErrorCode;

/**
 * 多文件代码保存模板
 */
public class MultiFileCodeFileSaverTemplate extends CodeFileSaverTemplate<MultiFileCodeResult> {

    @Override
    protected CodeGenTypeEnum getCodeType() {
        return CodeGenTypeEnum.MULTI_FILE;
    }

    @Override
    protected void saveFiles(MultiFileCodeResult result, String dirPath) {
        writeToFile(dirPath, "index.html", result.getHtmlCode());
        writeToFile(dirPath, "script.js", result.getJsCode());
        writeToFile(dirPath, "style.css", result.getCssCode());
    }

    @Override
    protected void validateInput(MultiFileCodeResult result) {
        super.validateInput(result);
        if(StrUtil.isBlank(result.getHtmlCode())){
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "HTML代码不能为空");
        }
    }
}
