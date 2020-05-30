package mad.sliit.uniflexy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ComplaintTypes extends AppCompatActivity {
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint_types);

        intent i = new Intent(getApplicationContext(),AddComplaint.class);
        startActivity(i);   /*** Question 19  ***/

    }

    public void complaintLab(View view){
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("Labimage/*");

        startActivityForResult(intent, READ_REQUEST_CODE);
        /*** Question 20 - (ii) ***/

    }

    public void complaintTime(View view){
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("Time/*");

        startActivityForResult(intent, READ_REQUEST_CODE);
       /*** Question 20 - (iii) ***/
    }

    public void complaintOther(View view){
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("Other/*");

        startActivityForResult(intent, READ_REQUEST_CODE);
        /*** Question 20 - (iv) ***/

    }
}
