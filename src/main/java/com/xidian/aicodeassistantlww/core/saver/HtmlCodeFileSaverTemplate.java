package com.xidian.aicodeassistantlww.core.saver;

import cn.hutool.core.util.StrUtil;
import com.xidian.aicodeassistantlww.ai.model.HtmlCodeResult;
import com.xidian.aicodeassistantlww.ai.model.enums.CodeGenTypeEnum;
import com.xidian.aicodeassistantlww.exception.BusinessException;
import com.xidian.aicodeassistantlww.exception.ErrorCode;

/**
 * 单Html代码文件保存模板
 */
public class HtmlCodeFileSaverTemplate extends CodeFileSaverTemplate<HtmlCodeResult> {

    @Override
    protected CodeGenTypeEnum getCodeType() {
        return CodeGenTypeEnum.HTML;
    }

    @Override
    protected void saveFiles(HtmlCodeResult result, String dirPath) {
        writeToFile(dirPath, "index.html", result.getHtmlCode());
    }

    @Override
    protected void validateInput(HtmlCodeResult result) {
        super.validateInput(result);
        if(StrUtil.isBlank(result.getHtmlCode())){
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "HTML代码不能为空");
        }
    }
}
