package com.example.g7190305.simpletodolist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class EditItemActivity extends ActionBarActivity {
    Integer itemPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        String itemText = getIntent().getStringExtra(ToDoActivity.ITEM_MESSAGE);
        itemPosition = getIntent().getIntExtra(ToDoActivity.ITEM_POS, 1);
        EditText editText = (EditText) findViewById(R.id.edit_item_text);
        editText.setText(itemText);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void saveToItem(View v ) {
        EditText editText = (EditText) findViewById(R.id.edit_item_text);
        Intent data = new Intent();
        data.putExtra(ToDoActivity.ITEM_MESSAGE, editText.getText().toString() );
        data.putExtra(ToDoActivity.ITEM_POS, itemPosition );
        setResult(RESULT_OK, data);
        finish();
    }
}
