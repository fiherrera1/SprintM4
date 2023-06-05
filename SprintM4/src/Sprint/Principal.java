package Sprint;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Contenedor contenedor = new Contenedor();
		Scanner scanner = new Scanner(System.in);
		int opcion;
		do {
			System.out.println("++++++ Menu principal ++++++");
			System.out.println("1. Guardar cliente");
			System.out.println("2. Guardar profesional");
			System.out.println("3. Guardar administrativo");
			System.out.println("4. Guardar capacitación");
			System.out.println("5. Eliminar usuario");
			System.out.println("6. Listar usuarios");
			System.out.println("7. Listar usuarios por tipo");
			System.out.println("8. Listar capacitaciones");
			System.out.println("9. Salir");
			System.out.print("Ingrese una opcion: ");
			opcion = Integer.parseInt(scanner.nextLine());
			switch (opcion) {
			case 1:
				// Agregar Cliente
				System.out.println("====== Almacenar Cliente ======");

				// Solicitar datos del Cliente

				// Solicitar nombre del Cliente
				System.out.print("Ingrese el nombre completo del cliente: ");
				String nombreCliente = scanner.nextLine();

				// Validar longitud del nombre de Cliente
				if (!Validaciones.validaLetrasDelNombre(nombreCliente)) {
					break;
				}

				// Solicitar fecha de nacimiento del Cliente
				System.out.print("Ingrese la fecha de nacimiento del Cliente (Formato DD/MM/YYYY): ");
				String nacimientoCliente = scanner.nextLine();

				// Validar fecha de nacimiento de Cliente
				if (!Validaciones.validarFecha(nacimientoCliente)) {
					System.out.println("Fecha inválida");
					break;
				}

				// Solicitar run del Cliente
				System.out.print("Ingrese el RUN del Cliente (sin puntos ni digito verificador): ");
				String runCliente = scanner.nextLine();

				// Validar run del Cliente
				if (!Validaciones.validarRun(runCliente)) {
					System.out.println("RUN inválido");
					break;
				}

				// Solicitar telefono del Cliente
				System.out.print("Ingrese el telefono del Cliente: ");
				String telefonoCliente = scanner.nextLine();

				// Validar telefono del Cliente
				if (!Validaciones.validarTelefono(telefonoCliente)) {
					System.out.println("Telefono inválido");
					break;
				}

				// Solicitar AFP del Cliente
				System.out.print("Ingrese la AFP del Cliente: ");
				String afpCliente = scanner.nextLine();

				// Validar telefono del Cliente
				if (!Validaciones.validarAFP(afpCliente)) {
					System.out.println("AFP ingresada no existe.");
					break;
				}

				// Solicitar el sistema de salud del cliente
				System.out.print("Ingrese el sistema de salud al cual pertenece el cliente (1 si es Fonasa"
						+ " o 2 si es Isapre): ");
				String sistemaCliente = scanner.nextLine();

				// Validar el sistema de salud del cliente
				if (!Validaciones.validarSistemaSalud(Integer.parseInt(sistemaCliente))) {
					System.out.println("AFP ingresada no existe.");
					break;
				}

				// Solicitar la direccion del Cliente
				System.out.print("Ingrese la dirección del Cliente: ");
				String direccionCliente = scanner.nextLine();

				// Validar direccion del Cliente
				if (!Validaciones.validarDireccion(direccionCliente)) {
					System.out.println("La dirección ingresada no es válida.");
					break;
				}

				// Solicitar la comuna del Cliente
				System.out.print("Ingrese la comuna del Cliente: ");
				String comunaCliente = scanner.nextLine();

				// Validar direccion del Cliente
				if (!Validaciones.validarComuna(comunaCliente)) {
					System.out.println("La comuna ingresada no es válida.");
					break;
				}

				Cliente cliente = new Cliente(nombreCliente,nacimientoCliente,
						Integer.parseInt(runCliente),telefonoCliente,afpCliente,
						Integer.parseInt(sistemaCliente),direccionCliente,comunaCliente);

				// Preguntar si registra ningun o muchos accidentes
				System.out.println("¿Desea registrar algún accidente? Puedes ingresar ningun o muchos accidentes: ");
				String accidentesCliente = scanner.nextLine();

				// Validar cantidad de accidentes
				if (!Validaciones.mayorCero(accidentesCliente)) {
					System.out.println("Ingrese una cantidad mayor o igual a cero de accidentes.");
					break;
				}

				if (Integer.parseInt(accidentesCliente) == 0) {
					System.out.println("No se ingresan accidentes.");
				} else {
					int i = 0;
					do {
						// Identificador del accidente
						System.out.println("Ingrese el identificador del accidente: ");
						String identificadorAccidente = scanner.nextLine();

						// Validar Identificador del accidente
						if (!Validaciones.validarIdentificador(identificadorAccidente)) {
							System.out.println("Numero incorrecto, ingrese el identificador correspondiente.");
							continue;
						}

						// Fecha del accidente						
						System.out.print("Ingrese la fecha del accidente (Formato DD/MM/YYYY): ");
						String fechaAccidente = scanner.nextLine();

						// Validar Fecha del accidente
						if (!Validaciones.validarFecha(fechaAccidente)) {
							System.out.println("Fecha inválida");
							continue;
						}

						// Hora del accidente
						System.out.print("Ingrese la hora del accidente (Formato HH:mm): ");
						String horaAccidente = scanner.nextLine();

						// Validar Hora del accidente
						if (!Validaciones.validarHora(horaAccidente)) {
							System.out.println("Hora inválida");
							continue;
						}

						// Lugar del accidente
						System.out.print("Ingrese el lugar del accidente: ");
						String lugarAccidente = scanner.nextLine();

						// Validar el lugar del accidente
						if (!Validaciones.validarCincuentaCaracteres(lugarAccidente)) {
							System.out.println("Lugar inválido.");
							continue;
						}

						// Origen del accidente
						System.out.print("Ingrese el origen del accidente: ");
						String origenAccidente = scanner.nextLine();

						// Validar el origen del accidente
						if (!Validaciones.validarCienCaracteres(origenAccidente)) {
							System.out.println("Origen inválido.");
							continue;
						}

						// Consecuencias del accidente
						System.out.print("Ingrese las consecuencias del accidente: ");
						String consecuenciasAccidente = scanner.nextLine();

						// Validar el origen del accidente
						if (!Validaciones.validarCienCaracteres(consecuenciasAccidente)) {
							System.out.println("Consecuencias inválido.");
							continue;
						}

						Accidente accidente = new Accidente(Integer.parseInt(identificadorAccidente), Integer.parseInt(runCliente),
								fechaAccidente, horaAccidente, lugarAccidente, origenAccidente, consecuenciasAccidente);

						cliente.almacenarAccidente(accidente);
						i++;
					} while (i != Integer.parseInt(accidentesCliente));
				}

				// Preguntar si tiene una o muchas visitas a terreno
				System.out.println("¿Desea registrar alguna visita a terreno? Puedes ingresar una o muchas visitas a terreno: ");
				String visitasCliente = scanner.nextLine();

				// Validar visitas a terreno del Cliente
				if (!Validaciones.mayorUno(visitasCliente)) {
					System.out.println("Ingrese una cantidad mayor o igual a uno de visitas a terreno.");
					break;
				}
				int j = 0;
				do {

					// Fecha de la visita
					System.out.print("Ingrese la fecha de la visita a terreno (Formato DD/MM/YYYY): ");
					String fechaVisita = scanner.nextLine();

					// Validar Fecha de la visita a terreno
					if (!Validaciones.validarFecha(fechaVisita)) {
						System.out.println("Fecha inválida");
						continue;
					}

					// Hora de la visita
					System.out.print("Ingrese la hora de la visita a terreno (Formato HH:mm): ");
					String horaVisita = scanner.nextLine();

					// Validar Hora de la visita
					if (!Validaciones.validarHora(horaVisita)) {
						System.out.println("Hora inválida");
						continue;
					}

					// Lugar de la visita
					System.out.print("Ingrese el lugar de la visita a terreno: ");
					String lugarVisita = scanner.nextLine();

					// Validar del accidente
					if (!Validaciones.validarCincuentaCaracteres(lugarVisita)) {
						System.out.println("Lugar inválido.");
						continue;
					}

					// Comentario de la visita
					System.out.print("Ingrese el comentario de la visita: ");
					String comentarioVisita = scanner.nextLine();

					// Validar el origen del accidente
					if (!Validaciones.validarCienCaracteres(comentarioVisita)) {
						System.out.println("Comentario inválido.");
						continue;
					}

					VisitaEnTerreno visita = new VisitaEnTerreno(Integer.parseInt(runCliente),
							fechaVisita, horaVisita, lugarVisita, comentarioVisita);

					// Preguntar si en la visita a terreno tiene 1 o más revisiones (dentro de visita a terreno)
					System.out.println("¿Desea registrar alguna revision? Puedes ingresar una o muchas revisiones: ");
					String revisionVisita = scanner.nextLine();

					// Validar revisiones de las visitas a terreno
					if (!Validaciones.mayorUno(revisionVisita)) {
						System.out.println("Ingrese una cantidad mayor o igual a uno de revisiones.");
						break;
					}

					int k = 0;
					do {

						// Identificador de la revision
						System.out.println("Ingrese el identificador de la revision: ");
						String identificadorRevision = scanner.nextLine();

						// Validar Identificador de la revision
						if (!Validaciones.validarIdentificador(identificadorRevision)) {
							System.out.println("Numero incorrecto, ingrese el identificador correspondiente.");
							continue;
						}

						// Nombre alusivo de la revision
						System.out.print("Ingrese el nombre alusivo a la revisión: ");
						String nombreRevision = scanner.nextLine();

						// Validar el nombre alusivo de la revision
						if (!Validaciones.validarCincuentaCaracteres(nombreRevision)) {
							System.out.println("Nombre inválido.");
							continue;
						}

						// Detalle de la revision
						System.out.print("Ingrese el detalle de la revisión: ");
						String detalleRevision = scanner.nextLine();

						// Validar el detalle de la revision
						if (!Validaciones.validarCienCaracteres(detalleRevision)) {
							System.out.println("Detalle inválido.");
							continue;
						}

						// Estado de la revision
						System.out.print("Ingrese el estado de la revisión (1 (sin problemas), 2 (con observaciones), 3 (no aprueba)): ");
						String estadoRevision = scanner.nextLine();
						
						// Validar el estado de la revision
						if (!Validaciones.validarEstado(Integer.parseInt(estadoRevision))) {
							System.out.println("Estado invalido inválido.");
							continue;
						}

						Revision revision = new Revision(visita.getIdentificadorVisitaTerreno(), nombreRevision,
								detalleRevision, Integer.parseInt(estadoRevision));

						visita.almacenarRevisiones(revision);
						k++;

					} while (k != Integer.parseInt(revisionVisita));

					cliente.almacenarVisitas(visita);
					j++;

				} while (j != Integer.parseInt(visitasCliente));

				contenedor.almacenarCliente(cliente);
				break;
			case 2:
				// Agregar Profesional
				System.out.println("====== Almacenar Profesional ======");

				// Solicitar datos del Profesional

				// Solicitar nombre del Profesional
				System.out.print("Ingrese el nombre completo del Profesional: ");
				String nombreProfesional = scanner.nextLine();

				// Validar longitud del nombre de Profesional
				if (!Validaciones.validaLetrasDelNombre(nombreProfesional)) {
					break;
				}

				// Solicitar fecha de nacimiento del Profesional
				System.out.print("Ingrese la fecha de nacimiento del Profesional (Formato DD/MM/YYYY): ");
				String nacimientoProfesional = scanner.nextLine();

				// Validar fecha de nacimiento de Profesional
				if (!Validaciones.validarFecha(nacimientoProfesional)) {
					System.out.println("Fecha inválida");
					break;
				}

				// Solicitar run del Profesional
				System.out.print("Ingrese el RUN del Profesional (sin puntos ni digito verificador): ");
				String runProfesional = scanner.nextLine();

				// Validar run del Profesional
				if (!Validaciones.validarRun(runProfesional)) {
					System.out.println("RUN inválido");
					break;
				}

				// Solicitar titulo del profesional
				System.out.print("Ingrese el titulo del Profesional: ");
				String tituloProfesional = scanner.nextLine();


				// Validar titulo del profesional
				if (!Validaciones.validarCincuentaCaracteres(tituloProfesional)) {
					System.out.println("Titulo invalido.");
					break;
				}

				// Solicitar fecha de ingreso del profesional
				System.out.print("Ingrese la fecha de ingreso del Profesional (Formato DD/MM/YYYY): ");
				String ingresoProfesional = scanner.nextLine();

				// Validar fecha de ingreso del profesional
				if (!Validaciones.validarFecha(ingresoProfesional)) {
					System.out.println("Fecha inválida");
					break;
				}

				Profesional profesional = new Profesional(nombreProfesional,nacimientoProfesional,
						Integer.parseInt(runProfesional), tituloProfesional, ingresoProfesional);

				contenedor.almacenarProfesional(profesional);
				break;

			case 3:

				// agregar administrativo
				System.out.println("====== Almacenar administrativo ======");

				// Solicitar datos del administrativo

				// Solicitar nombre del administrativo
				System.out.print("Ingrese el nombre completo del Administrativo: ");
				String nombreAdministrativo = scanner.nextLine();

				// Validar longitud del nombre de administrativo
				if (!Validaciones.validaLetrasDelNombre(nombreAdministrativo)) {
					break;
				}

				// Solicitar fecha de nacimiento del administrativo
				System.out.print("Ingrese la fecha de nacimiento del Administrativo (Formato DD/MM/YYYY): ");
				String nacimientoAdministrativo = scanner.nextLine();

				// Validar fecha de nacimiento de administrativo
				if (!Validaciones.validarFecha(nacimientoAdministrativo)) {
					System.out.println("Fecha inválida");
					break;
				}

				// Solicitar run del administrativo
				System.out.print("Ingrese el RUN del Administrativo (sin puntos ni digito verificador): ");
				String runAdministrativo = scanner.nextLine();

				// Validar run del administrativo
				if (!Validaciones.validarRun(runAdministrativo)) {
					System.out.println("RUN inválido");
					break;
				}
				// Solicitar area del administrativo
				System.out.println("Ingrese el área del Administrativo: ");
				String areaAdministrativo = scanner.nextLine();

				// Validar area del administrativo
				if (!Validaciones.validarArea(areaAdministrativo)) {
					System.out.println("Área invalida.");
					break;
				}

				// Solicitar experiencia previa de administrativo
				System.out.println("Ingrese la experiencia previa del Administrativo: ");
				String experienciaAdministrativo = scanner.nextLine();

				// Validar experiencia previa de administrativo
				if (!Validaciones.validarCienCaracteres(experienciaAdministrativo)) {
					System.out.println("Experiencia previa invalida.");
					break;
				}
				Administrativo administrativo = new Administrativo(nombreAdministrativo,nacimientoAdministrativo,
						Integer.parseInt(runAdministrativo), areaAdministrativo, experienciaAdministrativo);

				contenedor.almacenarAdministrativo(administrativo);
				break;

			case 4:
				// Almacenar capacitacion
				
				// Solicitar run del cliente
				System.out.print("Ingrese el RUN del Cliente que requiere capacitación (sin puntos ni digito verificador): ");
				String runClienteCap = scanner.nextLine();

				// Validar run del cliente
				if (!Validaciones.validarRutCliente(runClienteCap, contenedor)) {
					break;
				}
				
				// Identificador de la capacitación
				System.out.println("Ingrese el identificador de la capacitacion: ");
				String identificadorCapacitacion = scanner.nextLine();

				// Validar Identificador de la capacitacion
				if (!Validaciones.validarIdentificador(identificadorCapacitacion)) {
					System.out.println("Numero incorrecto, ingrese el identificador correspondiente.");
					break;
				}
				// Fecha de la capacitacion						
				System.out.print("Ingrese la fecha de la capacitacion (Formato DD/MM/YYYY): ");
				String fechaCapacitacion = scanner.nextLine();

				// Validar Fecha de la capacitacion
				if (!Validaciones.validarFecha(fechaCapacitacion)) {
					System.out.println("Fecha inválida");
					break;
				}

				// Hora de la capacitacion
				System.out.print("Ingrese la hora de la capacitacion (Formato HH:mm): ");
				String horaCapacitacion = scanner.nextLine();

				// Validar de la capacitacion
				if (!Validaciones.validarHora(horaCapacitacion)) {
					System.out.println("Hora inválida");
					break;
				}

				// Lugar de la capacitacion
				System.out.print("Ingrese el lugar de la capacitacion: ");
				String lugarCapacitacion = scanner.nextLine();

				// Validar el lugar de la capacitacion
				if (!Validaciones.validarCincuentaCaracteres(lugarCapacitacion)) {
					System.out.println("Lugar inválido.");
					break;
				}

				// Duracion de la capacitacion
				System.out.print("Ingrese la duracion de la capacitacion: ");
				String duracionCapacitacion = scanner.nextLine();

				// Validar la duración de la capacitacion
				if (!Validaciones.validarDireccion(duracionCapacitacion)) {
					System.out.println("Duración inválida.");
					break;
				}

				// Cantidad de asistentes a la capacitación
				System.out.print("Ingrese la cantidad de asistentes a la capacitacion: ");
				String asistentesCapacitacion = scanner.nextLine();

				// Validar la Cantidad de asistentes a la capacitación
				if (!Validaciones.validarAsistentes(asistentesCapacitacion)) {
					System.out.println("Cantidad de asistentes inválida.");
					break;
				}

				Capacitacion capacitacion = new Capacitacion(Integer.parseInt(runClienteCap),
						fechaCapacitacion, horaCapacitacion, lugarCapacitacion, duracionCapacitacion, Integer.parseInt(asistentesCapacitacion));

				contenedor.almacenarCapacitacion(capacitacion);
				break;
			case 5:
				// Como eliminar un usuario
				System.out.println("Ingrese el RUN del usuario que desea eliminar (sin puntos ni digito verificador): ");
				String runEliminar = scanner.nextLine();

				// Validar run del usuario a eliminar
				if (!Validaciones.validarRun(runEliminar)) {
					System.out.println("RUN inválido, intentelo nuevamente.");
					break;
				}
				contenedor.eliminarUsuario(Integer.parseInt(runEliminar));
				break;

			case 6:
				// Listar usuarios
				contenedor.listarUsuarios();
				break;
			case 7:
				// Listar usuarios por tipos

				System.out.print("Ingrese el tipo de usuario que desea desplegar (1 para los usuarios tipo Cliente, 2 para los tipo Profesional o 3 para los tipo Administrativo): ");
				String tipoUsuario = scanner.nextLine();

				// Validar el tipo de usuario ingresado
				if (!Validaciones.revisarUsuario(tipoUsuario)) {
					System.out.println("Tipo de usuario ingresado es incorrecto.");
					break;
				}
				
				String user;
				if (Integer.parseInt(tipoUsuario) == 1) {
					user = "Cliente";
				} else if (Integer.parseInt(tipoUsuario) == 2) {user = "Profesional";}
				else {user = "Administrativo";}
				
				contenedor.listarUsuariosPorTipo(user);
				break;
			case 8:
				// Listar capacitaciones
				contenedor.listarCapacitaciones();
				break;
			case 9:
				System.out.println("Ha finalizado de ingresar datos.");
				break;
			default:
				System.out.println("Opcion invalida. Por favor, ingrese nuevamente.");
			}
		} while (opcion != 9);
		scanner.close();
	}
}
