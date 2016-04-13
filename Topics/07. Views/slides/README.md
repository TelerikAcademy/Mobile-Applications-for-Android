<!-- section start -->

<!-- attr: {id: 'title', class: 'slide-title', hasScriptWrapper: true} -->
# Views

<div class="signature">
    <p class="signature-course">Android Applications</p>
    <p class="signature-initiative">Telerik Software Academy</p>
    <a href="http://academy.telerik.com" class="signature-link">http://academy.telerik.com</a>
</div>


<!-- section start -->
<!-- attr: { id:'table-of-contents', class:'table-of-contents' } -->
# Table of Contents
- Input Controls
  - Buttons
  - Text Fields
  - Check boxes
  - Toggle Buttons
  - Spinners
  - Pickers


<!-- section start -->
<!-- attr: { id:'', class:'slide-section', showInPresentation:true } -->
<!-- # Input Controls -->

<!-- attr: { hasScriptWrapper:true } -->
# Input Controls
- Input controls are the interactive components in your app's user interface
  - buttons, text fields, seek bars, checkboxes, zoom buttons, toggle buttons, etc.

<img class="slide-image" src="imgs/ui-controls.png" style="left:30%" />

<!-- attr: { showInPresentation:true, hasScriptWrapper:true } -->
<!-- # Input Controls -->
```java
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout 
  xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="fill_parent"
    android:layout_height="fill_parent"
    android:orientation="horizontal">
    <EditText android:id="@+id/edit_message"
        android:layout_weight="1"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:hint="@string/edit_message" />
    <Button android:id="@+id/button_send"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/button_send"
        android:onClick="sendMessage" />
</LinearLayout>
```

# Common Controls
- `Button`
  - A push-button that can be pressed, or clicked, by the user to perform an action
- `EditText`, `AutoCompleteTextView`
  - An editable text field
- `CheckBox`
  - An on/off switch that can be toggled by the user
- `RadioButton`, `RadioGroup`
  - Similar to checkboxes, except that only one option can be selected in the group

<!-- attr: { showInPresentation:true } -->
<!-- # Common Controls -->
- `ToggleButton`
  - An on/off button with a light indicator
  - Classs 
- `Spinner`
  - drop-down list that allows users to select one value from a set
- `DatePicker`, `TimePicker`
  - A dialog for users to select a single value for a set by using up/down buttons or via a swipe gesture


<!-- section start -->
<!-- attr: { id:'', class:'slide-section', showInPresentation:true } -->
<!-- # Buttons -->

<!-- attr: { hasScriptWrapper:true } -->
# Buttons
- A button consists of text or an icon (or both)
  - Communicates what action occurs when the user touches it
- _Examples_:

```xml
<Button
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="@string/button_text"
    ... />
```

<!-- attr: { showInPresentation:true, hasScriptWrapper:true } -->
<!-- # Buttons -->
- Using `ImageButton`

```xml
<ImageButton
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:src="@drawable/button_icon"
    ... />
```
- With both text and icon


```xml
<Button
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="@string/button_text"
    android:drawableLeft="@drawable/button_icon"
    ... />
```

<!-- attr: { showInPresentation:true, hasScriptWrapper:true, style:'font-size:0.9em' } -->
# Responding to Click Events
- Add the `android:onClick` attribute to the `<Button>`

```xml
<?xml version="1.0" encoding="utf-8"?>
<Button ...
    android:onClick="sendMessage" />
```

```java
public void sendMessage(View view) {
    // Do something in response to button click
}
```
- The method must:
  - Be public
  - Return void
  - Define a `View` as its only parameter

# Using an `OnClickListener`
- If you instantiate the `Button` at runtime
- Declare the click behavior in a `Fragment` subclass

```java
Button button = (Button) findViewById(R.id.button_send);
button.setOnClickListener(new View.OnClickListener() {
    public void onClick(View v) {
        // Do something in response to button click
    }
});
```

<!-- attr: { showInPresentation:true, hasScriptWrapper:true, style:'font-size:0.9em' } -->
# Styling a button
- To create a borderless button

```xml
<Button ...
    style="?android:attr/borderlessButtonStyle"
    android:text="@string/hello" />
```
- Or create yout own style in `res > style.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <style name="CodeFont" parent="@android:style/TextAppearance.Medium">
        <item name="android:layout_width">fill_parent</item>
        <item name="android:layout_height">wrap_content</item>
        <item name="android:textColor">#00FF00</item>
        <item name="android:typeface">monospace</item>
    </style>
</resources>
```

<!-- attr: { id:'', class:'slide-section demo', showInPresentation:true } -->
<!-- # Buttons -->
[Demo]()


