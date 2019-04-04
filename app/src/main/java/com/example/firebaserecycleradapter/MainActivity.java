package com.example.firebaserecycleradapter;

import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.firebaserecycleradapter.Class.Details;
import com.example.firebaserecycleradapter.Holder.ViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    DatabaseReference databaseReference;

    FirebaseRecyclerOptions<Details> firebaseRecyclerOptions;
    FirebaseRecyclerAdapter<Details , ViewHolder> firebaseRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Information of Posts");


        databaseReference = FirebaseDatabase.getInstance().getReference("Data");


        firebaseRecyclerOptions = new FirebaseRecyclerOptions.Builder<Details>().
                                                     setQuery(databaseReference ,Details.class).build();


        firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Details, ViewHolder>(firebaseRecyclerOptions) {
            @Override
            protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull Details model) {

                Picasso.get().load(model.getPost()).into(holder.imageView_row, new Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError(Exception e) {

                        Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();

                    }
                });

                holder.textView_name.setText(model.getName());
                holder.textView_lastname.setText(model.getLastName());
//                holder.textView_age.setText(model.getAge());


            }

            @NonNull
            @Override
            public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {


                View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_view,viewGroup,false);

                return new ViewHolder(view);
            }
        };


        recyclerView.setAdapter(firebaseRecyclerAdapter);

    }

    @Override
    protected void onStart() {
        super.onStart();

        if(firebaseRecyclerAdapter!=null){
            firebaseRecyclerAdapter.startListening();

        }
    }


    @Override
    protected void onStop() {
        super.onStop();
        if(firebaseRecyclerAdapter!=null){
            firebaseRecyclerAdapter.stopListening();

        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        if(firebaseRecyclerAdapter!=null){
            firebaseRecyclerAdapter.startListening();

        }
    }
}
