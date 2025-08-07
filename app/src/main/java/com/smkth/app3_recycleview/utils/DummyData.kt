package com.smkth.app3_recycleview.utils

import com.smkth.app3_recycleview.model.Student

object DummyData{
    fun getStudentList(): List<Student> {
        return listOf(
            Student("Andi", "123456", "XII TJKT 1"),
            Student("Okta", "123456", "XII TJKT 1"),
            Student("Soli", "123456", "XII TJKT 1"),
            Student("Nopal", "123456", "XII TJKT 1"),
            Student("Nurin", "123456", "XII TJKT 1"),
            Student("Widya", "123456", "XII TJKT 1"),
            Student("jono", "123456", "XII TJKT 1"),
            Student("Nuri", "123456", "XII TJKT 1"),
            Student("Wiya", "123456", "XII TJKT 1")
        )
    }
}