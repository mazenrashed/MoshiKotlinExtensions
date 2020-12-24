package com.mazenrashed.moshikotlinextensions

import org.junit.Assert.assertEquals
import org.junit.Test

internal class MoshiExtensionUnitTest {
    private val studentJson = "{\"name\":\"mazen\"}"
    private val receiptJson = "{\"total\": 19}"
    private val student: Student = Student("mazen")
    private val studentsJson = "[{\"name\":\"mazen1\"},{\"name\":\"mazen2\"}]"
    private val students = listOf(Student("mazen1"), Student("mazen2"))

    @Test
    fun test_serialize_object() {
        val serializedObject = student.serialize()
        assertEquals(studentJson, serializedObject)
    }

    @Test
    fun test_serialize_list() {
        val serializedObject = students.serialize()
        assertEquals(studentsJson, serializedObject)
    }

    @Test
    fun test_deserialize_object() {
        val student: Student? = studentJson.deserialize<Student>()
        assertEquals(this.student, student)
    }

    @Test
    fun test_deserialize_list() {
        val students: List<Student>? = studentsJson.deserializeList()
        assertEquals(this.students, students)
    }

    @Test
    fun test_can_convert_to_invalid_case() {
        val carConvertReceiptJsonToStudent: Boolean = receiptJson.canConvertTo(Student::class.java)
        assert(!carConvertReceiptJsonToStudent)
    }

    @Test
    fun test_can_convert_to_valid_case() {
        val carConvertStudentJsonToStudent: Boolean = studentJson.canConvertTo(Student::class.java)
        assert(carConvertStudentJsonToStudent)
    }


}

data class Student(var name: String)
