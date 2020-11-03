# RecyclerViewDynamic

* `activity_main.xml`
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    android:orientation="vertical">

    <androidx.recyclerview.widget.RecyclerView
        android:id="@+id/recyclerView"
        android:layout_weight="1" />

    <Button
        android:id="@+id/button"
        android:text="Add Item" />

    <Button
        android:id="@+id/getAllData"
        android:text="Get All Data" />

    <TextView
        android:id="@+id/textView"
        android:textAlignment="center"
        android:textSize="20sp" />
</LinearLayout>
```

* `item_rv.xml`
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical">

    <EditText
        android:id="@+id/editText"
        android:hint="Input Here" />
</LinearLayout>
```

* Make class `DynamicAdapter.java`
```java
public class DynamicAdapter extends RecyclerView.Adapter<DynamicAdapter.MyHolder> {

    public ArrayList<String> list;

    public DynamicAdapter(ArrayList<String> list) {
        this.list = list;
    }

    public void add() {
        list.add("");
        notifyItemInserted(list.size() - 1);
    }

    ...

    public static class MyHolder extends RecyclerView.ViewHolder {

        public EditText editText;

        ...
        
    }
}
```

* Make class `MainActivity.java`
```java
public class MainActivity extends AppCompatActivity {

    DynamicAdapter adapter;

    ...

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("M");
        arrayList.add("Fadli");
        arrayList.add("Zein");
        adapter = new DynamicAdapter(arrayList);

        adapter.add();

        recyclerView.setAdapter(adapter);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.add();
            }
        });

        getAllData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initGetDataPerIndex();
            }
        });
    }


    private void initGetDataPerIndex() {
        String str = "";

        int countItem = adapter.getItemCount();

        for (int i=0; i<countItem; i++){
            DynamicAdapter.MyHolder holder = (DynamicAdapter.MyHolder) recyclerView.findViewHolderForAdapterPosition(i);

            str = str + holder.editText.getText()+",";
        }

        textView.setText(str);
    }
    
    ...
    
}
```

Preview :
|<img src="https://github.com/gzeinnumer/RecyclerViewDynamic/blob/master/preview/example1.jpg" width="400"/>|<img src="https://github.com/gzeinnumer/RecyclerViewDynamic/blob/master/preview/example2.jpg" width="400"/>|<img src="https://github.com/gzeinnumer/RecyclerViewDynamic/blob/master/preview/example3.jpg" width="400"/>|
|---|---|---|

---

```
Copyright 2020 M. Fadli Zein
```