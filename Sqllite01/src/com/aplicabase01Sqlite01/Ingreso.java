package com.aplicabase01Sqlite01;

import java.sql.SQLException;

import com.datos.Clasesql;
import com.entidad.EntAlumno;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Ingreso extends Activity {
	EditText txtcod,txtape,txtnom,txted,txtsex;
	ImageButton imgnuevo,imggrabar,imgcerrar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ingreso);
		txtcod=(EditText)findViewById(R.id.txtcodigo);
		txtape=(EditText)findViewById(R.id.txtapellidos);
		txtnom=(EditText)findViewById(R.id.txtnombres);
		txted=(EditText)findViewById(R.id.txtedad);
		txtsex=(EditText)findViewById(R.id.txtsexo);
		imgnuevo=(ImageButton)findViewById(R.id.btnbuscar2);
		imggrabar=(ImageButton)findViewById(R.id.btnguardar2);
		imgcerrar=(ImageButton)findViewById(R.id.btnsalir2);
		
		imgnuevo.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				txtcod.setText("");
				txtape.setText("");
				txtnom.setText("");
				txted.setText("");
				txtsex.setText("");
				txtcod.requestFocus();
			}
		});
		
		imggrabar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				EntAlumno objAlu=new EntAlumno();
				
				objAlu.setCodigo(txtcod.getText().toString());
				objAlu.setNombre(txtnom.getText().toString());
				objAlu.setApellidos(txtape.getText().toString());
				objAlu.setEdad(txted.getText().toString());
				objAlu.setSexo(txtsex.getText().toString());
				
				Clasesql data=new Clasesql(Ingreso.this);
				try{
					data.abrir();
					data.ingreso(objAlu);
					data.cerrar();
					
					Toast mensaje=Toast.makeText(getApplicationContext(), "Registro Grabado", Toast.LENGTH_LONG);
					mensaje.show();
				}catch(SQLException e){
					e.printStackTrace();
				}
				
			}
		});
		imgcerrar.setOnClickListener(new View.OnClickListener() {
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
		getMenuInflater().inflate(R.menu.ingreso, menu);
		return true;
	}

}
