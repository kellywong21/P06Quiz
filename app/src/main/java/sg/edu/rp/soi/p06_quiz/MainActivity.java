package sg.edu.rp.soi.p06_quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etNum1;
    EditText etNum2;
    TextView tvOperation;
    TextView tvAns;
    Button btnReset;
    int ans = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNum1 = findViewById(R.id.etNum1);
        etNum2 = findViewById(R.id.etNum2);
        tvOperation = findViewById(R.id.tvOperation);
        tvAns = findViewById(R.id.tvAns);
        btnReset = findViewById(R.id.btnReset);

        registerForContextMenu(tvOperation);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etNum1.setText("");
                etNum2.setText("");
                tvAns.setText("");
            }
        });



    }

    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0, 0, 0, "+");
        menu.add(0, 1, 1, "-");

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getItemId()==0){
            int first = Integer.valueOf(etNum1.getText().toString().trim());
            int second = Integer.valueOf(etNum2.getText().toString().trim());
            ans = first + second;
            ;

        }else if(item.getItemId()==1){
            int first = Integer.valueOf(etNum1.getText().toString().trim());
            int second = Integer.valueOf(etNum2.getText().toString().trim());
            ans = first-second;

        }tvAns.setText(ans);
        return super.onContextItemSelected(item);


    }
}
