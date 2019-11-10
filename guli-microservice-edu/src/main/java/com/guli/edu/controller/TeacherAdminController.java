package com.guli.edu.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guili.common.vo.R;
import com.guli.edu.entity.Teacher;
import com.guli.edu.query.TeacherQuery;
import com.guli.edu.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;

@RestController
@RequestMapping("/admin/edu/teacher")
@CrossOrigin//跨域
@Api(description = "讲师管理")
public class TeacherAdminController {

    @Autowired
    private TeacherService teacherService;

    @ApiOperation(value = "所有讲师列表")
    @GetMapping
    public R list(){

        List<Teacher> list = teacherService.list(null);
        /*Map<String,List<Teacher>> map = new HashMap<>();
        map.put("items",list);
        return R.ok().data(map);*/
        Map<String,List<Teacher>> map = new HashMap<>();
        return  R.ok().message("查询列表成功")
                .data("items",list);
    }

    @ApiOperation(value = "根据id删除讲师")
    @DeleteMapping("{id}")
    public R removeById(
            @ApiParam(name = "id",value = "讲师id",required = true)
            @PathVariable String id){
            teacherService.removeById(id);
            return R.ok().message("删除成功");
    }

   /* @ApiOperation(value = "分页讲师列表")
    @GetMapping("{page}/{limit}")
    public R pageList(
            @ApiParam(name = "page",value = "当前页码",required = true)
            @PathVariable Integer page,
            @ApiParam(name = "limit",value = "每页记录数",required = true)
            @PathVariable Integer limit
    ){
        Page<Teacher> pageParam = new Page<>(page,limit);
        teacherService.page(pageParam,null);
        List<Teacher> records = pageParam.getRecords();
        long total = pageParam.getTotal();
        return  R.ok().data("total",total).data("rows",records);
    }*/

    @ApiOperation(value = "分页讲师列表")
    @GetMapping("{page}/{limit}")
    public R pageQuery(
            @ApiParam(name = "teacherQuery",value = "查询对象",required = false)
            TeacherQuery teacherQuery,
            @ApiParam(name = "page",value = "当前页码率",required = true)
            @PathVariable Long page,
            @ApiParam(name = "limit",value = "每页显示记录数",required = true)
            @PathVariable Long limit){

        Page<Teacher> pageParam = new Page<>(page, limit);
        teacherService.pageQuery(pageParam,teacherQuery);
        long total = pageParam.getTotal();
        List<Teacher> records = pageParam.getRecords();
        return  R.ok().data("total",total).data("rows",records);
    }
}
