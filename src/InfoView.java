/**
 * Project: EX02
 * Package: PACKAGE_NAME
 */

import javax.swing.*;
import java.awt.*;
import java.awt.dnd.DropTarget;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.util.Vector;

/**
 * InfoView Object
 * @author Nathaniel Graham
 * @version 1.0
 */
public class InfoView extends JPanel {

    private JPanel top_bar = new JPanel();
    private JPanel body = new JPanel();
    private JPanel side_bar = new JPanel();
    private JList<Person> side_bar_list = new JList<>();
    private JPanel delete_zone = new JPanel();
    private JLabel del_zone_text = new JLabel("Remove", SwingConstants.CENTER);
    private JButton back_button = new JButton("Back");
    private JList<String> info = new JList<>();

    InfoView()
    {
        this.setLayout(new BorderLayout());
        init();
    }

    private void init()
    {
        body.setLayout(new BorderLayout());
        side_bar.setLayout(new BorderLayout());
        top_bar.setLayout(new BorderLayout());
        delete_zone.setLayout(new BorderLayout());


        this.add(top_bar, BorderLayout.NORTH);
        this.add(body, BorderLayout.CENTER);
        body.add(side_bar, BorderLayout.EAST);
        body.add(info, BorderLayout.CENTER);
        side_bar.add(side_bar_list, BorderLayout.CENTER);
        side_bar.add(delete_zone, BorderLayout.SOUTH);
        top_bar.add(back_button, BorderLayout.WEST);
        delete_zone.add(del_zone_text);

        side_bar_list.setDragEnabled(true);
        delete_zone.setDropTarget(new DropTarget());

        addBorders();
        setColors();
        setSizes();
    }

    private void addBorders()
    {
        top_bar.setBorder(BorderFactory.createLineBorder(Color.black));
        body.setBorder(BorderFactory.createLineBorder(Color.black));
        side_bar.setBorder(BorderFactory.createLineBorder(Color.black));
        delete_zone.setBorder(BorderFactory.createLineBorder(Color.black));
    }

    private void setColors()
    {
        top_bar.setBackground(Color.CYAN);
        body.setBackground(Color.ORANGE);
        side_bar.setBackground(Color.MAGENTA);
        delete_zone.setBackground(Color.RED);
        //info.setBackground(Color.GREEN);
    }

    private void setSizes()
    {
        top_bar.setPreferredSize(new Dimension(-1, 30));
        side_bar.setPreferredSize(new Dimension(100, -1));
        side_bar_list.setPreferredSize(new Dimension(100,-1));
        delete_zone.setPreferredSize(new Dimension(-1, 55));
        back_button.setPreferredSize(new Dimension(75, -1));
    }

    public void populatePersonList(Vector<Person> occupants)
    {
        DefaultListModel<Person> lm = new DefaultListModel<>();
        for (Person p : occupants) {
            lm.addElement(p);
        }
        side_bar_list.setModel(lm);
    }

    public JPanel getTop_bar() {
        return top_bar;
    }

    public JPanel getBody() {
        return body;
    }

    public JPanel getSide_bar() {
        return side_bar;
    }

    public JList<Person> getSide_bar_list() {
        return side_bar_list;
    }

    public JPanel getDelete_zone() {
        return delete_zone;
    }

    public JLabel getDel_zone_text() {
        return del_zone_text;
    }

    public JButton getBack_button() {
        return back_button;
    }

    public JList getInfoPanel() {
        return info;
    }
}
