package com.groupb.week3.assignment1.model;

import java.io.Serializable;

/**
 * @Date - 30/01/2022
 * @Author - Abhishek
 * @Description - This object model create model for student
 */

@SuppressWarnings("serial")
public class StudentModel implements Serializable {
	private String sName;
	private String subject1;
	private String subject2;
	private String subject3;
	private String subject4;
	private String subject5;
	private String average;
	private String grade;
	private String gradePoint;
	private String minValue;
	private String maxValue;

	public StudentModel(String sName, String subject1, String subject2, String subject3, String subject4,
			String subject5, String average, String grade, String gradePoint, String minValue, String maxValue) {
		super();
		this.sName = sName;
		this.subject1 = subject1;
		this.subject2 = subject2;
		this.subject3 = subject3;
		this.subject4 = subject4;
		this.subject5 = subject5;
		this.average = average;
		this.grade = grade;
		this.gradePoint = gradePoint;
		this.minValue = maxValue;
		this.maxValue = minValue;
	}

	public StudentModel() {
		super();
	}

	public String getMinValue() {
		return minValue;
	}

	public void setMinValue(String minValue) {
		this.minValue = minValue;
	}

	public String getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(String maxValue) {
		this.maxValue = maxValue;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getSubject1() {
		return subject1;
	}

	public void setSubject1(String subject1) {
		this.subject1 = subject1;
	}

	public String getSubject2() {
		return subject2;
	}

	public void setSubject2(String subject2) {
		this.subject2 = subject2;
	}

	public String getSubject3() {
		return subject3;
	}

	public void setSubject3(String subject3) {
		this.subject3 = subject3;
	}

	public String getSubject4() {
		return subject4;
	}

	public void setSubject4(String subject4) {
		this.subject4 = subject4;
	}

	public String getSubject5() {
		return subject5;
	}

	public void setSubject5(String subject5) {
		this.subject5 = subject5;
	}

	public String getAverage() {
		return average;
	}

	public void setAverage(String average) {
		this.average = average;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getGradePoint() {
		return gradePoint;
	}

	public void setGradePoint(String gradePoint) {
		this.gradePoint = gradePoint;
	}

	@Override
	public String toString() {
		return "StudentModel [sName=" + sName + ", subject1=" + subject1 + ", subject2=" + subject2 + ", subject3="
				+ subject3 + ", subject4=" + subject4 + ", subject5=" + subject5 + ", average=" + average + ", grade="
				+ grade + ", gradePoint=" + gradePoint + ", minValue=" + minValue + ", maxValue=" + maxValue + "]";
	}

}
