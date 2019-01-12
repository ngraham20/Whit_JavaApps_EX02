/**
 * Project: EX02
 * Package: PACKAGE_NAME
 */

import javax.swing.*;

/**
 * PersonTransferHandler Object
 * @author Nathaniel Graham
 * @version 1.0
 */
public class PersonTransferHandler extends TransferHandler {

    private Person transferData;

    public void setTransferData(Person transferData) {
        this.transferData = transferData;
    }

    public Person getTransferData()
    {
        return transferData;
    }

}
