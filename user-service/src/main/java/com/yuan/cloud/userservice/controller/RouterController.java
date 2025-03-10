package com.yuan.cloud.userservice.controller;

import com.yuan.cloud.core.controller.BasicController;
import com.yuan.cloud.core.dto.userservice.RouterDTO;
import com.yuan.cloud.core.vo.userservice.RouterVO;
import com.yuan.cloud.userservice.entity.Router;
import com.yuan.cloud.userservice.query.RouterQuery;
import com.yuan.cloud.userservice.service.RouterService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("router")
public class RouterController extends BasicController<RouterService, Router, RouterDTO, RouterVO, RouterQuery> {
    public RouterController(RouterService baseService) {
        super(baseService);
    }

    @Override
    protected Class<Router> getEntityClass() {
        return Router.class;
    }

    @Override
    protected Class<RouterVO> getVoClass() {
        return RouterVO.class;
    }
}
