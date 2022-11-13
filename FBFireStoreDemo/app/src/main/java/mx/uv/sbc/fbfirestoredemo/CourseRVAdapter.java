package mx.uv.sbc.fbfirestoredemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CourseRVAdapter extends RecyclerView.Adapter<CourseRVAdapter.ViewHolder> {
    private ArrayList<Courses> coursesArrayList;
    private Context context;

    public CourseRVAdapter(ArrayList<Courses> coursesArrayList, Context context) {
        this.coursesArrayList = coursesArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public CourseRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.course_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CourseRVAdapter.ViewHolder holder, int position) {
        Courses courses = coursesArrayList.get(position);
        holder.courseNameTV.setText(courses.getCourseName());
        holder.courseDurationTV.setText(courses.getCourseDuration());
        holder.courseDescTV.setText(courses.getCourseDescription());
    }

    @Override
    public int getItemCount() {
        return coursesArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView courseNameTV;
        private final TextView courseDurationTV;
        private final TextView courseDescTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            courseNameTV = itemView.findViewById(R.id.idTVCourseName);
            courseDurationTV = itemView.findViewById(R.id.idTVCourseDuration);
            courseDescTV = itemView.findViewById(R.id.idTVCourseDescription);
        }
    }
}
