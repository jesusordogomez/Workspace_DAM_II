package Banco_PALASACA;
import java.util.*;

public class PRESTAMOS extends PRODUCTOS_BANCARIOS implements I_Prestamos {
	
	//Atributos
	protected Double saldo_solicitado;
	protected Date plazo_devolución;
	protected Double intereses_mensuales;
	protected Double intereses_anuales;
	protected Date fecha_revision;
	protected Date fecha_solicitud;
	protected boolean finalizado;
	
	
	//Metodos
	public double getSaldo_solicitado() {
		return saldo_solicitado;
	}
	protected void setSaldo_solicitado(double saldo_solicitado) {
		this.saldo_solicitado = saldo_solicitado;
	}
	public Date getPlazo_devolución() {
		return plazo_devolución;
	}
	protected void setPlazo_devolución(Date plazo_devolución) {
		this.plazo_devolución = plazo_devolución;
	}
	public double getIntereses_mensuales() {
		return intereses_mensuales;
	}
	protected void setIntereses_mensuales(double intereses_mensuales) {
		this.intereses_mensuales = intereses_mensuales;
	}
	public double getIntereses_anuales() {
		return intereses_anuales;
	}
	protected void setIntereses_anuales(double intereses_anuales) {
		this.intereses_anuales = intereses_anuales;
	}
	public Date getFecha_revision() {
		return fecha_revision;
	}
	protected void setFecha_revision(Date fecha_revision) {
		this.fecha_revision = fecha_revision;
	}
	public Date getFecha_solicitud() {
		return fecha_solicitud;
	}
	protected void setFecha_solicitud(Date fecha_solicitud) {
		this.fecha_solicitud = fecha_solicitud;
	}
	public boolean isFinalizado() {
		return finalizado;
	}
	protected void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}
	
	
}