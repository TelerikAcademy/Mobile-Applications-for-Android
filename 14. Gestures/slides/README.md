<!-- section start -->

<!-- attr: {id: 'title', class: 'slide-title', hasScriptWrapper: true} -->
# Touch & Gestures
<div class="signature">
    <p class="signature-course">Android Applications</p>
    <p class="signature-initiative">Telerik Software Academy</p>
    <a href="http://academy.telerik.com" class="signature-link">http://academy.telerik.com</a>
</div>


<!-- section start -->
<!-- attr: { id:'table-of-contents', class:'table-of-contents slide-section' } -->
# Table of Contents


<!-- section start -->
<!-- attr: { id:'', class:'slide-section', showInPresentation:true } -->
<!-- # Touch Events -->

# Touch Events
- Override `onTouchEvent()` to capture touch events for an **Activity** or **View**
- Then you have to determine if a gesture you care about occurred
  - You can use `MotionEventCompat.getActionMasked()`
- Or capture touch events for a single `View`

```java
View myView = findViewById(R.id.my_view); 
myView.setOnTouchListener(new OnTouchListener() {
    public boolean onTouch(View v, MotionEvent event) {
        // ... Respond to touch events       
        return true;
    }
});
```

# Detect Gestures
- Android provides the `GestureDetector` class

```java
public class MainActivity extends Activity implements 
        GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener { ...
```

# Tracking Movement
- Whenever the current touch **contact position**, **pressure**, or **size** changes
  - `motionEvent.getHistorySize()` - get positions, sizes, pressures

- Track Velocity - [link](http://developer.android.com/training/gestures/movement.html#velocity)
- Multiple Pointers - [link](http://developer.android.com/training/gestures/multi.html#track)

<!-- section start -->
<!-- attr: { id:'questions', class:'slide-section', showInPresentation:true } -->
# Questions
<!-- ## Android Applications -->
[link to TelerikAcademy Forum]()
