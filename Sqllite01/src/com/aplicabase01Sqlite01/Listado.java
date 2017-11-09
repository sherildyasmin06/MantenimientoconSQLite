package com.aplicabase01Sqlite01;

import java.sql.SQLException;

import com.datos.Clasesql;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Listado extends Activity {
TextView tvtexto;
Button b1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listado);
		tvtexto=(TextView)findViewById(R.id.tvlista);
		b1=(Button)findViewById(R.id.bcerrar);
		
		try{
			Clasesql dataLista=new Clasesql(this);
			dataLista.abrir();
			String listaDatos=dataLista.recibir();
			dataLista.cerrar();
			tvtexto.setText(listaDatos);
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		b1.setOnClickListener(new View.OnClickListener() {
			
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
		getMenuInflater().inflate(R.menu.listado, menu);
		return true;
	}

}
