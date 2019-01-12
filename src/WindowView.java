/**
 * Project: EX02
 * Package: PACKAGE_NAME
 */

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TooManyListenersException;
import java.util.Vector;

/**
 * WindowView Object
 * @author Nathaniel Graham
 * @version 1.0
 */
public class WindowView extends JFrame implements ActionListener {

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

        testScrolls();

        controller = new CityController(this);

        eventListeners();
    }

    private void testScrolls()
    {
        // --- occupants of a building ---
        Vector<Person> occupants = new Vector<>();
        occupants.add(new Kid("Charlie", 5));
        occupants.add(new Kid("Jameson", 7));
        occupants.add(new Kid("Lily", 9));
        occupants.add(new Kid("Susan", 4));
        occupants.add(new Kid("Matthew", 5));
        occupants.add(new Kid("Barey", 3));
        occupants.add(new Kid("Sara", 9));
        occupants.add(new Kid("Karisa", 3));
        occupants.add(new Kid("Katie", 5));
        occupants.add(new Kid("Jack", 7));
        occupants.add(new Kid("Justin", 9));
        occupants.add(new Kid("Sally", 4));
        occupants.add(new Kid("Drew", 5));
        occupants.add(new Kid("Andrew", 3));
        occupants.add(new Kid("Juaqin", 9));
        occupants.add(new Kid("Quill", 3));
        occupants.add(new Kid("Ali", 5));
        occupants.add(new Kid("Barb", 7));
        occupants.add(new Kid("Chunk", 9));
        occupants.add(new Kid("Mikey", 4));
        occupants.add(new Kid("Data", 5));
        occupants.add(new Kid("Smalls", 3));
        occupants.add(new Kid("Thomas", 9));
        occupants.add(new Kid("Nate", 3));

        //infoView.populatePersonList(occupants);

        Vector<Building> buildings = new Vector<>();
        buildings.add(new GenericBuilding("Holmes", "221 Baker St."));
        buildings.add(new GenericBuilding("Graham", "240 N. 5th St."));
        buildings.add(new School("Whitworth University", "300 W. Hawthorne Rd."));

        buildings.elementAt(2).addOccupants(occupants);

        cityView.populateBuildingList(buildings);
        cityView.populatePersonList(occupants);

    }

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
                    }

                    // TODO cityController should now remove that person from the building information too
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

                    // TODO implement with controller too
                }
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
            }
        });

        // --- INFO VIEW END ---

        // --- CITY VIEW BEGIN ---

        cityView.getPerson_list().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO open info panel on person
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                // TODO register who's been dragged with a selection event
            }
        });

        cityView.getBuilding_list().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO open info panel on building
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
                    // TODO remove person from person list
                    // TODO add person to building occupancy
                }
            });
        } catch (TooManyListenersException e) {
            e.printStackTrace();
        }

        // --- CITY VIEW END ---
    }

    void setView(String view)
    {
        this.previousView = currentView;
        this.layout.show(cards, view);
        this.currentView = view;
    }

    void init()
    {
        controller.createCity();
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
