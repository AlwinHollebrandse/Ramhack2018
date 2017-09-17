package com.example.yaxar.rentsplit;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

    //make password in LoginActivity not say optional

    private String MasterPassword="12345", code="";
    private double numberOfRenters=3;//set = to number of users, so put users in an array and take that array size?
    private double amountPaid=0;//get from onClickPay result
    private double totalRentOwed=500;//have this change from the user input, initillay set to 0
    private double invdRentOwed=totalRentOwed/numberOfRenters-amountPaid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      /*  Bundle bundle = getIntent().getExtras();//might be an unneccasry line
        Intent intent=getIntent();
        String userName=intent.getStringExtra("user");
        Context context = getApplicationContext();
        CharSequence text = "Welcome"+userName+"!";
        int duration = Toast.LENGTH_SHORT;
        Toast.makeText(context, text, duration).show();*/
        TextView totalRent = (TextView)findViewById(R.id.rentTotal);
        totalRent.setText("Total Rent Owed: "+totalRentOwed);//needs to update each time a change is made, so include this at the end of each onClick method?
        TextView invdRent = (TextView)findViewById(R.id.rentTotal);
        invdRent.setText("Your owed contribution: "+invdRentOwed);

    }

    public void onClickPay(View view){
        //set up paypal, or google pay, or venmo//which one?
        //will need to download android mobile payments library SDK
        //https://www.youtube.com/watch?v=1MyBO9z7ojk
        //https://github.com/paypal/sdk-packages/blob/gh-pages/MPL/PayPal_MPL_1.5.6.58_Android-Developer-Package.zip
        //what would happen if someone over pays-oversight - wont show in demo
    }

    public void onClickLogout(View view){
        //have message appear: ("Logout successful");
        //if logout is to complicated, just exit the app.
        //need all double variables to save
     //   Intent logout=new intent(this, LoginActivity.class);
        //might add onResume(below) to loginActivity
        finish();//should close each activity, same enough thing as logging out
    }

    public void onClickChangeTotal(View view){
        //need to have a password pop up
        //then the option appears to change the textfield. {
   //     Intent password=new Intent(this, PasswordActivity.class);
  //      startActivityForResult(password, 1);        // }
        //need to send changes to each user//as a toast? but the change should be logged somewhere
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == 1)
            code = (String) data.getExtras().getString("password");
        if (code.equals(MasterPassword)) {
            TextView totalRent = (TextView) findViewById(R.id.rentTotal);
            View editTotalRent = findViewById(R.id.editTotalRent);
            editTotalRent.setVisibility(View.VISIBLE);
            EditText text = (EditText) findViewById(R.id.editTotalRent);//needs securtiy to only allow int input-oversight
            totalRentOwed = Double.parseDouble(text.toString());
            totalRent.setText("Total Rent Owed: " + totalRentOwed);//needs to update each time a change is made, so include this at the end of each onClick method?
            //add each user getting a toast(wouldnt keep a log...)
        }
    }

    /*public void onResume(){
        finish();
    }*/
}
