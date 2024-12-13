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

public class CourseListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_course_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.CourseListPage), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        String difficulty=getIntent().getStringExtra("difficulty");
        List<Course> courses=getCoursesByDifficulty(difficulty);
        RecyclerView recyclerView = findViewById(R.id.rvCourses);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        CourseAdapter adapter = new CourseAdapter(courses, this::onCourseClicked);
        recyclerView.setAdapter(adapter);
    }
    private List<Course> getCoursesByDifficulty(String difficulty) {
        List<Course> courseList = new ArrayList<>();
        courseList.add(new Course("Introduction to Sustainable Farming", "Learn the basics of sustainable farming.", "android.resource://" + getPackageName() + "/" + R.raw.testvideo));
        courseList.add(new Course("Crop Rotation Techniques", "Discover the best practices for crop rotation.", "https://www.example.com/sample2.mp4"));
        return courseList;
    }

    // 点击课程时触发
    private void onCourseClicked(Course course) {
        Intent intent = new Intent(this, CourseDetailActivity.class);
        intent.putExtra("videoUrl", course.getUrl());
        startActivity(intent);
    }
}