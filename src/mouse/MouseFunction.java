package mouse;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import agenda.ScreenAgendaa;
import medico.ScreenMedico;
import paciente.ScreenPaciente;
import principal.MenuPrincipal;

public class MouseFunction extends MouseAdapter {

	private JPanel painel;

	// telas
	private MenuPrincipal telaPrincipal = null; // instanciado como nulo para saber se foi instanciada
	private ScreenMedico Medicos = null;
	private ScreenPaciente menu_Paciente = null;
	private ScreenAgendaa screenAgenda = null;

	private String tipo;
	public Color c;
	public Connection con;

	// sobrcarregando os construtores para instanciar de diversas telas
	public MouseFunction(JPanel fundoProfi, String tipo, MenuPrincipal telaPrincipal, Connection con) {
		painel = fundoProfi;
		this.tipo = tipo;
		this.telaPrincipal = telaPrincipal;
		this.con = con;
	}

	public MouseFunction(JPanel painelPaciente, String tipo2, ScreenMedico tela_Profissional, Connection con) {

		painel = painelPaciente;
		this.tipo = tipo2;
		this.Medicos = tela_Profissional;
		this.con = con;
	}

	public MouseFunction(JPanel painelMedico, String tipo2, ScreenPaciente menu_Paciente, Connection con) {

		painel = painelMedico;
		this.tipo = tipo2;
		this.menu_Paciente = menu_Paciente;
		this.con = con;
	}

	public MouseFunction(JPanel painelMedico, String tipo2, ScreenAgendaa screenAgenda, Connection con) {

		painel = painelMedico;
		this.tipo = tipo2;
		this.con = con;
		this.screenAgenda = screenAgenda;

	}

	// Escutador de click
	@Override
	public void mouseClicked(MouseEvent e) {
		ChamaTela_do_Menu();

	}

	// Volta a cor padr�o quando o mouse sair do objeto
	@Override
	public void mouseExited(MouseEvent e) {

		painel.setBackground(c);

	}

	// Faz anima��o ao passar o mouse
	@Override
	public void mouseEntered(MouseEvent e) {

//Vai mudar todas as cores que nao forem amarelo (no caso que nao estja 
		if (painel.getBackground() == Color.white) {
			painel.setBackground(new Color(224, 255, 255));

			c = Color.white;

		}

		else {

			c = new Color(240, 248, 255);

		}

	}

	public void ChamaTela_do_Menu() {
		if (tipo.equals("medico")) {

			ScreenMedico kk = new ScreenMedico(con);
			kk.setLocationRelativeTo(null);

			kk.setExtendedState(Frame.MAXIMIZED_BOTH);

			kk.setVisible(true);

			FecharJframeATual(); // Metodo verifica quem instanciou e fecha o mesmo

		} else if (tipo.equals("paciente")) {
			System.out.println("Paciente");

			ScreenPaciente pacientes = new ScreenPaciente(con);
			pacientes.setVisible(true);
			FecharJframeATual();

		}

		else if (tipo.equals("consulta")) {
			System.out.println("Consulta");

			ScreenAgendaa pacientes = new ScreenAgendaa(con);
			pacientes.setVisible(true);
			FecharJframeATual();

		}

		else if (tipo.equals("fechar")) {

			int i = JOptionPane.showConfirmDialog(null, "Deseja Encerrar o programa?", "Finalizar",
					JOptionPane.OK_CANCEL_OPTION);

			if (i == JOptionPane.YES_OPTION) {
				System.out.println("Clicou em Sim");

				FecharJframeATual();

			} else if (i == JOptionPane.CANCEL_OPTION) {

				System.out.println("Clicou em N�o");

			}
		}

	}

	// varias jframes vao ter acesso, como eu nao sei qual vai ser vou fazer um
	// retorno, caso retorne a propria tela fecha
	public void FecharJframeATual() {

		if (telaPrincipal != null) {

			telaPrincipal.dispose();
			// se ela nao for nula, significa que ela ja foi instanciada ent�o � ela queem
			// deve ser fechada

		}

		else if (Medicos != null) {
			Medicos.dispose();

		}

		else if (menu_Paciente != null) {

			menu_Paciente.dispose();
		}

		else if (screenAgenda != null) {

			screenAgenda.dispose();
		}

	}

}
