package com.yuan.cloud.core.query;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;

/**
 * @author YuAN
 * Created on 2025-02-27 18:17
 * @description 分页查询对象
 */
@Tag(name = "分页查询对象")
@Data
public class PageQuery<T extends BasicQuery> {

    /**
     * 当前页码
     */
    @Schema(description = "当前页码")
    private Long currentPage;

    /**
     * 每页条数
     */
    @Schema(description = "每页条数")
    private Long pageSize;

    /**
     * 排序字段
     */
    @Schema(description = "排序字段")
    private String sortBy;

    /**
     * 排序方式是否升序
     */
    @Schema(description = "排序方式是否升序")
    private Boolean isAsc;

    /**
     * 查询条件
     */
    @Schema(description = "查询条件")
    private T query;
}
