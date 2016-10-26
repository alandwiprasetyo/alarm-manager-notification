# AndroidLOVException
Library for avoid force close when your application is running and will be taken to a new activity which contains hints
# Usage
1. Import the library into your project.
  * Grab via maven
    ```xml
    <dependency>
        <groupId>com.alandwiprasetyo.androidlovexception</groupId>
        <artifactId>androidlov exception</artifactId>
        <version>1.0.0</version>
        <type>pom</type>
    </dependency>
    ```
  * Grab via gradle
    ```groovy
    compile 'com.alandwiprasetyo.androidlovexception:androidlov exception:1.0.0'
    ``` 2. Write the following code in your java file.
    ```java
    AndroidLovException.init(this, ExceptionActivity.class);
    ```
# To do
  * Make error message multylanguage
# Change Log
  **Version 1.0.0**
  * Make class for handler exception
# License
    Copyright 2016 Alan Dwi Prasetyo
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
       http://www.apache.org/licenses/LICENSE-2.0
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
