<!-- section start -->

<!-- attr: {id: 'title', class: 'slide-title', hasScriptWrapper: true} -->
# Services
<div class="signature">
    <p class="signature-course">Android Applications</p>
    <p class="signature-initiative">Telerik Software Academy</p>
    <a href="http://academy.telerik.com" class="signature-link">http://academy.telerik.com</a>
</div>


<!-- section start -->
<!-- attr: { id:'table-of-contents', class:'table-of-contents' } -->
# Table of Contents
- What is a Service
- Creating a Service
- Creating a Started Service
- Creating a Bound Service
- Starting a Service
- Stopping a service


<!-- section start -->
<!-- attr: { id:'', class:'slide-section', showInPresentation:true } -->
<!-- # What is a Service -->

# What is a Service
- A Service is an **application component** that can perform long-running **operations in the background**
- Does not provide a user interface
- A component (`Activity`, `Content Provider`) can bind to a service to **interact** with it
- _Examples_:
  - handle network transactions
  - play music
  - perform file I/O

<!-- attr: { showInPresentation:true } -->
<!-- # Service forms -->
- A service can essentially take two forms:
  - `started` and `bound`
- **Started** form
  - When an application component  starts it by calling `startService()`
  - A service can run in the background indefinitely
  - Usually
    - performs a **single operation**
    - does not return a result to the caller
    - then should **stop itself**

<!-- attr: { showInPresentation:true } -->
<!-- # Service forms -->
- **Bound** form
  - When an application component binds to it by calling `bindService()`
  - Offers a client-server interface
  - Components can interact with the service, send requests, get results
- A service can work **both ways**
  - it can be started (to run indefinitely)
  - also allow binding
    - use [onStartCommand()](http://developer.android.com/reference/android/app/Service.html#onStartCommand(android.content.Intent, int, int)) and [onBind()](http://developer.android.com/reference/android/app/Service.html#onBind(android.content.Intent))



<!-- section start -->
<!-- attr: { id:'', class:'slide-section', showInPresentation:true } -->
<!-- # Creating a Service -->

# Creating a Service


<!-- attr: { id:'', class:'slide-section demo', showInPresentation:true } -->
<!-- # Creating a Service -->
[Demo]()



<!-- section start -->
<!-- attr: { id:'', class:'slide-section', showInPresentation:true } -->
<!-- # Creating a Started Service -->

# Creating a Started Service


<!-- attr: { id:'', class:'slide-section demo', showInPresentation:true } -->
<!-- # Creating a Started Service -->
[Demo]()



<!-- section start -->
<!-- attr: { id:'', class:'slide-section', showInPresentation:true } -->
<!-- # Creating a Bound Service -->

# Creating a Bound Service


<!-- attr: { id:'', class:'slide-section demo', showInPresentation:true } -->
<!-- # Creating a Bound Service -->
[Demo]()



<!-- section start -->
<!-- attr: { id:'', class:'slide-section', showInPresentation:true } -->
<!-- # Starting a Service -->

# Starting a Service


<!-- attr: { id:'', class:'slide-section demo', showInPresentation:true } -->
<!-- # Starting a Service -->
[Demo]()


<!-- section start -->
<!-- attr: { id:'', class:'slide-section', showInPresentation:true } -->
<!-- # Stopping a service -->

# Stopping a service


<!-- attr: { id:'', class:'slide-section demo', showInPresentation:true } -->
<!-- # Stopping a Service -->
[Demo]()


<!-- section start -->
<!-- attr: { id:'questions', class:'slide-section', showInPresentation:true } -->
# Questions
<!-- ## Android Applications -->
[link to TelerikAcademy Forum]()
