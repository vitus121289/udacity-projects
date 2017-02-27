package com.example.vincent.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method increases the number of coffees that the customer wants to order.
     */
    public void addQuantity(View v) {
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    /**
     * This method decreases the number of coffees that the customer wants to order.
     */
    public void subtractQuantity(View v) {
        quantity = quantity - 1;
        displayQuantity(quantity);
    }

    /**
     * This method displays the number of coffees the customer going to order.
     * @param quantity is the number of coffees the customer is going to order.
     */
    private void displayQuantity(int quantity) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + quantity);
    }
}
