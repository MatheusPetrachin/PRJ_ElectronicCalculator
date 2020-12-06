import java.util.ArrayList;
import java.util.Iterator;

public class Projeto {
	
	private ArrayList<Projeto> listaDeProjetos;
	private String nome;
	private int filtros_img_index;
	private String resposta;
		
	public Projeto(String nome, int filtros_img_index, String resposta) {
		this.nome = nome;
		this.filtros_img_index = filtros_img_index;
		this.resposta = resposta;
	}

	public Projeto() {
		listaDeProjetos = new ArrayList<Projeto>();
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getFiltros_img_index() {
		return filtros_img_index;
	}
	public void setFiltros_img_index(int filtros_img_index) {
		this.filtros_img_index = filtros_img_index;
	}

	public String getResposta() {
		return resposta;
	}
	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
	
	public Boolean verificaExistenciaNome(String nomeProj) {
		Iterator<Projeto> achaProjetoNaLista = listaDeProjetos.iterator();
		Projeto projeto;
		Boolean existe = false;
		
		while(achaProjetoNaLista.hasNext()) {
			projeto = achaProjetoNaLista.next();
			
			String nomeProjeto = projeto.getNome();
			if (nomeProjeto.equals(nomeProj)) {
				existe = true;
				return existe;
			}
		}	
		return existe;
	}
	
	public String getRespostaProjeto(String nomeProj) {
		Iterator<Projeto> achaProjetoNaLista = listaDeProjetos.iterator();
		Projeto projeto;
		String saida = "";
		
		while(achaProjetoNaLista.hasNext()) {
			projeto = achaProjetoNaLista.next();
			
			String nomeProjeto = projeto.getNome();
			if (nomeProjeto.equals(nomeProj)) {
				return projeto.getResposta();
			}
		}	
		return saida;
	}
	
	public int getImagemProjeto(String nomeProj) {
		Iterator<Projeto> achaProjetoNaLista = listaDeProjetos.iterator();
		Projeto projeto;
		int index = 0;
		
		while(achaProjetoNaLista.hasNext()) {
			projeto = achaProjetoNaLista.next();
			
			String nomeProjeto = projeto.getNome();
			if (nomeProjeto.equals(nomeProj)) {
				return projeto.getFiltros_img_index();
			}
		}	
		return index;
	}
	
	public void adicionarProjeto(String nome, int filtros_img_index, String resposta) {
		Projeto projeto = new Projeto(nome, filtros_img_index, resposta);
		listaDeProjetos.add(projeto);
	}
	
	public String listarNomeProjetos() {
		Iterator<Projeto> achaProjetoNaLista = listaDeProjetos.iterator();
		Projeto projeto;
		String saida = "Lista de Projetos \n\n";
		
		while(achaProjetoNaLista.hasNext()) {
			projeto = achaProjetoNaLista.next();
			saida += projeto.getNome() + "\n";			
		}	
		
		return saida;
	}
	
}
