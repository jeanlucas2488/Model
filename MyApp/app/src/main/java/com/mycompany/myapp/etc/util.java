package com.mycompany.myapp.etc;

public class util
{
	public String money;
	public String cartaoD, cartaoC, pix;
	
	public long moneyID;
	public long cartaoDID;
	public long cartaoCID;
	public long pixID;
	
	public String getMoney(){
		return money;
	}
	public void setMoney(String mo){
		this.money = mo;
	}
	public String getPix(){
		return pix;
	}
	public void setPix(String mo){
		this.pix = mo;
	}
	public String getCartaoC(){
		return cartaoC;
	}
	public void setCartaoC(String mo){
		this.cartaoC = mo;
	}
	public String getCartaoD(){
		return cartaoD;
	}
	public void setCartaoD(String mo){
		this.cartaoD = mo;
	}
	public long getMoneyID(){
		return moneyID;
	}
	public void setMoneyID(long id){
		this.moneyID = id;
	}
	public long getCartaoDID(){
		return cartaoDID;
	}
	public void setCartaoDID(long id){
		this.cartaoDID = id;
	}
	public long getCartaoCID(){
		return cartaoCID;
	}
	public void setCartaoCID(long id){
		this.cartaoCID = id;
	}
	public long getPixID(){
		return pixID;
	}
	public void setPixID(long id){
		this.pixID = id;
	}
}
