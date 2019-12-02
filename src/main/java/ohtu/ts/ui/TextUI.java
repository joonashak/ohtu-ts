/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.ts.ui;

import java.util.List;
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

    public TextUI(IO io, ReadingTipService rtService) {
        this.io = io;
        this.rtService = rtService;
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
                    if (!commandList()) {
                        // something wrong
                    }
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
        TipUI tipUi = null;
        switch (type) {
            case BOOK:
                tipUi = new BookTipUI();
                break;
            case VIDEO:
                tipUi = new VideoTipUI();
                break;
            default:
                break;
        }

        ReadingTip tip = tipUi.getTipFromUser(io);
        rtService.save(tip);
        io.print("Lukuvinkki lisätty!");
        return true;
    }

    private boolean commandList() {
        List<ReadingTip> tips = rtService.listTips();
        if (tips.isEmpty()) {
            io.print("Lukuvinkkejä ei ole vielä lisätty.");
        }
        for (ReadingTip tip : tips) {
            io.print(tip.toString());
        }
        return true;
    }
}
