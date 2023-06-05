package Sprint;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Usuario implements Asesoria{
	protected String nombre;
	protected LocalDate fechaNacimiento;
	protected int run;
	
	public Usuario(){
	}
	public Usuario(String nombre, String fechaNacimiento, int run) {
		DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fechaNacimientoFormateada = LocalDate.parse(fechaNacimiento, formatoFecha);
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimientoFormateada;
		this.run = run;
	}
	public String getNombres() {
		return nombre;
	}
	public void setNombres(String nombres) {
		this.nombre = nombres;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public int getRun() {
		return run;
	}
	public void setRun(int run) {
		this.run = run;
	}
	@Override
	public String toString() {
		return "Usuario [nombres=" + nombre + ", fechaNacimiento=" + fechaNacimiento + ", run=" + run + "]";
	}
	
	@Override
	public void analizarUsuario() {
		System.out.println("Nombre de usuario: " + nombre + "; RUN del usuario: " + run);
	}
	
	public String mostrarEdad() {
		LocalDate ahora = LocalDate.now();
		Period periodo = Period.between(this.fechaNacimiento, ahora);
		int anho = periodo.getYears();
		int meses = periodo.getMonths();
		int dias = periodo.getDays();
		return anho + " Años " + meses + " Meses " + dias + " Dias ";
	}
}
