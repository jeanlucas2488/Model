package com.mycompany.myapp;

import android.*;
import android.app.*;
import android.content.*;
import android.content.pm.*;
import android.graphics.*;
import android.os.*;
import android.support.annotation.*;
import android.support.v4.app.*;
import android.support.v4.content.*;
import android.view.*;
import android.widget.*;
import android.widget.Toolbar.*;
import java.io.*;
import java.nio.channels.*;

import static android.Manifest.permission.MANAGE_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
import static android.Manifest.permission.READ_EXTERNAL_STORAGE;

public class selfCfg extends Activity
{
	String result;
	Context c = this;
	private static final int PERMISSION_REQUEST_CODE = 200;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		
		
		Handler handler2 = new Handler();
		handler2.postDelayed(new Runnable() {
				public void run() {
					
					ScrollView sc = new ScrollView(c);
					LinearLayout.LayoutParams pr = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
					pr.setMargins(10, 60, 10, 0);
					final LinearLayout root = new LinearLayout(c);
					sc.setLayoutParams(pr);
					root.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
					root.setOrientation(LinearLayout.VERTICAL);
					LinearLayout l1 = new LinearLayout(c);
					l1.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));

					l1.setBackgroundColor(Color.BLUE);
					TextView tv1 = new TextView(c);
					LayoutParams pr1 = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
					pr1.setMargins(10, 40, 10, 0);
					tv1.setGravity(Gravity.CENTER_HORIZONTAL);
					tv1.setText("Configuração do POS" + "\n");
					tv1.setTextSize(20);
					tv1.setTextColor(Color.WHITE);
					//tv.setBackgroundResource(R.drawable.border);
					tv1.setLayoutParams(pr1);
					l1.addView(tv1);
					root.addView(l1);
					sc.addView(root);
					
					Handler hd = new Handler();
					hd.postDelayed(new Runnable(){
						public void run(){
							LayoutParams pr1 = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
							pr1.setMargins(10, 40, 10, 0);
							
							LinearLayout l2 = new LinearLayout(c);
							l2.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
							final TextView tv = new TextView(c);
							tv.setText("Checando Permissões..." + "\n");
							ActivityCompat.requestPermissions(selfCfg.this, new String[]{WRITE_EXTERNAL_STORAGE, MANAGE_EXTERNAL_STORAGE,  READ_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);

							tv.setBackgroundResource(R.drawable.border);
							tv.setLayoutParams(pr1);
							l2.addView(tv);
							root.addView(l2);
							
							Handler hd2 = new Handler();
							hd2.postDelayed(new Runnable(){
								public void run(){
									LayoutParams pr1 = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
									pr1.setMargins(10, 30, 10, 0);
									
									LinearLayout l2 = new LinearLayout(c);
									l2.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
									final TextView tv = new TextView(c);
									
									if(checkPermission()){
										tv.setText("Permissão de SdCard Concedida!" + "\n");
										tv.setTextColor(Color.GREEN);
									}else {
										tv.setText("Permissão de SdCard Negada!" + "\n");
										tv.setTextColor(Color.RED);
									}
									tv.setBackgroundResource(R.drawable.border);
									tv.setLayoutParams(pr1);
									l2.addView(tv);
									root.addView(l2);
									
									Handler hd3 = new Handler();
									hd3.postDelayed(new Runnable(){
										public void run(){
											LayoutParams pr1 = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
											pr1.setMargins(10, 30, 10, 0);

											LinearLayout l2 = new LinearLayout(c);
											l2.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
											final TextView tv = new TextView(c);
											
											tv.setText("Criando diretórios do Sistema POS 1/4..." + "\n");
											
											File f = new File(Environment.getExternalStorageDirectory(), "pdvMain");
											f.exists();
											f.mkdir();
											
											if(f.canWrite()){
												Handler ha = new Handler();
												ha.postDelayed(new Runnable(){
													public void run(){
														tv.setText("Criando diretórios do Sistema POS 2/4..." + "\n");
														File f = new File(Environment.getExternalStorageDirectory(), "pdvMain/.sqlite");
														f.exists();
														f.mkdir();
														if(f.canWrite()){
															Handler hd4 = new Handler();
															hd4.postDelayed(new Runnable(){
																public void run(){
																	Handler hd5 = new Handler();
																	hd5.postDelayed(new Runnable(){
																		public void run(){
																			tv.setText("Criando diretórios do Sistema POS 3/4..." + "\n");

																			File f = new File(Environment.getExternalStorageDirectory(), "pdvMain/.Nfe");
																			f.exists();
																			f.mkdir();
																			if(f.canWrite()){
																				Handler hd6 = new Handler();
																				hd6.postDelayed(new Runnable(){
																					public void run(){
																						tv.setText("Criando diretórios do Sistema POS 4/4..." + "\n");

																						File f = new File(Environment.getExternalStorageDirectory(), "pdvMain/.fechamentos");
																						f.exists();
																						f.mkdir();
																						if(f.canWrite()){
																							Handler hd6 = new Handler();
																							hd6.postDelayed(new Runnable(){
																									public void run(){
																										LayoutParams pr1 = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
																										pr1.setMargins(10, 30, 10, 0);

																										LinearLayout l2 = new LinearLayout(c);
																										l2.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
																										final TextView tv = new TextView(c);

																										tv.setText("Concluído!" + "\n");

																										tv.setBackgroundResource(R.drawable.border);
																										tv.setLayoutParams(pr1);
																										l2.addView(tv);
																										root.addView(l2);

																										Handler hd6 = new Handler();
																										hd6.postDelayed(new Runnable(){
																												public void run(){
																													LayoutParams pr1 = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
																													pr1.setMargins(10, 30, 10, 0);

																													LinearLayout l2 = new LinearLayout(c);
																													l2.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
																													final TextView tv = new TextView(c);

																													tv.setText("Importando Banco de Dados..." + "\n");
																													Handler hd7 = new Handler();
																													hd7.postDelayed(new Runnable(){
																														public void run(){
																															try {
																																File sd = Environment.getExternalStorageDirectory();
																																File data = Environment.getDataDirectory();

																																if (sd.canWrite()) {
																																	tv.setText("Banco de dados Importado!" + "\n");
																																	tv.setTextColor(Color.GREEN);
																																	String  currentDBPath= "//data//" + c.getOpPackageName()
																																		+ "//databases//" + "data.db";

																																	String backupDBPath  = "pdvMain/.sqlite/data.db";

																																	File currentDB = new File(data, currentDBPath);
																																	File backupDB = new File(sd, backupDBPath);


																																	FileChannel src = new FileInputStream(backupDB).getChannel();
																																	FileChannel dst = new FileOutputStream(currentDB).getChannel();
																																	dst.transferFrom(src, 0, src.size());
																																	src.close();
																																	dst.close();
																																} else {
																																	tv.setText("Erro ao Importar Banco de dados!" + "\n");
																																	tv.setTextColor(Color.GREEN);
																																	
																																}
																															} catch (Exception e2) {

																															}
																														}
																													}, 1000);
																													tv.setBackgroundResource(R.drawable.border);
																													tv.setLayoutParams(pr1);
																													l2.addView(tv);
																													root.addView(l2);
																													Handler hd8 = new Handler();
																													hd8.postDelayed(new Runnable(){
																															public void run(){
																																
																																LayoutParams pr1 = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT);
																																pr1.setMargins(10, 30, 10, 0);

																																LinearLayout l2 = new LinearLayout(c);
																																l2.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
																																final TextView tv = new TextView(c);

																																tv.setText("Verificando a Integridade do POS..." + "\n");
																																
																																
																																tv.setBackgroundResource(R.drawable.border);
																																tv.setLayoutParams(pr1);
																																l2.addView(tv);
																																root.addView(l2);
																															}
																														}, 2000);
																												}
																											}, 900);
																									}
																								}, 1000);
																						} else {
																							tv.setText("Erro ao Criar diretórios!" + "\n");
																							tv.setTextColor(Color.RED);
																						}
																					}
																				}, 1000);
																			} else {
																				tv.setText("Erro ao Criar diretórios!" + "\n");
																				tv.setTextColor(Color.RED);
																			}
																		}
																	}, 1000);
																}
															}, 1000);
														} else {
															tv.setText("Erro ao Criar diretórios!" + "\n");
															tv.setTextColor(Color.RED);
														}
													}
												}, 1000);
											} else {
												tv.setText("Erro ao Criar diretórios!" + "\n");
												tv.setTextColor(Color.RED);
											}
											tv.setBackgroundResource(R.drawable.border);
											tv.setLayoutParams(pr1);
											l2.addView(tv);
											root.addView(l2);
										}
									}, 900);
								}
							}, 5000);
						}
					}, 1000);
					setContentView(sc);
						
				}
			}, 2000);
		
	}
	public boolean checkPermission(){
		if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){
			return Environment.isExternalStorageManager();
		} else {
			int write = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
			int read = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);

			return write == PackageManager.PERMISSION_GRANTED && read == PackageManager.PERMISSION_GRANTED;
		}
	}
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        switch (requestCode) {

            case 1:
                if (grantResults.length > 0) {
                    boolean readStorage = grantResults[1] == PackageManager.PERMISSION_GRANTED;
                    boolean writeStorage = grantResults[2] == PackageManager.PERMISSION_GRANTED;

                    if (readStorage && writeStorage) {
						Toast.makeText(c, "oi", Toast.LENGTH_LONG).show();
						// Permission GRANTED (Here write your code what you want).
                    } else {
                        // Permission DENY (If user click on DENY then finish the activity);

                    }
                }
        }
	}
}
