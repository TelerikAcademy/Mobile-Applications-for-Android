<!-- section start -->

<!-- attr: {id: 'title', class: 'slide-title', hasScriptWrapper: true} -->
# Setting up Android Environment
<div class="signature">
    <p class="signature-course">Android Applications</p>
    <p class="signature-initiative">Telerik Software Academy</p>
    <a href="http://academy.telerik.com" class="signature-link">http://academy.telerik.com</a>
</div>


<!-- section start -->
<!-- attr: { id:'table-of-contents', class:'table-of-contents' } -->
# Table of Contents
- Setup Android Environment
  - Download and setup SDKs
  - Download and install Emulators
    - Genymotion
- Android History
- Devices
- Emulators
- "Hello World" app
- App Manifest
- Application Life-cycle


<!-- section start -->
<!-- attr: { id:'', class:'slide-section', showInPresentation:true } -->
# Setup Android

# Setup Android
- Download SDK from [http://developer.android.com/](http://developer.android.com/sdk/index.html)
  - You need to have JDK 1.7 or higher
  - Need to have System Path `JAVA_HOME` set to `C:\Program Files\Java\jdk[version]`
- [http://developer.android.com](http://developer.android.com/)
- [Documentation](http://developer.android.com/reference/packages.html)
- [API Guides](http://developer.android.com/guide/index.html)

- Step-by-step [Android Fundamentals course](https://www.udacity.com/wiki/ud853)


<!-- section start -->
<!-- attr: { id:'', class:'slide-section', showInPresentation:true } -->
<!-- # Android Mobile Devices -->

# Android Mobile Devices
- Android Devices
  - Phones, Tablets, Wearables, TVs, Auto
  - Very different screen resolutions
  - [Device Compatibility](http://developer.android.com/guide/practices/compatibility.html)
- Key Mobile Challenges
  - Low processing power
  - Limited RAM
  - Intermittent, Low bandwidth, high latency data Connection
  - Impact on battery life

<!-- section start -->
<!-- attr: { id:'', class:'slide-section', showInPresentation:true } -->
<!-- # Android History -->

# Android History
- Android 1.0 - 2008
  - Since then there have been 11 major platform releases
- Android 1.6 **Donut**
  - Quick Search box
    S- search the web and local content
  - Screen size diversity
- Android 2.1 **Eclair**
  - Google maps navigation
  - Home screen customization
  - Speech-to-text

<!-- attr: { showInPresentation:true } -->
<!-- # Android History -->
- Android 2.2 **Froys**
  - Voice Actions
  - Portable hotspot
  - Performance
    - Dalvik JIT compiler
    - V8 JavaScript Engine
- Android 2.3 **Gingerbread**
  - Gaming APIs
  - Near Field Communication
  - Battery Management

<!-- attr: { showInPresentation:true } -->
<!-- # Android History -->
- Android 3.0 **Honeycomb**
  - Tablet-friendly design
  - System bar
  - Quick settings
- Android 4.0 **Ice Cream Sandwich**
  - Custom home screen
  - Data usage control
  - Android Beam

<!-- attr: { showInPresentation:true } -->
<!-- # Android History -->
- Android 4.1 **Jelly Bean**
  - Google Now
  - Actionable notifications
  - Account switching
- Android 4.4 **KitKat**
  - Voice: 'Ok Google'
  - Immersive design
  - Smart dialer

<!-- attr: { showInPresentation:true } -->
<!-- # Android History -->
- Android 5.0 **Lollipop**
  - Material Design
  - Multiscreen
  - Notifications
- Android 6.0 **Marshmallow**
  - Now On Tap
  - Permissions
  - Battery
- For more info on [Android History](https://www.android.com/history)


<!-- section start -->
<!-- attr: { id:'', class:'slide-section', showInPresentation:true } -->
<!-- # Emulators -->

# Emulators
- GenyMotion from [genymotion.com](https://www.genymotion.com/#!/developers/user-guide#installing-genymotion)
  - Fast and reliable for testing
  - Uses VirtualBox
- VisualStudio Emulator
  - Uses Hyper-V
- Best way for testing is on a real device

<!-- section start -->
<!-- attr: { id:'', class:'slide-section', showInPresentation:true } -->
<!-- # New Android Project -->

# New Android Project
- [Directory Structure](https://developer.android.com/tools/projects/index.html)
- [Udacity course](https://www.udacity.com/course/progress#!/c-ud853)

- Minimum API - for Jan 2016
  - API 15: Android 4.0.3 (IceCreamSandwich) 
    - Currently can run on **96.2%** of devices
  - Create a new Blank Activity with Fragment
  - Wait for Gradle build to finish

<!-- attr: { style:'font-size:0.9em' } -->
# What's next
1. Add new Icon
  - Right-click on 'app'
  - New > Image asset
2. Run Emulator
  - Install HAXM (Hardware Accelerated Execution Manager) if needed
    - From SDK Manager
  - Go to `C:\Users\[your user name]\AppData\ Local\Android\sdk\extras\intel\ Hardware_Accelerated_Execution_Manager\`
  - Run `intelhaxm-android.exe`
    - May need to turn off Hyper-V from Windows Features

<!-- attr: { style:'font-size:0.9em' } -->
# Gradle
- Builds the Android Project
- Compiles the java code to binary
- Packages the project (APK)
  - Byte code, Resources, Manifest
- APK is then signed
- Installed on the device with ADB (Android debug bridge)
- For more details:
  - [Building with Gradle](http://developer.android.com/sdk/installing/studio-build.html?utm_source=udacity&utm_medium=mooc&utm_term=android&utm_content=studio_gradle&utm_campaign=training)
  - [Android Debug Bridge](http://developer.android.com/tools/help/adb.html?utm_source=udacity&utm_medium=mooc&utm_term=android&utm_content=adb&utm_campaign=training)

# Connect to real device
- Connect with USB
  - [Download](http://developer.android.com/tools/extras/oem-usb.html#Drivers) USD Drivers for the device
- Enable USB Debugging on device
  - On > 4.2 Developer options is hidden
    - Go to Settings > About Phone and tap `7` times on Build Number
- Setup computer to detect device
- [Using Hardware Devices](http://developer.android.com/tools/device.html#setting-up?utm_source=udacity&utm_medium=mooc&utm_term=android&utm_content=dev_mode&utm_campaign=training)

<!-- section start -->
<!-- attr: { id:'', class:'slide-section', showInPresentation:true } -->
<!-- # Android Application
## Components and Life-cycle -->

# The Application
- Not much more than a container for your components
  - Activities
  - Services
  - Providers (Content providers)
  - Receivers
    - You need to register every one in the App Manifest

<!-- attr: { hasScriptWrapper:true } -->
# The Application Life-cycle
<img class="slide-image" src="imgs/app-life-cycle.png" style="height:80%; left:30%" />

# Context
- Interface to global information about an application environment
- An abstract class whose implementation is provided by the Android system
- It allows access to
  - Application-specific resources and classes
  - Up-calls for application-level operations
    - Launching activities
    - Broadcasting
    - Receiving intents, etc.

<!-- attr: { style:'font-size:0.9em' } -->
# Activity
- Activity - represents a single screen of the UI
- When you start an application you actually start an Activity within that application
- As a developer you cannot control the state of the Activity
  - You can control what happens in a transition
    - By `@Override`-ing `onCreate()`, `onStart()`, etc.
- Only 1 activity may be in **running** state and many in **stoped** state
- In Android you cannot decide to **destroy** an activity
  - The device manages it's own memory

<!-- attr: { showInPresentation:true, hasScriptWrapper:true } -->
<!-- # Activity Life-cycle -->
<img class="slide-image" src="imgs/activity-life-cycle.png" style="height:80%; left:30%" />

<!-- attr: { hasScriptWrapper:true, style:'font-size:0.9em' } -->
# Services
- 'Background' process - has no UI
  - If the activity is **destroyed** the service continues to run
    - Eg. play music
- Used to check for new data on the net
- The developer controls the life of the service

<img class="slide-image" src="imgs/service-life-cycle.png" style="height:45%; left:25%; top:48%" />

# Content Providers
- Content Providers
  - Used when two apps need to share data
  - Contacts
  - MediaStore
  - Settings

# Adapters
- An Adapter object acts as a bridge between an `AdapterView` and the underlying data
  - Provides access to the data items
  - Makes a `View` for each item in the data set
- An intelligent way to connect large amount of data to a tiny screen
- Automatically figure out how to pull the 'next' when you scroll
- Efficient and scalable

# Fragment
- Activities can contain one or more Fragments
- Fragments are modular sections of an activity
  - Usually meant to display UI
  - Fragments are **Reusable UI**
- Two activities can have the same fragment and fragments can be added or removed from an Activity
- Introduced in Honeycomb
- Used through the `FragmentManager`

# Loaders
- Intelligent way to load data asynchronously
- Loading data form the net
  - May take time
  - The device may not have a connection (blocks the UI)
- Used through the `LoaderManager`

# Broadcast Receiver
- A dormant piece of code that is registered for some event in the future
  - Eg. battery low, boot completed, network
- An intent based publish-subscribe mechanism  
- Great for listening system events such as SMS messages
- Just implement `onReceive()`

# App Widgets
- 'Lives' outside of the app
  - Runs in another app as a guest
- Show on the home screen
- Similar as Broadcast Receiver as implementation
- Goes together with a meta-data file
  - Size, update period

<!-- section start -->
<!-- attr: { id:'questions', class:'slide-section', showInPresentation:true } -->
# Questions
<!-- ## Android Applications -->
[link to TelerikAcademy Forum]()
