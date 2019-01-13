/**
 * Project: EX02
 * Package: PACKAGE_NAME
 */

import javax.swing.*;
import java.awt.*;
import java.awt.dnd.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.TooManyListenersException;
import java.util.Vector;

/**
 * WindowView Object
 * @author Nathaniel Graham
 * @version 1.0
 */
public class WindowView extends JFrame {

    private CityController controller = new CityController();

    private InfoView infoView = new InfoView();
    private CityView cityView = new CityView();

    private String previousView;
    private String currentView = null;

    private JPanel cards = new JPanel();
    private CardLayout layout = new CardLayout();

    private TransferHandler handler = new TransferHandler(null);

    public static void main(String[] args)
    {
        WindowView mainWindow = new WindowView();
    }

    /**
     * Default Constructor
     */
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
        setView("City");

        controller = new CityController(this);

        testScrolls();

        eventListeners();
    }

    /** Populates the window with some data to test and see */
    private void testScrolls()
    {
        // --- citizens of a building ---
        Vector<Person> citizens = new Vector<>();
        citizens.add(new Kid("Charlie", 5));
        citizens.add(new Kid("Jameson", 7));
        citizens.add(new Kid("Lily", 9));
        citizens.add(new Kid("Susan", 4));
        citizens.add(new Kid("Matthew", 5));
        citizens.add(new Kid("Barey", 3));
        citizens.add(new Kid("Sara", 9));
        citizens.add(new Kid("Karisa", 3));
        citizens.add(new Kid("Katie", 5));
        citizens.add(new Kid("Jack", 7));
        citizens.add(new Kid("Justin", 9));
        citizens.add(new Kid("Sally", 4));
        citizens.add(new Kid("Drew", 5));
        citizens.add(new Kid("Andrew", 3));
        citizens.add(new Kid("Juaqin", 9));
        citizens.add(new Kid("Quill", 3));
        citizens.add(new Kid("Ali", 5));
        citizens.add(new Kid("Barb", 7));
        citizens.add(new Kid("Chunk", 9));
        citizens.add(new Kid("Mikey", 4));
        citizens.add(new Kid("Data", 5));
        citizens.add(new Kid("Smalls", 3));
        citizens.add(new Kid("Thomas", 9));
        citizens.add(new Kid("Nate", 3));
        citizens.add(new Police("Bruce", 35, Police.Role.Sargent, 4083902198L));
        citizens.add(new Teacher("Donna", 29, 4086459270L));

        //infoView.populatePersonList(citizens);

        Vector<Building> buildings = new Vector<>();
        buildings.add(new GenericBuilding("Holmes", "221 Baker St."));
        buildings.add(new GenericBuilding("Graham", "240 N. 5th St."));
        buildings.add(new School("Whitworth University", "300 W. Hawthorne Rd."));
        buildings.add(new CityHall("City Hall", "123 N. 1st St."));

        controller.setBuildings(buildings);
        controller.setCitizens(citizens);

        //buildings.elementAt(2).addOccupants(citizens);

        cityView.populateBuildingList(buildings);
        cityView.populatePersonList(citizens);

    }

    /** Triggers all of the event listeners in the View from centralized source */
    private void eventListeners()
    {
        // --- INFO VIEW BEGIN ---

        infoView.getBack_button().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setView("City");
            }
        });

        try {
            infoView.getDelete_zone().getDropTarget().addDropTargetListener(new DropTargetListener() {
                @Override
                public void dragEnter(DropTargetDragEvent dtde) {

                }

                @Override
                public void dragOver(DropTargetDragEvent dtde) {

                }

                @Override
                public void dropActionChanged(DropTargetDragEvent dtde) {

                }

                @Override
                public void dragExit(DropTargetEvent dte) {

                }

                @Override
                public void drop(DropTargetDropEvent dtde) {
                    // the item dropped has been selected
                    Person person = infoView.getSide_bar_list().getSelectedValue();

                    if (person != null)
                    {
                        DefaultListModel<Person> occupants = (DefaultListModel) infoView.getSide_bar_list().getModel();
                        occupants.removeElement(person);
                        System.out.println("Person removed: " + person.toString());

                        // add person back to cityView's list
                        DefaultListModel<Person> citizens = (DefaultListModel) cityView.getPerson_list().getModel();
                        citizens.addElement(person);
                    }

                    Building building = cityView.getBuilding_list().getSelectedValue();
                    controller.removePersonFromBuilding(building, person);

                }
            });
        } catch (TooManyListenersException e) {
            e.printStackTrace();
        }

        infoView.getSide_bar_list().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JList list = (JList) e.getSource();

                if (e.getClickCount() == 1)
                {
                    Person person = infoView.getSide_bar_list().getSelectedValue();
                    if (person != null) {
                        System.out.println("Person Selected: " + person.toString());

                        DefaultListModel<String> iList = new DefaultListModel<>();

                        iList.addElement("NAME: " + person.getName());
                        iList.addElement("DESIGNATION: " + person.getDesignation());
                        iList.addElement("AGE: " + person.getAge());

                        if (person.getPhone() != -1) {
                            iList.addElement("PHONE: " + person.getPhone());
                        }

                        infoView.getInfoPanel().setModel(iList);
                    }
                }
            }
        });

        // --- INFO VIEW END ---

        // --- CITY VIEW BEGIN ---

        cityView.getPerson_list().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JList list = (JList) e.getSource();

                if (e.getClickCount() == 1)
                {
                    Person person = cityView.getPerson_list().getSelectedValue();
                    if (person != null) {
                        System.out.println("Person Selected: " + person.toString());

                        setView("Info");

                        DefaultListModel<String> iList = new DefaultListModel<>();

                        iList.addElement("NAME: " + person.getName());
                        iList.addElement("DESIGNATION: " + person.getDesignation());

                        if (person instanceof Police)
                        {
                            iList.addElement("ROLE: " + ((Police) person).getRole());
                        }

                        iList.addElement("AGE: " + person.getAge());

                        if (person.getPhone() != -1) {
                            iList.addElement("PHONE: " + person.getPhone());
                        }

                        infoView.getInfoPanel().setModel(iList);
                        infoView.getSide_bar_list().setModel(new DefaultListModel<>());
                    }
                }
            }
        });

        cityView.getBuilding_list().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JList list = (JList) e.getSource();

                if (e.getClickCount() == 1)
                {
                    Building building = cityView.getBuilding_list().getSelectedValue();
                    if (building != null) {
                        System.out.println("Building Selected: " + building.toString());

                        setView("Info");

                        DefaultListModel<String> iList = new DefaultListModel<>();

                        iList.addElement("NAME: " + building.getName());
                        iList.addElement("DESIGNATION: " + building.getDesignation());
                        iList.addElement("ADDRESS: " + building.getAddress());

                        if(building instanceof School)
                        {
                            int numTeachers = 0;
                            int numKids = 0;
                            for (Person person : building.getOccupants())
                            {
                                if (person instanceof Teacher)
                                {
                                    numTeachers++;
                                }
                                if (person instanceof Kid)
                                {
                                    numKids++;
                                }
                            }
                            iList.addElement("NUMBER OF TEACHERS: " + Integer.toString(numTeachers));
                            iList.addElement("NUMBER OF KIDS: " + Integer.toString(numKids));
                        }

                        if(building instanceof CityHall)
                        {
                            // list how many officers
                            int numOfficers = 0;
                            for(Person person : building.getOccupants())
                            {
                                if (person instanceof Police)
                                {
                                    numOfficers++;
                                }
                            }
                            iList.addElement("NUMBER OF OFFICERS: " + Integer.toString(numOfficers));
                        }

                        infoView.getInfoPanel().setModel(iList);

//                        DefaultListModel<Person> pList = new DefaultListModel<>();
//
//                        if (building.getOccupants() != null)
//                        {
//                            for(Person p : building.getOccupants())
//                            {
//                                pList.addElement(p);
//                            }
//                        }
//
//                        infoView.getSide_bar_list().setModel(pList);
                        infoView.populatePersonList(building.getOccupants());
                    }
                }
            }
        });

        try {
            cityView.getBuilding_list().getDropTarget().addDropTargetListener(new DropTargetListener() {
                @Override
                public void dragEnter(DropTargetDragEvent dtde) {

                }

                @Override
                public void dragOver(DropTargetDragEvent dtde) {

                }

                @Override
                public void dropActionChanged(DropTargetDragEvent dtde) {

                }

                @Override
                public void dragExit(DropTargetEvent dte) {

                }

                @Override
                public void drop(DropTargetDropEvent dtde) {

                    // the item dropped has been selected
                    Person person = cityView.getPerson_list().getSelectedValue();

                    if (person != null)
                    {
                        DefaultListModel<Person> occupants = (DefaultListModel) cityView.getPerson_list().getModel();
                        occupants.removeElement(person);
                        System.out.println("Person removed: " + person.toString());
                    }

                    // add person to building list
                    int index = cityView.getBuilding_list().locationToIndex(dtde.getLocation());

                    Building building = controller.getCity().getBuildings().elementAt(index);
                    controller.addPersonToBuilding(building, person);
                }
            });
        } catch (TooManyListenersException e) {
            e.printStackTrace();
        }

        // --- CITY VIEW END ---
    }

    /**
     * Sets the current card view
     * @param view the view to switch to
     */
    void setView(String view)
    {
        this.previousView = currentView;
        this.layout.show(cards, view);
        this.currentView = view;
    }
}
