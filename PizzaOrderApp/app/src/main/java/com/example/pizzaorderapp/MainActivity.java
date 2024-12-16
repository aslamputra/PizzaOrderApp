package com.example.pizzaorderapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int quantityCheesePizza = 0;
    private int quantityPepperoniPizza = 0;
    private int quantityVeggiePizza = 0;

    private final int priceCheesePizza = 50000;
    private final int pricePepperoniPizza = 60000;
    private final int priceVeggiePizza = 45000;

    private TextView textViewQuantityCheesePizza;
    private TextView textViewQuantityPepperoniPizza;
    private TextView textViewQuantityVeggiePizza;
    private TextView textViewTotalPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewQuantityCheesePizza = findViewById(R.id.textViewQuantityCheesePizza);
        textViewQuantityPepperoniPizza = findViewById(R.id.textViewQuantityPepperoniPizza);
        textViewQuantityVeggiePizza = findViewById(R.id.textViewQuantityVeggiePizza);
        textViewTotalPrice = findViewById(R.id.textViewTotalPrice);

        textViewQuantityCheesePizza = findViewById(R.id.textViewQuantityCheesePizza);
        Button buttonMinusCheesePizza = findViewById(R.id.buttonMinusCheesePizza);
        Button buttonPlusCheesePizza = findViewById(R.id.buttonPlusCheesePizza);

        buttonMinusCheesePizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quantityCheesePizza > 0) {
                    quantityCheesePizza--;
                    textViewQuantityCheesePizza.setText(String.valueOf(quantityCheesePizza));
                }
            }
        });

        buttonPlusCheesePizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantityCheesePizza++;
                textViewQuantityCheesePizza.setText(String.valueOf(quantityCheesePizza));
            }
        });

        // Tambahkan logika yang sama untuk Pepperoni Pizza dan Veggie Pizza
        textViewQuantityPepperoniPizza = findViewById(R.id.textViewQuantityPepperoniPizza);
        Button buttonMinusPepperoniPizza = findViewById(R.id.buttonMinusPepperoniPizza);
        Button buttonPlusPepperoniPizza = findViewById(R.id.buttonPlusPepperoniPizza);

        buttonMinusPepperoniPizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quantityPepperoniPizza > 0) {
                    quantityPepperoniPizza--;
                    textViewQuantityPepperoniPizza.setText(String.valueOf(quantityPepperoniPizza));
                }
            }
        });

        buttonPlusPepperoniPizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantityPepperoniPizza++;
                textViewQuantityPepperoniPizza.setText(String.valueOf(quantityPepperoniPizza));
            }
        });

        textViewQuantityVeggiePizza = findViewById(R.id.textViewQuantityVeggiePizza);
        Button buttonMinusVeggiePizza = findViewById(R.id.buttonMinusVeggiePizza);
        Button buttonPlusVeggiePizza = findViewById(R.id.buttonPlusVeggiePizza);

        buttonMinusVeggiePizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quantityVeggiePizza > 0) {
                    quantityVeggiePizza--;
                    textViewQuantityVeggiePizza.setText(String.valueOf(quantityVeggiePizza));
                }
            }
        });
        
        buttonPlusVeggiePizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantityVeggiePizza++;
                textViewQuantityVeggiePizza.setText(String.valueOf(quantityVeggiePizza));
            }
        });

        Button buttonSubmit = findViewById(R.id.buttonSubmit);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int total = calculateTotal();
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("totalPrice", total);
                intent.putExtra("quantityCheesePizza", quantityCheesePizza);
                intent.putExtra("quantityPepperoniPizza", quantityPepperoniPizza);
                intent.putExtra("quantityVeggiePizza", quantityVeggiePizza);
                startActivity(intent);
            }
        });
    }

    private int calculateTotal() {
        int total = (quantityCheesePizza * priceCheesePizza) +
                (quantityPepperoniPizza * pricePepperoniPizza) +
                (quantityVeggiePizza * priceVeggiePizza);

        textViewTotalPrice.setText("Total: Rp " + total);
        return total;
    }
}