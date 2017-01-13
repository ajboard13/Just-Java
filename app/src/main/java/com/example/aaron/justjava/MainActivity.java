package com.example.aaron.justjava;

import android.icu.text.NumberFormat;
import android.icu.text.StringPrepParseException;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    private int quantity = 0;
    private int price = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void submitOrder(View view) {
        String priceMessage = "Total: $" + (this.quantity * this.price) + "\nThank You!";
        displayMessage(priceMessage);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    private void displayMessage(String message){
        TextView priceTextview = (TextView) findViewById(R.id.price_text_view);
        priceTextview.setText(message);
    }

    public void increment(View view){
        this.quantity +=1;
        display(this.quantity);
    }

    public void decrement(View view){
        this.quantity -=1;
        if(this.quantity < 0){
            this.quantity = 0;
        }
        display(this.quantity);
    }
}
