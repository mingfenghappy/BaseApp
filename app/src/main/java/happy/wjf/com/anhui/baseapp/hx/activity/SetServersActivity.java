package happy.wjf.com.anhui.baseapp.hx.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.hyphenate.easeui.widget.EaseTitleBar;

import happy.wjf.com.anhui.baseapp.R;
import happy.wjf.com.anhui.baseapp.base.BaseActivity;
import happy.wjf.com.anhui.baseapp.hx.WJFModel;

public class SetServersActivity extends BaseActivity {

    EditText restEdit;
    EditText imEdit;
    EaseTitleBar titleBar;

    WJFModel wjfModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_servers);

        restEdit = (EditText) findViewById(R.id.et_rest);
        imEdit = (EditText) findViewById(R.id.et_im);
        titleBar = (EaseTitleBar) findViewById(R.id.title_bar);

        wjfModel = new WJFModel(this);
        if(wjfModel.getRestServer() != null)
            restEdit.setText(wjfModel.getRestServer());
        if(wjfModel.getIMServer() != null)
            imEdit.setText(wjfModel.getIMServer());
        titleBar.setLeftLayoutClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

    @Override
    protected void initView() {

    }

    @Override
    public void onBackPressed() {
        if(!TextUtils.isEmpty(restEdit.getText()))
            wjfModel.setRestServer(restEdit.getText().toString());
        if(!TextUtils.isEmpty(imEdit.getText()))
            wjfModel.setIMServer(imEdit.getText().toString());
        super.onBackPressed();
    }
}
