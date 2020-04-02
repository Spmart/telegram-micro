package test;

import mtproto.PrimeDecomposer;

public class PrimeDecomposerContext {
  public static class DecomposeTest extends Test {
    public String label() {
      return "It can decompose a prime";
    }
    public void test() throws TestFailureException {
      //This takes waaaaay too long
      PrimeDecomposer.Coprimes result = PrimeDecomposer.decompose(0x211cafa9555101f5L);
      expect(result.lesser_prime(), 0x59e2945dL);
      expect(result.greater_prime(), 0x5e4e4a79L);
    }
  }

  public static class LimitedPolynomialTest extends Test {
    public String label() {
      return "It can provide the limited polynomial";
    }
    public void test() throws TestFailureException {
      long result = PrimeDecomposer.limited_polynomial(0x93a652c056cb728cL, 0x211cafa9555101f5L);
      expect(result, 0xd5428d6f285c04dL);
    }
  }

  public static class EuclidianGreatestCommonDenominatorTest extends Test {
    public String label() {
      return "It can calculate the greatest common denominator";
    }
    public void test() throws TestFailureException {
      long result = PrimeDecomposer.euclidian_greatest_common_denominator(0x82529d10230L,0xa3af68179d8L);
      expect(result, 0x47f5d8f8L);
    }
  }
}
