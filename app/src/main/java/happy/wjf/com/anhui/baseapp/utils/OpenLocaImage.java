package happy.wjf.com.anhui.baseapp.utils;

import android.content.Intent;
import android.os.Build;

/**
 * Created by CloudAnt on 2016/12/19.
 * 打开本地相册工具类
 */

public class OpenLocaImage {
    /**
     * 打开本地相册
     * @return intent
     */
    public static Intent openImage(){
        Intent intent;
        if (Build.VERSION.SDK_INT < 19) {
            intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("image/*");

        } else {
            intent = new Intent(
                    Intent.ACTION_PICK,
                    android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        }
        return intent;
    }
}