<!-- section start -->
<!-- attr: { id:'', class:'slide-section', showInPresentation:true } -->
<!-- # Text Fields -->

<!-- attr: { showInPresentation:true, hasScriptWrapper:true } -->
# Text Fields
- Allows the user to type text into your app
  - single line or multi-line
- Touching a text field places the cursor and automatically displays the keyboard

<img class="slide-image" src="imgs/edittext-noextract.png" style="height:40%; left:30%" />

<!-- attr: { showInPresentation:true, hasScriptWrapper:true } -->
# Keyboard Type
- Use the `android:inputType` attribute
  - `text`
  - `textEmailAddress`
    - keyboard with the **@** character
  - `textUri`
    - keyboard with the **/** character
  - `number`
  - `phone`
    - phone-style keypad

```xml
<EditText
  android:inputType="textEmailAddress />"
```

<!-- attr: { showInPresentation:true, hasScriptWrapper:true } -->
# Controlling other behaviors
- The `android:inputType` allows you to specify keyboard behaviors
  - `textCapSentences`
  - `textCapWords`
  - `textAutoCorrect`
  - `textPassword`
  - `textMultiLine`

```xml
<EditText ...
    android:hint="@string/postal_address_hint"
    android:inputType="textPostalAddress|
                       textCapWords|
                       textNoSuggestions" />
```

<!-- attr: { showInPresentation:true, hasScriptWrapper:true, style:'font-size:0.9em' } -->
# Specifying Keyboard Actions
- Specify an action to be made when users have completed their input

```xml
<EditText ...
    android:imeOptions="actionSend" />
```
- Then listen for the specific action event

```java
editText.setOnEditorActionListener(new OnEditorActionListener() {
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        // hanndle the event
    }
});
```

- [more info](http://developer.android.com/guide/topics/ui/controls/text.html#Actions)
- [imeOptions documentation](http://developer.android.com/reference/android/widget/TextView.html#attr_android:imeOptions)

<!-- attr: { showInPresentation:true, hasScriptWrapper:true } -->
# `AutoCompleteTextView`

- You must specify an Adapter

```java
AutoCompleteTextView textView = 
    (AutoCompleteTextView) findViewById(R.id.autocomplete_country);

String[] countries = getResources()
    .getStringArray(R.array.countries_array);

ArrayAdapter<String> adapter = 
    new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countries);
textView.setAdapter(adapter);
```

<img class="slide-image" src="imgs/edittext-autocomplete.png" style="height:30%; left:60%; top:65%" />

<!-- attr: { id:'', class:'slide-section demo', showInPresentation:true } -->
<!-- # Text Fields -->
[Demo]()

<!-- section start -->
<!-- attr: { id:'', class:'slide-section', showInPresentation:true } -->
<!-- # Check boxes -->

<!-- attr: { showInPresentation:true, hasScriptWrapper:true } -->
# Check boxes
- Checkboxes allow the user to select one or more options from a set
- Typically, you should present each checkbox option in a vertical list
- Each checkbox is managed separately and you must register a click listener for each one

<img class="slide-image" src="imgs/checkboxes.png" style="height:30%; left:60%; top:60%" />

<!-- attr: { showInPresentation:true, hasScriptWrapper:true, style:'font-size:0.8em' } -->
# Responding to Click Events

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout ...>
    <CheckBox android:id="@+id/checkbox_meat"
        ...
        android:text="@string/meat"
        android:onClick="onCheckboxClicked"/>
    <CheckBox android:id="@+id/checkbox_cheese"
        ...
        android:text="@string/cheese"
        android:onClick="onCheckboxClicked"/>
</LinearLayout>
```
- Within the `Activity` that hosts this layout

```java
public void onCheckboxClicked(View view) {
    boolean checked = ((CheckBox) view).isChecked();
    
    switch(view.getId()) {
        case R.id.checkbox_meat:
            if (checked) ... else ... break;
        case R.id.checkbox_cheese:
            if (checked) ... else ... break;
    }
}
```

<!-- attr: { id:'', class:'slide-section demo', showInPresentation:true } -->
<!-- # Check boxes -->
[Demo]()


<!-- section start -->
<!-- attr: { id:'', class:'slide-section', showInPresentation:true } -->
<!-- # Radio Buttons -->

<!-- attr: { showInPresentation:true, hasScriptWrapper:true, style:'font-size:0.9em' } -->
# Radio Buttons
- Allow the user to select one option from a set
  - group them together inside a `RadioGroup`

```xml
<RadioGroup ...
    android:orientation="vertical">
    <RadioButton ...
        android:text="@string/pirates"
        android:onClick="onRadioButtonClicked"/>
    <RadioButton ...
        android:text="@string/ninjas"
        android:onClick="onRadioButtonClicked"/>
</RadioGroup>
```
- If it's not necessary to show all options side-by-side, use a spinner instead

<img class="slide-image" src="imgs/radiobuttons.png" style="height:15%; left:50%; top:80%" />

<!-- attr: { showInPresentation:true, hasScriptWrapper:true, style:'font-size:0.9em' } -->
# Responding to Click Events
- Within the `Activity` that hosts this layout

```java
public void onRadioButtonClicked(View view) {
    boolean checked = ((RadioButton) view).isChecked();
    
    switch(view.getId()) {
        case R.id.radio_pirates: if (checked) ... break;
        case R.id.radio_ninjas: if (checked) ... break;
    }
}
```

- The method must:
  - Be public
  - Return void
  - Define a `View` as its only parameter


<!-- attr: { id:'', class:'slide-section demo', showInPresentation:true } -->
<!-- # Radio Buttons -->
[Demo]()

<!-- section start -->
<!-- attr: { id:'', class:'slide-section', showInPresentation:true } -->
<!-- # Toggle Buttons -->

<!-- attr: { showInPresentation:true, hasScriptWrapper:true } -->
# Toggle Buttons
- A toggle button allows the user to change a setting between two states
  - **From Android 4.0** (API level 14) you can use a `Switch` object
- `CompoundButton.setChecked()` or `CompoundButton.toggle()` to change state yourself

<img class="slide-image" src="imgs/switch.png" style="width:30%; left:20%; top:78%" />
<img class="slide-image" src="imgs/togglebutton.png" style="width:30%; left:60%; top:70%" />

<!-- attr: { showInPresentation:true, hasScriptWrapper:true } -->
# Responding to Button Presses
```java
ToggleButton toggle = 
    (ToggleButton) findViewById(R.id.togglebutton);
toggle.setOnCheckedChangeListener(
    new CompoundButton.OnCheckedChangeListener() {
        public void onCheckedChanged(
          CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                // The toggle is enabled
            } else {
                // The toggle is disabled
            }
        }
});
```

<!-- attr: { id:'', class:'slide-section demo', showInPresentation:true } -->
<!-- # Toggle Buttons -->
[Demo]()


<!-- section start -->
<!-- attr: { id:'', class:'slide-section', showInPresentation:true } -->
<!-- # Spinners -->

<!-- attr: { showInPresentation:true, hasScriptWrapper:true } -->
# Spinners
- Spinners provide a quick way to select one value from a set
- The choices you provide for the spinner must be provided through an `SpinnerAdapter`
  - such as an `ArrayAdapter` or a `CursorAdapter`

```java
ArrayAdapter<CharSequence> adapter = ArrayAdapter
    .createFromResource(this, R.array.planets_array,
        android.R.layout.simple_spinner_item);

// Specify the layout to use when the list of choices appears
adapter.setDropDownViewResource(
    android.R.layout.simple_spinner_dropdown_item);
spinner.setAdapter(adapter);
```

<img class="slide-image" src="imgs/spinner.png" style="height:45%; left:80%; top:20%" />

<!-- attr: { showInPresentation:true, hasScriptWrapper:true } -->
# Responding to User Selections
- Implement the `AdapterView.OnItemSelectedListener` with your `Activity` or `Fragment`

```java
public class SpinnerActivity extends Activity
  implements OnItemSelectedListener {
    ...    
    public void onItemSelected(...) { ... }
    public void onNothingSelected(...) { ... }
}
```
  - Then 

```java
Spinner spinner = (Spinner) findViewById(R.id.spinner);
spinner.setOnItemSelectedListener(this);
```

<!-- attr: { id:'', class:'slide-section demo', showInPresentation:true } -->
<!-- # Spinners -->
[Demo]()


<!-- section start -->
<!-- attr: { id:'', class:'slide-section', showInPresentation:true } -->
<!-- # Pickers -->

<!-- attr: { showInPresentation:true, hasScriptWrapper:true } -->
# Pickers
- Each picker provides controls for selecting each part of the:
  - `Time` - hour, minute, AM/PM
  - `Date` - month, day, year
- Ensure that your users can pick
  - time or date that is **valid**
  - **formatted** correctly
  - adjusted to the **user's locale**
- [Pickers API Guides](http://developer.android.com/guide/topics/ui/controls/pickers.html)

<!-- attr: { id:'', class:'slide-section demo', showInPresentation:true } -->
<!-- # Pickers -->
[Demo]()


<!-- section start -->
<!-- attr: { id:'questions', class:'slide-section', showInPresentation:true } -->
# Questions
<!-- ## Android Applications -->
[link to TelerikAcademy Forum]()
