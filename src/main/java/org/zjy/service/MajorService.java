package org.zjy.service;

import org.zjy.entity.Major;

import java.util.List;

public interface MajorService {

    Major getMajor(Integer id);

    List<Major> getAllMajor();

    boolean addMajor(Major major);

    boolean updateMajor(Major major);

    boolean delMajor(Integer majorId);

    List<Major> listAllMajor4Stu(Integer stuId);

}
