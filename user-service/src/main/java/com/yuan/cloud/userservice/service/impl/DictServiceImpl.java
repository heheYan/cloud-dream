package com.yuan.cloud.userservice.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNode;
import cn.hutool.core.lang.tree.TreeUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuan.cloud.core.constant.CommonConst;
import com.yuan.cloud.userservice.entity.Dict;
import com.yuan.cloud.userservice.entity.DictItem;
import com.yuan.cloud.userservice.mapper.DictItemMapper;
import com.yuan.cloud.userservice.mapper.DictMapper;
import com.yuan.cloud.userservice.service.DictService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

/**
 * @author YhhWork
 * @description 针对表【s_dict(数据字典表)】的数据库操作Service实现
 * @createDate 2025-02-25 19:10:29
 */
@Service
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements DictService {

    @Resource
    DictItemMapper dictItemMapper;

    @Override
    public List<Tree<Long>> getDictTree(String searchText) {
        LambdaQueryWrapper<Dict> queryWrapper = new LambdaQueryWrapper<>();
        if (StrUtil.isNotBlank(searchText)) {
            queryWrapper.like(Dict::getDictName, searchText);
        }
        List<Dict> dictList = baseMapper.selectList(queryWrapper);
        List<TreeNode<Long>> treeNodes = CollUtil.newArrayList();
        HashSet<Long> existParentIdSet = new HashSet<>();
        if (CollUtil.isNotEmpty(dictList)) {
            dictList.forEach(dict -> {
                treeNodes.add(new TreeNode<>(dict.getId(), CommonConst.TREE_ROOT_ID, dict.getDictName(), dict.getSortOrder()));
                existParentIdSet.add(dict.getId());
            });
        }
        LambdaQueryWrapper<DictItem> wrapper = new LambdaQueryWrapper<>(DictItem.class);
        if (StrUtil.isNotBlank(searchText)) {
            wrapper.like(DictItem::getItemLabel, searchText);
        }
        List<DictItem> dictItems = dictItemMapper.selectList(wrapper);
        if (CollUtil.isNotEmpty(dictItems)) {
            dictItems.forEach(dictItem -> {
                treeNodes.add(new TreeNode<>(dictItem.getId(), dictItem.getDictId(), dictItem.getItemLabel(), dictItem.getSortOrder()));
                // 如果子项存在，需要添加父项
                if (!existParentIdSet.contains(dictItem.getDictId())) {
                    Dict dict = baseMapper.selectById(dictItem.getDictId());
                    treeNodes.add(new TreeNode<>(dict.getId(), CommonConst.TREE_ROOT_ID, dict.getDictName(), dict.getSortOrder()));
                    existParentIdSet.add(dict.getId());
                }
            });
        }
        // 构建树,权重越小优先级越高 默认0
        return TreeUtil.build(treeNodes, CommonConst.TREE_ROOT_ID);
    }
}




