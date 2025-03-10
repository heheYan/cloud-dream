package com.yuan.cloud.userservice.service;

import cn.hutool.core.lang.tree.Tree;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yuan.cloud.userservice.entity.Dict;

import java.util.List;

/**
 * @author YhhWork
 * @description 针对表【s_dict(数据字典表)】的数据库操作Service
 * @createDate 2025-02-25 19:10:29
 */
public interface DictService extends IService<Dict> {

    List<Tree<Long>> getDictTree(String searchText);
}
