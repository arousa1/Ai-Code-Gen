package com.xidian.aicodeassistantlww.core.saver;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.xidian.aicodeassistantlww.ai.model.enums.CodeGenTypeEnum;
import com.xidian.aicodeassistantlww.constant.AppConstant;
import com.xidian.aicodeassistantlww.exception.BusinessException;
import com.xidian.aicodeassistantlww.exception.ErrorCode;

import java.io.File;
import java.nio.charset.StandardCharsets;

/**
 * 代码文件保存模板方法 —— 模板方法模式
 */
public abstract class CodeFileSaverTemplate<T> {

    // 文件保存根目录
    private static final String FILE_SAVE_ROOT_DIR = AppConstant.CODE_OUTPUT_ROOT_DIR;


    /**
     * 代码保存的标准模板
     * @param result
     * @return
     */
    public final File saveCode(T result, Long appId) {
        // 1. 验证输入
        validateInput(result);
        // 2. 构建目标路径
        String baseDirPath = buildUniqueDir(appId);
        // 3. 保存文件
        saveFiles(result, baseDirPath);
        // 4. 返回目标文件对象
        return new File(baseDirPath);
    }

    /**
     * 验证输入（允许子类复写）
     * @param result
     */
    protected void validateInput(T result) {
        if(result == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "输入不可为空");
        }
    }

    /**
     * 构建唯一目标路径
     *
     * @param appId 创建的应用唯一标识
     * @return
     */
    private final String buildUniqueDir(Long appId) {
        String bizType = getCodeType().getValue();
        String uniqueDirName = StrUtil.format("{}_{}", bizType, appId);
        String dirPath = FILE_SAVE_ROOT_DIR + File.separator + uniqueDirName;
        FileUtil.mkdir(dirPath);
        return dirPath;
    }

    /**
     * 写入单个文件
     *
     * @param dirPath
     * @param fileName
     * @param content
     */
    protected final void writeToFile(String dirPath, String fileName, String content) {
        String filePath = dirPath + File.separator + fileName;
        FileUtil.writeString(content, filePath, StandardCharsets.UTF_8);
    }

    /**
     * 获取代码类型（由子类实现）
     * @return
     */
    protected abstract CodeGenTypeEnum getCodeType();

    /**
     * 保存代码文件（由子类实现）
     * @param result
     * @param dirPath
     */
    protected abstract void saveFiles(T result, String dirPath);
}
