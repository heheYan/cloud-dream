package com.yuan.cloud.core.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yuan.cloud.core.enums.YuanStatusEnum;
import com.yuan.cloud.core.exception.YuanApiException;
import com.yuan.cloud.core.query.BasicQuery;
import com.yuan.cloud.core.query.PageQuery;
import com.yuan.cloud.core.util.query.QueryBuilderUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 基础控制器
 *
 * @author YuAN
 */
public abstract class BasicController<S extends IService<T>, T, D, V, Q extends BasicQuery> {

    protected final S basicService;

    public BasicController(S baseService) {
        basicService = baseService;
    }

    /**
     * 根据ID查询对象
     *
     * @param id 主键
     * @return
     */
    @Operation(summary = "根据ID查询对象", description = "根据ID查询对象",
            parameters = {@Parameter(name = "id", description = "主键", required = true)},
            responses = {@ApiResponse(description = "对象", content = @Content(schema = @Schema(description = "实际的数据对象")))})
    @GetMapping("/{id}")
    public V findById(@NotNull @PathVariable("id") Long id) {
        T t = basicService.getOptById(id).orElseThrow(() -> new YuanApiException(YuanStatusEnum.DATA_NOT_EXIST));
        return BeanUtil.copyProperties(t, getVoClass());
    }

    /**
     * 查询对象列表
     *
     * @return
     */
    @Operation(summary = "查询所有对象列表", description = "查询所有对象列表",
            parameters = {@Parameter(name = "query", description = "查询条件", required = true)},
            responses = {@ApiResponse(description = "对象列表", content = @Content(schema = @Schema(description = "实际的数据对象列表")))}
    )
    @GetMapping
    public List<V> listAll() {
        List<T> list = basicService.list();

        return BeanUtil.copyToList(list, getVoClass());
    }

    /**
     * 新增对象
     *
     * @param dto
     * @return
     */
    @Operation(summary = "新增对象", description = "新增对象", parameters = {
            @Parameter(name = "dto", description = "DTO对象", required = true)
    }, responses = {@ApiResponse(responseCode = "200", description = "VO对象", content = @Content(schema = @Schema(description = "实际的数据对象")))})
    @PostMapping
    public V save(@Validated @RequestBody D dto) {
        T entity = BeanUtil.copyProperties(dto, getEntityClass());
        basicService.save(entity);
        return BeanUtil.copyProperties(entity, getVoClass());
    }

    /**
     * 更新对象
     *
     * @param dto
     * @return
     */
    @Operation(summary = "更新对象", description = "更新对象",
            parameters = {@Parameter(name = "dto", description = "DTO对象", required = true)},
            responses = {@ApiResponse(responseCode = "200", description = "VO对象", content = @Content(schema = @Schema(description = "实际的数据对象")))}
    )
    @PutMapping
    public V update(@Validated @RequestBody D dto) {
        T entity = BeanUtil.copyProperties(dto, getEntityClass());
        basicService.updateById(entity);
        return BeanUtil.copyProperties(entity, getVoClass());
    }

    /**
     * 删除对象[批量]
     *
     * @param ids 主键,支持批量，多个用分号隔开
     * @return
     */
    @Operation(summary = "删除对象[批量]", description = "删除对象[批量]",
            parameters = {@Parameter(name = "id", description = "主键，多个用 , 分隔", required = true)},
            responses = {@ApiResponse(description = "删除结果", content = @Content(schema = @Schema(description = "删除结果")))}
    )
    @DeleteMapping("/{id}")
    public JSONObject deleteByIds(@PathVariable("id") List<String> ids) {
        boolean result = false;
        // ids不为空，批量删除
        if (CollUtil.isNotEmpty(ids)) {
            result = basicService.removeBatchByIds(ids);
        }
        JSONObject rtn = new JSONObject();
        rtn.put("result", result);
        return rtn;
    }

    /**
     * 通用分页查询
     *
     * @param query 分页查询对象
     * @return 分页结果
     */
    @Operation(summary = "通用分页查询", description = "通用分页查询",
            parameters = {@Parameter(name = "query", description = "查询条件", required = true, schema = @Schema(implementation = PageQuery.class))},
            responses = {@ApiResponse(responseCode = "200", description = "分页结果", content = @Content(schema = @Schema(implementation = Page.class)))}
    )
    @PostMapping("/page")
    public Page<V> page(@RequestBody PageQuery<Q> query) {
        // 构建分页参数
        Page<T> page = Page.of(query.getCurrentPage(), query.getPageSize());
        // 添加排序条件
        if (StrUtil.isNotBlank(query.getSortBy())) {
            if (query.getIsAsc() == null || !query.getIsAsc()) {
                page.addOrder(OrderItem.desc(query.getSortBy()));
            } else {
                page.addOrder(OrderItem.asc(query.getSortBy()));
            }
        }
        // 定义查询条件（默认模糊查询）
        QueryWrapper<T> wrapper;
        try {
            wrapper = QueryBuilderUtil.build(query.getQuery());
        } catch (IllegalAccessException e) {
            throw new YuanApiException(YuanStatusEnum.QUERY_CONDITION_ERROR);
        }
        // 分页查询
        page = basicService.page(page, wrapper);
        // 转换为VO
        List<V> list = BeanUtil.copyToList(page.getRecords(), getVoClass());
        Page<V> resultPage = BeanUtil.copyProperties(page, Page.class);
        resultPage.setRecords(list);
        return resultPage;
    }

    protected abstract Class<T> getEntityClass();

    protected abstract Class<V> getVoClass();
}