package com.example.cafe;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // Attributs

    private Button addCoffeeButton, removeCoffeeButton, orderButton;
    private TextView quantityTextView, priceTextView;

    private CoffeeOrder coffeeOrder;

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

        coffeeOrder = new CoffeeOrder(10); // Prix du café

        addCoffeeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                coffeeOrder.addCoffee();
                quantityTextView.setText(String.valueOf(coffeeOrder.getQuantity()));
            }
        });
        removeCoffeeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                coffeeOrder.RemoveCoffee();
                quantityTextView.setText(String.valueOf(coffeeOrder.getQuantity()));
            }
        });
        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double totalPrice = coffeeOrder.CalculOrderAmount();
                priceTextView.setText(String.valueOf(totalPrice));
            }
        });
    }
}