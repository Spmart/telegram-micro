package support;

import java.io.ByteArrayOutputStream;

public class ByteArrayPlus extends ByteArrayOutputStream {
  public void append_byte(byte to_write) {
    write(to_write);
  }

  public void append_long(long to_write) {
    append_bytes(Encode.long_encode(to_write));
  }

  public void append_int(int to_write) {
    append_bytes(Encode.int_encode(to_write));
  }

  public void append_biginteger(BigInteger to_write) {
    append_bytes(Encode.biginteger_encode(to_write));
  }

  public void append_bytes(byte[] to_write) {
    write(to_write, 0, to_write.length);
  }
}
