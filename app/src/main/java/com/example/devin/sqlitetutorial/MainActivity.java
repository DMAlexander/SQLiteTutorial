package com.example.devin.sqlitetutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText devinsInput;
    TextView devinsText;
    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        devinsInput = (EditText) findViewById(R.id.devinsInput);
        devinsText = (TextView) findViewById(R.id.devinsText);
        dbHandler = new MyDBHandler(this, null, null, 1);
        printDatabase();
    }
    //Add a product to the database
    public void addButtonClicked(View view){
        Products product = new Products(devinsInput.getText().toString());
        dbHandler.addProduct(product);
        printDatabase();
    }

    //Delete items
    public void deleteButtonClicked(View view){
        String inputText = devinsInput.getText().toString();
        dbHandler.deleteProduct(inputText);
        printDatabase();
    }

    public void printDatabase(){
        String dbString = dbHandler.databaseToString();
        devinsText.setText(dbString);
        devinsInput.setText("");
    }

}
