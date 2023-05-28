package com.example.tracnghiemv1;

import static com.example.tracnghiemv1.ScreenSlide.ARR_QUEST;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class TestDoneActivity extends AppCompatActivity {

    ArrayList<Question> arr_Ques = new ArrayList<Question>();
    ScoreController scoreController;
    TextView txtDung,txtSai,txtChuaTraLoi,txtTongDiem;
    Button btnChoiLai,btnThoat,btnLuuDiem;

    int dung=0,sai=0,chuatraloi=0,tongdiem=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_done);

        scoreController = new ScoreController(TestDoneActivity.this);
        AnhXa();


        Intent intent = getIntent();
        arr_Ques = (ArrayList<Question>) intent.getExtras().getSerializable(ARR_QUEST);

        CheckCauTraLoi();
        tongdiem = dung;

        txtDung.setText(""+dung);
        txtSai.setText(""+sai);
        txtChuaTraLoi.setText(""+chuatraloi);
        txtTongDiem.setText(""+tongdiem);

        btnChoiLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(TestDoneActivity.this);
                builder.setIcon(R.drawable.exit);
                builder.setMessage("Bạn cố muốn thoát");
                builder.setTitle("Thoát");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                builder.show();
            }
        });
        btnLuuDiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(TestDoneActivity.this);
                LayoutInflater inflater = TestDoneActivity.this.getLayoutInflater();
                View v = inflater.inflate(R.layout.alert_custom_dialog,null);
                builder.setView(v);


                final EditText edtName = (EditText) v.findViewById(R.id.edtName);
                final EditText edtRoom = (EditText) v.findViewById(R.id.edtRoom);
                TextView txtScore = (TextView) v.findViewById(R.id.txtScore);
                final int numTotal = dung;
                txtScore.setText(numTotal+" Điểm");

                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String name = edtName.getText().toString();
                        String room = edtRoom.getText().toString();
                        scoreController.InsertScore(name,numTotal,room);

                        Toast.makeText(TestDoneActivity.this,"Lưu Thành Công",Toast.LENGTH_LONG).show();
                        finish();
                        dialogInterface.dismiss();

                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                AlertDialog b = builder.create();
                b.show();
            }
        });
    }
    void CheckCauTraLoi(){
        ArrayListIterator arr_Ques1 = new ArrayListIterator(arr_Ques);
        while(arr_Ques1.hasNext()){
            if (arr_Ques1.items.get(arr_Ques1.position).getAnsert().equals(""))
                chuatraloi++;
            else if(arr_Ques1.items.get(arr_Ques1.position).getResult().equals(arr_Ques1.items.get(arr_Ques1.position).getAnsert()))
                dung++;
            else sai++;
            arr_Ques1.next();
        }
    }

    void AnhXa(){
        txtDung = (TextView) findViewById(R.id.txtCauDung);
        txtSai = (TextView) findViewById(R.id.txtCauSai);
        txtChuaTraLoi = (TextView) findViewById(R.id.txtCauChuaTraLoi);
        txtTongDiem = (TextView) findViewById(R.id.txtTongDiem);

        btnChoiLai = (Button) findViewById(R.id.btnChoiLai);
        btnThoat = (Button) findViewById(R.id.btnThoat);
        btnLuuDiem = (Button) findViewById(R.id.btnLuuDiem);
    }

}
