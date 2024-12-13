package com.example.module5design;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AgriLabActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_agri_lab);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.AgriLabMainPage), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        TextView tvGreeting = findViewById(R.id.TV2Greeting); // 假设这是你的 TextView ID
        String greetingMessage = TimeUtils.getGreetingMessage();
        tvGreeting.setText(greetingMessage);
        setupButtonLogic(R.id.BtnBeginner, "Beginner");
        setupButtonLogic(R.id.BtnIntermediate, "Intermediate");
        setupButtonLogic(R.id.BtnAdvanced, "Advanced");
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                finish(); // 返回到上一页
            }
        });
    }
    private void setupButtonLogic(int buttonId, String difficulty) {
        findViewById(buttonId).setOnClickListener(v -> {
            Intent intent = new Intent(AgriLabActivity.this, CourseListActivity.class);
            intent.putExtra("difficulty", difficulty);
            startActivity(intent);
        });
    }
}