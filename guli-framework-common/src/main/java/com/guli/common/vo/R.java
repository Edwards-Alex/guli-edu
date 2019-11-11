package com.guli.common.vo;

import com.guli.common.constants.ResultCodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Alex
 * @create 2019-11-10 下午4:38
 */

@Data
@ApiModel(value = "全局统一返回结果")
public class R {

    @ApiModelProperty(value = "是否成功")
    private Boolean success;

    @ApiModelProperty(value = "返回代码code")
    private Integer code;

    @ApiModelProperty(value = "返回消息")
    private String messages;

    @ApiModelProperty(value = "返回数据")
    private Map<String, Object> data = new HashMap<>();

    private R() { }

    public static R ok() {
        R r = new R();
        r.setSuccess(ResultCodeEnum.SUCCESS.getSuccess());
        r.setCode(ResultCodeEnum.SUCCESS.getCode());
        r.setMessages(ResultCodeEnum.SUCCESS.getMessage());
        return  r;
    }

    public static R erro(){
        R r = new R();
        r.setSuccess(ResultCodeEnum.UNKNOWM_REASON.getSuccess());
        r.setCode(ResultCodeEnum.UNKNOWM_REASON.getCode());
        r.setMessages(ResultCodeEnum.UNKNOWM_REASON.getMessage());
        return  r;
    }

    //自定义success
    public R success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    //自定义code
    public R code(Integer code){
        this.setCode(code);
        return this;
    }

    //自定义message
    public R message(String message){
        this.setMessages(message);
        return this;
    }

    public R data(Map<String,Object> map){
        this.setData(map);
        return  this;
    }


    public  R data(String  key,Object value){
        this.data.put(key,value);
        return  this;
    }
}
