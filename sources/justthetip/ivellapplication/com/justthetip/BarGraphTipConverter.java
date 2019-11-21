package justthetip.ivellapplication.com.justthetip;

import com.github.mikephil.charting.data.BarEntry;
import java.util.ArrayList;

public class BarGraphTipConverter {
    private ArrayList<BarEntry> entries = new ArrayList<>();

    public BarGraphTipConverter(ArrayList<String> tipsArr) {
        int inc = 0;
        int entryInc = 0;
        while (inc != tipsArr.size()) {
            int entryInc2 = entryInc + 1;
            this.entries.add(new BarEntry(Float.valueOf((String) tipsArr.get(inc)).floatValue(), entryInc));
            inc++;
            entryInc = entryInc2;
        }
    }

    public ArrayList<BarEntry> entries() {
        return this.entries;
    }
}
