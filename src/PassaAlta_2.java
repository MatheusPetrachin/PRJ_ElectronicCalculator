
public class PassaAlta_2 {

	private String nome;
	private double r1;
	private double r2;
	private double rf;
	private double c1;
	private double c2;
	private double fc;
	
	PassaAlta_2(double c1, double fc,String nome){
		this.nome = nome;
		this.c1 = c1;
		this.fc = fc;
	}	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
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

	public double getRf() {
		return rf;
	}
	public void setRf(double rf) {
		this.rf = rf;
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

	public double getFc() {
		return fc;
	}
	public void setFc(double fc) {
		this.fc = fc;
	}

	void constroi_filtro_PA_2() {
		this.r1 = 1.414/(2*Math.PI*this.fc*this.c1);
		this.r2 = this.r1/2;
		this.rf = this.r1;
		this.c2 = this.c1;
	}
	
	public String resposta() {
		String format = "%.4f";
		
		return "Passa Alta - Ordem 2 \n\n"
				+ "Resistores: \n"
				+ "R1: " + String.format(format, getR1()) + " ohns\n"
				+ "R2: " + String.format(format, getR2()) + " ohns\n"
				+ "Rf: " + String.format(format, getRf()) + " ohns\n\n"
				+ "Capacitores: \n"
				+ "C1: " + String.format(format, getC1()) + " F\n"
				+ "C2: " + String.format(format, getC2()) + " F\n\n"
				+ "Frequência de Corte: " + String.format(format, getFc()) + " Hz";
	}
	
}
