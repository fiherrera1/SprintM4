package Sprint;

public class Revision {
	private static int contadorIdentificador = 0;
	private int identificadorRevision;
	private int identificadorVisitaTerreno;
	private String nombreRevision;
	private String detalleRevisar;
	private int estado;
	
	public Revision() {
	}

	public Revision(int identificadorVisitaTerreno, String nombreRevision,
			String detalleRevisar, int estado) {
		contadorIdentificador++;
		this.identificadorRevision = contadorIdentificador;
		this.identificadorVisitaTerreno = identificadorVisitaTerreno;
		this.nombreRevision = nombreRevision;
		this.detalleRevisar = detalleRevisar;
		this.estado = estado;
	}

	public int getIdentificadorRevision() {
		return identificadorRevision;
	}

	public void setIdentificadorRevision(int identificadorRevision) {
		this.identificadorRevision = identificadorRevision;
	}

	public int getIdentificadorVisitaTerreno() {
		return identificadorVisitaTerreno;
	}

	public void setIdentificadorVisitaTerreno(int identificadorVisitaTerreno) {
		this.identificadorVisitaTerreno = identificadorVisitaTerreno;
	}

	public String getNombreRevision() {
		return nombreRevision;
	}

	public void setNombreRevision(String nombreRevision) {
		this.nombreRevision = nombreRevision;
	}

	public String getDetalleRevisar() {
		return detalleRevisar;
	}

	public void setDetalleRevisar(String detalleRevisar) {
		this.detalleRevisar = detalleRevisar;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Revision [identificadorRevision=" + identificadorRevision + ", identificadorVisitaTerreno="
				+ identificadorVisitaTerreno + ", nombreRevision=" + nombreRevision + ", detalleRevisar="
				+ detalleRevisar + ", estado=" + estado + "]";
	}
}
