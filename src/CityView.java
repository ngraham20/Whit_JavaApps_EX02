/**
 * Project: EX02
 * Package: PACKAGE_NAME
 */

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

/**
 * CityView Object
 * @author Nathaniel Graham
 * @version 1.0
 */
public class CityView extends JPanel {

//    private JPanel top_bar = new JPanel();
//    private JPanel body = new JPanel();
//    private JPanel body_content = new JPanel();
//    private JPanel side_bar = new JPanel();
//    private JList side_bar_list = new JList();
//    private JPanel delete_zone = new JPanel();
//    private JButton back_button = new JButton();
//    private JList info = new JList();

    private JPanel top_bar = new JPanel();
    private JPanel body = new JPanel();
    private JList building_list = new JList();
    private JList person_list = new JList();

    public CityView()
    {
        this.setLayout(new BorderLayout());
        init();
    }

    private void init()
    {
        body.setLayout(new BorderLayout());
        top_bar.setLayout(new BorderLayout());

        person_list.setLayoutOrientation(JList.HORIZONTAL_WRAP);


        this.add(top_bar, BorderLayout.NORTH);
        this.add(body, BorderLayout.CENTER);
        this.add(person_list, BorderLayout.SOUTH);
        body.add(building_list, BorderLayout.CENTER);

        addBorders();
        setColors();
        setSizes();

    }

    public void populatePersonList(ArrayList<Person> citizens)
    {
        // this will populate the jlist with person buttons linking to info on the clicked person
    }

    public void populateBuildingList(ArrayList<Building> buildings)
    {
        // this will populate the jlist with building buttons linking to info on the clicked building
    }

    private void addBorders()
    {
        top_bar.setBorder(BorderFactory.createLineBorder(Color.black));
        body.setBorder(BorderFactory.createLineBorder(Color.black));
        person_list.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    private void setColors()
    {
        top_bar.setBackground(Color.CYAN);
        body.setBackground(Color.ORANGE);
        person_list.setBackground(Color.GREEN);
        building_list.setBackground(Color.ORANGE);

    }

    private void setSizes()
    {
        top_bar.setPreferredSize(new Dimension(-1, 30));
        person_list.setPreferredSize(new Dimension(-1, 40));
    }

    public JPanel getTop_bar() {
        return top_bar;
    }

    public JPanel getBody() {
        return body;
    }

    public JList getBuilding_list() {
        return building_list;
    }

    public JList getPerson_list() {
        return person_list;
    }
}
