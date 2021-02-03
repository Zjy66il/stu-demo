package org.zjy.service;

public interface Stu2MajorService {
    boolean addRelation(Integer stuId,Integer majorId);

    boolean updateRelation(Integer stuId,Integer majorId,Integer targetMajorId);

    boolean delRelation(Integer stuId, Integer majorId);
}
