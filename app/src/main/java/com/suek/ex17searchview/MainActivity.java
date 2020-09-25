package com.suek.ex17searchview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // 3)
    SearchView searchView;    // search 는 actionbar.xml 에 있어서 onCreate()에 안씀

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }//onCreate method





    //  1)  onCreate method 가 실행된후 OptionMenu 를 만드는 작업을 작성하기
    //위해 자동으로 실행되는 콜백메소드가 있다.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        /*MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.actionbar, menu);*/
        getMenuInflater().inflate(R.menu.actionbar, menu);

        //  2)  위 inflate()작업을 통해 MenuItem 이 만들어져있음
        //  4)  그 메뉴아이템 객체에게 SearchView 를 참조하기 위해 얻어오기
        MenuItem item= menu.findItem(R.id.menu_search);
        searchView= (SearchView)item.getActionView();

        // 서치뷰의 힌트글씨 변경
        searchView.setQueryHint("입력하세요");
        //searchView.setQuery("대신입력", false);


        // 5) 소프트키패드의 검색버튼(돋보기모양버튼)을 클릭하는 것을 듣는 리스너 추가..
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(MainActivity.this, query+"를 검색했습니다.", Toast.LENGTH_SHORT).show();
                return false;
            }


            // 그 서치뷰 EditText 안에 글씨를 변경할때 마다 실행되는 콜백메소드
            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });


        return super.onCreateOptionsMenu(menu);
    }
}
