package ihm;


import java.awt.BorderLayout;

import outils.Param;

import javax.swing.JFrame;

public class FenetreP extends JFrame {
	private PanelOuest panelOuest = null;
	private PanelFormulaireMembre panelFormulaire = null;
	public FenetreP(){
		super();
		build();
	}	
	private void build(){
		this.setTitle(Param.TITRE_PRINCIPAL);
		this.setPreferredSize(Param.DIM_FENETREPRINCIPALE);
		panelOuest = new PanelOuest();
		this.setLayout(new BorderLayout());
		this.getContentPane().add(panelOuest,BorderLayout.WEST);
		panelFormulaire = new PanelFormulaireMembre();
		this.getContentPane().add(panelFormulaire,BorderLayout.CENTER);
		this.setVisible(true);
		this.pack();
		
	}
}
