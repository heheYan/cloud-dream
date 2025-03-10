package com.yuan.cloud.core.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public abstract class AbstractBasicDTO implements Serializable {

    @JsonSerialize(using = ToStringSerializer.class)
    Long id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime gmtCreate;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime gmtModified;

    Boolean deleted;
}
