
public class PassaFaixa_Estreita {

	private String nome;
	private double fc;
	private double fl;
	private double fh;
	private double bandWith;
		
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getFc() {
		return fc;
	}
	public void setFc(double fc) {
		this.fc = fc;
	}

	public double getFl() {
		return fl;
	}
	public void setFl(double fl) {
		this.fl = fl;
	}

	public double getFh() {
		return fh;
	}
	public void setFh(double fh) {
		this.fh = fh;
	}

	public double getBandWith() {
		return bandWith;
	}
	public void setBandWith(double bandWith) {
		this.bandWith = bandWith;
	}


	PassaFaixa_Estreita(double fc, double bandWith, String nome){
		this.nome = nome;
		this.fc = fc;
		this.bandWith = bandWith;
	}
	
	
	void constroi_filtro_PF_Estreita() {
		this.fl = Math.sqrt(((Math.pow(bandWith, 2)/4)+Math.pow(fc, 2))) - (bandWith/2);
		this.fh = this.fl - bandWith;
	}
	
	public String resposta() {
		String format = "%.8f";
		
		return "Passa Faixa - Estreita \n\n"
				+ "Frequências: \n"
				+ "Fc ou Fr: " + String.format(format, getFc()) + " Hz\n"
				+ "Fl: " + String.format(format, getFl()) + " Hz\n"
				+ "Fh: " + String.format(format, getFh()) + " Hz\n\n"
				+ "BandWith: " + String.format(format, getBandWith()) + " Hz";
	}
	
}
