/**
 * Project: EX02
 * Package: PACKAGE_NAME
 */

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * BuildingButton Object
 * @author Nathaniel Graham
 * @version 1.0
 */
public class BuildingButton extends JButton {

    private Building building;

    public Building getBuilding()
    {
        return this.building;
    }

    public void setBuilding(Building building)
    {
        this.building = building;
    }

    // the action listener on this button should return the building for the controller to work with
}
