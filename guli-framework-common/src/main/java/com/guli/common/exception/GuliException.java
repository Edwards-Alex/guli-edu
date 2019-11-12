package com.guli.common.exception;

import com.guli.common.constants.ResultCodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Alex
 * @create 2019-11-12 上午12:46
 */

@Data
@ApiModel(value = "自定义全局异常")
public class GuliException extends RuntimeException{
    @ApiModelProperty(value = "状态码")
    private Integer code;

    //message

    /**
     * 接收状态码和错误消息
     * @param code
     * @param message
     */
    public  GuliException(Integer code,String message){
        super(message);
        this.code = code;
    }


    public  GuliException(ResultCodeEnum r){
        super(r.getMessage());
        this.code = r.getCode();
    }

    @Override
    public String toString() {
        return "GuliException{" +
                "code=" + code +
                ",message="+this.getMessage()+'}';
    }
}
