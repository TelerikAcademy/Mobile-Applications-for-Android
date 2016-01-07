<!-- section start -->

<!-- attr: {id: 'title', class: 'slide-title', hasScriptWrapper: true} -->
# Android Layouts
<div class="signature">
    <p class="signature-course">Android Applications</p>
    <p class="signature-initiative">Telerik Software Academy</p>
    <a href="http://academy.telerik.com" class="signature-link">http://academy.telerik.com</a>
</div>


<!-- section start -->
<!-- attr: { id:'table-of-contents', class:'table-of-contents' } -->
# Table of Contents
- Layouts
  - Linear Layout
  - Relative Layout
  - List View
  - Grid View


<!-- section start -->
<!-- attr: { id:'', class:'slide-section', showInPresentation:true } -->
<!-- # Layouts -->

# Layouts
- A layout defines the visual structure for a user interface, such as the UI for an activity or app widget
- Declare a layout in two ways:
  - Declare UI elements in XML
  - Instantiate layout elements at runtime
- The Android framework gives you the flexibility to use **either** or **both** of these methods for declaring and managing your application's UI

<!-- attr: { hasScriptWrapper:true } -->
# Layouts in XML

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout 
  xmlns:android="http://schemas.android.com/apk/res/android"
              android:layout_width="match_parent"
              android:layout_height="match_parent"
              android:orientation="vertical" >
    <TextView android:id="@+id/text"
              android:layout_width="wrap_content"
              android:layout_height="wrap_content"
              android:text="Hello, I am a TextView" >
    </TextView>
    <Button android:id="@+id/button"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Hello, I am a Button">
    </Button>
</LinearLayout>
```

<!-- attr: { hasScriptWrapper:true } -->
# Load the XML Resource
- Each XML layout file is compiled into a View resource
- Load the layout resource from your application code, in your `Activity.onCreate()`

```java
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main_layout);
}
```

# Attributes
- Every `View` and `ViewGroup` object supports their own variety of XML attributes
- Some attributes are specific to a View object
  - For example, `TextView` supports the `textSize` attribute
- Some are common to all View objects
    ```java
    android:id="@+id/my_button"
    ```
    ```java
    Button myButton = (Button) findViewById(R.id.my_button);
    ```

<!-- attr: { hasScriptWrapper:true } -->
# Layout Parameters
- XML layout attributes named `layout_something`
  - Appropriate for the `ViewGroup` in which it resides
- `ViewGroup.LayoutParams`
  - Define the size and position for each child view

<img class="slide-image" src="imgs/layoutparams.png" style="height:45%; top:50%; left: 20%" />

<!-- attr: { showInPresentation:true } -->
<!-- # Layout Parameters -->
- All view groups include a width and height
  - `layout_width`
  - `layout_height`
- Each view is required to define them
- More often, you will use one of these constants
  - `wrap_content`
  - `match_parent`

# Layout Position
- A view has a location, expressed as a pair of left and top coordinates and two dimensions
- The unit for location and dimensions is the pixel
- Methods `getLeft()` and `getTop()` retrieve the location of a view relative to its direct parent

<!-- attr: { style:'font-size:0.9em' } -->
# Size, Padding and Margins
- A view has two pairs of width and height values
  - **measured width** and **measured height**
    - Dimensions define how big a view wants to be within its parent
    - Obtained by calling `getMeasuredWidth()` and `getMeasuredHeight()`
  - **width** and **height**
    - Define the actual size of the view on screen
    - Obtained by calling `getWidth()` and `getHeight()`
- To measure its dimensions, a view takes into account its padding
  - `setPadding(int, int, int, int)`


<!-- section start -->
<!-- attr: { id:'', class:'slide-section', showInPresentation:true, hasScriptWrapper:true } -->
<!-- # Linear Layout -->
<img class="slide-image" src="imgs/linearlayout.png" style="left:30%" />

# Linear Layout
- `LinearLayout` is a view group that aligns all children in a single direction
  - **vertically** or **horizontally**
  - specified with the `android:orientation`
- All children of a `LinearLayout` are stacked one after the other
- `LinearLayout` respects **margins** between children and the **gravity** (right, center, or left alignment) of each child

<!-- attr: { class:'slide-section demo', showInPresentation:true } -->
<!-- # Linear Layout -->
[Demo]()

<!-- section start -->
<!-- attr: { id:'', class:'slide-section', showInPresentation:true, hasScriptWrapper:true } -->
<!-- # Relative Layout -->
<img class="slide-image" src="imgs/relativelayout.png" style="left:30%" />

<!-- attr: { hasScriptWrapper:true } -->
# Relative Layout
- A view group that displays child views in relative positions
- The position of each view can be specified as relative to sibling elements
  - such as to the **left-of** or **below** another view
- Or in positions relative to the parent `RelativeLayout` area
  - such as aligned to the **bottom**, **left** or **center**

<!-- attr: { style:'font-size:0.9em' } -->
# Relative Layout
- `android:layout_alignParentTop`
  - If "true", makes the top edge of this view match the top edge of the parent
- `android:layout_centerVertical`
  - If "true", centers this child vertically within its parent
- `android:layout_below`
  - Positions the top edge of this view below the view specified with a resource ID
- `android:layout_toRightOf`
  - Positions the left edge of this view to the right of the view specified with a resource ID

<!-- attr: { hasScriptWrapper:true, style:'font-size:0.9em' } -->
# Relative Layout

```xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout
  xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingLeft="16dp"
    android:paddingRight="16dp" >
    <EditText
        android:id="@+id/name"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="@string/reminder" />
    <Spinner
        android:id="@+id/dates"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_below="@id/name"
        android:layout_alignParentLeft="true"
        android:layout_toLeftOf="@+id/times" />
