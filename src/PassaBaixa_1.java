
public class PassaBaixa_1 {
	
	private String nome;
	private double k;
	private double r1;
	private double r2;
	private double r3;
	private double c1;
	private double fc;
	
	PassaBaixa_1(double k, double fc, String nome){
		this.nome = nome;
		this.k = k;
		this.fc = fc;
	}
	
	public double getK() {
		return k;
	}

	public void setK(double k) {
		this.k = k;
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

	public double getFc() {
		return fc;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setFc(double fc) {
		this.fc = fc;
	}
	
	public String getKstr() {
		String result = String.format("%.3f", this.k);
		return result;
	}
	
	void constroi_filtro_PB_1() {
		this.c1 = 10/this.fc;
		this.r1 = 1/(2*Math.PI*this.fc*this.c1);
		this.r2 = (this.k/(this.k-1))*this.r1;
		this.r3 = this.k*this.r1;
	}
	
	public String resposta() {
		String format = "%.8f";
		
		return "Passa Baixa - Ordem 1 (Com Ganho) \n\n"
				+ "Resistores: \n"
				+ "R1: " + String.format(format, getR1()) + " ohns\n"
				+ "R2: " + String.format(format, getR2()) + " ohns\n"
				+ "R3: " + String.format(format, getR3()) + " ohns\n\n"
				+ "Capacitores: \n"
				+ "C1: " + String.format(format, getC1()) + "F"
				+ "Frequência de Corte: " + String.format(format, getFc()) + " Hz";
	}

}
