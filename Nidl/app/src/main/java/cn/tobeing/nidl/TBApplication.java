package cn.tobeing.nidl;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;

import java.util.List;

/**
 * Created by sunzheng on 15/11/25.
 */
public class TBApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
    }

    private String getCurrentProcessName() {
        int pid = android.os.Process.myPid();
        ActivityManager am = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> infos = am.getRunningAppProcesses();
        if (infos != null && infos.size() > 0) {
            for (ActivityManager.RunningAppProcessInfo appProcess : infos) {
                if (appProcess.pid == pid) {
                    return appProcess.processName;
                }
            }
        }
        return "";
    }
}
