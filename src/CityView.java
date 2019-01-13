/**
 * Project: EX02
 * Package: PACKAGE_NAME
 */

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.dnd.DropTarget;
import java.util.ArrayList;
import java.util.Vector;

/**
 * CityView Object
 * @author Nathaniel Graham
 * @version 1.0
 */
public class CityView extends JPanel {

    private JPanel top_bar = new JPanel();
    private JPanel body = new JPanel();
    private JList<Building> building_list = new JList<>();
    private JList<Person> person_list = new JList<>();
    private JScrollPane leftScroll;
    private JScrollPane rightScroll;
    private JSplitPane splitPane;

    /** Default constructor */
    public CityView()
    {
        this.setLayout(new BorderLayout());
        init();
    }

    /** Initialize variables and objects */
    private void init()
    {
        body.setLayout(new BorderLayout());
        top_bar.setLayout(new BorderLayout());

        person_list.setLayoutOrientation(JList.VERTICAL);
        building_list.setLayoutOrientation(JList.VERTICAL);

        leftScroll = new JScrollPane(building_list,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        rightScroll = new JScrollPane(person_list,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftScroll, rightScroll);
        splitPane.setDividerLocation(0.5);



        this.add(top_bar, BorderLayout.NORTH);
        this.add(body, BorderLayout.CENTER);
        body.add(splitPane);

        addBorders();
        setColors();
        setSizes();

        person_list.setDragEnabled(true);
        building_list.setDropTarget(new DropTarget());

    }

    /**
     * Populate the view's person list
     * @param citizens a Vector of Person objects to populate the list with
     */
    public void populatePersonList(Vector<Person> citizens)
    {
        // this will populate the jlist with person buttons linking to info on the clicked person
        DefaultListModel<Person> lm = new DefaultListModel<>();
        for (Person p : citizens) {
            lm.addElement(p);
        }
        person_list.setModel(lm);
    }

    /**
     * Populate the view's building list
     * @param buildings a Vector of Building Objects to populate the list with
     */
    public void populateBuildingList(Vector<Building> buildings)
    {
        // this will populate the jlist with building buttons linking to info on the clicked building
        DefaultListModel<Building> lm = new DefaultListModel<>();
        for (Building b : buildings) {
            lm.addElement(b);
        }
        building_list.setModel(lm);
    }

    /** Adds borders to the jcomponents */
    private void addBorders()
    {
        top_bar.setBorder(BorderFactory.createLineBorder(Color.black));
        body.setBorder(BorderFactory.createLineBorder(Color.black));
        person_list.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    /** Sets the colors of the jComponents */
    private void setColors()
    {
        top_bar.setBackground(Color.CYAN);
        body.setBackground(Color.RED);
        person_list.setBackground(Color.GREEN);
        building_list.setBackground(Color.ORANGE);

    }

    /** Sets the sizes of the jComponents */
    private void setSizes()
    {
        top_bar.setPreferredSize(new Dimension(-1, 30));
    }

    /**
     * Returns the top_bar
     * @return the top_bar JPanel
     */
    public JPanel getTop_bar() {
        return top_bar;
    }

    /**
     * Returns the body content
     * @return the body JPanel
     */
    public JPanel getBody() {
        return body;
    }

    /**
     * returns the list of buildings
     * @return a JList of Building Objects
     */
    public JList<Building> getBuilding_list() {
        return building_list;
    }

    /**
     * Returns the list of people
     * @return a JList of Person objects
     */
    public JList<Person> getPerson_list() {
        return person_list;
    }
}
