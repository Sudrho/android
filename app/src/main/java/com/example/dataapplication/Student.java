package com.example.dataapplication;

public class Student {
    private int stuId;
    private String stuName;
    private String stuNO;
    private String stuPhotoId;

    public Student(int stuId, String stuName, String stuNO, String stuPhotoId) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.stuNO = stuNO;
        this.stuPhotoId = stuPhotoId;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuNO() {
        return stuNO;
    }

    public void setStuNO(String stuNO) {
        this.stuNO = stuNO;
    }

    public String getStuPhotoId() {
        return stuPhotoId;
    }

    public void setStuPhotoId(String stuPhotoId) {
        this.stuPhotoId = stuPhotoId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                ", stuNO='" + stuNO + '\'' +
                ", stuPhotoId='" + stuPhotoId + '\'' +
                '}';
    }
}
