package mtproto.send;
import support.ByteArrayPlus;
import mtproto.Serializer;
import mtproto.UnencryptedRequest;

public class SendUnencrypted {
  public Serializer message_data = new Serializer();

  public void send() {
    (new UnencryptedRequest(message_data.end())).send();
  }
}
