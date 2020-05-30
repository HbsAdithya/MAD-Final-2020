package mad.sliit.uniflexy.Database;

import android.content.ContentValues;
import android.content.Context;

/*** Question 1   ***/

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ComplaintDB extends SQLiteOpenHelper {

    private static final String TAG = "ComplaintDB";

    public static final String DATABSE_NAME="ComplaintsInfo.db";

    //Table
    protected static class Complaint implements BaseColumns{
        public static final String TABLE_NAME ="complaint";
        public static final String COLUMN_1 = "ComplaintId" ;
        public static final String COLUMN_2 = "Description";
        public static final String COLUMN_3 = "Type";
        public static final String COLUMN_4 = "Priority";
        public static final String COLUMN_5 = "Image";
        /*** Question 3  ***/
    }




    public ComplaintDB(@Nullable Context context) {
        super(context, DATABSE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.e(TAG, "onCreate: Table Created");
        String SQL_CREATE_ENTREES =

                "CREATE TABLE " + ComplaintDB.Complaint.TABLE_NAME + " (" +
                        ComplaintDB.Complaint._ID + " INTEGER PRIMARY KEY," +
                        ComplaintDB.Complaint.COLUMN_1 + " Description," +
                        ComplaintDB.Complaint.COLUMN_2 + " Type," +
                        ComplaintDB.Complaint.COLUMN_3 + " Priority," +
                        ComplaintDB.Complaint.COLUMN_4 + " Image) ";


                /*** Question 4  ***/


        db.execSQL(SQL_CREATE_ENTREES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addComplaint(Context context, String Type, String Description, String Priority, String Image   /*** Question 5  ***/ ){
        Log.e(TAG, "addComplaint: data inserted");
        //get database in write mode

        SQLiteDatabase db = getWritableDatabase();

        //Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put( ComplaintDB.Complaint.COLUMN_1, ComplaintDB.complaint());

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(ComplaintDB.Complaint.TABLE_NAME, null, values);

        if (newRowId >= 1 ){
            return true;
        }
        else {
            return false;
        }


        /*** Question 5  ***/


        Toast.makeText(context, "Data Inserted Successfully", Toast.LENGTH_SHORT).show();


    }

    public JSONArray viewComplaints() throws JSONException {

        SQLiteDatabase db = getWritableDatabase(); /*** Question 6  ***/
        JSONArray objs= new JSONArray();


        String[] projection = {
                // column names
        };

        String sortOrder = Complaint.TABLE_NAME + " DESC";
        String selectQuery = "SELECT * FROM +Complaint.TABLE_NAME"; /*** Question 7  ***/

        Cursor cursor = db.rawQuery(selectQuery,null);

        while (cursor.moveToNext()){
            // read all values in cursor

            JSONObject obj = new JSONObject();
            String Type = cursor.getString(cursor.getColumnIndexOrThrow(ComplaintDB.Complaint.COLUMN_1));
            String Desc = cursor.getString(cursor.getColumnIndexOrThrow(ComplaintDB.Complaint.COLUMN_2));
            String Prio = cursor.getString(cursor.getColumnIndexOrThrow(ComplaintDB.Complaint.COLUMN_3));
            String Image = cursor.getString(cursor.getColumnIndexOrThrow(ComplaintDB.Complaint.COLUMN_4));

            /*** Question 8  ***/


            objs.put(obj);



        }



        return objs;

    }
}
