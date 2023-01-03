#生成二维码
import qrcode
img = qrcode.make("https://blog.csdn.net/qq_60308100?spm=1000.2115.3001.5343")
img.save("博客.png")