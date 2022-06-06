[![Maven Central](https://img.shields.io/maven-central/v/com.saadahmedev.tinydb/tinydb.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22com.saadahmedev.shortintent%22%20AND%20a:%22tinydb%22)
[![License](https://img.shields.io/badge/License-Apache_2.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
<a href="https://android-arsenal.com/api?level=16"><img alt="API" src="https://img.shields.io/badge/API-16%2B-brightgreen.svg?style=flat"/></a>
<a href="https://github.com/saadahmedscse/shortintent"><img alt="API" src="https://badges.frapsoft.com/os/v1/open-source.png?v=103"/></a>
<a href="https://github.com/saadahmedscse/shortintent/graphs/traffic"><img alt="Total Clones" src="https://img.shields.io/badge/Clones-21-orange"/></a>
<a href="[https://github.com/rrsaikat/CodeChallengeByShikho/graphs/traffic](https://github.com/saadahmedscse/shortintent/graphs/traffic)"><img alt="Total Views" src="https://img.shields.io/badge/Views-76-brightgreen"/></a>
# TinyDB
Getting tired by usign the default Shared Preferences class? TinyDB is a lightweight and easy to use Android library that provides user to save data in shared preferences by just a few steps.
* Min SDK 16 (Android Jellybean 4.1)
* Written in Java

A lightweight, easy-to-use Android library that lets us to keep data in shared preferences also with objects and much more features

## Installation

Add the dependency to your module build.gradle:
```groovy
dependencies {
    ...
    implementation 'com.saadahmedev.tinydb:tinydb:1.0.0'
}
```

## Usage
### Get all features of default Shared Preferences class:
```java
TinyDB.getInstance(this)
        .putString("key1", "Hello")
        .putString("key2", "World")
        .putInt("key3", 5)
        .putLong("key4", 123456789)
        .putBoolean("key5", true)
        .putStringSet("key6", set)
        .apply();
```
```java
String value = TinyDB.getInstance(this).getString("key1", "Default Value");
```

### Get some extra cool features from TinyDB:
- Put and Get Object
```java
Student student1 = new Student();
Student student2 = new Student();

student1.setName("Fahad");
student1.setAge(36);

student2.setName("Saad");
student2.setAge(22);

TinyDB.getInstance(this)
      .putObject("key1", student1)
      .putObject("key2", student2)
      .apply();
```
```java
Student student = TinyDB.getInstance(this).getObject("key1", Student.class);
```

- Put and Get Uri
```java
TinyDB.getInstance(this)
        .putImageUri("key1", uri)
        .apply();
```
```java
Uri uri = TinyDB.getInstance(this).getImageUri("key1");
```

- Put and Get Bitmap
```java
TinyDB.getInstance(this)
        .putImageBitmap("key1", bitmap)
        .apply();
```
```java
Bitmap bitmap = TinyDB.getInstance(this).getImageBitmap("key1");
```

## License
```
Copyright 2022 Saad Ahmed

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
