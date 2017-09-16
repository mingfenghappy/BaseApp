package happy.wjf.com.anhui.baseapp.sqlitedb;

import com.google.gson.Gson;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/4/18.
 */
@DatabaseTable(tableName="UserApiModel")
public class UserApiModel implements Serializable {

    // 记得导入ormlite库
    @DatabaseField(generatedId=true)
    private int RecordId;

    @DatabaseField

    public long Id;

    @DatabaseField
    public String Username;

    @DatabaseField
    public String Email;

    @DatabaseField
    public String HeadImg;

    @DatabaseField
    public String EaseMobUserName;

    @DatabaseField
    public String EaseMobPassword;

    public UserApiModel(){
        Id = 0;
        Username = "";
        Email = "";
        HeadImg = "";
        EaseMobUserName = "";
        EaseMobPassword = "";
    }

    public static UserApiModel parse(String jsonString) {
        Gson gson = new Gson();
        UserApiModel obj = gson.fromJson(jsonString, UserApiModel.class);
        return obj;
    }

    public int getRecordId() {
        return RecordId;
    }

    public void setRecordId(int recordId) {
        RecordId = recordId;
    }


    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getHeadImg() {
        return HeadImg;
    }

    public void setHeadImg(String headImg) {
        HeadImg = headImg;
    }

    public String getEaseMobUserName() {
        return EaseMobUserName;
    }

    public void setEaseMobUserName(String easeMobUserName) {
        EaseMobUserName = easeMobUserName;
    }

    public String getEaseMobPassword() {
        return EaseMobPassword;
    }

    public void setEaseMobPassword(String easeMobPassword) {
        EaseMobPassword = easeMobPassword;
    }
}
