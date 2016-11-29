import io.muic.scandas.series.DoubleSeries
import org.scalatest.{FlatSpec, Matchers}

class DoubleSeriesTest extends FlatSpec with Matchers{
  val d0 = new DoubleSeries(Seq(0.192, 0.622, 0.438, 0.785, 0.78, 0.273, 0.276, 0.802, 0.958, 0.876, 0.358,
    0.501, 0.683, 0.713, 0.37, 0.561, 0.503, 0.014, 0.773, 0.883))
  val d1 = new DoubleSeries(Seq(0.365, 0.615, 0.075, 0.369, 0.933, 0.651, 0.397, 0.789, 0.317, 0.568, 0.869,
    0.436, 0.802, 0.144, 0.704, 0.705, 0.219, 0.925, 0.442, 0.909))

  "DoubleSeries" should "add two numbers together" in {
    (d0 + d1).toVector should be (Vector(0.5569999999999999, 1.237, 0.513, 1.154, 1.713, 0.924, 0.673, 1.5910000000000002, 1.275, 1.444, 1.2269999999999999,
      0.937, 1.485, 0.857, 1.0739999999999998, 1.266, 0.722, 0.9390000000000001, 1.215, 1.792))
    (d0 + 5).toVector should be (Vector(5.192, 5.622, 5.438, 5.785, 5.78, 5.273, 5.276, 5.802, 5.958, 5.876, 5.358, 5.501, 5.683, 5.713, 5.37, 5.561, 5.503, 5.014, 5.773, 5.883))
  }
  "DoubleSeries" should "subtract two numbers together" in {
    (d0 - d1).toVector should be (Vector(-0.173, 0.007000000000000006, 0.363, 0.41600000000000004, -0.15300000000000002, -0.378, -0.121, 0.013000000000000012, 0.641, 0.30800000000000005, -0.511, 0.065, -0.119, 0.569, -0.33399999999999996, -0.1439999999999999,
      0.28400000000000003, -0.911, 0.331, -0.026000000000000023))
    (d0 - 5).toVector should be (Vector(-4.808, -4.378, -4.562, -4.215, -4.22, -4.727, -4.724, -4.198, -4.042, -4.124, -4.642, -4.499, -4.317, -4.287, -4.63, -4.439, -4.497, -4.986, -4.227, -4.117))
  }
  "DoubleSeries" should "multiply two numbers together" in {
    (d0 * d1).toVector should be (Vector(0.07008, 0.38253, 0.03285, 0.289665, 0.72774, 0.17772300000000002, 0.10957200000000002, 0.6327780000000001, 0.303686, 0.49756799999999995, 0.311102, 0.218436, 0.5477660000000001, 0.10267199999999999,
      0.26048, 0.395505, 0.110157, 0.012950000000000001, 0.341666, 0.802647))
    (d0 * 5).toVector should be (Vector(0.96, 3.11, 2.19, 3.9250000000000003, 3.9000000000000004, 1.3650000000000002, 1.3800000000000001, 4.01, 4.79, 4.38, 1.79, 2.505, 3.415, 3.565, 1.85, 2.805, 2.515, 0.07, 3.865, 4.415))
  }
  "DoubleSeries" should "divide two numbers together" in {
    (d0 / d1).toVector should be (Vector(0.526027397260274, 1.0113821138211383, 5.84, 2.127371273712737, 0.8360128617363344, 0.41935483870967744, 0.6952141057934509, 1.0164765525982256, 3.0220820189274447, 1.5422535211267607, 0.41196777905638665, 1.1490825688073394, 0.8516209476309227, 4.951388888888889, 0.5255681818181819, 0.795744680851064, 2.2968036529680367,
      0.015135135135135135, 1.748868778280543, 0.9713971397139713))
    (d0 / 5).toVector should be (Vector(0.038400000000000004, 0.1244, 0.0876, 0.157, 0.156, 0.0546, 0.055200000000000006, 0.16040000000000001, 0.1916, 0.1752, 0.0716, 0.1002, 0.1366, 0.1426, 0.074, 0.11220000000000001, 0.1006, 0.0028, 0.15460000000000002, 0.1766))
  }
  "DoubleSeries" should "sum the series together" in {
    d0.sum() should be (11.361)
    d1.sum() should be (11.234)
  }
  "DoubleSeries" should "find the mode in the series" in {
    val spd0 = new DoubleSeries(Vector(1.1, 1.2, 1.1, 1.3, 1.4, 2.1, 5.5))
    spd0.mode() should be (1.1)
  }
  "DoubleSeries" should "find the mean in the series" in {
    d0.mean() should be (0.56805)
    d1.mean() should be (0.5617)
  }
  "DoubleSeries" should "find the min value in the series" in {
    d0.min() should be (0.014)
    d1.min() should be (0.075)
  }
  "DoubleSeries" should "find the index of the min value in the series" in {
    d0.argMin() should be (17)
    d1.argMin() should be (2)
  }
  "DoubleSeries" should "find the max value in the series" in {
    d0.max() should be (0.958)
    d1.max() should be (0.933)
  }
  "DoubleSeries" should "find the index of the max value in the series" in {
    d0.argMax() should be (8)
    d1.argMax() should be (4)
  }
  "DoubleSeries" should "filter nonzero objects" in {
    val spd0 = new DoubleSeries(Seq(1,1,0,0,2,2,2,0))
    spd0.nonzero().toVector should be (Vector(1,1,2,2,2))
  }





}
