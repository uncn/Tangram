# Tangram
Tangram

### Gradle

To get a Git project into your build:

**Step 1**. Add the JitPack repository to your build file

```groovy
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

**Step 2**. Add the dependency

```groovy
dependencies {
    implementation 'com.github.ShortStickBoy:Tangram:5.2.1'
}
```

### Use

**Step 1**. Add the TangramView to your layout file

```xml
<com.sunzn.tangram.library.view.TangramView
    android:id="@+id/tangram"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    app:FooterDone="@layout/state_view_done"
    app:FooterFail="@layout/state_view_fail"
    app:FooterLoad="@layout/state_view_load" />
```

**Step 2**. Bind the view id to the entity class with @LayoutAnnotation

```java
@LayoutAnnotation(R.layout.item)
public class Item extends TangramBean {

    private String name;
    private String pass;

}
```

**Step 3**. Create ItemViewHolder, set OnClickListener and bind the view

```java
public class ItemViewHolder extends TangramViewHolder<Item, RecyclerAdapter> {

    private final String TAG = "ItemViewHolder";

    public ItemViewHolder(final View itemView, RecyclerAdapter adapter) {
        super(itemView, adapter);
        TextView view = getView(R.id.item_tv);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "item:" + getAdapterPosition());
            }
        });
    }

    @Override
    public void onBindViewHolder(Item model, int position, RecyclerAdapter adapter) {
        TextView view = getView(R.id.item_tv);
        view.setText("item" + position);
    }

}
```