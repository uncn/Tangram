# Tangram

[![](https://jitpack.io/v/ShortStickBoy/Tangram.svg)](https://jitpack.io/#ShortStickBoy/Tangram)
[![](https://img.shields.io/badge/License-Apache%202.0-orange.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)

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
    implementation 'com.github.ShortStickBoy:Tangram:5.2.2'
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

**Step 4**. Create RecyclerAdapter, create custom ViewHolder and set view's SpanCount

```java
public class RecyclerAdapter extends TangramAdapter implements GridSpanSizeListener {

    public RecyclerAdapter() {
        super();
        setSpanSizeListener(this);
    }

    public RecyclerAdapter(List<TangramBean> beans) {
        super(beans);
        setSpanSizeListener(this);
    }

    @Override
    public TangramViewHolder onCreateViewHolder(int viewType, View itemView) {
        switch (viewType) {
            case R.layout.item_head:
                return new HeadViewHolder(itemView, this);
            case R.layout.item:
                return new ItemViewHolder(itemView, this);
            case R.layout.foot:
                return new FootViewHolder(itemView, this);
            case R.layout.done:
                return new DoneViewHolder(itemView, this);
            case R.layout.line:
                return new LineViewHolder(itemView, this);
        }
        return null;
    }

    @Override
    public int onGetSpanCount(int viewType, GridLayoutManager manager) {
        switch (viewType) {
            case R.layout.item_head:
                return manager.getSpanCount();
            case R.layout.item:
                return manager.getSpanCount();
            case R.layout.foot:
                return 3;
            case R.layout.done:
                return 2;
            case R.layout.line:
                return manager.getSpanCount();
        }
        return manager.getSpanCount();
    }

}
```

**Step 5**. Use in activity

```java
TangramView tangram = findViewById(R.id.tangram);
ArrayList<TangramBean> beans = new ArrayList<>();

for (int i = 0; i < 1; i++) {
    beans.add(new Item());
}
for (int i = 0; i < 9; i++) {
    beans.add(new Done());
}
for (int i = 0; i < 1; i++) {
    beans.add(new Item());
}
for (int i = 0; i < 9; i++) {
    beans.add(new Done());
}

tangram.setLayoutManager(new GridLayoutManager(this, 6));
adapter = new RecyclerAdapter();
adapter.setData(beans);
tangram.setCompatAdapter(adapter);
```

### Attribute

| Attribute  | Describe               | Additional                                                 |
| ---------- | ---------------------- | ---------------------------------------------------------- |
| FooterLoad | Footer status for load | If you setLoadMoreListener, this value must never be null. |
| FooterFail | Footer status for fail | If you setLoadMoreListener, this value must never be null. |
| FooterDone | Footer status for done | If you setLoadMoreListener, this value must never be null. |

### License
```
Copyright [2016-2019] sunzn

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