package com.example.vincent.justjava;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    int numberOfCoffees = 0;

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
     * Also checks if the either or both boxes are ticked.
     * Also gets the customer's name.
     */
    public void placeOrder(View v) {

        //Gets the name from the customer name text field and stores it in variable.
        EditText customerNameEditText = (EditText) findViewById(R.id.customer_name_edit_text);
        String customerName = customerNameEditText.getText().toString();

        //Gets the status of the whipped cream checkbox if it has been ticked or not.
        CheckBox hasWhippedCream = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean addWhippedCream = hasWhippedCream.isChecked();
        //Gets the status of the chocolate checkbox if it has been ticked or not
        CheckBox hasChocolate = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean addChocolate = hasChocolate.isChecked();

        int totalPrice = calculatePrice();
        String orderSummary = createSummary(totalPrice, addWhippedCream, addChocolate, customerName);
        displayOrderSummary(orderSummary);
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
     * @param price           total price of the purchase.
     * @param addWhippedCream a boolean parameter that tells if the customer wants whipped cream or not on their coffee.
     * @param addChocolate    a boolean parameter that tells if the customer wants chocolate or not on their coffee.
     * @param customerName    name of the customer.
     * @return a string that contains the order summary.
     */
    private String createSummary(int price, boolean addWhippedCream, boolean addChocolate, String customerName) {
        String orderSummary = "Name: " + customerName + "\nAdd whipped cream? " + addWhippedCream + "\nAdd chocolate? " + addChocolate +
                "\nQuantity: " + numberOfCoffees + "\nPrice: $" + price + "\nThank you!";
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
