package com.example.application5;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class ServiceReceiver extends BroadcastReceiver {
    private final Activity parent;

    public static final String REQUEST_CODE_KEY = "pending_intent_key";
    public static final String COUNTER_ACTION = "counter_service_action";
    public static final String COUNTER_ANSWER_KEY = "pending_intent";

    public static final int COUNTER_START = 1;
    public static final int COUNTER_ANSWER = 2;
    public static final int COUNTER_FINISH = 3;

    ServiceReceiver(Activity parent) {
        this.parent = parent;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        int requestCode = intent.getIntExtra(REQUEST_CODE_KEY,  0);

        switch (requestCode) {
            case COUNTER_START:
                Toast.makeText(parent, context.getString(R.string.service_started), Toast.LENGTH_SHORT).show();
                break;
            case COUNTER_ANSWER:
                int value = intent.getIntExtra(COUNTER_ANSWER_KEY, 0);
                Toast.makeText(parent, context.getString(R.string.counted_to, value), Toast.LENGTH_SHORT).show();
                break;
            case COUNTER_FINISH:
                Toast.makeText(parent, context.getString(R.string.service_stopped), Toast.LENGTH_SHORT).show();
                break;
            default:
                return;
        }
    }
}
