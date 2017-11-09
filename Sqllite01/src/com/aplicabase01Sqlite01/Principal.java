package com.aplicabase01Sqlite01;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;

public class Principal extends Activity {
	ImageButton imgbnuevo;
	ImageButton imgblistado;
	ImageButton imgbbuscar;
	ImageButton imgbsalir;
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        imgbnuevo=(ImageButton)findViewById(R.id.btningreso);
        imgblistado=(ImageButton)findViewById(R.id.btnlistado);
        imgbbuscar=(ImageButton)findViewById(R.id.btnbuscar);
        
        imgbsalir=(ImageButton)findViewById(R.id.btnsalir);
        
        imgbnuevo.setOnClickListener(new View.OnClickListener() {
        @Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent v1=new Intent(getApplicationContext(),Ingreso.class);
				startActivity(v1);
			}
		});
        
        imgblistado.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent v2= new Intent(getApplicationContext(),Listado.class);
				startActivity(v2);
			}
		});
        imgbbuscar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent v3= new Intent(getApplicationContext(),Busqueda.class);
				startActivity(v3);
			}
		});
        imgbsalir.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}
		});
        
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.principal, menu);
        return true;
    }
    
}
