package com.newdawn.commons;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    MyRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new MyRecyclerViewAdapter(this);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.recycler_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.add_item){

            final AlertDialog dialog = new AlertDialog.Builder(this).setView(R.layout.dialog_view)
                                                                      .setTitle("Add Item")
                                                                      .setPositiveButton("ADD",null)
                                                                      .setNegativeButton("CANCEL",null)
                                                                      .show();
            dialog.show();
            dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    EditText todoItemName = dialog.findViewById(R.id.todo_item_name);
                    String todoItemNameString = todoItemName.getText().toString();
                    if (!todoItemNameString.isEmpty()){
                    adapter.addItem(todoItemNameString);
                    dialog.dismiss();
                    }else {
                        todoItemName.setError("Please input text");
                    }
                }
            });

            dialog.getButton(AlertDialog.BUTTON_NEGATIVE).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });
        }

        return super.onOptionsItemSelected(item);
    }
}
