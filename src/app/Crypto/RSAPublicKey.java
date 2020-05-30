package crypto;
import bouncycastle.BigInteger;
import support.ByteArrayPlus;
import support.Decode;
import mtproto.Serialize;

public class RSAPublicKey {
  public BigInteger exponent;
  public BigInteger modulus;
  public long signature;

  public RSAPublicKey(int exponent, byte[] modulus) {
    this.exponent = BigInteger.valueOf(exponent);
    this.modulus = new BigInteger(modulus);

    update_signature();
  }

  //https://github.com/tdlib/td/issues/250
  //https://github.com/tdlib/td/blob/4eed84132e1389f2c80c77f0b8d6ca0d81a278d5/td/mtproto/RSA.cpp#L77
  public void update_signature() {
    ByteArrayPlus to_hash = new ByteArrayPlus();
    to_hash.append_bytes(Serialize.serialize_bytes(modulus.toByteArray()));
    to_hash.append_bytes(Serialize.serialize_bytes(exponent.toByteArray()));
    byte[] to_hash_bytes = to_hash.toByteArray();
    SHA1 hash_engine = new SHA1();
    byte[] full_hash = hash_engine.digest(to_hash_bytes);
    signature = Decode.Little.long_decode(full_hash, SHA1.HASH_SIZE-8);
  }
}
