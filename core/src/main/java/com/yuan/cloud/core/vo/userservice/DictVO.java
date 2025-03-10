package com.yuan.cloud.core.vo.userservice;

import com.yuan.cloud.core.vo.AbstractBasicVO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DictVO extends AbstractBasicVO {
    String dictName;
    String remark;
    Integer sortOrder;
    List<DictItemVO> dictItems;
}
