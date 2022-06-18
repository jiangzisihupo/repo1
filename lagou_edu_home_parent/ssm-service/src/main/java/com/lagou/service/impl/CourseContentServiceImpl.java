package com.lagou.service.impl;

import com.lagou.dao.CourseContentMapper;
import com.lagou.domain.Course;
import com.lagou.domain.CourseLesson;
import com.lagou.domain.CourseSection;
import com.lagou.domain.PromotionSpace;
import com.lagou.service.CourseContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**************************************
 * @author pan
 * @version 2022/6/7 21:38
 **************************************/
@Service
public class CourseContentServiceImpl implements CourseContentService {

    @Autowired
    private CourseContentMapper courseContentMapper;

    @Override
    public List<CourseSection> findSectionAndLessonById(Integer courseId) {
        List<CourseSection> sectionAndLessonList = courseContentMapper.findSectionAndLessonById(courseId);
        return sectionAndLessonList;
    }

    @Override
    public Course findCourseById(Integer courseId) {
        Course course = courseContentMapper.findCourseById(courseId);
        return course;
    }

    @Override
    public void saveSection(CourseSection courseSection) {
        Date date = new Date();
        courseSection.setCreateTime(date);
        courseSection.setUpdateTime(date);

        courseContentMapper.saveSection(courseSection);
    }

    @Override
    public void updateSection(CourseSection courseSection) {
        Date date = new Date();
        courseSection.setUpdateTime(date);
        courseContentMapper.updateSection(courseSection);
    }

    @Override
    public void updateSectionStatus(int id ,int status) {
        CourseSection courseSection = new CourseSection();
        Date date = new Date();
        courseSection.setUpdateTime(date);
        courseSection.setId(id);
        courseSection.setStatus(status);
        courseContentMapper.updateSectionStatus(courseSection);
    }

}
