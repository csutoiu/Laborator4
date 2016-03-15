package ro.pub.cs.systems.pdsd.lab04.contactsmanager;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity {

    View.OnClickListener myClickLIstener= new View.OnClickListener() {
        public void onClick(View v) {
        	switch (v.getId()) {

            case R.id.button1:
                View secondLayout = (View)findViewById(R.id.linearLayout2);
                
                if(secondLayout.getVisibility() == View.GONE) {
                	secondLayout.setVisibility(View.VISIBLE);
                	Button option = (Button)findViewById(R.id.button1);
                	option.setText("Hide Additional Fields");
                } else {
                	secondLayout.setVisibility(View.GONE);
                	Button option = (Button)findViewById(R.id.button1);
                	option.setText("Show Additional Fields");
                }
                break;

            case R.id.button2:
            	Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
            	intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
            	
            	EditText name = (EditText)findViewById(R.id.editText1);
            	EditText phone = (EditText)findViewById(R.id.editText2);
            	EditText email = (EditText)findViewById(R.id.editText3);
            	EditText address = (EditText)findViewById(R.id.editText4);
            	EditText jobTitle = (EditText)findViewById(R.id.editText5);
            	EditText company = (EditText)findViewById(R.id.editText6);
            	
            	if (name.getText() != null) {
            	  intent.putExtra(ContactsContract.Intents.Insert.NAME, name.getText().toString());
            	}

            	if (phone.getText() != null) {
              	  intent.putExtra(ContactsContract.Intents.Insert.PHONE, phone.getText().toString());
              	}
            	
            	if (email.getText() != null) {
            	  intent.putExtra(ContactsContract.Intents.Insert.EMAIL, email.getText().toString());
            	}
            	if (address.getText() != null) {
            	  intent.putExtra(ContactsContract.Intents.Insert.POSTAL, address.getText().toString());
            	}
            	if (jobTitle.getText() != null) {
            	  intent.putExtra(ContactsContract.Intents.Insert.JOB_TITLE, jobTitle.getText().toString());
            	}
            	if (company.getText() != null) {
            	  intent.putExtra(ContactsContract.Intents.Insert.COMPANY, company.getText().toString());
            	}
            	startActivity(intent);
                break;

            case R.id.button3:
            	finish();
                break;

            default:
                break;
            }

        }
    };
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button option = (Button)findViewById(R.id.button1);
        option.setOnClickListener(myClickLIstener);
        Button saveBtn = (Button)findViewById(R.id.button2);
        saveBtn.setOnClickListener(myClickLIstener);
        Button cancelBtn = (Button)findViewById(R.id.button3);
        cancelBtn.setOnClickListener(myClickLIstener);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
