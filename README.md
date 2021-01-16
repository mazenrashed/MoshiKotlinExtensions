# Moshi Kotlin Extensions

Kotlin extensions for Moshi, Make every thing you want with Moshi in just one line.

[![](https://jitpack.io/v/mazenrashed/MoshiKotlinExtensions.svg)](https://jitpack.io/#mazenrashed/MoshiKotlinExtensions)
[![Android Arsenal]( https://img.shields.io/badge/Android%20Arsenal-Moshi%20Kotlin%20Extensions-green.svg?style=flat )]( https://android-arsenal.com/details/1/8216 )

###  Add the JitPack repository to your build file
```groovy
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```
### Add dependency
```groovy
dependencies {
    implementation 'com.github.mazenrashed:MoshiKotlinExtensions:${LAST_VERSION}'
}
```

#### We have "Student" class to explan the examples
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
val canConvertStudentJsonToStudent: Boolean = studentJson.canConvertTo(Student::class.java) //true
```

### If you have a custom Moshi instance you want to use it (For example: To apply Moshi adapters)
```kotlin
MoshiExtensions.init(YOUR INSTANCE)
```


## Contributing

We welcome contributions!
* ⇄ Pull requests and ★ Stars are always welcome.
