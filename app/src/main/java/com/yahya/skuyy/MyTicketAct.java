package com.yahya.skuyy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.yahya.skuyy.TicketCheckout;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MyTicketAct extends AppCompatActivity {

    DatabaseReference reference,refence2;
    TextView xnamawisata, xlokasi, xdate_wisata, xtime_wisata, xketentuan;
    Button btn_back;
    EditText date_wisata;

    String username_key_new ="";
    Integer nomor_transaksi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_ticket);

        xnamawisata= findViewById(R.id.xnama_wisata);
        xlokasi= findViewById(R.id.xlokasi);
        xdate_wisata= findViewById(R.id.xdate_wisata);
        xtime_wisata= findViewById(R.id.xtime_wisata);
        xketentuan= findViewById(R.id.xketentuan);
        btn_back= findViewById(R.id.btn_back);
//        date_wisata =(EditText) findViewById(R.id.date_wisata);


        Bundle bundle = getIntent().getExtras();
        final String nama_wisata_baru = bundle.getString("nama_wisata");


        reference = FirebaseDatabase.getInstance().getReference().child("Wisata").child(nama_wisata_baru);
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                xnamawisata.setText(dataSnapshot.child("nama_wisata").getValue().toString());
                xlokasi.setText(dataSnapshot.child("lokasi").getValue().toString());
                xdate_wisata.setText(dataSnapshot.child("date_wisata").getValue().toString());
                xtime_wisata.setText(dataSnapshot.child("time_wisata").getValue().toString());
                xketentuan.setText(dataSnapshot.child("ketentuan").getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


//        reference = FirebaseDatabase.getInstance().getReference().child("MyTicket").child(username_key_new).child();
//        reference.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                xdate_wisata.setText(dataSnapshot.child("date_wisata").getValue().toString());
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });

//        xdate_wisata.setText(date_wisata.getText());


        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backtohome = new Intent(MyTicketAct.this, Beranda.class);
                startActivity(backtohome);
            }
        });
    }

}
