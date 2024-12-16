package com.example.pizzaorderapp;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView textViewOrderDetails = findViewById(R.id.textViewOrderDetails);
        TextView textViewTotalPriceResult = findViewById(R.id.textViewTotalPriceResult);

        // Ambil data dari MainActivity
        int quantityCheesePizza = getIntent().getIntExtra("quantityCheesePizza", 0);
        int quantityPepperoniPizza = getIntent().getIntExtra("quantityPepperoniPizza", 0);
        int quantityVeggiePizza = getIntent().getIntExtra("quantityVeggiePizza", 0);
        int totalPrice = getIntent().getIntExtra("totalPrice", 0);

        // Ringkasan Pembelian
        StringBuilder orderDetails = new StringBuilder();
        orderDetails.append("Cheese Pizza: ").append(quantityCheesePizza).append("\n");
        orderDetails.append("Pepperoni Pizza: ").append(quantityPepperoniPizza).append("\n");
        orderDetails.append("Veggie Pizza: ").append(quantityVeggiePizza).append("\n");

        textViewOrderDetails.setText(orderDetails.toString());
        textViewTotalPriceResult.setText("Total Pembayaran: Rp " + totalPrice);
    }
}

