package com.test.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
public class RegisterActivity extends AppCompatActivity {

    private EditText editTextTitle, editTextPost;
    private Button buttonPost;
    private DatabaseReference databasePosts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editTextTitle = findViewById(R.id.editTextTitle);
        editTextPost = findViewById(R.id.editTextPost);
        buttonPost = findViewById(R.id.buttonPost);

        databasePosts = FirebaseDatabase.getInstance().getReference("posts");

        buttonPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = editTextTitle.getText().toString().trim();
                String postContent = editTextPost.getText().toString().trim();

                if (!title.isEmpty() && !postContent.isEmpty()) {
                    String postId = databasePosts.push().getKey();
                    Post post = new Post(title, postContent);
                    if (postId != null) {
                        databasePosts.child(postId).setValue(post);
                        Toast.makeText(RegisterActivity.this, "게시글이 게시되었습니다.", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                } else {
                    Toast.makeText(RegisterActivity.this, "제목과 내용을 입력해주세요", Toast.LENGTH_SHORT).show();
                }
            }
        });

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new Fragment2())
                .commit();
    }
}