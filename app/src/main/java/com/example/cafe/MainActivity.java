package com.example.cafe;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {

    // Attributs

    private Button addCoffeeButton, removeCoffeeButton, orderButton;
    private TextView quantityTextView, priceTextView;
    private Spinner spinnerOrders;

    private CoffeeOrder coffeeOrder;
    private ArrayList<CoffeeOrder> coffeeOrders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        addCoffeeButton = findViewById(R.id.button_plus);
        removeCoffeeButton = findViewById(R.id.button_minus);
        orderButton = findViewById(R.id.button_commander);

        quantityTextView = findViewById(R.id.text_view_quantity);
        priceTextView = findViewById(R.id.text_view_result);
        spinnerOrders = findViewById(R.id.spinner_orders);
        coffeeOrder = new CoffeeOrder(10); // Prix du café
        coffeeOrders = new ArrayList<>();

        ArrayList<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, coffeeOrders);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOrders.setAdapter(adapter);




        addCoffeeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                coffeeOrder.addCoffee();
                quantityTextView.setText(String.valueOf(coffeeOrder.getQuantity()));
                double totalPrice = coffeeOrder.CalculOrderAmount();
                priceTextView.setText(String.valueOf(totalPrice));
            }
        });
        removeCoffeeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                coffeeOrder.RemoveCoffee();
                quantityTextView.setText(String.valueOf(coffeeOrder.getQuantity()));
                double totalPrice = coffeeOrder.CalculOrderAmount();
                priceTextView.setText(String.valueOf(totalPrice));
            }
        });
        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double totalPrice = coffeeOrder.CalculOrderAmount();
                String message = "Paiement Accepté";
                priceTextView.setText(message);
            }
        });




    }
}