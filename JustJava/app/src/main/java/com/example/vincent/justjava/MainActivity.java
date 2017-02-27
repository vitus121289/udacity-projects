package com.example.vincent.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

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
     * This method takes the order of the customer.
     */
    public void placeOrder(View v) {
        int totalPrice = 0;
        totalPrice = calculatePrice();
        displayOrderSummary(totalPrice);
    }

    /**
     * This method calculates the total price of the purchase.
     *
     * @return the total price of the purchase.
     */
    private int calculatePrice() {
        int pricePerCup = 5;
        return quantity * pricePerCup;
    }

    /**
     * This method displays the number of coffees the customer going to order.
     *
     * @param quantity is the number of coffees the customer is going to order.
     */
    private void displayQuantity(int quantity) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + quantity);
    }

    /**
     * This method displays the summary of the customer's order.
     *
     * @param price total price calculated by the method calculatePrice().
     */
    private void displayOrderSummary(int price) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText("$" + price);
    }
}
