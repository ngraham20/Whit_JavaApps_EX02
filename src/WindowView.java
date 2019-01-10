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

//    private CityView cityView = new CityView();
//    private InfoView infoView = new InfoView();
//    private PersonView personView = new PersonView();
//    private JPanel city_view = cityView.getContent();
//    private JPanel building_view = infoView.getContent();
//    private JPanel person_view = personView.getContent();

    private InfoView infoView = new InfoView();
    private CityView cityView = new CityView();

    private JPanel cards = new JPanel();
    private CardLayout layout = new CardLayout();

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
        this.cards.setLayout(layout);

//        this.cards.add(city_view, "City");
//        this.cards.add(building_view, "Building");
//        this.cards.add(person_view, "Person");
        this.add(cards);
        this.cards.add(cityView, "City");
        this.cards.add(infoView, "Info");

        //this.setTitle("Building");
        this.layout.show(cards, "City");
    }



    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
