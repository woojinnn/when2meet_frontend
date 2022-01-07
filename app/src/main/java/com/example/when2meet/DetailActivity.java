package com.example.when2meet;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class DetailActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{

    TextView text1 = null, text2 = null, text3 = null, text4 = null, text5 = null;
    Button button1, button3;
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Context context;
        text1 = findViewById(R.id.textView_date1);
        text2 = findViewById(R.id.textView_date2);
        text3 = findViewById(R.id.textView_date3);
        text4 = findViewById(R.id.textView_date4);
        text5 = findViewById(R.id.textView_date5);
        button1 = findViewById(R.id.button1);
        button3 = findViewById(R.id.button3);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailActivity.this, TimeActivity.class);
                startActivity(intent);
            }
        });

        text1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(DetailActivity.this);

                dialog.setMessage("정말로 삭제하시겠습니까?");
                dialog.setCancelable(true);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        DeleteText(1);
                    }
                });

                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                dialog.show();
                return false;
            }
        });
        text2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(DetailActivity.this);

                dialog.setMessage("정말로 삭제하시겠습니까?");
                dialog.setCancelable(true);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        DeleteText(2);
                    }
                });

                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                dialog.show();
                return false;
            }
        });
        text3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(DetailActivity.this);

                dialog.setMessage("정말로 삭제하시겠습니까?");
                dialog.setCancelable(true);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        DeleteText(3);
                    }
                });

                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                dialog.show();
                return false;
            }
        });
        text4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(DetailActivity.this);

                dialog.setMessage("정말로 삭제하시겠습니까?");
                dialog.setCancelable(true);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        DeleteText(4);
                    }
                });

                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                dialog.show();
                return false;
            }
        });
        text5.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(DetailActivity.this);

                dialog.setMessage("정말로 삭제하시겠습니까?");
                dialog.setCancelable(true);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        DeleteText(5);
                    }
                });

                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                dialog.show();
                return false;
            }
        });
    }
    public void DeleteText(int row){
        int n;
        DeleteDate(row);
        i--;
        for(n=row; n<5; n++)
        {
            if(n==1) {
                text1.setText(text2.getText().toString());
            }else if(n==2) {
                text2.setText(text3.getText().toString());
            }else if(n==3) {
                text3.setText(text4.getText().toString());
            }else if(n==4) {
                text4.setText(text5.getText().toString());
            }
        }
        if(i!=5){
            button1.setVisibility(View.VISIBLE);
        }
        DeleteDate(5);
    }
    public void DeleteDate(int daterow) {
        if(daterow==1) {
            text1.setText(null);
        }else if(daterow==2) {
            text2.setText(null);
        }else if(daterow==3) {
            text3.setText(null);
        }else if(daterow==4) {
            text4.setText(null);
        }else if(daterow==5) {
            text5.setText(null);
        }
    }
    public void showDatePickerDialog(){
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        Calendar c = Calendar.getInstance();
        datePickerDialog.getDatePicker().setMinDate(c.getTimeInMillis());
        datePickerDialog.show();
    }

    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        month++;
        i++;
        String date = year + "/" + month + "/" + dayOfMonth;
        if(i==1) {
            if(!checkValid(date)){
                date = null;
                i--;
                Toast.makeText(DetailActivity.this, "중복인 날짜가 있어요.", Toast.LENGTH_SHORT).show();
                System.out.println("no1!!!");
            }
            text1.setText(date);
        }else if(i==2) {
            if(!checkValid(date)){
                date = null;
                i--;
                Toast.makeText(DetailActivity.this, "중복인 날짜가 있어요.", Toast.LENGTH_SHORT).show();
                System.out.println("no2!!!");
            }
            text2.setText(date);
        }else if(i==3) {
            if(!checkValid(date)){
                date = null;
                i--;
                Toast.makeText(DetailActivity.this, "중복인 날짜가 있어요.", Toast.LENGTH_SHORT).show();
                System.out.println("no3!!!");
            }
            text3.setText(date);
        }else if(i==4) {
            if(!checkValid(date)){
                date = null;
                i--;
                Toast.makeText(DetailActivity.this, "중복인 날짜가 있어요.", Toast.LENGTH_SHORT).show();
                System.out.println("no4!!!");
            }
            text4.setText(date);
        }else if(i==5) {
            if(!checkValid(date)){
                date = null;
                i--;
                Toast.makeText(DetailActivity.this, "중복인 날짜가 있어요.", Toast.LENGTH_SHORT).show();
                System.out.println("no5!!!");
            }
            text5.setText(date);
            if(i==5) {
                button1.setVisibility(View.GONE);
            }
        }else{
            //nothing yet
        }
    }
    public boolean checkValid(String dateinput) {
        for(int k=1; k<i; k++){
            if(k==1) {
                if(dateinput.equals(text1.getText().toString())){
                    return false;
                }
            }else if(k==2) {
                if(dateinput.equals(text2.getText().toString())){
                    return false;
                }
            }else if(k==3) {
                if(dateinput.equals(text3.getText().toString())){
                    return false;
                }
            }else if(k==4) {
                if(dateinput.equals(text4.getText().toString())){
                    return false;
                }
            }else if(k==5) {
                if(dateinput.equals(text5.getText().toString())){
                    return false;
                }
            }
        }
        return true;
    }
}