```

<!-- attr: { hasScriptWrapper:true, style:'font-size:0.9em' } -->
# Relative Layout
```xml    
    <Spinner
        android:id="@id/times"
        android:layout_width="96dp"
        android:layout_height="wrap_content"
        android:layout_below="@id/name"
        android:layout_alignParentRight="true" />
    <Button
        android:layout_width="96dp"
        android:layout_height="wrap_content"
        android:layout_below="@id/times"
        android:layout_alignParentRight="true"
        android:text="@string/done" />
</RelativeLayout>
```
<img class="slide-image" src="imgs/sample-relativelayout.png" style="top:40%; left:80%" />


<!-- attr: { class:'slide-section demo', showInPresentation:true } -->
<!-- # Relative Layout -->
[Demo]()


<!-- section start -->
<!-- attr: { id:'', class:'slide-section', showInPresentation:true, hasScriptWrapper:true } -->
<!-- # List View -->
<img class="slide-image" src="imgs/listview.png" style="left:30%" />

<!-- attr: { hasScriptWrapper:true } -->
# List View
- ListView is a view group that displays a list of scrollable items
- The list items are automatically inserted to the list using an `Adapter`
  - pulls content from a **source**
    - an array or database query
  - converts each item result into a **view** that's placed into the list


<!-- attr: { class:'slide-section demo', showInPresentation:true } -->
<!-- # List View -->
[Demo]()

<!-- section start -->
<!-- attr: { id:'', class:'slide-section', showInPresentation:true, hasScriptWrapper:true } -->
<!-- # Grid View -->
<img class="slide-image" src="imgs/gridview.png" style="left:30%" />

<!-- attr: { hasScriptWrapper:true, style:'font-size:0.9em' } -->
# Grid View
- `GridView` is a `ViewGroup` that displays items in a two-dimensional, scrollable grid
- The grid items are automatically inserted to the layout using a ListAdapter

```xml
<?xml version="1.0" encoding="utf-8"?>
<GridView xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/gridview"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:columnWidth="90dp"
    android:numColumns="auto_fit"
    android:verticalSpacing="10dp"
    android:horizontalSpacing="10dp"
    android:stretchMode="columnWidth"
    android:gravity="center"
/>
```
# Grid View

```java
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    GridView gridview = (GridView) findViewById(R.id.gridview);
    gridview.setAdapter(new ImageAdapter(this));

    gridview.setOnItemClickListener(new OnItemClickListener() {
        public void onItemClick(AdapterView<?> parent, View v,
                int position, long id) {
            Toast.makeText(HelloGridView.this, "" + position,
                    Toast.LENGTH_SHORT).show();
        }
    });
}
```

<!-- attr: { class:'slide-section demo', showInPresentation:true } -->
<!-- # Grid View -->
[Demo]()


<!-- attr: { id:'', class:'slide-section', hasScriptWrapper:true } -->
<!-- # DrawerLayout -->

<!-- # DrawerLayout -->
- `DrawerLayout` acts as a top-level container for window content that allows for interactive "drawer" views to be pulled out from the edge of the window
- Drawer positioning and layout is controlled using the `android:layout_gravity` attribute on child views


<!-- section start -->
<!-- attr: { id:'', class:'slide-section', showInPresentation:true } -->
<!-- # Building Layouts with an Adapter -->

# Building Layouts with an Adapter
- Use a layout that subclasses `AdapterView`, when the content for your layout is dynamic or not pre-determined
- Common layouts backed by an adapter include
  - `ListView`, `GridView`

```java
ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
        android.R.layout.simple_list_item_1, myStringArray);
```
- By default, `ArrayAdapter` creates a view for each array item by calling `toString() `on each item and placing the contents in a `TextView`


<!-- section start -->
<!-- attr: { id:'', class:'slide-section', showInPresentation:true } -->
<!-- # Handling click events -->

# Handling click events

```java
// Create a message handling object as an anonymous class.
private OnItemClickListener mMessageClickedHandler = new OnItemClickListener() {
    public void onItemClick(AdapterView parent, View v, int position, long id) {
        // Do something in response to the click
    }
};

listView.setOnItemClickListener(mMessageClickedHandler);
```


<!-- section start -->
<!-- attr: { id:'questions', class:'slide-section', showInPresentation:true } -->
# Questions
<!-- ## Android Applications -->
[link to TelerikAcademy Forum]()
