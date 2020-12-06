import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;

public class JFCalculo extends JFrame {

	private static final long serialVersionUID = 1L;
	
	Projeto projeto = new Projeto();
	
	private String resposta = "";
	private int index = 0;
	private String[] filtros_img = {"pa ordem 1", "pa ordem 2", "pa ordem 3", "pb ordem 1", 
							"pb ordem 2", "pb ordem 3", "pf estreita", "pf larga"};
	
	private JPanel contentPane;
	JTextArea txtResposta = new JTextArea();
	private JTextField txtNomeProj;	
	private final JLabel lblImages = new JLabel("");
	JComboBox<String> comboBox = new JComboBox<String>();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFCalculo frame = new JFCalculo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFCalculo() {
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 718, 552);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblImages.setBackground(Color.WHITE);
		
		lblImages.setIcon(null);
		lblImages.setBounds(178, 11, 518, 235);
		contentPane.add(lblImages);
		
		
		txtResposta.setBounds(178, 278, 518, 234);
		contentPane.add(txtResposta);
		
		comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {       
                index = comboBox.getSelectedIndex();    
            }
        });

        comboBox.setModel(new DefaultComboBoxModel<String>(
                new String[] {"Passa Alta - Ordem 1", 
                        "Passa Alta - Ordem 2",
                        "Passa Alta - Ordem 3",
                        "Passa Baixa - Ordem 1",
                        "Passa Baixa - Ordem 2",
                        "Passa Baixa - Ordem 3",
                        "Passa Faixa - Estreita",
                        "Passa Faixa - Larga",}));
		comboBox.setBounds(10, 73, 158, 20);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Selecione o tipo do filtro:");
		lblNewLabel_1.setBounds(10, 47, 158, 25);
		contentPane.add(lblNewLabel_1);
		
		JButton btnGerarCircuito = new JButton("Gerar Circuito");
		btnGerarCircuito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double k;
				double fc;
				double capacitor;
				double bandWith;
				String nome;
				txtResposta.setText("");
				lblImages.setIcon(new ImageIcon(JFCalculo.class.getResource("")));				

				nome = String.valueOf(JOptionPane.showInputDialog("Nome do projeto: "));
				
				do {					
					if (projeto.verificaExistenciaNome(nome)) {
						nome = String.valueOf(JOptionPane.showInputDialog("Nome de projeto ja existente!\n tente outro nome:"));
					}
				} while (projeto.verificaExistenciaNome(nome));
				
				
				switch(index){			
					case 0:
						fc = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor da frequencia de corte (Fc): "));
						capacitor = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor do capacitor (C1)\n Valor entre 0.001 e 0.1uF: "));
						PassaAlta_1 filtro_pa1 = new PassaAlta_1(fc, capacitor, nome);
						filtro_pa1.constroi_filtro_PA_1();
						resposta = filtro_pa1.resposta();
						setResposta(resposta,index);
						break;
					case 1:	
						capacitor = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor do capacitor (C1),\nValor entre 100 pF e 0.1 uF: "));
						fc = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor da frequencia de corte (fc): "));
						PassaAlta_2 filtro_pa2 = new PassaAlta_2(capacitor, fc, nome);
						filtro_pa2.constroi_filtro_PA_2();
						resposta = filtro_pa2.resposta();
						setResposta(resposta,index);
						break;
					case 2:	
						capacitor = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor do capacitor (C),\nValor entre 100 pF e 0.1 uF: "));
						fc = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor da frequencia de corte (fc): "));
						PassaAlta_3 filtro_pa3 = new PassaAlta_3(capacitor, fc, nome);
						filtro_pa3.constroi_filtro_PA_3();
						resposta = filtro_pa3.resposta();
						setResposta(resposta,index);
						break;
					case 3:
						k = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor do ganho (K): "));
						fc = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor da frequencia de corte (fc): "));
						PassaBaixa_1 filtro = new PassaBaixa_1(k, fc, nome);
						filtro.constroi_filtro_PB_1();
						resposta = filtro.resposta();
						setResposta(resposta,index);						
						break;
					case 4:
						capacitor = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor do capacitor (C1),\nEscolha um valor entre 100 pF e 0.1 uF: "));
						fc = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor da frequencia de corte (fc): "));
						PassaBaixa_2 filtro_pb2 = new PassaBaixa_2(capacitor, fc, nome);
						filtro_pb2.constroi_filtro_PB_2();
						resposta = filtro_pb2.resposta();
						setResposta(resposta,index);
						break;
					case 5:
						capacitor = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor do capacitor (C3),\nEscolha um valor entre 0.001 e 0.1 uF: "));
						fc = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor da frequencia de corte (fc): "));
						PassaBaixa_3 filtro_pb3 = new PassaBaixa_3(capacitor, fc, nome);
						filtro_pb3.constroi_filtro_PB_3();
						resposta = filtro_pb3.resposta();
						setResposta(resposta,index);
						break;
					case 6:
						fc = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor da frequencia de corte (fc): "));
						bandWith = Double.parseDouble(JOptionPane.showInputDialog("Informe a largura da banda: "));
						PassaFaixa_Estreita filtro_pf_e = new PassaFaixa_Estreita(fc, bandWith, nome);
						filtro_pf_e.constroi_filtro_PF_Estreita();
						resposta = filtro_pf_e.resposta();
						setResposta(resposta,index);
						break;
					case 7:
						fc = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor da frequencia de corte (fc): "));
						bandWith = Double.parseDouble(JOptionPane.showInputDialog("Informe a largura da banda: "));
						PassaFaixa_Larga filtro_pf_l = new PassaFaixa_Larga(fc, bandWith, nome);
						filtro_pf_l.constroi_filtro_PF_Larga();
						resposta = filtro_pf_l.resposta();
						setResposta(resposta,index);
						break;
					default:
						break;
					}
				
				projeto.adicionarProjeto(nome, index, resposta);
			}
		});
		btnGerarCircuito.setBounds(10, 104, 158, 23);
		contentPane.add(btnGerarCircuito);
		
		JLabel lblNewLabel_2 = new JLabel("Novo Projeto");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(38, 11, 130, 25);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Buscar Projeto");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(38, 161, 130, 25);
		contentPane.add(lblNewLabel_2_1);
		
		JButton btnBuscar = new JButton("Buscar Projeto");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nomeProj = txtNomeProj.getText();
				if (projeto.verificaExistenciaNome(nomeProj)) {
					setResposta(projeto.getRespostaProjeto(nomeProj),
					projeto.getImagemProjeto(nomeProj));
				}else {
					txtResposta.setText("Projeto Inexistente!!!");
				}
				
			}
		});
		btnBuscar.setBounds(10, 279, 158, 23);
		contentPane.add(btnBuscar);
		
		JLabel lblNewLabel = new JLabel("Nome do Projeto");
		lblNewLabel.setBounds(10, 231, 158, 14);
		contentPane.add(lblNewLabel);
		
		txtNomeProj = new JTextField();
		txtNomeProj.setBounds(10, 248, 158, 20);
		contentPane.add(txtNomeProj);
		txtNomeProj.setColumns(10);
		
		JButton btnListarProjeto = new JButton("Listar Projetos");
		btnListarProjeto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtResposta.setText(projeto.listarNomeProjetos());
				lblImages.setIcon(new ImageIcon(""));
			}
		});
		btnListarProjeto.setBounds(10, 197, 158, 23);
		contentPane.add(btnListarProjeto);
		
		
		
	}
		
	public void setResposta(String resposta, int index) {
		txtResposta.setText(resposta);
		lblImages.setIcon(new ImageIcon(JFCalculo.class.getResource("/image/" + filtros_img[index] + ".png")));
		comboBox.setSelectedIndex(index);
	}
}
