package com.example.superkomponenty2;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private CustomCircleView customCircleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customCircleView = findViewById(R.id.customCircleView);

        customCircleView.setRadius(150);
        customCircleView.setColor(Color.GREEN);

        customCircleView.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                // Zmiana koloru okręgu
                int currentColor = customCircleView.getColor();
                customCircleView.setColor(currentColor == Color.BLUE ? Color.RED : Color.BLUE);
                // Animacja przesunięcia okręgu do pozycji dotknięcia
                animateCircle(event.getX(), event.getY());
            }
            return true;
        });
    }

    // Metoda animująca okrąg do nowej pozycji
    private void animateCircle(float toCx, float toCy) {
        ObjectAnimator animatorX = ObjectAnimator.ofFloat(customCircleView, "cx", customCircleView.getCx(), toCx);
        ObjectAnimator animatorY = ObjectAnimator.ofFloat(customCircleView, "cy", customCircleView.getCy(), toCy);

        animatorX.setDuration(1000);
        animatorY.setDuration(1000);

        animatorX.start();
        animatorY.start();
    }
}
