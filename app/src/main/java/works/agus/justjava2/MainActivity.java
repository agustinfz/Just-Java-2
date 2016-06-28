package works.agus.justjava2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder (View view){
        String priceMessage ="";
        int price = 5*quantity;
        if (quantity == 0) {
            priceMessage = "Free sucka!";
            displayMessage(priceMessage);
        }

        else
            priceMessage = "You owe $" + price + ", please \n Thank you!";
            displayMessage(priceMessage);

        //int price = 5;
        //display(quantity);
        //displayPrice(quantity * price);
    }

    /**
     * This method is called when the + button is clicked
     * @param view
     */

    public void increment (View view){
        quantity++;
        display (quantity);
    }


    /**
     * This method is called when the - button is clicked
     * @param view
     */
    public void decrement(View view){
        if (quantity > 0){
            quantity--;
            display (quantity);
        }
        else
        display (quantity);
    }

    /**
     * This method sets the given quantity value on the screen
     * @param number
     */
    private void display (int number){
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the price of the order using the correct currency symbol and format
     * @param number
     */

    private void displayPrice (int number){
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));

    }

    private void displayMessage (String message){
        TextView priceTextView  = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }
}
