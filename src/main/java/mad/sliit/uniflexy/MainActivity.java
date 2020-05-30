package mad.sliit.uniflexy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = (Spinner) findViewById(R.id.spinerUser);
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("Student");
        arrayList.add("Admin");


        /*** Question 10  ***/


// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                /*** Question 11   (i)  ***/
                R.array.planets_array
                ,

                /*** Question 11   (ii)  ***/
                , android.R.layout.simple_spinner_item
                );
// Specify the layout to use when the list of choices appears
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(ArrayAdapter /*** Question 11   (iii)  ***/);
/**************/
        //button events

        Button button = findViewById(R.id.btnLogin);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = spinner.getSelectedItem().toString();
                Intent i = new Intent(getApplicationContext(),AddComplaint.class);
                startActivity(i);
                /*** Question 15  ***/


            }
                else if(user == "Admin"){
                    textView = findViewById(R.id.txtPassword);
                    String  pwd /*** Question 16.1  ***/ = textView.getText().toString();


                    if(pwd.contains("1234")){
                        /*** Question 16.2  ***/
                        Intent i = new Intent(getApplicationContext(),ViewComplaints.class);
                        startActivity(i);
                    }else{

                        /*** Question 16.3  ***/
                        Context context = null;
                        Toast.makeText(context, "Incorrect  password", Toast.LENGTH_SHORT).show();
                        /*** Question 17  ***/
                        }
                }
            }
        });


    }
}
