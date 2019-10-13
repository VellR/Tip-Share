package com.github.mikephil.charting.utils;

import android.content.res.AssetManager;
import android.os.Environment;
import android.util.Log;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    private static final String LOG = "MPChart-FileUtils";

    public static List<Entry> loadEntriesFromFile(String path) {
        File file = new File(Environment.getExternalStorageDirectory(), path);
        List<Entry> entries = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while (true) {
                String line = br.readLine();
                if (line == null) {
                    break;
                }
                String[] split = line.split("#");
                if (split.length <= 2) {
                    entries.add(new Entry(Float.parseFloat(split[0]), Integer.parseInt(split[1])));
                } else {
                    float[] vals = new float[(split.length - 1)];
                    for (int i = 0; i < vals.length; i++) {
                        vals[i] = Float.parseFloat(split[i]);
                    }
                    entries.add(new BarEntry(vals, Integer.parseInt(split[split.length - 1])));
                }
            }
        } catch (IOException e) {
            Log.e(LOG, e.toString());
        }
        return entries;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0074 A[SYNTHETIC, Splitter:B:21:0x0074] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0099 A[SYNTHETIC, Splitter:B:34:0x0099] */
    public static List<Entry> loadEntriesFromAssets(AssetManager am, String path) {
        List<Entry> entries = new ArrayList<>();
        BufferedReader reader = null;
        try {
            BufferedReader reader2 = new BufferedReader(new InputStreamReader(am.open(path), "UTF-8"));
            try {
                for (String line = reader2.readLine(); line != null; line = reader2.readLine()) {
                    String[] split = line.split("#");
                    if (split.length <= 2) {
                        entries.add(new Entry(Float.parseFloat(split[0]), Integer.parseInt(split[1])));
                    } else {
                        float[] vals = new float[(split.length - 1)];
                        for (int i = 0; i < vals.length; i++) {
                            vals[i] = Float.parseFloat(split[i]);
                        }
                        entries.add(new BarEntry(vals, Integer.parseInt(split[split.length - 1])));
                    }
                }
                if (reader2 != null) {
                    try {
                        reader2.close();
                        BufferedReader bufferedReader = reader2;
                    } catch (IOException e) {
                        Log.e(LOG, e.toString());
                        BufferedReader bufferedReader2 = reader2;
                    }
                }
            } catch (IOException e2) {
                e = e2;
                reader = reader2;
                try {
                    Log.e(LOG, e.toString());
                    if (reader != null) {
                    }
                    return entries;
                } catch (Throwable th) {
                    th = th;
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (IOException e3) {
                            Log.e(LOG, e3.toString());
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                reader = reader2;
                if (reader != null) {
                }
                throw th;
            }
        } catch (IOException e4) {
            e = e4;
            Log.e(LOG, e.toString());
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e5) {
                    Log.e(LOG, e5.toString());
                }
            }
            return entries;
        }
        return entries;
    }

    public static void saveToSdCard(List<Entry> entries, String path) {
        File saved = new File(Environment.getExternalStorageDirectory(), path);
        if (!saved.exists()) {
            try {
                saved.createNewFile();
            } catch (IOException e) {
                Log.e(LOG, e.toString());
            }
        }
        try {
            BufferedWriter buf = new BufferedWriter(new FileWriter(saved, true));
            for (Entry e2 : entries) {
                buf.append(e2.getVal() + "#" + e2.getXIndex());
                buf.newLine();
            }
            buf.close();
        } catch (IOException e3) {
            Log.e(LOG, e3.toString());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x005c A[SYNTHETIC, Splitter:B:19:0x005c] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x006e A[SYNTHETIC, Splitter:B:25:0x006e] */
    public static List<BarEntry> loadBarEntriesFromAssets(AssetManager am, String path) {
        List<BarEntry> entries = new ArrayList<>();
        BufferedReader reader = null;
        try {
            BufferedReader reader2 = new BufferedReader(new InputStreamReader(am.open(path), "UTF-8"));
            try {
                for (String line = reader2.readLine(); line != null; line = reader2.readLine()) {
                    String[] split = line.split("#");
                    entries.add(new BarEntry(Float.parseFloat(split[0]), Integer.parseInt(split[1])));
                }
                if (reader2 != null) {
                    try {
                        reader2.close();
                        BufferedReader bufferedReader = reader2;
                    } catch (IOException e) {
                        Log.e(LOG, e.toString());
                        BufferedReader bufferedReader2 = reader2;
                    }
                }
            } catch (IOException e2) {
                e = e2;
                reader = reader2;
                try {
                    Log.e(LOG, e.toString());
                    if (reader != null) {
                    }
                    return entries;
                } catch (Throwable th) {
                    th = th;
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (IOException e3) {
                            Log.e(LOG, e3.toString());
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                reader = reader2;
                if (reader != null) {
                }
                throw th;
            }
        } catch (IOException e4) {
            e = e4;
            Log.e(LOG, e.toString());
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e5) {
                    Log.e(LOG, e5.toString());
                }
            }
            return entries;
        }
        return entries;
    }
}
