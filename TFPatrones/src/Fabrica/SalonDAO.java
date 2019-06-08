package Fabrica;

import java.util.ArrayList;

import persistencia.SalonBean;

public interface SalonDAO {
	
	public void InsertarSalon(SalonBean salon);
	public void update(SalonBean salon);
	public void delete(String cod);
	public SalonBean searchxCod (String cod);
	public ArrayList<SalonBean> listarSalones();
}
