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
        setView("Info");

        controller = new CityController(this);


        // create random info panel with occupants

        Vector<Person> occupants = new Vector<>();
        occupants.add(new Kid("Charlie", 5));
        occupants.add(new Kid("Jameson", 7));
        occupants.add(new Kid("Lily", 9));
        occupants.add(new Kid("Susan", 4));
        occupants.add(new Kid("Matthew", 5));
        occupants.add(new Kid("Barey", 3));
        occupants.add(new Kid("Sara", 9));
        occupants.add(new Kid("Karisa", 3));

        infoView.populatePersonList(occupants);

        eventListeners();
    }

    private void eventListeners()
    {
        infoView.getBack_button().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setView("City");
            }
        });

        infoView.getSide_bar_list().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting())
                {
                    Person person = infoView.getSide_bar_list().getSelectedValue();
                    System.out.println("Person Selected: " + person.toString());

                    DefaultListModel<String> iList = new DefaultListModel<>();

                    iList.addElement("NAME: " + person.getName());
                    iList.addElement("DESIGNATION: " + person.getDesignation());
                    iList.addElement("AGE: " + person.getAge());

                    if (person.getPhone() != -1)
                    {
                        iList.addElement("PHONE: " + person.getPhone());
                    }

                    infoView.getInfoPanel().setModel(iList);

                    // TODO add more info as needed
                }
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
                        System.out.println("Person removed: " + person.toString());
                    }

                    // TODO finish removal
                }
            });
        } catch (TooManyListenersException e) {
            e.printStackTrace();
        }
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
