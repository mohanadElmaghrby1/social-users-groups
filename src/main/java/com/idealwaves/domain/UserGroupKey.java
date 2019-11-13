package com.idealwaves.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.SecondaryTable;
import java.io.Serializable;

/**
 * create by mohannad on 11/11/2019
 */
@Embeddable
public class UserGroupKey implements Serializable {

    @Column(name = "user_id")
    Long studentId;

    @Column(name = "group_id")
    Long courseId;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }
}
