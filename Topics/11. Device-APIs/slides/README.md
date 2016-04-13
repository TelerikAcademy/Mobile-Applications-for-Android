<!-- section start -->

<!-- attr: {id: 'title', class: 'slide-title', hasScriptWrapper: true} -->
# Android
##  Applications
<div class="signature">
    <p class="signature-course">Android Applications</p>
    <p class="signature-initiative">Telerik Software Academy</p>
    <a href="http://academy.telerik.com" class="signature-link">http://academy.telerik.com</a>
</div>


<!-- section start -->
<!-- attr: { id:'table-of-contents', class:'' } -->
# Table of Contents
- Camera - [API Guide](http://developer.android.com/guide/topics/media/camera.html) and [documentation](http://developer.android.com/reference/android/hardware/Camera.html)
- Location - [API Guide](http://developer.android.com/guide/topics/location/index.html)
  - GeolocationPermisions - [documentation](http://developer.android.com/reference/android/webkit/GeolocationPermissions.html)

# Table of Contents
- Sensors
  - Motion Sensors
    - Using the Accelerometer
    - Using the Gyroscope
    - Using the Step Counter and Detector Sensors
  - Position Sensors
    - Using the Orientation Sensor
    - Using the Proximity Sensor
  - Environment Sensors
    - Using the Light, Pressure, and Temperature Sensors
    - Using the Humidity Sensor


<!-- section start -->
<!-- attr: { id:'', class:'slide-section', showInPresentation:true } -->
<!-- # Camera -->

<!-- attr: { hasScriptWrapper:true, style:'font-size:0.9em' } -->
# Camera
- Is the camera so important to your app?
  - You can use existing camera apps with `Intent`s
- Declare the camera requirement in your manifest
  - Request permission:

```xml
<uses-permission android:name="android.permission.CAMERA" / >
```
  - Declare camera features to prevent installation on device without this feature


```xml
<uses-feature android:name="android.hardware.camera" / >
 <uses-feature android:name="android.hardware.camera.autofocus" />
```
- [Building a camera app](http://developer.android.com/guide/topics/media/camera.html#custom-camera)

<!-- section start -->
<!-- attr: { id:'questions', class:'slide-section', showInPresentation:true } -->
# Questions
<!-- ## Android Applications -->
[link to TelerikAcademy Forum]()
