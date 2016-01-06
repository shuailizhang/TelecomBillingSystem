package me.tbs.zhang.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import me.tbs.zhang.AppConfig;

/**
 * Created by dime on 16-1-5.
 */
public class DBHelper extends SQLiteOpenHelper {


    public DBHelper(Context context) {
        super(context, AppConfig.DB_NAME, null, AppConfig.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //初始化数据库

        //创建用户表
        db.execSQL("CREATE TABLE user(id INTEGER primary key autoincrement," +      //主键自增
                " name TEXT," +                                                     //用户名
                " tel TEXT)"                                                        //电话号码
                );//创建用户表
        //创建通话记录表
        db.execSQL("CREATE TABLE record(id INTEGER primary key autoincrement," +   //主键自增
                " tel TEXT, " +                                                     //电话号码
                " date DATE" +                                                      //日期
                " duration FLOAT," +                                                //通话时长
                " type BOOLEAN)");                                                  //长途or本地
        //创建管理员表
        db.execSQL("CREATE TABLE admin(id INTEGER primary key autoincrement, " +    //主键自增
                "aname TEXT, " +                                                    //管理员名
                "password TEXT)");                                                  //密码
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        //忽略
    }
}
