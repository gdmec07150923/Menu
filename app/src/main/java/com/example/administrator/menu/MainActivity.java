package com.example.administrator.menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int mcount ;
    private TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mcount=0;



        tv1 = (TextView)findViewById(R.id.textView);
        registerForContextMenu(tv1);
    }

    //创建选项菜单
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       /* MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.mymenu,menu);*/
        menu.add(0,1,0,R.string.m1);
        menu.add(0,1,0,R.string.m2);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        mcount++;
        menu.add(0,2+mcount,0,"菜单"+mcount);
        return super.onPrepareOptionsMenu(menu);
    }
    //选项菜单被选中
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this,item.getTitle().toString(),Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }
    //创建上下文菜单
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.add(0,1,0,"点我了");
        menu.add(0,2,0,"我怕了");
        super.onCreateContextMenu(menu, v, menuInfo);
    }
    //上下文菜单被选中
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Toast.makeText(this,item.getTitle().toString(),Toast.LENGTH_SHORT).show();
        return super.onContextItemSelected(item);
    }
}
