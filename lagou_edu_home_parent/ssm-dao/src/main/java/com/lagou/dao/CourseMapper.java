package com.lagou.dao;

import com.lagou.domain.Course;
import com.lagou.domain.CourseVO;
import com.lagou.domain.Teacher;

import java.util.List;

/**************************************
 * @author pan
 * @version 2022/6/5 16:14
 **************************************/
public interface CourseMapper {

    /*
        多条件列表查询
     */

    public List<Course> findCourseByCondition(CourseVO courseVO);

    /*
        新增课程信息
     */
    public void saveCourse(Course course);

    /*
        新增讲师信息
     */
    public void saveTeacher(Teacher teacher);

    /*
        回显课程信息
     */
    public CourseVO findCourseById(Integer id);

    /*
        更新课程信息
     */
    public void updateCourse(Course course);

    /*
        更新讲师信息
     */
    public void updateTeacher(Teacher teacher);

    /*
        更新课程状态
     */
    public  void updateCourseStatus(Course course);

}
