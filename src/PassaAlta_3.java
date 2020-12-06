
public class PassaAlta_3 {
	
	private String nome;
	private double r1;
	private double r2;
	private double r3;
	private double c1;
	private double c2;
	private double c3;
	private double fc;
	private double rf;
	private double rf2;
	
	PassaAlta_3(double c, double fc, String nome){
		this.c1 = c;
		this.c2 = c;
		this.c3 = c;
		this.fc = fc;
		this.nome = nome;
	}	
	
	public double getR1() {
		return r1;
	}
	public void setR1(double r1) {
		this.r1 = r1;
	}

	public double getR2() {
		return r2;
	}
	public void setR2(double r2) {
		this.r2 = r2;
	}

	public double getR3() {
		return r3;
	}
	public void setR3(double r3) {
		this.r3 = r3;
	}

	public double getC1() {
		return c1;
	}
	public void setC1(double c1) {
		this.c1 = c1;
	}

	public double getC2() {
		return c2;
	}
	public void setC2(double c2) {
		this.c2 = c2;
	}

	public double getC3() {
		return c3;
	}
	public void setC3(double c3) {
		this.c3 = c3;
	}

	public double getFc() {
		return fc;
	}
	public void setFc(double fc) {
		this.fc = fc;
	}

	public double getRf() {
		return rf;
	}
	public void setRf(double rf) {
		this.rf = rf;
	}

	public double getRf2() {
		return rf2;
	}
	public void setRf2(double rf2) {
		this.rf2 = rf2;
	}

	void constroi_filtro_PA_3() {
		this.r3 = 1/(2*Math.PI*this.fc*this.c3);
		this.r1 = 2*r3;
		this.r2 = 0.5*this.r3;
		this.rf = this.r1;
		this.rf2 = this.r3;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String resposta() {
		String format = "%.8f";
		
		return "Passa Alta - Ordem 3 \n\n"
				+ "Resistores: \n"
				+ "R1: " + String.format(format, getR1()) + " ohns\n"
				+ "R2: " + String.format(format, getR2()) + " ohns\n"
				+ "R3: " + String.format(format, getR3()) + " ohns\n"
				+ "Rf: " + String.format(format, getRf()) + " ohns\n"
				+ "Rf2: " + String.format(format, getRf2()) + " ohns\n\n"
				+ "Capacitores: \n"
				+ "C1: " + String.format(format, getC1()) + "F\n"
				+ "C2: " + String.format(format, getC2()) + "F\n"
				+ "C3: " + String.format(format, getC3()) + "F\n\n"
				+ "Frequência de Corte: " + String.format(format, getFc()) + " Hz";
	}

}
