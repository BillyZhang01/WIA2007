package com.example.module5design;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ExpertDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_expert_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.CLAgriIQ), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // 获取传递的数据
        String name = getIntent().getStringExtra("expertName");
        String specialization = getIntent().getStringExtra("expertSpecialization");
        double rating = getIntent().getDoubleExtra("expertRating", 0.0);
        int avatarResId = getIntent().getIntExtra("avatarResId", 0);

        // 设置数据到界面
        ImageView ivAvatar = findViewById(R.id.ivAvatar);
        TextView tvName = findViewById(R.id.tvName);
        TextView tvSpecialization = findViewById(R.id.tvSpecialization);
        RatingBar ratingBar = findViewById(R.id.ratingBar);

        ivAvatar.setImageResource(avatarResId);
        tvName.setText("Name: " + name);
        tvSpecialization.setText("Specialization: " + specialization);
        ratingBar.setRating((float) rating);
        Button btnBook = findViewById(R.id.BtnBook);
        btnBook.setOnClickListener(v -> {
            Intent intent = new Intent(ExpertDetailActivity.this, ScheduleAppointmentActivity.class);
            startActivity(intent);
        });
    }
}