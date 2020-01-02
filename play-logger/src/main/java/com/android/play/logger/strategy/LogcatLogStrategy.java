package com.android.play.logger.strategy;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.android.play.logger.LoggerUtil;


/**
 * LogCat implementation for {@link LogStrategy}
 * <p>
 * This simply prints out all logs to Logcat by using standard {@link Log} class.
 */
public class LogcatLogStrategy implements LogStrategy {

    static final String DEFAULT_TAG = "play-logger-tag";

    @Override
    public void log(int priority, @Nullable String tag, @NonNull String message) {
        LoggerUtil.checkNotNull(message);
        if (tag == null) {
            tag = DEFAULT_TAG;
        }
        Log.println(priority, tag, message);
    }
}
