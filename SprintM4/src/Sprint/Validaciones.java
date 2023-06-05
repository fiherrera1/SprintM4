package Sprint;

import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.ArrayList;
import java.util.List;


public class Validaciones {
	//Comunes

	public static boolean validarFecha(String fechaTesteo) {

		if (fechaTesteo.length() <= 0) {
			return false;
		}

		SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
		Date testDate = null;
		String date = fechaTesteo;
		try {
			testDate = fecha.parse(date);
		}catch(Exception e) {System.out.println("Formato de fecha inválido");}
		if(!fecha.format(testDate).equals(date)) {
			return false;
		}
		else {
			return true;
		}
	}

	public static boolean validarHora(String horaTesteo) {

		if (horaTesteo.length() <= 0) {
			return false;
		}

		SimpleDateFormat hour = new SimpleDateFormat("HH:mm");
		Date testHour = null;
		String hora = horaTesteo;
		try {
			testHour = hour.parse(hora);
		}catch(Exception e) {System.out.println("Formato de hora invalido.");}
		if(!hour.format(testHour).equals(hora)) {
			return false;
		}
		else {
			return true;
		}
	}

	public static boolean validaLetrasDelNombre(String nombre) {
		boolean valido = true;
		if (nombre.length() < 10 || nombre.length() > 100) {
			System.out.println("El nombre del usuario debe tener entre 10 y 50 caracteres");
			valido = false;
		}
		if (!nombre.matches("[a-zA-Z ]*")){
			System.out.println("El nombre del usuario debe estar conformado por letras");
			valido = false;
		}
		return valido;
	}

	public static boolean validarRun(String run) {
		if (run.length() <= 0) {
			return false;
		}
		if (Integer.parseInt(run) < 0 || Integer.parseInt(run) > 99999999) {
			System.out.println("El run ingresado no existe.");
			return false;
		}
		else {
			return true;
		}
	}

	public static boolean validarCienCaracteres(String string) {
		if (string.isEmpty()) {
			System.out.println("No puede dejar en blanco esta sección, si no aplica para su caso, "
					+ "escriba NO APLICA.");
			return false;}
		if (string.length() > 100) {
			System.out.println("Excede los 100 caracteres permitidos.");
			return false;
		}
		else {return true;}
	}

	public static boolean validarCincuentaCaracteres(String string) {
		if (string.isEmpty()) {return false;}
		if (string.length() < 10 || string.length() > 50) {
			System.out.println("La informacion ingresada posee más de 50 o menos de 10 caracteres.");
			return false;
		}
		else {return true;}
	}



	//Cliente

	public static boolean validarTelefono(String telefono) {
		if (telefono.isEmpty()) {return false;}
		if (!telefono.matches("[0-9+]*")) {return false;}
		else {return true;}
	}

	public static boolean validarAFP(String afp) {
		if (afp.isEmpty()) {return false;}
		if (afp.length() < 4 || afp.length() > 30) {
			System.out.println("Nombre de AFP inválida.");
			return false;
		}
		else {return true;}
	}

	public static boolean validarSistemaSalud(int sistemaSalud) {
		if (sistemaSalud != 1 && sistemaSalud != 2) {
			System.out.println("Sistema de salud no encontrado.");
			return false;
		}
		else {return true;}
	}

	public static boolean validarDireccion(String direccion) {
		if (direccion.isEmpty()) {return false;}
		if (direccion.length() > 70) {
			System.out.println("Dirección invalida.");
			return false;
		}
		else {return true;}
	}

	public static boolean validarComuna(String comuna) {
		if (comuna.isEmpty()) {return false;}
		if (comuna.length() > 50) {
			System.out.println("Comuna invalida.");
			return false;
		}
		else {return true;}
	}

	// Administrativo 

	public static boolean validarArea (String area)  {
		if (area.length() >= 5 && area.length() <= 20) {
			return true;}
		else {return false;}
	}

	// Solicitar Estado de la Revisión al usuario de la empresa
	public static boolean validarEstado(int estado) {
		if ((estado != 1 && estado != 2 && estado != 3)) {
			System.out.println("Ingrese un código válido.");
			return false;
		}else {
			return true;
		}
	}
	// 
	public static boolean revisarUsuario(String usuario) {
		if ((Integer.parseInt(usuario) != 1 && Integer.parseInt(usuario) != 2 && Integer.parseInt(usuario) != 3)) {
			System.out.println("Ingrese un usuario valido.");
			return false;
		}else {
			return true;
		}
	}
	
	public static boolean mayorCero(String cantidad) {
		if ((Integer.parseInt(cantidad) < 0)) {
			System.out.println("Ingrese una cantidad valida (mayor o igual a cero).");
			return false;
		}else {
			return true;
		}
	}
	
	public static boolean mayorUno(String cantidad) {
		if ((Integer.parseInt(cantidad) < 1)) {
			System.out.println("Ingrese una cantidad valida (mayor o igual a uno).");
			return false;
		}else {
			return true;
		}
	}
	
	public static boolean validarIdentificador(String identificador) {
		if (identificador.isEmpty()) {return false;}
		if (!identificador.matches("[0-9]*")) {return false;}
		else {return true;}
	}
	
	public static boolean validarAsistentes(String cantidad) {
		if (cantidad.isEmpty()) {return false;}
		if (!cantidad.matches("[0-9]*") || Integer.parseInt(cantidad) > 1000) {return false;}
		else {return true;}
	}
	
	public static boolean validarRutCliente(String rutCliente, Contenedor contenedor) {
	    List<Cliente> clientes = new ArrayList<>();
	    List<Asesoria> coleccion = contenedor.getAsesorias();
	    
		if (!Validaciones.validarRun(rutCliente)) {
			System.out.println("RUN inválido");
			return false;
		} 
	    
	    for (Asesoria buscadorCliente : coleccion) {
	      if (buscadorCliente instanceof Cliente) {
	        clientes.add((Cliente) buscadorCliente);
	      }
	    }
	    for (Cliente cliente : clientes) {
	      if (cliente.getRun() == Integer.parseInt(rutCliente)) {
	        System.out.println("Cliente encontrado con exito.");
	        return true; // el rut existe
	      }
	    }
	    return false;

	  }
	
}
