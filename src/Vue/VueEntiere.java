package Vue;

import Modele.EvenementModele;
import javax.swing.*;
import java.awt.*;

public class VueEntiere extends SujetVueInterface implements ObservateurVue {

    private JButton btnChargerImage;
    private JButton btnEnregistrerPerspective;
    private JButton btnRefaire;
    private JButton btnDefaire;
    private JButton btnChargerPerspective;
    private VueImagePrincipale vueImagePrincipale;
    private VueImagePerspective vueImagePerspective1;
    private VueImagePerspective vueImagePerspective2;

    public VueEntiere() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        vueImagePrincipale = new VueImagePrincipale();
        vueImagePerspective1 = new VueImagePerspective();
        vueImagePerspective2 = new VueImagePerspective();

        vueImagePrincipale.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        vueImagePerspective1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        vueImagePerspective2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JPanel panelBoutons = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelBoutons.setBackground(new Color(240, 240, 240));

        btnChargerImage = new JButton("Charger Image");
        btnEnregistrerPerspective = new JButton("Sauvegarder");
        btnDefaire = new JButton("Défaire");
        btnRefaire = new JButton("Refaire");
        btnChargerPerspective = new JButton("Charger Perspective");

        btnChargerImage.addActionListener(e -> {
            notifierClic(btnChargerImage);
        });
        btnEnregistrerPerspective.addActionListener(e -> {
            notifierClic(btnEnregistrerPerspective);
        });
        btnDefaire.addActionListener(e -> {
            notifierClic(btnDefaire);
        });
        btnRefaire.addActionListener(e -> {
            notifierClic(btnRefaire);
        });
        btnChargerPerspective.addActionListener(e -> {
            notifierClic(btnChargerPerspective);
        });

        panelBoutons.add(btnChargerImage);
        panelBoutons.add(btnEnregistrerPerspective);
        panelBoutons.add(btnDefaire);
        panelBoutons.add(btnRefaire);
        panelBoutons.add(btnChargerPerspective);

        add(panelBoutons, BorderLayout.NORTH);

        JPanel panelCentral = new JPanel(new GridBagLayout());
        panelCentral.setBackground(Color.BLACK);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 1.0;

        gbc.gridx = 0;
        gbc.weightx = 0.35;
        panelCentral.add(vueImagePrincipale, gbc);

        JPanel panelPerspectives = new JPanel(new GridLayout(1, 2, 0, 0));
        panelPerspectives.setBackground(Color.BLACK);
        panelPerspectives.add(vueImagePerspective1);
        panelPerspectives.add(vueImagePerspective2);

        gbc.gridx = 1;
        gbc.weightx = 0.65; // Le reste de l'espace
        panelCentral.add(panelPerspectives, gbc);

        add(panelCentral, BorderLayout.CENTER);


        JLabel labelFooter = new JLabel("Équipe201 LOG121 © 2025", SwingConstants.CENTER);
        labelFooter.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        labelFooter.setOpaque(true);
        labelFooter.setBackground(new Color(240, 240, 240));
        labelFooter.setFont(new Font("Serif", Font.BOLD, 14));

        add(labelFooter, BorderLayout.SOUTH);
    }


    @Override
    public void mettreAJour(EvenementModele modele) {
        repaint();
    }
}
