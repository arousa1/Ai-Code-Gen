package com.xidian.aicodeassistantlww.service;

import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.service.IService;
import com.xidian.aicodeassistantlww.model.dto.app.AppQueryRequest;
import com.xidian.aicodeassistantlww.model.entity.App;
import com.xidian.aicodeassistantlww.model.vo.AppVO;

import java.util.List;

/**
 * 应用 服务层。
 *
 * @author lww
 */
public interface AppService extends IService<App> {

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
}
