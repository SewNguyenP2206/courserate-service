package com.example.CourseRateService.Service;


import com.example.CourseRateService.Client.AccountClient;
import com.example.CourseRateService.Client.CourseClient;
import com.example.CourseRateService.DTO.ResponeAccountDTO;
import com.example.CourseRateService.DTO.ResponeCourseDTO;
import com.example.CourseRateService.Entity.CourseRate;
import com.example.CourseRateService.Repository.CourseRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CourseRateService implements ICourseRateService{

    @Autowired
    CourseRateRepository courseRateRepository;

    @Autowired
    CourseClient courseClient;

    @Autowired
    AccountClient accountClient;

    @Override
    public Float getAvgCourseRateByCourseId(Integer courseId) {
        Float avg = courseRateRepository.avgCourseRateByCourseId(courseId);
        return avg;
    }

    @Override
    public int getCourseRateCountByCourseId(Integer courseId) {
        return courseRateRepository.countCourseRateByCourseId(courseId);
    }

    @Override
    public List<CourseRate> getCourseRatesByCourseId(Integer courseId) {
        List<CourseRate> courseRates = courseRateRepository.showCourseRateByCourseId(courseId);
        return courseRates;
    }

    @Override
    public String saveCourseRate(Integer courseId, Integer accountId, Integer rate, String comment) {
        ResponeCourseDTO courseOptional = courseClient.findCoursesByCourseId(courseId);//FeignCall
        if (courseOptional == null) {
            return"Course is not exist!";
        }
        ResponeAccountDTO accountOptional = accountClient.getAccountInformation(accountId).getBody() ;//FeignCall
        if(accountOptional == null) {
            return "Account is not exist!";
        }
        CourseRate courseRate = new CourseRate();
        courseRate.setComment(comment);
        courseRate.setRate(rate);
        courseRate.setAccountId(accountId);
        courseRate.setCourseId(courseId);
        courseRate.setTimeRate(new Date());
        courseRateRepository.save(courseRate);
        return "Successfully";
    }

    @Override
    public String RateOfCourse(Integer courseId, Integer accountId, Integer rate, String comment) {
        ResponeCourseDTO courseOptional = courseClient.findCoursesByCourseId(courseId);//FeignCall
        if (courseOptional == null) {
            return "Course is not exist";
        }
        ResponeAccountDTO accountOptional = accountClient.getAccountInformation(accountId).getBody() ;//FeignCall
        if(accountOptional == null) {
            return "Account is not exist";
        }
        CourseRate courseRate=new CourseRate();
        courseRate.setTimeRate(new Date());
        courseRate.setRate(rate);
        courseRate.setComment(comment);
        courseRate.setAccountId(accountId);
        courseRate.setCourseId(courseId);
        courseRateRepository.save(courseRate);
        return "Successfully";
    }

    @Override
    public List<CourseRate> getCourseRate(Integer courseId) {
        List<CourseRate> courseRates = courseRateRepository.getCourseRateByCourseId(courseId);
        return courseRates;
    }

    @Override
    public String updateCourseRate(Integer courseId, Integer accountId, Integer rate, String comment) {
        Optional<CourseRate> courseRateOptional=courseRateRepository.getCourseRateByAccountIdAndCourseId(accountId,courseId);
        if (courseRateOptional.isPresent()) {
            CourseRate courseRate = courseRateOptional.get();
            courseRate.setTimeRate(new Date());
            courseRate.setRate(rate);
            courseRate.setComment(comment);
            courseRate.setAccountId(accountId);
            courseRate.setCourseId(courseId);
            courseRateRepository.save(courseRate);
            return "Successfully";
        }
        return "Error when update rating course";

    }

    @Override
    public int updateAnn(String comment, int id) {
            return courseRateRepository.updateAnn(comment,id);
    }

    @Override
    public String DeleteCourseRate(Integer id) {
        courseRateRepository.deleteById(id);
        return "Successfully";
    }
}
