
public class PassaAlta_1 {

	private String nome;
	private double r1;
	private double rf;
	private double c1;
	private double fc;
	
	PassaAlta_1(double fc, double c1, String nome){
		this.nome = nome;
		this.fc = fc;
		this.c1 = c1;
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

	public double getFc() {
		return fc;
	}
	public void setFc(double fc) {
		this.fc = fc;
	}

	void constroi_filtro_PA_1() {
		this.c1 = 10/this.fc;
		this.r1 = 1/(2*Math.PI*this.fc*this.c1);
		this.rf = this.r1;
	}
	
	public String resposta() {
		String format = "%.8f";
		
		return "Passa Alta - Ordem 1 (Com Ganho) \n\n"
				+ "Resistores: \n"
				+ "R1: " + String.format(format, getR1()) + " ohns\n"
				+ "RF: " + String.format(format, getRf()) + " ohns\n"
				+ "Capacitores: \n"
				+ "C1: " + String.format(format, getC1()) + "F\n\n"
				+ "Frequência de Corte: " + String.format(format, getFc()) + " Hz";
	}
}
