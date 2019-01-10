/**
 * Project: EX02
 * Package: PACKAGE_NAME
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * WindowView Object
 * @author Nathaniel Graham
 * @version 1.0
 */
public class WindowView extends JFrame implements ActionListener {

    private CityView cityView = new CityView();
    private BuildingView buildingView = new BuildingView();
    private PersonView personView = new PersonView();
    private JPanel city_view = cityView.getContent();
    private JPanel building_view = buildingView.getContent();
    private JPanel person_view = personView.getContent();

    private JPanel cards;
    private CardLayout layout;

    public static void main(String[] args)
    {
        WindowView mainWindow = new WindowView();
    }

    private WindowView()
    {
        super();
        this.setSize(600, 400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

        // Setup JPanels from views


        this.cards = new JPanel();
        this.add(cards);


        this.cards.add(city_view, "City");
        this.cards.add(building_view, "Building");
        this.cards.add(person_view, "Person");

        this.layout = new CardLayout();
        this.cards.setLayout(layout);
        this.setTitle("Building");
        this.layout.show(cards, "Building");
    }



    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
