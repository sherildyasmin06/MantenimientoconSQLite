package com.datos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class Conexion extends SQLiteOpenHelper {
	private static final String BDD="DBalumno.db";
	private static final int VERSION=1;
	private String sql="Create Table alumno(id integer primary key autoincrement,codigo text,apellido text,nombre text,edad text,sexo text)";
	
	public Conexion(Context context) {
		super(context, BDD, null, VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("Drop Table If Exists alumno");
		db.execSQL(sql);
	}

}
