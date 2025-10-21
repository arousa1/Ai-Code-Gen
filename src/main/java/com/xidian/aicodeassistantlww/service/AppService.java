package com.xidian.aicodeassistantlww.service;

import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.service.IService;
import com.xidian.aicodeassistantlww.model.dto.app.AppQueryRequest;
import com.xidian.aicodeassistantlww.model.entity.App;
import com.xidian.aicodeassistantlww.model.entity.User;
import com.xidian.aicodeassistantlww.model.vo.AppVO;
import reactor.core.publisher.Flux;

import java.util.List;

/**
 * 应用 服务层。
 *
 * @author lww
 */
public interface AppService extends IService<App> {

    /**
     * 异步生成应用截图并更新封面
     *
     * @param appId  应用ID
     * @param appUrl 应用访问URL
     */
    void generateAppScreenshotAsync(Long appId, String appUrl);

    /**
     * 查询App关联信息
     * @param app
     * @return
     */
    AppVO getAppVO(App app);

    /**
     * 构造查询对象
     * @param appQueryRequest
     * @return
     */
    QueryWrapper getQueryWrapper(AppQueryRequest appQueryRequest);

    /**
     * 优化查询，组合批量用户信息
     * @param appList
     * @return
     */
    List<AppVO> getAppVOList(List<App> appList);

    /**
     * Ai创建应用根据用户提示词生成代码
     * @param appId
     * @param message
     * @param loginUser
     * @return
     */
    Flux<String> chatToGenCode(Long appId, String message, User loginUser);

    /**
     * 部署应用
     * @param appId
     * @param loginUser
     * @return
     */
    String deployApp(Long appId, User loginUser);
}
