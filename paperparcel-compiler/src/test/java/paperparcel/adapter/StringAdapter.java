package paperparcel.adapter;

import android.os.Parcel;

public final class StringAdapter extends AbstractAdapter<String> {
  public static final StringAdapter INSTANCE = new StringAdapter();

  @Override public String read(Parcel source) {
    throw new RuntimeException("Stub!");
  }

  @Override protected void write(String value, Parcel dest, int flags) {
    throw new RuntimeException("Stub!");
  }

  private StringAdapter() {
    throw new RuntimeException("Stub!");
  }
}