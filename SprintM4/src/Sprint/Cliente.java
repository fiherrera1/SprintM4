package Sprint;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario{
	private String telefono;
	private String afp;
	private int sistemaSalud;
	private String direccion;
	private String comuna;
	private List<VisitaEnTerreno> visitas;
	private List<Accidente> accidentes;
	
	public Cliente() {
		super();
	}
	public Cliente(String nombre, String fechaNacimiento, int run, String telefono, String afp, int sistemaSalud, String dirección, String comuna) {
		super(nombre, fechaNacimiento, run);
		this.telefono = telefono;
		this.afp = afp;
		this.sistemaSalud = sistemaSalud;
		this.direccion = dirección;
		this.comuna = comuna;
		visitas = new ArrayList<>();
		accidentes = new ArrayList<>();
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getAfp() {
		return afp;
	}
	public void setAfp(String afp) {
		this.afp = afp;
	}
	public int getSistemaSalud() {
		return sistemaSalud;
	}
	public void setSistemaSalud(int sistemaSalud) {
		this.sistemaSalud = sistemaSalud;
	}
	public String getDirección() {
		return direccion;
	}
	public void setDirección(String dirección) {
		this.direccion = dirección;
	}
	public String getComuna() {
		return comuna;
	}
	public void setComuna(String comuna) {
		this.comuna = comuna;
	}
	@Override
	public String toString() {
		return "Cliente [telefono=" + telefono + ", afp=" + afp + ", sistemaSalud=" + sistemaSalud + ", dirección="
				+ direccion + ", comuna=" + comuna + "]";
	}
	
	public String obtenerNombre() {
		return nombre;
	}
	
	public void obtenerSistemaSalud() {
		if (sistemaSalud == 1) {
            System.out.println("Fonasa");
        } else if (sistemaSalud == 2) {
            System.out.println("Isapre");
        } else {
            System.out.println("No existe");
        }
	}
	@Override
	public void analizarUsuario() {
		super.analizarUsuario();
		System.out.println("Dirección del cliente: " + direccion + ". Comuna del Cliente: " + comuna);
	}
	public void almacenarVisitas(VisitaEnTerreno visita) {
		visitas.add(visita);
	}
	public void almacenarAccidente(Accidente accidente) {
		accidentes.add(accidente);
	}
}
