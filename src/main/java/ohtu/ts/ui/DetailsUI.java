package ohtu.ts.ui;

import ohtu.ts.domain.ReadingTip;
import ohtu.ts.services.ReadingTipService;

public class DetailsUI {
    ReadingTip readingTip;

    /**
     * Initialize DetailsUI.
     * ReadingTip is loaded for content with the given id.
     * @param id id to search for a ReadingTip in the database.
     * @throws Exception Throws an exception if ReadingTip cannot be found.
     */
    public DetailsUI(int id) throws Exception {
        ReadingTipService service = new ReadingTipService();
        this.readingTip = service.find(id);

        if (this.readingTip == null) {
            throw new Exception("ReadingTip not found.");
        }
    }

    @Override
    public String toString() {
        // TODO: Add proper details.
        return "Found ReadingTip with id " + readingTip.getId();
    }
}
