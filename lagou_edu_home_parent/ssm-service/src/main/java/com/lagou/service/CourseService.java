package com.lagou.service;

import com.lagou.domain.Course;
import com.lagou.domain.CourseVO;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**************************************
 * @author pan
 * @version 2022/6/5 16:37
 **************************************/
public interface CourseService {

    /*
        多条件课程列表查询
     */
    public List<Course> findCourseByCondition(CourseVO courseVO);

    /*
    * 添加课程及讲师信息
    * */
    public void saveCourseOrTeacher(CourseVO courseVO) throws InvocationTargetException, IllegalAccessException;

    /*
    * 根据id查询课程信息
    * */
    public CourseVO findCourseById(Integer id);

    /*
    * 更新课程信息及讲师信息
    * */
    public void updateCourseOrTeacher(CourseVO courseVO) throws InvocationTargetException, IllegalAccessException;

    /*
    * 更新课程状态
    * */
    public void updateCourseStatus(int courseId , int status);
}
