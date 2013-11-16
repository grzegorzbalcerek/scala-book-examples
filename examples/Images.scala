import language.implicitConversions
import javax.imageio.ImageIO
import java.awt.image.BufferedImage
import java.awt.Graphics2D
package images {
  object LoadImage {
    import java.io.File
    def fromDir(dir: String) = new LoadImage(dir)
    def fromFile(filePath: String) = ImageIO.read(new File(filePath))
  }
  class LoadImage(dir: String) {
    import java.io.File
    def fromFile(filePath: String) = ImageIO.read(new File(dir, filePath))
  }
  abstract sealed class Orientation
  abstract sealed class VOrientation extends Orientation
  abstract sealed class HOrientation extends Orientation
  case object fromTop    extends VOrientation
  case object fromBottom extends VOrientation
  case object fromLeft   extends HOrientation
  case object fromRight  extends HOrientation
  class CropParam(bi: BufferedImage, value: Double) {
    private def n = value.toInt
    private def h = (bi.getHeight*value/100).toInt
    private def w = (bi.getWidth*value/100).toInt
    def px(orientation: Orientation) = orientation match {
      case `fromTop`    => bi.getSubimage(0,n,bi.getWidth,bi.getHeight-n)
      case `fromBottom` => bi.getSubimage(0,0,bi.getWidth,bi.getHeight-n)
      case `fromLeft`   => bi.getSubimage(n,0,bi.getWidth-n,bi.getHeight)
      case `fromRight`  => bi.getSubimage(0,0,bi.getWidth-n,bi.getHeight)
    }
    def percent(orientation: Orientation) = orientation match {
      case `fromTop`    => bi.getSubimage(0,h,bi.getWidth,bi.getHeight-h)
      case `fromBottom` => bi.getSubimage(0,0,bi.getWidth,bi.getHeight-h)
      case `fromLeft`   => bi.getSubimage(w,0,bi.getWidth-w,bi.getHeight)
      case `fromRight`  => bi.getSubimage(0,0,bi.getWidth-w,bi.getHeight)
    }
  }
  case class Format(w: Int, h: Int) {
    def ratio:Double = w.toDouble/h.toDouble
  }
  object Format10x15 extends Format(10,15)
  object Format15x10 extends Format(15,10)
  object Format21x15 extends Format(21,15)
  object Format15x21 extends Format(15,21)
  class FormatBuilder(bi: BufferedImage, format: Format) {
    def removing(vo: VOrientation) = new {
      def or(ho: HOrientation) = doFormat(bi,format,ho,vo)
    }
    def removing(ho: HOrientation) = new {
      def or(vo: VOrientation) = doFormat(bi,format,ho,vo)
    }
    private def doFormat(bi: BufferedImage, format: Format,
        ho: HOrientation, vo: VOrientation): BufferedImage = {
      val newWidth = (bi.getHeight.toDouble*format.ratio).toInt
      val newHeight = (bi.getWidth.toDouble/format.ratio).toInt
      if (bi.getWidth > newWidth) ho match {
        case `fromLeft` =>
          bi.getSubimage(bi.getWidth-newWidth,0,newWidth,bi.getHeight)
        case `fromRight` => bi.getSubimage(0,0,newWidth,bi.getHeight)
      }
      else if (bi.getHeight > newHeight) vo match {
        case `fromTop` =>
          bi.getSubimage(0,bi.getHeight-newHeight,bi.getWidth,newHeight)
        case `fromBottom` => bi.getSubimage(0,0,bi.getWidth,newHeight)
      }
      else bi
    }
  }
}
package object images {
  implicit class ImageOps(bi: BufferedImage) {
    def saveAs(filePath: String) {
      import java.io.File
      ImageIO.write(bi, "jpg", new File(filePath))
    }
    def crop(n: Int) = new CropParam(bi, n)
    def rotate(degrees: Double): BufferedImage = {
      import java.awt._, image.AffineTransformOp,
        AffineTransformOp._, geom.AffineTransform._
      val newBi = new BufferedImage(bi.getWidth,
        bi.getHeight, bi.getType)
      val angle = degrees*math.Pi/180.0
      val transform = getRotateInstance(angle,
        bi.getWidth/2, bi.getHeight/2)
      new AffineTransformOp(transform, TYPE_BICUBIC).
        filter(bi, newBi)
      newBi
    }
    def formatTo(format: Format) = new FormatBuilder(bi, format)
    def draw(f: (Graphics2D, Int, Int) => Unit) = {
      val g = bi.createGraphics
      f(g, bi.getWidth, bi.getHeight)
      bi
    }
  }
}
