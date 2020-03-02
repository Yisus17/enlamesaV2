package com.enlamesa.back.model;

public class WS_ST_Stocks_DT {
	
	private String Id_Tpv;
	private String EAN;
	private String Stock;
	private String Id_Articulo;
	
	public String getId_Tpv() {
		return Id_Tpv;
	}
	public void setId_Tpv(String id_Tpv) {
		Id_Tpv = id_Tpv;
	}
	public String getEAN() {
		return EAN;
	}
	public void setEAN(String eAN) {
		EAN = eAN;
	}
	public String getStock() {
		return Stock;
	}
	public void setStock(String stock) {
		Stock = stock;
	}
	public String getId_Articulo() {
		return Id_Articulo;
	}
	public void setId_Articulo(String id_Articulo) {
		Id_Articulo = id_Articulo;
	}
	
	@Override
    public String toString() {
        return "Linea:: Id_Tpv="+this.Id_Tpv+" EAN=" + this.EAN + " Stock=" + this.Stock + " Id_Articulo=" + this.Id_Articulo;
    }
}
