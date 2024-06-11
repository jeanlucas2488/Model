package com.mycompany.myapp;

import android.app.*;
import android.os.*;
import android.view.*;
import android.view.inputmethod.*;
import android.widget.*;
import java.io.*;
import java.nio.channels.*;
import android.content.*;
import com.mycompany.myapp.etc.*;
import com.mycompany.myapp.sqlite.*;
import java.util.*;
import android.view.View.*;
import android.widget.TableLayout.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.icu.text.*;

public class MainActivity extends Activity 
{
	TextView valTotal, valRest;
	EditText dinheiro, carD, carC, pix;
	TextView tvDin, tvCarD, tvCarC, tvPix;
	RelativeLayout dinL, carDL, carCL, pixL;
	Context c = this;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		valTotal = findViewById(R.id.valTotal);
		valRest = findViewById(R.id.valRest);
		dinheiro = findViewById(R.id.money);
		carD = findViewById(R.id.carD);
		carC = findViewById(R.id.carC);
		pix = findViewById(R.id.pix);
		
		tvDin = findViewById(R.id.tvMoney);
		tvCarD = findViewById(R.id.tvCarD);
		tvCarC = findViewById(R.id.tvCarC);
		tvPix = findViewById(R.id.tvPix);
		dinL = findViewById(R.id.moneyL);
		carDL = findViewById(R.id.carDL);
		carCL = findViewById(R.id.carCL);
		pixL = findViewById(R.id.pixL);
		
		dinheiro.setVisibility(View.GONE);
		carD.setVisibility(View.GONE);
		carC.setVisibility(View.GONE);
		pix.setVisibility(View.GONE);
		
		valTotal.setText("50.00");
		valRest.setText("50.00");
		DB db = new DB(c);
		List<util> dL;
		List<util> cdL;
		List<util> ccL;
		List<util> pl;
		
		dL = db.getMoney();
		cdL = db.getCartaoD();
		ccL = db.getCartaoC();
		pl = db.getPix();
		
		dinheiro.setText(dL.get(0).getMoney());
        carD.setText(cdL.get(0).getCartaoD());
		carC.setText(ccL.get(0).getCartaoC());
		pix.setText(pl.get(0).getPix());
		
