package com.example.ki.myapplication;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ki on 17. 8. 8.
 */

public class dialog  extends AppCompatActivity {
    SimpleAdapter adapter;
    ListView listView;
    ArrayList<Member> list;
    ArrayList<HashMap<String,String>> maplist;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_views);
        Bundle bundle = getIntent().getExtras();
        String name =  bundle.getString("name");

        list = new ArrayList<Member>();
        list.add(new Member(name+"의 정보를 조회합니다",""));
        list.add(new Member("주소","홍대"));

        list.add(new Member("전번","010-0000"));

        list.add(new Member("주소2","기흥"));

        list.add(new Member("친구","잭슨"));

        maplist = new ArrayList<HashMap<String,String>>();
        for(Member m : list){

            HashMap  map  = new HashMap();

            //id와 name을 꺼내서 map타입으로 변경.

            map.put("id", m.id);

            map.put("name", m.name);

            maplist.add(map);

        }

        listView = (ListView)findViewById(R.id.lv);

        adapter =

                new SimpleAdapter(this,

                        //string값을 가져옴.

                        maplist,

                        android.R.layout.simple_list_item_2,

                        //자원

                        new String[]{"id","name"},

                        //view 1. 첫번째 view를 뿌려줌, 2. 두번째 view를 뿌려줌

                        new int[]{android.R.id.text1,android.R.id.text2});

        listView.setAdapter(adapter);

        /*플러스 메뉴*/
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab3);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "정보 추가하기", Snackbar.LENGTH_LONG)
                        .setAction("추가", new View.OnClickListener(){
                            @Override
                            public void onClick(View view) {
                                LayoutInflater inflater=getLayoutInflater();



                                //res폴더>>layout폴더>>dialog_addmember.xml 레이아웃 리소스 파일로 View 객체 생성

                                //Dialog의 listener에서 사용하기 위해 final로 참조변수 선언

                                final View dialogView= inflater.inflate(R.layout.dialog_addmember, null);



                                //멤버의 세부내역 입력 Dialog 생성 및 보이기

                                AlertDialog.Builder buider= new AlertDialog.Builder(view.getContext()); //AlertDialog.Builder 객체 생성

                                buider.setTitle("추가할 정보명"); //Dialog 제목

                                buider.setView(dialogView); //위에서 inflater가 만든 dialogView 객체 세팅 (Customize)
                                buider.setPositiveButton("완성", new DialogInterface.OnClickListener() {

                                    //Dialog에 "Complite"라는 타이틀의 버튼을 설정

                                    @Override

                                    public void onClick(DialogInterface dialog, int which) {

                                        // TODO Auto-generated method stub

                                        //멤버 정보의 입력을 완료하고 TextView에 추가 하도록 하는 작업 수행



                                        //dialogView 객체 안에서 NAME을 입력받는 EditText 객체 찾아오기(주의: dialaogView에서 find 해야함)


                                        EditText thema= (EditText)dialogView.findViewById(R.id.dialog_edit_1);
                                        EditText content= (EditText)dialogView.findViewById(R.id.dialog_edit_2);
                                        String thema_1= thema.getText().toString();
                                        String content_1 = content.getText().toString();
                                        list.add(new Member(thema_1,content_1));
                                        HashMap  map  = new HashMap();


                                            map.put("id", thema_1);

                                            map.put("name", content_1);

                                            maplist.add(map);

                                        adapter.notifyDataSetChanged();




                                        Toast.makeText(dialog.this, "입력한 정보를 추가합니다.", Toast.LENGTH_SHORT).show();

                                    }

                                });

                                buider.setNegativeButton("취소", new DialogInterface.OnClickListener() {

                                    //Dialog에 "Cancel"이라는 타이틀의 버튼을 설정



                                    @Override

                                    public void onClick(DialogInterface dialog, int which) {

                                        // TODO Auto-generated method stub

                                        //멤버 정보의 입력을 취소하고 Dialog를 종료하는 작업

                                        //취소하였기에 특별한 작업은 없고 '취소'했다는 메세지만 Toast로 출력

                                        Toast.makeText(dialog.this, "멤버 추가를 취소합니다", Toast.LENGTH_SHORT).show();

                                    }

                                });



                             /*   //설정한 값으로 AlertDialog 객체 생성

                                AlertDialog dialog=buider.create();



                                //Dialog의 바깥쪽을 터치했을 때 Dialog를 없앨지 설정

                                dialog.setCanceledOnTouchOutside(false);//없어지지 않도록 설정



                                //Dialog 보이기

                                dialog*/
                                buider.show();







                        }//mOnClickMethod




                        }).show();
            }
        });


    }
    class Member{

        String id;

        String name;

        public Member(String id, String name){

            this.id = id;

            this.name = name;

        }

    }


    }



