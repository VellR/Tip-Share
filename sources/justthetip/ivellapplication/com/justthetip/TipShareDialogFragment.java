package justthetip.ivellapplication.com.justthetip;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog.Builder;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout.LayoutParams;

public class TipShareDialogFragment extends DialogFragment {
    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final EditText shareEditText = new EditText(getActivity());
        shareEditText.setInputType(2);
        shareEditText.setLayoutParams(new LayoutParams(-1, -1, 4.0f));
        Builder builder = new Builder(getActivity());
        builder.setView((View) shareEditText).setMessage((CharSequence) "Please enter your tip share").setPositiveButton((CharSequence) "Save", (OnClickListener) new OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                double doubleValue = Double.valueOf(String.valueOf(shareEditText.getText())).doubleValue();
            }
        }).setNegativeButton((CharSequence) "No tip share", (OnClickListener) new OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                TipShareDialogFragment.this.getDialog().cancel();
            }
        });
        return builder.create();
    }
}
