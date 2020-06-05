package com.rentacar.car_service.dto;

public class AutomobilDTO {

	private MarkaAutaDTO markaAuta;
	private ModelAutaDTO modelAuta;
	private KlasaAutaDTO klasaAuta;
	private VrstaGorivaDTO vrstaGoriva;
	private TipMenjacaDTO tipMenjaca;
	private double kilometraza;
	private double dozvoljenaKilometraza;
	private boolean cdw;
	private int decijaSedista;

	public AutomobilDTO() {
	}

	public MarkaAutaDTO getMarkaAuta() {
		return markaAuta;
	}

	public void setMarkaAuta(MarkaAutaDTO markaAuta) {
		this.markaAuta = markaAuta;
	}

	public ModelAutaDTO getModelAuta() {
		return modelAuta;
	}

	public void setModelAuta(ModelAutaDTO modelAuta) {
		this.modelAuta = modelAuta;
	}

	public KlasaAutaDTO getKlasaAuta() {
		return klasaAuta;
	}

	public void setKlasaAuta(KlasaAutaDTO klasaAuta) {
		this.klasaAuta = klasaAuta;
	}

	public VrstaGorivaDTO getVrstaGoriva() {
		return vrstaGoriva;
	}

	public void setVrstaGoriva(VrstaGorivaDTO vrstaGoriva) {
		this.vrstaGoriva = vrstaGoriva;
	}

	public TipMenjacaDTO getTipMenjaca() {
		return tipMenjaca;
	}

	public void setTipMenjaca(TipMenjacaDTO tipMenjaca) {
		this.tipMenjaca = tipMenjaca;
	}

	public double getKilometraza() {
		return kilometraza;
	}

	public void setKilometraza(double kilometraza) {
		this.kilometraza = kilometraza;
	}

	public double getDozvoljenaKilometraza() {
		return dozvoljenaKilometraza;
	}

	public void setDozvoljenaKilometraza(double dozvoljenaKilometraza) {
		this.dozvoljenaKilometraza = dozvoljenaKilometraza;
	}

	public boolean isCdw() {
		return cdw;
	}

	public void setCdw(boolean cdw) {
		this.cdw = cdw;
	}

	public int getDecijaSedista() {
		return decijaSedista;
	}

	public void setDecijaSedista(int decijaSedista) {
		this.decijaSedista = decijaSedista;
	}

}
