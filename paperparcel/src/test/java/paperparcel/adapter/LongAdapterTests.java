package paperparcel.adapter;

import paperparcel.utils.TestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static com.google.common.truth.Truth.assertThat;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE)
public class LongAdapterTests {
  @Test public void longsAreCorrectlyParcelled() {
    LongAdapter adapter = LongAdapter.INSTANCE;
    Long expected = Long.MAX_VALUE;
    Long result = TestUtils.writeThenRead(adapter, expected);
    assertThat(result).isEqualTo(expected);
  }
}