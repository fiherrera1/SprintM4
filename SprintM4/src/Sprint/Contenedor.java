package Sprint;
import java.util.ArrayList;
import java.util.List;
public class Contenedor {
	private List<Asesoria> asesorias;
	private List<Capacitacion> capacitaciones;
	public Contenedor() {
		asesorias = new ArrayList<>();
		capacitaciones = new ArrayList<>();
	}	
	public List<Asesoria> getAsesorias() {
		return asesorias;
	}
	public List<Capacitacion> getCapacitaciones() {
		return capacitaciones;
	}
	public void almacenarCliente(Cliente cliente) {
		asesorias.add(cliente);
	}
	public void almacenarProfesional(Profesional profesional) {
		asesorias.add(profesional);
	}
	public void almacenarAdministrativo(Administrativo administrativo) {
		asesorias.add(administrativo);
	}
	public void almacenarCapacitacion(Capacitacion capacitacion) {
		capacitaciones.add(capacitacion);
	}
	public void eliminarUsuario(int run) {
		for (Asesoria asesoria : asesorias) {
			if (asesoria instanceof Usuario && ((Usuario) asesoria).getRun() == run) {
				asesorias.remove(asesoria);
				System.out.println("Usuario eliminado correctamente");
				break;
			}
			else {
				System.out.println("El usuario no existe.");
			}
		}
		// usar iterator??
	}
	public void listarUsuarios() {
		for (Asesoria asesoria : asesorias) {
			if (asesoria instanceof Usuario) {
				System.out.println(((Usuario) asesoria).toString());
			}
		}
		// Alternativas
		// generar una nueva funcion qe nos liste los usuarios y de ahi pasarlas por un bucle
	}
	public void listarUsuariosPorTipo(String tipo) {
		for (Asesoria asesoria : asesorias) {
			if (asesoria instanceof Usuario &&  (asesoria.getClass().getSimpleName().equals(tipo))) {
				System.out.println(((Usuario) asesoria).toString());
			}
		}
		// tambien se puede usar un Stream
		// asesorias.stream()
		//         .filter(a -> a instanceof Usuario)
		//         .map(a -> (Usuario) a)
		//         .filter(u -> u.getClass().getSimpleName().equals(tipo))
		//         .forEach(System.out::println);
	}
	public void listarCapacitaciones() {
		for (Capacitacion capacitacion : capacitaciones) {
			System.out.println(capacitacion.toString());
			int rutCliente = capacitacion.getRutCliente();
			for (Asesoria asesoria : asesorias) {
				if (asesoria instanceof Cliente && ((Cliente) asesoria).getRun() == rutCliente) {
					System.out.println(((Cliente) asesoria).toString());
					break;
				}
			}
		}
		// lo mismo aqui podemos usar stream.       
		// capacitaciones.forEach(capacitacion -> {
		//     System.out.println(capacitacion.toString());
		//     int rutCliente = capacitacion.getRutCliente();
		//     asesorias.stream()
		//         .filter(e -> e instanceof Cliente && ((Cliente) e).getRut() == rutCliente)
		//         .findFirst()
		//         .ifPresent(cliente -> System.out.println(cliente.toString()));
		// });
	}
}