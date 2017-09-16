package happy.wjf.com.anhui.baseapp.sqlitedb;

import android.text.TextPaint;
import android.text.style.URLSpan;

/**
 * Created by Administrator on 2015/1/20.
 */
public class URLSpanNoUnderline extends URLSpan {
    public URLSpanNoUnderline(String url) {
        super(url);
    }

    public void updateDrawState(TextPaint p_DrawState) {
        super.updateDrawState(p_DrawState);
        p_DrawState.setUnderlineText(false);
    }
}
