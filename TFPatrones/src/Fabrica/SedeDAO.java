package Fabrica;

import java.util.ArrayList;

import persistencia.SedeBean;

public interface SedeDAO {
	
	public void InsertarSede(SedeBean sede);
	public void update(SedeBean sede);
	public void delete(String cod);
	public SedeBean searchxCod (String cod);
	public ArrayList<SedeBean> listarSedes();
}
