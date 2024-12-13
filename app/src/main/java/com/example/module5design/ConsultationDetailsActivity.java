package com.example.module5design;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ConsultationDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_consultation_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.CLAgriIQ), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // 获取传递的 Consultation 对象
        Consultation consultation = (Consultation) getIntent().getSerializableExtra("consultation");
        if (consultation == null) {
            Toast.makeText(this, "Error loading consultation details.", Toast.LENGTH_SHORT).show();
            finish();
            return; // 提前返回，防止后续代码执行
        }

        // 初始化 TextView 并设置内容
        TextView tvExpertInfo = findViewById(R.id.tvExpertInfo);
        if (tvExpertInfo != null) {
            tvExpertInfo.setText("Expert: " + consultation.getExpertName() + "\nSpecialization: " + consultation.getTopicSummary());
        } else {
            Toast.makeText(this, "TextView not found!", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        // 删除按钮逻辑
        Button btnDelete = findViewById(R.id.btnDelete);
        if (btnDelete != null) {
            btnDelete.setOnClickListener(v -> {
                Toast.makeText(this, "Consultation deleted!", Toast.LENGTH_SHORT).show();
                finish();
            });
        }
    }
}