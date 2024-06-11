package com.mycompany.myapp.sqlite;
import android.database.sqlite.*;
import android.content.*;

public class Core extends SQLiteOpenHelper
{
	public static String Db_name = "data.db";
	public Core(Context c){
		super(c, Db_name, null, 2);
	}

	@Override
	public void onCreate(SQLiteDatabase db)
	{
		// TODO: Implement this method
		db.execSQL("CREATE TABLE dinheiro" + 
		           "(id integer primary key, money TEXT);");
				   
		db.execSQL("CREATE TABLE cartaoD" +
		           "(id integer primary key, carD TEXT);");
		db.execSQL("CREATE TABLE cartaoC" +
		           "(id integer primary key, carC TEXT);");
		db.execSQL("CREATE TABLE Pix" +
		           "(id integer primary key, pix TEXT);");
	}
	@Override
	public void onUpgrade(SQLiteDatabase p1, int p2, int p3)
	{
		// TODO: Implement this method
	}
}
