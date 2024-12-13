package com.example.module5design;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyConsultationActivity extends AppCompatActivity {
    private RecyclerView rvConsultations;
    private List<Consultation> consultationList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_my_consultation);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.CLAgriIQ), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        rvConsultations = findViewById(R.id.rvConsultations);

        // 加载假数据（以后可以替换为数据库读取）
        loadDummyData();

        // 设置RecyclerView
        ConsultationAdapter adapter = new ConsultationAdapter(consultationList, this::onConsultationClicked);
        rvConsultations.setLayoutManager(new LinearLayoutManager(this));
        rvConsultations.setAdapter(adapter);
    }
    private void loadDummyData() {
        consultationList.add(new Consultation("John Doe", "2024-12-03", "Soil Management", "Completed"));
        consultationList.add(new Consultation("Jane Smith", "2024-12-05", "Pest Control", "Pending Follow-Up"));
    }

    private void onConsultationClicked(Consultation consultation) {
        Intent intent = new Intent(this, ConsultationDetailsActivity.class);
        intent.putExtra("consultation", consultation);
        startActivity(intent);
    }
}