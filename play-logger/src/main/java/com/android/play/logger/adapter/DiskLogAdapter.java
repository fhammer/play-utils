package com.android.play.logger.adapter;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.android.play.logger.LoggerUtil;
import com.android.play.logger.strategy.CsvFormatStrategy;
import com.android.play.logger.strategy.FormatStrategy;


/**
 * This is used to saves log messages to the disk.
 * By default it uses {@link CsvFormatStrategy} to translates text message into CSV format.
 */
public class DiskLogAdapter implements LogAdapter {

  @NonNull
  private final FormatStrategy formatStrategy;

  public DiskLogAdapter() {
    formatStrategy = CsvFormatStrategy.newBuilder().build();
  }

  public DiskLogAdapter(@NonNull FormatStrategy formatStrategy) {
    this.formatStrategy = LoggerUtil.checkNotNull(formatStrategy);
  }

  @Override
  public boolean isLoggable(int priority, @Nullable String tag) {
    return true;
  }

  @Override
  public void log(int priority, @Nullable String tag, @NonNull String message) {
    formatStrategy.log(priority, tag, message);
  }
}
