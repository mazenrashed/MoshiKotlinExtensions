# Moshi Kotlin Extensions
Kotlin extensions for Moshi, Make every thing you want with Moshi in just one line.

## Samples
### We have "Student" class to explan the samples
```kotlin
data class Student(var name: String)
```

### Deserialize Json object
```kotlin
private val studentJson = "{\"name\":\"mazen\"}"
val student: Student? = studentJson.deserialize<Student>()
```


### Deserialize Json array
```kotlin
private val studentsJson = "[{\"name\":\"Mazen\"},{\"name\":\"Mohammad\"}]"
val students: List<Student>? = studentsJson.deserializeList()
```


### Serialize Json
```kotlin
private val student: Student = Student("mazen")
val serializedObject = student.serialize()
```

### Check if you can convert json to a particular type
```kotlin
val carConvertStudentJsonToStudent: Boolean = studentJson.canConvertTo(Student::class.java) //true
```

### If you have a custom Moshi instance you want to use it (For example: To apply Moshi adapters)
```kotlin
MoshiExtensions.init(YOUR INSTANCE)
```


## Contributing

We welcome contributions!
* ⇄ Pull requests and ★ Stars are always welcome.
