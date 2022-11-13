package mx.uv.sbc.fbfirestoredemo;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class CourseDetails extends AppCompatActivity {

    private RecyclerView courseRV;
    private ArrayList<Courses> coursesArrayList;
    private CourseRVAdapter courseRVAdapter;
    private FirebaseFirestore db;
    ProgressBar loadingPB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_details);

        courseRV = findViewById(R.id.idRVCourses);
        loadingPB = findViewById(R.id.idProgressBar);

        db = FirebaseFirestore.getInstance();

        coursesArrayList = new ArrayList<>();
        courseRV.setHasFixedSize(true);
        courseRV.setLayoutManager(new LinearLayoutManager(this));

        courseRVAdapter = new CourseRVAdapter(coursesArrayList, this);

        courseRV.setAdapter(courseRVAdapter);

        db.collection("Courses").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        if (!queryDocumentSnapshots.isEmpty()) {
                            loadingPB.setVisibility(View.GONE);
                            List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                            for (DocumentSnapshot d : list) {
                                Courses c = d.toObject(Courses.class);
                                coursesArrayList.add(c);
                            }

                            courseRVAdapter.notifyDataSetChanged();
                        } else {
                            Toast.makeText(CourseDetails.this, "No data found in Database", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(CourseDetails.this, "Fail to get the data.", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
