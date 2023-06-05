package Sprint;

import java.util.ArrayList;
import java.util.List;

public class VisitaEnTerreno {
	private static int contadorIdentificador = 0;
	private int identificadorVisitaTerreno;
	private int rut;
	private String dia;
	private String hora;
	private String lugar;
	private String comentarios;
	private List<Revision> revisiones;
	
	public VisitaEnTerreno() {
		super();
	}
	public VisitaEnTerreno(int rut, String dia, String hora, String lugar,
			String comentarios) {
		super();
		contadorIdentificador++;
		this.identificadorVisitaTerreno = contadorIdentificador;
		this.rut = rut;
		this.dia = dia;
		this.hora = hora;
		this.lugar = lugar;
		this.comentarios = comentarios;
		revisiones = new ArrayList<>();
	}
	public int getIdentificadorVisitaTerreno() {
		return identificadorVisitaTerreno;
	}
	public int getRut() {
		return rut;
	}
	public void setRut(int rut) {
		this.rut = rut;
	}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getLugar() {
		return lugar;
	}
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	@Override
	public String toString() {
		return "VisitaEnTerreno [identificadorVisitaTerreno=" + identificadorVisitaTerreno + ", rut=" + rut + ", dia="
				+ dia + ", hora=" + hora + ", lugar=" + lugar + ", comentarios=" + comentarios + "]";
	}
	public void almacenarRevisiones(Revision revision) {
		revisiones.add(revision);
	}
}
