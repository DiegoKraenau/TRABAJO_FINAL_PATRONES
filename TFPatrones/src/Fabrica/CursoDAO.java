package Fabrica;

import java.util.ArrayList;

import persistencia.CursoBean;

public interface CursoDAO {
	public void InsertarCurso(CursoBean curso);
	public void update(CursoBean curso);
	public void delete(String cod);
	public CursoBean searchxCod (String cod);
	public ArrayList<CursoBean> listarCursos();
}
