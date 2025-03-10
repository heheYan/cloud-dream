package com.yuan.cloud.userservice.controller;

import cn.hutool.core.lang.tree.Tree;
import com.yuan.cloud.core.controller.BasicController;
import com.yuan.cloud.core.dto.userservice.DictDTO;
import com.yuan.cloud.core.vo.userservice.DictVO;
import com.yuan.cloud.userservice.entity.Dict;
import com.yuan.cloud.userservice.query.DictQuery;
import com.yuan.cloud.userservice.service.DictService;
import jakarta.annotation.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("dict")
public class DictController extends BasicController<DictService, Dict, DictDTO, DictVO, DictQuery> {
    final DictService baseService;

    public DictController(DictService baseService) {
        super(baseService);
        this.baseService = baseService;
    }

    @GetMapping("tree")
    public List<Tree<Long>> getDictTree(@Nullable @RequestParam("s") String searchText) {
        return baseService.getDictTree(searchText);
    }

    @Override
    protected Class<Dict> getEntityClass() {
        return Dict.class;
    }

    @Override
    protected Class<DictVO> getVoClass() {
        return DictVO.class;
    }
}
