package com.lagou.controller;

import com.lagou.domain.Course;
import com.lagou.domain.CourseSection;
import com.lagou.domain.ResponseResult;
import com.lagou.service.CourseContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**************************************
 * @author pan
 * @version 2022/6/7 21:41
 **************************************/
@RestController
@RequestMapping("/courseContent")
public class CourseContentController {

    @Autowired
    private CourseContentService courseContentService;

    @RequestMapping("/findSectionAndLesson")
    public ResponseResult findSectionAndLesson(Integer courseId){
        List<CourseSection> sectionAndLessonList = courseContentService.findSectionAndLessonById(courseId);

        ResponseResult responseResult = new ResponseResult(true, 200, "响应成功", sectionAndLessonList);

        return responseResult;
    }

    @RequestMapping("/findCourseById")
    public ResponseResult findCourseById (Integer courseId){
        Course course = courseContentService.findCourseById(courseId);

        HashMap<String, Object> map = new HashMap<>();
        map.put("id",course.getId());
        map.put("courseName",course.getCourseName());

        ResponseResult responseResult = new ResponseResult(true, 200, "响应成功", map);

        return responseResult;
    }


    /*
    * 新增或修改章节信息
    * */
    @RequestMapping("/saveOrUpdateSection")
    public ResponseResult saveOrUpdateSection (@RequestBody CourseSection courseSection){
        if(courseSection.getId() == null){
            courseContentService.saveSection(courseSection);
            return new ResponseResult(true, 200, "新增成功", null);
        }else{
            courseContentService.updateSection(courseSection);
            return new ResponseResult(true, 200, "修改成功", null);
        }
    }

    /*
    * 修改章节状态
    * */
    @RequestMapping("/updateSectionStatus")
    public ResponseResult updateSectionStatus (int id,int status){
        courseContentService.updateSectionStatus(id,status);
        return new ResponseResult(true, 200, "修改成功", status);

    }

}
