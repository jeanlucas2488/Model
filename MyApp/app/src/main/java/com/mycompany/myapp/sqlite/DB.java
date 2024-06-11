package com.mycompany.myapp.sqlite;
import android.database.sqlite.*;
import android.content.*;
import com.mycompany.myapp.etc.*;
import java.util.*;
import android.database.*;

public class DB
{
	SQLiteDatabase db;
	Context c;
	public DB(Context c2){
		Core cor = new Core(c2);
		db = cor.getWritableDatabase();
		this.c = c2;
	}
	public void moneyIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("money", us.getMoney());
		db.insert("dinheiro", null, ct);
	}
	public void moneyUp(util us){
		ContentValues ct = new ContentValues();
		ct.put("money", us.getMoney());
		db.update("dinheiro", ct, "id = ?", new String[]{String.valueOf(us.getMoneyID())});
	}
	public void cartaoDIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("carD", us.getCartaoD());
		db.insert("cartaoD", null, ct);
	}
	public void cartaoDUp(util us){
		ContentValues ct = new ContentValues();
		ct.put("carD", us.getCartaoD());
		db.update("cartaoD", ct, "id = ?", new String[]{String.valueOf(us.getCartaoDID())});
	}
	public void cartaoCIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("carC", us.getCartaoC());
		db.insert("cartaoC", null, ct);
	}
	public void cartaoCUp(util us){
		ContentValues ct = new ContentValues();
		ct.put("carC", us.getCartaoC());
		db.update("cartaoC", ct, "id = ?", new String[]{String.valueOf(us.getCartaoCID())});
	}
	public void pixIn(util us){
		ContentValues ct = new ContentValues();
		ct.put("pix", us.getPix());
		db.insert("Pix", null, ct);
	}
	public void pixUp(util us){
		ContentValues ct = new ContentValues();
		ct.put("pix", us.getPix());
		db.update("Pix", ct, "id = ?", new String[]{String.valueOf(us.getPixID())});
	}
	public List<util> getMoney(){
		ArrayList<util> arr = new ArrayList<util>();
		String[] cl = {"id", "money"};
		Cursor cr = db.query("dinheiro", cl, null, null, null, null, "money ASC");
		if(cr.getCount() >0){
			cr.moveToFirst();
			do {
				util us = new util();
				us.setMoneyID(Integer.parseInt(cr.getString(0)));
				us.setMoney(cr.getString(1));
				arr.add(us);
			}while(cr.moveToNext());
		}
		return arr;
	}
	public List<util> getCartaoD(){
		ArrayList<util> arr = new ArrayList<util>();
		String[] cl = {"id", "carD"};
		Cursor cr = db.query("cartaoD", cl, null, null, null, null, "carD ASC");
		if(cr.getCount() >0){
			cr.moveToFirst();
			do {
				util us = new util();
				us.setCartaoDID(Integer.parseInt(cr.getString(0)));
				us.setCartaoD(cr.getString(1));
				arr.add(us);
			}while(cr.moveToNext());
		}
		return arr;
	}
	public List<util> getCartaoC(){
		ArrayList<util> arr = new ArrayList<util>();
		String[] cl = {"id", "carC"};
		Cursor cr = db.query("cartaoC", cl, null, null, null, null, "carC ASC");
		if(cr.getCount() >0){
			cr.moveToFirst();
			do {
				util us = new util();
				us.setCartaoCID(Integer.parseInt(cr.getString(0)));
				us.setCartaoC(cr.getString(1));
				arr.add(us);
			}while(cr.moveToNext());
		}
		return arr;
	}
	public List<util> getPix(){
		ArrayList<util> arr = new ArrayList<util>();
		String[] cl = {"id", "pix"};
		Cursor cr = db.query("Pix", cl, null, null, null, null, "pix ASC");
		if(cr.getCount() >0){
			cr.moveToFirst();
			do {
				util us = new util();
				us.setPixID(Integer.parseInt(cr.getString(0)));
				us.setPix(cr.getString(1));
				arr.add(us);
			}while(cr.moveToNext());
		}
		return arr;
	}
}
