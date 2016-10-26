# AndroidLovScheduleNotification
Library for schedule notification based on timestamps data.
# Usage
1. Import the library into your project.
  * Grab via maven

    ```xml
    <dependency>
        <groupId>com.alandwiprasetyo.androilovschedule</groupId>
        <artifactId>androidlov-schedule-notification</artifactId>
        <version>1.0.0</version>
        <type>pom</type>
    </dependency>
    ```

  * Grab via gradle

    ```groovy
    compile 'com.alandwiprasetyo.androilovschedule:androidlov-schedule-notification:1.0.0'
    ```

2. Add permissions in your AndroidManifest.xml.

    ```xml
    <uses-permission android:name="android.permission.WAKE_LOCK" />
    <uses-permission android:name="android.permission.VIBRATE" />
    ```

3. Write the following code in your java file.

    ```java
    String timeSchedule = "2016-10-26 21:07:00"; // format timestamps
    ScheduleNotification notification = new ScheduleNotification(0, this, NotifActivity.class, timeSchedule);
    notification.setId(0).setTitle("Title").setMessage("This is a message for notification");
    notification.save();
    ```
    or

    ```java
    ScheduleNotification notification = new ScheduleNotification(this, NotifActivity.class, timeSchedule);
    notification.setTitle("Title").setMessage("This is a message for notification");
    notification.save();
    ```

# To do
  * Show notification before certain time of the event
  * Support for many time format

# Change Log
  **Version 1.0.0**
  * Make class for schedule notification

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
