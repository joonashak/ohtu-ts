/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.ts.ui;

import ohtu.ts.domain.ReadingTip;
import ohtu.ts.domain.Types;
import ohtu.ts.io.IO;
import ohtu.ts.services.ReadingTipService;

/**
 *
 * @author Arttu Mykkänen <arttu.mykkanen@outlook.com>, Joonas Häkkinen
 */
public class TextUI {

    private final IO io;
    private final ReadingTipService rtService;
    private final TerminalWrapper terminal;

    public TextUI(IO io, ReadingTipService rtService, TerminalWrapper term) {
        this.io = io;
        this.rtService = rtService;
        this.terminal = term;
    }

    public void run() {
        while (true) {
            // Loop over until correct command received (switch cannot handle null).
            Commands cmd = null;
            while (cmd == null) {
                cmd = Prompts.getCommandFromUser(io);
            }

            switch (cmd) {
                case ADD: {
                    if (!commandAdd()) {
                        // something wrong
                    }
                    break;
                }
                case LIST_ALL: {
                    ListUI listUi = new ListUI(io, terminal);
                    listUi.show();
                    break;
                }
                case QUIT: {
                    return;
                }
            }
        }
    }

    private boolean commandAdd() {
        // Loop over until valid type received.
        Types type = null;
        while (type == null) {
            type = Prompts.getTypeFromUser(io);
        }

        // Select correct type of TipUI.
        TipUI tipUi = TipUI.selectTipUI(type);

        ReadingTip tip = tipUi.getTipFromUser(io);
        rtService.save(tip);
        io.print("Lukuvinkki lisätty!");
        return true;
    }
}
