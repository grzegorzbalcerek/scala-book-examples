import images._
(LoadImage fromDir "." fromFile "casabattlo.jpg"
 rotate 5
 crop 40 px fromTop
 crop 40 percent fromBottom
 crop 10 percent fromRight
 formatTo Format10x15 removing fromLeft or fromTop
 saveAs "casabattlo1.jpg")
