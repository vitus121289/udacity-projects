package com.example.vincent.justjava;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    int numberOfCoffees = 0;
    boolean hasWhippedCream = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method increases the number of coffees that the customer wants to order.
     */
    public void addQuantity(View v) {
        numberOfCoffees = numberOfCoffees + 1;
        displayQuantity(numberOfCoffees);
    }

    /**
     * This method decreases the number of coffees that the customer wants to order.
     */
    public void subtractQuantity(View v) {
        numberOfCoffees = numberOfCoffees - 1;
        displayQuantity(numberOfCoffees);
    }

    /**
     * This method takes the order of the customer.
     */
    public void placeOrder(View v) {
        int totalPrice = calculatePrice();
        String orderSummary = createSummary(totalPrice);
        displayOrderSummary(orderSummary);
    }

    /**
     * This method determines if the checkbox for the whipped cream is clicked or not.
     */
    public void onCheckboxClicked(View v) {
        hasWhippedCream = ((CheckBox) v).isChecked();
    }

    /**
     * This method calculates the total price of the purchase.
     *
     * @return the total price of the purchase.
     */
    private int calculatePrice() {
        int pricePerCup = 5;
        return numberOfCoffees * pricePerCup;
    }

    /**
     * This method creates the order summary of the customer.
     *
     * @param price total price of the purchase.
     * @return a string that contains the order summary.
     */
    private String createSummary(int price) {
        String orderSummary = "Name: Vincent\n" +"Quantity: " + numberOfCoffees + "\nAdd whipped cream? " + hasWhippedCream + "\nPrice: $" + price + "\nThank you!";
        return orderSummary;
    }

    /**
     * This method displays the number of coffees the customer going to order.
     *
     * @param numberOfCoffees is the number of coffees the customer is going to order.
     */
    private void displayQuantity(int numberOfCoffees) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffees);
    }

    /**
     * This method displays the summary of the customer's order.
     *
     * @param orderSummary is the summary of order created by the method createSummary().
     */
    private void displayOrderSummary(String orderSummary) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(orderSummary);
    }
}