		dinL.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					// TODO: Implement this method
					dinL.setBackgroundResource(R.drawable.util);
					dinheiro.setVisibility(View.VISIBLE);
				}
		});
		carDL.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					// TODO: Implement this method
					carDL.setBackgroundResource(R.drawable.util);
					carD.setVisibility(View.VISIBLE);
				}
			});
		carCL.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					// TODO: Implement this method
					carCL.setBackgroundResource(R.drawable.util);
					carC.setVisibility(View.VISIBLE);
				}
			});
		pixL.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					// TODO: Implement this method
					pixL.setBackgroundResource(R.drawable.util);
					pix.setVisibility(View.VISIBLE);
				}
			});
		
		
		dinheiro.setOnEditorActionListener(new TextView.OnEditorActionListener(){

				@Override
				public boolean onEditorAction(TextView p1, int p2, KeyEvent event)
				{
					// TODO: Implement this method
					if(p2 == EditorInfo.IME_ACTION_DONE){
						
						
							Double val1 = new Double(valRest.getText().toString());
							Double val2 = new Double(dinheiro.getText().toString());
							double res = val1 - val2;

							
							DecimalFormatSymbols df = new DecimalFormatSymbols();
							df.setDecimalSeparator('.');
							df.setGroupingSeparator('.');
						    DecimalFormat dform = new DecimalFormat("####.00", df);
							valRest.setText(dform.format(res));

							try{
								List<util> lt;
								DB db = new DB(c);
								lt = db.getMoney();

								if(!lt.get(0).getMoney().equals("")){
									Double v1 = new Double(lt.get(0).getMoney());
									Double v2 = new Double(dinheiro.getText().toString());
									double res2 = v1 + v2;

									util us = new util();
									us.setMoneyID(lt.get(0).getMoneyID());
									us.setMoney(String.valueOf(res2));
									db.moneyUp(us);
								} else {}
							}catch(Exception e){
								util us = new util();
								us.setMoney(dinheiro.getText().toString());
								DB db = new DB(c);
								db.moneyIn(us);
							}
							try {
								File sd = Environment.getExternalStorageDirectory();
								File data = Environment.getDataDirectory();

								if (sd.canWrite()) {
									String  currentDBPath= "//data//" + c.getOpPackageName()
										+ "//databases//" + "data.db";

									String backupDBPath  = "pdvMain/.sqlite/data.db";

									File currentDB = new File(data, currentDBPath);
									File backupDB = new File(sd, backupDBPath);


									FileChannel src = new FileInputStream(currentDB).getChannel();
									FileChannel dst = new FileOutputStream(backupDB).getChannel();
									dst.transferFrom(src, 0, src.size());
									src.close();
									dst.close();
								}
							} catch (Exception e2) {

							}
						
						return true;
					}
					return false;
				}
		});
		carD.setOnEditorActionListener(new TextView.OnEditorActionListener(){

				@Override
				public boolean onEditorAction(TextView p1, int p2, KeyEvent event)
				{
					// TODO: Implement this method
					if(p2 == EditorInfo.IME_ACTION_DONE){
						
							Double val1 = new Double(valRest.getText().toString());
							Double val2 = new Double(carD.getText().toString());
							double res = val1 - val2;

						DecimalFormatSymbols df = new DecimalFormatSymbols();
						df.setDecimalSeparator('.');
						df.setGroupingSeparator('.');
						DecimalFormat dform = new DecimalFormat("####.00", df);
						valRest.setText(dform.format(res));
						
							try{
								List<util> lt;
								DB db = new DB(c);
								lt = db.getCartaoD();

								if(!lt.get(0).getCartaoD().equals("")){
									Double v1 = new Double(lt.get(0).getCartaoD());
									Double v2 = new Double(carD.getText().toString());
									double res2 = v1 + v2;

									util us = new util();
									us.setCartaoDID(lt.get(0).getCartaoDID());
									us.setCartaoD(String.valueOf(res2));
									db.cartaoDUp(us);
								} else {}
							}catch(Exception e){
								util us = new util();
								us.setCartaoD(carD.getText().toString());
								DB db = new DB(c);
								db.cartaoDIn(us);
							}
							try {
								File sd = Environment.getExternalStorageDirectory();
								File data = Environment.getDataDirectory();

								if (sd.canWrite()) {
									String  currentDBPath= "//data//" + c.getOpPackageName()
										+ "//databases//" + "data.db";

									String backupDBPath  = "Android/data.db";

									File currentDB = new File(data, currentDBPath);
									File backupDB = new File(sd, backupDBPath);


									FileChannel src = new FileInputStream(currentDB).getChannel();
									FileChannel dst = new FileOutputStream(backupDB).getChannel();
									dst.transferFrom(src, 0, src.size());
									src.close();
									dst.close();
								}
							} catch (Exception e2) {

							}
						
						return true;
					}
					return false;
				}
			});
		carC.setOnEditorActionListener(new TextView.OnEditorActionListener(){

				@Override
				public boolean onEditorAction(TextView p1, int p2, KeyEvent event)
				{
					// TODO: Implement this method
					if(p2 == EditorInfo.IME_ACTION_DONE){

						
							Double val1 = new Double(valRest.getText().toString());
							Double val2 = new Double(carC.getText().toString());
							double res = val1 - val2;

						DecimalFormatSymbols df = new DecimalFormatSymbols();
						df.setDecimalSeparator('.');
						df.setGroupingSeparator('.');
						DecimalFormat dform = new DecimalFormat("####.00", df);
						valRest.setText(dform.format(res));
						
							try{
								List<util> lt;
								DB db = new DB(c);
								lt = db.getCartaoC();

								if(!lt.get(0).getCartaoC().equals("")){
									Double v1 = new Double(lt.get(0).getCartaoC());
									Double v2 = new Double(carC.getText().toString());
									double res2 = v1 + v2;

									util us = new util();
									us.setCartaoCID(lt.get(0).getCartaoCID());
									us.setCartaoC(String.valueOf(res2));
									db.cartaoCUp(us);
								} else {}
							}catch(Exception e){
								util us = new util();
								us.setCartaoC(carC.getText().toString());
								DB db = new DB(c);
								db.cartaoCIn(us);
							}
							try {
								File sd = Environment.getExternalStorageDirectory();
								File data = Environment.getDataDirectory();

								if (sd.canWrite()) {
									String  currentDBPath= "//data//" + c.getOpPackageName()
										+ "//databases//" + "data.db";

									String backupDBPath  = "Android/data.db";

									File currentDB = new File(data, currentDBPath);
									File backupDB = new File(sd, backupDBPath);


									FileChannel src = new FileInputStream(currentDB).getChannel();
									FileChannel dst = new FileOutputStream(backupDB).getChannel();
									dst.transferFrom(src, 0, src.size());
									src.close();
									dst.close();
								}
							} catch (Exception e2) {

							}
						
						return true;
					}
					return false;
				}
			});
		pix.setOnEditorActionListener(new TextView.OnEditorActionListener(){

				@Override
				public boolean onEditorAction(TextView p1, int p2, KeyEvent event)
				{
					// TODO: Implement this method
					if(p2 == EditorInfo.IME_ACTION_DONE){

						
							Double val1 = new Double(valRest.getText().toString());
							Double val2 = new Double(pix.getText().toString());
							double res = val1 - val2;

						DecimalFormatSymbols df = new DecimalFormatSymbols();
						df.setDecimalSeparator('.');
						df.setGroupingSeparator('.');
						DecimalFormat dform = new DecimalFormat("####.00", df);
						valRest.setText(dform.format(res));
						
							try{
								List<util> lt;
								DB db = new DB(c);
								lt = db.getPix();

								if(!lt.get(0).getPix().equals("")){
									Double v1 = new Double(lt.get(0).getPix());
									Double v2 = new Double(pix.getText().toString());
									double res2 = v1 + v2;

									util us = new util();
									us.setPixID(lt.get(0).getPixID());
									us.setPix(String.valueOf(res2));
									db.pixUp(us);
								} else {}
							}catch(Exception e){
								util us = new util();
								us.setPix(pix.getText().toString());
								DB db = new DB(c);
								db.pixIn(us);
							}
							try {
								File sd = Environment.getExternalStorageDirectory();
								File data = Environment.getDataDirectory();

								if (sd.canWrite()) {
									String  currentDBPath= "//data//" + c.getOpPackageName()
										+ "//databases//" + "data.db";

									String backupDBPath  = "Android/data.db";

									File currentDB = new File(data, currentDBPath);
									File backupDB = new File(sd, backupDBPath);


									FileChannel src = new FileInputStream(currentDB).getChannel();
									FileChannel dst = new FileOutputStream(backupDB).getChannel();
									dst.transferFrom(src, 0, src.size());
									src.close();
									dst.close();
								}
							} catch (Exception e2) {

						}
						return true;
					}
					return false;
				}
			});
			
    }
}
