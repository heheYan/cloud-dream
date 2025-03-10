package com.yuan.cloud.userservice.controller;

import com.yuan.cloud.core.controller.BasicController;
import com.yuan.cloud.core.dto.userservice.DictItemDTO;
import com.yuan.cloud.core.vo.userservice.DictItemVO;
import com.yuan.cloud.userservice.entity.DictItem;
import com.yuan.cloud.userservice.query.DictItemQuery;
import com.yuan.cloud.userservice.service.DictItemService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("dictItem")
public class DictItemController extends BasicController<DictItemService, DictItem, DictItemDTO, DictItemVO, DictItemQuery> {
    public DictItemController(DictItemService baseService) {
        super(baseService);
    }

    @Override
    protected Class<DictItem> getEntityClass() {
        return DictItem.class;
    }

    @Override
    protected Class<DictItemVO> getVoClass() {
        return DictItemVO.class;
    }
}
