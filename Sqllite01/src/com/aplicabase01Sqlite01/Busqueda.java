package com.aplicabase01Sqlite01;

import java.sql.SQLException;

import com.datos.Clasesql;
import com.entidad.EntAlumno;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Busqueda extends Activity {
	
	EditText etCod,etNom,etApe,etEdad,etSexo;
	Button bnuevobus,bbuscarbus,bcerrarbus,beliminarbus,bactualizarbus;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_busqueda);
		
		etCod=(EditText)findViewById(R.id.txtbuscodigo);
		etApe=(EditText)findViewById(R.id.txtbusape);
		etNom=(EditText)findViewById(R.id.txtbusnom);
		etEdad=(EditText)findViewById(R.id.txtbusedad);
		etSexo=(EditText)findViewById(R.id.txtbussexo);
		
		bnuevobus=(Button)findViewById(R.id.btnnuevobus);
		bbuscarbus=(Button)findViewById(R.id.btnbusqueda);
		beliminarbus=(Button)findViewById(R.id.btneliminar);
		bactualizarbus=(Button)findViewById(R.id.btnactualizar);
		bcerrarbus=(Button)findViewById(R.id.btncerrarbus);
		
		bnuevobus.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				etCod.setText("");
				etApe.setText("");
				etNom.setText("");
				etEdad.setText("");
				etSexo.setText("");
				etCod.requestFocus();				
			}
		});
        bbuscarbus.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Clasesql data = new Clasesql(Busqueda.this);
				Cursor fila;
				try{
					data.abrir();
					fila=data.busqueda(etCod.getText().toString());
					if (fila.moveToFirst()){
						etApe.setText(fila.getString(0));
						etNom.setText(fila.getString(1));
						etEdad.setText(fila.getString(2));
						etSexo.setText(fila.getString(3));
					
					}else{
						Toast.makeText(getApplicationContext(), "Codigo no Existe", Toast.LENGTH_SHORT).show();
					}
					data.cerrar();
					
				}catch(SQLException e){
					e.printStackTrace();
				}
				
			}
		});
       beliminarbus.setOnClickListener(new View.OnClickListener() {
        	
        	@Override
        	public void onClick(View arg0) {
        		// TODO Auto-generated method stub
        		Clasesql data=new Clasesql(Busqueda.this);
        		try{
        			data.abrir();
        			data.eliminar(etCod.getText().toString());
        			data.cerrar();
        			Toast mensaje=Toast.makeText(getApplicationContext(), "Registro Eliminado", Toast.LENGTH_LONG);
        			mensaje.show();
        		}catch(SQLException e){
        			e.printStackTrace();
        		}
        	}
        });
        bactualizarbus.setOnClickListener(new View.OnClickListener() {
        	
        	@Override
        	public void onClick(View arg0) {
        		// TODO Auto-generated method stub
        		EntAlumno objAlu=new EntAlumno();
        		objAlu.setCodigo(etCod.getText().toString());
        		objAlu.setApellidos(etApe.getText().toString());
        		objAlu.setNombre(etNom.getText().toString());
        		objAlu.setEdad(etEdad.getText().toString());
        		objAlu.setSexo(etSexo.getText().toString());
        		
        		Clasesql data=new Clasesql(Busqueda.this);
        		
        		try{
        			data.abrir();
        			data.modificar(objAlu);
        			data.cerrar();
        			Toast mensaje = Toast.makeText(getApplicationContext(), "Registro Actualizado", Toast.LENGTH_LONG);
        			mensaje.show();
        			
        		}catch(SQLException e){
        			e.printStackTrace();
        		}
        	}
        });
        
        bcerrarbus.setOnClickListener(new View.OnClickListener() {
	
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
		getMenuInflater().inflate(R.menu.busqueda, menu);
		return true;
	}

}
