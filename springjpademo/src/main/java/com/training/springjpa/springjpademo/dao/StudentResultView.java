package com.training.springjpa.springjpademo.dao;

import org.springframework.beans.factory.annotation.Value;

public interface StudentResultView {
    @Value("#{target.name + ' - ' + target.email}")
    String getStudentInfo();
}
