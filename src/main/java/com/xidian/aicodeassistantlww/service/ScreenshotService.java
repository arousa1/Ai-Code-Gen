package com.xidian.aicodeassistantlww.service;


public interface ScreenshotService {

    /**
     * 截取和上传截图
     * @param webUrl
     * @return
     */
    String generateAndUploadScreenshot(String webUrl);
}
