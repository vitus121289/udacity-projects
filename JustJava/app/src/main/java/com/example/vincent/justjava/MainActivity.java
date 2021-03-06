package com.example.vincent.justjava;

import android.content.Context;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    int numberOfCoffees = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffees);
    }

    /**
     * This method increases the number of coffees that the customer wants to order.
     * Also prohibits the customer to input a quantity more than 100.
     */
    public void addQuantity(View v) {
        if (numberOfCoffees < 100) {
            numberOfCoffees = numberOfCoffees + 1;
            displayQuantity(numberOfCoffees);
        } else {
            Context context = getApplicationContext();
            CharSequence warnOverQuantity = "You may not order more than 100 cups of coffee.";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, warnOverQuantity, duration);
            toast.show();
        }
    }

    /**
     * This method decreases the number of coffees that the customer wants to order.
     * Also prohibits the customer to input a quantity less than 1.
     */
    public void subtractQuantity(View v) {
        if (numberOfCoffees > 1) {
            numberOfCoffees = numberOfCoffees - 1;
            displayQuantity(numberOfCoffees);
        } else {
            Context context = getApplicationContext();
            CharSequence warnUnderQuantity = "You may not order less than 1 cup of coffee.";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, warnUnderQuantity, duration);
            toast.show();
        }
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

        int totalPrice = calculatePrice(addWhippedCream, addChocolate);
        String orderSummary = createSummary(totalPrice, addWhippedCream, addChocolate, customerName);
        displayOrderSummary(orderSummary);
    }

    /**
     * This method calculates the total price of the purchase.
     *
     * @param addWhippedCream a boolean variable that tells if the customer requested for whipped cream as a topping for their coffee.
     * @param addChocolate    a boolean variable that tells if the customer requested for chocolate as a topping for their coffee.
     * @return the total price of the purchase.
     */
    private int calculatePrice(boolean addWhippedCream, boolean addChocolate) {
        int pricePerCup = 5;
        int addToppings = 0;

        if (addWhippedCream) {
            addToppings = addToppings + 1;
        }

        if (addChocolate) {
            addToppings = addToppings + 2;
        }

        return numberOfCoffees * (pricePerCup + addToppings);
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
